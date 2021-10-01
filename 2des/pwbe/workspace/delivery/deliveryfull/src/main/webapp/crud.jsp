<%@page import="vo.Pedido"%>
<%@page import="ctr.PedidoProcess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="delivery.css">
<link rel="shortcut icon" href="./assets/icon.png">
<title>Todos os pedidos (CRUD)</title>
</head>
<body>
	<a href="delivery.jsp">Voltar para Pedidos</a>
	<div class='pedidos'>
		<table>
			<tr>
				<th>Id</th>
				<th>Cliente</th>
				<th>Endereço</th>
				<th>Produto</th>
				<th>Data</th>
				<th>Pedido</th>
				<th>Entrega</th>
				<th>Fim</th>
				<th>Ações</th>
			</tr>
			<%
			PedidoProcess.abrir();
			for (Pedido pedido : PedidoProcess.pedidos) {
				out.print("<tr>");
				out.print(pedido.toTableHTML());
				out.print("<td>");
				out.print("<form action='registra.jsp'>");
				out.print("<input type='hidden' name='del' value='"+pedido.getId()+"'/>");
				out.print("<input type='submit' class='del' value=' '/>");
				out.print("</form>");
				out.print("<form action='registra.jsp'>");
				out.print("<input type='hidden' name='update' value='"+pedido.getId()+"'/>");
				out.print("<input type='submit' class='update' value=' '/>");
				out.print("</form>");
				out.print("</td>");
				out.print("</tr>");
			}
			%>
		</table>
	</div>

</body>
</html>