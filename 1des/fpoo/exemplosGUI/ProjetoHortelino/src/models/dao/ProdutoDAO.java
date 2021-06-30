package models.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.Produto;

public class ProdutoDAO {

	//DAO (Data Access Object = Objeto de Acesso a Dados)
	private Produto produto;
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = ".\\bd\\produtos.csv";
	private String[] campos;
	
	public boolean save(ArrayList<Produto> produtos) {
		boolean retorno = false;
		try {
			bw = new BufferedWriter(new FileWriter(arquivo,false));
			for(Produto p: produtos) {
				bw.write(p.toCSV());
			}
			bw.close();
			retorno = true;
		} catch (IOException e) {
			System.out.println("Erro ao salvar "+e);
		}
		return retorno;
	}
	
	public ArrayList<Produto> open(){
		ArrayList<Produto> produtos = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(arquivo));
				String linha = br.readLine();
				while(linha != null) {
					campos = linha.split(";");
					
					produto =  new Produto();
					produto.setCodigo(Integer.parseInt(campos[0]));
					produto.setNome(campos[1]);
					produto.setDescricao(campos[2]);
					produto.setPreco(Double.parseDouble(campos[3]));
					produto.setQuantidade(Integer.parseInt(campos[4]));
					produtos.add(produto);
					
					linha = br.readLine();
				}
				br.close();
		} catch (FileNotFoundException e) {
			System.out.println("O arquivo não foi encontrado.");
		} catch (IOException e) {
			System.out.println("Arquivo corrompido.");
		}
		return produtos;
	}
}
