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
					<div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">
            <div class="col-xl-10 col-lg-12 col-md-9">
                <div class="card o-hidden border-0 shadow-lg my-5 w-75 mx-auto">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">로그인</h1>
                                    </div>
                                    <h5>${ param.failMessage }</h5>
                                    <form class="user" method="post" action="loginProcess">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                id="memberId" name="memberId" aria-describedby="emailHelp"
                                                placeholder="아이디" value="${ cookie.rememberId.value }">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="password" name="password" placeholder="비밀번호">
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" value="1" name="rememberId" id="rememberId">
                                                <label class="custom-control-label" for="rememberId">아이디기억</label>
                                            </div>
                                            <div class="custom-control custom-checkbox small">
                                            	<input type="checkbox" class="custom-control-input" value="1" name="remember-me" id="remember-me">
                                                <label class="custom-control-label" for="remember-me">자동 로그인</label>
                                            </div>
                                        </div>
                                        <button class="btn btn-primary btn-user btn-block">로그인</button>
                                    </form>
                                    <hr>
                                    <a href="/oauth2/authorization/kakao" class="btn btn-facebook btn-user btn-block" style="background-color: #FEE500;">카카오로그인</a>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="forgot-password.html">비밀번호찾기</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="/member/join">회원가입</a>
                                    </div>
                                </div>
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
	</div>
	
	<!-- Modal, JS -->
	<c:import url="/WEB-INF/views/include/tail.jsp"></c:import>
</body>
</html>