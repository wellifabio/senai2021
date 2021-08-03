package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Estacionamento {

	private int id;
	private String vaga;
	private String placa;
	private Date data;
	private String horaEntrada;
	private String horaSaida = "";
	private double valorHora;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Estacionamento() {
	}

	public Estacionamento(String placa, Date data) {
		this.placa = placa;
		this.data = data;
	}

	public Estacionamento(int id, String vaga, String placa, Date data, String horaEntrada, String horaSaida,
			double valorHora) {
		this.id = id;
		this.vaga = vaga;
		this.placa = placa;
		this.data = data;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.valorHora = valorHora;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVaga() {
		return vaga;
	}

	public void setVaga(String vaga) {
		this.vaga = vaga;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacionamento other = (Estacionamento) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}

	// Método para calcular o valor a ser pago ao estacionar
	public double getTotal() {
		if (horaSaida.equals(null) || horaSaida.equals("null") || horaSaida.equals("")) {
			return valorHora;
		} else {
			int hEntra = Integer.valueOf(horaEntrada.split(":")[0]);
			int hSaida = Integer.valueOf(horaSaida.split(":")[0]);
			if (hSaida - hEntra == 0)
				return valorHora;
			else
				return (hSaida - hEntra) * valorHora;
		}
	}

	@Override
	public String toString() {
		return id + "\t" + vaga + "\t" + placa + "\t" + sdf.format(data) + "\t" + horaEntrada + "\t" + horaSaida + "\t"
				+ valorHora + "\t" + getTotal() + "\n";
	}

	public String toCSV() {
		return id + ";" + vaga + ";" + placa + ";" + sdf.format(data) + ";" + horaEntrada + ";" + horaSaida + ";"
				+ valorHora + "\r\n";
	}

	public String[] toVetor() {
		return new String[] { id + "", vaga, placa, sdf.format(data), horaEntrada, horaSaida, valorHora + "",
				getTotal() + "" };
	}

}
