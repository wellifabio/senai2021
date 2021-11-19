package model;

import java.io.InputStream;

public class Receita {
	private int id;
	private String nome, ingredientes, modoDeFazer;
	private InputStream foto;

	public Receita() {
	}

	public Receita(int id, String nome, String ingredientes, String modoDeFazer, InputStream foto) {
		this.id = id;
		this.nome = nome;
		this.ingredientes = ingredientes;
		this.modoDeFazer = modoDeFazer;
		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getModoDeFazer() {
		return modoDeFazer;
	}

	public void setModoDeFazer(String modoDeFazer) {
		this.modoDeFazer = modoDeFazer;
	}

	public InputStream getFoto() {
		return foto;
	}

	public void setFoto(InputStream foto) {
		this.foto = foto;
	}

}
