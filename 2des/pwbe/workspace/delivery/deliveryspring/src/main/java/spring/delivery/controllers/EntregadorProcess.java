package spring.delivery.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import spring.delivery.dao.EntregadorDAO;
import spring.delivery.domains.Entregador;

public class EntregadorProcess {
	
	public static EntregadorDAO ed;
	public static ArrayList<Entregador> entregadores;
	
	public static void carregarDados() throws SQLException {
		ed = new EntregadorDAO();
		entregadores = ed.readAll();
	}
}
