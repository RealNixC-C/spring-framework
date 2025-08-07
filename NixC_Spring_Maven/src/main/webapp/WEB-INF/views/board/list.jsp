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
					<div class="col-md-8 offset-md-2 ">
						<h2>${ board }</h2>
						<div>
							<form id="searchFrom" method="get">
								<div class="input-group mb-3">
									<input type="hidden" id="pageNum" name="pageNum">
									<select class="form-select" name="kind">
										<option value="k1" ${ pager.kind eq 'k1' ? 'selected' : '' }>제목</option>
										<option value="k2" ${ pager.kind eq 'k2' ? 'selected' : '' }>내용</option>
										<option value="k3" ${ pager.kind eq 'k3' ? 'selected' : '' }>작성자</option>
									</select>
									<input type="text" class="form-control" value="${ pager.keyword }" placeholder="제목을 입력하세요." name="keyword">
									<button class="btn btn-outline-secondary" type="submit" id="button-addon2">검색</button>
								</div>
							</form>
						</div>
						<table class="table text-center">
							<thead>
								<tr class="table-primary">
									<th>번호</th>
									<th>작성자</th>
									<th>제목</th>
									<th>날짜</th>
									<th>조회수</th>
								</tr>							
							</thead>
							<tbody>
								<c:forEach var="l" items="${ list }">
									<tr>
										<td>${ l.boardNo }</td>
										<td>${ l.boardWriter }</td>
										<td>
											<c:catch>
												<c:forEach begin="1" end="${ l.boardDepth }" varStatus="vs">&nbsp;&nbsp;
													<c:if test="${vs.last}">ㄴ</c:if>
												</c:forEach>
											</c:catch>
										<a href="./detail?boardNo=${ l.boardNo }">${ l.boardTitle }</a>
										</td>
										<td>${ l.boardDate }</td>
										<td>${ l.boardHit }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						<div class="mx-auto">
							<nav aria-label="Page navigation example">
								<ul class="pagination">
									<li class="page-item">
										<button type="button" class="page-link pn" data-pn="${ pager.startNum-1 }" aria-label="Previous"> 
											<span aria-hidden="true">&laquo;</span>
										</button>
									</li>
									<c:forEach begin="${ pager.startNum }" end="${ pager.endNum }" var="i">
										<li class="page-item"><button type="button" class="page-link pn" data-pn="${i}" >${i}</button></li>
									</c:forEach>
									<li class="page-item">
										<button type="button" class="page-link pn" data-pn="${ pager.endNum+1 }" aria-label="Next"> 
											<span aria-hidden="true">&raquo;</span>
										</button>
									</li>
								</ul>
							</nav>
						</div>
						
						<div>
							<a class="btn btn-outline-primary" href="./add">글쓰기</a>
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
	<script type="text/javascript" src="/js/board/board_list.js"></script>
</body>
</html>