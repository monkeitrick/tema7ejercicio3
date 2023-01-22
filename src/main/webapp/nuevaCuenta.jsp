<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Nueva cuenta</h1>
		<c:if test="${sessionScope.error!=null}">
			<p style="color:red;">${sessionScope.error}</p>
		</c:if>
		<form action="ServletNuevaCuenta" method="post">
			<table>
				<tr>
					<td>Titular</td>
					<td><input type="text" name="titular" id="titular"></td>
				</tr>
				<tr>
					<td>Saldo Inicial</td>
					<td><input type="text" name="saldo" id="saldo"></td>
				</tr>
			</table>
			<input type="submit" value="Crear Cuenta Corriente">
		</form>
	</body>
</html>