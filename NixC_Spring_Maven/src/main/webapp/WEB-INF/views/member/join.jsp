<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
			                            <hr>
			                            <form:form cssClass="user" method="post" modelAttribute="memberVO" encType="multipart/form-data">
			                                <div class="form-group row">
			                                    <div class="col-sm-12 mb-3 mb-sm-0">
			                                    	<form:input placeholder="아이디" path="memberId" cssClass="form-control form-control-user" />
			                                    	<form:errors path="memberId" ></form:errors>
			                                    </div>
			                                </div>
			                                 <div class="form-group row">
			                                    <div class="col-sm-6 mb-3 mb-sm-0">
			                                    	<form:password path="password" placeholder="비밀번호" cssClass="form-control form-control-user"/>
			                                    	<form:errors path="password" ></form:errors>
			                                    </div>
			                                    <div class="col-sm-6">
			                                        <input type="password" class="form-control form-control-user"
			                                            name="passwordConfirm" id="passwordConfirm" placeholder="비밀번호 확인">
			                                        <form:errors path="passwordConfirm"></form:errors>
			                                    </div>
			                                </div>
			                                <div class="form-group row">
			                                    <div class="col-sm-12 mb-3 mb-sm-0">
			                                    	<form:input path="name" placeholder="이름" cssClass="form-control form-control-user"/>
			                                    	<form:errors path="name" ></form:errors>
			                                    </div>
			                                </div>
			                                <div class="form-group">
			                                	<form:input path="email" placeholder="이메일" cssClass="form-control form-control-user"/>
			                                	<form:errors path="email" ></form:errors>
			                                </div>
			                                <div class="form-group">
			                                	<form:input path="phone" placeholder="전화번호" cssClass="form-control form-control-user"/>
			                                	<form:errors path="phone" ></form:errors>
			                                </div>
			                                <div class="form-group">
			                                    <input type="date" class="form-control form-control-user" 
			                                    name="birth" id="birth" placeholder="생일">
			                                    <form:errors path="birth"></form:errors>
			                                </div>
			                                 <div class="form-group">
			                              	 	<input type="file" class="form-control form-control-user" name="attaches">
			                                </div>
			                                <button class="btn btn-primary btn-user btn-block">가입</button>
			                            </form:form>
			                            <hr>
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