package auladia11;

import java.util.Scanner;
import java.util.Locale;

public class ExercList2_5 {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		float a, b, c;
		
		a = input.nextFloat();
		b = input.nextFloat();
		c = input.nextFloat();
		
		if ((a >= (b + c)) || (b >= (a + c)) || (c >= (a + b))) {
			System.out.println("Estes números não formam um triangulo");
		}else {
			System.out.println("Estes números formam um triangulo");
		}
		
		input.close();
	}
}
