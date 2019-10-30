<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script>
		$(function() {
			$("a[data-lang]").click(function() {
				var lang = $(this).attr("data-lang");
				$.get("home.htm?language=" + lang, function() {
					location.reload();
				});
				return false;
			});
		});
</script>
 <div id="header">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="tope">
                <div class="row header1_top">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4">
                        <div class="logo-ct">
                            <a href="#">
                                <img src="/static/Image/50402515_1120675448092448_7984809958107512832_n.png">
                            </a>
                        </div>
                    </div>


                    <div class="col-sm-2">
                        <div class="search-header">
                            <form class="input-group" action="/search">
                                <input type="search" value="" placeholder="<spring:message code="menu.search"/> " class=" search-text1">
                                <span class="input-group-btn">
								<button class="icon-search btn icon-fallback-text">
									<i class="fa fa-search"></i>
								</button>
							</span>
                            </form>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="cart">
                            <a href="#">
                                <img src="/static/Image/icon/icons8-favorite-cart-80.png" class="image-cart">
                            </a>

                        </div>
                        <div class="cart contach1">

                            <div class="btn-group fw">
                                <a data-toggle="dropdown" href="#">
                                    <img src="/static/Image/icon/icons8-change-user-64.png" class="image-user">
                                </a>
                                <ul class="dropdown-menu nhap-xuat">
                                    <li><a class="chu-nhap-xuat" href="#"><spring:message code="menu.login"/></a></li>
                                    <li><a class="chu-nhap-xuat" href="#"><spring:message code="menu.logout"/></a></li>
                                </ul>
                            </div>
                             <a href="?lang=en"><img src="${pageContext.servletContext.contextPath}/static/Image/icon/england.png"></a>|
                             <a href="?lang=vi"><img src="${pageContext.servletContext.contextPath}/static/Image/icon/vietnam.png"></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container menu-nav">

                <div class="navbar-collapse collapse" id="main-menu">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="/home" class="hvr-underline-from-center"><spring:message code="menu.home"/></a>
                        </li>
                        <li>
                            <a href="/gioithieu" class="hvr-underline-from-center"><spring:message code="menu.about"/></a>
                        </li>
                        <li>
                            <a href="/product" class="hvr-underline-from-center"><spring:message code="menu.product"/></a>
                        </li>
                        <li>
                            <a href="/khuyenmai" class="hvr-underline-from-center"><spring:message code="menu.promotion"/></a>
                        </li>
                        <li>
                            <a href="/hethong" class="hvr-underline-from-center"><spring:message code="menu.system"/></a>
                        </li>
                        <li>
                            <a href="#" class="hvr-underline-from-center"><spring:message code="menu.culinary"/></a>
                        </li>
                        <li>
                            <a href="/contact" class="hvr-underline-from-center"><spring:message code="menu.contact"/></a>
                        </li>

                    </ul>

                </div>
            </div>

        </nav>
    </div>