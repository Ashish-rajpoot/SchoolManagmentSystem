<%@ page import="com.dao.*, java.sql.*,java.util.*,com.entity.*"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>School Management System</title>
</head>
<body>
	<jsp:include page="../includes/header2.jsp" />
	<center>
		<caption>
			<h1>Assign Classes</h1>
			<h3>List of Assigned Class</h3>
		</caption>
	</center>

	<div class="container jumbotron">
		<div class="row">
			<div class="col-lg">
				
				<hr class="w-75">
			</div>
		</div>
		<br>
		<table class="table table-striped text-center">
			<thead>
				<tr>
					<th>Class ID</th>
					<th>Teacher ID</th>
					<th>Subject ID</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${data}">
				
					<tr>
						<td><c:out value="${a.cls.class_name}" /></td>
						<td><c:out value="${a.techer.teacher_name}" /></td>
						<td><c:out value="${a.sub.name}" /></td>
						<td><a class="btn btn-success"
							href="SelectByAssignId?assign_id=<c:out value='${a.assign_id}' />" role="button">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a class="btn btn-danger"
							href="DeleteConfig?assign_id=<c:out value='${a.assign_id}' />" role="button">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>

</body>
<jsp:include page="../includes/footer.jsp" />
</html>