<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>

<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
</head>
<body id="page-top">
	<div id="wrapper">
		<!-- Sidebar -->
		<c:import url="/WEB-INF/views/include/sidebar.jsp"></c:import>
		<!-- Start Content -->
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>
				<div class="container-fluid">
					<!-- page content 내용 -->
					<div class="card o-hidden border-0 shadow-lg my-5">
			            <div class="card-body p-0">
			                <!-- Nested Row within Card Body -->
			                <div class="row justify-content-center">
			                    <div class="col-lg-6">
			                        <div class="p-5">
			                            <div class="text-center">
			                                <h1 class="h4 text-gray-900 mb-4">회원 가입</h1>
			                            </div>
			                            <form class="user" action="" method="post" encType="multipart/form-data">
			                                <div class="form-group row">
			                                    <div class="col-sm-12 mb-3 mb-sm-0">
			                                        <input type="text" class="form-control form-control-user" 
			                                        	name="memberId" id="memberId" placeholder="아이디">
			                                    </div>
			                                </div>
			                                 <div class="form-group row">
			                                    <div class="col-sm-6 mb-3 mb-sm-0">
			                                        <input type="password" class="form-control form-control-user"
			                                            name="password" id="password" placeholder="비밀번호">
			                                    </div>
			                                    <div class="col-sm-6">
			                                        <input type="password" class="form-control form-control-user"
			                                            name="password-confirm" id="password-confirm" placeholder="비밀번호 확인">
			                                    </div>
			                                </div>
			                                <div class="form-group row">
			                                    <div class="col-sm-12 mb-3 mb-sm-0">
			                                        <input type="text" class="form-control form-control-user" 
			                                        name="name" id="name" placeholder="이름">
			                                    </div>
			                                </div>
			                                <div class="form-group">
			                                    <input type="email" class="form-control form-control-user" 
			                                    name="email" id="email" placeholder="이메일">
			                                </div>
			                                <div class="form-group">
			                                    <input type="text" class="form-control form-control-user" 
			                                    name="phone" id="phone" placeholder="전화번호">
			                                </div>
			                                <div class="form-group">
			                                    <input type="date" class="form-control form-control-user" 
			                                    name="birth" id="birth" placeholder="생일">
			                                </div>
			                                 <div class="form-group">
			                              	 	<input type="file" class="form-control form-control-user" name="attaches">
			                                </div>
			                                <button class="btn btn-primary btn-user btn-block">가입</button>
			                            </form>
			                            <hr>
			                            <div class="text-center">
			                                <a class="small" href="forgot-password.html">비밀번호찾기</a>
			                            </div>
			                            <div class="text-center">
			                                <a class="small" href="login.html">아이디가 이미 있으신가요?</a>
			                            </div>
			                        </div>
			                    </div>
			                </div>
			            </div>
			        </div>
				</div>
			</div>
		<!-- End Content -->
		
		<!-- Footer -->
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		</div>
	</div>
	
	<!-- Modal, JS -->
	<c:import url="/WEB-INF/views/include/tail.jsp"></c:import>
</body>
</html>