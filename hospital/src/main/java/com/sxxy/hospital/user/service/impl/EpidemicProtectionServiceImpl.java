package com.sxxy.hospital.user.service.impl;

import com.sxxy.hospital.user.mapper.EpidemicProtectionMapper;
import com.sxxy.hospital.user.service.EpidemicProtectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpidemicProtectionServiceImpl implements EpidemicProtectionService {

    @Autowired
    EpidemicProtectionMapper epidemicProtectionMapper;
    //修改疫情推荐
    @Override
    public int updateEpidemicProjection(String title, String date, String content,String imageUrl) {
        return epidemicProtectionMapper.updateEpidemicProjection(title,date,content,imageUrl);
    }
}
