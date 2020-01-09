package com.baizhi.ljy.service;

import com.baizhi.ljy.entity.Chapter;

import java.util.Map;

/**
 * (Chapter)表服务接口
 *
 * @author makejava
 * @since 2019-12-28 16:24:08
 */
public interface ChapterService {


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    Map ByPageChapter(String albumId, Integer page, Integer rows);

    /**
     * 新增数据
     *
     * @param chapter 实例对象
     * @return 实例对象
     */
    Map insert(Chapter chapter,String albumId);

    /**
     * 修改数据
     *
     * @param chapter 实例对象
     * @return 实例对象
     */
    Map update(Chapter chapter);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Map deleteById(String[] id);



}