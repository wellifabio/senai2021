package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.ClienteDAO;
import domains.Cliente;

public class ClienteProcess {
	
	public static ClienteDAO cd;
	public static ArrayList<Cliente> clientes;
	
	public static void carregarDados() throws SQLException {
		cd = new ClienteDAO();
		clientes = cd.readAll();
	}

}
