package rotas;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rota1")
public class Servlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(HttpServletResponse.SC_OK); // Retorna sucesso com o c�difo 200
		resp.setContentType("application/json"); // Configura a saída no formato JSON
		resp.setCharacterEncoding("utf-8"); //Codifica a resposta em UTF-8
		
		String dados = req.getParameter("entrada");
		if(dados == null) {
			resp.getWriter().print("Aguardando requisições"); //Imprime mensagem no navegador
		}else {
			resp.getWriter().print("Opa chegou o nome " + dados + " com " + dados.length() + " caracteres"); //Imprime mensagem no navegador	
		}
	}

}
