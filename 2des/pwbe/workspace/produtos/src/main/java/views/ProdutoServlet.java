package views;

import java.io.IOException;

import controllers.ProdutoProcess;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Produto;

@WebServlet("/rotaget")
public class ProdutoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		ProdutoProcess.iniciar();
		String id = req.getParameter("id");
		
		if(id != null) {
			Produto prod = new Produto();
			prod.setId(req.getParameter("id"));
			prod.setNome(req.getParameter("nome"));
			prod.setDescricao(req.getParameter("descricao"));
			prod.setValor(req.getParameter("valor"));
			prod.setQuantidade(req.getParameter("quantidade"));
			ProdutoProcess.produtos.add(prod);
		}
				
		for(Produto p: ProdutoProcess.produtos) {
			resp.getWriter().print(p.toString());
		}
	}
}
