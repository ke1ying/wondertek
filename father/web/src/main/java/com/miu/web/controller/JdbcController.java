package com.miu.web.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcController {

    private static String userName = "root";

    private static String password = "ROOT";

    private static String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";

    public static void getCon() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Scanner in=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String uname=in.nextLine();
        System.out.println("请输入密码：");
        String upwd=in.nextLine();
        Connection connection = null;
        connection = DriverManager.getConnection(url,userName,password);
        String sql = "select * from ky_user where name = '" + uname + "' and password = '" +upwd +"'";
//        PreparedStatement st = connection.prepareStatement(sql);
        Statement st = connection.createStatement();
//        st.setString(1,"孙风1 or 1=1");
        ResultSet resultSet = st.executeQuery(sql);
        while (resultSet.next()){
            String sName = resultSet.getString("name");
            System.out.println(sName);
        }
        st.close();
        resultSet.close();
        connection.close();
    }

    public static void main(String[] args) throws Exception {
        JdbcController.getCon();
    }

}
