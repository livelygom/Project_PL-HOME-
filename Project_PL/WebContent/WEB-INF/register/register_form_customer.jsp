<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>편라인 : Project PL</title>
		<link href="${initParam.rootPath }/css/bootstrap.min.css" rel="stylesheet">
		<link href="${initParam.rootPath }/css/font-awesome.min.css" rel="stylesheet">
		<link href="${initParam.rootPath }/css/prettyPhoto.css" rel="stylesheet">
		<link href="${initParam.rootPath }/css/price-range.css" rel="stylesheet">
		<link href="${initParam.rootPath }/css/animate.css" rel="stylesheet">
		<link href="${initParam.rootPath }/css/main.css" rel="stylesheet">
		<link href="${initParam.rootPath }/css/responsive.css" rel="stylesheet">
		<!--[if lt IE 9]>
		    <script src="js/html5shiv.js"></script>
		    <script src="js/respond.min.js"></script>
		    <![endif]-->
		<link rel="shortcut icon" href="${initParam.rootPath}/images/ico/favicon.ico">
		<link rel="apple-touch-icon-precomposed" sizes="144x144" href="${initParam.rootPath}/images/ico/apple-touch-icon-144-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="114x114" href="${initParam.rootPath}/images/ico/apple-touch-icon-114-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="72x72" href="${initParam.rootPath}/images/ico/apple-touch-icon-72-precomposed.png">
		<link rel="apple-touch-icon-precomposed" href="${initParam.rootPath}/images/ico/apple-touch-icon-57-precomposed.png">
	</head>
	<body>
		<header id="header"><!--header-->
			<div class="header-middle">
				<!--header-middle-->
				<div class="container">
					<div class="row">
						<div class="col-sm-4">
							<div class="logo pull-left">
								<a href="${initParam.rootPath }/basic/item_list.do">
									<img src="${initParam.rootPath}/images/pline.png" alt="홈으로" />
								</a>
							</div>
						</div>
						<div class="col-sm-8">
							<div class="shop-menu pull-right">
								<ul class="nav navbar-nav">
									<li><a href="${initParam.rootPath }/basic/login_form.do"><i class="fa fa-lock"></i> 로그인</a></li>
									<li><a href="${initParam.rootPath }/basic/register_form.do"><i class="fa fa-user"></i> 회원가입</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--/header-middle--> 
		</header>
		
		<!--\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 스크립트 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\ -->
	<script type="text/javascript" src="/Project_PL/script/jquery.js"></script>
	<script type="text/javascript">
		function checkPassword() {
			var form = document.forms[0];
			var customerPassword = form.customerPassword.value;
			var customerPasswordCheck = form.customerPasswordCheck.value;
			if (customerPassword != customerPasswordCheck) {
				document.getElementById('checkPwd').style.color = "red";
				document.getElementById('checkPwd').innerHTML = "동일한 암호를 입력하세요.";
			} else {
				document.getElementById('checkPwd').style.color = "black";
				document.getElementById('checkPwd').innerHTML = "암호가 확인 되었습니다.";
			}
		}
	</script>


	<script type="text/javascript">
		$(document).ready(function() {
			$("#checkId").on("click", function() {
				var hidden = document.joinForm.id_check.value;
				var pw1 = document.joinForm.pw1.value;
				var pw2 = document.joinForm.pw2.value;
				if (hidden == "Y") {
					alert("ID중복확인을 해주세요");
					return false;
				} else if(pw1 != pw2) {
					alert("패스워드가 틀립니다.")
					return false;
				} else {
					return true;
				}
			});
		});
	</script>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#searchJsonBtn").on("click", function() {
				$.ajax({
					"url" : "/Project_PL/customer/findByIdJson.do",//요청할 서버 URL 
					"type":"POST", 
					"data": {"customerId":$("#customerId").val()},//요청파라미터 - query string형태, javascript 객체
					"dataType": "text",//응답 데이터 형식(타입)-text(기본),json, jsonp, xml
					"beforeSend":function(){
						if(!$("#customerId").val()){
							alert("조회할 ID 넣으세요");
							$("#customerId").focus();
							return false;
						}
					},
					"success" : function(text) {
	                       alert("중복된 아이디입니다.");		
	                       var t = document.joinForm.id_check.value = "Y";
	             
					},
					"error" : function() {
						alert("사용가능한 ID입니다.");
						document.joinForm.id_check.value = "N";
					}
				});
			});
		});
	</script>
	
	<!--\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 스크립트 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\ -->
		
		<!--/header-->
		<section id="slider"><!--slider-->
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<div id="slider-carousel" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
								<li data-target="#slider-carousel" data-slide-to="1"></li>
								<li data-target="#slider-carousel" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner">
								<div class="item active">
									<div class="col-sm-6">
										<h1>
											<span>P</span>-LINE
										</h1>
										<h2>코스타 101기 2조 프로젝트</h2>
										<p>윤민석 최정길 강지선 권효균 안동신 김경모</p>
										<button type="button" class="btn btn-default get">편라인</button>
									</div>
									<div class="col-sm-6">
										<img src="${initParam.rootPath}/images/home/girl1.jpg" class="girl img-responsive" alt="" /> 
										<img src="${initParam.rootPath}/images/home/pricing.png" class="pricing" alt="" />
									</div>
								</div>
								<div class="item">
									<div class="col-sm-6">
										<h1>
											<span>P</span>-LINE
										</h1>
										<h2>프로젝트 : 편라인</h2>
										<p>윤민석 최정길 강지선 권효균 안동신 김경모</p>
										<button type="button" class="btn btn-default get">편라인</button>
									</div>
									<div class="col-sm-6">
										<img src="${initParam.rootPath}/images/home/girl2.jpg" class="girl img-responsive" alt="" /> 
										<img src="${initParam.rootPath}/images/home/pricing.png" class="pricing" alt="" />
									</div>
								</div>
								<div class="item">
									<div class="col-sm-6">
										<h1>
											<span>P</span>-LINE
										</h1>
										<h2>한국소프트웨어기술진흥협회</h2>
										<p>윤민석 최정길 강지선 권효균 안동신 김경모</p>
										<button type="button" class="btn btn-default get">편라인</button>
									</div>
									<div class="col-sm-6">
										<img src="${initParam.rootPath}/images/home/girl3.jpg" class="girl img-responsive" alt="" />
										<img src="${initParam.rootPath}/images/home/pricing.png" class="pricing" alt="" />
									</div>
								</div>
							</div>
							<a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev"> 
								<i class="fa fa-angle-left"></i>
							</a> 
							<a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next"> 
								<i class="fa fa-angle-right"></i>
							</a>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!--/slider-->
		<section id="form">
		<!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-4">
					<div class="signup-form">
						<!--login form-->
						<h2>1분 1초가 아쉬운 당신 회원가입 하세요</h2>
						<spring:hasBindErrors name="customer" />
						<form action="${initParam.rootPath}/customer/add.do" method="post" name="joinForm">
							<font color="red"><form:errors path="customer.customerId" /></font> 
							<input type="text" name="customerId" placeholder="아이디" id = "customerId" /> 
							<input type="button" name="idCheckBtn" value="중복확인" id ="searchJsonBtn"/>
							<font color="red"><form:errors path="customer.customerPassword" /></font>
							<input type="password" name="customerPassword" placeholder="비밀번호" id="pw1"/> 
							<div id="checkPwd"></div>	
							<font color="red"><span class="errorMessage" id="pwErrorMessage"><form:errors path="customer.customerPassword" /></span></font>
							<input type="password" name="customerPasswordCheck" placeholder="비밀번호 재입력" id="pw2" onkeyup="checkPassword()"/> 
							<font color="red"><form:errors path="customer.customerName" /></font>
							<input type="text" name="customerName" placeholder="이름" /> 
							<font color="red"><form:errors path="customer.customerAddress" /></font> 
							<input type="text" name="customerAddress" placeholder="주소(50자 이내)" height="100px" /> 
							<font color="red"><form:errors path="customer.customerBirth" /></font>
							<input type="text" name="customerBirth" placeholder="생년월일 (예 : 20151117)" /> 
							<font color="red"><form:errors path="customer.customerGender" /></font> 
							<table width="100%">
								<tr>
									<td width="20%">
										<h2>남자</h2>
									</td>
									<td><input type="radio" name="customer_gender" value="1" />
									</td>
									<td width="20%">
										<h2>여자</h2>
									</td>
									<td><input type="radio" name="customer_gender" value="2" />
									</td>
								</tr>
							</table>
							<font color="red"><form:errors path="customer.customerPhone" /></font>
							<input type="text" name="customerPhone" placeholder="전화번호 (예: 01012345678)" /> 
							<font color="red"><form:errors path="customer.customerEmail" /></font>
							<table width="100%">
								<tr>
									<td><input type="text" name="customerEmail"
										placeholder="이메일 (예: example@example.com)" /> 
										
									</td>
								</tr>
							</table>
							<input type="hidden" name="customerPoint" value="0" />
							<input type="hidden" name="id_check" id="id_check" value="Y"/>
							<button type="submit" class="btn btn-default" id="checkId">회원가입</button>
						</form>
					</div>
					<!--/login form-->
				</div>
			</div>
		</div>
	</section>
		<!--/form-->
		<footer id="footer"><!--Footer-->
			<div class="footer-top">
				<div class="container">
					<div class="row">
						<div class="col-sm-2">
							<div class="companyinfo">
								<h2>
									<span>P</span>-Line
								</h2>
								<p>윤민석 최정길 강지선 권효균 안동신 김경모</p>
							</div>
						</div>
						<div class="col-sm-7">
							<div class="col-sm-3">
								<div class="video-gallery text-center">
									<a href="#">
										<div class="iframe-img">
											<img src="${initParam.rootPath}/images/home/IMG_0035.JPG" alt="" />
										</div>
										<div class="overlay-icon">
											<i class="fa fa-play-circle-o"></i>
										</div>
									</a>
									<p>Circle of Hands</p>
									<h2>24 DEC 2014</h2>
								</div>
							</div>
							<div class="col-sm-3">
								<div class="video-gallery text-center">
									<a href="#">
										<div class="iframe-img">
											<img src="${initParam.rootPath}/images/home/IMG_0248.PNG" alt="" />
										</div>
										<div class="overlay-icon">
											<i class="fa fa-play-circle-o"></i>
										</div>
									</a>
									<p>Circle of Hands</p>
									<h2>24 DEC 2014</h2>
								</div>
							</div>
							<div class="col-sm-3">
								<div class="video-gallery text-center">
									<a href="#">
										<div class="iframe-img">
											<img src=${initParam.rootPath}/images/home/IMG_0258.PNG alt="" />
										</div>
										<div class="overlay-icon">
											<i class="fa fa-play-circle-o"></i>
										</div>
									</a>
									<p>Circle of Hands</p>
									<h2>24 DEC 2014</h2>
								</div>
							</div>
							<div class="col-sm-3">
								<div class="video-gallery text-center">
									<a href="#">
										<div class="iframe-img">
											<img src="${initParam.rootPath}/images/home/IMG_0362.JPG" alt="" />
										</div>
										<div class="overlay-icon">
											<i class="fa fa-play-circle-o"></i>
										</div>
									</a>
									<p>Circle of Hands</p>
									<h2>24 DEC 2014</h2>
								</div>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="address">
								<img src="${initParam.rootPath}/images/home/map.png" alt="" />
								<p>505 S Atlantic Ave Virginia Beach, VA(Virginia)</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="footer-bottom">
				<div class="container">
					<div class="row">
						<p class="pull-left">Copyright © 2013 E-SHOPPER Inc. All rights
							reserved.</p>
						<p class="pull-right">
							Designed by <span><a target="_blank" href="http://www.themeum.com">Themeum</a></span>
						</p>
					</div>
				</div>
			</div>
		</footer>
		<!--/Footer-->
	
		<script src="${initParam.rootPath}/js/jquery.js"></script>
		<script src="${initParam.rootPath}/js/bootstrap.min.js"></script>
		<script src="${initParam.rootPath}/js/jquery.scrollUp.min.js"></script>
		<script src="${initParam.rootPath}/js/price-range.js"></script>
		<script src="${initParam.rootPath}/js/jquery.prettyPhoto.js"></script>
		<script src="${initParam.rootPath}/js/main.js"></script>
	</body>
</html>