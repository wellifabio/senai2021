package controlls;

public class Conversao {

	private String questao;
	private String resposta;
	private String de;
	private String para;
	private String[] partesDaQuestao;
	private double quantidade;

	public Conversao(String entrada) {
		questao = entrada;
		partesDaQuestao = getEntrada().split(" ");
		de = capitalizar(partesDaQuestao[1]);
		para = paraMinusculas(partesDaQuestao[3]);
		quantidade = Double.valueOf(partesDaQuestao[0]);
		resposta = partesDaQuestao[0] + " " + partesDaQuestao[1] + " iguais ";
	}

	private String paraMinusculas(String palavraParaMinuscula) {
		return palavraParaMinuscula.toLowerCase();
	}

	public String getEntrada() {
		return questao;
	}

	private String capitalizar(String palavraCapitalizar) {
		palavraCapitalizar = palavraCapitalizar.toLowerCase();
		palavraCapitalizar = Character.toUpperCase(palavraCapitalizar.charAt(0)) + palavraCapitalizar.substring(1);
		int comprimento = palavraCapitalizar.length();
		if (palavraCapitalizar.charAt(comprimento - 1) != 's') {
			palavraCapitalizar = new StringBuffer(palavraCapitalizar).insert(comprimento, "s").toString();
		}
		return palavraCapitalizar;
	}

	public String getQuestao() {
		return questao;
	}

	public String getResposta() {
		return resposta;
	}

	public String getDe() {
		return de;
	}

	public String getPara() {
		return para;
	}

	public double getQuantidade() {
		return quantidade;
	}
}
