<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="common.BbsPage"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lecture_main</title>
    <style>
        .container {
            width: 1100px;
            margin: auto;
        }
        #id0 {
            height: 76px;
        }
        #id1 a{
            text-decoration: none;
            color: black;
        }
        #id2 {
                background-color: #002475;
   				background-image: url("../img/bg_title_01.png"), url("../img/bg_title_02.png");
    			background-repeat: no-repeat;
    			background-position: bottom left, top 30% right 20%;
            width: 100%;
            height: 200px;
        }
        #id3 {
            display: flex;
        }
        #id4 {
            display: block;
        }
        #id4_1 {
    		display: flex;
    		justify-content: space-between;
        }
        #id4_1 span {
        }
        #id4_2 {
            display: grid;
            width: 100%;
            grid-template-columns: repeat(4, minmax(150px,1fr));
            grid-template-rows: repeat(5, 300px);
            grid-gap: 20px;
        }
        .content_div {
            background-color: rgb(230, 230, 230);
            border: 1px solid transparent;
            width: 100%;
            height: 100%;
            overflow: hidden;	/*넘치지 않게..ㅜㅠclip이랑 뭐가 다른지*/
        }
        #id4_2 a{
            text-decoration: none;
            color: black;
        }
        .content_img {
        	margin: 10px auto;
        	width: 230px;
        	height: 150px;
        	background-size: cover;
        }
        .content_card {
        	margin: 5px 10px;
        }
        .content_title {
        	height: 20px;
        	overflow: clip;
        }
        .content_name {
        	margin: 0 auto;
        }
        .content_company {
        	color:grey;
        	line-height: 0.5;
        	font-size: small;
        }
        .content_date {
        	color:grey;
        	line-height: 0.5;
        	font-size: small;
        }
        #id5 {
            text-align: center;
        }
        #frm1 {
            width: 100%;
            height: 30px;
        }
        #frm1 input[type=search]{
            width: 70%;
            height: 40px;
        }
        #frm1 select {
        	width: 100px;
        	height: 40px;
        	font-size: 16px;
        }
        #search_submit {
        	width:40px;
        	height: 40px;
        	margin: 0;
            background: #00A85D;
        }
        #frm2 select {
        	width: 150px;
            height: 30px;
            font-size: 16px;
            border: 1px solid rgb(200, 200, 200);
        }
        #frm2 input[type=button] {
        	width: 100px;
            height: 30px;
            font-size: 16px;
            padding: 0;
            border: 1px solid rgb(200, 200, 200);
        }
        #frm2 input[type=button]:hover {
        	background-color: #007bff;
        }
        #frm2 input[type=button]:active {
        	color: white;
        }
        #frm2 input[type=submit] {
        	width: 100px;
            height: 30px;
            font-size: 16px;
            padding: 0;
            border: 1px solid rgb(200, 200, 200);
        }
        #frm2 input[type=submit]:hover {
        	background-color: #007bff;
        }
        #frm2 input[type=submit]:active {
        	color: white;
        }
        #frm3 {
            display: flex;
        }
		#frm3 select{
        	width: 120px;
            height: 30px;
            font-size: 16px;
            border: 1px solid rgb(200, 200, 200);
        }
        #paging {
        	margin: auto;
        	display: flex;
        	justify-content: center;
        }
        .pagehover{
        	text-decoration: none;
        	color: black;
        	padding: 2px 5px;
        }
        .pagehover:hover{
        	background-color:#002475;
        	color: white;
        	padding: 2px 5px;
        }
    </style>
</head>


<body>
	<jsp:include page="/header/header.jsp"></jsp:include>
