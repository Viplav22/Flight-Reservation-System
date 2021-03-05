<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import spring suppiled JSP tag lib for URL rewriting --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<h4>Welcome to Flight Reservation!!</h4>
	<h5>
		<a href="<spring:url value='/user/login'/>">Sign In</a>
	</h5>
	<h5>
		<a href="<spring:url value='/user/signup'/>">Sign Up</a>
	</h5>
	<h5 align="center" style="color: red;">${requestScope.message}</h5>
</body>
</html>