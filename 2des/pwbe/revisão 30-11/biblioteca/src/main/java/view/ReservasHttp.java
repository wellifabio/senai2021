package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import controller.ReservasProcess;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Reservas;

@WebServlet("/reservas")
public class ReservasHttp extends HttpServlet {
	
	private PrintWriter pw;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		pw = resp.getWriter();
		
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		try {
			JSONObject obj = new JSONObject(body);
			
			String nomePessoa = obj.getString("nome_pessoa");
			String nomeLivro = obj.getString("nome_livro");
			String data = obj.getString("data_devolucao");
			
			Reservas reserva = new Reservas();
			reserva.setNomeLivro(nomeLivro);
			reserva.setNomePessoa(nomePessoa);
			reserva.setDataDevolucao(data);
			
			ReservasProcess rp = new ReservasProcess();
			
			if(rp.create(reserva)) {
				obj.put("id", reserva.getId());
				pw.write(obj.toString());
			}else {
				resp.setStatus(402);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReservasProcess rp = new ReservasProcess();
		pw = resp.getWriter();
		
		String nomePessoa = req.getParameter("nome_pessoa");
		String nomeLivro = req.getParameter("nome_livro");
		
		JSONArray arr = rp.read(nomePessoa, nomeLivro);
				
		pw.write(arr.toString());
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		pw = resp.getWriter();
		ReservasProcess rp = new ReservasProcess();
		
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		try {
			JSONObject obj = new JSONObject(body);
			
			String nomePessoa = obj.getString("nome_pessoa");
			String nomeLivro = obj.getString("nome_livro");
			String data = obj.getString("data_devolucao");
			int id = obj.getInt("id");
			
			Reservas reserva = new Reservas();
			reserva.setId(id);
			reserva.setNomePessoa(nomePessoa);
			reserva.setNomeLivro(nomeLivro);
			reserva.setDataDevolucao(data);
			
			if(rp.update(reserva) == true) {
				pw.write(obj.toString());
			}else {
				resp.setStatus(401);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		pw = resp.getWriter();
		ReservasProcess rp = new ReservasProcess();
		
		String tempId = req.getParameter("id");
		int id = Integer.parseInt(tempId);
		
		if(rp.delete(id) == false) {
			resp.setStatus(401);
		}
	}
	
}
