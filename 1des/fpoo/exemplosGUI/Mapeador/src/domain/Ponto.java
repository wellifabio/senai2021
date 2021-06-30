package domain;

public class Ponto {

	private String id;
	private String descricao;
	private String icone;
	private String origem;
	private String destino;
	private String pai;

	public Ponto() {
	}

	public Ponto(String id) {
		this.id = id;
	}
	
	public Ponto(String id, String descricao, String icone, String origem, String destino, String pai) {
		this.id = id;
		this.descricao = descricao;
		this.icone = icone;
		this.origem = origem;
		this.destino = destino;
		this.pai = pai;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Ponto other = (Ponto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id + "\t" + descricao + "\t" + icone + "\t" + origem + "\t" + destino + "\t" + pai + "\n";
	}

	public String toCSV() {
		return id + ";" + descricao + ";" + icone + ";" + origem + ";" + destino + ";" + pai + "\r\n";
	}
	
	public String[] getStringVetor() {
		return new String[]{id, descricao, icone, origem, destino, pai};
	}
}
