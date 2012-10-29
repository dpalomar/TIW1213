<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="usuario" method="post">
		<fieldset>
			<legend>Formulario de Edición de Usuarios</legend>
			<label for="pk">Id:</label> <input type="text" name="id"
				id="pk" value="${usuario.id }" readonly="readonly" ><br>
			<label for="nom">Nombre:</label> <input type="text" name="nombre"
				id="nom" value="${usuario.nombre }"><br> <label for="clave">Password:</label> <input
				type="password" name="password" id="clave" value="${usuario.password }">
			<input type="hidden" value="EDITAR" name="accion">
		</fieldset>
		<input type="submit" value="Enviar">

	</form>

</body>
</html>