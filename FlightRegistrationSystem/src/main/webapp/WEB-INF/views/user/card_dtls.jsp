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
<title>Card Details</title>
</head>
<body>
	<h4 align="center" style="color: red;">${requestScope.message}</h4>
	<form method=post>
		<table style="background-color: lightgrey; margin: auto;">
			<caption>Enter Card Details</caption>
			<tbody>
				<tr>
					<td>Card Number</td>
					<td><input type="number" name="c_num" required="required" /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="c_name" required="required" /></td>
				</tr>
				<tr>
					<td>Expiry Date</td>
					<td><input type="date" name="c_exp" required="required" /></td>
				</tr>
				<tr>
					<td>CVV</td>
					<td><input type="number" name="cvv" /></td>
				</tr>
			</tbody>
		</table>
		<h5 align="center">
			<input type="submit" value="Enter" />
		</h5>
	</form>
</body>
</html>