package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Reservas;

public class ReservasProcess {
	
	PreparedStatement ps;
	Connection con;
	ResultSet rs;
	
	public ReservasProcess() {
		this.con = ConnectionDB.getConnection();
	}
	
	public boolean create(Reservas reserva) {
		
		String query = "INSERT INTO reservas VALUES (DEFAULT, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(query);
			
			ps.setString(1, reserva.getNomeLivro());
			ps.setString(2, reserva.getNomePessoa());
			ps.setString(3, reserva.getDataDevolucao());
			
			if(ps.executeUpdate() > 0) {
				rs = ps.getGeneratedKeys();
				rs.next();
				int id = rs.getInt(1);
				reserva.setId(id);
				ps.close();
				return true;
			}
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public JSONArray read() {
		
		JSONArray arr = new JSONArray();
		
		String query = "SELECT * FROM reservas";
		
		try {
			ps = con.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("nome_pessoa", rs.getString("nome_pessoa"));
				obj.put("nome_livro", rs.getString("nome_livro"));
				obj.put("data_devolucao", rs.getString("data_devolucao"));
				obj.put("id", rs.getInt("id"));
				
				arr.put(obj);
			}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arr;
		
	}
	
}