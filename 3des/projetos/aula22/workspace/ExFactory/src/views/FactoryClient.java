package views;

import models.OSFactory;
import models.SistemaOperacional;

///* 
//* Exemplo do Design Pattern de Criação Factory
//* https://www.youtube.com/watch?v=pt1IbV1aSZ4
//* */

public class FactoryClient {

	//Classe que garante a criação do objeto de acordo com o parâmetro escolhido
	private static OSFactory osf = new OSFactory(); 	
	
	public static void main(String[] args) {
		
		SistemaOperacional os = osf.getInstance("Outro");
		System.out.println(os.getTipo());

	}

}
