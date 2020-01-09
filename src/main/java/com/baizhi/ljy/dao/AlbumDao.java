package com.baizhi.ljy.dao;

import com.baizhi.ljy.entity.Album;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * (Album)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-27 17:13:05
 */
public interface AlbumDao extends Mapper<Album>, DeleteByIdListMapper<Album,String> {

}