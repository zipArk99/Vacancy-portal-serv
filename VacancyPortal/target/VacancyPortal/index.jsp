<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>VacancyX</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp" %>
ss
<div style="width:30%; margin: auto; background-color:#aed6f1; padding:20px;">
<form action="/VacancyPortal/user" method="POST">
<h3> <span style="color: #145a32"><b>V</b>acancy</span><span style="color:#d35400;"><b>X</b></span> Registration</h3>
  <div class="form-group">  
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" name="email" class="form-control" id="exampleInputEmail1" value="${param.email}" aria-describedby="emailHelp" placeholder="Enter email">
    <span style="color:red;"><c:out value="${requestScope.userValidation['email']}"></c:out> </span>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input name="password" type="password" class="form-control" id="exampleInputPassword1" value="${param.password}" placeholder="Password">
  	<span style="color:red;"><c:out value="${requestScope.userValidation['password']}"></c:out> </span>
  </div>
  
   <div class="form-group">
    <label for="confexampleInputPassword1">Confirm Password</label>
    <input name="confirmpassword" type="password" class="form-control" id="confexampleInputPassword1" value="${param.confirmpassword}" placeholder="Confirm Password">
  	<span style="color:red;"><c:out value="${requestScope.userValidation['classlevelerror']}"></c:out></span>
  </div>
  <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1" name="check">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<br><br>
<form action="/VacancyPortal/user/login" method="get">
<button type="submit">Already Registered</button>
</form>

</div>
</body>
</html>