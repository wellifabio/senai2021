package aula1606;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class arquivo2 {

	public static void main(String args[]) {
		
		Arquivo file = new Arquivo("info", "txt");
		
		/*ArrayList<String> data = new ArrayList<>();
		
		data.add("Fulano");
		data.add("Ciclano");
		data.add("Beltrano");
		
		file.criar(data);*/
		
		/*ArrayList<String> conteudo = file.ler();
		
		for(String item : conteudo) {
			System.out.println(item);
		}*/
		
		//file.atualizar("ciclano", "richard");
		
		//Escrita
		//FileWriter
		//BufferedWriter
		
		//file.excluir("Ronaldinho");
		
		/*try {

			//BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"));
			
			FileWriter file = new FileWriter("data.txt", true);
			BufferedWriter bw = new BufferedWriter(file);
			
			bw.write("Teste de escrita\r\n");
			
			bw.close();
			file.close();
			
		} catch (IOException e) {
			
			System.out.println("Falha ao abrir arquivo para escrita");
			
		}*/
		
		//file.excluirList("Ciclano de Oliveira");
		
		//Leitura
		//FileReader
		//BufferedReader
		
		/*try {
			
			FileReader fr = new FileReader("data.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			br.close();
			fr.close();
			
		}catch(IOException e) {
			System.out.println("Falha ao abrir arquivo");
		}*/

	}
	
}
