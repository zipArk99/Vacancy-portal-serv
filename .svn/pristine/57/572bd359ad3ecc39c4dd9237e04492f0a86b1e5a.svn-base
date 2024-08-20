<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<%@ include file="header.jsp"%>

	<div
		style="width: 30%; margin: auto; background-color: #aed6f1; padding: 20px;">
		<form action="/VacancyPortal/user/login" method="post">
			<h3>
				<span style="color: #145a32"><b>V</b>acancy</span><span
					style="color: #d35400;"><b>X</b></span> Login
			</h3>
			<div class="form-group">
				<label for="loginEmail">Email address</label> <input
					type="email" name="lEmail" class="form-control"
					id="loginEmail" value="${param.lEmail}"
					aria-describedby="emailHelp" placeholder="Enter email"> <span
					style="color: red;"><c:out value="${requestScope.loginUserValidation['email']}"></c:out> </span>
			</div>	
			<div class="form-group">
				<label for="loginPassword">Password</label> <input
					name="lPassword" type="password" class="form-control"
					id="loginPassword" value="${param.lPassword}"
					placeholder="Password"> <span style="color: red;"><c:out value="${requestScope.loginUserValidation['password']}"></c:out> </span>
			</div>
			<br>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
</body>

</html>