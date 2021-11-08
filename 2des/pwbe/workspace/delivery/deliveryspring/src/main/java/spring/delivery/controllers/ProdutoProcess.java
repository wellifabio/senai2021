package spring.delivery.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import spring.delivery.dao.ProdutoDAO;
import spring.delivery.domains.Produto;

public class ProdutoProcess {

	public static ProdutoDAO pd;
	public static ArrayList<Produto> produtos;
		
	public static void carregarDados() throws SQLException {
		pd =  new ProdutoDAO();
		produtos = pd.readAll();
	}
	
}
