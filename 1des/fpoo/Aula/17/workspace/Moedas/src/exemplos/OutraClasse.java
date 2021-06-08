package exemplos;

public class OutraClasse {

	public static void main(String[] args) {
		
		double funcao1 = Funcoes.investir1(100);
		double funcao2 = Funcoes.investir1(200);
		double funcao3 = Funcoes.investir1(300);
		
		System.out.printf("Eu tenho %.2f\n",funcao1);
		System.out.printf("Eu tenho %.2f\n",funcao2);
		System.out.printf("Eu tenho %.2f\n",funcao3);
		Funcoes.investir2(400);

	}

}
