<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

</head>
<body>

	<header>
	<jsp:include page="../includes/header2.jsp" />
	</header>
	<br>
	<div class="container col-md-5">

		<c:if test="${cls != null}">
			<form action="Update" method="post">
		</c:if>
		<c:if test="${cls == null}">
			<form action="AddClass" method="post">
		</c:if>

		<caption>
			<h2>
				<c:if test="${cls != null}">
            			Edit class
            		</c:if>
				<c:if test="${cls == null}">
            			Add New class
            		</c:if>
			</h2>
		</caption>
<jsp:include page="../includes/error.jsp" />
		<c:if test="${cls != null}">
			<fieldset class="form-group">
				<label>Class ID</label> <input type="text"
					value="${cls.class_id}" class="form-control"
					name="class_id" readonly="readonly" >
			</fieldset>
		</c:if>
		<c:if test="${cls == null}">
			<fieldset class="form-group">
				<label></label> <input type="hidden"
					value="<c:out value='${cls.class_id}' />" class="form-control"
					name="class_id" required="required" >
			</fieldset>
		</c:if>
		<fieldset class="form-group">
			<label>Class name</label> <input type="text"
				value="<c:out value='${cls.class_name}' />" class="form-control"
				name="class_name" required="required">
		</fieldset>

		<fieldset class="form-group">
			<label>seats</label> <input type="text"
				value="<c:out value='${cls.seats}' />" class="form-control"
				name="seats" required="required">
		</fieldset>

		<div class="col-lg-12 mx-auto">
			<label for=""></label>

			<c:if test="${cls !=null }">
			<button type="submit" name="submit"
				class="btn btn-primary btn-block mb-2">Update Course</button>
				</c:if>
		
			<c:if test="${cls ==null }">
			<button type="submit" name="submit" class="btn-primary form-control">Create
				Course</button>
				</c:if>
	
		</div>
		</form>

	</div>
</body>
<jsp:include page="../includes/footer.jsp" />
</html>







