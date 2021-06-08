package Humanos;

public class Pessoa {
	// Atributos primitivos
	String nome, cor;
	double altura, peso;
	int idade;
	double distancia;
	// Atributos de tipos de dados criado
	Cabeca cabeca;
	
	
	// Métodos Personalizados - ações 
	// Método com argumento
	void fala(String idioma) {
		String nome = "Rafael";
		if (idioma == "Portugues")
			System.out.println("Olá mundo! Seu nome é:"+this.nome);
		else if(idioma == "Inglês")
			System.out.println("Hello world! Your name is:"+nome);
		else
			System.out.println("Mudo");
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// Método sem argumento
	void fala() {
		System.out.println("Olá mundo!");
	}
	
	void anda() {
		distancia = distancia + 2;
	}
	
	// Métodos especiais
     
	// Construtores
	Pessoa() {
		System.out.println("Pessoa criada! Construtor SEM argumento");
		this.idade = 0;
		
	}
		
	
	Pessoa(String nome, String cor, double altura, double peso, int idade) {
		System.out.println("Pessoa criada! Construtor COM argumento, cor:"+cor);
		this.nome = nome;
		this.cor = cor;
		this.altura = altura;
		this.peso = peso;
		this.idade = idade;
	}

	// Getters e Setters - Getters e Setters
	public String getCor() {
		return cor;
	}

	
	public void setCor(String cor) {
		this.cor = cor;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	

}
