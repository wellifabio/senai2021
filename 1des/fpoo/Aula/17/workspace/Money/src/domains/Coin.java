package domains;

public class Coin extends Money {

	public Coin() {
		super();
	}

	public Coin(int val, int qtd, String nome, String img) {
		super(val, qtd, nome, img);
	}

	@Override
	public String toString() {
		if (getQtd() != 1)
			if (getVal() < 10)
				return getQtd() + " moedas de R$ 0,0" + getVal() + " - " + getNome() + " centavos";
			else if (getVal() == 100)
				return getQtd() + " moedas de R$ " + getVal() + ",00 - " + getNome() + " Real";
			else
				return getQtd() + " moedas de R$ 0," + getVal() + " - " + getNome() + " centavos";
		else if (getVal() < 10)
			if (getVal() == 1)
				return getQtd() + " moeda de R$ " + getVal() + ",00 - " + getNome() + " real";
			else
				return getQtd() + " moeda de R$ 0,0" + getVal() + " - " + getNome() + " centavos";
		else
			return getQtd() + " moeda de R$ 0," + getVal() + " - " + getNome() + " centavos";
	}

}
