package com.miu.web.test.day106;

/**
 * @author keying
 * @date 2022-10-07 15:08:40
 */
public class USBbyVGA extends USBImpl implements VGA{

    @Override
    public void projection() {
        super.showPPT();
    }
}