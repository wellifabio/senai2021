package spring.delivery.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import spring.delivery.dao.ItemDAO;
import spring.delivery.domains.Item;

public class ItemProcess {

	public static ItemDAO id;
	public static ArrayList<Item> itens;
	
	public static void carregarDados() throws SQLException {
		id = new ItemDAO();
		itens = id.readAll();
	}
}
