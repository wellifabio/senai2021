package vo.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import vo.Livro;

public class LivroDAO {

	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = "c:\\dbs\\livros.csv";
	private ArrayList<Livro> livros; // lista de modelos
	private Livro livro; // modelo

	public void escrever(ArrayList<Livro> livros) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo, false));
			for (Livro l : livros) {
				bw.write(l.toCSV());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Erro ao salvar: " + e);
		}
	}

	public ArrayList<Livro> ler() {
		livros = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha = "";
			while ((linha = br.readLine()) != null) {
				livro = new Livro(linha.split(";"));
				livros.add(livro);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: " + e);
		} catch (IOException e) {
			System.out.println("Erro ao abrir: " + e);
		}
		return livros;
	}

}
