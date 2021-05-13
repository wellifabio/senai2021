/*
Exercício de Lógica
Programa que lê a partir do teclado um valor de ponto
flutuante com duas casas decimais (monetário) e calcula
o menor número de notas (cédulas) e ou moedas no qual o
valor pode ser decomposto. As notas são 100, 50, 20, 10, 5, 2
e as moedas são 1, 0.5, 0.25, 0.1, 0.05. A seguir
mostre o valor lido e a relação de notas necessárias.
*/

import java.util.Scanner;

class Notas3 {
	
	private static Scanner entrada;

	public static void main(String args[]) {
		// Declaração de variáveis
		entrada = new Scanner(System.in);
		float valor = 0;
		Dinheiro[] dinheiro = new Dinheiro[12]; // Vetor de objetos
		dinheiro[0] = new Dinheiro(0, 100f, "notas de Cem Reais");
		dinheiro[1] = new Dinheiro(0, 50f, "notas de Cinquenta Reais");
		dinheiro[2] = new Dinheiro(0, 20f, "notas de Vinte Reais");
		dinheiro[3] = new Dinheiro(0, 10f, "notas de Dez Reais");
		dinheiro[4] = new Dinheiro(0, 5f, "notas de Cinco Reais");
		dinheiro[5] = new Dinheiro(0, 2f, "notas de Dois Reais");
		dinheiro[6] = new Dinheiro(0, 1f, "moedas de Um Real");
		dinheiro[7] = new Dinheiro(0, 0.5f, "moedas de Cinquenta centavos");
		dinheiro[8] = new Dinheiro(0, 0.25f, "moedas de Vinte e Cinco centavos");
		dinheiro[9] = new Dinheiro(0, 0.1f, "moedas de Dez centavos");
		dinheiro[10] = new Dinheiro(0, 0.05f, "moedas de cinco centavos");
		dinheiro[11] = new Dinheiro(0, 0.01f, "moedas de um centavo");

		// Entrada
		System.out.println("Digite um valor em dinheiro, maior do que zero:");
		valor = entrada.nextFloat();

		// Processamento
		while (valor > 0.00f) {
			for (int i = 0; i < 12; i++) {
				if (valor >= dinheiro[i].val) {
					dinheiro[i].cont++;
					valor -= (float)dinheiro[i].val;
					break;
				}
			}
		}
		
		// Saídas
		System.out.println("Será necessário:");
		for (Dinheiro d : dinheiro) {
			if (d.cont > 0) {
				System.out.println(d.cont + " " + d.nome+": "+d.val);
			}
		}
	}
}

class Dinheiro {
	int cont;
	float val;
	String nome;

	Dinheiro() {
	}

	Dinheiro(int cont, float val, String nome) {
		this.cont = cont;
		this.val = val;
		this.nome = nome;
	}
}