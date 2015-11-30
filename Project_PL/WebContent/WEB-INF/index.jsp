<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% if(session.getAttribute("sessionUser")!= null) {
      session.invalidate();   
}   
%>
<!DOCTYPE html>
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
		<link rel="shortcut icon" href="${initParam.rootPath }/images/ico/favicon.ico">
		<link rel="apple-touch-icon-precomposed" sizes="144x144" href="${initParam.rootPath }/images/ico/apple-touch-icon-144-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="114x114" href="${initParam.rootPath }/images/ico/apple-touch-icon-114-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="72x72" href="${initParam.rootPath }/images/ico/apple-touch-icon-72-precomposed.png">
		<link rel="apple-touch-icon-precomposed" href="${initParam.rootPath }/images/ico/apple-touch-icon-57-precomposed.png">
	</head>
	<body>
		<header id="header"><!--header-->
			<div class="header-middle">
				<!--header-middle-->
				<div class="container">
					<div class="row">
						<div class="col-sm-4">
							<div class="logo pull-left">
								<a href="${initParam.rootPath }/basic/item_list.do"><img src="${initParam.rootPath }/images/pline.png" alt="" /></a>
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
			</div><!--/header-middle--> 
		</header><!--/header-->
		<section id="slider"><!--slider-->
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<div id="slider-carousel" class="carousel slide" data-ride="carousel">
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
										<img src="${initParam.rootPath }/images/home/girl1.jpg" class="girl img-responsive" alt="" /> 
										<img src="${initParam.rootPath }/images/home/pricing.png" class="pricing" alt="" />
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
										<img src="${initParam.rootPath }/images/home/girl2.jpg" class="girl img-responsive" alt="" /> 
										<img src="${initParam.rootPath }/images/home/pricing.png" class="pricing" alt="" />
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
										<img src="${initParam.rootPath }/images/home/girl3.jpg" class="girl img-responsive" alt="" /> 
										<img src="${initParam.rootPath }/images/home/pricing.png" class="pricing" alt="" />
									</div>
								</div>
							</div>
							<a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev"> 
								<i class="fa fa-angle-left"></i></a> <a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next"> 
								<i class="fa fa-angle-right"></i>
							</a>
						</div>
					</div>
				</div>
			</div>
		</section><!--/slider-->
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
												<li><a href="${initParam.rootPath }/basic/back_home.do">식품</a></li>
												<li><a href="${initParam.rootPath }/basic/back_home.do">음료</a></li>
												<li><a href="${initParam.rootPath }/basic/back_home.do">과자</a></li>
												<li><a href="${initParam.rootPath }/basic/back_home.do">아이스크림</a></li>
												<li><a href="${initParam.rootPath }/basic/back_home.do">생활용품</a></li>
											</ul>
										</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordian" href="#beverage"> 
												<span class="badge pull-right">
												<i class="fa fa-plus"></i></span> 편의점 검색
											</a>
										</h4>
									</div>
									<div id="beverage" class="panel-collapse collapse">
										<div class="panel-body">
											<ul>
												<li><a href="${initParam.rootPath }/basic/back_home.do">매장명 검색</a></li>
												<li><a href="${initParam.rootPath }/basic/back_home.do">지역 검색</a></li>
												<li><a href="${initParam.rootPath }/basic/back_home.do">주변 편의점</a></li>
											</ul>
										</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title"><a href="#">게시판</a></h4>
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
							<h2 class="title text-center">물품</h2>
							<c:forEach items="${requestScope.product }" var="pd" begin="0" end="5">
								<div class="col-sm-4">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="${initParam.rootPath }/images/${pd.categoryId }/${pd.itemName }.png" alt="" />
												<h2>${pd.itemPrice}</h2>
												<p>${pd.itemName }</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>장바구니 담기</a>
											</div>
											<div class="product-overlay">
												<div class="overlay-content">
													<h2>${pd.itemPrice}</h2>
													<p>${pd.itemName }</p>
													<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>장바구니 담기</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>	
						</div>
						<!--features_items-->
						<div class="recommended_items">
							<!--recommended_items-->
							<h2 class="title text-center">추천 물품</h2>
							<div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
								<div class="carousel-inner">
									<div class="item active">
										<c:forEach items="${requestScope.product }" var="pd" begin="6" end="8">
											<div class="col-sm-4">
												<div class="product-image-wrapper">
													<div class="single-products">
														<div class="productinfo text-center">
															<img src="${initParam.rootPath }/images/${pd.categoryId }/${pd.itemName }.png" alt="" />
															<h2>${pd.itemPrice}</h2>
															<p>${pd.itemName }</p>
															<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>장바구니 담기</a>
														</div>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
									<div class="item">
										<c:forEach items="${requestScope.product }" var="pd" begin="9" end="11">
											<div class="col-sm-4">
												<div class="product-image-wrapper">
													<div class="single-products">
														<div class="productinfo text-center">
															<img src="${initParam.rootPath }/images/${pd.categoryId }/${pd.itemName }.png" alt="" />
															<h2>${pd.itemPrice}</h2>
															<p>${pd.itemName }</p>
															<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>장바구니 담기</a>
														</div>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
								<a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev"> 
									<i class="fa fa-angle-left"></i>
								</a> 
								<a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next"> 
									<i class="fa fa-angle-right"></i>
								</a>
							</div>
						</div>
						<!--/recommended_items-->
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
										<img src="${initParam.rootPath }/images/home/IMG_0035.JPG" alt="" />
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
										<img src="${initParam.rootPath }/images/home/IMG_0248.PNG" alt="" />
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
										<img src=${initParam.rootPath }/images/home/IMG_0258.PNG alt="" />
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
										<img src="${initParam.rootPath }/images/home/IMG_0362.JPG" alt="" />
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
							<img src="${initParam.rootPath }/images/home/map.png" alt="" />
							<p>505 S Atlantic Ave Virginia Beach, VA(Virginia)</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left">Copyright © 2013 E-SHOPPER Inc. All rights reserved.</p>
					<p class="pull-right">
						Designed by <span><a target="_blank" href="http://www.themeum.com">Themeum</a></span>
					</p>
				</div>
			</div>
		</div>
		</footer>
		<!--/Footer-->

		<script src="${initParam.rootPath }/js/jquery.js"></script>
		<script src="${initParam.rootPath }/js/bootstrap.min.js"></script>
		<script src="${initParam.rootPath }/js/jquery.scrollUp.min.js"></script>
		<script src="${initParam.rootPath }/js/price-range.js"></script>
		<script src="${initParam.rootPath }/js/jquery.prettyPhoto.js"></script>
		<script src="${initParam.rootPath }/js/main.js"></script>
	</body>
</html>