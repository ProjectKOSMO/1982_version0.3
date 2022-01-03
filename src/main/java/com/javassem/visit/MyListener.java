package com.javassem.visit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener{

	
	public void sessionCreated(HttpSessionEvent arg0) {
		
		String driver = "org.mariadb.jdbc.Driver";
		String DB_IP="gomdb.cimth6lqkkpt.us-east-2.rds.amazonaws.com";
		String DB_PORT="3306";
		String DB_NAME="xe";
		String DB_URL="jdbc:mariadb://"+DB_IP+":"+DB_PORT+"/"+DB_NAME;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(DB_URL, "root", "project1982");
			if (conn != null) {
				System.out.println("DB 접속 성공");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}
		
		try {
			String sql = "insert into visitor (visitDate)values(Date_Format(now(),'%Y-%m-%d'))";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			String userId = null;
			String password = null;
			String name = null;
			while (rs.next()) {
				userId = rs.getString(1);
				password = rs.getString(2);
				name = rs.getString(3);
			}

			System.out.println(userId);
			System.out.println(password);
			System.out.println(name);

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	public void sessionDestroyed(HttpSessionEvent arg0) {
	}

}
