<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    <style>
        .main{
            width: 1100px;
            margin: 0 auto;
        }
        .mainhead{
            width: 1100px;
            background-color:#002475;
            padding-bottom:40px;
        }
        .searchWrap{
            padding-top:20px;
            width: 900px;
        }
        .search{
            padding-left: 50px;
            display:flex;
            flex-wrap:wrap;
        }
        #select{
            width: 160px;
            height: 55px;
            font-size: 16px;
            line-height: 48px;
            position: relative;
            padding: 0 68px 0 20px;
            box-sizing: border-box;
        }
        #search_word{
            font-size: 16px;
            line-height: 48px;
            margin-left:10px;
            width: 500px;
        }
        #btnSearch{
            width: 55px;
            height: 55px;
            background-color: #00A85D;
        }
        .btnImg{
            width: 20px;
            height: 20px;
        }
        .listHead{
            width: 1100px;
            font-size: 18px;
            border-bottom: 1px solid black;
            display:grid;
            grid-template-columns: 1fr 6fr 1fr;
        }
        .listBody {
        	display: flex;
        	align-items: center;
        }
        .listBody span{
        	display: flex;
        	justify-content: center;
        	align-items: center;
        }
        .count{
            padding-left: 20px;
        }
        .countDiv{
            padding: 10px 0;
            line-height: 50px;
        }
        .registDiv{
            padding: 10px 0;
            padding-right: 20px;
            text-align: center;
        }
        .categoryDiv{
            display: flex;
            flex-wrap:wrap;          
        }
        .categoryDiv>a{
            padding: 10px 0;
            width: 33%;
            text-align: center;
            text-decoration: none;
            color: black;
            line-height: 50px;
        }
        .categoryDiv a:hover{
            background-color:#002475;
            color: white;
        }
        
        .ul1{padding: 0px;}
        .main li{
        	list-style-type: none;
        	border-bottom: 1px solid rgb(200, 200, 200);
        }
        .thead span {
        	font-size: 18px;
        	font-weight: 700;
        }
        .thead .tbody{
            list-style-type: none;
            display: table;
            width: 100%;
            border-top-color: 1px solid black;
        }
        .num, .type, .user, .title, .date{
            text-align:center;
            padding: 10px 0px;
            height: 60px;
            box-sizing:border-box;
            display: table-cell;
      
        }
        .num{
            width: 100px;
        }
        .type{
            width: 130px;
        }
        .user{
            width: 130px;
        }
        .title{
            width: 800px;
            
        }
        .title a{
        	width:600px;
            text-decoration: none;
            color: black;
            text-align:left;
        }
        .date{
            width: 170px;
        }
        .mainfoot{
            width: 1100px;
            text-align: center;
        }
        #registBtn{
           vertical-align:middle;
           
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
        .qnaA{
        background-color:#002475;
        color: white;
        }
        
    </style>
</head>
<body>

<div class="wrap">
<div class=header>
<%@ include file="../header/header.jsp" %>
</div>
<div class=main>
    <div class="mainhead">
    <div class="searchWrap">
        <form name="frmSearch" id="frmSearch" method="get" >
        <div class="search">
        <select name="search_category" id="search_category">
            <option value="">전체</option>
            <option value="comu_title">제목만</option>
            <option value="comu_content">내용만</option>
            <option value="tc">제목+내용</option>
            <option value="member_user_id">작성자</option>
        </select>
        <input name="search_word" id="search_word" type="text" placeholder="검색어를 입력하세요." maxlength="100">
        <button type="submit" id="btnSearch"><img class="btnImg" src="/Project4/img/search.png" alt="img"></img></button>
        </form>
        </div>
    </div>
    </div>
    <div class="mainhead2">
        <div class ="listHead"> 
            <div class="countDiv"><span class="count"><a href="comu.do">총${params.total_count}건</a></span></div>
            <div class="categoryDiv">
                <a href="comu.do?category=1">자유게시판</a>
                <a href="comu.do?category=2">공지사항</a>
                <a href="qna.do">자주묻는질문</a>
            </div>
            <div class="registDiv"><img id="registBtn" src="/Project4/img/write.png" alt="img"></div>
        </div>
    <ul class=ul1>
        <li class="thead">
            <span class="num">번호</span>
            <span class="type">구분</span>
            <span class="user">작성자</span>
            <span class="title">제목</span>
            <span class="date">등록일</span>
        </li>
    
    <c:set var="row" value="${params.total_count - (params.page_no-1)*params.page_size }" />
	<c:choose>
	<c:when test="${not empty bbsList }">
		<c:forEach var="list" items="${bbsList}" varStatus="loop">
		<li class="listBody">
            <span class="num">${row }</span>
            <span class="type">${list.comu_category}</span>
            <span class="user">${list.member_user_id}</span>
            <span class="title"><a href="bbsdetail.do?idx=${list.comu_idx}">${list.comu_title}</a></span>
            <span class="date">${list.comu_reg_date}</span>
    	</li>
    	${row= row-1;'' }
		</c:forEach>
	</c:when>
	<c:otherwise>
		<span class="QNA" style="width: 1100px;"><img src="/Project4/img/Q.png" alt="Q">등록된 글이 없습니다.</span>
	</c:otherwise>
	</c:choose>
    
    <br/>
    
    </ul>
    <div class="mainfoot">
        <p>${params.paging }</p>
    </div>
    </div>
</div>

<div class=footer>
<%@ include file="../footer/footer.jsp" %>
</div>
</div>

<script>
document.querySelector("#registBtn").addEventListener("click",()=>{
   window.location.href="./registConn.do";
})
</script>
</body>
</html>