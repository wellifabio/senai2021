<%@page import="ctr.PedidoProcess"%>
<%@page import="vo.Pedido"%>
<%
String verboHttp = request.getMethod();
String cliente = request.getParameter("cliente");
String endereco = request.getParameter("endereco");
String produto = request.getParameter("produto");

if (verboHttp.equals("POST")) {
	if (cliente != null && endereco != null && produto != null) {
		Pedido p = new Pedido(cliente, endereco, produto);
		PedidoProcess.pedidos.add(p);
		out.print(p.toString());
		if (PedidoProcess.salvar()) {
			out.print("Dados registrados no arquivo CSV");
		} else {
			out.print("Erro ao registrar no arquivo CSV");
		}
	} else {
		out.print("Faltam dados para o registro");
	}
}
%>
