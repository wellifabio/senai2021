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
<title>Alterar ou Excluir Bem(CREATE)</title>
</head>
<body>
	<%
		Bem bem;
		int indice = 0;
		String id = request.getParameter("id");
		String desc = request.getParameter("descricao");
		String dat = request.getParameter("data");
		String val = request.getParameter("valor");
		String opcao = request.getParameter("opcao");
		if(id != null && desc != null && val != null && dat != null){
			if(opcao != null){
				switch(opcao){
					case "excluir":
						bem = new Bem(Integer.parseInt(id));
						indice = BensProcess.bens.indexOf(bem);
						BensProcess.bens.remove(indice);
						break;
					case "alterar":
						bem = new Bem(Integer.parseInt(id),desc,dat,Double.parseDouble(val));
						indice = BensProcess.bens.indexOf(bem);
						BensProcess.bens.set(indice,bem);
						break;
				}
				out.print(BensProcess.salvar());
				response.sendRedirect("listar.jsp");
			} else {
				String formulario = "";
				formulario += "<form method='get'>";
				formulario += "<label>ID</label><input type='number' value='"+id+"' name='id' required>";
				formulario += "<label>Descrição</label><input type='text' value='"+desc+"' name='descricao' required>";
				formulario += "<label>Data</label><input type='text' value='"+dat+"' name='data' required>";
				formulario += "<label>Valor</label><input type='number' value='"+val+"' name='valor' required>";
				formulario += "<div><label>Excluir</label><input type='radio' name='opcao' value='excluir'>";
				formulario += "<label>Alterar</label><input type='radio' name='opcao' value='alterar'></div>";
				formulario += "<input type='submit' value='Enviar'>";
				formulario += "</form>";
				out.print(formulario);
			}	
		}else{
			out.print("<p>não chegaram dados para serem alterados ou excluidos</p>");
		}
	%>
</body>
</html>

