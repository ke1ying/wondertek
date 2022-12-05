package com.miu.web.test.day1012.guan;

/**
 * @author keying
 * @date 2022-10-12 14:29:13
 */
public class GuanMain1012 {
    public static void main(String[] args) {
        WechatServer wechatServer = new WechatServer();
        Observer userZhang = new User("zhangsan");
        Observer userLi = new User("lisi");
        wechatServer.registerObserver(userZhang);
        wechatServer.registerObserver(userLi);
        wechatServer.setMsg("msg  one  one");

        wechatServer.removeObserver(userLi);
        wechatServer.setMsg("msg update ");
    }
}