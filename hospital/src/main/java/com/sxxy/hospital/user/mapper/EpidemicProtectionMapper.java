package com.sxxy.hospital.user.mapper;


import com.sxxy.hospital.user.entity.EpidemicProtection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EpidemicProtectionMapper extends JpaRepository<EpidemicProtection,Object> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update epidemic_protection set date=:date,content=:content,image_url=:imageUrl where title=:title")
    int updateEpidemicProjection(@Param("title")String title,@Param("date")String date,@Param("content")String content,@Param("imageUrl")String imageUrl);
}
