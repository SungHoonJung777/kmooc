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
	<style>
        *{
           margin:0px;
            padding:0px;
        }
        .main{
            margin:200px auto;
            width: 744px;
        }
        .border{
            width: 622px;
            border:1px solid white;
            padding:30px 60px;
            background-color: #e3f0fc;
        }
        #idrange,#passwordrange{
            border:1px solid black;
            padding:10px;
            margin:20px 0px;
        }
        
        .findfrm input:not([type = submit]){
            height:50px;
            width:100%;
            margin:20px 0px;
            border:1px solid blue;
        }
        .loginbtn{
            width:100px;
            height:30px;
            margin:0px auto;
            margin-top:30px;
            display:block;
        }
        .loginbtn:hover{
            font-weight: bold;
            background-color: black;
            border: 2px solid gray;
            color:white;
        }
        
        .changebtn{
            width:100%;
            height:62px;
            background-color: white;
            border-collapse: collapse;
            border:1px solid gray;
        }
        .changebtn tr td{
            display:inline-block;
            width:33%;
            height:100%;
            text-align: center;
        }
        .changebtn tr td a{
            text-decoration: none;
            height: 100%;
            margin: 10px auto;
            display:inline-block;
        }
        .changebtn{
            margin:20px auto;
        }
        #button{
        	width: 120px;
            height: 50px;
            background-color:#ebebeb;
            color:black;
        	font-size:16px;
        	border:1px solid black;
        	border-radius:10px;
        }
        #button{
        	text-align:center;
        }
        .information{
        	width:600px;
        	height:200px;
        	background-color:white;
        	border:1px solid white;
        	margin-botthom:20px;
        }
        
        .information tr th,.information tr td{
        	border:1px solid black;
        }
        
</style>
</head>
<body>
	<header>
		<jsp:include page="/header/header.jsp" />
	</header>
	<main>
    	<div class="main">
    		<h1>${errmsg }</h1>
	        <h1 style="text-align: center; margin-bottom:50px;"> 회원가입 성공</h1>
            <h2 style="text-align: center; margin:50px 0px;"> 가입한 회원정보</h2>
	        <div class="border" style="text-align: center;"">
	        <table class="information">
	        	<thead>
	        		<tr>
	        			<th>이름</th>
	        			<th>아이디</th>
	        			<th>이메일</th>
	        		</tr>
	        	</thead>
	        	<tbody>
	        		<tr>
	        			<td>${params.name }</td>
	        			<td>${params.id }</td>
	        			<td>${params.email }</td>
	        		</tr>
	        	</tbody>
	        </table>
	        <h4 style="margin:20px;">로그인 하시겠습니까?</h4>
	        <input type="button" id="button" onclick="location.href='login.do'" value="로그인">
	        </div>
        </div>
        
    </main>
    <jsp:include page="/footer/footer.jsp"></jsp:include>
    <script>
    	
    </script>
</body>
</html>