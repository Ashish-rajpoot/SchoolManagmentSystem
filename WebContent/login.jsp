<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="includes/header2.jsp" />
	<div class="container ">
		<div class="row mx-auto">
			<div class="col-lg-6 mx-auto">
				<h3 class="text-center mb-2">
					<i class="fas fa-sign-in-alt fa-3x">Login</i>
				</h3>
				<jsp:include page="./includes/error.jsp" />
				<form method="POST" autocomplete="off" action="login">
					<div class="row">
						<div class="col-lg-12">
							<label>Email</label> <input type="text" name="email"
								class="form-control">
						</div>
						<div class="col-lg-12">
							<label>Password</label> <input type="password" name="password"
								class="form-control">
						</div>
						<div class="col-lg-12">
							<label for=""></label>
							<button type="submit" name="login"
								class="btn-primary form-control">Login</button>
						</div>
					</div>
				</form>
				<p class="lead mt-4">
					Don't have an Account? <a href="signup.jsp">Signup</a>
				</p>
			</div>
		</div>
	</div>


</body>
</html>