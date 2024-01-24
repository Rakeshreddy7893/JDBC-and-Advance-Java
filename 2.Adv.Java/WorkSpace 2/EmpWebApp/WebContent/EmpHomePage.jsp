<%@ page language="java" contentType="text/html charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<body bgcolor='lightyellow' text='red'>
			<%String emailId = (String) session.getAttribute("emailId");%>
			
			<h3 style = 'color:red'>Welcome<%= emailId%>!</h3>
			
			<form align='right'>
			<a href='EmpHomePage'>Home</a> 
			<a href='Logout'>Logout</>
			<form>

			<center>
			<h1>Welcome to EmpHomePage</h1>			
		    <h3><a href = 'Profile.jsp'>Profile</a></h3>
		    </center>
		    </body>





</html>