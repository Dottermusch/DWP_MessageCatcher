<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Got to display Page</h1>
	
	
	<c:forEach var="msg" items="${messages}">
	<label for="username">Name & Time </label>
	<span><c:out value='${msg.username}' /></span>&nbsp;&nbsp;
	<span><fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${msg.postingTime}" /></span><br>
	<span><c:out value='${msg.message}' /></span><br><br>
	</c:forEach>
	<a href="getMessage.jsp"><button>Add Comment</button></a>
</body>
</html>