package controle;

//Controle processa os cálculos totais, listas
import java.util.ArrayList;

import modelo.Viagem;
import modelo.dao.ViagemDAO;

public class ProcessaViagens {
	
	public static ArrayList<Viagem> viagens = new ArrayList<>();
	public static ViagemDAO vd = new ViagemDAO();

	public static int totalTempo() {
		int acumulador = 0;
		for (Viagem v : viagens) {
			acumulador += v.getTempo();
		}
		return acumulador;
	}
	
	public static void abrirDAO() {
		viagens = vd.abrir();
	}
	
	public static boolean salvarDAO() {
		return vd.salvar(viagens);
	}
	
	//Método de testes, excluir ao final do projeto
	public static void preencherTeste() {
		viagens.add(new Viagem("Campinas","Belo Horizonte",1200,2));
		viagens.add(new Viagem("Campinas","Natal",2200,4));
		viagens.add(new Viagem("Campinas","Maceió",2100,3));
		viagens.add(new Viagem("Campinas","Rio de Janeiro",800,2));
		viagens.add(new Viagem("Campinas","Salvador",1500,3));
		viagens.add(new Viagem("Campinas","Fortaleza",2000,3));
	}
	
}
