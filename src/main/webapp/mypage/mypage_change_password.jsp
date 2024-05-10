<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.contact li{
    	list-style-type: none;
    }
   
</style>
</head>



<body>
<% String pwd = request.getParameter("pwd"); %>
<b><font size="4" color="gray">비밀번호 변경</font></b>
	<br>
	
	<form name="checkpwdForm">
		<div class="border">
			<fieldset class="contact">
			<ul>
				<li>
		        	<label for="password" >현재 비밀번호</label>
		        	<input type="password" id ="password_now" name="password_now" maxlength="30" class="contents"  placeholder="비밀번호 입력" required>
		        	<p id ="pwdnowequal"></p>
		        </li>
				<li>
		        	<label for="password" >비밀번호</label>
		        	<input type="password" id ="password" name="password" maxlength="30" class="contents"  placeholder="비밀번호 입력" required>
		        	<p id ="pwderr"></p>
		        </li>
		        <li>
		        	<label for="password" >비밀번호 확인</label>
		        	<input type="password" id ="password2" name="password2" maxlength="30" class="contents"  placeholder="비밀번호 다시 입력" required>
		        	<p id ="pwdequal"></p>
		        </li>
	        </ul>
			<input type="button" id="change" value="변경"/>
			</fieldset>
		</div>
	</form>
	<script>
		let pwd = document.querySelector('#password');
    	let pwd2 = document.querySelector('#password2');
    	let pwdnow = document.querySelector('#password_now');
    	
    	let pwdnowequalerr = document.querySelector('#pwdnowequal');
    	let pwderr = document.querySelector('#pwderr');
	    let pwderr2 = document.querySelector("#pwdequal");
    	
    	let pwdnowequal = false;
    	let pwdequal = false;
    	let pwdconfirm = false;
    	
        
        document.querySelector("#change").addEventListener('click',()=>{
        	 event.preventDefault();
        	 if(pwdnowequal == false){
        		alert("원래비밀번호가 다릅니다.");
              	return false;
        	 }
        	 else if(pwdconfirm == false){
            	 alert("양식에 맞게 비밀번호를 설정하세요.");
            	
             	return false;
             }
        	 else if(pwdequal == false){
        		 alert("비밀번호가 일치하지 않습니다.");
             	return false;
             }
             
        	 
        	 document.querySelector("#change").disabled = true;
        	 opener.document.querySelector("#pwd").value = document.querySelector("#password").value;
          	 window.close();
        	 
        });
        
        pwd.addEventListener('keypress', () =>{
            if(pwd.value.match(/[a-zA-Z]/g) == null 
					|| pwd.value.match(/[0-9]/g) == null 
					|| pwd.value.match(/[\W_]/g) == null 
					|| pwd.value.length<4 ||pwd.value.length >20){
                pwderr.innerHTML = "<strong>&nbsp;&nbsp;&nbsp;4글자~20글자이내 영어/숫자/특수문자를 최소 하나씩넣어서 작성해주세요</strong>"                
                pwderr.style.color = "red";
                pwdconfirm = false;
            }
            else{
                pwderr.innerHTML = "<strong>&nbsp;&nbsp;&nbsp;올바른 비밀번호입니다.";
                pwderr.style.color = "green";
                pwdconfirm = true;
            }
        });
        
        pwd2.addEventListener('keypress', () =>{
        	if(pwd.value !== pwd2.value){
                pwderr2.innerHTML = "<strong>&nbsp;&nbsp;&nbsp;비밀번호가 일치하지 않습니다.</strong>"                
                pwderr2.style.color = "red";
                pwdequal = false;
            }
            else{
            	pwderr2.innerHTML = "<strong>&nbsp;&nbsp;&nbsp;비밀번호가 일치합니다.</strong>";
                pwderr2.style.color = "green";
                pwdequal = true;
            }
        });
        
        pwdnow.addEventListener('keypress', () =>{
        	if(pwdnow.value != "${pwd}"){
                pwdnowequalerr.innerHTML = "<strong>&nbsp;&nbsp;&nbsp;비밀번호가 일치하지 않습니다.</strong>"                
                pwdnowequalerr.style.color = "red";
                pwdnowequal = false;
            }
            else{
            	pwdnowequalerr.innerHTML = "<strong>&nbsp;&nbsp;&nbsp;비밀번호가 일치합니다.</strong>";
            	pwdnowequalerr.style.color = "green";
            	pwdnowequal = true;
            }
        });
        
        pwd.addEventListener('keyup', () =>{
            if(pwd.value.match(/[a-zA-Z]/g) == null 
					|| pwd.value.match(/[0-9]/g) == null 
					|| pwd.value.match(/[\W_]/g) == null 
					|| pwd.value.length<4 ||pwd.value.length >20){
                pwderr.innerHTML = "<strong>&nbsp;&nbsp;&nbsp;4글자~20글자이내 영어/숫자/특수문자를 최소 하나씩넣어서 작성해주세요</strong>"                
                pwderr.style.color = "red";
                pwdconfirm = false;
            }
            else{
                pwderr.innerHTML = "<strong>&nbsp;&nbsp;&nbsp;올바른 비밀번호입니다.";
                pwderr.style.color = "green";
                pwdconfirm = true;
            }
        });
        
        pwd2.addEventListener('keyup', () =>{
        	if(pwd.value !== pwd2.value){
                pwderr2.innerHTML = "<strong>&nbsp;&nbsp;&nbsp;비밀번호가 일치하지 않습니다.</strong>"                
                pwderr2.style.color = "red";
                pwdequal = false;
            }
            else{
            	pwderr2.innerHTML = "<strong>&nbsp;&nbsp;&nbsp;비밀번호가 일치합니다.</strong>";
                pwderr2.style.color = "green";
                pwdequal = true;
            }
        });
        
        pwdnow.addEventListener('keyup', () =>{
        	if(pwdnow.value != "${pwd}"){
                pwdnowequalerr.innerHTML = "<strong>&nbsp;&nbsp;&nbsp;비밀번호가 일치하지 않습니다.</strong>"                
                pwdnowequalerr.style.color = "red";
                pwdnowequal = false;
            }
            else{
            	pwdnowequalerr.innerHTML = "<strong>&nbsp;&nbsp;&nbsp;비밀번호가 일치합니다.</strong>";
            	pwdnowequalerr.style.color = "green";
            	pwdnowequal = true;
            }
        });
    </script>

</body>
</html>