<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="includes/header2.jsp" />
	<center>
		<h1>Teachers Management</h1>
		<h2>
					<c:if test="${User != null}">
                        Edit User
                    </c:if>
					<c:if test="${User == null}">
                        Add New User
                    </c:if>
				</h2>
	</center>
	<div align="center">
		<c:if test="${User != null}">
			<form action="#" method="post">
		</c:if>
		<c:if test="${User == null}">
			<form action="AddUser" method="post">
		</c:if>
<div class="container jumbotron">
    <div class="row">
        <div class="col-lg-8 mx-auto">
            <h1 class="text-center mb-2"><i class="fas fa-user-plus" aria-hidden="true">Register</i></h1>
            <br>

            <form method="POST" autocomplete="off">
                <div class="row">
                 <div class="col-lg-8">
                        <label></label>
                        <input type="hidden" name="user_id" class="form-control">
                    </div>
                    <div class="col-lg-8">
                        <label>Full name</label>
                        <input type="text" name="name" class="form-control">
                    </div>
                    <div class=" col-lg-4">
                        <label for="role">Role</label>
                        <select class="custom-select form-control" name="role">
                            <option value="ADMIN">ADMIN</option>
                            <!-- 
                            <option value="Student">Student</option>
                            <option value="Host">Host</option>
                             -->
                        </select>
                    </div>
                    <div class="col-lg-12">
                        <label>Email Id</label>
                        <input type="text" name="email" class="form-control">
                    </div>
                    <div class="col-lg-12">
                        <label for="password">Password</label>
                        <input type="password" name="password" class="form-control" p>
                    </div>
                   
                    <div class="col-lg-12">
                        <label></label>
                        <button type="submit" class="btn-primary form-control">Register Now!</button>
                    </div>
                </div>
            </form>
            <p class="lead mt-4">Have an Account? <a href="login.jsp">Login</a></p>
        </div>
    </div>
</div>
</body>
</html>