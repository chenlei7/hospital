package com.sxxy.hospital.personnel.controller;


import com.sxxy.hospital.personnel.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deptLogin")
public class DeptLogin {
    //注入接口
    @Autowired
    DeptService deptService;

    //部门登录
    @RequestMapping("/login")
    public String deptLogin(String deptNum, String deptPassword){
        if(deptService.deptLodin(deptNum,deptPassword)!=null) {
            return "personnel/dept/deptIndex";
        }else {
            return "personnel/login";
        }
    }

}
