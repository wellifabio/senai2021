import java.util.Locale; //Para fazer leitura de número com .
import java.util.Scanner; //Para leitura do teclado

public class ExercLista1_3 {
public static void main(String args []) {
		Locale.setDefault(Locale.US); // Configura Estados Unidos para conseguir ler ponto
		Scanner input = new Scanner(System.in); // Instacia objeto para leitura do teclado
		
		float a, b, c, d, e; // Declara variáveis para leitura das entradas
		//int a_o, b_o, c_o, d_o, e_o // Declara variáveis para salvar o múltiplos
		
		// Faz a leitura das 5 variáveis
		a = input.nextFloat();
		b = input.nextFloat();
		c = input.nextFloat();
		d = input.nextFloat();
		e = input.nextFloat();
		
		/*
		// Declara variáveis para salvar o dobro dos valores de entrada
		a_o = a * 2;
		b_o = b * 2;
		c_o = c * 2;
		d_o = d * 2;
		e_o = e * 2;
		*/
		
		// Saída para o usuário
		System.out.printf("O valor original é %.2f, e o seu dobro é %.2f\n", a, (a * 2));
		System.out.printf("O valor original é %.2f, e o seu dobro é %.2f\n", b, (b * 2));
		System.out.printf("O valor original é %.2f, e o seu dobro é %.2f\n", c, (c * 2));
		System.out.printf("O valor original é %.2f, e o seu dobro é %.2f\n", d, (d * 2));
		System.out.printf("O valor original é %.2f, e o seu dobro é %.2f\n", e, (e * 2));
		
		// Sempre precisa fechar a entrada do teclado, caso tenha utilizado ela
		input.close();
	}
}