<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="author"  content="David Palomar " >
<title>Insert title here</title>

</head>
<body>
	<h1>Página JSP de respuesta</h1>
	<p> <a href="login.jsp">Volver</a></p>
	<p> <a href="formulario?sesion=logout">Cerrar Sesión</a></p>
	<p>
		<c:if test="${empty param.nombre }">
			Has accedido directamente como <strong>${sessionScope.nombre }</strong> y no has pasado por el controlador, por lo que el controlador 
			no ha cargado los datos en el request.<br>
			Este es un ejemplo de cómo puedo llamarte por tu nombre almacenado en sesión (${sessionScope.nombre }), pero no puedo
			acceder a los datos de request, porque se han borrado. <br>
			Si pasas de nuevo introduciendo datos en el formulario verás los datos cargados en la página en ámbito de request.
		</c:if>
	</p>
	<h1>
		Tu nombre es:
		<c:out value="${param.nombre }"></c:out> <!-- Esta respuesta es haciendo uso de los parámetros del request -->
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