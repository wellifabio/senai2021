import java.util.Random;
import java.util.Scanner;

public class ListaExerc2_2 {
    public static void main(String[] args) throws Exception {
        //Importando método Scanner/input
        //Importando método Random/Aleatorio gera um valor aleatorio
        Scanner input = new Scanner(System.in);
        Random aleatorio = new Random();
        // Variáveis
        int t, z;
        double x, media;
        t = 0;  //Coletando o valor aleatório acumulado para calc. média
        x = 0;  // acumulando as nota já multi.
        // Entrada
        System.out.print("Numero de vezes: ");
        int vezesNotas = input.nextInt();
        // Processo / Saída
        // Estrutura de repetição For/Para
        for (z = 1; z <= vezesNotas; z++) {
            System.out.printf("Nota (%d): ",z);
            double notas = input.nextDouble();
            int y = aleatorio.nextInt(5);
            x += notas * y;  // Somando nota já mult. e incrementando em x
            t += y; // Setar valor peso (aleatório) em T 
            System.out.printf("Peso da nota %d = (%d) e Soma dos Pesos (%d)\n",z,y,t);
            System.out.printf("notas já Multiplicada e Incrementada %.2f\n", x);
            
        }
        media = x/t;
        // Saída / Processo
        System.out.printf("(Média Ponderada) do Aluno (%.1f)", media);
        input.close();
    }
}
