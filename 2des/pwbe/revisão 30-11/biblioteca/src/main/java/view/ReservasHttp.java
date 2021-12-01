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
		JSONArray arr = rp.read();
		pw = resp.getWriter();
		pw.write(arr.toString());
	}
	
}
