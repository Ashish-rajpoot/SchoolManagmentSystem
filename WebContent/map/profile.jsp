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
	<div class="container jumbotron">
		<div class="row">
			<div class="col-lg">
				<h3>Welcome to Profile</h3>
				<hr class="w-75">
			</div>
		</div>
		<br>

				<jsp:include page="../includes/error.jsp" />
		<!-- Profarma to signup and login -->
		<div class="container ">
			<div class="row">
					<div class="col-lg-5">
						<h3>Change Profile!</h3>

						<form method="POST" action="AdminUser" autocomplete="off">
							<input type="hidden" name="user_id" value="${profile.user_id}"
								class="form-control">
							<div class="col-lg-12">
								<label>Name</label> <input name="name" value="${profile.name}"
									class="form-control">
							</div>
							<div class="col-lg-12">
								<label>Email Id</label> <input name="email"
									value="${profile.email}" class="form-control">
							</div>
							<div class="col-lg-12">
								<label></label>
								<button type="submit" class="btn-primary form-control">Change</button>
							</div>
						</form>
					</div>
					<div class="col-lg-5">
						<h3>Change password!</h3>
						<form method="POST" action="AdminPass" autocomplete="off">
							<input type="hidden" name="user_id" value="${profile.user_id}"
								class="form-control">
							<div class="col-lg-12">
								<label>Old Password</label> <input type="password"
									name="password" class="form-control">
							</div>
							<div class="col-lg-12">
								<label for="password">Change Password</label> <input
									type="password" name="npassword" class="form-control">
							</div>
							<div class="col-lg-12">
								<label for="Confirm password">Confirm Password</label> <input
									type="password" name="cnpassword" class="form-control">
							</div>
							<div class="col-lg-12">
								<label></label>
								<button type="submit" class="btn-primary form-control">Change</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>

<jsp:include page="../includes/footer.jsp" />
</html>




