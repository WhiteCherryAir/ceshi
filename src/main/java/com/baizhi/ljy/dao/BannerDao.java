package com.baizhi.ljy.dao;

import com.baizhi.ljy.cache.MybatisCache;
import com.baizhi.ljy.entity.Banner;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@CacheNamespace(implementation = MybatisCache.class)
public interface BannerDao extends Mapper<Banner>, DeleteByIdListMapper<Banner, String> {
    //一级页面
    List<Banner> queryBannersByStatus(String status);
}