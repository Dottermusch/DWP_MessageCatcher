<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/main.css">
<title>Get Message</title>
</head>
<body>
	<h1>Welcome - Please Enter Message</h1>
	<h3>Please enter your name and message below:</h3><br>
	<form action="getMessage" method="post" >
		<label for="username">Name: </label>
		<input type="text" name="username" required><br>
		<label for="messageContent">Message: </label>
		<textarea rows="3" name="messageContent" maxlength="140" required></textarea><br><br>
		<label for="submit">&nbsp;</label>
		<input type="submit" value="Submit" name="submit">
	</form>
</body>
</html>