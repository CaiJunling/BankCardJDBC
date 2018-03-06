package com.oracle.jdbc.t3;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class ConnectionPool {
	
	public static void main(String[] args) {
	try {
		Properties  p=new Properties();
		p.load(new FileInputStream("datasource.properties"));
		DataSource  source=BasicDataSourceFactory.createDataSource(p);
		
		
		
		Connection  c=source.getConnection();
		
		Statement  s=c.createStatement();
		ResultSet  rs=s.executeQuery("select * from  stu");
		
		while(rs.next())
		{
			System.out.println(rs.getString("stuname")+"\t"+rs.getInt("stuage"));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
