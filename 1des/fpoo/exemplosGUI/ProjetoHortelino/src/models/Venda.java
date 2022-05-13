package models;

public class Venda {

	private int num;
	private String data;
	private String hora;
	private Produto produto;
	private int quantidade;

	// GETs && SETss
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	// Outros Métodos
	public double getSubtotal() {
		return this.quantidade * this.produto.getPreco();
	}

	@Override
	public String toString() {
		return "Compra [num=" + num + ", data=" + data + ", hora=" + hora + ", produto=" + produto.getCodigo()
				+ ", preco =" + produto.getPreco() + ", quantidade=" + quantidade + "]";
	}

	//Metodo para enviar os dados para um arquivo de texto
	public String toCSV() {
		return num + ";" + data + ";" + hora + ";" + produto.getCodigo() + ";" + produto.getPreco() + ";" + quantidade
				+ "\r\n";
	}

	public String[] getStringVetor() {
		return new String[] { "" + num, data, hora, "" + produto.getCodigo(), "" + produto.getPreco(), "" + quantidade,
				String.format("%.2f", getSubtotal()) };
	}

	public String cabecalho() {
		return "Numero   Data               Hora                   (Cod Produto                          Preço)      Quantidade";
	}

}
