<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Gothic+A1&family=Noto+Sans+KR:wght@100..900&family=Poor+Story&display=swap" rel="stylesheet">
		
	<link type="text/css" rel="stylesheet" href="./css/main.css"/>
	
	
	<title>메인페이지 | K-MOOC</title>
	<script 
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 
	crossorigin="anonymous">
	$('.carousel-inner').carousel({ interval:1000 });
</script>
</head>
<body>
		<jsp:include page="/header/header.jsp"></jsp:include>
			
		<main>
		<div class="carousel_class">
			<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active"><img class="d-block w-100" src="./mainImg/3.png" alt="..." /></div>
					<div class="carousel-item"><img class="d-block w-100" src="./mainImg/4.png" alt="..." /></div>
				</div>
			<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev"> <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="visually-hidden">Previous</span> </button> <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next"> <span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="visually-hidden">Next</span> </button>
			</div>
		</div>
		<div>
			<div id="categoryBox" class="categoryBox">
				<div id="alram" class="alram">
					<div id="alram_img" class="alram_img">공지</div>
					<div id="alram_text "class="alram_text"><a href="/Project4/comu.do?category=2" style="text-decoration: none; ">2024년 최신 공지사항 확인하러 가기</a></div>
				</div>
			</div>
		</div>
		<div>
			<div id="searchBox" class="searchBox">
				<div id="searchBox_search" class="searchBox_search">검색</div>
				<div id="searchBox_text" class="searchBox_text">
					<form action="" id="searchFrm" method="post">
					<input type="text" name="search" id="search"value="">
					<input type="button" id="searchButton"value=" 🔍">
					</form>
				</div>
				
			</div>
		</div>


		<div id="recommend_box" class="recommend_box">
			<div id="recommend_box_text" class="recommend_box_text"><p>K-MOOC</p>에서 추천하는 강좌 리스트</div>
			<div id="recommend_box_lecture" class="recommend_box_lecture">
				
				<c:forEach var="recommendList" items="${recommendLectureList}">
					<fmt:formatDate value="${recommendList.lecture_start_date}" pattern="yyyy-MM-dd" var="formattedStartDate" />
					<fmt:formatDate value="${recommendList.lecture_end_date}" pattern="yyyy-MM-dd" var="formattedEndDate" />
					<fmt:formatDate value="<%= new Date() %>" pattern="yyyy-MM-dd" var="formatNowDate" />
							
				
					<div id="recommend_box_All" class="recommend_box_All">
						<div id="recommend_box_img" class="recommend_box_img">
							<a href="/Project4/kmocMain.do?command=lectureDetail&lecture_idx=${recommendList.lecture_idx}"><img src="./${recommendList.lecture_img}" alt="">
							<c:if test="${recommendList.lecture_endPrize eq 'y'}">
							    <small class="certificate">이수증</small> 
							</c:if>
							
							<c:choose>
								<c:when test="${formattedStartDate le formatNowDate && formatNowDate ge formattedEndDate}">
									<small class="end">종료</small> 
								</c:when>
								<c:otherwise>
									 <small class="ing">진행중</small> 
								</c:otherwise>
							</c:choose>
							</a>
						</div>
						<div  id="recommend_box_content" class="recommend_box_content">
							<a href="/Project4/kmocMain.do?command=lectureDetail&lecture_idx=${recommendList.lecture_idx}"><p>${recommendList.lecture_title}</p></a>
							<p>${recommendList.member_name}</p>
							<p>${recommendList.member_company}</p>
							<p>${recommendList.lecture_start_date} ~ ${recommendList.lecture_end_date}</p>
							<p></p>
						</div>
					</div>
				</c:forEach>
				
			
			</div>
		</div>


		<div id="button_group" class="button_group">
			<div id="button_group_class" class="button_group_class">
				<button id="button_group_btn" class="button_group_btn"  onclick="window.location.href='/Project4/lecture/lecture_main.do?search_state=&search_category=10000';" >인문<img src="./mainImg/btn1.png" alt=""></button>
				<button id="button_group_btn" class="button_group_btn"  onclick="window.location.href='/Project4/lecture/lecture_main.do?search_state=&search_category=20000';">사회 <img src="./mainImg/btn2.png" alt=""></button>
				<button id="button_group_btn" class="button_group_btn"  onclick="window.location.href='/Project4/lecture/lecture_main.do?search_state=&search_category=30000';">교육<img src="./mainImg/btn3.png" alt=""></button>
				<button id="button_group_btn" class="button_group_btn"  onclick="window.location.href='/Project4/lecture/lecture_main.do?search_state=&search_category=40000';">공학<img src="./mainImg/btn4.png" alt=""></button>
				<button id="button_group_btn" class="button_group_btn"  onclick="window.location.href='/Project4/lecture/lecture_main.do?search_state=&search_category=50000';">자연<img src="./mainImg/btn5.png" alt=""></button>
				<button id="button_group_btn" class="button_group_btn"  onclick="window.location.href='/Project4/lecture/lecture_main.do?search_state=&search_category=60000';">의약 <img src="./mainImg/btn6.png" alt=""></button>
				<button id="button_group_btn" class="button_group_btn"  onclick="window.location.href='/Project4/lecture/lecture_main.do?search_state=&search_category=70000';">예체능 <img src="./mainImg/btn7.png" alt=""></button>
				<button id="button_group_btn" class="button_group_btn"  onclick="window.location.href='/Project4/lecture/lecture_main.do?search_state=&search_category=80000';">융합<img src="./mainImg/btn8.png" alt=""></button>
				<button id="button_group_btn" class="button_group_btn"  onclick="window.location.href='/Project4/lecture/lecture_main.do';">기타<img src="./mainImg/btn9.png" alt=""></button>
			</div>
		</div>


		<div id="best_box" class="best_box">
			<div id="best_box_text" class="best_box_text">서두르세요! 인기 강좌가 곧 시작합니다.</div>
			<div id="best_box_lecture" class="best_box_lecture">
		
				<c:forEach var="bestList" items="${bestLectureList}">
					<div id="best_box_All" class="best_box_All">
						<div id="best_box_img" class="best_box_img">
							<a href="/Project4/kmocMain.do?command=lectureDetail&lecture_idx=${bestList.lecture_idx}"><img src="./${bestList.lecture_img}" alt=""></a>
						</div>
						<div id="best_box_content" class="best_box_content">
							<a href="/Project4/kmocMain.do?command=lectureDetail&lecture_idx=${bestList.lecture_idx}"><p>${bestList.lecture_title}</p></a>
							<p>${bestList.lecture_start_date} ~ ${bestList.lecture_end_date}</p> 
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
    </main>
    
	<jsp:include page="/footer/footer.jsp"></jsp:include>
		<script type="text/javascript">
		const search = document.querySelector("#search");
		document.querySelector("#searchButton").addEventListener("click",function(){
		
			const frm = document.querySelector("#searchFrm");
			const v = "/Project4/lecture/lecture_main.do?search_option=search_title&search_word="+search.value;
			console.log(v);
			frm.action = v;
			frm.submit();
		});
	</script>
</body>
</html>