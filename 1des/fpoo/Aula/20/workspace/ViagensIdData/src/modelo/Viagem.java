package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Viagem {
	
	//Atributos
	private int id;
	private Date data;
	private String origem;
	private String destino;
	private int distancia;
	private int tempo;
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");//Classe para formatar a Data

	//Construtor com todos os campos
	public Viagem(int id, Date data, String origem, String destino, int distancia, int tempo) {
		this.id = id;
		this.data = data;
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		this.tempo = tempo;
	}

	public int getId() {
		return id;
	}
	
	//Getters && Setters
	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Viagem() {
		super();
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	//Método que obtem a velocidade da viagem
	float getVelocidade() {
		return (float) distancia / tempo;
	}

	//ToString
	@Override
	public String toString() {
		return id + "\t" + formato.format(data) + "\t" + origem + "\t" + destino + "\t" + distancia + "\t" + tempo + "\t"
				+ String.format("%.1f", getVelocidade()) + "\n";
	}

	public String toCSV() {
		return id + ";" + formato.format(data) + ";" + origem + ";" + destino + ";" + distancia + ";" + tempo + "\r\n";
	}

	//HashCode && Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Viagem other = (Viagem) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
