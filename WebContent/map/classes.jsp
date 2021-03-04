<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>School Management System</title>

</head>
<body>
	<!-- Header Begins -->
	<jsp:include page="../includes/header2.jsp" />
	<br>
 <center>
        <h1>Class Management</h1>
        <h3>List of Classes</h3>
   </center>
   <div align="center">
		<table class="table table-striped text-center">
			<thead>
				<tr>
					
					<th>Class Name</th>
					<th>Class Seats</th>
					<th>Class Strength</th>

					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${cla}">
					<tr>
						
						<td><c:out value="${user.class_name}" /></td>
						<td><c:out value="${user.seats}" /></td>
						<td><c:out value="${user.strength}" /></td>

						<td>
						<a class="btn btn-success"						
							href="StudentByClassId?class_id=${user.class_id }"	role="button">Students Detail</a>
						<a class="btn btn-primary"						
							href="ClassById?class_id=${user.class_id}"
							role="button">Edit</a> 
						<a class="btn btn-danger"
							href="Delete?class_id=<c:out value='${user.class_id}'/>"
							role="button">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
</body>
<jsp:include page="../includes/footer.jsp" />
</html>




