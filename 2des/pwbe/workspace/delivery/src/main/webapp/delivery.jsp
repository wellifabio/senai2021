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
<title>Delivery Lanchão</title>
</head>

<body onload="preencherForm(), obterAgora()">
	<%
	PedidoProcess.abrir();
	%>
	<div class="pedido">
		<form method="POST" action="registra.jsp" class="cadastro">
			<label>Cliente:</label><input type="text" id="cliente" name="cliente"> 
			<label>Endereço:</label><input type="text" id="endereco" name="endereco">
			<label>Produto:</label><select id="produto" name="produto">
			</select>
			<button type="submit"
				onclick="lancarPedido(), preencherForm(), obterAgora()">Gerar
				Pedido</button>
			<input type="text" id="agora" readonly="readonly">
		</form>
	</div>
	<a href="crud.jsp">Todos os pedidos Relatório</a>
	<div class="pedidos">
		<div class="producao">
			<h4>Em execução</h4>
			<%
			for (Pedido p : PedidoProcess.pedidos) {
				if(p.getHoraInicioEntrega() == null && p.getHoraFimEntrega() == null){
					out.print("<div class='card'><div class='dados'>");
					out.print(p.toHTML());
					out.print("</div>");
					out.print("<form method='POST' action='registra.jsp'>");
					out.print("<input type='hidden' name='inicio' value='"+p.getId()+"'>");
					out.print("<button type='submit'><img width='50px' src='./assets/icon-check.png'>Enviar Entrega</button>");
					out.print("</form></div>");
				}
			}
			%>
		</div>
		<div class="entrega">
			<h4>A caminho</h4>
			<%
			for (Pedido p : PedidoProcess.pedidos) {
				if(p.getHoraInicioEntrega() != null && p.getHoraFimEntrega() == null){
					out.print("<div class='card'><div class='dados'>");
					out.print(p.toHTML());
					out.print("</div>");
					out.print("<form method='POST' action='registra.jsp'>");
					out.print("<input type='hidden' name='fim' value='"+p.getId()+"'>");
					out.print("<button type='submit'><img width='50px' src='./assets/icon-motoboy.png'>Enviar Entrega</button>");
					out.print("</form></div>");
				}
			}
			%>
		</div>
	</div>
</body>
<script src="./uteis/uteis.js"></script>
</html>