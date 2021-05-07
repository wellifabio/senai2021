import java.util.Scanner; 


public class Main{
	
	
	
	public static void main(String args[]){
		int n;
		Scanner ler = new Scanner(System.in);
		
		
		n = ler.nextInt();
		
		for(int i = 1; i <= 10;i++){
			System.out.println(i+" x "+n+" = "+i*n);
		}
		
		
		ler.close();
		
	}
}