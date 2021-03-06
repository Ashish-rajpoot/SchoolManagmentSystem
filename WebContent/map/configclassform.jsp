<%@page import="java.util.List"%>
<%@page import="com.entity.Classes"%>
<%@ page import="com.dao.*, java.sql.*" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>School Management System</title>
</head>

<body>
	<header>
		<jsp:include page="../includes/header2.jsp" />
	</header>

	<center>
		<h1>Assign Classes</h1>

	</center>
	<div align="center">
		<c:if test="${assign != null}">
			<form action="UpdateConfig" method="post">
		</c:if>
		<c:if test="${assign == null}">
			<form action="AddClassConfig" method="post">
		</c:if>
		<caption>
		<h3>
			<c:if test="${assign != null}">
                        Edit Assigned Class
                    </c:if>
			<c:if test="${assign == null}">
                        Assign New Class
                    </c:if>
		</h3>
		</caption>
			</div>
		<div class="container col-lg-5">
		<jsp:include page="../includes/error.jsp" />
		<c:if test="${assign != null}">
			<input type="hidden" name="assign_id"
				value="<c:out value='${assign.assign_id}'/>" />
		</c:if>
		<fieldset class="form-group">
			<label>Class Name</label> <select class="custom-select form-control"
				name="class_id" required="required">
				<option selected value="${assign.class_id}">
					<c:if test="${assign != null}">
                       ${assign.cls.class_name}
                    </c:if>
					<c:if test="${assign == null}">
                       Select Class
                    </c:if>
				</option>
				<%
					String sql = "SELECT * FROM classes";
				try (Connection connection = Database.getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
					ResultSet set = preparedStatement.executeQuery();
					while (set.next()) {
						String class_name = set.getString("class_name");
						int class_id = set.getInt("class_id");
				%>
				<option  value="<%=class_id%>"><%=class_name%></option>

				<%
					}
				} catch (Exception e) {
				e.printStackTrace();
				out.println("Error" + e.getMessage());
				}
				%>
			</select>
		</fieldset>
		<fieldset class="form-group">
			<label>Teacher Name</label> <select class="custom-select form-control"
				name="teacher_id" required="required">
				<option selected value="${assign.teacher_id}">
					<c:if test="${assign != null}">
                       ${assign.techer.teacher_name}
                    </c:if>
					<c:if test="${assign == null}">
                       Select Teacher
                    </c:if>

				</option>
				<%
					String sql1 = "SELECT * FROM teachers";
				try (Connection connection = Database.getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(sql1)) {
					ResultSet set = preparedStatement.executeQuery();
					while (set.next()) {
						String name = set.getString("teacher_name");
						int teacher_id = set.getInt("teacher_id");
				%>
				<option value="<%=teacher_id%>"><%=name%></option>
				<%
					}
				} catch (Exception e) {
				e.printStackTrace();
				out.println("Error" + e.getMessage());
				}
				%>
			</select>
		</fieldset>
		<fieldset class="form-group">
			<label>Subject Name</label> <select class="custom-select form-control"
				name="subject_id" required="required">
				<option selected value="${assign.subject_id}">
					<c:if test="${assign != null}">
                       ${assign.sub.name}
                    </c:if>
					<c:if test="${assign == null}">
                       Select subject
                    </c:if>
				</option>
				<%
					String sql2 = "SELECT * FROM subjects";
				try (Connection connection = Database.getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(sql2)) {
					ResultSet set = preparedStatement.executeQuery();
					while (set.next()) {
						String name = set.getString("name");
						int subject_id = set.getInt("subject_id");
				%>
				<option value="<%=subject_id%>"><%=name%></option>
				<%
					}
				} catch (Exception e) {
				e.printStackTrace();
				out.println("Error" + e.getMessage());
				}
				%>
			</select>
		</fieldset>
		<c:if test="${assign !=null }">
			<button type="submit" name="submit"
				class="btn btn-primary btn-block mb-2">Update Class</button>
				</c:if>
		
			<c:if test="${assign ==null }">
			<button type="submit" name="submit" class="btn-primary form-control">Assign Class</button>
				</c:if>
	</div>
</body>
<jsp:include page="../includes/footer.jsp" />
</html>