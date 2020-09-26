package com.sxxy.hospital.user.controller;

import com.sxxy.hospital.user.entity.EpidemicProtection;
import com.sxxy.hospital.user.mapper.EpidemicProtectionMapper;
import com.sxxy.hospital.user.service.EpidemicProtectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    EpidemicProtectionMapper epidemicProtectionMapper;
    @Autowired
    EpidemicProtectionService epidemicProtectionService;
    /**上传地址*/
    @Value("${file.upload.path}")
    private String filePath;

    //跳转到用户界面
    @RequestMapping("/index")
    public String goIndex(Model model){
        List<EpidemicProtection> epidemicProtections = epidemicProtectionMapper.findAll();
        model.addAttribute("a1",epidemicProtections.get(0));
        model.addAttribute("a2",epidemicProtections.get(1));
        model.addAttribute("a3",epidemicProtections.get(2));
        return "user/index";
    }



    //跳转世界疫情
    @RequestMapping("/index2")
    public String goWorldEpidemic(Model model){
        List<EpidemicProtection> epidemicProtections = epidemicProtectionMapper.findAll();
        model.addAttribute("a1",epidemicProtections.get(0));
        model.addAttribute("a2",epidemicProtections.get(1));
        model.addAttribute("a3",epidemicProtections.get(2));
        return "user/index2";
    }

    //修改疫情推荐
    @RequestMapping("/doChange")
    public String doChange(String title, String date, String content,MultipartFile file,Model model){
        // 获取上传文件名
        String filename = file.getOriginalFilename();
        // 定义上传文件保存路径
        String path = filePath;
        // 新建文件
        File filepath = new File(path, filename);
        // 判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        try {
            // 写入文件
            file.transferTo(new File(path + File.separator + filename));
            String imageUrl = "/images/"+filename;
            epidemicProtectionService.updateEpidemicProjection(title,date,content,imageUrl);
            return "personnel/success";
        } catch (IOException e) {
            e.printStackTrace();
            return "personnel/error";
        }
    }





    //跳到疫情推荐修改
    @RequestMapping("/goChange")
    public String goChange(String title,String date,String content){
        return "personnel/change";
    }
}
