package auladia24;

public class Lista2_1 {
	public static void main(String[] args) {
		mostra();		
	}
	
	static void mostra() {
		int [] elementos = {2, 4, 5, 6, 8};
		System.out.println("Indice    Valor");
		for(int i = 0; i < elementos.length; i++) {
			System.out.printf("%3d %9d\n", i, elementos [i]);
		}
		System.out.println("\nValor    Indice");
		for(int elemento: elementos) {
			System.out.printf("%3d\n", elemento);
		}
	}
}
