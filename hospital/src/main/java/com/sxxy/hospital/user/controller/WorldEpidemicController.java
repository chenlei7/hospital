package com.sxxy.hospital.user.controller;

import com.sxxy.hospital.user.entity.WorldEpidemic;
import com.sxxy.hospital.user.mapper.WorldEpidemicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/world")
public class WorldEpidemicController {
    @Autowired
    WorldEpidemicMapper worldEpidemicMapper;

    @RequestMapping("/list")
    @ResponseBody
    public List<WorldEpidemic> retu(){
        List<WorldEpidemic> es = worldEpidemicMapper.findAll();
        return es;
    }
}
