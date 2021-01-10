<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Telephones</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Telephone ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Address</th>
				<th>Number</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tels}" var="tel">
				<tr>
					<td><c:out value="${tel.telId}" /></td>
					<td><c:out value="${tel.firstName}" /></td>
					<td><c:out value="${tel.lastName}" /></td>
					<td><c:out value="${tel.address}" /></td>
					<td><c:out value="${tel.num}" /></td>
					<td><a
						href="TelephoneController.do?action=edit&telId=<c:out value="${tel.telId}"/>">Update</a></td>
					<td><a
						href="TelephoneController.do?action=delete&telId=<c:out value="${tel.telId}"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="TelephoneController.do?action=insert">Add Telephone</a>
	</p>
</body>
</html>