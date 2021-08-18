package vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Bem {

	// Atributos
	private int id;
	private String descricao;
	private Date data;
	private double valor;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// Construtores
	public Bem() {
	}

	public Bem(int id) {
		this.id = id;
	}
	
	public Bem(int id, String descricao, Date data, double valor) {
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.valor = valor;
	}
	
	public Bem(int id, String descricao, String data, double valor) {
		this.id = id;
		this.descricao = descricao;
		try {
			this.data = sdf.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.valor = valor;
	}

	public Bem(String[] vetor) {
		try {
			this.id = Integer.valueOf(vetor[0]);
			this.descricao = vetor[1];
			this.data = sdf.parse(vetor[2]);
			this.valor = Double.valueOf(vetor[3]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// Getters && Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	// Chave
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
		Bem other = (Bem) obj;
		return id == other.id;
	}

	// toString, CSV, HTML
	@Override
	public String toString() {
		return id + "\t" + descricao + "\t" + sdf.format(data) + "\t" + valor + "\n";
	}

	public String toCSV() {
		return id + ";" + descricao + ";" + sdf.format(data) + ";" + valor + "\r\n";
	}

	public String toHTML() {
		return "<tr><td>" + id + "</td><td>" + descricao + "</td><td>" + sdf.format(data) + "</td><td>" + valor
				+ "</td></tr>";
	}

	public String toURL() {
		return "?id=" + id + "&descricao=" + descricao + "&data=" + sdf.format(data) + "&valor=" + valor;
	}
		
}
