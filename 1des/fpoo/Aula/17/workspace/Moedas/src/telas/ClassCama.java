package telas;

import java.util.Scanner;

import controle.ProcessaValores;
import modelo.Cedula;
import modelo.Dinheiro;
import modelo.Moeda;

public class ClassCama {

	private static Dinheiro din; // Instância
	private static int menu = 0;
	private static String valor;
	private static int moeda,cedula;
	private static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		ProcessaValores.preencherMoedas();
		ProcessaValores.preencherCedulas();
		
		while (menu != 3) {
			System.out.println("1.Contar Dinheiro\n2.Listar\n3.Sair");
			menu = leia.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Digite o valor a ser contado:");
				valor = leia.next();
				if(valor.contains(",")) {
					System.out.println("Tem moeda");
				}else {
					System.out.println("Não Tem moeda");
					System.out.println(ProcessaValores.contarCedulas(Integer.valueOf(valor)));
				}
				break;
			case 2:
				for(Moeda m: ProcessaValores.moedas) {
					System.out.println(m.toString());
				}
				for(Cedula c: ProcessaValores.cedulas) {
					System.out.println(c.toString());
				}
				break;
			case 3:
				System.out.println("Bye,bye...");
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}
		}
	}

}
