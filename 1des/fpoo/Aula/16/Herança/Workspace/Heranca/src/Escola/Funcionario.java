package Escola;

public class Funcionario {
	// Declarando atributos
	protected String nome;
	private int idade;
	private String data;
	private double salario;
	private String RG;
	
	
	// Definindo Setters e Getters
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	
	
	// Métodos do funcionário
	public void passarPonto() {
		System.out.println("O funcionário "+this.nome+" bateu o ponto!");
	}
}
