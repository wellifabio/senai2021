package servlet;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import controllers.PedidoProcess;
import domains.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/pedidos")
public class PedidoHttp extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json"); // Configura a saída para JSON
		resp.setCharacterEncoding("utf8"); // Configura o CHARSET
		PedidoProcess.abrir(); // Carrega os dados do Banco de dados
		String linha = req.getReader().readLine(); // Lê a primeira linha do corpo da requisição
		Pedido pedido = null; // Cria um novo pedido Nulo
		if (linha != null) {// Se tiver informações no corpo da requisição
			try {
				JSONObject json = new JSONObject(linha);// Cria um objeto JSON com os dados do corpo da requisição
				pedido = new Pedido(json.getInt("id"));// Cria um novo pedido com o ID recebido via JSON
			} catch (JSONException e) {// Trata o erro de conversão do corpo da requisição para JSON
				System.out.println("Erro ao codificar JSON: " + e);
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		}
		if (pedido == null) { // Se pedido for nulo Listar todos
			String jArray = "["; // String para juntar um array JSON
			// Percorre a lista preenchendo o array
			for (Pedido p : PedidoProcess.pedidos) {
				jArray += p.toJSON() + ",";
			}
			// Remove o �ltimo caracter "," da string e fecha o array "]"
			jArray = jArray.substring(0, jArray.length() - 1) + "]";
			resp.getWriter().print(jArray);
		} else { // Senão verifica se o pedido está na lista e mostra apenas ele
			if (PedidoProcess.pedidos.contains(pedido)) {// Se o pedido está na lista
				int indice = PedidoProcess.pedidos.indexOf(pedido);// Pega o índice do pedido
				resp.getWriter().print(PedidoProcess.pedidos.get(indice).toJSON());// Exibe os dados do pedido
			} else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);// Retorna apenas o código de não encontrado
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json"); // Configura a saída para JSON
		resp.setCharacterEncoding("utf8"); // Configura o CHARSET
		Pedido pedido = null; // Cria um novo pedido Nulo
		PedidoProcess.abrir(); // Carrega os dados do Banco de dados
		String jsonReq = ""; // Variável para obter o corpo no formato JSON da requisição
		String linha = null; // Linha para ler o corpo da requisição
		while ((linha = req.getReader().readLine()) != null) {
			jsonReq += linha;// Laço que lê cada linha da requisição
		}

		try {
			JSONObject json = new JSONObject(jsonReq);// Cria um objeto JSON
			pedido = new Pedido(json.getString("cliente"), json.getString("endereco"), json.getString("produto"));
		} catch (JSONException e) {// Trata o erro de conversão do corpo da requisição para JSON
			System.out.println("Erro ao codificar JSON: " + e);
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			resp.getWriter().print("{\"erro\":\"Para criar um novo pedido preencha: cliente, endereco e produto\"}");
		}

		if (pedido != null) {
			PedidoProcess.pedidos.add(pedido);
			PedidoProcess.salvar();
			resp.setStatus(HttpServletResponse.SC_CREATED);
			resp.getWriter().print(pedido.toJSON());
		} else {
			resp.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json"); // Configura a saída para JSON
		resp.setCharacterEncoding("utf8"); // Configura o CHARSET
		PedidoProcess.abrir(); // Carrega os dados do Banco de dados
		String linha = req.getReader().readLine(); // Lê a primeira linha do corpo da requisição
		Pedido pedido = null; // Cria um novo pedido Nulo
		if (linha != null) {// Se tiver informações no corpo da requisição
			try {
				JSONObject json = new JSONObject(linha);// Cria um objeto JSON com os dados do corpo da requisição
				pedido = new Pedido(json.getInt("id"));// Cria um novo pedido com o ID recebido via JSON
			} catch (JSONException e) {// Trata o erro de conversão do corpo da requisição para JSON
				System.out.println("Erro ao codificar JSON: " + e);
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		}

		if (pedido != null) {
			if (PedidoProcess.pedidos.contains(pedido)) {
				int indice = PedidoProcess.pedidos.indexOf(pedido);// Pega o índice do pedido
				PedidoProcess.pedidos.remove(indice);
				PedidoProcess.salvar();
			} else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} else {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json"); // Configura a saída para JSON
		resp.setCharacterEncoding("utf8"); // Configura o CHARSET
		Pedido pedido = null; // Cria um novo pedido Nulo
		PedidoProcess.abrir(); // Carrega os dados do Banco de dados
		String jsonReq = ""; // Variável para obter o corpo no formato JSON da requisição
		String linha = null; // Linha para ler o corpo da requisição
		while ((linha = req.getReader().readLine()) != null) {
			jsonReq += linha;// Laço que lê cada linha da requisição
		}

		try {
			JSONObject json = new JSONObject(jsonReq);// Cria um objeto JSON
			pedido = new Pedido();
			pedido = new Pedido(json.getString("id"), json.getString("cliente"), json.getString("endereco"),
						json.getString("produto"), json.getString("data"), json.getString("horaPedido"),
						json.getString("horaInicioEntrega"), json.getString("horaFimEntrega"));
		} catch (JSONException e) {// Trata o erro de conversão do corpo da requisição para JSON
			System.out.println("Erro ao codificar JSON: " + e);
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			resp.getWriter().print("{\"erro\":\"Para alterar o pedido preencha todos os campos\"}");
		}

		if (pedido != null) {
			if (PedidoProcess.pedidos.contains(pedido)) {
				int indice = PedidoProcess.pedidos.indexOf(pedido);// Pega o índice do pedido
				PedidoProcess.pedidos.set(indice,pedido);
				PedidoProcess.salvar();
			} else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} else {
			resp.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
		}
	}

}
