package com.oracle.jdbc.t1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestOracleJDBC {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//加载驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//oracle数据库驱动类的完全限定类名
		String url = "jdbc:oracle:thin:@localhost:1521:XE";//orcl为数据库实例名
		try {
			Connection conn = DriverManager.getConnection(url, "store ", " 2342 ");
			
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}//url,数据库用户名及密码
	}

}
