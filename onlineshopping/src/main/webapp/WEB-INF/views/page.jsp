<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - ${title }</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
<link href="${css}/style.css" rel="stylesheet">

<!-- Bootstrap DataTable -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

</head>

<body>



	<%@include file="./shared/navbar.jsp"%>

	<div class="container">
		<div class="row">
			<!-- Page Content -->
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userClickContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			
			<!-- Load only when user clicks manage products -->
			<c:if test="${userClickManageProducts == true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>
			
			
			<!-- /.container -->
		</div>
	</div>


	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>



	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.min.js"></script>
	<script src="${js}/bootstrap.bundle.min.js"></script>
	<script src="${js}/myapp.js"></script>
	
	<!-- DataTable Plugin -->
	<script src="${js}/jquery.dataTables.js"></script>
	
	<!-- DataTable Bootstrap Script -->
	<script src="${js}/dataTables.bootstrap.js"></script>
	<script src="${js}/bootbox.min.js"></script>

</body>

</html>
