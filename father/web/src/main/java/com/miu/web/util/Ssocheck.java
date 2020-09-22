package com.miu.web.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Ssocheck {

    private static String SSOname = "123";
    private static String SSOpassword = "333";

    private static String SSOCookie = "ssoname";
    private static String CookieValues = "sso";

    public static boolean checkLogin(String name, String password) {
        if (name.equals(SSOname) && password.equals(SSOpassword)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                String SOOName = cookie.getName();
                String value = cookie.getValue();
                if(SSOCookie.equals(SOOName) && value.equals(CookieValues)){
                    return true;
                }
            }
        }
        return false;
    }
}
