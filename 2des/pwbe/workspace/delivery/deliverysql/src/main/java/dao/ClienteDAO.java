package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domains.Cliente;

public class ClienteDAO {

	private Connection con;
	private PreparedStatement ps;
	private ArrayList<Cliente> clientes;
	private Cliente cliente;
	
	//Listar Todos
	public ArrayList<Cliente> readAll() throws SQLException{
		clientes = new ArrayList<>();
		String query = "select * from clientes;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			cliente = new Cliente();
			cliente.setIdCliente(rs.getInt("id_cliente"));
			cliente.setCpf(rs.getString("cpf"));
			cliente.setNomeCompleto(rs.getString("nome_completo"));
			cliente.setEndereco(rs.getString("endereco"));
			cliente.setTelefone(rs.getString("telefone"));
			clientes.add(cliente);
		}
		con.close();
		return clientes;
	}
}
