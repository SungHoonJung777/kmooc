<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</head>
<body>
	<% String name = request.getParameter("name");
	String id = request.getParameter("id");
	String email = request.getParameter("email"); %>
	
	<form action="/Project4/member/join_complete.do" id="frm" method="post">
	<input type="hidden" id="id" name="id" value="<%=id %>">
	<input type="hidden" id="name" name="name" value="<%=name %>">
	<input type="hidden" id="email" name="email" value="<%=email %>">
	</form>
	
    	
    <script>
    	document.querySelector("#frm").submit();
    </script>
</body>
</html>