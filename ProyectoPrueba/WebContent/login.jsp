<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="author"  content="David Palomar " >
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<!-- comprobar y pintar errores (Sólo el usuario administrador puede entrar root/admin) -->
	
	<c:if test="${!empty errores }">

		<c:forEach items="${errores }" var="error" >
		

		<c:if test="${empty error.value}">
			<p class="error"> <c:out value="${error.key } no puede quedar en blanco"></c:out> </p>
		</c:if>
		<c:if test="${(!empty error.value) && (error.key=='nombre')}">
			<p class="error">Sólo el usuario administrador puede entrar </p>
			<p class="error">Psss, una pista root/admin</p>
		</c:if>
			
			
			
		</c:forEach>
	</c:if>
	<c:if test="${sessionScope.autenticado == true}">
		<p>Bienvenido de nuevo: <c:out value="${sessionScope.nombre }"></c:out> <!-- se recupera los atributos almacenados en sesión -->
		</p>
		<p>Aquí puedes acceder directamente <a href="respuesta.jsp">Acceso directo</a> <br>
		Este enlace sólo aparece sacando los datos de la sesión si te has autenticado correctamente.</p>	
	</c:if>
	<h1>Formulario</h1>
	<form action="formulario" method="post">
		<fieldset>
			<legend>Formulario de login</legend>
			<label for="nom">Nombre:</label> <input type="text" name="nombre"
				id="nom"><br> <label for="clave">Password:</label> <input
				type="password" name="clave" id="clave">

		</fieldset>
		<input type="submit" value="Enviar">

	</form>


</body>
</html>