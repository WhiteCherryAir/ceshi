package com.baizhi.ljy.controller;

import com.baizhi.ljy.entity.Guru;
import com.baizhi.ljy.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("guru")
public class GuruController {
    @Autowired
    private GuruService guruService;
    @RequestMapping("showAllGuru")
    public List<Guru> showAllGuru(){
        return guruService.queryAllGuru();
    }

}
