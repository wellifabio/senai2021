package model;

import java.util.ArrayList;

public class ObservadorPrecos implements Assunto {

	private ArrayList<Observer> observers;
	private double precoForn1;
	private double precoForn2;
	private double precoForn3;

	public ObservadorPrecos() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registar(Observer o) {
		observers.add(o);

	}

	@Override
	public void desRegistar(Observer o) {
		int indice = observers.indexOf(o);
		System.out.println("Observer " + (indice + 1) + " excluído");
		observers.remove(indice);

	}

	@Override
	public void notificar() {
		for (Observer o : observers) {
			o.update(precoForn1, precoForn2, precoForn3);
		}
	}

	public void setPrecoForn1(double precoForn1) {
		this.precoForn1 = precoForn1;
		notificar();
	}

	public void setPrecoForn2(double precoForn2) {
		this.precoForn2 = precoForn2;
		notificar();
	}

	public void setPrecoForn3(double precoForn3) {
		this.precoForn3 = precoForn3;
		notificar();
	}

}
