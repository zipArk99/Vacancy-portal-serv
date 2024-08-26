<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>VacancyX</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<style>
body, html {
	height: 90%;
	margin: 0;
}

.container {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 93vh; /* Full viewport height */
}

.card-img-top {
	height: 150px;
	width: auto;
	s max-width: 100%;
	display: block;
	object-fit: contain;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<div class="card" style="width: 18rem;">
			<div class="card-body" style="background-color: green;">
				<h5 class="card-title" style="color: white;">UserProfile</h5>
			</div>
			<img src="<%=request.getContextPath()%>/${requestScope.profile}"class="card-img-top" alt="User Image">
			<ul class="list-group list-group-flush">
				<li class="list-group-item"><b>Email:</b> <c:out
						value="${requestScope.email}"></c:out></li>
				<li class="list-group-item"><b>First Name:</b> <c:out
						value="${requestScope.fname}"></c:out></li>
				<li class="list-group-item"><b>Last Name:</b> <c:out
						value="${requestScope.lname}"></c:out></li>
				<li class="list-group-item"><b>Role:</b> <c:choose>
						<c:when test="${requestScope.role==1}">
							<c:out value="ADMIN"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="NORMAL"></c:out>
						</c:otherwise>
					</c:choose></li>
			</ul>


			<div class="card-body">
				<form action="/VacancyPortal/portal/updateprofile/get"
					method="POST" >
					<input type="hidden" name="email" value="${requestScope.email}">
					<input type="hidden" name="fname" value="${requestScope.fname }">
					<input type="hidden" name="lname" value="${requestScope.lname}">
					<input type="hidden" name="role" value="${requestScope.role}">
					<input type="hidden" name="profId" value="${requestScope.profileId}">
					<input type="hidden" name="profile" value="${requestScope.profile}">
					<input type="submit" value="Edit" class="btn btn-primary">
				</form>
			</div>
		</div>
	</div>
</body>
</html>