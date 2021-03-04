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
        <h1>Teachers Management</h1>
        <h3>List of Teachers</h3>
    </center>
    <div align="center">
       <table class="table table-striped text-center">
			<thead>
         
            <tr>
                 <th>Teacher ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Age</th>
                 <th>Gender</th>
                 <th>Action</th>
                 
            </tr>
     </thead>
     	<tbody>
            <c:forEach var="s" items="${teacher}">
                <tr>
                    <td><c:out value="${s.teacher_id}" /></td>
                    <td><c:out value="${s.teacher_name}" /></td>
                      <td><c:out value="${s.email_id}" /></td>
                    <td><c:out value="${s.age}" /></td>
                     <td><c:out value="${s.gender}" /></td>
                     
                    
                    <td>
                        <a class="btn btn-success"  href="TeacherByTeacherId?teacher_id=<c:out value='${s.teacher_id}' />" role="button">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="btn btn-danger" href="TeacherDelete?teacher_id=<c:out value='${s.teacher_id}' />" role="button">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>   

</body>
<jsp:include page="../includes/footer.jsp" />
</html>