package modelo;

public class Cedula extends Dinheiro{

	public Cedula() {
		super();
	}

	public Cedula(int valor, String nome) {
		super(valor, nome);
	}

	@Override
	public String toString() {
		return String.format("R$ %d,00", super.getValor())+" "+super.getNome()+" Reais";
	}
}
