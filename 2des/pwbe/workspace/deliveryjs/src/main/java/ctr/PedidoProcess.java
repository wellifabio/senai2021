package ctr;

import java.util.ArrayList;

import vo.Pedido;
import vo.dao.PedidoDAO;

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
		if(pedidos.size()<1) {
			return 1;
		}else {
			return pedidos.get(pedidos.size()-1).getId()+1;
		}
	}
}
