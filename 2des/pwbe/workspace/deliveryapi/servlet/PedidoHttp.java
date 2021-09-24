package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import org.json.JSONArray;
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
		// Configurações
		PrintWriter out = resp.getWriter();// Configurar a saida de resto resp
		resp.setContentType("application/json"); // Configura a resposta no formato JSON
		resp.setCharacterEncoding("utf8");// Configura o charset

		// Lendo os dados do BD "CSV"
		PedidoProcess.abrir();

		// Recebendo dados por Parâmetros
		String id = req.getParameter("id"); // Recebe um "parâmetro" via URI "?id=2"
		String cliente = req.getParameter("cliente"); // Recebe um "parâmetro" via URI "?id=2"
		if (id != null) {// Verifica se chegou o parâmetro "id"
			if (PedidoProcess.pedidos.contains(new Pedido(id))) {
				int indice = PedidoProcess.pedidos.indexOf(new Pedido(id));// Obtem o indice
				out.print(PedidoProcess.pedidos.get(indice).toJSON());
			} else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				// out.print("{ \"erro\": \"Id não encontrado\" }");
			}
		} else if (cliente != null) {// Filtra pelo parâmetro cliente
			for (Pedido p : PedidoProcess.pedidos) {
				if (p.getCliente().contains(cliente)) {
					out.print(p.toJSON());
				}
			}
		} else {
			JSONArray vetor = new JSONArray(); // Cria um vetor para armazenar cada obj json
			for (Pedido p : PedidoProcess.pedidos) {
				vetor.put(p.toJSON());// Preenche o vetor
			}
			out.print(vetor);// Mostra o vetor
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Lendo os dados do BD "CSV"
		PedidoProcess.abrir();

		// Lê o corpo da requisição HTTP
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

		try {
			// Decofigica o corpo em JSON
			JSONObject json = new JSONObject(body);
			String cliente = json.getString("cliente"); // Pega o parâmetro JSON
			String endereco = json.getString("endereco"); // Pega o parâmetro JSON
			String produto = json.getString("produto"); // Pega o parâmetro JSON

			// Adiciona a lista do controle
			PedidoProcess.pedidos.add(new Pedido(cliente, endereco, produto));
			PedidoProcess.salvar();// Salva no arquivo CSV
			// Retorna o código HTTP 201 de sucesso
			resp.setStatus(HttpServletResponse.SC_CREATED);

		} catch (JSONException e) {
			// Mensagem de erro no Console
			System.out.println("Erro na conversão para JSON: " + e);
			// Retorna código de erro para o Cliente
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);

		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Lendo os dados do BD "CSV"
		PedidoProcess.abrir();
		// Recebe o Id a ser excluído via parâmtro
		String id = req.getParameter("id"); // Recebe um "parÃ¢metro" via URI "?id=2"

		if (id != null) {// Verifica se chegou o parâmetro "id"
			if (PedidoProcess.pedidos.contains(new Pedido(id))) { // Vê se o ID está na lista
				int indice = PedidoProcess.pedidos.indexOf(new Pedido(id));// Obtem o indice
				PedidoProcess.pedidos.remove(indice);// Remove da lista
				PedidoProcess.salvar();// Salva no arquivo CSV
			} else {
				// Retorna o código http 404 Não encontrado
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} else {
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Lendo os dados do BD "CSV"
		PedidoProcess.abrir();

		// Lê o corpo da requisição HTTP
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

		try {
			// Decofigica o corpo em JSON
			JSONObject json = new JSONObject(body);
			int id = json.getInt("id"); // Obtem o id
			String status = json.getString("status");// Obtem o status início ou fim
			if (id != 0) {// Verifica se chegou o parâmetro "id"
				if (PedidoProcess.pedidos.contains(new Pedido(id))) {
					int indice = PedidoProcess.pedidos.indexOf(new Pedido(id));// Obtem o indice
					switch (status) {
					case "inicio":
						// Configura a hora Inicio da entrega
						PedidoProcess.pedidos.get(indice).setHoraInicioEntrega();
						PedidoProcess.salvar();// Salva no arquivo CSV
						break;
					case "fim":
						// Configura a hora fim da entrega
						PedidoProcess.pedidos.get(indice).setHoraFimEntrega();
						PedidoProcess.salvar();// Salva no arquivo CSV
						break;
					default:
						resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
						break;
					}
				}else {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				}
			}
		} catch (JSONException e) {
			// Mensagem de erro no Console
			System.out.println("Erro na conversão para JSON: " + e);
			// Retorna código de erro para o Cliente
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);

		}
	}
}
