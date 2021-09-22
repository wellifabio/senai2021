package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cliente")
public class Cliente extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JSONArray arr = new JSONArray();
		
		BufferedReader br = new BufferedReader(new FileReader("d:/cad.csv"));
		
		String linha = "";
		//id;nome;endereco
		while((linha = br.readLine()) != null) {
			String[] data = linha.split(";");
			JSONObject cli = new JSONObject();
			
			cli.put("id", Integer.parseInt(data[0]));
			cli.put("nome", data[1]);
			cli.put("endereco", data[2]);
			
			arr.put(cli);
		}
		
		br.close();
		 
		PrintWriter pw = resp.getWriter();
		
		pw.write(arr.toString());
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("d:/cad.csv", true));
		
		String data = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		JSONObject cli = new JSONObject(data);
		
		int id = cli.getInt("id");
		String nome = cli.getString("nome");
		String endereco = cli.getString("endereco");
		
		bw.write(id + ";" + nome + ";" + endereco + "\r\n");
		
		bw.close();
		
		PrintWriter pw = resp.getWriter();
		
		pw.write(cli.toString());
		
	}
		
}