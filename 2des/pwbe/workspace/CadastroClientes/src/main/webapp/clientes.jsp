<%@page import="ctr.ClienteProcess"%>
<%@page import="vo.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="estilo.css">
<meta charset="UTF-8">
<title>Lista com todos os clientes (READ)</title>
</head>
<body>
	<div>
		<a href="cadastro.jsp">Cadastrar Novo</a>
		<a href="editar.jsp">Alterar ou Remover</a>
	</div>
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