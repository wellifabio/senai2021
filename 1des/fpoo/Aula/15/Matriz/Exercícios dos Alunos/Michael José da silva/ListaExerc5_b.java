public class ListaExerc5_b {
    public  static void vetorMatrizes(int [][] matriz){ // método vetorMAtrizes
        int a = -1, b = 0; //variáveis auxiliares
    
        for (int z = 0; z < matriz.length;z++){ //length esta contando quantas linha, 9 linhas

            for(int i = 0; i < matriz[z].length;i++){ //length esta contando quantas colunas dentro da linha, 6 colunas

                matriz[z][i] = a; // Atribuindo os elementos na matriz
                System.out.printf("%3d",matriz[z][i]); // imprimindo os elementos nas posições definidas
                
            }
            // Convertendo para 0 e -1 dps de completar o 2 for
            if ( a == -1){ 
                a = b;
            }else if (a == 0){
                a = -1;
            }
            System.out.println(); // Apenas dando um espaço
        } 
        
    }
    public static void main(String[] args) throws Exception {
        int matriz[][] = new int[9][6]; // Criando matriz com 9 linhas e 6 colunas em cada linha
        
        
        vetorMatrizes(matriz); // chamando o Método e colocando variável matriz como argumento do método
        
    }
}
