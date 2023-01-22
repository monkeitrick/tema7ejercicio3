<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<c:choose>
	<c:when test="${sessionScope.cuenta!=null}">
	<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>Insert title here</title>
		</head>
		<body>
			<h1>Movimientos</h1>
			<form action="ServletMovimientos" method="post">
				<table>
					<tr>
						<td>Titular</td>
						<c:if test="${sessionScope.cuenta!=null}">
							<td>${sessionScope.cuenta.getTitular()}</td>
						</c:if>
					</tr>
					<tr>
						<td>Saldo actual</td>
						<c:if test="${sessionScope.cuenta!=null}">
							<td>${sessionScope.cuenta.getSaldo()}</td>
						</c:if>
					</tr>
					<tr>
						<td>Cantidad</td>
						<td><input type="text" name="cantidad" id="cantidad"></td>
					</tr>
				</table>
				<button type="submit" value="ingresar"name="ingresoGasto">Ingresar</button>
				<button type="submit" value="gastar" name="ingresoGasto">Gastar</button>
			</form>
			<c:if test="${sessionScope.noGasto!=null}">
				<p>${sessionScope.noGasto}</p>
				<%
					session.removeAttribute("noGasto");
				%>
			</c:if>
		</body>
	</html>
	</c:when>
	<c:otherwise>
		<c:redirect url="nuevaCuenta.jsp" />
	</c:otherwise>
</c:choose>