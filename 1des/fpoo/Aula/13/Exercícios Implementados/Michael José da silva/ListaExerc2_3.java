import java.util.Scanner;

public class ListaExerc2_3 {
    public static void main(String[] args) throws Exception {
        //Importando método Scanner/input
        Scanner input = new Scanner(System.in);
        //Variáveis
        double altura, imc; int peso;
        //Estrutura de repetição While/Enquanto
        while (true) {
            
            //Entradas

            System.out.print("Digite seu Nome: ");
            String nome = input.nextLine();
            System.out.print("Altura: ");
            altura = input.nextDouble();
            System.out.print("Peso: ");
            peso = input.nextInt();
            System.out.printf("Nome: %s IMC: %.2f\n",nome, imc = peso/(altura * altura));
            // Estruturas condicional simples if/Se e composta else/Senão
            // Saídas
            if (imc <= 18.5){
                System.out.println("Abaixo do peso");
                break;
            }else if ((imc > 18.5) && (imc <= 25)){
                System.out.println("Peso normal");
                break;
            }else if ((imc > 25) && (imc <= 30)){
                System.out.println("Acima do peso");
                break;
            }else{
                System.out.println("Obeso");  
                break;
            }

        }
        input.close();
    }
}