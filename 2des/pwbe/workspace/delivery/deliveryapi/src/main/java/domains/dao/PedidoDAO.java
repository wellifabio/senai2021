package controllers.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import domains.Pedido;

public class PedidoDAO {
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = "c:\\dbs\\pedidos.csv";
	private ArrayList<Pedido> pedidos;
	private Pedido pedido;
	
	public boolean salvar(ArrayList<Pedido> pedidos) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo,false));
			for(Pedido p: pedidos) {
				bw.write(p.toCSV());
			}
			bw.close();
			return true;
		} catch (IOException e) {
			System.out.println("Erro ao gravar arquivo "+e);
			return false;
		}
	}
	
	public ArrayList<Pedido> abrir(){
		pedidos = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha = null;
			while((linha = br.readLine()) != null) {
				pedido = new Pedido(linha.split(";"));
				pedidos.add(pedido);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado "+e);
		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo "+e);
		}
		return pedidos;
	}
}