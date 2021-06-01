package model;

public interface Assunto {
	public void registar(Observer o);
	public void desRegistar(Observer o);
	public void notificar();
}
