public class ListaExrc5_c {
    public  static void vetorMatrizes(int [][] matriz){// Método vetorMatrizes
        int som = 0; // Variável auxiliar
        for (int z = 0; z < matriz.length;z++){ //length esta contando quantas linha, 6 linhas

            for(int i = 0; i < matriz[z].length;i++){ //length esta contando quantas colunas na linha, 6 colunas
                matriz[z][i] = som; // Atribuindo os elementos na matriz
                System.out.printf("%3d",matriz[z][i]); // imprimindo os elementos nas posições definidas
            }
            som += 1; // somando na Variável auxiliar
            System.out.println(); // Apenas dando um espaço
        } 
        
    }
    public static void main(String[] args) throws Exception {
        int matriz[][] = new int[6][6]; // Criando matriz com 6 linha e 6 coluna em cada linha
        
        
        vetorMatrizes(matriz); // chamando o Método e colocando variável matriz como argumento do método

    }
}
