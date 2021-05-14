/*
Exercício de Lógica
Programa que lê a partir do teclado um valor de ponto
flutuante com duas casas decimais (monetário) e calcula
o menor número de notas (cédulas) e ou moedas no qual o
valor pode ser decomposto. As notas são 100, 50, 20, 10, 5, 2
e as moedas são 1, 0.5, 0.25, 0.1, 0.05. A seguir
mostre o valor lido e a relação de notas necessárias.
*/

import java.util.Scanner;

class Notas1 {  
  public static void main(String args[]) {
    //Declaração de variáveis
    Scanner entrada = new Scanner(System.in);
    float valor = 0;
    int cem = 0, cinquenta = 0, vinte = 0, dez = 0, cinco = 0, dois = 0;
    int um = 0, mCinquenta = 0, mVinteECinco = 0, mDez = 0, mCinco = 0;
    int mUm = 0;
    //Entrada
    System.out.println("Digite um valor em dinheiro, maior do que zero:");
    valor = entrada.nextFloat();
	
    //Processamento com condicionais e laços
	//Devido a utilização de ponto flutuante, este algoritmo apresenta erro de estouro de memória
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
    System.out.println("Será necessário:");
    if(cem > 0){
      System.out.println(cem+" notas de Cem;");
    }
    if(cinquenta > 0){
      System.out.println(cinquenta+" notas de Cinquenta;");
    }
    if(vinte > 0){
      System.out.println(vinte+" notas de Vinte;");
    }
    if(dez > 0){
      System.out.println(dez+" notas de Dez;");
    }
    if(cinco > 0){
      System.out.println(cinco+" notas de Cinco;");
    }
    if(dois > 0){
      System.out.println(dois+" notas de Dois;");
    }
    if(um > 0){
      System.out.println(um+" moedas de Um;");
    }
    if(mCinquenta > 0){
      System.out.println(mCinquenta+" moedas de Cinquenta centavos;");
    }
    if(mVinteECinco > 0){
      System.out.println(mVinteECinco+" moedas de Vinte e cinco centavos;");
    }
    if(mDez > 0){
      System.out.println(mDez+" moedas de Dez centavos;");
    }
    if(mCinco > 0){
      System.out.println(mCinco+" moedas de Cinco centavos;");
    }
    if(mUm > 0){
      System.out.println(mUm+" moedas de Um centavo;");
    }
  } 
}