package com.miu.web.test;

import com.miu.service.impl.ServletTestImlp;

public class TestDongTai {
    public static void main(String[] args) {
        DongTai dongTai = new DongTai();
        ServletTestImlp ServletTestImlp=(ServletTestImlp) dongTai.newProxyInstance(new ServletTestImlp());
        //UserManager userManager=new UserManagerImpl();
        ServletTestImlp.getUserAll();
    }
}
