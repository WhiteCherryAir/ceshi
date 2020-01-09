package com.baizhi.ljy.service;

import java.util.Map;


/**
 * (Banner)表服务接口
 *
 * @author makejava
 * @since 2019-12-26 11:36:53
 */
public interface BannerService {



    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    Map queryAllByLimit(Integer curPage, Integer pageSize);



}