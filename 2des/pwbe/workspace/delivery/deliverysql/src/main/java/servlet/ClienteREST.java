package servlet;

import java.io.IOException;
import java.sql.SQLException;

import org.json.JSONArray;

import controllers.ClienteProcess;
import domains.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/clientes")
public class ClienteREST extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ClienteProcess.carregarDados();
			JSONArray ja = new JSONArray();
			for(Cliente c: ClienteProcess.clientes) {
				ja.put(c.toJSON());	
			}
			resp.getWriter().print(ja);
		} catch (SQLException e) {
			System.out.println("Erro ao carregar dados do BD: "+e);
		}
	}
}
