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
					<div class="col-md-12 text-center">	<h2>${ board }</h2>	</div>
					<!-- page content 내용 -->
					<div class="row col-md-8 offset-md-2 ">
						<table class="table">
							<thead>
								<tr class="table-primary">
									<th>상품 번호</th>
									<th>상품명</th>
									<th>날짜</th>
									<th>이자율</th>
								</tr>							
							</thead>
							<tbody>
								<c:forEach var="l" items="${ productList }">
									<tr>
										<td>${ l.productNo }</td>
										<td><a href="./detail?productNo=${ l.productNo }">${ l.productName }</a></td>
										<td><c:out value="${ fn:substring(l.productDate, 0, 10) }"/></td>
<%-- 										<td>${fn:substring(l.productDate, 0, 10)}</td> --%>
										<td>${ l.productRate }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div>
							<a class="btn btn-outline-primary" href="./add">상품 등록</a>
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