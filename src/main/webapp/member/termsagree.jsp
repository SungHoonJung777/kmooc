<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/Project4/css/popup.css">
    <style>
        *{
            margin:0px;
            padding:0px;
        }
        .main{
            margin:200px auto;
            width: 1100px;
            margin-bottom:100px;
        }
        .border{
            width:800px;
            margin: 100px auto;
            background-color: skyblue;
            padding: 60px 30px;
        }
        .contact{
            width:680px;
            margin:0px auto;
            background-color: white;
        }
        .terms{
        	display:inline-block;
            width: 470px;
            height: 72px;
            font-size:20px;
            
        }
        .contents{
            margin:30px;
        }
        .contact li{
            list-style-type: none;
            margin-left:10px;
        }
        .btn{
           	width: 120px;
            height: 50px;
        	font-size:16px;
        	border:1px solid white;
        	border-radius:3px;
        	margin:10px;
        }
        .submitbtn input:hover,.submitbtn button:hover{
            background-color: black;
            color:white;
            border:1px solid gray;
        }
        .submitbtn{
            text-align: center;
        }
        /* li button{
            float:right;
            width: 90px;
            height: 30px;
            margin :10px;
            background-color:#ebebeb;
        	font-size:16px;
        	border:1px solid white;
        	border-radius:3px;
        } */
        #findid{
        	background-color:#0036CE;
            color:white;
        }
        input[type=checkbox]{
            width:20px;
            margin:10px;
        }
        #nextbtn{
        	background-color:blue;
        	Color:white;
        }
        .agreebtn{
        	width: 120px;
            height: 40px;
            margin :10px;
            background-color:white;
        	font-size:16px;
        	border:1px solid #ebebeb;
        	border-radius:4px;
        }
        .check{
			height:20px;   
        }
        
    </style>
</head>
<body>
	<jsp:include page="/header/header.jsp" />
    <main>
        <div class="main">
            <h1 style="text-align: center; margin-bottom:50px;"> 약관동의</h1>
            <h2 style="text-align: center; margin:50px 0px;"> </h2>
            <form action="join.do" id="frm" method="post">
                <div class="border">
                    <div style="width:680px; display:block; margin:20px auto; font-size:20px; height:30px;">
                        <input type="checkbox" class ="check" id="check">전체 약관에 동의합니다.
                    </div>
                    <fieldset class="contact">
                        <ul>
                            <li>
                                <input type="checkbox" class="check" id="check1"><label class="terms">이용약관 동의<span style="color:red">(필수)</span></label><button type="button" onclick="openPop1()" class="agreebtn">자세히 보기</button>
                            </li>
                            <li>
                                <input type="checkbox" class="check" id="check2"><label class="terms">개인정보 필수항목 수집 이용 및 동의<span style="color:red">(필수)</span></label><button type="button" class="agreebtn" onclick="openPop2()">자세히 보기</button>
                            </li>
                            
                            <li>
                                <input type="checkbox" class="check" id="check3"><label class="terms">개인정보 선택항목 수집 및 이용 동의</label><button type="button" class="agreebtn" onclick="openPop3()">자세히 보기</button>
                            </li>
                            
                            <li> 
                                <input type="checkbox" class="check" id="check4"><label class="terms">홍보 설문 관련 정보 수신 동의</label><button type="button" class="agreebtn" onclick="openPop4()">자세히 보기</button>
                            </li>
                            
                        </ul>
                    </fieldset>
                </div>
                <div class="submitbtn">
                    <button type="button" class="btn" onclick="window.location.href='login.do'">취소</button>
                    <input class="btn" id="nextbtn" type="submit" value="다음">
                </div>
            </form>
        </div>
        <% for(int i =1; i<=4; i++){ %>
        <div class="popup_layer" id="popup_layer<%=i %>" style="display: none;">
          <div class="popup_box">
              <div style="height: 10px; width: 800px; float:right;">
                <a href="javascript:closePop<%=i%>();"><img src="/Project4/img/close.png" class="m_header-banner-close" width="30px" height="30px" style="float:right;"></a>
              </div>
              <!--팝업 컨텐츠 영역-->
              <div class="popup_cont" style="margin-top:30px;">
        		  <img src="/Project4/img/약관<%=i%>.jpg"></img>
              </div>
              <!--팝업 버튼 영역-->
              <div class="popup_btn" style="float: bottom; margin-top: 200px;">
                  <a href="javascript:closePop<%=i%>();">닫기</a>
              </div>
          </div>
         </div>
         <%} %>
    </main>
    <jsp:include page="/footer/footer.jsp"></jsp:include>
    <script>
	   
		/* if(!document.querySelector("#check1").checked || !document.querySelector("#check2").checked){
			document.querySelector("#nextbtn").disabled = true;
		} */
		let nextbtn = document.querySelector("#nextbtn");
		let btngroup = document.querySelectorAll(".check");
		let entirecheck = document.querySelector("#check");
		
		nextbtn.addEventListener('click',()=>{
			event.preventDefault();
			if(!document.querySelector("#check1").checked || !document.querySelector("#check2").checked){
				alert("필수 항목체크가 되지 않았습니다.");
				return false;
			}
			document.querySelector("#frm").submit();
		});
		
		entirecheck.addEventListener('click',()=>{
			if(entirecheck.checked){
				for(let i=0; i<btngroup.length; i++){
					btngroup[i].checked = true;
				}
			}
			else{
				for(let i=0; i<btngroup.length; i++){
					btngroup[i].checked = false;
				}
			}
			
		});
		
		function openPop1() {
	        document.getElementById("popup_layer1").style.display = "block";
	    }
	    //팝업 닫기
	    function closePop1() {
	        document.getElementById("popup_layer1").style.display = "none";
	    }
	    function openPop2() {
	        document.getElementById("popup_layer2").style.display = "block";
	    }
	    //팝업 닫기
	    function closePop2() {
	        document.getElementById("popup_layer2").style.display = "none";
	    }
	    function openPop3() {
	        document.getElementById("popup_layer3").style.display = "block";
	    }
	    //팝업 닫기
	    function closePop3() {
	        document.getElementById("popup_layer3").style.display = "none";
	    }
	    function openPop4() {
	        document.getElementById("popup_layer4").style.display = "block";
	    }
	    //팝업 닫기
	    function closePop4() {
	        document.getElementById("popup_layer4").style.display = "none";
	    }
	    
    </script>
</body>
</html>

