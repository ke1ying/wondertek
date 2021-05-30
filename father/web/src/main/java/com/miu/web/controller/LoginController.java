package com.miu.web.controller;

import com.miu.entity.User;
import com.miu.web.util.Ssocheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    /*
    * 账号密码登入
    * */
    @RequestMapping("/loginOne")
    public ModelAndView login(HttpServletRequest request) {
       /* User user = new User("zhangsan",1);
        request.getSession().setAttribute("name",user);
        System.out.println("登入");*/
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    /*
    * 成功进入登入页面1
    * */
    @RequestMapping("/indexOne")
    public ModelAndView indexOne() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("indexOne");
        return mv;
    }

    /*
     * 成功进入登入页面2
     * */
    @RequestMapping("/indexTwoGo")
    public ModelAndView indexTwoGo() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("indexTwo");
        return mv;
    }

    @RequestMapping("/indexOneOne")
    @ResponseBody
    public Map<String,Object> index(String name, String password, String gotoUrl, HttpServletResponse response) {
        boolean ok = Ssocheck.checkLogin(name, password);
        Map<String,Object> map = new HashMap<>();
        map.put("gotoUrl",gotoUrl);
        if (ok) {
            Cookie cookie = new Cookie("ssoname","sso");
            cookie.setPath("/");
            response.addCookie(cookie);
            map.put("flag",true);
            return map;
        }
        map.put("flag",false);
        return map;
    }

    /*
    * index1
    * */
    @RequestMapping("/index1")
    public String index1(HttpServletRequest request) {
        boolean ok = Ssocheck.checkCookies(request);
        if(ok){
            return "indexOne";
        }
        request.getSession().setAttribute("gotoUrl","indexOne");
       return "login";
    }

    /*
     * index2
     * */
    @RequestMapping("/index2")
    public String index2(HttpServletRequest request) {
        boolean ok = Ssocheck.checkCookies(request);
        if(ok){
            return "indexTwoGo";
        }
        request.getSession().setAttribute("gotoUrl","indexTwo");
        return "login";
    }
}
