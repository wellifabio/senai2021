package auladia24_2;
import java.util.Random;

public class MatrizExerc_2 {
	public static void main(String[] args){
		Random gerador = new Random();
			
		int[][] matriz = new int[gerador.nextInt(9)+1][gerador.nextInt(9)+1]; 
		
		for(int linha = 0; linha < matriz.length; linha++) {
			for(int col = 0; col < matriz[linha].length; col++) {
				matriz[linha][col] = gerador.nextInt(100);
				System.out.printf("%d ", matriz[linha][col]);
			}
		System.out.println();	
		}
	}
}
