package com.study.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/signLogic")
public class signLogic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn = null;

	public signLogic() {

	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 작동");

		String url = "jdbc:mysql://localhost:3306/db_todo?serverTimezone=Asia/Seoul";
		String username = "root";
		String password = "asd123";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new ServletException("JDBC 드라이버를 찾을 수 없습니다", e);
		}
	}

	public void destroy() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");

		try { 
			String query = " INSERT INTO sign(username, email, userid, userpw) VALUES (?, ?, ?, ?) ";
			PreparedStatement ptmt = conn.prepareStatement(query);
			
			ptmt.setString(1, username);
			ptmt.setString(2, email);
			ptmt.setString(3, userid);
			ptmt.setString(4, userpw);
			
			int rowCount = ptmt.executeUpdate();
			if(rowCount > 0) {
				conn.commit();
				System.out.println("commit complete");
			} else {
				conn.rollback();
				System.out.println("commit fail");
			}
			
		} catch (Exception e) {
			e.printStackTrace(); // 콘솔창에서 오류를 찾기 위함
			response.getWriter().print("오류 발생"); // Client 측에게 보내는 오류 메시지
		}
		response.getWriter().print("complete");
		
	}

	

}
