<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UpdateEmployee</title>
</head>
<body>

	<jsp:include page="HRHomePage.jsp" />
	
	
	<form action="UpdateEmployee" method="post">

	<table align="center">
		<tr>
			<td>EmpId</td>
			<td><input type="text" name="empId" value="${emp.empId}" readonly/></td>
		</tr>
		<tr>
			<td>EmpName</td>
			<td><input type="text" name="empName" value="${emp.empName}" /></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><input type="text" name="salary" value="${emp.salary}" /></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>
				<select name="gender">
					<option value="${emp.gender}" selected>${emp.gender}</option>
					<option value="Male">Male</option>
					<option value="Female">Female</option>
					<option value="Others">Others</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>EmailId</td>
			<td><input type="text" name="emailId" value="${emp.emailId}" readonly /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" value="${emp.password}" readonly/></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<button>Update Employee</button>
			</td>
		</tr>
	</table>
</form>
	
</body>
</html>