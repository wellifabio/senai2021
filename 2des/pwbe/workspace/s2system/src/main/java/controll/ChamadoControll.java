package controll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.ChamadoModel;

public class ChamadoControll {

	public String cadastrar(ChamadoModel cm) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("c:/dbs/base.csv", true));		
			bw.write(cm.toCsv());
			bw.close();
			return cm.toCsv();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String listar() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("c:/dbs/base.csv"));
			String linha = "";
			String retorno = "";
			while( (linha = br.readLine()) != null ) {
				retorno += linha +"\r\n";
			}
			br.close();
			return retorno;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public boolean excluir(String id) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("c:/dbs/base.csv"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("c:/dbs/temp.csv", false));
			String linha = "";
			while( (linha = br.readLine()) != null ) {
				String[] colunas = linha.split(";");
				if(!colunas[0].equals(id)) {
					bw.write(linha+"\r\n");
				}
			}
			br.close();
			bw.close();
			File temp = new File("d:/temp.csv");//Abre arquivo para renomear
			File base = new File("d:/base.csv");//Abre para excluir
			base.delete(); //Excluir o arquivo antigo
			temp.renameTo(new File("d:/base.csv")); //Renomear o novo
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean alterar(ChamadoModel c) {
		try {
			boolean encontrado = false;
			BufferedReader br = new BufferedReader(new FileReader("d:/base.csv"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("d:/temp.csv", false));
			String linha = "";
			while( (linha = br.readLine()) != null ) {
				String[] colunas = linha.split(";");
				if(colunas[0].equals(""+c.getId())) {
					bw.write(c.toCsv());
					encontrado = true;
				}else {
					bw.write(linha+"\r\n");
				}
			}
			br.close();
			bw.close();
			File temp = new File("d:/temp.csv");//Abre arquivo para renomear
			File base = new File("d:/base.csv");//Abre para excluir
			base.delete(); //Excluir o arquivo antigo
			temp.renameTo(new File("d:/base.csv")); //Renomear o novo
			return encontrado;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
