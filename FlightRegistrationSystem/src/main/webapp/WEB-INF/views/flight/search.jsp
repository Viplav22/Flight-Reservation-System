<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search flight Page</title>
</head>
<body>
	<h5 align="center" style="color: blue;">Hello,
		${sessionScope.user_details.userName}</h5>
	<form method=post>
		<table style="background-color: lightgrey; margin: auto;">
			<caption>Search Flight</caption>
			<tbody>
				<tr>
					<td>From</td>
					<td><input type="text" name="src_city" /></td>
				</tr>
				<tr>
					<td>To</td>
					<td><input type="text" name="dest_city" /></td>
				</tr>
				<tr>
					<td>Departure Date</td>
					<td><input type="date" name="dept_date" /></td>
				</tr>
			</tbody>
		</table>
		<h5 align="center">
			<input type="submit" value="Search" />
		</h5>
	</form>
</body>
</html>