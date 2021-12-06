package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;

import controll.ServicoProcess;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Servico;

@WebServlet("/servicos")
public class ServicoHTTP extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private int indice = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		String id = req.getParameter("id");
		try {
			ServicoProcess.carregar();
			if(id != null) {
				if(ServicoProcess.servicos.contains(new Servico(id))) {
					indice = ServicoProcess.servicos.indexOf(new Servico(id));
					resp.getWriter().print(ServicoProcess.servicos.get(indice).toJSON());
				}else {
					resp.setStatus(404);
				}
			}else {
				JSONArray ja = new JSONArray();
				for(Servico s : ServicoProcess.servicos) {
					ja.put(s.toJSON());
				}
				resp.getWriter().print(ja);				
			}
		} catch (SQLException e) {
			resp.setStatus(404);
			resp.getWriter().print("{\"erro_bd\" \"" + e + "\" }" );
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		try {
			if(ServicoProcess.create(body)) {
				resp.setStatus(201);
			}else {
				resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			}
		} catch (JSONException | SQLException e) {
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			resp.getWriter().print("{\"erro_bd\" \"" + e + "\" }" );
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		try {
			if(ServicoProcess.atualizar(body)) {
				resp.setStatus(HttpServletResponse.SC_ACCEPTED);
			}else {
				resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			}
		} catch (JSONException | SQLException e) {
			resp.getWriter().print("{\"erro_bd\" \"" + e + "\" }" );
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getParameter("id");
		try {
			if(ServicoProcess.apagar(url)) {
				resp.setStatus(HttpServletResponse.SC_GONE);
			}else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (SQLException e) {
			resp.getWriter().print("{\"erro_bd\" \"" + e + "\" }" );
		}
	}
	

}
