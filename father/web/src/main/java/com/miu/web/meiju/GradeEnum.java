package com.miu.web.meiju;

public enum GradeEnum{
    PRIMARY(1, "小学"),
    SECONDORY(2, "初中"),
    HIGH(3, "高中");

    private Integer i;
    private String school;

    GradeEnum(int i, String school) {
        this.i = i;
        this.school = school;
    }

    public Integer getI() {
        return i;
    }

    public String getSchool() {
        return school;
    }

}
