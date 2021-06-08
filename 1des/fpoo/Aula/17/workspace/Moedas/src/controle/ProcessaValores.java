package controle;

import java.util.ArrayList;

import modelo.Cedula;
import modelo.Moeda;

public class ProcessaValores {

	//Atributos
	public static ArrayList<Cedula> cedulas = new ArrayList<>();
	public static ArrayList<Moeda> moedas = new ArrayList<>();
	
	//Método que preenche a lista de moedas
	public static void preencherMoedas(){
		moedas.add(new Moeda(1,"um"));
		moedas.add(new Moeda(5,"cinco"));
		moedas.add(new Moeda(10,"dez"));
		moedas.add(new Moeda(25,"vinte e cinco"));
		moedas.add(new Moeda(50,"cinquenta"));
		moedas.add(new Moeda(100,"um"));
	}
	
	//Método que preenche a lista de moedas
	public static void preencherCedulas(){
		cedulas.add(new Cedula(2,"dois"));
		cedulas.add(new Cedula(5,"cinco"));
		cedulas.add(new Cedula(10,"dez"));
		cedulas.add(new Cedula(20,"vinte"));
		cedulas.add(new Cedula(50,"cinquenta"));
		cedulas.add(new Cedula(100,"cem"));
		cedulas.add(new Cedula(200,"duzentos"));
	}
	
	public static String contarCedulas(int valor) {
		Cedula val = new Cedula(valor,null);
		if(cedulas.contains(val)) {
			return cedulas.toString();
		}else {
			return "calma ai";
		}
	}
}
