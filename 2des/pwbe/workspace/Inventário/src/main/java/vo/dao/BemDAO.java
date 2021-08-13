package vo.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import vo.Bem;

public class BemDAO {

	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = "c:\\dbs\\bens.csv";
	private ArrayList<Bem> bens;
	private Bem bem;
	
	public boolean salvar(ArrayList<Bem> bens) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo,false));
			for(Bem b: bens) {
				bw.write(b.toCSV());
			}
			bw.close();
			return true;
		} catch (IOException e) {
			System.out.println("Erro ao gravar arquivo "+e);
			return false;
		}
	}
	
	public ArrayList<Bem> abrir(){
		bens = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha = null;
			while((linha = br.readLine()) != null) {
				bem = new Bem(linha.split(";"));
				bens.add(bem);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo n�o encontrado "+e);
		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo "+e);
		}
		return bens;
	}
	
}
