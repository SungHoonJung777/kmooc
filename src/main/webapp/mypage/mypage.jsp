<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>MyPage</title>
    <style>
        .container {
            width: 1100px;
            margin: auto;
        }
        #id0 {
            height: 76px;
        }
        .content {
            display: flex;
            justify-content: space-between;
            margin: 30px 20px;
            height: 150px;
        }
        .content_img {
            margin: 15px 20px;
            width: 150px;
            height: 120px;
            box-sizing: border-box;
            background-color: grey;
        }
        .content_card {
            width: 350px;
            font-size: 12px;
        }
        .lecture_title {
            margin: 20px 0px 30px 0px;
            font-size: 18px;
            font-weight: 800;
        }
        .lecture_date {
            color: grey;
        }
        .content_state {
            align-self: center;
        }
        .content_cancel {
            align-self: center;
            padding: 20px;
        }
        .content_cancel input[type=button]{
            border: 0;
            border-radius: 5px;
            padding: 10px 20px;
            background-color: rgba(190, 190, 190, 0.5);
        }
        .content_cancel input[type=button]:hover{
            border: 0;
            border-radius: 5px;
            padding: 10px 20px;
            background-color: rgba(190, 190, 190, 0.7);
        }
        .content_cancel input[type=button]:active{
            border: 0;
            border-radius: 5px;
            padding: 10px 20px;
            background-color: rgba(190, 190, 190, 0.3);
        }
        #id1 {
            float: left;
            box-sizing: border-box;
            width: 200px;
            padding: 20px;
        }
        #id2 {
            float: left;
            box-sizing: border-box;
            height: 800px;
            width: 800px;
        }
        #id2_1 {
            height: 100px;
            margin: 20px 30px;
        }
        #id2_2 {
            margin: 20px 30px;
        }
        #id2_2_1 {
            padding: 0px 30px;
        }
        #id2_2_1 a{
            text-decoration: none;
            color: black;
        }
        #img1 {
            float: left;
            width: 100px;
            height: 100px;
            border-radius: 50%;
            background-color: grey;
            margin: 0 20px 0 0;
        }
        a {
            text-decoration: none;
            color: black;
        }
        #id2_2_1 button {
        	width: 120px;
            height: 30px;
            font-size: 16px;
            padding: 2px 5px;
            border: 1px solid rgb(200, 200, 200);
        }
        #id2_2_1 button:hover {
        	background-color:#007bff;
        }
        #id2_2_1 button:active {
        	color: white;
        }
        #id2_2_1 a{
            padding: 0px 20px ;
            color: grey;
        }
        #id2_2_1 a:active, #id2_2_1 a:target, #id2_2_1 a:hover{
            padding: 0px 20px ;
            color: black;
            font-weight: 700;
        }
        #sp_user_name {
            font-weight: 700;
            color: blue;
            font-size: 34px;
        }
        #sp_user_email {
            font-weight: 600;
        }
        .ing{
			box-sizing: border-box;
		    display: inline-block;
		    width: 58px;
		    height: 23px;
		    font-size: 12px;
		    color: #fff;
		    line-height: 23px;
		    text-align: center;
		    border-radius: 2px;
		    background: rgba(8, 119, 240, 0.9);
		}
		.end{
			box-sizing: border-box;
		    display: inline-block;
		    width: 58px;
		    height: 23px;
		    font-size: 12px;
		    color: #fff;
		    line-height: 23px;
		    text-align: center;
		    border-radius: 2px;
		    background-color: rgba(140,42,108,0.9);
		
		}
    </style>
</head>
<body>
	<jsp:include page="/header/header.jsp" />
<main>
	<div id="id0"></div>
	
