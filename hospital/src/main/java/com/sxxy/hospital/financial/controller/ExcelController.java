package com.sxxy.hospital.financial.controller;

import com.sxxy.hospital.financial.entity.ExcelData;
import com.sxxy.hospital.financial.service.FinancialService;
import com.sxxy.hospital.utils.ExcelUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    FinancialService financialService;
    @RequiresRoles(value={"admin","financial"},logical = Logical.OR)
    @RequestMapping("/out")
    public void outExcel(String excelName, String tag,HttpServletResponse response){
        int rowIndex = 0;
        //分割页面传过来的id数组
        String[] strs = tag.split(",");

        List<Map> list = new ArrayList<>();
        //查询页面传过来的数据
        for (int i = 0; i < strs.length; i++) {
            list.add(financialService.findById(Integer.parseInt(strs[i])));
        }
        ExcelData data = new ExcelData();
        data.setName("财务表");
        //设置Excel的字段名
        List<String> titles = new ArrayList();
        titles.add("编号");
        titles.add("姓名");
        titles.add("部门");
        titles.add("类别");
        titles.add("详情");
        titles.add("时间");
        titles.add("金额");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Map map = list.get(i);
            List<Object> row = new ArrayList<>();
            row.add(map.get("statements_num"));
            row.add(map.get("statements_name"));
            row.add(map.get("statements_dept_name"));
            row.add(map.get("statements_type"));
            row.add(map.get("statements_event"));
            row.add(map.get("statements_time"));
            row.add(map.get("statements_money"));
            rows.add(row);
        }
        data.setRows(rows);
        try{
            ExcelUtils.exportExcel(response,excelName,data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
