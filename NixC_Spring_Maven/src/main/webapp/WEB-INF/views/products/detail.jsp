<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
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
							<div class="mx-auto h2">${ productVO.productName }</div>
						</div>
						<div class="row">
							<div class="col-12 h5 d-flex justify-content-between">
								<div>${ productVO.productKindVO.kindName }</div>
								<div><c:out value="${ fn:substring(productVO.productDate, 0, 10) }"/></div>
							</div>
						</div>
						<div class="mt-3 p-3 bg-light">
						<%--<pre><c:out value="${ productVO.productContent }"/></pre> --%>
							<div><c:out value="${ productVO.productContent }"/></div>
						</div>
						<div>
							<form id="frm">
								<input type="hidden" name="productNo" value="${ productVO.productNo }">
							</form>
							<button class="btn btn-outline-success action" data-kind="u">수정</button>
							<button class="btn btn-outline-danger action" data-kind="d">삭제</button>
						</div>
						<div>
							<button class="btn btn-primary" id="cart" data-product-no="${ productVO.productNo }">장바구니</button>
							<button class="btn btn btn-success" id="sign_up" data-product-no="${ productVO.productNo }">가입</button>
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
	<script type="text/javascript" src="/js/product/product_detail.js"></script>
</body>
</html>