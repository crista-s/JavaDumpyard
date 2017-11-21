package com.capgemini.tcc.DBUtil;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;



public class DbUtil {
	private static Connection conn=null;
	private DbUtil(){
		
	}
	
	
	public static Connection getConnection(){
		try{
			Properties prop = new Properties();
			InputStream is = DbUtil.class.getClassLoader().getResourceAsStream("dbms.properties");
			prop.load(is);
		
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
			
			if(conn==null){
				return conn;
			}else{
				return conn;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			return conn;
		}
		
		
	}
}
	
