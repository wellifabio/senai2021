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
		<label>CPF:</label><input type="text" name="cpf" required>
		<label>Nome:</label><input type="text" name="nome" required>
		<label>Telefone:</label><input type="text" name="telefone" required>
		<input type="reset" value="Limpar"><input type="submit" value="Enviar">
	</form>
	<%
		Cliente cliente = new Cliente();
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setTelefone(request.getParameter("telefone"));	
		if(cliente.getCpf() == null || cliente.getCpf().equals("")){
			out.print("<p>Aguardando dados</p>");
		}else{
			ClienteProcess.clientes.add(cliente);
			out.print(ClienteProcess.salvar());
		}
	%>
	<a href="clientes.jsp">Listar todos</a>
</body>
</html>