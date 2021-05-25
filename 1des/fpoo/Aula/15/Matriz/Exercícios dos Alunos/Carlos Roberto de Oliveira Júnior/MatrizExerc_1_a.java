package auladia24_2;

public class MatrizExerc_1_a {
	public static void main(String[] args) {
		int[][] matriz = new int[3][10];

		for (int line = 0; line < matriz.length; line++) {
			for (int col = 0; col < matriz[line].length; col++) {
				matriz[line][col] = col;
				System.out.printf("%d ", matriz[line][col]);
			}
			System.out.println();
		}
	}
}
