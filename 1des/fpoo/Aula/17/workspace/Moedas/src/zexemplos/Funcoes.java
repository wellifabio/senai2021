package zexemplos;

public class Funcoes {

	protected static double investir1(double dinheiro) {
		dinheiro = dinheiro * 1.1;
		return dinheiro;
	}
	
	protected static void investir2(double dinheiro) {
		System.out.printf("Eu tenho %.2f\n",(dinheiro * 1.1));
	}

}
