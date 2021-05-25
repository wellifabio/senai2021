package auladia24_2;

public class MatrizExerc_1_c {
	public static void main(String[] args) {
		int[][] matriz = new int[6][6];

		for (int linha = 0; linha < matriz.length; linha++) {
			for (int col = 0; col < matriz[linha].length; col++) {
				matriz[linha][col] = linha;
				System.out.printf("%d ", matriz[linha][col]);
			}
			System.out.println();
		}
	}
}
