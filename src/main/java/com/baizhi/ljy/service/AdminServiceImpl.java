package com.baizhi.ljy.service;

import com.baizhi.ljy.dao.AdminDao;
import com.baizhi.ljy.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
   private AdminDao adminDao;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin queryAdminByName(String name) {
        Admin admin = adminDao.selectOne(new Admin("1", name, "admin"));
        return admin;
    }
}
