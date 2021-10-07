package domains;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

import controllers.PedidoProcess;

public class Pedido {

	// Atributos encapsulados
	private int id;
	private String cliente;
	private String endereco;
	private String produto;
	private Date data;
	private Date horaPedido;
	private Date horaInicioEntrega;
	private Date horaFimEntrega;

	// Atributos uteis para manipulação de data e hora
	SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat fh = new SimpleDateFormat("hh:mm");

	// Construtores
	public Pedido() {
	}

	public Pedido(int id) {
		this.id = id;
	}

	public Pedido(String id) {
		this.id = Integer.parseInt(id);
	}

	public Pedido(String cliente, String endereco, String produto) {
		this.id = PedidoProcess.autoIncrementId();
		this.cliente = cliente;
		this.endereco = endereco;
		this.produto = produto;
		this.data = new Date();
		this.horaPedido = new Date();
	}

	public Pedido(String[] csv) {
		try {
			this.id = Integer.parseInt(csv[0]);
			this.cliente = csv[1];
			this.endereco = csv[2];
			this.produto = csv[3];
			this.data = fd.parse(csv[4]);
			this.horaPedido = fh.parse(csv[5]);
			if (!csv[6].equals("null"))
				this.horaInicioEntrega = fh.parse(csv[6]);
			if (!csv[7].equals("null"))
				this.horaFimEntrega = fh.parse(csv[7]);
		} catch (ParseException e) {
			System.out.println("Erro na conversão de tipos de dados " + e);
		}
	}

	public Pedido(String id, String cliente, String endereco, String produto, String data, String horaPedido,
			String horaInicioEntrega, String horaFimEntrega) {
		try {
			this.id = Integer.parseInt(id);
			this.cliente = cliente;
			this.endereco = endereco;
			this.produto = produto;
			this.data = fd.parse(data);
			this.horaPedido = fh.parse(horaPedido);
			this.horaInicioEntrega = fh.parse(horaInicioEntrega);
			this.horaFimEntrega = fh.parse(horaFimEntrega);
		} catch (ParseException e) {
			System.out.println("Erro na conversão de tipos de dados " + e);
		}
	}

	// Getters && Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
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

	public Date getHoraInicioEntrega() {
		return horaInicioEntrega;
	}

	public void setHoraInicioEntrega(Date horaInicioEntrega) {
		this.horaInicioEntrega = horaInicioEntrega;
	}

	// caso não seja passado atributo configura a hora do sistema
	public void setHoraInicioEntrega() {
		this.horaInicioEntrega = new Date();
	}

	public Date getHoraFimEntrega() {
		return horaFimEntrega;
	}

	public void setHoraFimEntrega(Date horaFimEntrega) {
		this.horaFimEntrega = horaFimEntrega;
	}

	// caso não seja passado atributo configura a hora do sistema
	public void setHoraFimEntrega() {
		this.horaFimEntrega = new Date();
	}

	// Chave = id
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		if (horaInicioEntrega == null) {
			return id + "\t" + cliente + "\t" + endereco + "\t" + produto + "\t" + fd.format(data) + "\t"
					+ fh.format(horaPedido) + "\tnull\tnull\n";
		} else if (horaFimEntrega == null) {
			return id + "\t" + cliente + "\t" + endereco + "\t" + produto + "\t" + fd.format(data) + "\t"
					+ fh.format(horaPedido) + "\t" + fh.format(horaInicioEntrega) + "\tnull\n";
		} else {
			return id + "\t" + cliente + "\t" + endereco + "\t" + produto + "\t" + fd.format(data) + "\t"
					+ fh.format(horaPedido) + "\t" + fh.format(horaInicioEntrega) + "\t" + fh.format(horaFimEntrega)
					+ "\n";
		}
	}

	public String toCSV() {
		if (horaInicioEntrega == null) {
			return id + ";" + cliente + ";" + endereco + ";" + produto + ";" + fd.format(data) + ";"
					+ fh.format(horaPedido) + ";null;null\r\n";
		} else if (horaFimEntrega == null) {
			return id + ";" + cliente + ";" + endereco + ";" + produto + ";" + fd.format(data) + ";"
					+ fh.format(horaPedido) + ";" + fh.format(horaInicioEntrega) + ";null\r\n";
		} else {
			return id + ";" + cliente + ";" + endereco + ";" + produto + ";" + fd.format(data) + ";"
					+ fh.format(horaPedido) + ";" + fh.format(horaInicioEntrega) + ";" + fh.format(horaFimEntrega)
					+ "\r\n";
		}
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put("id", this.id);
			json.put("cliente", this.cliente);
			json.put("endereco", this.endereco);
			json.put("produto", this.produto);
			json.put("data", fd.format(this.data));
			json.put("horaPedido", fh.format(this.horaPedido));
			if(horaInicioEntrega != null)json.put("horaInicioEntrega", fh.format(this.horaInicioEntrega));
			if(horaFimEntrega != null)json.put("horaFimEntrega", fh.format(this.horaFimEntrega));
		} catch (JSONException e) {
			System.out.println("Erro na conversão JSON " + e);
		}		
		return json;
	}
}