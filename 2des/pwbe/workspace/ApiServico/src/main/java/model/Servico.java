package model;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

public class Servico {
	private int id;
	private String prestador;
	private double horasTrabalhadas;
	private double valorHora;

	//Construtores
	public Servico() {
	}
	
	public Servico(String id) {
		this.id = Integer.valueOf(id);
	}

	//Getters && Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrestador() {
		return prestador;
	}

	public void setPrestador(String prestador) {
		this.prestador = prestador;
	}

	public double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(double horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	//Chave
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
		Servico other = (Servico) obj;
		return id == other.id;
	}

	//Cálculos unitários
	public double getSubTotal() {
		return this.valorHora * this.horasTrabalhadas;
	}

	public double getISS() {
		return (getSubTotal() * 7) / 100;
	}

	public double getTotal() {
		return getISS() + getSubTotal();
	}

	//Saídas
	@Override
	public String toString() {
		return id + "\t" + prestador + "\t" + horasTrabalhadas + "\t" + valorHora + "\n";
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put("id", id);
			json.put("prestador", prestador);
			json.put("horas_trabalhadas", horasTrabalhadas);
			json.put("valor_hora", valorHora);
			json.put("iss", getISS());
			json.put("subtotal", getSubTotal());
			json.put("total", getTotal());
			return json;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
