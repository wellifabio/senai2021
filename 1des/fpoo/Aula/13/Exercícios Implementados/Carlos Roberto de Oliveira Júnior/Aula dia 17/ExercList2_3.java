package auladia11;

import java.util.Scanner;
import java.util.Locale;

public class ExercList2_3 {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		float p, h, imc;
		
		System.out.println("Insira seu peso: ");
		p = input.nextFloat();
		System.out.println("Insira sua altura: ");
		h = input.nextFloat();
		
		imc = p / (h * h);
		
		if (imc < 18.5) {
			System.out.println("Você está abaixo do peso");
		} else if (18.5 <= imc && imc < 25){
			System.out.println("Você está no seu peso ideal");
		} else if (25 <= imc && imc < 30) {
			System.out.println("Você está acima do peso");
		} else {
			System.out.println("Você está obesa(o)");
		}
		
		input.close();
	}
}
