package spring.delivery.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import spring.delivery.dao.PedidoDAO;
import spring.delivery.domains.Pedido;

public class PedidoProcess {
	
	public static PedidoDAO pd;
	public static ArrayList<Pedido> pedidos;
	
	public static void carregarDados() throws SQLException {
		pd = new PedidoDAO();
		pedidos = pd.readAll();
	}
		
}