<div class="container">
    <div id="id1">
        <div>
            <h2>마이페이지</h2>
        </div>
        <div>
            <div><img src="/Project4/img/my_menu_01.png"/><a href="mypage.do">내 강의실</a></div>
            <br>
            <div><img src="/Project4/img/my_menu_02.png"/><a href="mypage_info.do">개인정보관리</a></div>
        </div>
    </div>

    <div id="id2">
        <div id="id2_1">
                <img id="img1" src="/Project4/img/user_image.png">
                <span id="sp_user_name">${params.name}</span>님 안녕하세요. <br>
                <p><span id="sp_user_email">이메일 주소</span>&nbsp;${params.email}</p>
        </div>
        <div id="id2_2">
            <hr>
            <div id="id2_2_1">
                <button id="classbtn1" class="btn">수강중인 강좌</button>
                <button id="classbtn2" class="btn">관심 강좌</button>
            </div>
            <div class="class1">
            <c:if test="${params.titleList.size()-1 >=0 }">
            <c:forEach var="i" begin="0" end="${params.titleList.size()-1}">
            <a href="/Project4/kmocMain.do?command=lectureDetail&lecture_idx=${params.idxList.get(i)}">
            <div class="content">
                <div class="content_img">
                    <img src="/Project4${params.imgList.get(i) }" style="background-color: grey; background-size:cover; width:150px; height:120px;"/>
                </div>
                <div class="content_card">
                    <p class="lecture_title">${params.titleList.get(i) }</p>
                    <span class="lecture_teacher">${params.teacherList.get(i)}</span>
                    <span class="lecture_date">${params.strdateList.get(i)}~${params.enddateList.get(i)}</span>
                </div>
                <fmt:formatDate value="${params.strdateList.get(i)}" pattern="yyyy-MM-dd" var="formattedStartDate" />
				<fmt:formatDate value="${params.enddateList.get(i)}" pattern="yyyy-MM-dd" var="formattedEndDate" />
				<fmt:formatDate value="<%= new Date() %>" pattern="yyyy-MM-dd" var="formatNowDate" />
                <p class="content_state">
					<c:choose>
						<c:when test="${formattedStartDate le formatNowDate && formatNowDate ge formattedEndDate}">
							<small class="end">종료</small> 
						</c:when>
							<c:otherwise>
								<small class="ing">진행중</small> 
						</c:otherwise>
					</c:choose>
				</p>
                <div class="content_cancel">
                    <form class="frm3">
                        <input type="button" id="cancel_lecture${i}" onclick="location.href='/Project4/kmocMain.do?command=cartDelete&idx=${params.idxList.get(i)}'" value="수강취소"/>
                    </form>
                </div>
 
            </div>
            </a>
            </c:forEach>
            </c:if>
            <c:if test="${params.titleList.size()-1 < 0 }">
            <div class="content">
            	<h1>등록된 정보가 없습니다.</h1>
            </div>
            </c:if>
            </div>
            
            
            
            
            </div>
            
            <div class="class2" style="display:none;">
           
           	<c:if test="${params1.titleList.size()-1 >=0 }">
            <c:forEach var="i" begin="0" end="${params1.titleList.size()-1}">
            <a href="/Project4/kmocMain.do?command=lectureDetail&lecture_idx=${params1.idxList.get(i)}"><div class="content">
                <div class="content_img">
                    <img src="/Project4${params1.imgList.get(i) }" style="background-color: grey; background-size:cover; width:150px; height:120px;"/>
                </div>
                <div class="content_card">
                    <p class="lecture_title">${params1.titleList.get(i) }</p>
                    <span class="lecture_teacher">${params1.teacherList.get(i)}</span>
                    <span class="lecture_date">${params1.strdateList.get(i)}~${params1.enddateList.get(i)}</span>
                </div>
                <fmt:formatDate value="${params1.strdateList.get(i)}" pattern="yyyy-MM-dd" var="formattedStartDate" />
				<fmt:formatDate value="${params1.enddateList.get(i)}" pattern="yyyy-MM-dd" var="formattedEndDate" />
				<fmt:formatDate value="<%= new Date() %>" pattern="yyyy-MM-dd" var="formatNowDate" />
                <p class="content_state">
					<c:choose>
						<c:when test="${formattedStartDate le formatNowDate && formatNowDate ge formattedEndDate}">
							<small class="end">종료</small> 
						</c:when>
							<c:otherwise>
								<small class="ing">진행중</small> 
						</c:otherwise>
					</c:choose>
				</p>
                <div class="content_cancel">
                    <form class="frm3">
                        <input type="button" id="cancel_heart${i}" onclick="location.href='/Project4/kmocMain.do?command=heartDelete&idx=${params1.idxList.get(i)}'" value="찜 해제"/>
                    </form>
                </div>
			
            </div></a>
            </c:forEach>
            </c:if>
            <c:if test="${params1.titleList.size()-1 < 0 }">
            <h1>등록된 정보가 없습니다.</h1>
            </c:if>
            </div>
        </div>
    </div>
</div>
</main>
<script>
	
	let classbtn1 = document.querySelector("#classbtn1");
    let classbtn2 = document.querySelector("#classbtn2");
    
    classbtn1.addEventListener('click',()=>{
    	document.querySelector(".class1").style.display ="block";
    	document.querySelector(".class2").style.display ="none";
    });
    
    classbtn2.addEventListener('click',()=>{
    	document.querySelector(".class2").style.display ="block";
    	document.querySelector(".class1").style.display ="none";
    });
    
</script>
</body>
</html>