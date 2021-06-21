package visao;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Viagem;

public class TelaViagensObj {

	public static int menu = 0;
	public static Scanner leia = new Scanner(System.in);
	public static ArrayList<Viagem> viagens;

	public static void main(String[] args) {
		viagens = new ArrayList<>();
		viagens.add(new Viagem("Campinas", "Amapá", 1200, 2.5f));
		viagens.add(new Viagem("Campinas", "Paraiba", 1100, 3));
		viagens.add(new Viagem("Campinas", "Pedreira", 1900, 2.7f));
		viagens.add(new Viagem("Campinas", "Jaguariúna", 1800, 3.1f));
		viagens.add(new Viagem("Campinas", "Maranhão", 1400, 2.1f));
		viagens.add(new Viagem("Campinas", "Recife", 1700, 1));
		viagens.add(new Viagem("Campinas", "Acre", 1300, 7));
		while (menu != 5) {
			menu = menu(new String[] { "\n1.Cadastro", "2.Listar", "3.Alterar", "4.Excluir", "5.Sair\n" });
			switch (menu) {
			case 1:
				System.out.print("Digite seu destino:");
				// viagens.add(leia.next());
				break;
			case 2:
				int i = 1;
				for (Viagem v: viagens) {
					System.out.println(i + v.toString());
					i++;
				}
				break;
			case 3:
				System.out.print("Digite um índice do destino que deseja alterar:");
				int indice = leia.nextInt();
				if (indice > 0 && indice < viagens.size()) {
					System.out.println("Você irá alterar o destino:" + viagens.get(indice - 1));
					System.out.print("Digite um novo destino:");
					String destino = leia.next();
					//viagens.set(indice, destino);
				}
				break;

			case 4:
				System.out.print("Digite um índice do destino que deseja excluir:");
				int ind = leia.nextInt();
				if (ind > 0 && ind < viagens.size()) {
					viagens.remove(ind - 1);
					System.out.println("destino removido");
				} else {
					System.out.println("índice inválido");
				}
				break;
			case 5:
				System.out.println("Ariverdecci");
				break;
			default:
				System.out.println("Não");
				break;
			}
		}
	}

	public static int menu(String[] itens) {

		for (String i : itens) {
			System.out.println(i);
		}

		return leia.nextInt();
	}

}