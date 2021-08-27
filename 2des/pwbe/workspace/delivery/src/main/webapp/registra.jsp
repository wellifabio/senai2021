<%@page import="ctr.PedidoProcess"%>
<%@page import="vo.Pedido"%>
<%

Pedido pedido;
String verboHttp = request.getMethod();
String cliente = request.getParameter("cliente");
String endereco = request.getParameter("endereco");
String produto = request.getParameter("produto");
String inicio = request.getParameter("inicio");
String fim = request.getParameter("fim");
String del = request.getParameter("del");
String update = request.getParameter("update");

if (verboHttp.equals("POST")) {
	if (cliente != null && endereco != null && produto != null) {
		pedido = new Pedido(cliente, endereco, produto);
		PedidoProcess.pedidos.add(pedido);
		if (PedidoProcess.salvar()) {
			response.sendRedirect("delivery.jsp?mensagem=Salvo%com%sucesso");
		} else {
			response.sendRedirect("delivery.jsp?mensagem=Erro%ao%salvar%no%arquivo%CSV");
		}
	}
	if (inicio != null) {
		pedido = new Pedido(inicio);
		if (PedidoProcess.pedidos.contains(pedido)) {
			int indice = PedidoProcess.pedidos.indexOf(pedido);
			PedidoProcess.pedidos.get(indice).setHoraInicioEntrega();
			if (PedidoProcess.salvar()) {
				response.sendRedirect("delivery.jsp?mensagem=Enviado%para%entrega");
			} else {
				response.sendRedirect("delivery.jsp?mensagem=Erro%ao%salvar%no%arquivo%CSV");
			}
		}
	}
	
	if (fim != null) {
		pedido = new Pedido(fim);
		if (PedidoProcess.pedidos.contains(pedido)) {
			int indice = PedidoProcess.pedidos.indexOf(pedido);
			PedidoProcess.pedidos.get(indice).setHoraFimEntrega();
			if (PedidoProcess.salvar()) {
				response.sendRedirect("delivery.jsp?mensagem=Entregue%com%sucesso");
			} else {
				response.sendRedirect("delivery.jsp?mensagem=Erro%ao%salvar%no%arquivo%CSV");
			}
		}
	}
}

if (verboHttp.equals("GET")){
	if(del!=null){
		pedido = new Pedido(del);
		if (PedidoProcess.pedidos.contains(pedido)){
			int indice = PedidoProcess.pedidos.indexOf(pedido);
			PedidoProcess.pedidos.remove(indice);
			if (PedidoProcess.salvar()) {
				response.sendRedirect("crud.jsp");
			} else {
				response.sendRedirect("crud.jsp?mensagem=Erro%ao%salvar%no%arquivo%CSV");
			}
		}
	}
	if(update!=null){
		pedido = new Pedido(update);
		if (PedidoProcess.pedidos.contains(pedido)){
			int indice = PedidoProcess.pedidos.indexOf(pedido);
			pedido = PedidoProcess.pedidos.get(indice);
			response.sendRedirect("update.jsp"+pedido.toURL());
		}
	}
}
%>
