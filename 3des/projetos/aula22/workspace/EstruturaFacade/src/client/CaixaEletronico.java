package client;

import java.util.Scanner;

import process.ContaCorrenteFacade;

/*
 * Facade ou Fachada
 * Serve para criar uma interface simplificada que roda outras ações por trás.
 * Exemplo:
 * Para sacar R$ 50,00 do Banco, seria necessário:
 * Validar o número da conta
 * Validar a senha
 * Validar se tem saldo na conta
 * Realizar a alteração do saldo da conta
 * https://www.youtube.com/watch?v=B1Y8fcYrz5o
 * */

public class CaixaEletronico {

	public static ContaCorrenteFacade cc;
	public static int menu;

	public static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) {

		System.out.print("Digite o número da conta e a senha:");
		cc = new ContaCorrenteFacade(leia.nextInt(),leia.nextInt());
		

	}

}
