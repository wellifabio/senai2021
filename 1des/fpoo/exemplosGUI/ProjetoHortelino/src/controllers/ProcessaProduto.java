package controllers;

import java.util.ArrayList;

import models.Produto;
import models.dao.ProdutoDAO;

public class ProcessaProduto {

	private static ProdutoDAO pd = new ProdutoDAO();
	private static ArrayList<Produto> produtos = pd.open();

	// GETs && SETs
	public static ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public static void setProdutos(ArrayList<Produto> produtos) {
		ProcessaProduto.produtos = produtos;
		pd.save(produtos);
	}

	public static ProdutoDAO getPd() {
		return pd;
	}

	public static void setPd(ProdutoDAO pd) {
		ProcessaProduto.pd = pd;
	}

	// Retorna apenas um produto a partir do código
	public static Produto getProduto(int codigo) {
		Produto produto = new Produto(codigo);
		if (produtos.contains(produto)) {
			return produtos.get(produtos.indexOf(produto));
		}
		return null;
	}

	// Retorna o código do produto adicionando 1 ao ultimo codigo da lista
	public static int getAutoCodigo() {
		if (ProcessaProduto.produtos.isEmpty())
			return 1;
		else
			return ProcessaProduto.produtos.get(ProcessaProduto.produtos.size() - 1).getCodigo() + 1;
	}

	public static int getTotalItens() {
		int total = 0;
		for (Produto p : produtos) {
			total += p.getQuantidade();
		}
		return total;
	}

	public static double getTotalDinheiro() {
		double total = 0;
		for (Produto p : produtos) {
			total += p.getSubtotal();
		}
		return total;
	}
}
