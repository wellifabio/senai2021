package models;

public class Produto {

	private int codigo;
	private String nome;
	private String descricao;
	private double preco;
	private int quantidade;

	public Produto() {
	}

	public Produto(int codigo, double preco) {
		this.codigo = codigo;
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
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
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
				+ ", quantidade=" + quantidade + "]";
	}

	public String toCSV() {
		return codigo + ";" + nome + ";" + descricao + ";" + preco + ";" + quantidade + "\r\n";
	}

	public boolean darBaixa(int quantidade) {
		if (quantidade > this.quantidade) {
			return false;
		} else {
			this.quantidade -= quantidade;
			return true;
		}
	}

	public double getSubtotal() {
		return this.preco * this.quantidade;
	}

	public String[] getStringVetor() {
		return new String[] { codigo+"", nome, descricao, preco+"",quantidade+"",String.format("%.2f", getSubtotal())};
	}

	public String cabecalho() {
		return "Cód        Nome                                      Descrição                              Preço               Quantidade";
	}

}
