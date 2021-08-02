<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Meu primeiro JSP</title>
</head>
<body>
	<form method='get'>
		<input type='text' placeholder='digite um nome' name='entrada'>
		<input type='submit' value='Enviar'>
	</form>
	<%="Ben vindo ao JSP<br>"%>
	<%
	String texto = request.getParameter("entrada");
	if (texto == null) {
		out.print("Aguardando dados");
	} else {
		out.print("Opa chegou o nome " + texto);
		out.print(" com " + texto.length() + " caracteres");
	}
	%>
</body>
</html>