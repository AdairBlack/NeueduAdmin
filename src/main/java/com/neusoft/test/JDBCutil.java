package com.neusoft.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCutil {
	private static Connection conn=null;
	private PreparedStatement pst;

	public Connection getConnection(){
		try {
			String url = "jdbc:mysql://localhost:3306/neuedu";  
		    String name = "com.mysql.jdbc.Driver";  
		    String userName = "root";  
		    String pwd = "qwertyui";
			Class.forName(name);
			System.out.println("Load MySql Driver Success");
			
			if(conn==null){
				conn=DriverManager.getConnection(url, userName, pwd);
			}
			System.out.println("Gain Connection");

		} catch (ClassNotFoundException e) {
			System.out.println("Fail Load MySql Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL Exception");
			e.printStackTrace();
		}
		return conn;
	}
	
	public ResultSet executeQuery(String sql)throws SQLException{
		ResultSet rs=null;
		try {
			pst=conn.prepareStatement(sql);
			rs = pst.executeQuery();
			System.out.println("Execute Query Success");
		} catch (SQLException e) {
			System.out.println("SQL Exception");
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet executeQuery(String sql,Object obj[])throws SQLException{
		ResultSet rs=null;
		try {
			pst=conn.prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i + 1, obj[i]);
				}
			}
			rs = pst.executeQuery();
			System.out.println("Execute Query Success");
		} catch (SQLException e) {
			System.out.println("SQL Exception");
			e.printStackTrace();
		}
		return rs;
	}
	

	
	public int executeUpdate(String sql)throws SQLException{
		int count=-1;
		try {
			pst=conn.prepareStatement(sql);
			count=pst.executeUpdate();
			System.out.println("Execute Update Success");
		} catch (SQLException e) {
			System.out.println("SQL Exception");
			e.printStackTrace();
		}
		return count;
	}
	public int executeUpdate(String sql,Object obj[])throws SQLException{
		int count=-1;
		try {
			pst=conn.prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i + 1, obj[i]);
				}
			}
			count=pst.executeUpdate();
			System.out.println("Execute Update Success");
		} catch (SQLException e) {
			System.out.println("SQL Exception");
			e.printStackTrace();
		}
		return count;
	}
	public void close(){
		try {
			if(pst!=null){
				pst.close();
				pst=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
			System.out.println("Close Success");
		} catch (SQLException e) {
			System.out.println("SQL Exception");
			pst=null;
			conn=null;
			e.printStackTrace();
		}	
	}

	public void beginTransation(){
		try {
			conn.setAutoCommit(false);
			System.out.println("Begin Transation Success");
		} catch (SQLException e) {
			System.out.println("SQL Exception");
			e.printStackTrace();
		}
	}
	
	public void commit(){
		try {
			conn.commit();
			System.out.println("Commit Success");
		} catch (SQLException e) {
			System.out.println("SQL Exception");
			e.printStackTrace();
		}
	}

	public void rollback(){
		try {
			conn.rollback();
			System.out.println("Rollback Success");
		} catch (SQLException e) {
			System.out.println("SQL Exception");
			e.printStackTrace();
		}
	}
}
