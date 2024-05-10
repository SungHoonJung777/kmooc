<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Gothic+A1&family=Noto+Sans+KR:wght@100..900&family=Poor+Story&display=swap" rel="stylesheet">
		
	<link type="text/css" rel="stylesheet" href="/Project4/css/header.css"/>
	
    <header id="header">
        <div id="headcontainer">
        	<% boolean login = CommonUtil.loginCheck(session); %>
            <div id="logo">
                <a href="/Project4/kmocMain.do?command=main"><img src="/Project4/mainImg/header_logo.png" alt=""></a>
            </div>
            <nav id="top_menu">
                <ul>
                    <li><button style="margin-left: 50px ;" onclick="location.href='/Project4/lecture/lecture_main.do'" id="lecturebtn">강좌</button>
                    <div id = "dropbar" style="width:150px;height:600px;position:absolute;top:83px;border:1px solid black;border-top:1px solid white;display:none;z-index:100; background-color:white">
        				<ul style="text-align:center; padding:0;">
        					<li><a href="/Project4/lecture/lecture_main.do?search_state=&search_category=10000">인문</a></li><br>
        					<li><a href="/Project4/lecture/lecture_main.do?search_state=&search_category=20000">사회</a></li><br>
        					<li><a href="/Project4/lecture/lecture_main.do?search_state=&search_category=30000">교육</a></li><br>
        					<li><a href="/Project4/lecture/lecture_main.do?search_state=&search_category=40000">공학</a></li><br>
        					<li><a href="/Project4/lecture/lecture_main.do?search_state=&search_category=50000">자연</a></li><br>
        					<li><a href="/Project4/lecture/lecture_main.do?search_state=&search_category=60000">의약</a></li><br>
        					<li><a href="/Project4/lecture/lecture_main.do?search_state=&search_category=70000">예체능</a></li><br>
        					<li><a href="/Project4/lecture/lecture_main.do?search_state=&search_category=80000">융합</a></li><br>
        				</ul>
        			</div>
        			</li>
                    <li><a href="/Project4/comu.do">커뮤니티</a></li>
                </ul>
            </nav>
            <nav id="top_menu_1">
                <ul>
                	<% if(!login){ %>
                    <li><a href="/Project4/member/login.do">로그인</a></li>
                    <li><a href="/Project4/member/joinchoice.do">회원가입</a></li>
                    <%}else{ %>
                    <li><a href="/Project4/member/logout.do">로그아웃</a></li>
                    <c:choose>
                    	<c:when test="${member_category eq '1'}">
                    		<li><a href="/Project4/mypage/mypage.do">마이페이지</a></li>
                    	</c:when>
                    	<c:otherwise>
                    	  <li><a href="/Project4/kmocMain.do?command=teacherMypage">강사 마이페이지</a></li>
                    	</c:otherwise>
                    </c:choose>
                    <%} %>
                </ul>
            </nav>
        </div>
        
        <script>
    	document.querySelector("#lecturebtn").addEventListener('mouseover',()=>{
    		console.log("Test");
    		document.querySelector("#dropbar").style.display="block";
    	});
    	document.querySelector("#dropbar").addEventListener('mouseleave',()=>{
    		console.log("Test");
    		document.querySelector("#dropbar").style.display="none";
    	})
    </script>
    </header>
    
