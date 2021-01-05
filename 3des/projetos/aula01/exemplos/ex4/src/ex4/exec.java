package ex4;

import java.util.Scanner;

public class exec {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String valores = scan.nextLine();
		int par = 0, impar = 0;
		String result = "";
		String[] vetor = valores.split(" ");
		
		for(int i = 0; i < vetor.length; i++) {
			int saida = Integer.parseInt(vetor[i]) % 2;
			if(saida == 0) {
				par++;
			}else {
				impar++;
			}
		}
		
		if(par > 0) {
			if(par > 1) result += par+" pares ";
			else result += par+" par ";
		}
		
		if(impar > 0) {
			if(impar > 1) result += impar+" impares ";
			else result += impar+" impar ";
		}
		
		System.out.println(result);
		
	}

}
