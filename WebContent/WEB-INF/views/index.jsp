<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC - HelloWorld Index Page</title>
</head>
<body>
 
	<center>
	<!-- 	<h2>Hello World</h2>
		<h3>
			<a href="hello?name=Eric">Click Here</a>
		</h3> -->
	
		<form action="login" method="Post">
		<label>Username:</label>
		<input type="text" name="username"/><br><br>
		<label>Password:</label>
		<input type="password" name="password"/><br><br>
		<input type="submit" value="submit"/>
		<c:if test="${errmsg  ne null }">
		<c:out value="${errmsg}" escapeXml="true"></c:out>
		</c:if>
		</form>
	</center>
</body>
</html>