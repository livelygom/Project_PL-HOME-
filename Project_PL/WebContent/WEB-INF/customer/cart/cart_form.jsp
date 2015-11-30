<%@page import="kr.or.kosta.pl.vo.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>편라인 : Project PL</title>
    <link href="${initParam.rootPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${initParam.rootPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${initParam.rootPath}/css/prettyPhoto.css" rel="stylesheet">
    <link href="${initParam.rootPath}/css/price-range.css" rel="stylesheet">
    <link href="${initParam.rootPath}/css/animate.css" rel="stylesheet">
	<link href="${initParam.rootPath}/css/main.css" rel="stylesheet">
	<link href="${initParam.rootPath}/css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="${initParam.rootPath}/images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${initParam.rootPath}/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${initParam.rootPath}/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${initParam.rootPath}/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${initParam.rootPath}/images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->
<script type="text/javascript">
   function order() {
      var cart = confirm("주문 하시겠습니까?");
         if(cart){
            return true;
         }else{
            return false;
         }
   }
</script>
<body>
	<header id="header"><!--header-->
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="${initParam.rootPath }/basic/item_list.do"><img src="${initParam.rootPath}/images/pline.png" alt="" /></a> 
							&nbsp&nbsp&nbsp<b>${sessionScope.sessionUser.customerName }</b>님 환영합니다.
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
							<li><a href="${initParam.rootPath }/customer/mypage.do"><i class="fa fa-user"></i>마이페이지</a></li>
								<li><a href="${initParam.rootPath}/customer/cartpage.do"><i class="fa fa-shopping-cart"></i> 장바구니</a></li>
								<li><a href="${initParam.rootPath}/basic/index.do"><i class="fa fa-lock"></i> 로그아웃</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	</header><!--/header-->
			<c:choose>
				<c:when test="${empty requestScope.cart}">
				
				<section id="cart_items">
					<div class="container">
						<div class="breadcrumbs">
							<ol class="breadcrumb">
							  <li><a>편라인</a></li>
							  <li class="active">Shopping Cart</li>
							</ol>
						</div>
						<div class="heading">
								<h3><b>장바구니에 담아 놓은 물건이 없습니다.</b></h3>
								<p>이용해 주셔서 감사합니다. 즐거운 쇼핑 되시기 바랍니다.</p>
								<h5><b>&nbsp</b></h5>
							</div>
							<div class="table-responsive cart_info">
								<table class="table table-condensed">
									<thead>
										<tr class="cart_menu">
											<td class="image">상품</td>
											<td class="description"></td>
											<td class="price">주문 편의점</td>
											<td class="price">가격</td>
											<td class="quantity">수량</td>
											<td class="total">총 가격</td>
											<td></td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td class="cart_product">
												<a href=""><img src="${initParam.rootPath}/images/pline.png" alt=""></a>
											</td>
											<td class="cart_description">
												<h4>편라인</h4>
												<p>분류: project</p>
											</td>
											<td class="cart_price">
												<p>판교</p>
											</td>
											<td class="cart_price">
												<p>999999원</p>   
											</td>
											<td class="cart_quantity">
												<div class="cart_quantity_button">
						
													<input class="cart_quantity_input" readonly="readonly" name="quantity" value="1" autocomplete="off" size="2">
													<div>&nbsp개</div>
													
												</div>
											</td>
											<td class="cart_total">
												<p class="cart_total_price">$$$$$</p>
											</td>
											<td class="cart_delete">
												<a class="cart_quantity_delete"><i class="fa fa-times"></i></a>
											</td>
										</tr>		
									</tbody>
								</table>
							</div>
					</div>
				</section><!--/#do_action-->
				
				<section id="do_action">
						<div class="container">
						<div class="heading">
							<h3><b>&nbsp</b></h3>
							<h3><b>&nbsp</b></h3>
							<h3><b>&nbsp</b></h3>
							<h3><b>&nbsp</b></h3>
							<h3><b>&nbsp</b></h3>
							<h3><b>&nbsp</b></h3>
						</div>
					</div>
				</section>

				</c:when>

				<c:otherwise>
				<form action="${initParam.rootPath}/customer/order.do" onsubmit="return order();">
					<section id="cart_items">
						<div class="container">
							<div class="breadcrumbs">
								<ol class="breadcrumb">
								  <li><a>편라인</a></li>
								  <li class="active">Shopping Cart</li>
								</ol>
							</div>
							<div class="heading">
								<h3><b>주문 전 확인해 주세요.</b></h3>
								<p>고객님께서 주문하신 편의점, 물품, 주문 금액 정보입니다. 다시한번 확인 해 주세요.</p>
							</div>
							
							<div class="table-responsive cart_info">
								<table class="table table-condensed">
									<thead>
										<tr class="cart_menu">
											<td class="image">상품</td>
											<td class="description"></td>
											<td class="price">주문 편의점</td>
											<td class="price">가격</td>
											<td class="quantity">수량</td>
											<td class="total">총 가격</td>
											<td></td>
										</tr>
									</thead>
									<tbody>
									<%int sum=0; %>
									<c:forEach items="${requestScope.cart }" var="cart">
										<tr>
											<td class="cart_product">
												<a href=""><img src="${initParam.rootPath}/images/${cart.categoryId }/${cart.itemName }.png" alt=""></a>
											</td>
											<td class="cart_description">
												<h4>${cart.itemName }</h4>
												<p>분류: ${cart.categoryName }</p>
											</td>
											<td class="cart_price">
												<p>${cart.storeName }</p>
											</td>
											<td class="cart_price">
												<p>${cart.itemPrice }원</p>   
											</td>
											<td class="cart_quantity">
												<div class="cart_quantity_button">
						
													<input class="cart_quantity_input" readonly="readonly" name="quantity" value="${cart.cartCount }" autocomplete="off" size="2">
													<div>&nbsp개</div>
													
												</div>
											</td>
											<td class="cart_total">
												<p class="cart_total_price">${cart.totalPrice }원</p>
											</td>
											<td class="cart_delete">
												<a class="cart_quantity_delete" href="${initParam.rootPath}/customer/deleteCart.do?customerId=${cart.customerId}&storeId=${cart.storeId}&itemId=${cart.itemId}"><i class="fa fa-times"></i></a>
											</td>
										</tr>
										<%sum = sum +(int)((Cart)pageContext.getAttribute("cart")).getTotalPrice(); %>		
										<input type="hidden" name="customerId" value="${cart.customerId }">  <!-- 1개 -->
										<input type="hidden" name="storeId" value="${cart.storeId }">
										<input type="hidden" name="itemId" value="${cart.itemId }">
										<input type="hidden" name="orderCount" value="${cart.cartCount }">
										<input type="hidden" name="orderStatus" value="1">		
									</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</section> <!--/#cart_items-->
							
					<section id="do_action">
						<div class="container">
							<div class="heading">
								<h3><b>주문 총금액: <%=sum  %>원</b></h3>
								주문하시겠습니까?&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								<input type="submit" value="주문하기">
							</div>
						</div>
					</section><!--/#do_action-->
					</form>
				</c:otherwise>
			</c:choose>
			
			
			
	<footer id="footer"><!--Footer-->
		<div class="footer-top">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="companyinfo">
							<h2><span>e</span>-shopper</h2>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,sed do eiusmod tempor</p>
						</div>
					</div>
					<div class="col-sm-7">
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="${initParam.rootPath}/images/home/iframe1.png" alt="" />
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
										<img src="${initParam.rootPath}/images/home/iframe2.png" alt="" />
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
										<img src="${initParam.rootPath}/images/home/iframe3.png" alt="" />
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
										<img src="${initParam.rootPath}/images/home/iframe4.png" alt="" />
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
		
		<div class="footer-widget">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Service</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">Online Help</a></li>
								<li><a href="">Contact Us</a></li>
								<li><a href="">Order Status</a></li>
								<li><a href="">Change Location</a></li>
								<li><a href="">FAQ’s</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Quock Shop</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">T-Shirt</a></li>
								<li><a href="">Mens</a></li>
								<li><a href="">Womens</a></li>
								<li><a href="">Gift Cards</a></li>
								<li><a href="">Shoes</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Policies</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">Terms of Use</a></li>
								<li><a href="">Privecy Policy</a></li>
								<li><a href="">Refund Policy</a></li>
								<li><a href="">Billing System</a></li>
								<li><a href="">Ticket System</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>About Shopper</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">Company Information</a></li>
								<li><a href="">Careers</a></li>
								<li><a href="">Store Location</a></li>
								<li><a href="">Affillate Program</a></li>
								<li><a href="">Copyright</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3 col-sm-offset-1">
						<div class="single-widget">
							<h2>About Shopper</h2>
							<form action="#" class="searchform">
								<input type="text" placeholder="Your email address" />
								<button type="submit" class="btn btn-default"><i class="fa fa-arrow-circle-o-right"></i></button>
								<p>Get the most recent updates from <br />our site and be updated your self...</p>
							</form>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left">Copyright © 2013 E-SHOPPER Inc. All rights reserved.</p>
					<p class="pull-right">Designed by <span><a target="_blank" href="http://www.themeum.com">Themeum</a></span></p>
				</div>
			</div>
		</div>
		
	</footer><!--/Footer-->
	


    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>