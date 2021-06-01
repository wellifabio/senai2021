package Escola;

public class Testadora {

	public static void main(String[] args) {

		// Instanciando uma classe Funcionario (class mãe) 
		Funcionario paraguassu = new Funcionario();
		paraguassu.setNome("Paraguassu");
		paraguassu.setIdade(60);
		paraguassu.setSalario(10000);
		paraguassu.setData("12/04/1950");
		paraguassu.setRG("SP-12-13-40");
		//paraguassu.nome  = "nada";
		//paraguassu.ensinarDisciplina("Matemática");
		paraguassu.passarPonto();
		
		System.out.println(paraguassu.getNome());
		
		// Instanciando uma classe Professor (classe filho)
		Professor rafael = new Professor();
		rafael.setNome("Rafael");
		rafael.setIdade(30);
		rafael.setSalario(10000);
		rafael.setData("12/04/1991");
		rafael.setRG("16180972");
		//rafael.ensinarDisciplina("FPOO");
		rafael.imprimirNomeProfessorESala("Lab 05");
		rafael.passarPonto();
		//System.out.println(rafael.getNome());
	}

}