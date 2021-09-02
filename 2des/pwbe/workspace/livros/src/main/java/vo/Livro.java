package vo;

import java.util.Objects;

public class Livro {

	private int id;
	private String autor;
	private String titulo;
	private float preco;
	
	public Livro() {
	}

	public Livro(String[] vetor) {
		this.id = Integer.valueOf(vetor[0]);
		this.autor = vetor[1];
		this.titulo = vetor[2];
		this.preco = Float.valueOf(vetor[3]);
	}
	
	public Livro(String id, String autor, String titulo, String preco) {
		this.id = Integer.valueOf(id);
		this.autor = autor;
		this.titulo = titulo;
		this.preco = Float.valueOf(preco);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return id + "\t" + autor + "\t" + titulo + "\t" + preco + "\n";
	}
	
	public String toCSV() {
		return id + ";" + autor + ";" + titulo + ";" + preco + "\r\n";
	}
	
	public String toHTML() {
		return "<td>"+ id + "</td><td>" + autor + "</td><td>" + titulo + "</td><td>" + preco + "</td>";
	}
	
}
