
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<img src="<%=request.getContextPath()%>/${param.profile}"
			class="rounded float-left" alt="..." height="150px"
			onclick="handleClick(1)"> <img
			src="<%=request.getContextPath()%>/${param.profile}"
			class="rounded float-right" alt="..." height="150px"
			onclick="handleClick(2)"> <img
			src="<%=request.getContextPath()%>/${param.profile}"
			class="rounded float-right" alt="..." height="150px"
			onclick="handleClick(3)">
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
				<img src="<%=request.getContextPath()%>/${param.profile}"
					class="card-img-top" alt="User Image"> <input type="hidden"
					name="email" value="${param.email}"> <input type="hidden"
					name="role" value="${param.role}"> <input type="hidden"
					name="profile" value="${param.profile}"> <input
					type="hidden" name="profId" value="${param.profId}">
				<ul class="list-group list-group-flush">
					<li class="list-group-item"><b>Email:</b> <c:out
							value="${param.email}"></c:out></li>

					<li class="list-group-item"><b>First Name:</b> <input
						type="text" name="fname" class="form-control" id="fnameId"
						value="${param.fname}" aria-describedby="emailHelp"></li>


					<li class="list-group-item"><b>Last Name:</b> <input
						type="text" name="lname" class="form-control" id="fnameId"
						value="${param.lname}" aria-describedby="emailHelp"></li>


					<li class="list-group-item"><b>Role:</b> <c:choose>
							<c:when test="${param.role==1}">
								<c:out value="ADMIN"></c:out>
							</c:when>
							<c:otherwise>
								<c:out value="NORMAL"></c:out>
							</c:otherwise>
						</c:choose></li>
				</ul>
				<div class="card-body">
					<input type="submit" class="btn btn-primary" value="Update">
				</div>
				<form action="#" method="POST">
					<input type="submit" class="btn btn-primary"
						value="Upload New Image">
				</form>
			</div>
		</div>
	</form>
	<script>
		function handleClick(imageId) {
			// Perform the desired action here
			alert("Image " + imageId + " clicked!");
			// You can also make AJAX calls, navigate to a different page, etc.
		}
	</script>
</body>
</html>