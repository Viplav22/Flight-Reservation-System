<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--import spring suppiled JSP tag lib for URL rewriting --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%--import for the form binding tech, spring supplied form tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Passenger Registration Form</title>
</head>
<body>
	<h3 align="center">Passenger Details Form</h3>
	<h5 align="center" style="color: blue;">Hello,
		${sessionScope.user_details.userName}</h5>
	<h4 align="center">You have chosen : Flight Details</h4>
	<h4 align="center">${sessionScope.selected_flight_http}</h4>
	<h4 align="center" style="color: red;">${requestScope.message}</h4>
	
	<form:form method= "post" modelAttribute="passenger">
		<table style="background-color: lightgrey; margin: auto;">
			<caption>Enter Passenger Details</caption>
			<tbody>
				<tr>
					<td>Passenger Name</td>
					<td><form:input path="passengerName" /></td>
					<td><form:errors path="passengerName" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="passengerEmail" /></td>
					<td><form:errors path="passengerEmail" /></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><form:input path="passengerPhoneNo" /></td>
					<td><form:errors path="passengerPhoneNo" /></td>
				</tr>
			</tbody>
		</table>
		<h5 align="center">
			<input type="submit" value="Enter Details" />
		</h5>
	</form:form>
</body>
</html>