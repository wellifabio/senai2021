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
<title>Buscar ou localizar item</title>
</head>
<body>
	<form method="GET">
		<label>ID</label><input type="number" name="id" required>
		<input type="submit" value="Buscar">
	</form>
	<%
		String id = request.getParameter("id");
		Bem bem; //Instanciamos um item (Bem)
		if(id != null){//Verifica se o cliente enviou um ID
			bem = new Bem(Integer.parseInt(id));//Cria o objeto só com o ID
			if(BensProcess.bens.contains(bem)){//Verifica se este bem está na lista
				int indice = BensProcess.bens.indexOf(bem); //Obtem o índice
				bem = BensProcess.bens.get(indice); //Pega todos os dados
				String url = "alterar.jsp"+bem.toURL();
				response.sendRedirect(url);
			}else{
				out.print("<p>Bem não foi encontrado</p>");
			}
		}else{
			out.print("<p>Digite um id e clique em Buscar</p>");
		}
	%>
</body>
</html>

