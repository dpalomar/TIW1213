<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<!-- comprobar y pintar errores -->

	<c:if test="${!empty errores }">
		<c:forEach items="${errores }" var="error">

			<c:if test="${error.key =='nombre'}">
				<p class="error">El nombre no puede quedar en blanco</p>

			</c:if>
			<c:if test="${error.key =='clave'}">
				<p class="error">La clave no puede quedar en blanco</p>

			</c:if>
		</c:forEach>
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