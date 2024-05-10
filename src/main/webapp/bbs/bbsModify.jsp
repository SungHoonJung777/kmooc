<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<style>
    .main{
        width: 1100px;
        margin: 0 auto;
    }
    h2{
        text-align: center;
        padding: 10px;
    }
    span{
        width: 100px;
        font-size: 18px;
        margin-right: 10px;
        line-height: 50px;
    }
    #category, #title{
        font-size: 18px;
        margin-right: 10px;
        width: 1080px;
        padding: 10px;
        border:  0px solid black;
    }
    .f1, .f2{
        border-bottom: 1px solid black;
        
    }
    .f1>div, .f2 >div{
        width: 100px;
    }
    textarea{
        width: 1100px;
        height: 400px;
        font-size: 18px;
        resize: none;
    }
    #btn_submit, #btn_cancel{
        margin-top: 10px;
        padding: 10px;

    }
    #file{
        visibility: hidden;
    }
    #filename{
        margin-left: 5px;
        font-size: 14px;
    }
    form{
    	margin-bottom: 10px;
    }


</style>
</head>
<body>
<div class="wrap">
<div class=header>
<%@ include file="../header/header.jsp" %>
</div>
<div class="main">
    <h2>게시판 수정</h2>
    <form name="frm_regist" id="frm_regist" action="./modify.do" enctype="multipart/form-data" method="post">
        <div class="f1"><div><span>구분</span></div>
        <select name="category" id="category">
        	<option value="자유게시판">자유게시판</option>
        	<option value="공지사항">공지사항</option>
        </select></div><br>
        <div class="f2"><div><span>제목</span></div>
        <input type="text" name="title" id="title" value="${title}" maxlength="100"></div><br>
        <textarea name="content" id="content">${content}</textarea><br>
        <input type="image" src="/Project4/img/upload.png" id="btn_fileupload"><span id="filename"></span>
        <input type="file" name="file" id="file" multiple ><br>
        <input type="submit" name="btn_submit" id="btn_submit" value="글등록">
        <input type="button" name="btn_cancel" id="btn_cancel" value="취소">
        <input type="hidden" id="idx" name="idx" value="${idx}">
        <input type="hidden" name="user_id" id="user_id" value="${ UserId}" readonly><br>
    </form>
</div>


<div class=footer>
<%@ include file="../footer/footer.jsp" %>
</div>

</div>

<script>
	let a = document.getElementById("file").addEventListener("change",()=>{
    let b = document.getElementById("file").files;
    let c = document.getElementById("filename");
    let d = "";
    for(let i=0; i<b.length; i++){
        d = d+ "file name : "+ b[i].name+" ";
    }
    c.innerText = d;
	})
    document.querySelector("#btn_fileupload").addEventListener("click",()=>{
        let a = document.getElementById("file");
        a.click();
        event.preventDefault();
    })
    document.querySelector("#btn_submit").addEventListener("click",()=>{
        let a = document.getElementById("user_id");
        let b = document.getElementById("title");
        let c = document.getElementById("content");
        if(b.value ==""){
            alert("제목이 비어있습니다.");
            event.preventDefault();
        }
        if(c.value == ""){
            alert("내용이 비어있습니다.");
            event.preventDefault();
        }        
        if(confirm("수정 하시겠습니까?")){
            window.location.href="./comu.do";
        }
    })
    document.querySelector("#btn_cancel").addEventListener("click",()=>{
        if(confirm("이전페이지로 돌아가시겠습니까?")){
            window.location.href="./comu.do";
        }
    })
    </script>
</body>
</html>