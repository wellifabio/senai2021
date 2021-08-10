package vo;

import java.util.Random;

public class CPF {

	// Atributos
	private String cpf;

	// Construtores
	public CPF() {
	}

	public CPF(String cpf) {
		this.cpf = cpf;
	}

	// Getters && Setters
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	// Metodos espertos
	public void geraCpf() {
		cpf = "";
		Random gerador = new Random();
		for (int i = 0; i < 9; i++) {
			cpf += "" + gerador.nextInt(9);
		}
		cpf += geraDigitos();
	}

	public String geraDigitos() {
		String cpfSemDigito = cpf;
		String digito = "";
		int[] pesos1 = { 10, 9, 8, 7, 6, 5, 4, 3, 2 };
		int[] pesos2 = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
		int soma = 0;
		int d1 = 0, d2 = 0;
		for (int i = 0; i < 9; i++) {
			soma += Integer.parseInt(cpfSemDigito.charAt(i) + "") * pesos1[i];
		}
		d1 = soma % 11;
		if (d1 < 2)
			d1 = 0;
		else
			d1 = 11 - d1;
		soma = 0;
		cpfSemDigito += d1;
		for (int i = 0; i < 10; i++) {
			soma += Integer.parseInt(cpfSemDigito.charAt(i) + "") * pesos2[i];
		}
		d2 = soma % 11;
		if (d2 < 2)
			d2 = 0;
		else
			d2 = 11 - d2;
		digito += d1;
		digito += d2;
		return digito;
	}

}
