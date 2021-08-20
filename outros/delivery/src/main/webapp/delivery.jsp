<%@page import="vo.Pedido"%>
<%@page import="ctr.PedidoProcess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="delivery.css">
<link rel="shortcut icon" href="./assets/icon-motoboy.png">
<title>Delivery Lanchão</title>
</head>

<body onload="preencherForm(), obterAgora()">
	<%
	PedidoProcess.abrir();
	%>
	<div class="pedido">
		<form>
			<label>Cliente:</label><input type="text" id="cliente"> <label>Endereço:</label><input
				type="text" id="endereco"> <label>Produto:</label><select
				id="produto">
			</select>
			<button type="button"
				onclick="lancarPedido(), preencherForm(), obterAgora()">Gerar
				Pedido</button>
			<input type="text" id="agora" readonly="readonly">
		</form>
	</div>
	<div class="pedidos">
		<div class="producao">
			<h4>Em execução</h4>
			<%
			for (Pedido p : PedidoProcess.pedidos) {
				out.print("<div class='card'><div class='dados'>");
				out.print(p.toHTML());
				out.print("</div><button type='button'><img width='50px' src='./assets/icon-check.png'>Enviar Entrega</button></div>");
			}
			%>
		</div>
		<div class="entrega">
			<h4>A caminho</h4>
		</div>
	</div>
</body>
<script src="delivery.js"></script>
<script src="./uteis/uteis.js"></script>
</html>