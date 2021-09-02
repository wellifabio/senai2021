package ctr;

import java.util.ArrayList;

import vo.Livro;
import vo.dao.LivroDAO;

public class LivroProcess {

	public static ArrayList<Livro> livros;
	public static LivroDAO ld = new LivroDAO();
	
	public static void testes() {
		livros = new ArrayList<>();
		livros.add(new Livro("1","Paulo Coelho","O Alquimista","26.92"));
		livros.add(new Livro("2","Paulo Freire","Pedagogia do oprimido","29.98"));
		livros.add(new Livro("3","Mauricio de Souza","Almanaque Chico Bento","10.30"));
	}
	
	public static void abrir() {
		livros = ld.ler();
	}
	
	public static void salvar() {
		ld.escrever(livros);
	}
	
}
