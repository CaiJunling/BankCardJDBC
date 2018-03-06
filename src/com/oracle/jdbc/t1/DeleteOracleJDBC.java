package com.oracle.jdbc.t1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteOracleJDBC {

	public static void main(String[] args) {
		
		 //1.装在驱动("jdbc 2.0可以省略)
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//加载驱动(可省略)
			//2.建立连接
			Connection con=null;
			Statement sta=null;
			ResultSet rs=null;
			try {
				  con = DriverManager.getConnection("jdbc:oracle:thin:@172.19.22.111:1521:XE","store","ok");
				//使用驱动管理器来建立对应数据库的连接（instace Name）
				
				//3.创建会话
				  sta=con.createStatement();//在链接的基础上创建了会话
				
				//4.使用会话执行SQL语句
				 int count= sta.executeUpdate("update   stu set stuage=22  where  stuid=569664199");
//				  rs=  sta.executeQuery("select stuage,stusex  from  stu");//(使用会话的方法发送一条查询语句到数据库并将返回的结果存储到一个ResutSet对象里面)
				
				 System.out.println(count);
				//5.解析结果集，将数据提取并显式出来
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(rs!=null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(sta!=null) {
					try {
						sta.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
	}

}
