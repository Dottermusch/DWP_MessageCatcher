<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/main.css">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="getMessage?action=onlyRecent">Get Most Recent</a>
          <a class="navbar-brand" href="getMessage?action=reverseOrder">Get Oldest Msgs First</a>
<!--           <a class="navbar-brand" href="#">Choice C</a> -->
<!--           <a class="navbar-brand" href="#">Choice D</a> -->
<!--           <a class="navbar-brand" href="#">Choice E</a> -->
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="welcome.jsp">Home</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
<br />
<br />
    <div class="container">

      <div class="starter-template">
        <h1>Tewter Recent Message</h1>
        
      </div>
		<form action="getMessage.jsp" method="post">
		  <div class="form-group">
		  <label> Most Recent Message</label>
		  <span>
		 <c:out value='${recentMessage.username}' /></span>&nbsp;&nbsp;
		 <span><fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${recentMessage.postingTime}" /></span><br>
		  <c:out value='${recentMessage.message}' /></span><br><br>
		  </div>
		  <button type="submit" class="btn btn-primary">Add Message</button>
		</form>
    </div><!-- /.container -->
</body>
</html>