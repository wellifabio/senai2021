package modelo.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Viagem;

public class ViagemDAO {

	private Viagem viagem;
	private ArrayList<Viagem> viagens;
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = "./bd/viagem.csv";

	public ArrayList<Viagem> abrir() {
		viagens = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha = "";
			while ((linha = br.readLine()) != null) {
				String[] campos = linha.split(";");
				viagem = new Viagem(campos[0], campos[1], Integer.valueOf(campos[2]), Integer.valueOf(campos[3]));
				viagens.add(viagem);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo: " + e);
		}
		return viagens;
	}

	public boolean salvar(ArrayList<Viagem> vs) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo, false));
			for(Viagem v: vs) {
				bw.write(v.toCSV());
			}
			bw.close();
			return true;
		} catch (IOException e) {
			System.out.println("Erro ao gravar arquivo: " + e);
			return false;
		}
	}
}
