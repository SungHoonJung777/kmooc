<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% boolean check = (boolean)request.getAttribute("result"); %>
<b><font size="4" color="gray">ID 중복 확인</font></b>
	<br>
	
	<form name="checkIdForm">
		
		<%if(check){ %>
			<p style="color: green">사용 할 수 있는 이메일입니다.</p>
		<%}else{ %>
			<p style="color: red">이미 사용 중인 이메일입니다.</p>
		<%};%>
		<input type="hidden" value=<%=check %> name="check" id="check">
		<input type="button" onclick="setParentText();" value="닫기"/>

	</form>
	<script>
		
        function setParentText(){
        	opener.document.querySelector("#emailcheck").value = document.querySelector("#check").value;
        	window.close();
        }
    </script>
</body>
</html>