package controllers;

import java.util.ArrayList;

import domains.Pedido;
import controllers.dao.PedidoDAO;

public class PedidoProcess {

	public static ArrayList<Pedido> pedidos;
	public static PedidoDAO pd = new PedidoDAO();

	public static void abrir() {
		pedidos = pd.abrir();
	}

	public static boolean salvar() {
		return pd.salvar(pedidos);
	}
	
	public static int autoIncrementId() {
		if(pedidos.size()<=0) {
			return 1;
		}else {
			return pedidos.get(pedidos.size()-1).getId()+1;
		}
	}
	
	public static void testes() {
		pedidos = new ArrayList<>();
		pedidos.add(new Pedido("Ana","Rua Machado de Assis, 21","X-Tudo"));
		pedidos.add(new Pedido("Marcelo Silva","Rua Paulo Coelho, 12","X-Bacon"));
		pedidos.add(new Pedido("Maria Mello","Rua Olavo Bilac, 454","Cachorro Quente"));
		pedidos.add(new Pedido("Bruno Gonçalves","Av. Pacheco Aguiar, 11","Pizza Mussarela"));
	}
}
