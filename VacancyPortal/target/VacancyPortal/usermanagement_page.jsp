<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>User Management</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
body {
	margin-top: 20px;
	color: #1a202c;
	text-align: left;
	background-color: #e2e8f0;
}

.main-body {
	padding: 15px;
}

.card {
	box-shadow: 0 1px 3px 0 rgba(0, 0, 0, .1), 0 1px 2px 0
		rgba(0, 0, 0, .06);
}

.card {
	position: relative;
	display: flex;
	flex-direction: column;
	min-width: 0;
	word-wrap: break-word;
	background-color: #fff;
	background-clip: border-box;
	border: 0 solid rgba(0, 0, 0, .125);
	border-radius: .25rem;
}

.card-body {
	flex: 1 1 auto;
	min-height: 1px;
	padding: 1rem;
}

.gutters-sm {
	margin-right: -8px;
	margin-left: -8px;
}

.gutters-sm>.col, .gutters-sm>[class*=col-] {
	padding-right: 8px;
	padding-left: 8px;
}

.mb-3, .my-3 {
	margin-bottom: 1rem !important;
}

.bg-gray-300 {
	background-color: #e2e8f0;
}

.h-100 {
	height: 100% !important;
}

.shadow-none {
	box-shadow: none !important;
}

.bg-white {
	background-color: #fff !important;
}

.btn-light {
	color: #1a202c;
	background-color: #fff;
	border-color: #cbd5e0;
}

.ml-2, .mx-2 {
	margin-left: .5rem !important;
}

.card-footer:last-child {
	border-radius: 0 0 .25rem .25rem;
}

.card-footer, .card-header {
	display: flex;
	align-items: center;
}

.card-footer {
	padding: .5rem 1rem;
	background-color: #fff;
	border-top: 0 solid rgba(0, 0, 0, .125);
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">

		<div class="main-body">


			<!-- /Breadcrumb -->

			<div
				class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-xl-4 gutters-sm">
				<c:forEach var="user" items="${requestScope.usersDetail}">

					<div class="col mb-3">
						<div class="card">
							<img src="https://www.bootdey.com/image/340x120/FFB6C1/000000"
								alt="Cover" class="card-img-top">
							<div class="card-body text-center">
								<img src="https://bootdey.com/img/Content/avatar/avatar7.png"
									style="width: 100px; margin-top: -65px" alt="User"
									class="img-fluid img-thumbnail rounded-circle border-0 mb-3">
								<h5 class="card-title">
									<c:out value="${user.getUser().email}"></c:out>
								</h5>
								<p class="text-secondary mb-1">
									<c:out value="${user.firstName} ${user.lastName}"></c:out>
								</p>
								<p class="text-muted font-size-sm">
									Role :
									<c:choose>
										<c:when test="${user.getUser().roleId==1}">
											<c:out value="ADMIN"></c:out>
										</c:when>
										<c:otherwise>
											<c:out value="NORMAL"></c:out>
										</c:otherwise>
									</c:choose>
								</p>
							</div>
							<div class="card-footer">
								<form action="/VacancyPortal/portal/usermanagement/edit" method="POST">
									<input type="hidden" name="isAdmin" value = "true"> 
									<input type="hidden" name="email"
										value="${user.getUser().email}" /> <input type="hidden"
										name="fname" value="${user.firstName}" /> <input
										type="hidden" name="lname" value="${user.lastName}" /> <input
										type="hidden" name="role" value="${user.getUser().roleId}" />
										<input type="hidden" name="profilePath" value="${user.getProfilePicture().getProfilePath()}">
									<input type="hidden" name="profileId" value="${user.getProfilePicture().getPictureId()}">
									<button class="btn bg-orange has-icon btn-block" type="submit"
										style="background-color: orange;">
										<i class="material-icons">Edit User</i>
									</button>
								</form>
								&nbsp; &nbsp;


								<form action="/VacancyPortal/portal/user/delete" method="POST">
									<input type="hidden" name="email"
										value="${user.getUser().email}" />
									<button class="btn  bg-red has-icon btn-block" type="submit"
										style="background-color: orange;">
										<i class="material-icons">Delete User</i>
									</button>

								</form>

							</div>
						</div>
					</div>
				</c:forEach>



			</div>
		</div>
	</div>

</body>
</html>
