<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

           <!-- Sidebar - Brand -->
     <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
         <div class="sidebar-brand-icon rotate-n-15">
             <i class="fas fa-laugh-wink"></i>
         </div>
         <div class="sidebar-brand-text mx-3">스프링 공부<sup></sup></div>
     </a>

     <!-- Divider -->
     <hr class="sidebar-divider my-0">

     <!-- Nav Item - Dashboard -->
     <li class="nav-item">
         <a class="nav-link" href="index.html">
             <i class="fas fa-fw fa-tachometer-alt"></i>
             <span>대시보드</span></a>
     </li>

     <!-- Divider -->
     <hr class="sidebar-divider">

     <!-- Heading -->
     <div class="sidebar-heading">
         인터페이스
     </div>

     <!-- Nav Item - Pages Collapse Menu -->
     <li class="nav-item">
         <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
             aria-expanded="true" aria-controls="collapseTwo">
             <i class="fas fa-fw fa-cog"></i>
             <span>게시판</span>
         </a>
         <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
             <div class="bg-white py-2 collapse-inner rounded">
                 <h6 class="collapse-header">게시판:</h6>
                 <a class="collapse-item" href="/notice/list">공지사항</a>
                 <a class="collapse-item" href="cards.html">질문 게시판</a>
             </div>
         </div>
     </li>

     <!-- Nav Item - Utilities Collapse Menu -->
     <li class="nav-item">
         <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
             aria-expanded="true" aria-controls="collapseUtilities">
             <i class="fas fa-fw fa-wrench"></i>
             <span>유틸리티</span>
         </a>
         <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
             data-parent="#accordionSidebar">
             <div class="bg-white py-2 collapse-inner rounded">
                 <h6 class="collapse-header">커스텀 유틸리티:</h6>
                 <a class="collapse-item" href="utilities-color.html">색상</a>
                 <a class="collapse-item" href="utilities-border.html">보더</a>
                 <a class="collapse-item" href="utilities-animation.html">애니메이션</a>
                 <a class="collapse-item" href="utilities-other.html">그 외</a>
             </div>
         </div>
     </li>

     <!-- Divider -->
     <hr class="sidebar-divider">

     <!-- Heading -->
     <div class="sidebar-heading">
         에드온
     </div>

     <!-- Nav Item - Pages Collapse Menu -->
     <li class="nav-item active">
         <a class="nav-link" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true"
             aria-controls="collapsePages">
             <i class="fas fa-fw fa-folder"></i>
             <span>페이지</span>
         </a>
         <div id="collapsePages" class="collapse" aria-labelledby="headingPages"
             data-parent="#accordionSidebar">
             <div class="bg-white py-2 collapse-inner rounded">
                 <h6 class="collapse-header">로그인 화면:</h6>
                 <a class="collapse-item" href="login.html">로그인</a>
                 <a class="collapse-item" href="register.html">회원 가입</a>
                 <a class="collapse-item" href="forgot-password.html">비밀번호 찾기</a>
                 <div class="collapse-divider"></div>
                 <h6 class="collapse-header">그외 페이지:</h6>
                 <a class="collapse-item" href="404.html">404 페이지</a>
                 <a class="collapse-item active" href="blank.html">빈 페이지</a>
             </div>
         </div>
     </li>

     <!-- Nav Item - Charts -->
     <li class="nav-item">
         <a class="nav-link" href="charts.html">
             <i class="fas fa-fw fa-chart-area"></i>
             <span>차트</span></a>
     </li>

     <!-- Nav Item - Tables -->
     <li class="nav-item">
         <a class="nav-link" href="tables.html">
             <i class="fas fa-fw fa-table"></i>
             <span>테이블</span></a>
     </li>

     <!-- Divider -->
     <hr class="sidebar-divider d-none d-md-block">

     <!-- Sidebar Toggler (Sidebar) -->
     <div class="text-center d-none d-md-inline">
         <button class="rounded-circle border-0" id="sidebarToggle"></button>
     </div>

 </ul>