import java.util.Random;

public class Exemplo {

	public static void main(String[] args) {
		
		//------------------- Exemplo de vetor -------------------
		int [] vetorIdades = new int[5];
		vetorIdades[0] = 6;
		vetorIdades[1] = 7;
		vetorIdades[2] = 5;
		vetorIdades[3] = 8;
		vetorIdades[4] = 7;
		
		//System.out.printf("Idade Crianca 1: %d anos\nIdade Crianca 2: %d anos\nIdade Crianca 3: %d anos\n ",vetorIdades[0],vetorIdades[1],vetorIdades[2]);
		for(int i=0;i<vetorIdades.length;i++) 
			System.out.printf("Idade Crianca %d: %d anos\n",i+1,vetorIdades[i]);
		
		//------------------- Exemplo de matriz -------------------		
		int [][] matrizIdadesPesos = {{5,30},{1,40},{7,35},{2,30},{8,35},{6,66}}, matrizIdadesPesos2= {{6,20},{5,67},{4,67},{4,56},{6,78}};
		 
		
		/*
		System.out.printf("Crianca %d: Idade %d anos e Peso %d kg\n",1,matrizIdadesPesos[0][0],matrizIdadesPesos[0][1]);
		System.out.printf("Crianca %d: Idade %d anos e Peso %d kg\n",2,matrizIdadesPesos[1][0],matrizIdadesPesos[1][1]);
		System.out.printf("Crianca %d: Idade %d anos e Peso %d kg\n",3,matrizIdadesPesos[2][0],matrizIdadesPesos[2][1]);
		System.out.printf("Crianca %d: Idade %d anos e Peso %d kg\n",4,matrizIdadesPesos[3][0],matrizIdadesPesos[3][1]);
		System.out.printf("Crianca %d: Idade %d anos e Peso %d kg\n",5,matrizIdadesPesos[4][0],matrizIdadesPesos[4][1]);
		*/
		mostra(matrizIdadesPesos);
		mostra(matrizIdadesPesos2);
		int oMenorValor = menorValor(matrizIdadesPesos2);
		System.out.printf("O menor valor eh: %d\n",oMenorValor);
		
		Random gerador = new Random();
		System.out.println(gerador.nextInt(100));
		
		
	}
	
	 static void mostra(int [][] matriz) {
		System.out.printf("%15s %4s\n","Idade","Peso");
		for(int linha=0;linha<matriz.length;linha++) {
			System.out.printf("Crianca %d: ",linha+1);
			for(int coluna=0;coluna<matriz[linha].length;coluna++) {
				System.out.printf("%3d\t",matriz[linha][coluna]);
			}
			System.out.println();
		}
	}
	 
	public static int menorValor(int [][] matriz) {
		int menor = matriz[0][0];
		
		for(int [] linha:matriz) {
			for(int valor:linha) {
				if(valor<menor)
					menor = valor;
			}
		}
		
		return menor;
	}

}
