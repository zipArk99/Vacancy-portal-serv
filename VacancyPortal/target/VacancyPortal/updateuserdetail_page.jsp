
<%@page import="java.io.PrintWriter"%>
<%@page import="com.app.vacancyportal.entity.UserDetail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.app.vacancyportal.entity.ProfilePicture"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>

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

.image-container {
	text-align: center;
}

.image-container button {
	background: none;
	border: none;
	padding: 0;
	cursor: pointer;
}

.image-container img {
	display: inline-block;
	margin: 0 10px;
	height: 200px;
	transition: transform 0.3s ease, box-shadow 0.3s ease;
}
/* Hover effect */
.image-container img:hover {
	transform: scale(1.05); /* Slightly enlarges the image */
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3); /* Adds a shadow */
}
/* Click effect */
.image-container img:active {
	transform: scale(0.95); /* Adds a subtle click effect */
}
</style>
</head>
<body>
<body>
	

	<%@ include file="header.jsp"%>
	<div class="image-container">
		<c:forEach var="profile"
			items="${sessionScope.userDetail.getProfilePictureList()}">
			<img src="<%=request.getContextPath()%>/${profile.getProfilePath()}"
			class="rounded float-left" alt="Profile Pic" height="150px"
			onclick="handleClick(1)">
		</c:forEach>
	</div>
	<form
		action="<c:choose>
<c:when test="${param.isAdmin}">
	<c:out value="/VacancyPortal/portal/usermanagement"></c:out>
</c:when>
<c:otherwise>

<c:out value="/VacancyPortal/portal/updateprofile"></c:out>
</c:otherwise>

</c:choose>"
		method="POST">

		<div class="container">
			<div class="card" style="width: 15rem;">
				<div class="card-body" style="background-color: green;">
					<h5 class="card-title" style="color: white;">UserProfile</h5>
				</div>
				<img
					src="<%=request.getContextPath()%>/${sessionScope.userDetail.getProfilePicture().getProfilePath()}"
					class="card-img-top" alt="User Image"> <input type="hidden"
					name="email"
					value="${sessionScope.userDetail.getUser().getEmail()}"> <input
					type="hidden" name="profile"
					value="${sessionScope.userDetail.getProfilePicture().getProfilePath()}">
				<input type="hidden" name="profId"
					value="${sessionScope.userDetail.getProfilePicture().getPictureId()}">
				<ul class="list-group list-group-flush">


					<li class="list-group-item"><b>Email :</b> <input type="text"
						name="email" class="form-control" id="fnameId"
						value="${sessionScope.userDetail.getUser().getEmail()}"
						aria-describedby="emailHelp" disabled="disabled"></li>

					<li class="list-group-item"><b>First Name:</b> <input
						type="text" name="fname" class="form-control" id="fnameId"
						value="${sessionScope.userDetail.getFirstName()}"
						aria-describedby="emailHelp"></li>


					<li class="list-group-item"><b>Last Name:</b> <input
						type="text" name="lname" class="form-control" id="fnameId"
						value="${sessionScope.userDetail.getLastName()}"
						aria-describedby="emailHelp"></li>


					<li class="list-group-item"><b>Role:</b> <c:choose>
							<c:when
								test="${sessionScope.userDetail.getUser().getRoleId()==1}">
								<input type="text" name="role" class="form-control" id="fnameId"
									value="ADMIN" aria-describedby="emailHelp" disabled="disabled">
							</c:when>
							<c:otherwise>
								<input type="text" name="role" class="form-control" id="fnameId"
									value="NORMAL" aria-describedby="emailHelp" disabled="disabled">
							</c:otherwise>
						</c:choose></li>
				</ul>
				<div class="card-body">
					<input type="submit" class="btn btn-primary" value="Update">
				</div>

			</div>
		</div>
	</form>

	<div class="card" style="width: 15rem;"
		style=" display:flex; justify-content:center;
	align-items: center;">
		<form action="/VacancyPortal/portal/userprofile/add" method="POST"
			enctype="multipart/form-data">
			<input type="hidden" name="email" value="${param.email}"> <input
				type="file" name="profile" class="form-control" id="profileId"
				value="${param.profile}" aria-describedby="emailHelp"
				style="padding: 10px;"> <input type="submit"
				class="btn btn-primary" value="Upload New Profile">
		</form>

	</div>
	<script>
		function handleClick(imageId) {
			// Perform the desired action here
			alert("Image " + imageId + " clicked!");
			// You can also make AJAX calls, navigate to a different page, etc.
		}
	</script>
</body>
</html>