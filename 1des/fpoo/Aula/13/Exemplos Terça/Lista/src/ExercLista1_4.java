import java.util.Locale;
import java.util.Scanner;

public class ExercLista1_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner objScanner = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		float valor = objScanner.nextFloat();
		objScanner.nextLine();
		String operacao = objScanner.nextLine();
		
		switch(operacao) {
			case "+":
				for (int i=1;i<=10;i++) {
					System.out.printf("%f + %d = %f\n",valor,i,valor+i);
				}
			break;
			case "-":
				for (int i=1;i<=10;i++) {
					System.out.printf("%f - %d = %f\n",valor,i,valor-i);
				}
			break;
			case "*":
				for (int i=1;i<=10;i++) {
					System.out.printf("%f * %d = %f\n",valor,i,valor*i);
				}
			break;
			case "/":
				for (int i=1;i<=10;i++) {
					System.out.printf("%f / %d = %f\n",valor,i,valor/i);
				}
			break;
			default:
				System.out.println("Voce digitou um operador errrado!");
		
		}
		
	}

}
