package com.myorg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DButil {

    private static String driver = "com.mysql.jdbc.Driver";// MySql驱动
    private static String url = "jdbc:mysql://localhost:3306/webserver?" +
            "useUnicode=true&characterEncoding=UTF-8" +
            "&zeroDateTimeBehavior=convertToNull" +
            "&serverTimezone=UTC" +
            "&useSSL=false";// 写成本机地址，不能写成localhost，同时手机和电脑连接的网络必须是同一个
    private static String user = "root";// 用户名
    private static String password = "Seraphwinds00";// 密码
    private static DButil instance;

    private DButil() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {

        Connection connection = null;
        try {
            // 尝试建立到给定数据库URL的连接
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static DButil getInstance() {
        if (instance == null) {
            instance = new DButil();
        }
        return instance;
    }

    public void releaseConn(ResultSet rs, PreparedStatement pstmt, Connection connection) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    public void releaseConn(PreparedStatement pstmt, Connection connection) {

        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    public static void releaseConn(Connection connection) {

        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }


}
