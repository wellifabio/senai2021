package controle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			viagens.add(new Viagem(1,formato.parse("10/01/2021"),"Campinas","Belo Horizonte",1200,2));
			viagens.add(new Viagem(2,formato.parse("10/01/2021"),"Campinas","Natal",2200,4));
			viagens.add(new Viagem(3,formato.parse("10/01/2021"),"Campinas","Maceió",2100,3));
			viagens.add(new Viagem(4,formato.parse("10/01/2021"),"Campinas","Rio de Janeiro",800,2));
			viagens.add(new Viagem(5,formato.parse("10/01/2021"),"Campinas","Salvador",1500,3));
			viagens.add(new Viagem(6,formato.parse("10/01/2021"),"Campinas","Fortaleza",2000,3));
		} catch (ParseException e) {
			System.out.println("Erro ao converter datas "+e);
		}
	}
	
}
