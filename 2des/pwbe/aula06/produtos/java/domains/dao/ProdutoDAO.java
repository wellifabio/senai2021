package domains.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import domains.Produto;

public class ProdutoDAO {

	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = "c:\\dbs\\produtos.csv";
	private ArrayList<Produto> produtos;
	private Produto produto;

	public void salvar(ArrayList<Produto> produtos) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo, false));
			for (Produto p : produtos) {
				bw.write(p.toCSV());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Erro ao salvar: " + e);
		}
	}

	public ArrayList<Produto> abrir() {
		produtos = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha = "";
			while ((linha = br.readLine()) != null) {
				produto = new Produto(linha.split(";"));
				produtos.add(produto);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: " + e);
		} catch (IOException e) {
			System.out.println("Erro ao abrir: " + e);
		}
		return produtos;
	}
	
}
