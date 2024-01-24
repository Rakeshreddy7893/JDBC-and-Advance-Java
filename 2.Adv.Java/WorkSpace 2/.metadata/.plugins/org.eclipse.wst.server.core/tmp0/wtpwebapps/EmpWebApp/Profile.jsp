<%@ page import="com.dto.Employee"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.io.IOException"%>
<%@ page import="javax.servlet.ServletException"%>



<!DOCTYPE html>
<html>
<head>
<title>Employee Profile</title>
</head>
<body>
	<jsp:include page="EmpHomePage.jsp" />

	<table border='2' align='center'>
		<tr>
			<th>EmpId</th>
			<th>EmpName</th>
			<th>Salary</th>
			<th>Gender</th>
			<th>Email-Id</th>
			<th>Password</th>
		</tr>

		
			<tr>
			<td> ${ emp.empId } </td>
			<td> ${ emp.empName } </td>
			<td> ${ emp.salary } </td>
			<td> ${ emp.gender } </td>
			<td> ${ emp.emailId } </td>
			</tr>
	</table>
</body>
</html>
