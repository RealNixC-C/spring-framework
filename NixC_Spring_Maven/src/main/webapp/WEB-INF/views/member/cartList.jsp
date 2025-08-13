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
				<div class="container-fluid">
					<!-- page content 내용 -->
					<div class="col-md-8 offset-md-2">
						<div class="col-md-12 text-center">
							<h2>${ board }</h2>
						</div>
						<table class="table text-center">
							<thead>
								<tr class="table-primary">
									<th>
										<div class="form-check">
											<input class="form-check-input" type="checkbox" value="" id="checkAll">
											<label class="form-check-label" for="checkDefault">전체 선택</label>
										</div>
									</th>
									<th>상품명</th>
									<th>이자율</th>
									<th>종류</th>
								</tr>							
							</thead>
							<tbody>
								<c:forEach var="l" items="${ list }">
									<tr>
										<td>
											<div class="form-check">
												<input class="form-check-input ch" type="checkbox" value="${ l.productNo }">
											</div>
										</td>
										<td><a href="/products/detail?productNo=${ l.productNo }">${ l.productName }</a></td>
										<td>${ l.productRate }</td>
										<td>${ l.kindNo }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
<!-- 						<div> -->
<!-- 							<nav aria-label="Page navigation example"> -->
<!-- 								<ul class="pagination justify-content-center"> -->
<!-- 									<li class="page-item"> -->
<%-- 										<button type="button" class="page-link pn" data-pn="${ pager.startNum-1 }" aria-label="Previous">  --%>
<!-- 											<span aria-hidden="true">&laquo;</span> -->
<!-- 										</button> -->
<!-- 									</li> -->
<%-- 									<c:forEach begin="${ pager.startNum }" end="${ pager.endNum }" var="i"> --%>
<%-- 										<li class="page-item"><button type="button" class="page-link pn" data-pn="${i}" >${i}</button></li> --%>
<%-- 									</c:forEach> --%>
<!-- 									<li class="page-item"> -->
<%-- 										<button type="button" class="page-link pn" data-pn="${ pager.endNum+1 }" aria-label="Next">  --%>
<!-- 											<span aria-hidden="true">&raquo;</span> -->
<!-- 										</button> -->
<!-- 									</li> -->
<!-- 								</ul> -->
<!-- 							</nav> -->
<!-- 						</div> -->
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
	<script type="text/javascript" src="/js/member/member_cartList.js"></script>
</body>
</html>