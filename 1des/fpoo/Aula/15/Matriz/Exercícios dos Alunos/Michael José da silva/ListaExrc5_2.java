import java.util.Random;

public class ListaExrc5_2 {
    public  static void vetorMatrizes(int [][] matriz){// Método vetorMatrizes
        Random aleator = new Random();
        
        for (int z = 0; z < matriz.length;z++){  //length esta contando quantas linha, 3 linhas
            
            for(int i = 0; i < matriz[z].length;i++){ //length esta contando quantas colunas na linha, 2 colunas
                
                matriz[z][i] = aleator.nextInt(100)+1; // Atribuindo os elementos aleatorio na matriz
                System.out.printf("%5d",matriz[z][i]); // imprimindo os elementos nas posições definidas
            }
            System.out.println(); // Apenas dando um espaço
        } 
        
    }
    public static void main(String[] args) throws Exception {
        int matriz[][] = new int[3][2]; // Criando matriz com 3 linha e 2 coluna em cada linha
        
        
        vetorMatrizes(matriz); // chamando o Método  e colocando variável matriz como argumento do método
        
    }
}