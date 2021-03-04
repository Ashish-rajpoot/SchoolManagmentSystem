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
			<h1>Students Management</h1>
			<h3>
				<c:if test="${student != null}">
                        Edit student
                    </c:if>
				<c:if test="${student == null}">
                        Add New student
                    </c:if>
			</h3>
		</center>
	</caption>
	<div class="container col-md-5">

		<c:if test="${student != null}">
			<form action="StudentEditUpdate" method="post">
		</c:if>
		<c:if test="${student == null}">
			<form action="AddStudent" method="post">
		</c:if>


		<c:if test="${student != null}">
			<fieldset class="form-group">
				<label>Student ID</label> <input type="text"
					value="${student.student_id}" class="form-control"
					name="student_id" readonly="readonly">
			</fieldset>
		</c:if>
		<c:if test="${student == null}">
			<fieldset class="form-group">
				<label>Student ID</label> <input type="text"
					value="${student.student_id}" class="form-control"
					name="student_id" required="required">
			</fieldset>
		</c:if>

		<fieldset class="form-group">
			<label>Student Name:</label> <input type="text"
				value="${student.name}" class="form-control" name="name"
				required="required">
		</fieldset>
		<fieldset class="form-group">
			<label>Class:</label> <select class="custom-select form-control"
				name="class_id" value="${student.class_id}">
				<%
						String sql = "SELECT * FROM classes";
					try (Connection connection = Database.getConnection();
							PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
						ResultSet set = preparedStatement.executeQuery();
						while (set.next()) {
							int class_id = set.getInt("class_id");
							String class_name = set.getString("class_name");
					%>
				<option value="<%=class_id%>"><%=class_name%></option>
				<%
						}
					} catch (Exception e) {
					e.printStackTrace();
					out.println("Error" + e.getMessage());
					}
					%>
			</select>
		</fieldset>

		<fieldset class="form-group">
			<label>Email ID</label> <input type="text"
				value="${student.email_id}" class="form-control" name="email_id"
				required="required">
		</fieldset>
		<fieldset class="form-group">
			<label>Age</label> <input type="text" value="${student.age}"
				class="form-control" name="age" required="required">
		</fieldset>
		<fieldset class="form-group">
			<label>Gender</label> <input type="text" value="${student.gender}"
				class="form-control" name="gender" required="required">
		</fieldset>

		<c:if test="${student !=null }">
			<button type="submit" name="submit"
				class="btn btn-primary btn-block mb-2">Update Student</button>
		</c:if>

		<c:if test="${student ==null }">
			<button type="submit" name="submit" class="btn-primary form-control">Add
				Student</button>
		</c:if>

	</div>

</body>
<jsp:include page="../includes/footer.jsp" />
</html>