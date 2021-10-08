package servlet;

import java.io.IOException;
import java.sql.SQLException;

import org.json.JSONArray;

import controllers.ItemProcess;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/itens")
public class ItemREST extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ItemProcess.carregarDados();
			JSONArray ja = new JSONArray();
			ItemProcess.itens.forEach(i -> ja.put(i.toJSON()));
			resp.getWriter().print(ja);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
