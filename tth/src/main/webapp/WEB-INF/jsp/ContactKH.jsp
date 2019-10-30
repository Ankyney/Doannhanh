<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title><spring:message code="contact.title"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/bootstrap.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/static/css/hover-min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/static/css/header.css">
    <link rel="stylesheet" href="/static/css/footer.css">
    <link rel="stylesheet" href="/static/css/contact.css">
    <link rel="stylesheet" href="/static/css/quangcao.css">
</head>
<body>
<div id="body">
<%@include file="khachhang/menu.jsp" %>
<section class="contact-wrap sec-space-bottom">
    <div class="container rel-div pt-50">
        <div class="row">
            <div class="col-md-8">
                <div class="contact-map">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.041935724356!
                    2d105.78306571493263!3d21.031007985997093!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1
                    !3m3!1m2!1s0x3135ab4b864c2cb7%3A0xebda3d1c091131c3!2zS2hvYWlraGF1LnZuIC0gQ8ahIH
                    Phu58gMSAtIER1eSBUw6Ju!5e0!3m2!1svi!2s!4v1557366273134!5m2!1svi!2s" width="100%"
                            height="300px" frameborder="0" style="boder:0" allowfullscreen></iframe>
                </div>
            </div>
            <div class="col-md-4">
                <div class="contact-details">
                    <h1 class="fsz-20">
                        <span class="light-font">TTH.VN - <spring:message code="contact.title1"/></span>
                    </h1>
                    <h5 class="clr-txt fsz-12 pt-15">TTH.VN</h5>
                    <ul>
                        <li class="diachi">
                            <strong style="color: #999999"><spring:message code="contact.title2"/>:</strong>
                            <i style="color: #525252">Số 8 ngõ 36 Duy Tân, Cầu Giấy, Hà Nội</i>
                        </li>
                        <li class="diachi">
                            <strong style="color: #999999"><spring:message code="contact.title3"/>:</strong>
                            <i>
                                <a href="#" style="color: #525252">0972.666.368</a>
                                <a href="#" style="color: #525252">0972.666.368</a>
                                <a href="#" style="color: #525252">0972.666.368</a>
                            </i>
                        </li>
                        <li class="diachi">
                            <strong style="color: #999999">Email:</strong>
                            <i><a href="#" style="color: #525252">contact@tth.vn</a> </i>
                        </li>
                    </ul>
                    <p></p>
                </div>
            </div>
            <div class="col-md-8 col-md-offset-2">
                <h3 class="fsz-25 text-center">
                    <span class="light-font"><spring:message code="contact.title4"/> TTH.VN</span>
                </h3>
                <h6 class="sub-title-1 text-center">
                    <spring:message code="contact.title5"/>
                </h6>
                <div class="contact-form pt-50">
                    <form class="contact-form has-validation-callback" method="post">
                        <input name="form-type" type="hidden" value="contact">
                        <input name="utf8" type="hidden" value="✓">
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <input class="form-control" placeholder="<spring:message code="contact.label1"/>" data-validation="required" required type="text">
                            </div>
                            <div class="form-group col-sm-6">
                                <input class="form-control" placeholder="Email" data-validation="email" required type="email"
                                       pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,63}$" data-validation-error-msg="Email sai định dạng">
                            </div>
                            <div class="form-group col-sm-12">
                                <textarea style="resize:none" class="form-control" placeholder="<spring:message code="contact.label2"/>" cols="102" rows="5"
                                          data-validation-error-msg="Không được để trống" data-validation="required" required></textarea>
                            </div>
                            <div class="text-banner col-sm-12 form-group">
                                <button href="#" class="navbar-btn btn-tinnhan"><spring:message code="contact.btn1"/></button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
 <%@include file="khachhang/quangcao.jsp" %>
	<%@include file="khachhang/footer.jsp" %>
</div>
</body>
</html>