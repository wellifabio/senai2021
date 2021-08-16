<%@page import="vo.Bem"%>
<%@page import="ctr.BensProcess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="estilo.css">
<title>Listar todos os Bens (READ)</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Descrição</th>
			<th>Data</th>
			<th>Valor</th>
		</tr>
		<%
		//BensProcess.testes();
		BensProcess.abrir();
		for (Bem b : BensProcess.bens) {
			out.print(b.toHTML());
		}
		//out.print(BensProcess.salvar());
		%>
	</table>
</body>
</html>