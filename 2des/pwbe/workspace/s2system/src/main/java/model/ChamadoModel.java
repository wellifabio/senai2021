package model;

public class ChamadoModel {

	//Atributos
	private int id;
	private String data;
	private String status;
	private String responsavel;
	private float valor;
	
	//Construtor
	public ChamadoModel(int id, String data, String status, String responsavel, float valor) {
		this.id = id;
		this.data = data;
		this.status = status;
		this.responsavel = responsavel;
		this.valor = valor;
	}
	
	//Pra manipular arquivos
	public String toCsv() {
		return id + ";" + data + ";" + status + ";" + responsavel + ";" + valor + "\r\n";
	}
	
	//Getters && Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
}
