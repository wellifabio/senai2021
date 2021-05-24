public class ListaExerc4_1{

    // Função/ Método 
    static void mostra(){
        int vetorList [] = {2,4,5,6,8};
        String cabeCalho []= {"Índice","Valor"};
        System.out.printf("%8s %7s\n",cabeCalho[0],cabeCalho[1]);
        for (int z = 0 ;z < vetorList.length;z++){
            System.out.printf("%5d %8d\n",z,vetorList[z]);
        }
        
    }
    public static void main(String[] args) throws Exception {
        mostra(); // chamada função
    }
}
