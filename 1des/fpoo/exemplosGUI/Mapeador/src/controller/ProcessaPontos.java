package controller;

import java.util.ArrayList;

import domain.Ponto;
import domain.dao.PontoDAO;

public class ProcessaPontos {

	public static ArrayList<Ponto> pontos = new ArrayList<>();
	private static PontoDAO pd = new PontoDAO();

	public static void lerArquivo() {
		pontos = pd.abrir();
	}

	public static boolean salvar() {
		if (pd.salvar(pontos)) {
			return true;
		} else {
			return false;
		}
	}

	//Excuir este método ao final do programa, utilizado somente para teste, caso não haja arquivo
	public static void preencheTestes() {
		pontos.add(new Ponto("RK01PT00", "Switch Principal", "switch.png", "TI", "TI", null));
		pontos.add(new Ponto("RK01PT01", "PC Recepção", "pc.png", "TI", "Recepção", "RK01PT00"));
		pontos.add(new Ponto("RK01PT02", "Laptop Diretor", "pc.png", "TI", "Diretoria", "RK01PT00"));
		pontos.add(new Ponto("RK01PT03", "PC ADM", "pc.png", "TI", "Administração", "RK01PT00"));
		pontos.add(new Ponto("RK01PT04", "Switch Secundário", "switch.png", "TI", "Corredor", "RK01PT00"));
		pontos.add(new Ponto("RK02PT01", "PC Almoxarifado", "pc.png", "Corredor", "Almoxarifado", "RK01PT04"));
		pontos.add(new Ponto("RK02PT02", "PC Balcão", "pc.png", "Corredor", "Balcão 1", "RK01PT04"));
		pontos.add(new Ponto("RK02PT03", "PC Balcão", "pc.png", "Corredor", "Balcão 2", "RK01PT04"));
	}
	
	public static String[] getPais(){
		String retorno = "";
		for(Ponto p: pontos) {
			if(p.getIcone().equals("switch.png") || p.getIcone().equals("roteador.png") )
				retorno += ","+p.getId();
		}
		return retorno.split(",");
	}
}
