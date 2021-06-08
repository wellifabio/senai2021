package modelo;

public class Moeda extends Dinheiro {

	public Moeda() {
		super();
	}

	public Moeda(int valor, String nome) {
		super(valor, nome);
	}

	@Override
	public String toString() {
		if(super.getValor() != 100)
			if(super.getValor() < 10)
				return String.format("R$ 0,0%d", super.getValor())+" "+super.getNome()+" centavos";
			else
				return String.format("R$ 0,%d", super.getValor())+" "+super.getNome()+" centavos";
		else
			return String.format("R$ %d,00", (super.getValor()/100))+" "+super.getNome()+" Real";
	}
}
