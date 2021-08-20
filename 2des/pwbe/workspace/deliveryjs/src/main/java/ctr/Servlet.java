package ctr;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Pedido;

@WebServlet("/registra")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Pedido pedido;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/xml");
		String cliente = request.getParameter("cliente");
		String endereco = request.getParameter("endereco");
		String produto = request.getParameter("produto");
		if (cliente != null && endereco != null && produto != null) {
			pedido = new Pedido(cliente, endereco, produto);
			PedidoProcess.pedidos.add(pedido);
			if (PedidoProcess.salvar()) {
				response.getWriter().print("<id>" + pedido.getId() + "</id>");
			} else {
				response.getWriter().print("<erro>Erro ao registrar no arquivo CSV</erro>");
			}
		} else {
			response.getWriter().print("<erro>Faltam dados para o registro</erro>");
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/xml");
		String inicio = req.getParameter("inicio");
		if (inicio != null) {
			pedido = new Pedido(inicio);
			if (PedidoProcess.pedidos.contains(pedido)) {
				int indice = PedidoProcess.pedidos.indexOf(pedido);
				PedidoProcess.pedidos.get(indice).setHoraInicioEntrega();
				if (PedidoProcess.salvar()) {
					resp.getWriter().print("<id>" + pedido.getId() + "</id>");
				} else {
					resp.getWriter().print("<erro>Erro ao alterar dados no arquivo</erro>");
				}
			}
		} else {
			resp.getWriter().print("<erro>É necessário que envie o id do pedido no campo inicio</erro>");
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/xml");
		String fim = req.getParameter("fim");
		if (fim != null) {
			pedido = new Pedido(fim);
			if (PedidoProcess.pedidos.contains(pedido)) {
				int indice = PedidoProcess.pedidos.indexOf(pedido);
				PedidoProcess.pedidos.get(indice).setHoraFimEntrega();
				if (PedidoProcess.salvar()) {
					resp.getWriter().print("<id>" + pedido.getId() + "</id>");
				} else {
					resp.getWriter().print("<erro>Erro ao alterar dados no arquivo</erro>");
				}
			}
		} else {
			resp.getWriter().print("<erro>É necessário que envie o id do pedido no campo fim</erro>");
		}
	}
}
