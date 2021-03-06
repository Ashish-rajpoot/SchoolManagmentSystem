<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
   <title>School Management System</title>
</head>
<body>
<jsp:include page="../includes/header2.jsp" />
    <center>
        <h1>Students Management</h1>
        <h3>List of Students</h3>
    </center>
       <jsp:include page="../includes/error.jsp" />
    <div align="center">
       <table class="table table-striped text-center">
			<thead>
         
            <tr>
                <th>Student ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Class</th>
                <th>Age</th>
                 <th>Gender</th>
                 <th>Action</th>
            </tr>
     </thead>
     	<tbody>
            <c:forEach var="s" items="${student}">
         
                <tr>
                    <td><c:out value="${s.student_id}" /></td>
                    <td><c:out value="${s.name}" /></td>
                      <td><c:out value="${s.email_id}" /></td>
                       <td><c:out value="${s.cls.class_name}" /></td>
                    <td><c:out value="${s.age}" /></td>
                     <td><c:out value="${s.gender}" /></td>
                     
                    
                    <td>
                        <a class="btn btn-success" href="StudentByStudentId?student_id=<c:out value='${s.student_id}' />" role="button">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="btn btn-danger" href="StudentDelete?student_id=<c:out value='${s.student_id}' />" role="button">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>   
</body>
<jsp:include page="../includes/footer.jsp" />
</html>