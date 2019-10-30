<%@ page pageEncoding="utf-8"%>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="static/admin/img/admin.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${user.name}</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Đang hoạt động</a>
        </div>
      </div>
      <!-- search form -->
      
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">ĐIỀU HƯỚNG</li>
        <li class="active treeview">
        </li>
        <li>
          <a href="admin?user=${user.id}">
            <i class="fa fa-home"></i> <span>Trang chủ admin</span>
          </a>
        </li>
        <li>
          <a href="categoryManager?user=${user.id}">
            <i class="fa fa-server"></i> <span>Quản lý Danh Mục</span>
          </a>
        </li>
        <li class="treeview">
          <a href="productManager?user=${user.id}">
            <i class="fa fa-clone"></i>
            <span>Quản lý Sản Phẩm</span>
          </a>
        </li>
         <li class="treeview">
          <a href="orderManagerr?user=${user.id}">
            <i class="fa fa-tags"></i>
            <span>Quản Lý Đơn Hàng</span>
          </a>
        </li>   
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>