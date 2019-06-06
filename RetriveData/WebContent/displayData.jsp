<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="javax.swing.text.StyledEditorKit.ForegroundAction"%>
<%@page import="info.inetsolv.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 style="color: green;">This data is Retrived from the database</h1>

	<%
		List<Employee> empList = (List<Employee>) request.getAttribute("list");
		request.setAttribute("empList", empList);
	%>
	<table border="2">

		<tr>
			<th>ENO</th>
			<th>NAME</th>
			<th>SALARY</th>
			<th>ADDRESS</th>
			<th>GENDER</th>
			<th>MARITAL STATUS</th>
		</tr>

		<c:if test="${not empty empList}">
			<c:forEach items="${empList}" var="employee">
				<tr>
					<td><c:out value="${employee.eno}" /></td>
					<td><c:out value="${employee.name}" /></td>
					<td><c:out value="${employee.salary}" /></td>
					<td><c:out value="${employee.address}" /></td>
					<td><c:out value="${employee.gender}" /></td>
					<td><c:out value="${employee.maritalStatus}" /></td>
				</tr>
			</c:forEach>

		</c:if>
		<c:if test="${empty empList}">
			<h2>
				<c:out value="No Records Found In DataBase"></c:out>
			</h2>
		</c:if>

	</table>
</body>
</html>