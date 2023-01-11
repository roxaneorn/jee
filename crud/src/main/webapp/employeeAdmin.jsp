<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<a class="navbar-brand" href="#">CRUD</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse d-flex justify-content-end"
			id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="login.html">Logout</a></li>
			</ul>
		</div>
	</nav>

	<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/bd_formation?serverTimezone=UTC&amp" user="root" password="123456" />

	<sql:query dataSource="${snapshot}" var="result">
         SELECT * from Employee;
      </sql:query>

	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col">empId</th>
				<th scope="col">endDate</th>
				<th scope="col">firstName</th>
				<th scope="col">lastName</th>
				<th scope="col">startDate</th>
				<th scope="col">title</th>
				<th scope="col">assignedBranchId</th>
				<th scope="col">Modified or delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="e" items="${result.rows}">
				<tr>
					<td><c:out value="${e.EMP_ID}"/></td>
					<td><c:out value="${e.END_DATE}"/></td>
					<td><c:out value="${e.FIRST_NAME}"/></td>
					<td><c:out value="${e.LAST_NAME}"/></td>
					<td><c:out value="${e.START_DATE}"/></td>
					<td><c:out value="${e.title}"/></td>
					<td><c:out value="${e.ASSIGNED_BRANCH_ID}"/></td>
					<td class="row"> 
					<button><i class="bi bi-pencil-square"></i></button>
					<h3> / </h3>
					<button><i class="bi bi-trash-fill"></i></button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>