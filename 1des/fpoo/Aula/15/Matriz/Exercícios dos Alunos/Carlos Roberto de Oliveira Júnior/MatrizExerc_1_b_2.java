package auladia24_2;

public class MatrizExerc_1_b_2 {
	public static void main(String[] args) {
		int[][] matriz = new int[9][6];
		
		for(int linha = 0; linha < matriz.length; linha++) {
			for (int col = 0; col < matriz[linha].length; col++) {
				if ((linha % 2) == 0){
					matriz[linha][col] = -1;
					System.out.printf("%d ", matriz[linha][col]);
				}else {
					matriz[linha][col] = 0;
					System.out.printf(" %d ", matriz[linha][col]);
				}
			}
			System.out.println();	
		}
	}
}
