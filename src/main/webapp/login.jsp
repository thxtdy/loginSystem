<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="jakarta.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="loginstyles.css">
</head>
<body>
	<%
	Connection conn = null;

	String url = "jdbc:mysql://localhost:3306/db_todo?serverTimezone=Asia/Seoul";
	String username = "root";
	String password = "asd123";

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, username, password);
	} catch (Exception e) {
		throw new ServletException("JDBC 드라이버를 찾을 수 없습니다.");
	}

	String userid = request.getParameter("username");
	String email = request.getParameter("email");
	String userpw = request.getParameter("confirm-password");

	try {
		String checkquery = " SELECT * FROM sign where id = ?";
		PreparedStatement ptmt = conn.prepareStatement(checkquery);
		
		ptmt.setString(1, userid);
		
		ResultSet rs = ptmt.executeQuery();
		
		if(!rs.next()){
			out.print("중복된 ID 입니다.");
		} else {
			out.print("사용 가능한 아이디입니다.");
		}
		
		String insertquery = " INSERT INTO sign(userid, email, userpw) VALUES (?, ?, ?)";

	} catch (Exception e) {

	}
	%>
	<div class = "container">
	<h2>로그인</h2>
	<form action="#" method="post">
	
		<label for="userid">아이디</label>
	    <input type="text" id="id" name="userid">
		 
		<label for="password">비밀번호</label>
        <input type="password" id="password" name="userpw">
        
        <button type="submit">로그인</button>

	</form>
</div>


</body>
</html>