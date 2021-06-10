package modelo;

/*
 * Polimorfismo = sobrecarga ou sobrescrita
 * sobracarga = dois ou mais métodos com o mesmo nome e parametros diferentes
 * sobrescrita = dois ou mais métodos com o mesmo nome e parametros em classes
 * diferentes com relação de herança
 * 
 * */

public abstract class Dinheiro {

	// Atributos
	private int valor;
	private String nome;
	private int quantidade;

	// Construtores
	public Dinheiro() {
	}

	public Dinheiro(int valor, String nome, int quantidade) {
		this.valor = valor;
		this.nome = nome;
		this.quantidade = quantidade;
	}

	// Métodos de acesso Getters && Setters
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Dinheiro [valor=" + valor + ", nome=" + nome + ", quantidade=" + quantidade + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + valor;
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
		Dinheiro other = (Dinheiro) obj;
		if (valor != other.valor)
			return false;
		return true;
	}

}
