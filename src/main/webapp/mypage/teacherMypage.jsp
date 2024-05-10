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
			
	.pageInfo_wrap {
    margin-top: 20px;
    text-align: center;
}

.pageInfo_area {
    display: inline-block;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #f9f9f9;
}

.pageInfo_btn {
    display: inline-block;
    margin: 0 5px;
}

.pageInfo_btn a {
    padding: 5px 10px;
    color: #333;
    text-decoration: none;
}

.pageInfo_btn.active a {
    background-color: #337ab7;
    color: #fff;
    border-radius: 5px;
}

.pageInfo_btn.previous a,
.pageInfo_btn.next a {
    font-weight: bold;
}

.pageInfo_btn.previous a span,
.pageInfo_btn.next a span {
    margin-right: 5px;
}

	 
	  .active{
      background-color: #cdd5ec;
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
            <h2>강사 마이페이지</h2>
        </div>
        <div>
            <img src="/Project4/img/my_menu_01.png"/><a href="/Project4/kmocMain.do?command=teacherMypage">내 강의실</a>
            <br>
            <img src="/Project4/img/my_menu_02.png"/><a href="/Project4/mypage/mypage_info.do">개인정보관리</a>
        </div>
    </div>

    <div id="id2">
        <div id="id2_1">
                <img id="img1" src="/Project4/img/user_image.png">
                <span id="sp_user_name">${lecture_list[0].member_name}</span>강사님 안녕하세요. <br>
                <p><span id="sp_user_email">전화번호</span>&nbsp;${lecture_list[0].member_phone}</p>
        </div>
        <div id="id2_2">
            <hr>
            <div id="id2_2_1">
                <button id="classbtn1" class="btn">개설 강좌</button>
 <!--                <button id="classbtn2" class="btn">관심 강좌</button> -->
            </div>
            <div class="class1">
      
	         <c:forEach var="list" items="${lecture_list}">
	            <a href="/Project4/kmocMain.do?command=lectureDetail&lecture_idx=">
	            <div class="content">
	                <div class="content_img">
	                    <img src="/Project4${list.lecture_img}" style="background-color: grey; background-size:cover; width:150px; height:120px;"/>
	                </div>
	                <div class="content_card">
	                    <p class="lecture_title">${list.lecture_title}</p>
	                    <span class="lecture_teacher">${list.member_name}</span>
	                    <span class="lecture_date">${list.lecture_start_date} ~ ${list.lecture_end_date}</span>
	                </div>
	                <fmt:formatDate value="${list.lecture_start_date}" pattern="yyyy-MM-dd" var="formattedStartDate" />
					<fmt:formatDate value="${list.lecture_end_date}" pattern="yyyy-MM-dd" var="formattedEndDate" />
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
<!-- 	                        <input type="button" id="cancel_lecture" onclick="location.href='/Project4/kmocMain.do?command=cartDelete&idx=###'" value="수강취소"/>
 -->	                    </form>
	                </div>
	 
	            </div>
	            </a>
	         </c:forEach>
         
            
            
            <c:if test="${pageMaker.total eq 0}">
            <div class="content">
            	<h1>등록된 정보가 없습니다.</h1>
            </div>
            </c:if>
            </div>
            
            
     
            </div>
            
          
			<div class="pageInfo_wrap" >
			        <div class="pageInfo_area">
			        		<!-- 이전페이지 버튼 -->
			                <c:if test="${pageMaker.prev}">
			                    <li class="pageInfo_btn previous"><a href="/Project4/kmocMain.do?command=teacherMypage&pageNum=${pageMaker.startPage-1}">Previous</a></li>
			                </c:if>
			 				
			                 <!-- 각 번호 페이지 버튼 -->
			                <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			                    <li class="pageInfo_btn ${pageMaker.cri.pageNum == num ? "active":"" }"><a href="/Project4/kmocMain.do?command=teacherMypage&pageNum=${num}" >${num}</a></li>
							</c:forEach>
			                
			                      <!-- 다음페이지 버튼 -->
			                <c:if test="${pageMaker.next}">
			                    <li class="pageInfo_btn next"><a href="/Project4/kmocMain.do?command=teacherMypage&pageNum=${pageMaker.endPage + 1 }">Next</a></li>
			                </c:if>  
			        </div>
			</div>
    </div>
</div>
</main>

<script>
	
/* 	let classbtn1 = document.querySelector("#classbtn1");
    let classbtn2 = document.querySelector("#classbtn2");
    
    classbtn1.addEventListener('click',()=>{
    	document.querySelector(".class1").style.display ="block";
    	document.querySelector(".class2").style.display ="none";
    });
    
    classbtn2.addEventListener('click',()=>{
    	document.querySelector(".class2").style.display ="block";
    	document.querySelector(".class1").style.display ="none";
    }); */
    
</script>
</body>
</html>