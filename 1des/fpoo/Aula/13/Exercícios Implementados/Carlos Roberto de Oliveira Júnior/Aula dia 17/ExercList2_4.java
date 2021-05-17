package auladia11;

import java.util.Scanner;
import java.util.Locale;

public class ExercList2_4 {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		float a, p, h, imc;
		
		System.out.println("Qual seu sexo? (1-masculino 2- feminino)");
		a = input.nextFloat();
		System.out.println("Informe seu peso: ");
		p = input.nextFloat();
		System.out.println("Informe sua altura: ");
		h = input.nextFloat();
		imc = p / (h * h);
		
		
		if (a == 1) {
			if (imc < 20.7) {
				System.out.printf("Seu IMC é: %.1f e você está abaixo do peso\n");
			}else if (20.7 <= imc && imc < 26.4) {
				System.out.printf("Seu IMC é: %.1f e você está no seu peso ideal\n", imc);
			}else if (26.4 <= imc && imc < 27.8) {
				System.out.printf("Seu IMC é: %.1f e você está levemente acima do peso\n", imc);
			}else if (27.8 <= imc && imc < 31.1) {
				System.out.printf("Seu IMC é: %.1f e você está acima do peso\n", imc);
			}else {
				System.out.printf("Seu IMC é: %.1f e você está obeso\n", imc);
			}
		}else { if (imc < 19.1) {
			System.out.printf("Seu IMC é: %.1f e você está abaixo do peso\n", imc);
		}else if (19.1 <= imc && imc < 25.8) {
			System.out.printf("Seu IMC é: %.1f e você está no seu peso ideal\n", imc);
		}else if (25.8 <= imc && imc < 27.3) {
			System.out.printf("Seu IMC é: %.1f e você está levemente acima do peso\n", imc);
		}else if (27.3 <= imc && imc < 32.3) {
			System.out.printf("Seu IMC é: %.1f e você está acima do peso\n", imc);
		}else {
			System.out.printf("Seu IMC é: %.1f e você está obesa\n", imc);
		}
		}
		input.close();
	}
}
