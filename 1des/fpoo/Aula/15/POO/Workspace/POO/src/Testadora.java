
public class Testadora {

	public static void main(String[] args) {
		
		Aluno alunoRicardo = new Aluno("Ricardo Belli"); // Instanciar objeto da classe Aluno
		//alunoRicardo.nome = "Ricardo Belli"; // Atribuir nos atributos as informações
		alunoRicardo.idade = 44;
		alunoRicardo.ra = 18365;
		alunoRicardo.curso = "Tec Desenvolvimento de Sistema";
		alunoRicardo.semestre = "Primeiro Semestre";
		alunoRicardo.estuda();
		alunoRicardo.nota1 = 8f;
		alunoRicardo.nota2 = 9f;
		System.out.println("A nota do aluno eh:"+alunoRicardo.obterMedia());
				
		Aluno alunoMichael = new Aluno("Michael José");
		//alunoMichael.nome = "Michael José";
		alunoMichael.idade = 18;
		alunoMichael.ra = 1245;
		alunoMichael.curso = "Tec Desenvolvimento de Sistema";
		alunoMichael.semestre = "Primeiro Semestre";
		alunoMichael.fazProva();
		alunoMichael.nota1 = 5f;
		alunoMichael.nota2 = 6f;
		System.out.println("A nota do aluno eh:"+alunoMichael.obterMedia());
		
		
		
		
		
	}

}
