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
				<div class="container-fluid d-flex justify-content-center" style="margin-top: 100px; height: 600px;">
					<div class="w-50">
						<!-- page content 내용 -->
						<div class="row bg-body-tertiary">
							<div class="mx-auto h2">${ boardVO.boardTitle }</div>
						</div>
						<div class="row">
							<div class="col-12 h5 d-flex justify-content-between">
								<div>${ boardVO.boardWriter }</div>
								<div>${ boardVO.boardDate }</div>
							</div>
						</div>
						<div class="mt-3 p-3 bg-light">
							<div>${ boardVO.boardContent }</div>
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