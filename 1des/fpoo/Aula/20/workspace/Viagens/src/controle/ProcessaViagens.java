package controle;
//Controle processa os cálculos totais, listas
import java.util.ArrayList;

import modelo.Viagem;

public class ProcessaViagens {
	static ArrayList<Viagem> viagens = new ArrayList<>();
	
	int totalTempo() {
		int acumulador = 0;
		for(Viagem v: viagens) {
			acumulador += v.getTempo();
		}
		return acumulador;
	} 
}
