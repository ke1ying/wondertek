package com.miu.web.controller;

import com.miu.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public void login(HttpServletRequest request){
        User user = new User("zhangsan",1);
        request.getSession().setAttribute("name",user);
        System.out.println("登入");

    }
}
