<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/header.css">
    <style>
        *{
            margin:0px;
            padding:0px;
        }
        .main{
            margin:200px auto;
            width: 1100px;
        }
        .border{
            width:800px;
            margin: 100px auto;
            background-color: #e3f0fc;
            padding: 60px 30px;
        }
        .contact{
            width:600px;
            margin:0px auto;
            background-color: white;
            padding: 20px 40px;
        }
        .contact input:not([type=submit]){
            width:120px;
            height:50px;
            border:1px solid white;
        }
        .contact label{
            width: 120px;
            height: 72px;
            float: left;
            text-align: center;
            line-height: 75px;
        }
        .contents{
            margin:10px;
        }
        .contact li{
            list-style-type: none;
        }
        .btn{
            width: 120px;
            height: 50px;
            margin :10px;
            background-color:#ebebeb;
        	font-size:16px;
        	border:1px solid white;
        	border-radius:3px;
        }
        
        .submitbtn input:hover,.submitbtn button:hover{
            background-color: black;
            color:white;
            border:1px solid gray;
        }
        
        .submitbtn{
            text-align: center;
        }
        .btn1{
        	background-color:blue; 
        	color:white; 
        }
    </style>
</head>
<body>
	<jsp:include page="/header/header.jsp" />
    <main>
        <div class="main">
            <h1 style="text-align: center; margin-bottom:50px;"> 회원가입</h1>
            <h2 style="text-align: center; margin:50px 0px;"> 학부모 인증</h2>
            <form action="termsagree.do" id="frm">
                <div class="border">
                    <fieldset class="contact">
                        <ul>
                            <li>
                                <label for="name">학부모 이름</label>
                                <input type="text" id ="name" name="name" maxlength="20" class="contents"  placeholder="이름 입력" autofocus required/>
                            </li>
                            <li>
                                <label for="age">학부모 주민번호</label>
                                <input type="text" id ="jumin1" name="jumin1" maxlength="6" class="contents"  placeholder="주민번호 앞자리" autofocus required/>
                                -
                                <input type="text" id ="jumin2" name="jumin2" maxlength="7" class="contents"  placeholder="주민번호 뒷자리" autofocus required/>
                            </li>
                            <li style="text-align: center;">
                                <button type="button" class="btn btn1" id="agecheck">인증</button>
                            </li>
                        </ul>
                        
                    </fieldset>
                </div>
                <div class="submitbtn">
                    <button class="btn" type="button" onclick="window.location.href='login.do'">취소</button>
                    <input class="btn btn1" id="nextbtn" type="submit" value="다음">
                </div>
            </form>
        </div>
    </main>
    <jsp:include page="/footer/footer.jsp"></jsp:include>
    <script>
    
    	let check = false;
	    
    	var onlyKorean = function() {
	    	
	  	  	var pattern = /[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g;
	  	  	this.value = this.value.replace(pattern, '');
	  	};
	  	
	  	var onlyNumber = function() {
	  		
	    	var pattern = /[^-0-9]/g;
	    	this.value = this.value.replace(pattern, '');
    	};
    	
    	let jumin1 = document.querySelector("#jumin1");
 	    let jumin2 = document.querySelector("#jumin2");
    	let name = document.querySelector('#name');
    	let nextbtn = document.querySelector('#nextbtn');
		let agecheck = document.querySelector("#agecheck");
		
			
    	
	    name.addEventListener("keypress", onlyKorean);
	    name.addEventListener("keyup", onlyKorean);
	    
	    jumin1.addEventListener("keypress", onlyNumber);
	    jumin1.addEventListener("keyup", onlyNumber);
	    
	    jumin2.addEventListener("keypress", onlyNumber);
	    jumin2.addEventListener("keyup", onlyNumber);
	    
	    
	    agecheck.addEventListener('click',()=>{
	    	if(jumin1.value.length !=6 || jumin2.value.length !=7 || (name.value.length >4&&name.value.length<2)){
	    		alert("개인정보를 바르게 입력하세요");
	    	}
	    	else if(jumin1.value.substr(0,2) < 24 && 2024-("20"+jumin1.value.substr(0,2))<20){
				check = false;
				alert("성인이 아닙니다.");
			}
			else{
				check = true;
				alert("인증완료");
			}
		});
		
		nextbtn.addEventListener('click', ()=>{
			event.preventDefault();
				if(check){
					document.querySelector("#frm").submit();
				}
				else{
					alert("인증 진행 요망");
					return false;
				}
		})
    	
    </script>
</body>
</html>