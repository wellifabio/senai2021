package models.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import models.Estacionamento;

public class EstacionamentoDAO {
	private Estacionamento estacionamento;
	private ArrayList<Estacionamento> estacionamentos;
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = "./bd/estacionamentos.csv";
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	public ArrayList<Estacionamento> abrir() {
		estacionamentos = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha = "";
			while ((linha = br.readLine()) != null) {
				String[] campos = linha.split(";");
				estacionamento = new Estacionamento(Integer.valueOf(campos[0]), campos[1], campos[2],
						formato.parse(campos[3]), campos[4], campos[5], Double.valueOf(campos[6]));
				estacionamentos.add(estacionamento);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo: " + e);
		} catch (NumberFormatException e) {
			System.out.println("Erro ao converter n�meros: " + e);
		} catch (ParseException e) {
			System.out.println("Erro ao converter datas: " + e);
		}
		return estacionamentos;
	}

	public boolean salvar(ArrayList<Estacionamento> vs) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo, false));
			for (Estacionamento v : vs) {
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
