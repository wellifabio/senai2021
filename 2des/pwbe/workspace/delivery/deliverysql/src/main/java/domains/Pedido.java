package domains;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pedido {

	private int idPedido;
	private Cliente cliente;
	private Entregador entregador;
	private Date data;
	private Date horaPedido;
	private Date horaEntrega;
	private Date horaFim;

	private SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat h = new SimpleDateFormat("hh:mm");

	public Pedido() {
	}

	public Pedido(int idPedido, Cliente cliente, Entregador entregador, Date data, Date horaPedido, Date horaEntrega,
			Date horaFim) {
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.entregador = entregador;
		this.data = data;
		this.horaPedido = horaPedido;
		this.horaEntrega = horaEntrega;
		this.horaFim = horaFim;
	}

	public Pedido(String idPedido, String idCliente, String idEntregador, String data, String horaPedido,
			String horaEntrega, String horaFim) {
		this.idPedido = Integer.valueOf(idPedido);
		this.cliente = new Cliente(idCliente);
		this.entregador = new Entregador(idEntregador);
		try {
			this.data = d.parse(data);
			this.horaPedido = h.parse(horaPedido);
			this.horaEntrega = h.parse(horaEntrega);
			this.horaFim = h.parse(horaFim);
		} catch (ParseException e) {
			System.out.println("Erro converter data/hora: "+e);
		}
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHoraPedido() {
		return horaPedido;
	}

	public void setHoraPedido(Date horaPedido) {
		this.horaPedido = horaPedido;
	}

	public Date getHoraEntrega() {
		return horaEntrega;
	}

	public void setHoraEntrega(Date horaEntrega) {
		this.horaEntrega = horaEntrega;
	}

	public Date getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}

}
