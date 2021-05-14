import java.io.IOException;
import java.util.Scanner;
import java.util.Locale;
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Notas2 {
 
  public static void main(String args[]) {

    //Declaração de variáveis
    Locale.setDefault(Locale.US);
    Scanner entrada = new Scanner(System.in);
    float valor = 0;
    int cem = 0, cinquenta = 0, vinte = 0, dez = 0, cinco = 0, dois = 0;
    int um = 0, mCinquenta = 0, mVinteECinco = 0, mDez = 0, mCinco = 0;
    int mUm = 0;
    
    //Entrada
    valor = entrada.nextFloat();
	
    //Processamento
    do{
      if(valor >= (float)100){
        cem++;
        valor = valor - (float)100;
      } else if(valor >= (float)50){
        cinquenta++;
        valor = valor - (float)50;
      } else if(valor >= (float)20){
        vinte++;
        valor = valor - (float)20;
      } else if(valor >= (float)10){
        dez++;
        valor = valor - (float)10;
      } else if(valor >= (float)5){
        cinco++;
        valor = valor - (float)5;
      } else if(valor >= (float)2){
        dois++;
        valor = valor - (float)2;
      } else if(valor >= (float)1){
        um++;
        valor = valor - (float)1;
      } else if(valor >= (float)0.5){
        mCinquenta++;
        valor = valor - (float)0.5;
      } else if(valor >= (float)0.25){
        mVinteECinco++;
        valor = valor - (float)0.25;
      } else if(valor >= (float)0.1){
        mDez++;
        valor = valor - (float)0.1;
      } else if(valor >= (float)0.05){
        mCinco++;
        valor = valor - (float)0.05;
      }else{
        mUm++;
        valor = valor - (float)0.01;
      }
    }while(valor > (float)0.00);

    //Saídas
    System.out.println("NOTAS:");
    System.out.println(cem+" nota(s) de R$ 100.00");
    System.out.println(cinquenta+" nota(s) de R$ 50.00");
    System.out.println(vinte+" nota(s) de R$ 20.00");
    System.out.println(dez+" nota(s) de R$ 10.00");
    System.out.println(cinco+" nota(s) de R$ 5.00");
    System.out.println(dois+" nota(s) de R$ 2.00");
    System.out.println("MOEDAS:");
    System.out.println(um+" moeda(s) de R$ 1.00");
    System.out.println(mCinquenta+" moeda(s) de R$ 0.50");
    System.out.println(mVinteECinco+" moeda(s) de R$ 0.25");
    System.out.println(mDez+" moeda(s) de R$ 0.10");
    System.out.println(mCinco+" moeda(s) de R$ 0.05");
    System.out.println(mUm+" moeda(s) de R$ 0.01");
  }
 
}