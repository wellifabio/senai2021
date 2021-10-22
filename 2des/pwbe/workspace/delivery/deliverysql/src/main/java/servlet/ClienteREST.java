package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.stream.Collectors;

import org.json.JSONArray;

import controllers.ClienteProcess;
import domains.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/clientes")
public class ClienteREST extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private PrintWriter out;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out = resp.getWriter();
		try {
			ClienteProcess.carregarDados();
			JSONArray ja = new JSONArray();
			for (Cliente c : ClienteProcess.clientes) {
				ja.put(c.toJSON());
			}
			out.print(ja);
		} catch (SQLException e) {
			System.out.println("Erro ao carregar dados do BD: " + e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		out = resp.getWriter();
		try {
			int idCliente = ClienteProcess.create(body);
			if (idCliente > 0) {
				resp.setStatus(HttpServletResponse.SC_CREATED);
				out.print("{ \"id_cliente\":"+idCliente+"}");
			} else {
				resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com SGBD: " + e);
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out = resp.getWriter();
		String idCliente = req.getParameter("id_cliente");
		if (idCliente != null) {
			try {
				if (ClienteProcess.delete(idCliente)) {
					resp.setStatus(HttpServletResponse.SC_OK);
				} else {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				}
			} catch (SQLException e) {
				System.out.println("Erro ao conectar com SGBD: " + e);
				resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			}
		} else {
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			out.print("{ \"erro\":\"Necessário o parâmetro 'id' para exclusão\"}");
		}
	}
}
