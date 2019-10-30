<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giới thiệu</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/bootstrap.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/static/css/hover-min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/css/header.css">
    <link rel="stylesheet" href="/static/css/footer.css">
    <link rel="stylesheet" href="/static/css/aside.css">
    <link rel="stylesheet" href="/static/css/gioithieu.css">
    <link rel="stylesheet" href="/static/css/quangcao.css">
</head>
<body>
<div id="body">
<%@include file="khachhang/menu.jsp" %>
<%@include file="khachhang/aside.jsp" %>
	<br>
<div class="col-sm-9">
                    <div class="blog-heading">
                        <h3 class="title-1">Tin TTH.VN</h3>
                    </div>
                    <div class="divider-full-1"></div>
                    <div class="col-sm-6">
                        <picture>
                            <img src="/static/Image/gioithieu.jpg">
                        </picture>
                    </div>
                    <div class="col-sm-6">

                        <div class="blog-caption">
                            <h4 class="sub-title-1">Ngày đăng: 16/05/2019</h4>
                            <h3 class="title-2"><a href="#">Thông báo sử dụng hóa đơn VAT điện tử</a> </h3>
                            <div class="ptb-10">
                                <p>Thưa Quý khách hàng!Khoáikhẩu.vn là thương hiệu trực thuộc Công ty Cổ phần SB FOODS.
                                    Kể từ ngày 18/6/2018, Công ty Cổ phần SB FOODS chuyển sang sử dụng hóa đơn VAT điện tử. Vì vậy khi đến thưởng thức...</p>
                            </div>
                            <a href="#"><strong>Chi tiết<i class="fa fa-long-arrow-right"></i> </strong></a>

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