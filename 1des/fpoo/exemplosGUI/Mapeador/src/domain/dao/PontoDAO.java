package domain.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import domain.Ponto;

public class PontoDAO {

	private Ponto Ponto;
	private ArrayList<Ponto> pontos;
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = "./bd/pontos.csv";

	public ArrayList<Ponto> abrir() {
		pontos = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha = "";
			while ((linha = br.readLine()) != null) {
				String[] campos = linha.split(";");
				if (campos.length > 5)
					Ponto = new Ponto(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5]);
				else
					Ponto = new Ponto(campos[0], campos[1], campos[2], campos[3], campos[4], "");
				pontos.add(Ponto);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo: " + e);
		}
		return pontos;
	}

	public boolean salvar(ArrayList<Ponto> vs) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo, false));
			for (Ponto p : vs) {
				bw.write(p.toCSV());
			}
			bw.close();
			return true;
		} catch (IOException e) {
			System.out.println("Erro ao gravar arquivo: " + e);
			return false;
		}
	}
}
