package views;

import java.io.IOException;

import controllers.ProdutoProcess;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Produto;

@WebServlet("/rotarest")
public class ProdutoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		if (ProdutoProcess.produtos == null) {
			ProdutoProcess.iniciar();
		}
		String id = req.getParameter("id");
		if (id != null) {
			for (Produto p : ProdutoProcess.produtos) {
				if (p.getId() == Integer.valueOf(id)) {
					resp.getWriter().print(p.toString());
				}
			}
		} else {
			for (Produto p : ProdutoProcess.produtos) {
				resp.getWriter().print(p.toString());
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id != null) {
			Produto prod = new Produto();
			prod.setId(req.getParameter("id"));
			prod.setNome(req.getParameter("nome"));
			prod.setDescricao(req.getParameter("descricao"));
			prod.setValor(req.getParameter("valor"));
			prod.setQuantidade(req.getParameter("quantidade"));
			ProdutoProcess.produtos.add(prod);
			resp.getWriter().print("Post Recebido");
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id != null) {
			Produto produto = new Produto(id);
			if (ProdutoProcess.produtos.contains(produto)) {
				ProdutoProcess.produtos.remove(produto);
			} else {
				resp.getWriter().print("Produto não encontrado");
			}
		}
	}

}
