package model;

public class ObservadorEstoque implements Observer {

	private double precoForn1;
	private double precoForn2;
	private double precoForn3;

	private static int observerIdRastreador = 0;
	private int observerId;
	private Assunto observaPrecos;

	public ObservadorEstoque(Assunto observaPrecos) {
		this.observaPrecos = observaPrecos;
		this.observerId = ++observerIdRastreador;
		System.out.println("Nova observação " + this.observerId);
		observaPrecos.registar(this);
	}

	@Override
	public void update(double precoForn1, double precoForn2, double precoForn3) {
		this.precoForn1 = precoForn1;
		this.precoForn2 = precoForn2;
		this.precoForn3 = precoForn3;
		
	}

}
