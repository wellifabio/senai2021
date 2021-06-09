package modelo;

public class Cedula extends Dinheiro{

	public Cedula() {
		super();
	}

	public Cedula(int valor, String nome, int quantidade) {
		super(valor, nome, quantidade);
	}

	@Override
	public String toString() {
		return super.getQuantidade()+" x "+String.format("R$ %d,00", super.getValor())+" "+super.getNome()+" Reais";
	}
}
