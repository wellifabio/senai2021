package auladia24_2;

public class MatrizExerc_1_b_1 {
	public static void main(String[] args) {
		int[][] matriz = new int[9][6];
		
		for(int linha = 0; linha < matriz.length; linha++) {
			if ((linha % 2) == 0) {
				for (int col = 0; col < matriz[linha].length; col++) {
					matriz[linha][col] = -1;
					System.out.printf("%d ", matriz[linha][col]);
				}
			}else {
				for (int col = 0; col < matriz[linha].length; col++) {
					matriz[linha][col] = 0;
					System.out.printf(" %d ", matriz[linha][col]);
				}
			}
			System.out.println();	 
		}
	}
}
