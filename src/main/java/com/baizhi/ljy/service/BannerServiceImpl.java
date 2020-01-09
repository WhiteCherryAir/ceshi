package com.baizhi.ljy.service;

import com.baizhi.ljy.dao.BannerDao;
import com.baizhi.ljy.entity.Banner;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * (Banner)表服务实现类
 *
 * @author makejava
 * @since 2019-12-26 11:36:53
 */
@Service("bannerService")
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;


    //分页
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Map queryAllByLimit(Integer page, Integer rows) {
        //jqgrid rows数据 page当前页 records总条数 total总页数
        Map map = new HashMap();
        //不传入任何条件查所有
        int records = bannerDao.selectCount(null);
        //三元运算符，求总页数
        Integer total = records % rows == 0 ? records / rows : records / rows + 1;
        List<Banner> bannerList = bannerDao.selectByRowBounds(null, new RowBounds((page - 1) * rows, rows));
        map.put("rows", bannerList);
        map.put("page", page);
        map.put("records", records);
        map.put("total", total);
        return map;
    }



}