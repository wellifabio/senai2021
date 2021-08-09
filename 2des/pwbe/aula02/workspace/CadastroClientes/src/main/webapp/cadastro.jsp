<%@page import="ctr.ClienteProcess"%>
<%@page import="vo.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="estilo.css">
<title>Cadastro de Clientes (CREATE)</title>
</head>
<body>
	<form method="POST">
		<label>CPF:</label><input type="number" name="cpf">
		<label>Nome:</label><input type="text" name="nome">
		<label>Telefone:</label><input type="text" name="telefone">
		<input type="reset" value="Limpar"><input type="submit" value="Enviar">
	</form>
	<%
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		if(cpf == null || nome == null || telefone == null){
			out.print("<p>Aguardando dados</p>");
		}else{
			Cliente cliente = new Cliente(cpf, nome, telefone);
			ClienteProcess.clientes.add(cliente);
			out.print(ClienteProcess.salvar());
		}
	%>
</body>
</html>