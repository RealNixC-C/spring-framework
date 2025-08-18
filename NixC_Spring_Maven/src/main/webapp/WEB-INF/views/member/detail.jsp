<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
<%@ include file="/WEB-INF/views/include/head_css.jsp" %>
</head>
<body id="page-top">
	<div id="wrapper">
		<c:import url="/WEB-INF/views/include/sidebar.jsp"></c:import>
		
		<!-- Start  -->
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>
				<div class="container-fluid">
					<div class="alert alert-primary" role="alert">
					  ${member.memberId}
					</div>
					<div class="alert alert-primary" role="alert">
					  ${member.name}
					</div>
					<div class="alert alert-primary" role="alert">
					  ${member.email}
					</div>
					<div class="alert alert-primary" role="alert">
					  ${member.birth}
					</div>
					<div class="alert alert-primary" role="alert">
						<c:if test="${ member.profileVO.oriName eq 'default.jpg' }">
						    <img src="/img/default.png" alt="이미지">
						</c:if>
						<c:if test="${ member.profileVO.oriName ne 'default.jpg' }">
						    <img src="/files/member/${member.profileVO.saveName}" alt="이미지">
						</c:if>
					</div>
				</div>
			</div>
			<!--  End Content  -->
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		</div>
		
		
	</div>
	<c:import url="/WEB-INF/views/include/tail.jsp"></c:import>
	
</body>
</html>