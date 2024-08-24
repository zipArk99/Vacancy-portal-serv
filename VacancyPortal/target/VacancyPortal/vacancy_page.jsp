<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Vacancies</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"
	rel="stylesheet">
<style type="text/css">
body {
	margin-top: 20px;
	background: #eee;
	color: #708090;
}

.icon-1x {
	font-size: 24px !important;
}

a {
	text-decoration: none;
}

.text-primary, a.text-primary:focus, a.text-primary:hover {
	color: #00ADBB !important;
}

.text-black, .text-hover-black:hover {
	color: #000 !important;
}

.font-weight-bold {
	font-weight: 700 !important;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container" style="width: 100%;">
		<div class="row" style="width: 100%;">
			<!-- Main content -->
			<div class="col-lg-9 mb-3">
				<div class="row text-left mb-5"></div>
				<!-- End of post 1 -->
				<c:forEach var="vac" items="${sessionScope.vacancies}">
					<div
						class="card row-hover pos-relative py-3 px-3 mb-3 border-warning border-top-0 border-right-0 border-bottom-0 rounded-0">
						<div class="row align-items-center">
							<div class="col-md-8 mb-3 mb-sm-0">
								<h5>
									<a href="#" class="text-primary">${vac.getVacancyTitle()}</a>
								</h5>
								<p class="text-sm">
									<span class="op-6">Experience</span> <a class="text-black" href="#">${vac.getVacancyExperience()}</a> <span class="op-6"> , </span> <a class="text-black"
										href="#">Salary  <a class="text-black" href="#">${vac.getVacancySalary()}</a></a>
								</p>
								<div class="text-sm op-5">
									<a class="text-black mr-2" href="#">#C++</a> <a
										class="text-black mr-2" href="#">#AppStrap Theme</a> <a
										class="text-black mr-2" href="#">#Wordpress</a>
								</div>
							</div>
							<div class="col-md-4 op-7">
								<div class="row text-center op-7">
									<div class="col px-1">
										<i class="ion-connection-bars icon-1x"></i> <span
											class="d-block text-sm">141 Votes</span>
									</div>
									<div class="col px-1">
										<i class="ion-ios-chatboxes-outline icon-1x"></i> <span
											class="d-block text-sm">122 Replys</span>
									</div>
									<div class="col px-1">
										<i class="ion-ios-eye-outline icon-1x"></i> <span
											class="d-block text-sm">290 Views</span>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>




			</div>
		</div>
	</div>
</body>
</html>