<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Add New Telephone</title>
</head>
<body>
	<form action="TelephoneController.do" method="post">
		<fieldset>
			<div>
				<label for="telephoneId">Telephone ID</label> <input type="text"
					name="telId" value="<c:out value="${tel.telId}" />"
					readonly="readonly" placeholder="Telephone ID" />
			</div>
			<div>
				<label for="firstName">First Name</label> <input type="text"
					name="firstName" value="<c:out value="${tel.firstName}" />"
					placeholder="First Name" />
			</div>
			<div>
				<label for="lastName">Last Name</label> <input type="text"
					name="lastName" value="<c:out value="${tel.lastName}" />"
					placeholder="Last Name" />
			</div>
			<div>
				<label for="address">Address</label> <input type="text" name="address"
					value="<c:out value="${tel.address}" />" placeholder="Address" />
			</div>
			<div>
				<label for="number">Number</label> <input type="text" name="num"
					value="<c:out value="${tel.num}" />" placeholder="Number" />
			</div>
			<div>
				<input type="submit" value="Submit" />
			</div>
		</fieldset>
	</form>
</body>
</html>