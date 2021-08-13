package ctr;

import java.util.ArrayList;
import java.util.Date;

import vo.Bem;
import vo.dao.BemDAO;

public class BensProcess {
	
	public static ArrayList<Bem> bens;
	public static BemDAO bd = new BemDAO();
	
	public static void testes() {
		bens = new ArrayList<>();
		bens.add(new Bem(1, "Armário pequeno",new Date(),500.0));
		bens.add(new Bem(5, "Mesa de Reuniões",new Date(),1500.0));
		bens.add(new Bem(3, "Computador DEL",new Date(),2500.0));
		bens.add(new Bem(4, "Impressora HP",new Date(),1350.0));
		bens.add(new Bem(2, "NoteBook Positivo",new Date(),3500.0));
		bens.add(new Bem(6, "Maquina Injetora",new Date(),35000.0));
		bens.add(new Bem(8, "Furadeira BOSH",new Date(),1200.0));
	}
	
	public static void abrir() {
		bens = bd.abrir();
	}
	
	public static String salvar() {
		if(bd.salvar(bens)) {
			return "<p>Dados salvos com sucesso</p>";
		}else {
			return "<p>Erro ao salvar aquivo CSV</p>";
		}
	}
}
