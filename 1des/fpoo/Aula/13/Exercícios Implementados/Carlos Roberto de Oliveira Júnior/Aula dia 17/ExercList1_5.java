package auladia11;
import java.util.Scanner;
import java.util.Locale;

public class ExercList1_5 {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner input = new Scanner(System.in);
		
		float a = input.nextInt();
		float b = input.nextInt();
		float c = input.nextInt();
		
		double d = Math.sqrt((b * b) - (4*a*c));
		
		if (d >= 0) {		
			double r_1 = (- b + d) / (2 * a);
			double r_2 = (- b - d) / (2 * a);
			
			System.out.printf("A primeira raiz é igual a: %f\nA segunda raiz é igual a: %f", r_1, r_2);
		} else {
			System.out.println("Não há raízes reais para tal equação");
		}

		input.close();
		
	}
}

