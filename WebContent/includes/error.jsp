<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
	<c:if test="${errors != null}">
		<c:forEach var="error" items="${errors }">
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				${error }
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${success != null}">
		<c:forEach var="success" items="${success }">
			<div class="alert alert-success alert-dismissible fade show"
				role="alert">
				${success }
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:forEach>
	</c:if>


	<script>
  document.addEventListener("DOMContentLoaded", function () {
    setTimeout(() => {
      document.querySelectorAll('.alert').forEach(alert => {
        alert.classList.remove("show");
        alert.classList.add("fade");
        
        setTimeout(() => alert.remove(), 500);
      });
    }, 3000);
  });
</script>
</body>
</html>
