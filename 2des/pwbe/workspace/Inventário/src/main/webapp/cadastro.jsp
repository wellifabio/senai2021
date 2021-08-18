<%@page import="java.util.Date"%>
<%@page import="vo.Bem"%>
<%@page import="ctr.BensProcess"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css">
<title>Cadastro de Bens (CREATE)</title>
</head>
<body>
	<form method="post">
		<label>ID</label><input type="number" name="id" required>
		<label>Descrição</label><input type="text" name="descricao" required>
		<label>Valor</label><input type="number" name="valor" required> 
		<input type="reset" value="Limpar">
		<input type="submit" value="Enviar">
	</form>
	<%
		Bem bem;
		String id = request.getParameter("id");
		String desc = request.getParameter("descricao");
		String val = request.getParameter("valor");
		
		if(id != null && desc != null && val != null){//Checar se chegaram dados
			bem = new Bem(Integer.valueOf(id),desc,new Date(),Double.valueOf(val));
			BensProcess.bens.add(bem); //Acrescenta a lista
			out.print(BensProcess.salvar()); // Da uma mensagem curta de erro ou sucesso
			response.sendRedirect("listar.jsp"); //Responde direcionando para o listar
		}else{
			out.print("<p>Aguardando dados</p>");
		}
	
	%>

</body>
</html>

