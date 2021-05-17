import java.util.Scanner;
public class ListaExerc2_1 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        // Variáveis

        double media, x;
        x = 0;
        // Entrada

        System.out.print("Numero de Notas: ");
        int vezesNotas = input.nextInt();
        // Processo
        
        for (int z = 1; z <= vezesNotas; z++) {
            System.out.printf("Nota (%d): ",z);
            double notas = input.nextDouble();
            x += notas;
        }
        media = x/vezesNotas;
        // Saída e Processo
        System.out.printf("(Média Simples) do Aluno: %.1f", media);
        input.close();
    }
}
