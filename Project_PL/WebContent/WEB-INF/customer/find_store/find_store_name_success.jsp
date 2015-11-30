<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>편라인 : Project PL</title>
<link href="/Project_PL/css/bootstrap.min.css" rel="stylesheet">
<link href="/Project_PL/css/font-awesome.min.css" rel="stylesheet">
<link href="/Project_PL/css/prettyPhoto.css" rel="stylesheet">
<link href="/Project_PL/css/price-range.css" rel="stylesheet">
<link href="/Project_PL/css/animate.css" rel="stylesheet">
<link href="/Project_PL/css/main.css" rel="stylesheet">
<link href="/Project_PL/css/responsive.css" rel="stylesheet">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="/Project_PL/images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="/Project_PL/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="/Project_PL/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="/Project_PL/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="/Project_PL/images/ico/apple-touch-icon-57-precomposed.png">
</head>
<body>
	<header id="header"><!--header-->
	<div class="header-middle">
		<!--header-middle-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="logo pull-left">
						<a href="${initParam.rootPath }/basic/item_list.do"><img
							src="${initParam.rootPath }/images/pline.png" alt="" /></a>
					</div>
				</div>
				<div class="col-sm-8">
					<div class="shop-menu pull-right">
						<ul class="nav navbar-nav">
							<li><a href="">${sessionScope.hello }님반갑습니다.<i
									class="fa fa-user"></i>
									<li><a href="login.html"><i class="fa fa-user"></i>
											마이페이지</a></li>
									<li><a href="login.html"><i
											class="fa fa-shopping-cart"></i> 장바구니</a></li>
									<li><a href="${initParam.rootPath }/basic/index.do"><i
											class="fa fa-lock"></i> 로그아웃</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/header-middle--> 
	</header>
	<script type="text/javascript" src="/Project_PL/script/jquery.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#categoryIdChk").on("click", function() {
				var chk = document.findStoreForm.categoryId.value;
				if (chk == "default") {
					alert("카테고리를 선택해 주세요");
					return false;
				} else {
					return true;
				}
			});
		});
	</script>
	
	
	<section id="slider"><!--slider-->
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div id="slider-carousel" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#slider-carousel" data-slide-to="0"
							class="active"></li>
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
								<img src="/Project_PL/images/home/girl1.jpg"
									class="girl img-responsive" alt="" /> <img
									src="/Project_PL/images/home/pricing.png" class="pricing"
									alt="" />
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
								<img src="/Project_PL/images/home/girl2.jpg"
									class="girl img-responsive" alt="" /> <img
									src="/Project_PL/images/home/pricing.png" class="pricing"
									alt="" />
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
								<img src="/Project_PL/images/home/girl3.jpg"
									class="girl img-responsive" alt="" /> <img
									src="/Project_PL/images/home/pricing.png" class="pricing"
									alt="" />
							</div>
						</div>

					</div>

					<a href="#slider-carousel" class="left control-carousel hidden-xs"
						data-slide="prev"> <i class="fa fa-angle-left"></i>
					</a> <a href="#slider-carousel"
						class="right control-carousel hidden-xs" data-slide="next"> <i
						class="fa fa-angle-right"></i>
					</a>
				</div>

			</div>
		</div>
	</div>
	</section>
	<!--/slider-->

	<section>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="left-sidebar">
					<h2>카테고리</h2>
					<div class="panel-group category-products" id="accordian">
						<!--category-productsr-->
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordian" href="#food">
										<span class="badge pull-right"><i class="fa fa-plus"></i></span>
										물품 검색
									</a>
								</h4>
							</div>
							<div id="food" class="panel-collapse collapse">
								<div class="panel-body">
									<ul>
										<li><a
											href="${initParam.rootPath }/customer/form_food.do?categoryId=1">식품</a></li>
										<li><a
											href="${initParam.rootPath }/customer/form_beverage.do?categoryId=2">음료</a></li>
										<li><a
											href="${initParam.rootPath }/customer/form_snack.do?categoryId=3">과자</a></li>
										<li><a
											href="${initParam.rootPath }/customer/form_icecream.do?categoryId=4">아이스크림</a></li>
										<li><a
											href="${initParam.rootPath }/customer/form_daily.do?categoryId=5">생활용품</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordian"
										href="#beverage"> <span class="badge pull-right"><i
											class="fa fa-plus"></i></span> 편의점 검색
									</a>
								</h4>
							</div>
							<div id="beverage" class="panel-collapse collapse">
								<div class="panel-body">
									<ul>
										<li><a
											href="${initParam.rootPath }/customer/find_store_name_form.do">매장명
												검색</a></li>
										<li><a href="#">지역검색</a></li>
										<li><a
											href="${initParam.rootPath }/customer/find_store_nearby.do">주변
												편의점</a></li>
									</ul>
								</div>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a href="#">게시판</a>
								</h4>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a href="#">고객센터</a>
								</h4>
							</div>
						</div>
					</div>
					<!--/category-products-->
				</div>
			</div>

			


			<div class="col-sm-9 padding-right">
				<div class="features_items">
					<!--features_items-->
					<h2 class="title text-center">매장 검색</h2>
					<!-- <section id="form"> -->
					<!--form-->
					<div class="container">
						<div class="row">
							<div class="col-sm-4 col-sm-offset-2">
								<div class="signup-form">
									<div style="Text-align: center; padding: 30px; border: 1px;">
									</div>
									<!--login form-->
									<h2>매장 검색 결과</h2>
									<%-- <spring:hasBindErrors name="customer"/> --%>
									<c:forEach items="${requestScope.findstore }" var="fs"
										begin="0" end="10">
										<form action="/Project_PL/customer/find_store_categoryPage.do" method="post" name="findStoreForm">
											<table border="1" style="width: 700px">
												<tr>
													<td>매장명</td>
													<td>매장주소</td>
													<td>매장번호</td>
												</tr>
												<tr>
													<td>${fs.storeName }</td>
													<td>${fs.storeAddress }</td>
													<td>${fs.storePhone }</td>
												</tr>
											</table>
											<!-- 지도 div -->
											<div id="daumRoughmapContainer${fs.storeTimeStamp}" class="root_daum_roughmap root_daum_roughmap_landing"></div>
											
											<table>
												<th><select name="categoryId">
														<option value="default">품목을 선택해 주세요.</option>
														<option value="2">음료</option>
														<option value="5">생활용품</option>
														<option value="1">식품</option>
														<option value="4">아이스크림</option>
														<option value="3">과자</option>
													</select> 
													<input type="hidden" name="storeId" value="${fs.storeId}" />
													<button type="submit" class="btn btn-default" id="categoryIdChk" >이동</button></th>
											</table>
										</form>
										</br>
										
										<!-- 지도스크립트 폼 -->
										<script charset="UTF-8" class="daum_roughmap_loader_script" src="http://dmaps.daum.net/map_js_init/roughmapLoader.js"></script>

										<!-- 실행 스크립트 -->
										<script charset="UTF-8">
											new daum.roughmap.Lander(
													{
														"timestamp" : "${fs.storeTimeStamp}", 
														"key" : "${fs.storeKey}",
														"mapWidth" : "360",
														"mapHeight" : "250"
													}).render();
										</script>
									</c:forEach>
									<div style="Text-align: center; padding: 80px; border: 1px;"></div><!-- 밑공백넣어줄려고 이렇게함 -->
								</div>
								<!--/login form-->
							</div>
						</div>
					</div>
					<!-- </section> -->



				</div>
				<!--features_items-->



			</div>
		</div>
	</div>
	</section>

	<footer id="footer"><!--Footer-->
	<div class="footer-top">
		<div class="container">
			<div class="row">
				<div class="col-sm-2">
					<div class="companyinfo">
						<h2>
							<span>e</span>-shopper
						</h2>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing
							elit,sed do eiusmod tempor</p>
					</div>
				</div>
				<div class="col-sm-7">
					<div class="col-sm-3">
						<div class="video-gallery text-center">
							<a href="#">
								<div class="iframe-img">
									<img src="/Project_PL/images/home/iframe1.png" alt="" />
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
									<img src="/Project_PL/images/home/iframe2.png" alt="" />
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
									<img src=/Project_PL /"images/home/iframe3.png" alt="" />
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
									<img src="/Project_PL/images/home/iframe4.png" alt="" />
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
						<img src="/Project_PL/images/home/map.png" alt="" />
						<p>505 S Atlantic Ave Virginia Beach, VA(Virginia)</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="footer-widget">
		<div class="container">
			<div class="row">
				<div class="col-sm-2">
					<div class="single-widget">
						<h2>Service</h2>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="#">Online Help</a></li>
							<li><a href="#">Contact Us</a></li>
							<li><a href="#">Order Status</a></li>
							<li><a href="#">Change Location</a></li>
							<li><a href="#">FAQ’s</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="single-widget">
						<h2>Quock Shop</h2>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="#">T-Shirt</a></li>
							<li><a href="#">Mens</a></li>
							<li><a href="#">Womens</a></li>
							<li><a href="#">Gift Cards</a></li>
							<li><a href="#">Shoes</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="single-widget">
						<h2>Policies</h2>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="#">Terms of Use</a></li>
							<li><a href="#">Privecy Policy</a></li>
							<li><a href="#">Refund Policy</a></li>
							<li><a href="#">Billing System</a></li>
							<li><a href="#">Ticket System</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="single-widget">
						<h2>About Shopper</h2>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="#">Company Information</a></li>
							<li><a href="#">Careers</a></li>
							<li><a href="#">Store Location</a></li>
							<li><a href="#">Affillate Program</a></li>
							<li><a href="#">Copyright</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-3 col-sm-offset-1">
					<div class="single-widget">
						<h2>About Shopper</h2>
						<form action="#" class="searchform">
							<input type="text" placeholder="Your email address" />
							<button type="submit" class="btn btn-default">
								<i class="fa fa-arrow-circle-o-right"></i>
							</button>
							<p>
								Get the most recent updates from <br />our site and be updated
								your self...
							</p>
						</form>
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
					Designed by <span><a target="_blank"
						href="http://www.themeum.com">Themeum</a></span>
				</p>
			</div>
		</div>
	</div>

	</footer>
	<!--/Footer-->


	<script src="/Project_PL/js/jquery.js"></script>
	<script src="/Project_PL/js/bootstrap.min.js"></script>
	<script src="/Project_PL/js/jquery.scrollUp.min.js"></script>
	<script src="/Project_PL/js/price-range.js"></script>
	<script src="/Project_PL/js/jquery.prettyPhoto.js"></script>
	<script src="/Project_PL/js/main.js"></script>
</body>
</html>