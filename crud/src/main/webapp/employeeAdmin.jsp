<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD - List of employees</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!--bootstrap table-->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
<script
	src="https://unpkg.com/bootstrap-table@1.21.2/dist/bootstrap-table.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap-table@1.21.2/dist/bootstrap-table.min.css">
<link rel="shortcut icon" type="image/x-icon" href="groupe_travail.png"/>
	
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-info fixed-top">
		<a class="navbar-brand" href="/crud/employee">CRUD</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
		<c:choose>
		<c:when test="${user.roleName=='admin' }">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="add">Add
						employee</a></li>
			</ul>
			</c:when>
			</c:choose>
		</div>
		<div class="collapse navbar-collapse d-flex justify-content-end"
			id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active">
					<a class="nav-link" href="${pageContext.request.contextPath }/logout">Logout</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container-fluid mt-5">
		<table class="table table-hover text-center align-items-center" border="1"
			data-toggle="table" data-pagination="true" data-search="true"
			data-page-size="5" data-page-list="[10, 25, 50, All]">
			<thead>
				<tr>
					<th scope="col">empId</th>
					<th scope="col">firstName</th>
					<th scope="col">lastName</th>
					<th scope="col">startDate</th>
					<th scope="col">title</th>
					<th scope="col">Modified</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${employees}">
					<tr>
						<td><c:out value="${e.empId}" /></td>
						<td><c:out value="${e.firstName}" /></td>
						<td><c:out value="${e.lastName}" /></td>
						<td><c:out value="${e.startDate}" /></td>
						<td><c:out value="${e.title}" /></td>
						
						<c:choose>
						<c:when test="${user.roleName=='admin' }">
						<td>
						<a href="update?id=<c:out value='${e.empId}'/>"> <i
								class="bi bi-pencil-square"></i></a></td>
						<td>
						<a href="delete?id=<c:out value='${e.empId}'/>"> <i
								class="bi bi-trash-fill"></i></a></td>
								</c:when>
						<c:otherwise>
						<td>
						<a href="update?id=<c:out value='${e.empId}'/>"> <i
								class="bi bi-pencil-square"></i></a></td>
						<td>
						<button type="button" href="delete?id=<c:out value='${e.empId}'/>" disabled> <i
								class="bi bi-trash-fill "></i></button></td>
						</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
		
				
			</tbody>
		</table>
	</div>
</body>
</html>