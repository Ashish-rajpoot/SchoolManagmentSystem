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
			<h1>Subject Management</h1>
			<h3>
				<c:if test="${subject != null}">
                        Edit subject
                    </c:if>
				<c:if test="${subject == null}">
                        Add New subject
                    </c:if>
			</h3>
		</center>
	</caption>
	<div class="container col-md-5">
		<c:if test="${subject != null}">
			<form action="SubjectsEditUpdate" method="post">
		</c:if>
		<c:if test="${subject == null}">
			<form action="AddSubject" method="post">
		</c:if>
						<jsp:include page="../includes/error.jsp" />
				<c:if test="${subject != null}">
					<fieldset class="form-group">
						<label>Subject ID</label> <input type="text"
							value="${subject.subject_id}" class="form-control"
							name="subject_id" readonly="readonly">
					</fieldset>
				</c:if>
				<c:if test="${subject == null}">
					<fieldset class="form-group">
						<label></label> <input type="hidden"
							value="${subject.subject_id}" class="form-control"
							name="subject_id" required="required">
					</fieldset>
				</c:if>

				<fieldset class="form-group">
					<label>Subject Name:</label> <input type="text"
						value="${subject.name}" class="form-control" name="name"
						required="required">
				</fieldset>

				<c:if test="${subject !=null }">
					<button type="submit" name="submit"
						class="btn btn-primary btn-block mb-2">Update Subject</button>
				</c:if>
				<c:if test="${subject ==null }">
					<button type="submit" name="submit"
						class="btn-primary form-control">Add Subject</button>
				</c:if>
		</div>
</body>
<jsp:include page="../includes/footer.jsp" />
</html>