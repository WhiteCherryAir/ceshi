package com.baizhi.ljy;

import com.alibaba.excel.EasyExcel;
import com.baizhi.ljy.dao.AdminDao;
import com.baizhi.ljy.dao.BannerDao;
import com.baizhi.ljy.entity.Admin;
import com.baizhi.ljy.entity.Banner;
import com.baizhi.ljy.entity.BannerListener;
import io.goeasy.GoEasy;
import org.apache.poi.hssf.usermodel.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = CmfzApplication.class)
@RunWith(SpringRunner.class)

public class CmfzApplicationTests {
    @Autowired
    AdminDao adminDao;
    Admin admin;
    @Autowired
    private BannerDao bannerDao;

    @Test
    public void contextLoads() {
        List<Admin> admins = adminDao.selectAll();
        System.out.println(admins);
    }

    @Test
    public void testSelectOne() {
        Admin admin = adminDao.selectOne(this.admin);
        System.out.println(admin);
    }

    @Test
    public void testPoiOne() {
        List<Banner> bannerList = bannerDao.selectAll();
        //创建文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作薄
        HSSFSheet sheet = workbook.createSheet();
        //创建一行
        HSSFRow row = sheet.createRow(0);

        String[] str = {"ID", "标题", "图片", "超链接", "创建时间", "描述", "状态"};
        //创建单元格
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            //设置单元格内容
            row.createCell(i).setCellValue(s);
        }
        //通过workbook对象获取样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        //数据格式化处理
        HSSFDataFormat dataFormat = workbook.createDataFormat();
        //设置时间格式
        short format = dataFormat.getFormat("yyyy-MM-dd");
        cellStyle.setDataFormat(format);
        for (int i = 0; i < bannerList.size(); i++) {
            Banner banner = bannerList.get(i);
            HSSFRow row1 = sheet.createRow(i + 1);
            row1.createCell(0).setCellValue(banner.getId());
            row1.createCell(1).setCellValue(banner.getTitle());
            row1.createCell(2).setCellValue(banner.getUrl());
            row1.createCell(3).setCellValue(banner.getHref());
            HSSFCell cell = row1.createCell(4);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(banner.getCreate_date());

            row1.createCell(5).setCellValue(banner.getDescription());
            row1.createCell(6).setCellValue(banner.getStatus());
        }
        try {
            workbook.write(new File("G:\\三阶段\\后期项目\\day7-poiEasyExcel(2)\\示例\\" + new Date().getTime() + ".xls"));
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //导入
    @Test
    public void testPoiInput() {
        //创建excel文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作薄
        HSSFSheet sheet = workbook.createSheet();
        //创建一行
        HSSFRow row = sheet.createRow(0);
        //创建一个单元格
        HSSFCell cell = row.createCell(0);
        //给单元格设置内容
        cell.setCellValue("zzzzzzz");
        //将excel文档做本地输出
        try {
            workbook.write(new FileOutputStream("G:\\三阶段\\后期项目\\day7-poiEasyExcel(2)\\示例" + new Date().getTime() + ".xls"));
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void outPutBannerExcel() {
        String filename = "G:\\三阶段\\后期项目\\day7-poiEasyExcel(2)\\示例\\" + new Date().getTime() + ".xls";
        List<Banner> bannerList = bannerDao.selectAll();
        EasyExcel.write(filename, Banner.class).sheet("轮播图信息").doWrite(bannerList);
    }

    @Test
    public void inPutBannerExcel() {
        String url="G:\\三阶段\\后期项目\\day7-poiEasyExcel(2)\\示例\\1577962580475.xls";
        EasyExcel.read(url,Banner.class,new BannerListener(bannerDao)).sheet().doRead();
    }

    @Test
    public void testGoeasy(){
        GoEasy goEasy = new GoEasy( "http://rest-hangzhou.goeasy.io", "BC-1853cc09b905435db55c370114483489");
        goEasy.publish("cmfz", "Hello, GoEasy!");
    }
}
