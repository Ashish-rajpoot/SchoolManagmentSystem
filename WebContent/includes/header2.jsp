<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Toast Begins -->
<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<style></style>
<link rel="stylesheet" href="../css/bootstrap.min.css">

<script src="https://kit.fontawesome.com/a323b54415.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="../css/_bootswatch.scss">
<title>title</title>
<style>
</style>
</head>

<body>

	<nav class="navbar navbar-expand-sm bg-faded navbar-light  shadow-sm">
		<a class="navbar-brand" href="#">LMS</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<a  href="home.jsp"><button type="button" class="btn btn-light ">Home</button></a>
					
				<a  href="home.jsp"><button type="button" class="btn btn-light ">Dashboard</button></a>
				<%
						String user = (String) session.getAttribute("user");
					%>
			
				<%
						if (user != null) {
					%>
				<!-- Class Drop Down -->
				<div class="dropdown">
					<button type="button" class="btn btn-light dropdown-toggle"
						data-toggle="dropdown">Classes</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="ClassForm">Add Class</a> <a
							class="dropdown-item" href="Classes">Class List</a>

					</div>
				</div>
				<!-- Student Drop Down -->
				<div class="dropdown">
					<button type="button" class="btn btn-light dropdown-toggle"
						data-toggle="dropdown">Students</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="StudentForm">Add Student</a> <a
							class="dropdown-item" href="Students">Student List</a>

					</div>
				</div>
				<!-- Teacher Drop Down -->
				<div class="dropdown">
					<button type="button" class="btn btn-light dropdown-toggle"
						data-toggle="dropdown">Teachers</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="TeacherForm">Add Teacher</a> <a
							class="dropdown-item" href="Teachers">Teacher List</a>

					</div>
				</div>
				<!-- Subject Drop Down -->
				<div class="dropdown">
					<button type="button" class="btn btn-light dropdown-toggle"
						data-toggle="dropdown">Subjects</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="SubjectForm">Add Subject</a> <a
							class="dropdown-item" href="Subjects">Subject List</a>

					</div>
				</div>
				<!-- Assign classes Drop Down -->
				<div class="dropdown">
					<button type="button" class="btn btn-light dropdown-toggle"
						data-toggle="dropdown">Assign Class</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="AssignForm">Add Assign class</a> <a
							class="dropdown-item" href="Class_subject_teacher">List
							Assigned Class List</a>
					</div>
				</div>
			</ul>
			<div>

				<form class="form-inline my-2 my-lg-0">


					<a name="logout" class="btn btn-outline-success mx-2" href="Logout"
						role="button">LogOut</a> <a name="login"
						class="btn btn-outline-success mx-2" href="ProfileServlet"
						role="button">Profile</a>
					<%
						} else {
					%>
					<a name="login" class="btn btn-outline-success mx-2"
						href="login.jsp" role="button"> LogIn</a>
						<a name="signup.jsp" class="btn btn-outline-success mx-2"
						href="UserForm" role="button"> Signup</a>
					<%
						}
					%>
				</form>
			</div>
		</div>
	</nav>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
<br>
<br>


<!-- Nav-Bar Ends -->