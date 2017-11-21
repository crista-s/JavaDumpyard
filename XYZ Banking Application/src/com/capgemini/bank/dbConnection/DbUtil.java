package com.capgemini.bank.dbConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbUtil {
	
	public static Connection getConnection()
	{
		Connection conn=null;
		try{
			Properties prop=new Properties();
			
			InputStream is=DbUtil.class.getClassLoader().getResourceAsStream("database.properties");
		prop.load(is);
		
		Class.forName(prop.getProperty("driver"));
		conn=DriverManager.getConnection(prop.getProperty("connUrl"),prop.getProperty("userName"),prop.getProperty("password"));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
}
}