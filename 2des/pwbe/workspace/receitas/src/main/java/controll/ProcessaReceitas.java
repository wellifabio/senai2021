package controll;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import dao.ReceitaDAO;
import model.Receita;

@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/procreceitas")
public class ProcessaReceitas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Receita r;
	private ReceitaDAO rd = new ReceitaDAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Processa o recebimento da imagen
		Part file = null;
		String fileName = null;
		if (req.getPart("foto") != null) {
			file = req.getPart("foto");
			fileName = file.getSubmittedFileName();
		}

		String acao = req.getParameter("action");

		if (acao == null) {
			Mensagem.addMensagem("Nenhuma ação enviada");
			resp.sendRedirect("receitas.jsp");
		} else {
			switch (acao) {
			case "create":
				r = new Receita();
				r.setNome(req.getParameter("nome").toString());
				r.setIngredientes(req.getParameter("ingredientes").toString());
				r.setModoDeFazer(req.getParameter("modo_de_fazer").toString());
				// Processa a imagen
				if (!fileName.isEmpty()) {
					InputStream is = file.getInputStream();
					r.setFoto(is);
				}
				try {
					if (rd.create(r)) {
						Mensagem.addMensagem("Receita e imagem enviadas com sucesso!");
					} else
						Mensagem.addMensagem("Erro ao enviar receita!");
				} catch (SQLException e) {
					Mensagem.addMensagem("Erro: " + e);
				}
				resp.sendRedirect("receitas.jsp");
				break;
			case "update":
				r = new Receita();
				r.setId(Integer.parseInt(req.getParameter("id").toString()));
				r.setNome(req.getParameter("nome").toString());
				r.setIngredientes(req.getParameter("ingredientes").toString());
				r.setModoDeFazer(req.getParameter("modo_de_fazer").toString());
				// Processa a imagem
				if (!fileName.isEmpty()) {
					InputStream is = file.getInputStream();
					r.setFoto(is);
				}
				try {
					if (rd.update(r))
						Mensagem.addMensagem("Receita e imagem atualizadas com sucesso!");
					else
						Mensagem.addMensagem("Erro ao processar alterção!");
				} catch (SQLException e) {
					Mensagem.addMensagem("Erro: " + e);
				}
				resp.sendRedirect("receitas.jsp");
				break;
			case "delete":
				int id = Integer.parseInt(req.getParameter("id").toString());
				try {
					if (rd.delete(id))
						Mensagem.addMensagem("Receita excluida com sucesso!");
					else
						Mensagem.addMensagem("Erro ao processar exclusão!");
				} catch (SQLException e) {
					Mensagem.addMensagem("Erro: " + e);
				}
				resp.sendRedirect("receitas.jsp");
				break;
			default:
				Mensagem.addMensagem("Ação inválida");
				resp.sendRedirect("receitas.jsp");
				break;
			}
		}
	}
}
