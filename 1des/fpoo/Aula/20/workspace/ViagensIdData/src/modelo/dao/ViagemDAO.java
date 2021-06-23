package modelo.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import modelo.Viagem;

public class ViagemDAO {

	private Viagem viagem;
	private ArrayList<Viagem> viagens;
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = "./bd/viagem.csv";
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	public ArrayList<Viagem> abrir() {
		viagens = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha = "";
			while ((linha = br.readLine()) != null) {
				String[] campos = linha.split(";");
				viagem = new Viagem(Integer.valueOf(campos[0]), formato.parse(campos[1]), campos[2], campos[3], Integer.valueOf(campos[4]), Integer.valueOf(campos[5]));
				viagens.add(viagem);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo: " + e);
		} catch (NumberFormatException e) {
			System.out.println("Erro ao converter números: " + e);
		} catch (ParseException e) {
			System.out.println("Erro ao converter datas: " + e);
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
