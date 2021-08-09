package vo;

import java.util.Objects;

public class Cliente {
	
	//Atributos
	private String cpf;
	private String nome;
	private String telefone;
	
	//Construtores
	public Cliente() {
	}

	public Cliente(String cpf, String nome, String telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public Cliente(String[] csv) {
		this.cpf = csv[0];
		this.nome = csv[1];
		this.telefone = csv[2];
	}

	//Getters && Setters
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	//Chave CPF
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return cpf + "\t" + nome + "\t" + telefone + "\n";
	}
	
	public String toCSV() {
		return cpf + ";" + nome + ";" + telefone + "\r\n";
	}
	
	public String toHTML() {
		return "<tr><td>"+ cpf + "</td><td>" + nome + "</td><td>" + telefone + "</td></tr>";
	}
	
}
