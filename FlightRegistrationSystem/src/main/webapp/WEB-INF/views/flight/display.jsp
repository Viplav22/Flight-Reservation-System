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
<title>Flight Details</title>
</head>
<body>
	<table style="background-color: lightgrey; margin: auto;">
		<caption>Flights Available</caption>
		<thead>
			<tr>
				<th>Airline Name</th>
				<th>Departure City</th>
				<th>Arrival City</th>
				<th>Departure Date</th>
				<th>Select</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="f" items="${requestScope.flight_details}">
				<tr>
					<td>${f.airlineName}</td>
					<td>${f.departureCity}</td>
					<td>${f.arrivalCity}</td>
					<td>${f.departureDate}</td>
					<td><a
						href="<spring:url value='/passenger/details?fid=${f.id}'/>">Select</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h3 align="center" style="color: red;">${requestScope.message}</h3>
	<h4 align="center">
		<a href="<spring:url value='/flight/search'/>">Back</a>
	</h4>
</body>
</html>