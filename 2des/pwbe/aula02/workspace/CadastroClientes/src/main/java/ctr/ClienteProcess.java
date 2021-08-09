package ctr;

import java.util.ArrayList;

import vo.Cliente;
import vo.dao.ClienteDAO;

public class ClienteProcess {
	
	public static ArrayList<Cliente> clientes;
	public static ClienteDAO cd = new ClienteDAO();
	
	public static void testes() {
		clientes = new ArrayList<>();
		clientes.add(new Cliente("11111111111","Jacinto Pena","19 11111-1111"));
		clientes.add(new Cliente("22222222222","Jacinto Paixão","19 22222-2222"));
		clientes.add(new Cliente("33333333333","Osmar Motta","19 33333-3333"));
		clientes.add(new Cliente("44444444444","Osmar Manjo","19 44444-4444"));
		clientes.add(new Cliente("55555555555","Paula Ramos","19 55555-5555"));
		clientes.add(new Cliente("66666666666","Juliana Silva","19 66666-6666"));
		clientes.add(new Cliente("77777777777","Marcela Garcia","19 77777-7777"));
		clientes.add(new Cliente("88888888888","Ivone Souza","19 88888-8888"));
	}
	
	public static String salvar() {
		if(cd.salvar(clientes)) {
			return "Dados registrados";
		}
		return "Erro ao registrar dados";
	}
	
	public static void abrir() {
		clientes = cd.abrir();
	}

}
