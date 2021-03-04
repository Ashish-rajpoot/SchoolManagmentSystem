<%@ page language="java" contentType="text/html; charset=UTF-8"
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
			<h1>Subject Management</h1>
			<h3>List of Subjects</h3>
		</caption>

	</center>
	<div align="center">
		 <table class="table table-striped text-center">
			<thead>

			<tr>
				<th>Subject ID</th>
				<th>Name</th>
				<th>Action</th>
			</tr>
    </thead>
     	<tbody>
			<c:forEach var="s" items="${subject}">
				<tr>
					<td><c:out value="${s.subject_id}" /></td>
					<td><c:out value="${s.name}" /></td>
					 <td>
                        <a class="btn btn-success" href="SubjectById?subject_id=<c:out value='${s.subject_id}' />" role="button">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="btn btn-danger" href="SubjectDelete?subject_id=<c:out value='${s.subject_id}' />" role="button">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
            </tbody>
		</table>
	</div>
</body>
<jsp:include page="../includes/footer.jsp" />
</html>