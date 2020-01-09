package com.baizhi.ljy.dao;

import com.baizhi.ljy.entity.Banner;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BannerDao extends Mapper<Banner>, DeleteByIdListMapper<Banner, String> {
    //一级页面
    List<Banner> queryBannersByStatus(String status);
}