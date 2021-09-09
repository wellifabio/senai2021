package controllers;

import java.util.Locale;
import java.util.Random;

import domains.Produto;

public class ProdutoUtil {

	private static String[] nomes = { "Gabinete", "Teclado", "Mouse", "Monitor", "Memória RAM", "HD", "SSD",
			"Processador", "Cabo de rede", "Plug RJ45" };
	private static String[][] descricoes = {
			{ "Gabinete ATX 12V Vertical", "Teclado Mecânico", "Mouse Básico", "Monitor 19''",
					"Pente de Memoria RAM 4GB", "HD 1TB", "SSD 127GB", "Processador i5 10º geracao", "Cabo de rede CAT5E",
					"Plug RJ45 CAT5E" },
			{ "Gabinete ATX 12V Horizontal", "Teclado Eletônico", "Mouse Gamer", "Monitor 21''",
					"Pente de Memoria RAM 16GB", "HD 1TB", "SSD 255GB", "Processador i5 9º geracao", "Cabo de rede CAT6E",
					"Plug RJ45 CAT6E" },
			{ "Gabinete Compacto", "Teclado EletroMecânico", "Mouse Profissional", "Monitor 23''",
					"Pente de Memoria RAM 8GB", "HD 1TB", "SSD 512GB", "Processador i7 10º geracao", "Cabo de rede CAT6E Blindado",
					"Plug RJ45 CAT6E com capa" } };
	private static Random rand = new Random();

	public static Produto getAleatorio() {
		Locale.setDefault(new Locale("en", "US"));
		int i = rand.nextInt(nomes.length - 1);
		String valor = String.format("%.2f", (rand.nextFloat() * 1000));
		String quantidade = String.format("%d", rand.nextInt(10));
		return new Produto(nomes[i], descricoes[rand.nextInt(3)][i], valor, quantidade);
	}
}
