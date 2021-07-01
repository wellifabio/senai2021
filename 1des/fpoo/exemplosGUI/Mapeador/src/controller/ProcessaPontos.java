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
		pontos.add(new Ponto("RK01PT00", "Switch Principal", "switch", "TI", "TI", ""));
		pontos.add(new Ponto("RK01PT01", "PC Recepção", "pc", "TI", "Recepção", "RK01PT00"));
		pontos.add(new Ponto("RK01PT02", "NoteBook Diretor", "laptop", "TI", "Diretoria", "RK01PT00"));
		pontos.add(new Ponto("RK01PT03", "PC ADM1", "pc", "TI", "Administração", "RK01PT00"));
		pontos.add(new Ponto("RK01PT05", "Impressora Recepção", "impressora", "TI", "Recepção", "RK01PT00"));
		pontos.add(new Ponto("RK01PT06", "Notebook ADM", "laptop", "TI", "Administração", "RK01PT00"));
		pontos.add(new Ponto("RK01PT07", "NoteBook Contabilidade", "laptop", "TI", "Contabilidade", "RK01PT00"));
		pontos.add(new Ponto("RK01PT08", "PC ADM2", "pc", "TI", "Administração", "RK01PT00"));
		pontos.add(new Ponto("RK01PT04", "Switch Secundário", "switch", "TI", "Corredor 1", "RK01PT00"));
		pontos.add(new Ponto("RK02PT01", "PC Almoxarifado", "pc", "Corredor 1", "Almoxarifado", "RK01PT04"));
		pontos.add(new Ponto("RK02PT02", "PC Balcão", "pc", "Corredor 1", "Balcão 1", "RK01PT04"));
		pontos.add(new Ponto("RK02PT03", "PC Balcão", "pc", "Corredor 1", "Balcão 2", "RK01PT04"));
		pontos.add(new Ponto("RK01PT09", "Roteador", "roteador", "TI", "Produção", "RK01PT00"));
		pontos.add(new Ponto("RK03PT01", "NoteBook Produção 1", "laptop", "Corredor 2", "Produção", "RK01PT09"));
		pontos.add(new Ponto("RK03PT02", "NoteBook Produção 2", "laptop", "Corredor 2", "Produção", "RK01PT09"));
		pontos.add(new Ponto("RK03PT03", "NoteBook Produção 3", "laptop", "Corredor 2", "Produção", "RK01PT09"));
	}
	
	public static String[] getPais(){
		String retorno = "";
		for(Ponto p: pontos) {
			if(p.getIcone().equals("switch") || p.getIcone().equals("roteador") )
				retorno += ","+p.getId();
		}
		return retorno.split(",");
	}
	
	public static boolean isPai(String id){
		for(Ponto p: pontos) {
			if(p.getPai().equals(id))
				return true;
		}
		return false;
	}
}
