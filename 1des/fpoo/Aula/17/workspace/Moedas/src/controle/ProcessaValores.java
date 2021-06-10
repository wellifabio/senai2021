package controle;

import java.util.ArrayList;

import modelo.Cedula;
import modelo.Moeda;

public class ProcessaValores {

	// Atributos
	public static ArrayList<Cedula> cedulas = new ArrayList<>();
	public static ArrayList<Moeda> moedas = new ArrayList<>();

	// Método que preenche a lista de moedas
	public static void preencherMoedas() {
		moedas.add(new Moeda(100, "um", 0));
		moedas.add(new Moeda(50, "cinquenta", 0));
		moedas.add(new Moeda(25, "vinte e cinco", 0));
		moedas.add(new Moeda(10, "dez", 0));
		moedas.add(new Moeda(5, "cinco", 0));
		moedas.add(new Moeda(1, "um", 0));
	}

	// Método que preenche a lista de moedas
	public static void preencherCedulas() {
		cedulas.add(new Cedula(200, "duzentos", 0));
		cedulas.add(new Cedula(100, "cem", 0));
		cedulas.add(new Cedula(50, "cinquenta", 0));
		cedulas.add(new Cedula(20, "vinte", 0));
		cedulas.add(new Cedula(10, "dez", 0));
		cedulas.add(new Cedula(5, "cinco", 0));
		cedulas.add(new Cedula(2, "dois", 0));
	}

	public static void contarCedulas(int valor) {
		while (valor > 0) {
			for (Cedula c : cedulas) {
				if (valor >= c.getValor()) {
					valor -= c.getValor();
					c.setQuantidade(c.getQuantidade() + 1);//Contador
					break;
				}
			}
			if (valor == 1) {//Esta condição é por não existir nota de 1Real
				valor = 0;
				moedas.get(0).setQuantidade(moedas.get(0).getQuantidade()+1);
			}
		}
	}

	public static void contarMoedas(int valor) {
		while (valor > 0) {
			for (Moeda m : moedas) {
				if (valor >= m.getValor()) {
					valor -= m.getValor();
					m.setQuantidade(m.getQuantidade() + 1);
					break;
				}
			}
		}
	}
}
