package com.sxxy.hospital.config;


import com.sxxy.hospital.personnel.entity.Dept;
import com.sxxy.hospital.personnel.entity.Doctor;
import com.sxxy.hospital.personnel.entity.Nurse;
import com.sxxy.hospital.personnel.entity.Other;
import com.sxxy.hospital.personnel.service.DeptService;
import com.sxxy.hospital.personnel.service.DoctorService;
import com.sxxy.hospital.personnel.service.NurseService;
import com.sxxy.hospital.personnel.service.OtherService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    DeptService deptService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    OtherService otherService;
    @Autowired
    NurseService nurseService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        String role = (String) request.getSession().getAttribute("role");

        List<String> permissionList=new ArrayList<>();
        info.addStringPermissions(permissionList);


        if (role.equals("财务部")){
            info.addRole("财务部");
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String name = (String) token.getPrincipal();
        String pwd = new String((char[]) token.getCredentials());
        String password = null;
        Dept dept = null;
        Doctor doctor = null;
        Other other = null;
        Nurse nurse =null;
        //判断查询的表
        String role = (String) request.getSession().getAttribute("role");
        if("财务部".equals(role)||"人事部".equals(role)){
           dept = deptService.deptLodin(name);
           if (null!=dept&&role.equals(dept.getDeptName())){
               password=dept.getDeptPassword();
           }else {
               throw new AuthenticationException();
           }
        }else if ("医生".equals(role)){
            doctor = doctorService.findByDoctorNum(name);
            if (null!=doctor){
                password = doctor.getDoctorPassword();
            }else {
                throw new AuthenticationException();
            }
        }else if ("后勤部".equals(role)){
            other = otherService.findByOtherNum(name);
            if (null!=other){
                password=other.getOtherPassword();
            }else {
                throw new AuthenticationException();
            }
        }else if ("护士".equals(role)){
            nurse = nurseService.findByNurseNum(name);
            if (null != nurse){
                password = nurse.getNursePassword();
            }else {
                throw new AuthenticationException();
            }
        }

        //判断查出来的值非空
        if (null!=password||"".equals(password)){
            if (pwd.equals(password)){
                return new SimpleAuthenticationInfo(name,pwd,getName());
            }else {
                throw new AuthenticationException();
            }
        }else {
                throw new AuthenticationException();
        }
    }
}
