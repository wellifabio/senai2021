<%@page import="ctr.PedidoProcess"%>
<%@page import="vo.Pedido"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="delivery.css">
<link rel="shortcut icon" href="./assets/icon.png">
<title>Altera Pedido</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String cliente = request.getParameter("cliente");
	String endereco = request.getParameter("endereco");
	String produto = request.getParameter("produto");
	String data = request.getParameter("data");
	String horaPedido = request.getParameter("horaPedido");
	String horaInicioEntrega = request.getParameter("horaInicioEntrega");
	String horaFimEntrega = request.getParameter("horaFimEntrega");
	String acao = request.getParameter("acao");
	if (id != null && acao == null) {
	%>
	<div class="pedido">
		<form method="POST" action="update.jsp" class="cadastro">
			<!-- O nome do campo id é alterado para 'acao' para que ao ser enviado saibamos que são os dados alterados-->
			<label>Id:</label><input type="number" id="id" name="acao" value="<%=id%>">
			<label>Cliente:</label><input type="text" id="cliente" name="cliente" value="<%=cliente%>">
			<label>Endereco:</label><input type="text" id="endereco" name="endereco" value="<%=endereco%>">
			<label>Produto:</label><input type="text" id="produto" name="produto" value="<%=produto%>">
			<label>Data:</label><input type="text" id="data" name="data" value="<%=data%>">
			<label>Horário:</label><input type="text" id="horaPedido" name="horaPedido" value="<%=horaPedido%>">
			<label>Início da Entrega:</label><input type="text" id="horaInicioEntrega" name="horaInicioEntrega" value="<%=horaInicioEntrega%>">
			<label>Conclusão da Entrega:</label><input type="text" id="horaFimEntrega" name="horaFimEntrega" value="<%=horaFimEntrega%>">
			<a href="crud.jsp" style="max-width:240px;margin:8px;">Cancelar</a>
			<button type="submit">Alterar Pedido</button>
		</form>
	</div>
	<%
	} else {
	%>
	<label>Aguardando dados para atualizar</label>
	<%
	}
	if(acao != null){//Executa a efetiva ação de Update
		//Configura um novo modelo com os dados alterados
		Pedido pedido = new Pedido(acao,cliente,endereco,produto,data,horaPedido,horaInicioEntrega,horaFimEntrega);
		//Encontra o índice na lista vinda do controle
		int indice = PedidoProcess.pedidos.indexOf(pedido);
		PedidoProcess.pedidos.set(indice,pedido);//Efetua a alteração no item correto
		if(PedidoProcess.salvar()){//Salva no arquivo
			response.sendRedirect("crud.jsp");//Redireciona para a pagina que lista todos
		}
	}
	%>
</body>
</html>