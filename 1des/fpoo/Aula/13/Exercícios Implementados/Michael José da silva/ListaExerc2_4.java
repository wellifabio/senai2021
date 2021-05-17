import java.util.Scanner;

public class ListaExerc2_4 {
    public static void main(String[] args) throws Exception {
        //Importando método Scanner/input
        Scanner input = new Scanner(System.in);
        //Variáveis
        double altura, imc; int peso, sexo;
        //Estrutura de repetição While/Enquanto
        while (true) {

            //Entradas

            System.out.print("Digite seu Nome: ");
            String nome = input.nextLine();
            System.out.print("Sexo: 1 - masculino  2 - Feminino ? ");
            sexo = input.nextInt();
            System.out.print("Altura: ");
            altura = input.nextDouble();
            System.out.print("Peso: ");
            peso = input.nextInt();
            System.out.printf("Nome: %s IMC: %.2f\n",nome, imc = peso/(altura * altura));

            // Estruturas condicional simples if/Se e composta else/Senão
            // Saídas 

            if (sexo == 1){
                if (imc <= 20.7){
                    System.out.println("Abaixo do peso");
                  
                }else if ((imc > 20.7) && (imc <= 26.4)){
                    System.out.println("Peso normal");
                   
                }else if ((imc > 26.4) && (imc <= 27.8)){
                    System.out.println("Marginalmente acima do peso");

                }else if ((imc > 27.8) && (imc <= 31.1)) {
                    System.out.println("Acima do peso ideal");
                }
                else{
                    System.out.println("Obeso");
                }
                     
            }else if (sexo == 2) {
                if (imc <= 19.1){
                    System.out.println("Abaixo do peso");
                
                }else if ((imc > 19.1) && (imc <= 25.8)){
                    System.out.println("Peso normal");

                }else if ((imc > 25) && (imc <= 27.3)){
                    System.out.println("Marginalmente acima do peso");
                    
                }else if ((imc > 27.3) && (imc <= 32.3)) {
                    System.out.println("Acima do peso ideal");
                }
                else{
                    System.out.println("Obeso");  
                }   
            }
            // Avalia se o usuário quer continuar ou não o programa
            System.out.print("deseja calcular outro IMC, 1-sim e 2-não: ");
            int outroIMC = input.nextInt();
            if (outroIMC == 2) {
                break;
            }
            input.nextLine(); // Gambiarra para não bugar o print
        }
        input.close();
    }
}