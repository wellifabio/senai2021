package Humanos;

public class Testadora {

	public static void main(String[] args) {

		
		// Objeto roberto do tipo Pessoa
		//Pessoa roberto = new Pessoa();
		Pessoa roberto = new Pessoa("Roberto","branco",1.6,50,30);
		
		
		int idadeRoberto;
		idadeRoberto = roberto.getIdade();
		
		// Novo estado
		roberto.setAltura(1.84);
		roberto.setCor("Azul");
		roberto.setIdade(13);
		roberto.setPeso(70.0);
		
		// Comportamento
		roberto.anda();
		//String meuIdioma = "X";
		//roberto.fala(meuIdioma);
		roberto.fala("Portugues");
		
		
		//Aluno rafael = new Aluno()
		

	}

}
