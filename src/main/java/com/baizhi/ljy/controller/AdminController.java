package com.baizhi.ljy.controller;

import com.baizhi.ljy.entity.Admin;
import com.baizhi.ljy.service.AdminService;
import com.baizhi.ljy.util.CreateValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    //登录
    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, HttpSession session, String password, String clientCode) {
        Admin admin = adminService.queryAdminByName(username);
        String serverCode = session.getAttribute("ServerCode").toString();
        String s;
        if (clientCode.equals(serverCode)) {
            //验证码正确则验证用户是否存在,存在则判断用户是否为空
            if (admin == null) {
                s="用户不存在";
                return s;
            } else {
                //用户存在则验证密码
                if (admin.getPassword().equals(password)) {
                    //密码正确将用户信息存入session,进入后台管理主界面
                    session.setAttribute("admin", admin);
                    return null;
                } else {
                    s = "密码错误";
                    return s;
                }
            }
        } else {
            s = "验证码错误";
            return s;
        }
    }

    //验证码
    @RequestMapping("/verify")
    public void verify(HttpSession session, HttpServletResponse response) throws IOException {
        //使用验证码插件
        CreateValidateCode vcode = new CreateValidateCode();
        //获取随机验证码
        String code = vcode.getCode();
        //输出图片到client
        vcode.write(response.getOutputStream());
        //获取session
        session.setAttribute("ServerCode", code);
    }

    //退出登录
    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.invalidate();
        return "redirect:/jsp/login.jsp";
    }
}
