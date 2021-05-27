package domain;

public class Valor {

	private int num;
	private String estenso;

	public Valor() {
	}

	public Valor(int num, String estenso) {
		this.num = num;
		this.estenso = estenso;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getEstenso() {
		return estenso;
	}

	public void setEstenso(String estenso) {
		this.estenso = estenso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
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
		Valor other = (Valor) obj;
		if (num != other.num)
			return false;
		return true;
	}
	
}
