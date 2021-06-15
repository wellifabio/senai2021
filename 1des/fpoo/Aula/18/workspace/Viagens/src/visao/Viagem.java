package visao;

public class Viagem {
	
	// atributos
	String origem;
	String destino;
	int distancia;
	float tempo;

	// ações
	public float getVelocidade() { // método
		return distancia / tempo;
	}

	// Construtor
	public Viagem(String origem, String destino, int distancia, float tempo) {
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		this.tempo = tempo;
	}

	@Override
	public String toString() {
		return "\t" + origem + "\t" + destino + "\t" + distancia + "\t" + tempo
				+ "\t" + String.format("%.1f",getVelocidade());
	}

}
