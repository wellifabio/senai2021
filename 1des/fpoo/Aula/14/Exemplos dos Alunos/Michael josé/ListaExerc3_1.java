import java.util.Scanner;

public class ListaExerc3_1 {
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        //variável
        int diaSemana = 0;

        //Estrutura de repetição while/Enquanto
        while (true){
            System.out.print("Digite um numero de 1 a 7: ");
            diaSemana = input.nextInt();
            if ((diaSemana != 0)&&(diaSemana <= 7)) {
                //Estrutura Switch
                switch (diaSemana) {
                    case 1:
                        System.out.println("É Segunda");
                        break;
                    case 2:
                        System.out.println("É Terça-Feira");
                        break;
                    case 3:
                        System.out.println("É Quarta-Feira");
                        break;
                    case 4:
                        System.out.println("É Quinta-Feira");
                        break;
                    case 5:
                        System.out.println("É Sexta-Feira");
                        break;
                    case 6:
                        System.out.println("É Sábado");
                        break;
                    case 7:
                        System.out.println("É Domingo");
                        break;
                    
                }
                
            }else
                break;
            

        }
        input.close();
    }
}
