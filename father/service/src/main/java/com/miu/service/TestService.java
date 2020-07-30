package com.miu.service;

import java.util.List;

public abstract class TestService<T> {

    public void exportExcel() {
        List<T> data = getData();
        setData(data);
        downloadExcel();
    }

    protected void setData(List<T> data){
        //设置data
        System.out.println("设置data");
    };

    protected void downloadExcel(){
        //下载excel
        System.out.println("下载excel");
    };

    protected abstract List<T> getData();
}
