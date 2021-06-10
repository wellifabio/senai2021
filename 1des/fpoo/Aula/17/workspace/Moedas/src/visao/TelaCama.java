package visao;

/*
 * Plugin para desenhar diagrama de classes automaticamente
 * https://www.objectaid.com/home
 * 
 * */

import java.util.Scanner;

import controle.ProcessaValores;
import modelo.Cedula;
import modelo.Moeda;

public class TelaCama {

	private static int menu = 0;
	private static String valor;
	private static String[] valores;
	private static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		ProcessaValores.preencherMoedas();
		ProcessaValores.preencherCedulas();

		while (menu != 3) {
			String[] itensMenu = { "Contar Dinheiro", "Listar", "Sair" };
			menu = criarMenu(itensMenu);
			switch (menu) {
			case 1:
				contarDinheiro();
				break;
			case 2:
				listarValores();
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

	// Metodo que executa a opção 1 do menu
	private static void contarDinheiro() {
		System.out.println("Digite o valor a ser contado:");
		valor = leia.next();
		if (valor.contains(",")) {
			valores = valor.split(",");
			// "245,36".split(",") -> {"245","36"}
			ProcessaValores.contarCedulas(Integer.valueOf(valores[0]));
			ProcessaValores.contarMoedas(Integer.valueOf(valores[1]));
		} else {
			ProcessaValores.contarCedulas(Integer.valueOf(valor));
		}
		System.out.println("\nValor contabilizado\n");
	}

	// Metodo que executa a opção 2 do menu
	private static void listarValores() {
		for (Cedula c : ProcessaValores.cedulas) {
			System.out.println(c.toString());
		}
		for (Moeda m : ProcessaValores.moedas) {
			System.out.println(m.toString());
		}
	}

	// Método que cria o menu
	public static int criarMenu(String[] itens) {
		int val = 1;
		for (String i : itens) {
			System.out.println(val + "." + i);
			val++;
		}
		val = leia.nextInt();
		return val;
	}

}
