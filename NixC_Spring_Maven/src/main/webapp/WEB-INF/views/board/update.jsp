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
					<div class="w-75 mx-auto">
						<form method="post" action="">
							<div class="col-md-12 mb-3">
								<label for="boardWriter">작성자</label>
								<input type="text" class="form-control" name="boardWriter" id="boardWriter" value="${ boardVO.boardWriter }">
							</div>
							<div class="col-md-12 mb-3">
								<label for="boardTitle">제목</label> 
								<input type="text" class="form-control" name="boardTitle" id="boardTitle" value="${ boardVO.boardTitle }" required>
							</div>
							<div class="col-md-12 mb-3">
								<label for="boardContent">내용</label>
								<textarea class="form-control" name="boardContent" id="boardContent" rows="15" cols="40">${ boardVO.boardContent }</textarea>
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