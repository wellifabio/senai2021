package models;

import javax.swing.ImageIcon;

public class Vaga {
	
	private String codigo;
	private ImageIcon img;
	private boolean status;

	public Vaga(String codigo, boolean status) {
		this.codigo = codigo;
		this.status = status;
		String extensao = ".png";
		if(!status)
			extensao = "30.png";
		if (codigo.substring(0, 1).equals("M")) {
			this.img = new ImageIcon("./assets/moto"+extensao);
		} else {
			if (Integer.valueOf(codigo.substring(2, 3)) > 4) {
				this.img = new ImageIcon("./assets/carro2"+extensao);

			} else {
				this.img = new ImageIcon("./assets/carro1"+extensao);
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
