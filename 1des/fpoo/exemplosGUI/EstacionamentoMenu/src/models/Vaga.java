package models;

import javax.swing.ImageIcon;

public class Vaga {

	private String codigo;
	private String placa;
	private ImageIcon img;
	private int indice;

	public Vaga(String codigo) {
		this.codigo = codigo;
		this.placa = "";
		this.indice = 0;
		if (codigo.substring(0, 1).equals("M")) {
			this.img = new ImageIcon("./assets/moto30.png");
		} else {
			if (Integer.valueOf(codigo.substring(2, 3)) > 4) {
				this.img = new ImageIcon("./assets/carro230.png");
			} else {
				this.img = new ImageIcon("./assets/carro130.png");
			}
		}
	}

	public Vaga(String codigo, String placa, int indice) {
		this.codigo = codigo;
		this.placa = placa;
		this.indice = indice;
		if (codigo.substring(0, 1).equals("M")) {
			this.img = new ImageIcon("./assets/moto.png");
		} else {
			if (Integer.valueOf(codigo.substring(2, 3)) > 4) {
				this.img = new ImageIcon("./assets/carro2.png");
			} else {
				this.img = new ImageIcon("./assets/carro1.png");
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Vaga other = (Vaga) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

}
