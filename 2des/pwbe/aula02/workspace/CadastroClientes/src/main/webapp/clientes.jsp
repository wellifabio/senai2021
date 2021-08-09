<%@page import="ctr.ClienteProcess"%>
<%@page import="vo.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="read.css">
<meta charset="UTF-8">
<title>Lista todos os clientes</title>
</head>
<body>
	<table>
	<tr>
		<th>CPF</th>
		<th>Nome</th>
		<th>Telefone</th>
	</tr>
	<%
	ClienteProcess.abrir();
	for (Cliente c : ClienteProcess.clientes) {
		out.print(c.toHTML());
	}
	%>
	</table>
</body>
</html>