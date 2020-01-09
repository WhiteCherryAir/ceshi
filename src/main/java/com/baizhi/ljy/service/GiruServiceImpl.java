package com.baizhi.ljy.service;

import com.baizhi.ljy.dao.GuruDao;
import com.baizhi.ljy.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class GiruServiceImpl implements GuruService {
    @Autowired
    private GuruDao guruDao;

    @Override
    public List<Guru> queryAllGuru() {
        return guruDao.selectAll();
    }
}