<main>
	<div id="id0"></div>
    <div id="id1" class="container">
        <a href="/Project4/kmocMain.do?command=main">Home</a>
        &gt
        <a href="/Project4/lecture/lecture_main.do">강좌</a>
       	
        <c:if test="${param.search_category != '' && param.search_category != null}">
        	&gt
		        <a href="/Project4/lecture/lecture_main.do?search_category=${param.search_category }">${result_category}</a>
		</c:if>
		<c:if test="${param.search_category_detail != '' && param.search_category_detail != null}">
		        &gt
		        	<a href="/Project4/lecture/lecture_main.do?search_category_detail=${param.search_category_detail }">${result_category_detail}</a>
		</c:if>
        
    </div>
    
    <div id="id2">
    <div class="container">
        <h1 style="color: white; padding: 60px 0px 20px; ">강좌 검색</h1>

        <form name="frm1" id="frm1">
            <select name="search_option" id="search">
                <option value="search_title" selected>강좌제목</option>
                <option value="search_teacher">강사명</option>
            </select>
            <input type="search" name="search_word" id="search_word">
            <input id="search_submit" type="submit" value="🔍">
        </form>
    </div>
    </div>
    
    <div id="id3" class="container">
        <form name="frm2" id="frm2">
            <select name="search_state" id="search_state">
                <option value="" selected hidden>개강상태</option>
                <option value="" >전체</option>
                <option value="state_ing" >진행중</option>
                <option value="state_before" >개강예정</option>
                <option value="state_after" >종료</option>
            </select>
            <select name="search_category" id="search_category">
                <option value="" selected hidden>주제</option>
                <option value="" >전체</option>
                <option value="10000" class="category">인문</option>
                <option value="20000" class="category">사회</option>
                <option value="30000" class="category">교육</option>
                <option value="40000" class="category">공학</option>
                <option value="50000" class="category">자연</option>
                <option value="60000" class="category">의약</option>
                <option value="70000" class="category">예체능</option>
                <option value="80000" class="category">융합</option>
            </select>
            <select name="search_category_detail" id="search_category_detail">
                <option value="" selected hidden>중분류</option>
                <option value="" >전체</option>
                <option value="10100" class="detail">언어문학</option>
                <option value="10200" class="detail">인문과학</option>
                <option value="20100" class="detail">경영·경제</option>
                <option value="20200" class="detail">법률</option>
                <option value="20300" class="detail">사회과학</option>
                <option value="30100" class="detail">교육일반</option>
                <option value="30200" class="detail">유아교육</option>
                <option value="30300" class="detail">초등교육</option>
                <option value="30400" class="detail">중등교육</option>
                <option value="30500" class="detail">고등교육</option>
                <option value="40100" class="detail">건축</option>
                <option value="40200" class="detail">전기</option>
                <option value="40300" class="detail">전자</option>
                <option value="40400" class="detail">컴퓨터</option>
                <option value="50100" class="detail">농림</option>
                <option value="50200" class="detail">화학</option>
                <option value="50300" class="detail">생명</option>
                <option value="60100" class="detail">의료</option>
                <option value="60200" class="detail">간호</option>
                <option value="70100" class="detail">디자인</option>
                <option value="70200" class="detail">영화</option>
                <option value="70300" class="detail">미술</option>
                <option value="80100" class="detail">융합</option>
                
            </select>
            <select name="search_period" id="search_period">
                <option value="" selected hidden>학습기간</option>
                <option value="" >전체</option>
                <option value="period_short" >단기(1~2주)</option>
                <option value="period_mid" >중기(3~4주)</option>
                <option value="period_long" >장기(5주~)</option>
            </select>
            <input type="button" id="search_refresh" value="새로고침" />
            <input type="submit" value="필터 검색" />
        </form>
    </div>
    
    <br/>
    
    <div id="id4" class="container">
        <div id="id4_1" >
        	
        <c:choose>
        	<c:when test="${param.search_word != '' && param.search_word != null}">
        		<span>'${params.search_word }' 검색결과 ${params.total_count}건</span>
        	</c:when>
        	<c:otherwise>
        		<span>총 ${params.total_count} 강좌수</span>
        	</c:otherwise>
        </c:choose>

            <form name="frm3" id="frm3" method="post">
              <!--   <input type="button" name="order_by" id="order_by_1" value = "최신등록순" onclick="this.form.submit()" selected/>
                <input type="button" name="order_by" id="order_by_2" value = "가나다순" onclick="this.form.submit()" /> -->
            	 <select name="order_by" id="order_by" class="order_by">
	                <option value=""  >정렬</option>
	                <option value="order_by_1" >최신등록순</option>
	                <option value="order_by_2" >가나다순</option>
	            </select>
            </form>
        </div>
    
    	<br/>
    	
        <div id="id4_2" class="container">
        
        <c:choose>
        	<c:when test="${not empty lectureList }">
        		<c:forEach var="list" items="${lectureList }" varStatus="loop">
        			<a href="/Project4/kmocMain.do?command=lectureDetail&lecture_idx=${list.lecture_idx }">
					<div class="content_div">
                        <div class="content_img">
                        	<img src="..${list.lecture_img}" style="width: 230px; height: 150px; margin: auto;" />
                        </div>
                       	<div class="content_card">
						<strong class="content_title">${list.lecture_title }</strong>
						<p class="content_name">${list.member_name }</p>
						<p class="content_company">${list.member_company }</p>
						<p class="content_date">${list.lecture_start_date } ~ ${list.lecture_end_date }</p>
						</div>
					</div>
					</a>
		</c:forEach>
			</c:when>
			<c:otherwise>
				<p>일치하는 검색결과가 없습니다.<p>
			</c:otherwise>
		</c:choose>

        </div>
    </div>
    
    <br>
    
    <div class="container">
    	<div id="paging">
    		<div>
    			${params.paging }
    		</div>	
    	</div>
    </div>
    <br/>
    
    </main>
    <jsp:include page="/footer/footer.jsp"></jsp:include>
<script>
	let search_refresh= document.querySelector("#search_refresh");
	let search_state = document.querySelector("#search_state");
    let search_categorye = document.querySelector("#search_category");
    let search_category_detail = document.querySelector("#search_category_detail");
    let search_period = document.querySelector("#search_period");
	search_refresh.addEventListener("click", (e) => {
        

        search_state.options[0].selected = true;
        search_category.options[0].selected = true;
        search_category_detail.options[0].selected = true;
        search_period.options[0].selected = true;
    })
      
      const frm  = document.querySelector("#frm3");
	 const frm1  = document.querySelector(".order_by");
    document.querySelector(".order_by").addEventListener("change", function(){

    	frm.action = "/Project4/lecture/lecture_main.do";
    	frm.submit();
    });
    
    let category = document.querySelectorAll(".category");
    let category_detail = document.querySelectorAll(".detail");
    
    console.log(category);
    console.log(category_detail);
    search_categorye.addEventListener('click',()=>{
    	
        	for(let j =0; j<category_detail.length; j++){
        		if(category_detail[j].value.substring(0,2) != search_category.value.substring(0,2)){
        			console.log(category_detail[j].value.substring(0,2) !== search_category.value.substring(0,2));
        			console.log(search_category.value.substring(0,2));
        			console.log(search_category.value.substring(0,2));
        			category_detail[j].hidden = true;
        		}
        		else{
        			category_detail[j].hidden = false;
        		}
        	}
        
    });
   
</script>

</body>
</html>