/*
	Rafael Martins Alves
	10/05/2021
	rafaelmartinsalves@gmail.com
	Exemplo de aula
*/

import java.util.Scanner;

/** 
Essa classe é do exemplo de aula nada
*/
public class Exemplo{
	
	
	
	/** 
		Essa classe é do exemplo de aula nada
	*/
	public static void main(String args[]){
		
			
		Scanner obj = new Scanner(System.in);
		
		int minhaVarInt = 1;
	    String minhaVarString = "1";
		
		// Parse converte string para qualquer(primitivos) tipo de dados
		double minhaVarDouble = Double.parseDouble(minhaVarString);//String para double
		float minhaVarFloat = Float.parseFloat(minhaVarString); //String para float
		int minhaVarInt2 = Integer.parseInt(minhaVarString); // String para int
		
		// Double converte qualquer(primitivos) tipo de dados para double
		double minhaVarDouble2 = new Double(minhaVarInt2); // Inteiro para double
		double minhaVarDouble3 = new Double(minhaVarString); // Inteiro para double
		
		
		// Double para int NO EXIST, exemplo de String para Int
		int minhaVarInt3 = new Integer(minhaVarString);
		
		// Char
		char letra1, letra2;
		letra1 = 50;
		letra2 = 'a';
		
		// Leitura do teclado
		String nomeAluno = obj.nextLine();
		int a,b,c;
		a = b = c = 3;
		
		int i = 0;
		i++; //i = i + 1;
		i++;
		i--; //i = i - 1;
		
	
		System.out.printf("  Entrei \' Aqui \r nada"+minhaVarInt+"\n");
		System.out.printf("Entrei \" Aqui  \b nada"+minhaVarInt);
		System.out.printf("Double aqui: %5.3f \f nada\n",minhaVarDouble);
		System.out.printf("Float aqui: %10.2f \n",minhaVarFloat);
		System.out.printf("Int aqui: %d \n",minhaVarInt2);
		System.out.printf("Double do inteiro aqui 1 : %f \n",minhaVarDouble2);
		System.out.printf("Double do inteiro aqui 2: %f \n",minhaVarDouble3);
		System.out.printf("Int 2: %d \n",minhaVarInt3);
		System.out.printf("Nome do aluno: %s \n",nomeAluno);
		System.out.printf("Caracter: %d %c \n",new Integer(letra1),letra2);
		System.out.printf("a: %d | b: %d | c: %d\n", a,b,c);
		System.out.printf("%d",i);
		
		if(true && false){
			System.out.printf("Entrei");
		}else{
			System.out.printf("Não Entrei");	
		}
		
	}
	
}