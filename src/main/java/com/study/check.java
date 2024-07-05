package com.study;

import java.sql.Connection;
import java.sql.DriverManager;

import jakarta.servlet.ServletException;

public class check {
	
	private String url = "jdbc:mysql://localhost:3306/db_todo?serverTimezone=Asia/Seoul";
	private String username = "root";
	private String password = "asd123";
	private final String CHECKQUERY = "SELECT userid from jspstudy where userid = ? ";
	Connection conn = null;
	
	private void checkID() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new ServletException("JDBC 드라이버를 찾을 수 없습니다", e);
		}
		
	}
	
	
	
	
    
}
