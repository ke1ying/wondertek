package com.miu.web.suanfa;

import java.util.List;

public class XcxMessageVo {
    private List<DataList> dataList;

    public List<DataList> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataList> dataList) {
        this.dataList = dataList;
    }
}

class DataList{
    private String displayTitle;
    private String displayTitle1;
    private String title;

    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
    }

    public String getDisplayTitle1() {
        return displayTitle1;
    }

    public void setDisplayTitle1(String displayTitle1) {
        this.displayTitle1 = displayTitle1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
