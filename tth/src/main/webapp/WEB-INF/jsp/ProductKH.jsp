<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title><spring:message code="product.title"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/bootstrap.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <link href="/static/css/Style_product.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/hover-min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/static/css/footer.css">
    <link rel="stylesheet" href="/static/css/header.css">
    <link rel="stylesheet" href="/static/css/aside.css">
    <link rel="stylesheet" href="/static/css/quangcao.css">
</head>
<body>
<div id="body">
	<%@include file="khachhang/menu.jsp" %>
	<%@include file="khachhang/aside.jsp" %>
	<br>
	                    <div class="col-sm-9">
                        <div class="product">
                            <div class="title"><strong><spring:message code="product.title1"/></strong></div>
                            <div class="title1"><spring:message code="product.title2"/></div>
                            <br>
                            <div class="left col-sm-9">
                                <div class="view-mode">
                                    <a href="#" class="btn button-view-mode view-mode-grid active sapxep">
                                        <i class="fa fa-th"></i>
                                    </a>
                                    <a href="#" class="btn button-view-mode view-mode-list active sapxep">
                                        <i class="fa fa-list"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="right col-sm-3">
                                <h5><label><spring:message code="product.sort"/>: </label>
                                    <select class="sapxep">
                                        <option value="a-z">A-Z</option>
                                        <option value="a-z">Z-A</option>
                                        <option value="a-z"><spring:message code="product.sort1"/></option>
                                        <option value="a-z"><spring:message code="product.sort2"/></option>
                                        <option value="a-z"><spring:message code="product.sort3"/></option>
                                    </select>
                                </h5>
                            </div>
                            <br>
                            <br>
                            <hr>
                                    <div class="su">
                                        <img class="anh-sp" src="/static/Image/Sanpham/canh-ga-chien-mam_ed6ac332cea64a729cd3ba45af78216b_large.jpg" />
                                        <div class="noi-dung-ten-gia">
                                            <a href="#" class="ten-san-pham">Ếch chiên mắm</a>
                                            <p class="giá-sp">70.000đ</p>
                                        </div>
                                    </div>
                                    <div class="su">
                                        <img class="anh-sp" src="/static/Image/Sanpham/canh-ga-chien-mam_ed6ac332cea64a729cd3ba45af78216b_large.jpg" />
                                        <div class="noi-dung-ten-gia">
                                            <a href="#" class="ten-san-pham">Ếch rang muối</a>
                                            <p class="giá-sp">70.000đ</p>
                                        </div>
                                    </div>

                                    <div class="su">
                                        <img class="anh-sp" src="/static/Image/Sanpham/canh-ga-chien-mam_ed6ac332cea64a729cd3ba45af78216b_large.jpg" />
                                        <div class="noi-dung-ten-gia">
                                            <a href="#" class="ten-san-pham">Nộm chân gà rút xương</a>
                                            <p class="giá-sp">70.000đ</p>
                                        </div>
                                    </div>
                        </div>
                    </div>
                    </div>
                    </div>
                    </div>
                   
     
    <%@include file="khachhang/quangcao.jsp" %>
	<%@include file="khachhang/footer.jsp" %>

</div>
</body>
</html>