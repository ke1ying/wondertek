package com.miu.web.test.day1011;

/**
 * @author keying
 * @date 2022-10-11 15:20:53
 */
public class XiaoMi extends Phone{
    private Software software;

    public void setSoftware(Software software){
        this.software = software;
    }
    @Override
    public void run() {
        software.run();
    }
}