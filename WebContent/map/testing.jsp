<%@ page import="com.dao.*, java.sql.*,java.util.*" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Teachers Store Application</title>
</head>
<body>
<jsp:include page="../includes/header2.jsp" />
    <center>
        <h1>Teachers Management</h1>
       
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Teachers</h2></caption>
            <tr>
                <th>Class ID</th>
              
            </tr>
     
            <c:forEach var="a" items="${class}">
            
                <tr>
                	 	
                    <td><c:out value="${a.class_id}" /></td>
                   
    
                     
                    
                    <td>
                        <a href="SelectByAssignId?assign_id=<c:out value='${a.class_id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="DeleteConfig?assign_id=<c:out value='${a.class_id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
   
        </table>
          
    </div>   
</body>
</html>