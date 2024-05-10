<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QnA게시판</title>
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
            padding:20px;
            width: 900px;
            color: white;
        }
        .listHead{
            width: 1100px;
            font-size: 18px;
            border-bottom: 1px solid black;
            display:grid;
            grid-template-columns: 1fr;
        }
        .count{
            padding-left: 20px;
        }
        .countDiv{
            padding: 10px 0;
        }
        .registDiv{
            padding: 10px 0;
            padding-right: 20px;
        }
        .categoryDiv{
            display: flex;
            flex-wrap:wrap;          
        }
        .categoryDiv>a{
            padding: 10px 0;
            width: 33.33%;
            text-align: center;
            text-decoration: none;
            color: black;
            border-top: 1px solid black;
        }
        .categoryDiv a:hover{
            background-color:#002475;
            color: white;
        }
        #categoryDiv2>a{
            width: 12.5%;
        }
        
        .ul1{padding: 0px;}
        .thead, .tbody{
            list-style-type: none;
            display: table;
            width: 100%;
            border-top-color: 1px solid black;
        }
        .QNA, .type, .title, .flag, .content{
            text-align:center;
            padding: 10px 0px;
            height: 60px;
            box-sizing:border-box;
            display: table-cell;
            line-height: 50px;
        }
        .QNA{
            width: 100px;
        }
        .type{
            width: 150px;
        }
        .title{
            width: 800px;
            text-align: left;
        }
        .flag{
            width: 170px;
        }
        .content{
            width: 1100px;
            text-align: left;
            padding-left: 134px;
        }
        .mainfoot{
            width: 1100px;
            text-align: center;
        }
        .thead, .tbody{
            border: 1px solid black;
        }
        img{
        	vertical-align: middle;
        }
        .pagehover{
        	text-decoration: none;
        	color: black;
        }
        .pagehover:hover{
        	background-color:#002475;
        	color: white;
        }
        .qnaA{
        background-color:#002475;
        color: white;
        }
        .tbody{
        	display:none;
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
       <h2>자주묻는질문</h2>
    </div>
    </div>
    <div class="mainhead2">
        <div class ="listHead"> 
            <div class="categoryDiv">
                <a href="./comu.do?category=1">자유게시판</a>
                <a href="./comu.do?category=2">공지사항</a>
                <a class="qnaA" href="./qna.do" style="color: white;">자주묻는질문</a>
            </div>
        </div>
        <div class ="listHead2"> 
            <div class="categoryDiv" id="categoryDiv2">
                <a href="./qna.do?">전체</a>
                <a href="./qna.do?category=0">회원가입</a>
                <a href="./qna.do?category=1">로그인/계정</a>
                <a href="./qna.do?category=2">수강신청/취소</a>
                <a href="./qna.do?category=3">강좌수강</a>
                <a href="./qna.do?category=4">성적/이수증</a>
                <a href="./qna.do?category=5">기술적문제</a>
                <a href="./qna.do?category=6">기타</a>
            </div>
        </div>
        <div class="countDiv"><span class="count">총${params.total_count}건</span></div>
    <c:set var="row" value="${params.total_count - (params.page_no-1)*params.page_size }" />
    ${cnt=1;'' }
	<c:choose>
	<c:when test="${not empty bbsList }">
		<c:forEach var="list" items="${bbsList }" varStatus="loop">
		<ul class=ul1>
        <li class="thead">
            <span class="QNA"><img src="/Project4/img/Q.png" alt="Q"></span>
            <span class="type">${list.qna_category}</span>
            <span class="title">${list.qna_title }</span>
            <span class="flag" id="flag${cnt}">▼</span>
        </li>
        <li class="tbody" id="tbody${cnt}">
            <span class="QNA"><img src="/Project4/img/A.png" alt="A"></span>
            <span class="content">${list.qna_answer}</span>
        </li>
        ${cnt=cnt+1;''}
    	</ul>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<span class="QNA" style="width: 1100px;"><img src="/Project4/img/Q.png" alt="Q">등록된 Q&A글이 없습니다.</span>
	</c:otherwise>
</c:choose>
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
document.querySelector("#flag1").addEventListener("click",()=>{
let a = document.querySelector("#tbody1");
a.style.display=='table'? a.style.display='none': a.style.display='table';
})
document.querySelector("#flag2").addEventListener("click",()=>{
let a = document.querySelector("#tbody2");
a.style.display=='table'? a.style.display='none': a.style.display='table';
})
document.querySelector("#flag3").addEventListener("click",()=>{
let a = document.querySelector("#tbody3");
a.style.display=='table'? a.style.display='none': a.style.display='table';
})
document.querySelector("#flag4").addEventListener("click",()=>{
let a = document.querySelector("#tbody4");
a.style.display=='table'? a.style.display='none': a.style.display='table';
})
document.querySelector("#flag5").addEventListener("click",()=>{
let a = document.querySelector("#tbody5");
a.style.display=='table'? a.style.display='none': a.style.display='table';
})
document.querySelector("#flag6").addEventListener("click",()=>{
let a = document.querySelector("#tbody6");
a.style.display=='table'? a.style.display='none': a.style.display='table';
})
document.querySelector("#flag7").addEventListener("click",()=>{
let a = document.querySelector("#tbody7");
a.style.display=='table'? a.style.display='none': a.style.display='table';
})
document.querySelector("#flag8").addEventListener("click",()=>{
let a = document.querySelector("#tbody8");
a.style.display=='table'? a.style.display='none': a.style.display='table';
})
document.querySelector("#flag9").addEventListener("click",()=>{
let a = document.querySelector("#tbody9");
a.style.display=='table'? a.style.display='none': a.style.display='table';
})
document.querySelector("#flag10").addEventListener("click",()=>{
let a = document.querySelector("#tbody10");
a.style.display=='table'? a.style.display='none': a.style.display='table';
})
</script>
</body>
</html>