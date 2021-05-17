package auladia11;

import java.util.Scanner;
import java.util.Locale;

public class ExercList2_2 {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner input = new Scanner(System.in);
		
		float a, b, c, d;
		
		a = input.nextFloat();
		b = input.nextFloat();
		c = input.nextFloat();
		d = input.nextFloat();
		
		System.out.printf("A média dos 4 números é: %.2f", ((a * 2 + b * 3 + c * 4 + d * 5) / 14) );
		
		input.close();
	}
}

