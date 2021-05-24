package auladia24;

import java.util.Scanner;

public class Lista2_2{
	private static Scanner input;
	
	public static void main(String[] args){
		input = new Scanner(System.in);
		System.out.print("Digite o tamanho do vetor: ");
		int[] idades = new int[input.nextInt()];
		leVetor(idades);
		mostra(idades);
		maior_idade(idades);
		//System.out.printf("\nO maior valor é %d", maior_idade_2(idades));
		input.close();
	}
	
	private static void leVetor(int[] vetorIdade){
		input = new Scanner(System.in);
		for (int i = 0; i < vetorIdade.length; i++) {
			System.out.printf("Digite o valor de número %d: ", (i+1));
			vetorIdade[i] = input.nextInt();
		}
		input.close();
	}
	
	private static void mostra(int[] vetorIdade) {
		System.out.println("\nIndice    Valor");
		for(int i = 0; i < vetorIdade.length ; i++) {
			System.out.printf("%3d     %5d\n", i, vetorIdade[i]);
		}
	}		
	
	private static void maior_idade(int[] vetorIdade) {
		int maior = 0;
		for(int i = 0; i < vetorIdade.length ; i++) {
			if (vetorIdade[i] > maior) {
				maior = vetorIdade[i];
			}
		}
		System.out.printf("\nO maior valor é %d", maior);
		//System.out.printf("\nO maior valor é %d", maior_idade_2(vetorIdade));
	}

	/*
	private static int maior_idade_2(int[] vetorIdade) {
		int maior = 0;
		for(int i = 0; i < vetorIdade.length ; i++) {
			if (vetorIdade[i] > maior) {
				maior = vetorIdade[i];
			}
		}
		return maior;
	}
	*/
	
}
