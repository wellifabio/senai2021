
public class ListaExerc5_a {

    public  static void vetorMatrizes(int [][] matriz){ // Método vetorMatrizes
        for (int z = 0; z < matriz.length;z++){ //length esta contando quantas linha, 3 linhas
            for(int i = 0; i < matriz[z].length;i++){ //length esta contando quantas colunas dentro da linha, 10 colunas
                matriz[z][i] = i; // Atribuindo os elementos na matriz
                System.out.printf("%d",matriz[z][i]); // imprimindo os elementos nas posições definidas 
                
            }
            
            System.out.println(); // Apenas dando um espaço
        } 
        
    }
    public static void main(String[] args) throws Exception {
        int matriz[][] = new int[3][10]; //matriz 3  linhas com 10 colunas em cada linha
        
        
        vetorMatrizes(matriz);  // chamando o Método e colocando variável matriz como argumento do método
        
    }
    
}
