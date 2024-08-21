<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Detail</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div
		style="width: 30%; margin: auto; background-color: #aed6f1; padding: 20px;">
		<form action="/VacancyPortal/user/userdetail" method="post" enctype="multipart/form-data">
			<h3>
				<span style="color: #145a32"><b>V</b>acancy</span><span
					style="color: #d35400;"><b>X</b></span> User Details
			</h3>
			
			<input type="hidden" value="${userEmail}" name="useremail">
			
			<div class="form-group">
				<label for="fnameId">First Name</label> <input type="text"
					name="fname" class="form-control" id="fnameId"
					value="${param.fname}" aria-describedby="emailHelp"
					placeholder="Enter your first name"> <span
					style="color: red;"><c:out
						value="${requestScope.userDetailValidation['firstName']}"></c:out> </span>
			</div>
			<div class="form-group">
				<label for="lnameId">Last Name</label> <input name="lname"
					type="text" class="form-control" id="lnameId"
					value="${param.lname}" placeholder="Enter your last name">
				<span style="color: red;"><c:out
						value="${requestScope.userDetailValidation['lastName']}"></c:out> </span>
			</div>
			<div class="form-group">
				<label for="profileId">Profile Photo</label> <input type="file"
					name="profile" class="form-control" id="profileId"
					value="${param.profile}" aria-describedby="emailHelp"> <span
					style="color: red;"><c:out
						value="${requestScope.userDetailValidation['profile']}"></c:out> </span>
			</div>
			<br>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>