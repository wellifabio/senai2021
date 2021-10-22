package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import dao.ClienteDAO;
import domains.Cliente;

public class ClienteProcess {
	
	public static ClienteDAO cd;
	public static ArrayList<Cliente> clientes;
	public static Cliente cliente;
	private static JSONObject jo;
	
	public static void carregarDados() throws SQLException {
		cd = new ClienteDAO();
		clientes = cd.readAll();
	}
	
	public static int create(String body) throws SQLException {
		cd = new ClienteDAO();
		try {
			jo = new JSONObject(body);
			cliente = new Cliente();
			cliente.setCpf(jo.getString("cpf"));
			cliente.setNomeCompleto(jo.getString("nome_completo"));
			cliente.setEndereco(jo.getString("endereco"));
			cliente.setTelefone(jo.getString("telefone"));
		} catch (JSONException e) {
			System.out.println("Erro ao receber JSON:"+e);
		}
		return cd.create(cliente);
	}
	
	public static boolean delete(String id) throws SQLException {
		cd = new ClienteDAO();
		return cd.delete(id);
	}
}
