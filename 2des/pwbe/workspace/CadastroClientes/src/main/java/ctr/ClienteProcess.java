package ctr;

import java.util.ArrayList;

import util.CPF;
import util.Nome;
import util.Telefone;
import vo.Cliente;
import vo.dao.ClienteDAO;

public class ClienteProcess {

	public static ArrayList<Cliente> clientes;
	public static ClienteDAO cd = new ClienteDAO();

	public static void testes() {
		clientes = new ArrayList<>();
		String[] nomes = { "Marcos", "Lúcia", "Ana", "Maria", "Renata" };
		String[] sobrenomes = { "Silva", "da Silva", "Castro", "Souza", "de Souza", "e Silva", "Oliveira", "de Oliveira" };
		Nome n = new Nome(nomes, sobrenomes);
		
		for (int i = 0; i < n.getAll().length; i++)
			clientes.add(new Cliente(new CPF().getFormat() + "", n.getNome(2), new Telefone().getFormat()));
	}

	public static String salvar() {
		if (cd.salvar(clientes)) {
			return "<p>Dados registrados</p>";
		}
		return "<p>Erro ao registrar dados</p>";
	}

	public static void abrir() {
		clientes = cd.abrir();
	}

}
