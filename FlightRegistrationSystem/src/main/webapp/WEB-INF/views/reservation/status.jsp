<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--import spring supplied JSP tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation Status Page</title>
</head>
<body>
	<h4>${requestScope.message}</h4>
	<h4>${requestScope.rid}</h4>
	<h4>${sessionScope.user_details}</h4>
	<h4>${sessionScope.selected_flight_http}</h4>
	<h4>${sessionScope.passenger_details_http}</h4>
	<h4>${sessionScope.card_details}</h4>
	<h4>${requestScope.redirect_message}</h4>
</body>
</html>