package auladia11;

import java.util.Scanner;
import java.util.Locale;

public class ExercList2_6 {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		float vendas = 0;
		double comi = 0;
		
		System.out.println("Quanto foi vendido?");
		vendas = input.nextFloat();
		
		if (vendas <= 2000) {
			comi = 0.05 * vendas ;
		}else if (vendas < 8000){
			comi = 0.06 * vendas;
		}else if (vendas >= 8000){
			comi = 0.08 * vendas;
		}
		
		System.out.println("O total em comissão é R$" + comi);
		
		input.close();
	}
}
