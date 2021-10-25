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
		// READ caso seja enviado um 'id_cliente' pesquisa o mesmo sen�o mostra todos
		String idCliente = req.getParameter("id_cliente");
		try {
			ClienteProcess.carregarTodos();
			if (idCliente != null) {
				if (ClienteProcess.clientes.contains(new Cliente(idCliente))) {
					int indice = ClienteProcess.clientes.indexOf(new Cliente(idCliente));
					out.print(ClienteProcess.clientes.get(indice).toJSON());
				} else {// Se o id_cliente n�o foi encontrado responde apenas com erro http 404
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				}
			} else {
				JSONArray ja = new JSONArray();
				for (Cliente c : ClienteProcess.clientes) {
					ja.put(c.toJSON());
				}
				out.print(ja);
			}
		} catch (SQLException e) {
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			out.print("{ \"erro\":\"Erro ao carregar dados do BD: " + e + "\"}");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String body = req.getReader().readLine();// L� apenas a primeira linha do corpo da req.
		out = resp.getWriter(); // Configura out como sa�da de resp.
		if (body != null) {// Se a primeira linha n�o for nula
			req.getReader().reset();// Reseta a leitura das linhas do corpo da req
			// L� todas as linhas do corpo e converte em uma String
			body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			try {// Tenta enviar os dados para o controller processar
				int idCliente = ClienteProcess.create(body);
				if (idCliente > 0) {// Se os dados foram registrados no banco
					// Responde com status http 201 criado.
					resp.setStatus(HttpServletResponse.SC_CREATED);
					// Retorna tamb�m o Id criado pelo auto_increment Banco de dados
					out.print("{ \"id_cliente\":" + idCliente + "}");
				} else {
					resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
				}
			} catch (SQLException e) {
				out.print("{ \"erro\":\"Erro ao conectar ao SGBD: " + e + "\"}");
				resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			}
		} else {//Se o corpo n�o foi devidamente preenchido
			//Responde com requisi��o n�o aceita erro http 406
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			//Envia a mensagem de como deve ser o corpo JSON da requisi��o
			out.print(
					"{\"cpf\":null,\"nome_completo\":\"Algum nome\",\"endereco\":\"cep,numero,complemento\",\"telefone\":\"numero\"}");
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String body = req.getReader().readLine();// L� apenas a primeira linha do corpo da req.
		out = resp.getWriter(); // Configura out como sa�da de resp.
		if (body != null) {// Se a primeira linha n�o for nula
			req.getReader().reset();// Reseta a leitura das linhas do corpo da req
			// L� todas as linhas do corpo e converte em uma String
			body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			try {// Tenta enviar os dados para o controller processar
				if (ClienteProcess.update(body)) {// Se os dados foram registrados no banco
					// Responde com status http 410 alterado.
					resp.setStatus(HttpServletResponse.SC_GONE);
				} else {
					resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
				}
			} catch (SQLException e) {
				out.print("{ \"erro\":\"Erro ao conectar ao SGBD: " + e + "\"}");
				resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			}
		} else {//Se o corpo n�o foi devidamente preenchido
			//Responde com requisi��o n�o aceita erro http 406
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			//Envia a mensagem de como deve ser o corpo JSON da requisi��o
			out.print(
					"{\"id_cliente\":\"1\",\"cpf\":null,\"nome_completo\":\"Algum nome\",\"endereco\":\"cep,numero,complemento\",\"telefone\":\"numero\"}");
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
				out.print("{ \"erro\":\"Erro ao conectar ao SGBD: " + e + "\"}");
				resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			}
		} else {
			out.print("{ \"erro\":\"Necess�rio o par�metro 'id_cliente' para exclus�o\"}");
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
	}
}
