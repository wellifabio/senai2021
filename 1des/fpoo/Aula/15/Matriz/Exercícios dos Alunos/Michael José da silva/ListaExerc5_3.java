public class ListaExerc5_3 {
    public  static void vetorMatrizes(int [][] matriz){// Método vetorMatrizes

        System.out.println(matriz.length); // length esta contando quantas linha. 10 linhas
    }
    public static void main(String[] args) throws Exception {
        int matriz[][] = new int[10][10]; // Criando matriz com 10 linha e 10 coluna em cada linha
        
        
        vetorMatrizes(matriz);  // chamando o Método e colocando variável matriz como argumento do método

    }
}
