package com.sxxy.hospital.user.controller;


import com.sxxy.hospital.user.entity.ChineseEpidemic;
import com.sxxy.hospital.user.mapper.ChineseEpidemicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/chinese")
public class ChineseEpidemicController {
    @Autowired
    ChineseEpidemicMapper chineseEpidemicMapper;
    @RequestMapping("/show")
    public String show(){
        return "user/chineseEpidemic";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<ChineseEpidemic> retu(){
        List<ChineseEpidemic> es = chineseEpidemicMapper.findAll();
        return es;
    }
}
