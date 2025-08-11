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
					<div class="w-75 mx-auto">
						<!-- page content 내용 -->
						<form method="post" action="">
							<input type="hidden" name="productNo" value="${ productVO.productNo }">
							<div class="mb-3 d-flex justify-content-between">
								<div class="col-md-6 mb-2">
									<label for="productKind">분류</label> 
									<select class="form-control rounded" aria-label="Default select example" id="productKind" name="kindNo">
										<option selected>선택</option>
										<option value="1" ${ productVO.kindNo eq 1 ? 'selected' : ''}>예금</option>
										<option value="2" ${ productVO.kindNo eq 2 ? 'selected' : ''}>적금</option>
										<option value="3" ${ productVO.kindNo eq 3 ? 'selected' : ''}>대출</option>
									</select>
								</div>
								<div class="col-md-6 mb-3">
									<label for="productRate">상품 이율</label>
									<input type="text" class="form-control" name="productRate" id="productRate" value="${ productVO.productRate }" required>
								</div>
							</div>
							<div class="col-md-12 mb-3">
								<label for="productDate">판매기간</label> 
								<input type="date" class="form-control" name="productDate" id="productDate" value="${ productVO.productDate }" required>
							</div>
							<div class="col-md-12 mb-3">
								<label for="productName">상품명</label> 
								<input type="text" class="form-control" name="productName" id="productName" value="${ productVO.productName }" required>
							</div>
							<div class="col-md-12 mb-3">
								<label for="productContent">내용</label>
								<textarea class="form-control" name="productContent" id="productContent" rows="15" cols="40">${ productVO.productContent }</textarea>
							</div>
							<button class="btn btn-primary" type="submit">등록</button>
						</form>
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