<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Khuyến mãi</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/static/css/bootstrap.min.css">
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<link href="/static/css/promotion.css" rel="stylesheet">
<link rel="stylesheet" href="/static/css/hover-min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/static/css/footer.css">
<link rel="stylesheet" href="/static/css/header.css">
<link rel="stylesheet" href="/static/css/aside.css">
<link rel="stylesheet" href="/static/css/quangcao.css">
</head>
<body>
	<div id="body">
		<%@include file="khachhang/menu.jsp"%>
		<%@include file="khachhang/aside.jsp"%>
		<br>
		<div class="col-sm-9">
			<div class="sanpham1">
				<div class="sanpham2">
					<strong><spring:message code="promotion.title1" /></strong>
				</div>
				<br>
				<div class="left col-sm-9">
					<div class="view-mode">
						<a href="#"
							class="btn button-view-mode view-mode-grid active sapxep"> <i
							class="fa fa-th"></i>
						</a> <a href="#"
							class="btn button-view-mode view-mode-list active sapxep"> <i
							class="fa fa-list"></i>
						</a>
					</div>
				</div>
				<div class="right col-sm-3">
					<h5>
						<label><spring:message code="product.sort"/>: </label> <select class="sapxep">
							<option value="a-z">A-Z</option>
							<option value="a-z">Z-A</option>
							<option value="a-z"><spring:message code="product.sort1" /></option>
							<option value="a-z"><spring:message code="product.sort2" /></option>
							<option value="a-z"><spring:message code="product.sort3" /></option>
						</select>
					</h5>

				</div>
			</div>
			<br> <br>
			<hr>
			<div class="alert alert-warning fade in green-alert" role="alert">
				<button type="button" class="close" data-dissmiss="alert">
					<span aria-hidden="true">x</span> <span class="sr-only">Close</span>
				</button>
				<spring:message code="promotion.title2" />
			</div>
		</div>
	</div>
	</div>
	</div>
	<%@include file="khachhang/quangcao.jsp"%>
	<%@include file="khachhang/footer.jsp"%>

	</div>
</body>
</html>