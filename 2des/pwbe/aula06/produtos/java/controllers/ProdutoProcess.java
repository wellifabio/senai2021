package controllers;

import java.util.ArrayList;

import domains.Produto;
import domains.dao.ProdutoDAO;

public class ProdutoProcess {

	//Atributos básicos do controle (Lista e DAO)
	public static ArrayList<Produto> produtos;
	public static ProdutoDAO pd = new ProdutoDAO();

	//Métodos básicos para abrir e salvar o arquivo
	public static void abrir() {
		produtos = pd.abrir();
	}

	public static void salvar() {
		pd.salvar(produtos);
	}

	//Método que obtem o total geral
	public static double total() {
		if (produtos.size() <= 0) {
			return 0;
		} else {
			double total = 0;
			for(Produto p: produtos) {
				total += p.getSubtotal();
			}
			return total;
		}
	}

	//Método que obtêm um idautomático
	public static int autoId() {
		if (produtos.size() <= 0) {
			return 1;
		} else {
			return produtos.get(produtos.size() - 1).getId() + 1;
		}
	}
	
	//Gerador de testes aleatórios
	public static void testes(int n) {
		produtos = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			produtos.add(ProdutoUtil.getAleatorio());
		}
	}
}
