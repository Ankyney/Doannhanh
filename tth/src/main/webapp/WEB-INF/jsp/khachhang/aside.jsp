<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="product-khuyen-mai">
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <div class="panel-group" id="accordion">
                    <!--Category-->
                    <div class="panel panel-danger">
                        <div class="panel-heading pa">
                            <span class="glyphicon glyphicon-th-list"></span>
                            <spring:message code="aside.as1"/>
                        </div>
                        <p>
                      
                        <div class="list-group">
                            <a class="san-pham-dow" href="#"><spring:message code="aside.as13"/></a><i class="fa fa-angle-down" aria-hidden="true" data-toggle="collapse" data-parent="#accordion" href="#1"></i>
                        </div>
                        </p>
                        <div id="1" class="list-group panel-collapse collapse in">
                            <div class="list-group">
                            <strong>
                                <p><a class="san-pham-dowsp" href="#"><spring:message code="aside.as2"/></a></p>
                                <p> <a class="san-pham-dowsp" href="#">ĂN VẶT ĐẶC SẮC</a></p>
                                <p><a class="san-pham-dowsp" href="#"><spring:message code="aside.as4"/></a></p>
                                <p><a class="san-pham-dowsp" href="#"><spring:message code="aside.as5"/></a></p>
                                <p><a class="san-pham-dowsp" href="#"><spring:message code="aside.as6"/></a></p>
                                <p><a class="san-pham-dowsp" href="#"><spring:message code="aside.as7"/></a></p>
                                <p><a class="san-pham-dowsp" href="#">CARAMEN, <spring:message code="aside.as8"/></a></p>
                                <p><a class="san-pham-dowsp" href="#"><spring:message code="aside.as9"/></a></p>
                             </strong>
                            </div>
                        </div>
                        <p><a class="san-pham-dow duoi-dow" href="#"><spring:message code="aside.as10"/></a></p>
                        <p><a class="san-pham-dow duoi-dow" href="#"><spring:message code="aside.as11"/></a> </p>
                        <p><a class="san-pham-dow duoi-dow" href="#"><spring:message code="aside.as12"/></a> </p>
                    </div>
                   
                    <!--/Category-->
                </div>
                <!--locsanpham-->
                <h3><spring:message code="aside.as14"/></h3>
                <h5><strong><spring:message code="aside.as15"/></strong></h5>
                <div class="row">
                    <div class="col-sm-5">
                        <div class="locsanpham">
                            <br>
                            <p><input type="checkbox"> <label class="filter"><spring:message code="aside.as17"/></label></p>
                            <p><input type="checkbox"> <label class="filter"><spring:message code="aside.as18"/></label></p>
                            <p><input type="checkbox"> <label class="filter"><spring:message code="aside.as19"/></label></p>
                            <p><input type="checkbox"> <label class="filter"><spring:message code="aside.as19"/></label></p>
                            <p><input type="checkbox"> <label class="filter"><spring:message code="aside.as20"/></label></p>
                            <p><input type="checkbox"> <label class="filter"><spring:message code="aside.as21"/></label></p>
                            <p><input type="checkbox"> <label class="filter">Caramen</label></p>
                            <p><input type="checkbox"> <label class="filter"><spring:message code="aside.as22"/></label></p>
                        </div>
                    </div>
                </div>
                <!--sanphambanchay-->
                <h3><spring:message code="aside.as23"/></h3>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="locsanpham">
                            <br>
                            <div class="locsanpham1">
                                <img src="/static/Image/doan1.jpg" width="91px" height="81px">
                                <label>Chân gà CP chiên mắm</label>
                                <label style="color: orange">7,000đ</label> <strike>10,000đ</strike>
                            </div>
                            <br>
                            <div class="locsanpham1">
                                <img src="/static/Image/doan2.jpg" width="91px" height="81px">
                                <label>Chân gà CP ngâm xả ớt</label>
                                <label style="color: orange">7,000đ</label> <strike>10,000đ</strike>
                            </div>
                            <br>
                            <div class="locsanpham1">
                                <img src="/static/Image/doan3.jpg" width="91px" height="81px">
                                <label>Chân gà CP rang muối</label>
                                <label style="color: orange">7,000đ</label> <strike>10,000đ</strike>
                            </div>
                            <br>
                            <div class="locsanpham1">
                                <img src="/static/Image/doan4.jpg" width="91px" height="81px">
                                <label>Nem chua nướng</label></p>
                                <label style="color: orange">7,000đ</label> <strike>10,000đ</strike>
                            </div>
                        </div>
                    </div>
                    <!--sanpham-->
                </div>

            </div>
        
           
