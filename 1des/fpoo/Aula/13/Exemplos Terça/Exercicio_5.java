import java.util.Scanner;
import java.util.Locale;



public class Exercicio_5 {
	public static void main (String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		float a, b, c, delta;
		double x1, x2;


		a = input.nextFloat();
		b = input.nextFloat();
		c = input.nextFloat();


		delta = (b*b)-(4 * a * c);
		if (delta >= 0) {
			x1 = (-b + Math.sqrt(delta)) / ( 2 * a);
			x2 = (-b - Math.sqrt(delta)) / ( 2 * a);
			System.out.printf("A duas raizes são: %f e %f",x1, x2);


		}

		else {
			System.out.println("Não ha raizes reais");
		}



		input.close();

	}

}