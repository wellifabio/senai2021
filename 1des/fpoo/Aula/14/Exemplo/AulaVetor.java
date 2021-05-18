public class AulaVetor{
	
	static int [] notasAlunos;
	
	
	public static void main(String [] args ){
		//int [] notasAlunos = new int[8], matriculasAlunos = new int[8];
		notasAlunos = new int[2];
		
		notasAlunos[0] = 5;
		notasAlunos[1] = 6;
		mostra();
		
		/*notasAlunos[0] = 5;
		notasAlunos[1] = 6;
		notasAlunos[2] = 7;
		notasAlunos[3] = 5;
		notasAlunos[4] = 6;
		notasAlunos[5] = 7;
		*/
		//notasAlunos = {5,6,7,5,6,7,5,6};
		
		/*
		System.out.println(notasAlunos[notasAlunos.length-1]);
		System.out.printf("O tamanho do vetor eh: %d\n", notasAlunos.length);
		
		String [] cabecalho = {"Indice","Valor"};
		System.out.printf("%8s %8s\n", cabecalho[0], cabecalho[1]);
		
		
		
		for (int i = 0; i < notasAlunos.length ; i++)
			System.out.printf("%6d %8d\n",i,notasAlunos[i]);
		
		
		int soma = 0;
		for (int i = 0; i < notasAlunos.length ; i++)
			soma = soma + notasAlunos[i];
		System.out.printf("Soma total eh: %d\n", soma);
		
		
		for (int nota : notasAlunos)
			System.out.printf("%d\n",nota);
		
		*/
		
	}
	
	static void mostra(){
		 System.out.print(notasAlunos[0]);
	}
}