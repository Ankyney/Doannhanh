<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="com.tthshop.entities.Admin"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>TTH SHOP</title>
<meta name="description" content="Quản lý danh mục">
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="static/admin/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- DataTables -->
<!-- Theme style -->
<link rel="stylesheet" href="static/admin/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="static/admin/css/skins/_all-skins.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="static/dtable/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="static/dtable/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">

<!-- Datatables -->
<link
	href="static/dtable/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link
	href="static/dtable/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css"
	rel="stylesheet">
<link
	href="static/dtable/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css"
	rel="stylesheet">
<link
	href="static/dtable/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css"
	rel="stylesheet">
<link
	href="static/dtable/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="static/dtable/table.css">
</head>
<style>
.button {
	background-color: #20B2AA;
	border: none;
	color: white;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

.button1 {
	padding: 10px 24px;
}
</style>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<jsp:include page="admin/header.jsp" />

		<jsp:include page="admin/sidebar.jsp" />

		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Quản lý đơn hàng</h1>

			</section>


			<!-- Main content -->
			<!-- Start Table -->
			<!-- /.box-header -->
			<c:choose>
				<c:when test="${mode != null}">
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<h3 style="padding-right: 20px;" class="box-title">ĐƠN
										HÀNG ${orderID}</h3>
									<form action="checkedOrder" method="post">
										<input type="hidden" value="${orderID}" name="orderID" /> <input
											type="radio" value="1" name="orderStatus" /> Xác nhận Đơn
										hàng <input type="radio" value="0" name="orderStatus" /> Hủy
										Đơn hàng <input
											style="float: right; border: none; background-color: #3c8dbc; padding: 3px 10px; color: #FFF;"
											type="submit" value="LƯU DỮ LIỆU" />
									</form>
								</div>
								<!-- /.box-header -->
								<div class="box-body">
									<div
										style="margin-left: 50px; margin-right: 50px; margin-top: 20px">


										<table id="datatable-buttons"
											class="table table-striped table-bordered">
											<thead>
												<tr>
													<th><strong>Mã ĐH</strong></th>
													<th><strong>Tên Sản Phẩm</strong></th>
													<th><strong>Đơn Giá</strong></th>
													<th><strong>Số Lượng</strong></th>
													<th><strong>Thành Tiền</strong></th>
												</tr>

											</thead>



											<tbody>
												<c:forEach var="orderDetail" items="${orderDetails}">
													<tr>
														<td>${orderDetail.order.id}</td>
														<td>${orderDetail.product.name}</td>
														<td>${orderDetail.product.price}</td>
														<td>${orderDetail.quantity}</td>
														<td>${orderDetail.product.price * orderDetail.quantity}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								<!-- /.box-body -->
							</div>
						</div>
				</c:when>
				<c:otherwise>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<h3 class="box-title">ĐƠN HÀNG MỚI</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body">
									<div
										style="margin-left: 50px; margin-right: 50px; margin-top: 20px">


										<table class="table table-striped table-bordered">
											<thead>
												<tr>
													<th><strong>Mã ĐH</strong></th>
													<th><strong>Tên Khách hàng</strong></th>
													<th><strong>Số điện thoại</strong></th>
													<th><strong>Địa chỉ</strong></th>
													<th><strong>Ngày Thanh Toán</strong></th>
													<th><strong>Tổng Tiền</strong></th>
													<th><strong>Lựa Chọn</strong></th>
												</tr>

											</thead>



											<tbody>
												<c:forEach var="order" items="${newOrder}">
													<tr>
														<td>${order.id}</td>
														<td>${order.customerName}</td>
														<td>${order.phoneNumber}</td>
														<td>${order.address}</td>
														<td>${order.date}</td>
														<td>${order.total}</td>
														<td><a
															href="viewOrderDetail?orderID=${order.id}&&user=${user.id}"
															style="border: none; background-color: #3c8dbc; padding: 0 10px; color: #FFF;">
																Chi Tiết</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								<div class="box">
									<div class="box-header">
										<h3 class="box-title">ĐƠN HÀNG ĐÃ THANH TOÁN</h3>
									</div>
									<!-- /.box-header -->
									<div class="box-body">
										<div
											style="margin-left: 50px; margin-right: 50px; margin-top: 20px">
											<table id="datatable-buttons"
												class="table table-striped table-bordered">
												<thead>
													<tr>
														<th><strong>Mã ĐH</strong></th>
														<th><strong>Tên Khách hàng</strong></th>
														<th><strong>Số điện thoại</strong></th>
														<th><strong>Địa chỉ</strong></th>
														<th><strong>Ngày Thanh Toán</strong></th>
														<th><strong>Tổng Tiền</strong></th>
														<th><strong>Lựa Chọn</strong></th>
													</tr>

												</thead>



												<tbody>
													<c:forEach var="order" items="${checkedOrder}">
														<tr>
															<td>${order.id}</td>
															<td>${order.customerName}</td>
															<td>${order.phoneNumber}</td>
															<td>${order.address}</td>
															<td>${order.date}</td>
															<td>${order.total}</td>
															<td><a
																href="viewOrderDetail?orderID=${order.id}&&user=${user.id}"
																style="border: none; background-color: #3c8dbc; padding: 0 10px; color: #FFF;">
																	Chi Tiết</a></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
									<!-- /.box -->
								</div>
								<!-- /.col -->
							</div>
				</c:otherwise>
			</c:choose>
			<!-- /.row -->
			<!-- /.content -->
		</div>
		<!-- End Table -->
		<!-- /.box -->

		<!-- footer -->
		<footer
			style="border-top: 1px solid #d2d6de; text-align: center; background: #fff; color: #444; height: 60px; line-height: 60px;">
			<strong>Copyright &copy; 2019 | <a
				href="https://www.facebook.com">TTH SHOP</a>.
			</strong>
		</footer>
		<!-- footer -->
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->

	<!-- Control Sidebar -->
	<aside class="control-sidebar control-sidebar-dark">
		<!-- Create the tabs -->
		<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
			<li><a href="#control-sidebar-home-tab" data-toggle="tab"><i
					class="fa fa-home"></i></a></li>
			<li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i
					class="fa fa-gears"></i></a></li>
		</ul>
		<!-- Tab panes -->
		<div class="tab-content">
			<!-- Home tab content -->
			<div class="tab-pane" id="control-sidebar-home-tab">
				<h3 class="control-sidebar-heading">Recent Activity</h3>
				<ul class="control-sidebar-menu">
					<li><a href="javascript:void(0)"> <i
							class="menu-icon fa fa-birthday-cake bg-red"></i>

							<div class="menu-info">
								<h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

								<p>Will be 23 on April 24th</p>
							</div>
					</a></li>
					<li><a href="javascript:void(0)"> <i
							class="menu-icon fa fa-user bg-yellow"></i>

							<div class="menu-info">
								<h4 class="control-sidebar-subheading">Frodo Updated His
									Profile</h4>

								<p>New phone +1(800)555-1234</p>
							</div>
					</a></li>
					<li><a href="javascript:void(0)"> <i
							class="menu-icon fa fa-envelope-o bg-light-blue"></i>

							<div class="menu-info">
								<h4 class="control-sidebar-subheading">Nora Joined Mailing
									List</h4>

								<p>nora@example.com</p>
							</div>
					</a></li>
					<li><a href="javascript:void(0)"> <i
							class="menu-icon fa fa-file-code-o bg-green"></i>

							<div class="menu-info">
								<h4 class="control-sidebar-subheading">Cron Job 254
									Executed</h4>

								<p>Execution time 5 seconds</p>
							</div>
					</a></li>
				</ul>
				<!-- /.control-sidebar-menu -->


				<!-- /.control-sidebar-menu -->

			</div>
			<!-- /.tab-pane -->
			<!-- Stats tab content -->

			<!-- /.tab-pane -->
			<!-- Settings tab content -->

			<!-- /.tab-pane -->
		</div>
	</aside>
	<!-- /.control-sidebar -->
	<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
	<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery 2.2.0 -->
	<!-- Bootstrap 3.3.6 -->
	<script src="static/admin/js/bootstrap.min.js"></script>
	<!-- DataTables -->
	<!-- SlimScroll -->
	<script src="static/admin/slimScroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script src="static/admin/fastclick/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="static/admin/js/app.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="static/admin/js/demo.js"></script>
	<!-- page script -->
	<!-- jQuery -->
	<script src="static/dtable/vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="static/dtable/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->

	<!-- Datatables -->
	<script
		src="static/dtable/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
	<script
		src="static/dtable/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<script
		src="static/dtable/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
	<script
		src="static/dtable/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
	<script
		src="static/dtable/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
	<script
		src="static/dtable/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
	<script
		src="static/dtable/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="static/dtable/build/js/custom.min.js"></script>
</body>
</html>
