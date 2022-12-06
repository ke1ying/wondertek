package com.miu.web.controller.callback.function3;

/**
 * @author keying
 * @date 2022-12-05 22:29:50
 */
public class ButtonMain1205 {
    public static void main(String[] args) {
        ClickButton clickButton = new ClickButton();
        clickButton.setButtonListener(new ButtonListener() {
            @Override
            public void listener() {
                System.out.println("触发点击动作");
            }
        });

        clickButton.click();
    }
}