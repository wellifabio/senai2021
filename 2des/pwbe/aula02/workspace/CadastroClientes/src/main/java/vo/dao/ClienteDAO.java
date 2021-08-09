package vo.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import vo.Cliente;

public class ClienteDAO {

	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = "c:\\dbs\\clientes.csv";
	private ArrayList<Cliente> clientes;
	private Cliente cliente;
	
	public boolean salvar(ArrayList<Cliente> clientes) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo,false));
			for(Cliente c: clientes) {
				bw.write(c.toCSV());
			}
			bw.close();
			return true;
		} catch (IOException e) {
			System.out.println("Erro ao gravar arquivo "+e);
			return false;
		}
	}
	
	public ArrayList<Cliente> abrir(){
		clientes = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha = null;
			while((linha = br.readLine()) != null) {
				cliente = new Cliente(linha.split(";"));
				clientes.add(cliente);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo n�o encontrado "+e);
		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo "+e);
		}
		return clientes;
	}
	
}
