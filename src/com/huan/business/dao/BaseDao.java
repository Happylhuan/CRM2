package com.huan.business.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {

	public static Connection conn=null;
	public static String SQL_PAGE_STAR="select * from (select rownum num, t.* from (";
	public static String SQL_PAGE_END=") t where rownum<=?) where num>?";
	
	public static Connection getConnection() {
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			String name = "hr";
			String pass = "hr";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521/XE";
			String driverClass = "oracle.jdbc.OracleDriver";
			
			try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, name, pass);
			return conn;
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
	}
	public static int getTotalPage(int totalNum,int pageSize) {
		float pageNum = totalNum/pageSize;
		float pageNum2 = totalNum%pageSize;
		int pageNumInt = 0;
		if(pageNum==0){
			pageNumInt=1;
		}
		if(pageNum2!=0){
			pageNumInt = (int)(pageNum+1);
		}else{
			pageNumInt = (int)pageNum;
		}
		
		return pageNumInt;
		
	}
	public static int getTotalNum(String sql) {
		conn =getConnection();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			stmt = conn.prepareStatement(sql);
			rset= stmt.executeQuery();
			if(null == rset){
				return 0;
			}
			int num =0;
			while(rset.next()){
				num++;
			}
			rset.close();
			stmt.close();
			conn.close();
			return num;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return 0;
	}
}
