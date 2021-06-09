package domains;

//Super Classe Abstrada
public abstract class Money {

	// Atributos
	private int val;
	private int qtd;
	private String nome;
	private String img;

	// Construtores
	public Money() {
	}

	public Money(int val, int qtd, String nome, String img) {
		this.val = val;
		this.qtd = qtd;
		this.nome = nome;
		this.img = img;
	}

	// Getters && Setters
	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	//Chave primária valor
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + val;
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
		Money other = (Money) obj;
		if (val != other.val)
			return false;
		return true;
	}
	
}
