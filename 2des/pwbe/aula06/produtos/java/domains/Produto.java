package domains;

import java.util.Objects;

import controllers.ProdutoProcess;

public class Produto {

	// Atributos básicos
	int id;
	String nome;
	String descricao;
	float valor;
	int quantidade;

	// Construtores
	public Produto() {
		this.id = ProdutoProcess.autoId();
	}

	public Produto(String id) {
		this.id = Integer.valueOf(id);
	}

	public Produto(String[] csv) {
		this.id = Integer.valueOf(csv[0]);
		this.nome = csv[1];
		this.descricao = csv[2];
		this.valor = Float.valueOf(csv[3]);
		this.quantidade = Integer.valueOf(csv[4]);
	}
	
	public Produto(String id, String nome, String descricao, String valor, String quantidade) {
		this.id = Integer.valueOf(id);
		this.nome = nome;
		this.descricao = descricao;
		this.valor = Float.valueOf(valor);
		this.quantidade = Integer.valueOf(quantidade);
	}

	public Produto(String nome, String descricao, String valor, String quantidade) {
		this.id = ProdutoProcess.autoId();
		this.nome = nome;
		this.descricao = descricao;
		this.valor = Float.valueOf(valor);
		this.quantidade = Integer.valueOf(quantidade);
	}
	// Getters && Setters
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	// Calcula o subtotal
	public double getSubtotal() {
		return (double) quantidade * valor;
	}

	// Chave
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
		Produto other = (Produto) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return id + "\t" + nome + "\t" + descricao + "\t" + valor + "\t" + quantidade + "\n";
	}

	public String toCSV() {
		return id + ";" + nome + ";" + descricao + ";" + valor + ";" + quantidade + "\r\n";
	}

	public String toHTML() {
		return "<td>" + id + "</td><td>" + nome + "</td><td>" + descricao + "</td><td>"
				+ String.format("R$ %.2f", valor) + "</td><td>" + quantidade + "</td><td>" + String.format("R$ %.2f",getSubtotal()) + "</td>";
	}

}
