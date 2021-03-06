<%@ page import="com.dao.*, java.sql.*" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>School Management System</title>
</head>
<body>

	<jsp:include page="../includes/header2.jsp" />

	<caption>
		<center>
			<h1>Teachers Management</h1>
			<h2>
				<c:if test="${teacher != null}">
                        Edit teacher
                    </c:if>
				<c:if test="${teacher == null}">
                        Add New teacher
                    </c:if>
			</h2>
		</center>
	</caption>

	<div class="container col-md-5">
   <jsp:include page="../includes/error.jsp" />
		<c:if test="${teacher != null}">
			<form action="TeacherUpdateEdit" method="post">
		</c:if>
		<c:if test="${teacher == null}">
			<form action="AddTeacher" method="post">
		</c:if>
		<c:if test="${teacher != null}">
			<fieldset class="form-group">
				<label>Teacher ID</label> <input type="text"
					value="${teacher.teacher_id}" class="form-control"
					name="teacher_id" readonly="readonly">
			</fieldset>
		</c:if>
		<c:if test="${teacher == null}">
			<fieldset class="form-group">
				<label></label> <input type="hidden"
					value="${teacher.teacher_id}" class="form-control"
					name="teacher_id" required="required">
			</fieldset>
		</c:if>

				<fieldset class="form-group">
				<label>Teacher Name</label> <input type="text"
					value="${teacher.teacher_name}" class="form-control"
					name="teacher_name" required="required">
			</fieldset>
				
				<fieldset class="form-group">
				<label>Email</label> <input type="text"
					value="${teacher.email_id}" class="form-control"
					name="email_id" required="required">
			</fieldset>
				<fieldset class="form-group">
				<label>Age</label> <input type="text"
					value="${teacher.age}" class="form-control"
					name="age" required="required">
			</fieldset>
				<fieldset class="form-group">
				<label>Gender</label> <input type="text"
					value="${teacher.gender}" class="form-control"
					name="gender" required="required">
			</fieldset>
			<c:if test="${teacher !=null }">
			<button type="submit" name="submit"
				class="btn btn-primary btn-block mb-2">Update Teacher</button>
				</c:if>
		
			<c:if test="${teacher ==null }">
			<button type="submit" name="submit" class="btn-primary form-control">Add Teacher</button>
				</c:if>
	</div>
</body>
<jsp:include page="../includes/footer.jsp" />
</html>