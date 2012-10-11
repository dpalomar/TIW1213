<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<h1>Página JSP de respuesta</h1>
	<h1>
		Tu nombre es:
		<c:out value="${param.nombre }"></c:out>
	</h1>
<!-- Esta tabla recorre la lista de usuarios devuelta por el servlet y muestra sus datos mediante JSTL -->
	<table >
		<caption>Lista Usuarios</caption>
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Clave</th>
			</tr>
		</thead>
		<c:forEach items="${listas }" var="usuario">

		<tr><td><c:out value="${usuario.nombre }"></c:out></td><td><c:out value="${usuario.password }"></c:out></td> </tr>
		
	
	
	</c:forEach>
</table>
</body>
</html>