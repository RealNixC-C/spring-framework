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
					<div class="w-75 mx-auto">
						<!-- page content 내용 -->
						<form method="post" action="" enctype="multipart/form-data">
							<input type="hidden" name="boardNo" value="${ boardVO.boardNo }">
							<div class="col-md-12 mb-3">
								<span>${ member.memberId }</span>
							</div>
							<div class="col-md-12 mb-3">
								<label for="boardTitle">제목</label> 
								<input type="text" class="form-control" name="boardTitle" id="boardTitle" value="${ boardVO.boardTitle }" required>
							</div>
							<div class="col-md-12 mb-3">
								<label for="boardContent">내용</label>
								<textarea class="form-control" name="boardContent" id="boardContent" rows="15" cols="40">${ boardVO.boardContent }</textarea>
							</div>
							<div class="d-flex justify-content-between col-md-12 mb-3">
								<div class="mb-3">
									<button class="btn btn-primary" type="button" id="btn_add">파일추가</button>
								</div>
								
								<div class="mb-3">
									<button class="btn btn-primary" type="submit">등록</button>
								</div>
							</div>
							<div>
								<c:forEach items="${ boardVO.boardFileVOs }" var="vo">
									<button class="deleteFile"  data-file-no="${ vo.fileNo }" type="button">${ vo.oriName }</button>
								</c:forEach>
							</div>
							<div class="" id="result" data-file-count="${fn:length(boardVO.boardFileVOs)}">
								<!-- 여기에 추가 -->
							</div>
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
	<script type="text/javascript" src="/js/board/board_add.js"></script>
	<script type="text/javascript">
		$("#boardContent").summernote({
			callbacks: {
				onImageUpload: function name(files) {
					console.log("files", files[0]);
					let f = new FormData();
					f.append("bf", files[0])
					
					fetch("./boardFile", {
						method : "POST",
						body : f
					})
					.then(r=>r.text())
					.then(r=>{
						$("#boardContent").summernote('editor.insertImage', r);
					})
					.catch(e => console.log(e))
					
					;
				},
				onMediaDelete: function(files) {
					let f = $(files[0]).attr("src"); // /files/notice/****.jpg
				
					let params = new URLSearchParams();
					params.append("fileName", f);
					fetch("./boardFileDelete", {
						method : "post",
						body : params
					})
					.then(r=>r.json())
					.then(r=>{
						console.log("delete")
					})
				}
			}
		});
	</script>
</body>
</html>