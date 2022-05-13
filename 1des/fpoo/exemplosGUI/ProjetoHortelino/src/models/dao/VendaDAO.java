package models.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.Venda;
import models.Produto;

public class VendaDAO {
	
	private Venda compra;
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = System.getProperty("user.dir")+"\\bd\\vendas.csv";
	private String[] campos;
	
	//Salva os dados de uma lista no arquivo
	public boolean save(ArrayList<Venda> compras) {
		boolean retorno = false;
		try {
			bw = new BufferedWriter(new FileWriter(arquivo,false));
			for(Venda c: compras) {
				bw.write(c.toCSV());
			}
			bw.close();
			retorno = true;
		} catch (IOException e) {
			System.out.println("Erro ao salvar "+e);
		}
		return retorno;
	}
	
	//Abre os dados do do arquivo e carrega em uma lista 
	public ArrayList<Venda> open(){
		ArrayList<Venda> compras = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(arquivo));
				String linha = br.readLine();
				while(linha != null) {
					campos = linha.split(";");					
					compra =  new Venda();
					compra.setNum(Integer.parseInt(campos[0]));
					compra.setData(campos[1]);
					compra.setHora(campos[2]);
					compra.setProduto(new Produto(Integer.parseInt(campos[3]),Double.parseDouble(campos[4])));
					compra.setQuantidade(Integer.parseInt(campos[5]));
					compras.add(compra);
					
					linha = br.readLine();
				}
				br.close();
		} catch (FileNotFoundException e) {
			System.out.println("O arquivo não foi encontrado.");
		} catch (IOException e) {
			System.out.println("Arquivo corrompido.");
		}
		return compras;
	}
}
