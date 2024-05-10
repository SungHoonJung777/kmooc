<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
            color: white;
        }
        .changebtn tr td{
            list-style-type: none;
            display:inline-block;
            width:49.92%;
            height:100%;
            text-align: center;
            
        }
        .changebtn tr td a{
            text-decoration: none;
            height: 100%;
            margin: 10px auto;
            display:inline-block;
            color: black;
           
        }
        .changebtn{
            margin:20px auto;
        }
        #button input{
        	width: 120px;
            height: 50px;
            background-color:#0036ce;
            color:white;
        	font-size:16px;
        	border:1px solid white;
        	border-radius:3px;
        }
        #button{
        	text-align:center;
        }
        
</style>
</head>
<body>
	
	<header>
		<jsp:include page="/header/header.jsp" />
	</header>
	<main>
    	<div class="main">
	        <h1 style="text-align: center; margin-bottom:50px;"> 아이디 / 비밀번호 찾기</h1>
            <table class="changebtn">
                <tr>
                    <c:if test="${param.search eq 1}" >
               		<td id="findid" style="border-bottom:5px solid blue;"><a href ="/Project4/member/find.do?search=1" id="findid1">아이디 찾기</a></td>
               		<td id="findpwd" style="border-left:1px solid black; border-bottom:5px solid black;"><a href ="/Project4/member/find.do?search=2" id="findpwd1">비밀번호 찾기</a></td>
               		</c:if>
                    <c:if test="${param.search eq 2}" >
               		<td id="findid" style="border-bottom:5px solid black;"><a href ="/Project4/member/find.do?search=1" id="findid1">아이디 찾기</a></td>
               		<td id="findpwd" style="border-left:1px solid black; border-bottom:5px solid blue;"><a href ="/Project4/member/find.do?search=2" id="findpwd1">비밀번호 찾기</a></td>
               		</c:if>

                </tr>
                
            </table>
           <input type="hidden" name="idFind" id="idFind" value="${memberId}">
           <input type="hidden" name="pwdChange" id="pwdChange" value="${pwdChange}">
            <h2 style="text-align: center; margin:50px 0px;"> 회원가입시 기입한 정보를 입력해주세요.</h2>
	        <div class="border" style="text-align: center;"">
		        <c:choose>
		        	<c:when test="${param.search  eq 1}" >
		        		<form action="" class="findfrm" id="login0" method="post">
				            <input type="tel" name="tel" id="tel" maxlength="20" placeholder="- 빼고 전화번호 입력" />
				            <input type="email" name="email" id="email" placeholder="이메일입력" />
				                                                      
				            <input type="hidden" name="id" id="id" placeholder="아이디입력" value="hidden"/>
				            <input type="hidden" name="search" id="search" value="${param.search}"/>
				            <div>회원가입 시 기입한 정보를 입력해주세요.</div>
				            <div id="button">
				                <input type="button" value="찾기" class="loginbtn">
				            </div>
				        </form>
		        	</c:when>
		        	<c:otherwise>
			        	<form method="post" action="" class="findfrm" id="login0">
				            <input type="tel" name="tel" id="tel" maxlength="20" placeholder="- 뺴고 전화번호 입력" />
				            <input type="email" name="email" id="email" placeholder="이메일입력" />
				            <input type="hidden" name="search" id="search" value="${param.search}"/>                    
				            <input type="text" name="id" id="id" placeholder="아이디입력" />
				            
				            <div>회원가입 시 기입한 정보를 입력해주세요.</div>
				            <div id="button">
				                <input type="button" value="찾기" class="loginbtn">
				            </div>
				        </form>
		        	</c:otherwise>
		        </c:choose>
	        </div>    
        </div>
    </main>
    <jsp:include page="/footer/footer.jsp"></jsp:include>
    <script>

    	let findid = document.querySelector("#findid");
    	let findid1 = document.querySelector("#findid1");
    	let findpwd = document.querySelector("#findpwd");
    	let findpwd1 = document.querySelector("#findpwd1");
    	
    	
    	
    	const phone = document.querySelector("#tel");
    	const email = document.querySelector("#email");
    	const id = document.querySelector("#id");
    	const search = document.querySelector("#search");


    	document.querySelector(".loginbtn").addEventListener("click",function(){
    		if(phone.value == null || email.value == null || id.value == null || phone.value == 'null' || email.value == 'null' || id.value == 'null'
    				|| phone.value == "" || email.value == "" || id.value == "" ){
    			alert("정보를 모두 입력해주세요.");
    			
    		} else {
    			
    			if(search.value == 1){
    				const frm  = document.querySelector(".findfrm");
    				frm.action = "/Project4/kmocMain.do?command=idSearch";
        			
        			
    				frm.submit(); 
    			} else {
    				const frm  = document.querySelector(".findfrm");

    				frm.action = "/Project4/kmocMain.do?command=pwdSearch";
        			frm.submit(); 
    			} 

    		}
    	});
    	
    	const idFind = document.querySelector("#idFind");
    	console.log(idFind.value );
    	if(idFind.value != null && idFind.value != "" && idFind.value != "null"){
    		if(idFind.value == "nullId"){
    			alert("입력하신 회원정보와 일치하는 ID가 없습니다.");
    		} else {
    			alert("찾으시는 ID는 : " + idFind.value);
    		}
    	}
    	
    	const pwdChange = document.querySelector("#pwdChange");
    	console.log(pwdChange.value );
    	if(pwdChange.value != null && pwdChange.value != "" && pwdChange.value != "null"){
    		if(pwdChange.value == "nullPwd"){
    			alert("입력하신 회원정보와 일치하는 PWD가 없습니다.");
    		} else {
    			alert("임시 비밀번호를 발급해드렸습니다. 마이페이지에서 비밀번호를 변경해주세요.  임시비밀번호 : " + pwdChange.value);
    		}
    	}
    	
    	
    </script>
</body>
</html>