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
						<div><h2>${ board }</h2></div>
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
							<pre><c:out value="${ boardVO.boardContent }"/></pre>
<%-- 							<div><c:out value="${ boardVO.boardContent }"/></div> --%>
						</div>
						<div>
							<div>${ boardVO.boardFileVO.oriName }</div>
						</div>
						<div>
							<div>${ boardVO.boardFileVO.saveName }</div>
						</div>
						<div>
							<form id="frm">
								<input type="hidden" name="boardNo" value="${ boardVO.boardNo }">
							</form>
							<button class="btn btn-outline-success action" data-kind="u">수정</button>
							<button class="btn btn-outline-danger action" data-kind="d">삭제</button>
							<c:if test="${ board ne 'notice' }">
								<button class="btn btn-outline-info action" data-kind="r">답글</button>
							</c:if>
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
	<script type="text/javascript" src="/js/board/board_detail.js"></script>
</body>
</html>