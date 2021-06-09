package domains;

public class Cash extends Money {

	public Cash() {
		super();
	}

	public Cash(int val, int qtd, String nome, String img) {
		super(val, qtd, nome, img);
	}

	@Override
	public String toString() {
		if (getQtd() != 1)
			return getQtd() + " notas de R$ " + getVal() + ",00 - " + getNome() + " Reais";
		else
			return getQtd() + " nota de R$ " + getVal() + ",00 - " + getNome() + " Reais";
	}

}
