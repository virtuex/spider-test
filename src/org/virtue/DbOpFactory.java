package org.virtue;

import org.virtue.pojo.Product;

import java.sql.*;

public class DbOpFactory {
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/spider-data";
    public static DbOpFactory getInstance(){
        return new DbOpFactory();
    }

    private DbOpFactory(){

    }
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "xda265856";
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public void init() {
        // 注册 JDBC 驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Product product){
        try{
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = String.format("insert into spiderdata(productNo,productName,productType,manager,recordDate,endDate,toIndustry,wealthOpTyle,trustFunction) values('%s','%s','%s','%s','%s','%s','%s','%s','%s')"
                    ,product.getProductNo(),product.getProductName(),product.getProductType(),
                    product.getManager(),product.getRecordDate(),product.getEndDate(),product.getToIndustry(),
                    product.getWealthOpTyle(),product.getTrustFunction());
            stmt.executeUpdate(sql);
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }

    public void close(){
        // 完成后关闭
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
