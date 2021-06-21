package modelo;

public class Viagem {
	
	private String origem;
	private String destino;
	private int distancia;
	private int tempo;
	public Viagem(String origem, String destino, int distancia, int tempo) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		this.tempo = tempo;
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
	
	float getVelocidade() {
		return (float) distancia / tempo;
	}
	@Override
	public String toString() {
		return origem + "\t" + destino + "\t" + distancia + "\t" + tempo + "\t" + String.format("%.1f", getVelocidade());
	}
	
}
