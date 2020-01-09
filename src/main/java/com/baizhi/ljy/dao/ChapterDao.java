package com.baizhi.ljy.dao;

import com.baizhi.ljy.entity.Chapter;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * (Chapter)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-28 16:24:08
 */
public interface ChapterDao  extends Mapper<Chapter>, DeleteByIdListMapper<Chapter,String> {

}