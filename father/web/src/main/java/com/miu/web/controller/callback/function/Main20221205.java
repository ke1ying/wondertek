package com.miu.web.controller.callback.function;


/**
 * @author keying
 * @date 2022-12-05 19:55:02
 */
public class Main20221205 {
    public static void main(String[] args) {
        Employee221205 employeeA221205 = new EmployeeA221205();
        Boss221205 boss221205 = new Boss221205(employeeA221205);
        boss221205.question();
    }
}