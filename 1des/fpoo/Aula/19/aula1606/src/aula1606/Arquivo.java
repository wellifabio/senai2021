package aula1606;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {

	String nome;
	String formato;
		
	Arquivo() {}
	
	Arquivo(String nome, String formato) {
		setNome(nome);
		setFormato(formato);
	}
			
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	
	private String fileName() {
		return this.nome + "." + this.formato;
	}
	
	//Metodo de criação de arquivo
	//Conteudo atraves de String
	public boolean criar(String conteudo) {
		
		try {
			
			FileWriter fw = new FileWriter(fileName(), true);
			BufferedWriter bw = new BufferedWriter(fw);
						
			bw.write(conteudo + "\r\n");
			
			bw.close();
			fw.close();
					
		} catch (IOException e) {
			return false;
		}
		
		return true;
		
	}

	//Metodo de criação de arquivo
	//Conteudo atraves de lista
	public boolean criar(ArrayList<String> data) {
		
		try {
			
			FileWriter fw = new FileWriter(fileName(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			//Percorre cada item da lista 
			for(String item : data) {
				//Escreve no arquivo o valor da lista
				bw.write(item + "\r\n");				
			}
			
			bw.close();
			fw.close();
					
		} catch (IOException e) {
			//Caso de erro retorna falso
			return false;
		}
		
		return true;
		
	}

	//Metodo de leitura de arquivo
	//Conteudo retorna como lista, onde cada linha do arquivo é um item da lista
	public ArrayList ler() {
		
		ArrayList<String> conteudo = new ArrayList<>();
		
		try {
			
			FileReader fr = new FileReader(fileName());
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			
			//Percorre o arquivo até o fim
			//Armazena cada linha lida na variavel line
			while( (line = br.readLine()) != null ) {
				conteudo.add(line);
			}
			
			br.close();
			fr.close();
			
		//Tratamento de erros
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		//IO Input Output
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conteudo;
		
	}

	//Metodo de leitura de arquivo
	//Recebe o nome atual e o novo nome
	public boolean atualizar(String antigo, String atual) {
		
		try {
			
			FileReader fr = new FileReader(fileName());
			BufferedReader br = new BufferedReader(fr);
			
			FileWriter fwtemp = new FileWriter("temp.txt", true);
			BufferedWriter bwtemp = new BufferedWriter(fwtemp);
			
			String line = "";
			
			int conta = 0;
						
			while( (line = br.readLine()) != null) {
				//Separa o nome completo a partir dos espaços, armazenando no vetor temp
				String[] temp = line.split(" ");
				
				//Verifica o primeiro nome comparando com o parametro antigo
				if(temp[0].toLowerCase().equals(antigo.toLowerCase())) {
					
					//Substitui o primeiro nome pelo atual para não perder o sobrenome
					String novo = line.replace(temp[0], atual);
					bwtemp.write(novo + "\r\n");
					//Outro modo de fazer
					/*temp[0] = atual;
					for(int i = 0; i < temp.length; i++) {
						bwtemp.write(temp[i] + " ");
					}
					bwtemp.write("\r\n");*/
					conta++;
				}else {
					bwtemp.write(line + "\r\n");
				}
			}
			
			if(conta == 0) System.out.println("Cliente não localizado");
			
			bwtemp.close();
			fwtemp.close();			
			
			br.close();
			fr.close();

			//Apaga o arquivo info com os dados antigos
			File f = new File(fileName());
			f.delete();

			//Renomeia o arquivo temp para info, atualizando os dados
			File ft = new File("temp.txt");
			ft.renameTo(f);
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
		
	}

}
