package com.miu.web.controller.callback.function3;

/**
 * @author keying
 * @date 2022-12-05 22:29:19
 */
public class ClickButton {

    private ButtonListener buttonListener;

    public void setButtonListener(ButtonListener buttonListener){
        this.buttonListener = buttonListener;
    }

    public void click(){
        if(buttonListener!=null){
            buttonListener.listener();
        }
        System.out.println("点击成功");
    }

}