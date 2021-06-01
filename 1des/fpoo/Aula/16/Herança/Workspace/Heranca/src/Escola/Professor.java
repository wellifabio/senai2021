package Escola;
public class Professor extends Funcionario{
	
	public void ensinarDisciplina(String disc) {
		System.out.println(getNome() + " está ensinando "+disc);
	}
	
	public void imprimirNomeProfessorESala(String sala) {
		System.out.println("O professor "+super.nome+" estah na sala "+ sala);
	}
	
	public void passarPonto() {
		System.out.println("O professor "+super.nome+ " bateu o ponto");
	}
	
}
