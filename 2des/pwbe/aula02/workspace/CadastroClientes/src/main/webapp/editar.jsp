<%@page import="ctr.ClienteProcess"%>
<%@page import="vo.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="estilo.css">
<title>Alterar ou Excluir Clientes (UPDATE e DELETE)</title>
</head>
<body>
	<%
	Cliente cliente = new Cliente();
	cliente.setCpf(request.getParameter("cpf"));
	cliente.setNome(request.getParameter("nome"));
	cliente.setTelefone(request.getParameter("telefone"));
	int indice = ClienteProcess.clientes.indexOf(cliente);
	String opcao = request.getParameter("opcao");

	String formulario1 = "<form method='GET'>"
			+ "<label>CPF:</label><input type='text' name='cpf'>"
			+ "<input type='reset' value='Limpar'><input type='submit' value='Buscar'>" + "</form>";

	if (cliente.getCpf() == null || cliente.getCpf().equals("")) {
		out.print("<p>Digite o cpf do cliente e clique em buscar</p>");
		out.print(formulario1);
	} else {
		if (ClienteProcess.clientes.contains(cliente)) {
			cliente = ClienteProcess.clientes.get(indice);
			String formulario2 = "<form method='GET'>"
				+ "<label>CPF:</label><input type='text' name='cpf' value='"	+ cliente.getCpf() + "'>"
				+ "<label>Nome:</label><input type='text' name='nome' value='" + cliente.getNome() + "'>"
				+ "<label>Telefone:</label><input type='text' name='telefone' value='" + cliente.getTelefone() + "'>"
				+ "<div><label>Excluir</label><input type='radio' name='opcao' value='excluir'></div>"
				+ "<div><label>Alterar</label><input type='radio' name='opcao' value='alterar'></div>"
				+ "<input type='submit' value='Enviar'>"
				+ "</form>";
			out.print(formulario2);
		} else {
			out.print("<p>CPF não encontrado</p>");
			out.print(formulario1);
		}
		
		if(opcao != null){
			switch(opcao){
			case "excluir":
				ClienteProcess.clientes.remove(indice);
				ClienteProcess.salvar();
				break;
			case "alterar":
				cliente.setNome(request.getParameter("nome"));
				cliente.setTelefone(request.getParameter("telefone"));
				ClienteProcess.clientes.set(indice,cliente);
				ClienteProcess.salvar();
				break;
			default:
				break;
			}
			response.sendRedirect("clientes.jsp");
		}
	}
	%>
	<a href="clientes.jsp">Listar todos</a>
</body>
</html>