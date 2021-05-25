public class Aluno {
	// atributos
	int idade, ra;
	String nome, curso, semestre;
	float nota1, nota2;
	
	// Método construtor
	Aluno(String argNome) {
		this.nome = argNome;
		System.out.println("Objeto aluno com nome "+this.nome+ " criado com sucesso!");
	}
	
	// Métodos
	void vaiParaAula() {
		System.out.println("O aluno "+nome+" foi para a aula.");		
	}
	
	void estuda() {
		System.out.println("O aluno "+nome+" foi estudar.");
	}
	
	void fazProva() {
		System.out.println("O aluno "+nome+" foi fazer prova do curso "+curso);
	}
	
	float obterMedia() {
		return (this.nota1 + this.nota2)/2;
	}

}
