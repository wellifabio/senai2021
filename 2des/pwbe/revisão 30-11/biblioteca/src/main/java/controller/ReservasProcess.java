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
	
	public JSONArray read(String nomePessoa, String nomeLivro) {		
		JSONArray arr = new JSONArray();
		
		String query = "SELECT * FROM reservas";
		
		if(nomePessoa != null && nomeLivro != null) {
			query += " WHERE nome_livro = ? AND nome_pessoa = ?";
		}else if(nomePessoa != null || nomeLivro != null) {
			String part = (nomePessoa != null) ? "nome_pessoa" : "nome_livro";
			query += " WHERE " + part + " = ?";
		}
		
		try {
			ps = con.prepareStatement(query);
			
			if(nomePessoa != null && nomeLivro != null) {
				ps.setString(1, nomeLivro);
				ps.setString(2, nomePessoa);
			}else if(nomePessoa != null || nomeLivro != null) {
				//SELECT * FROM reservas WHERE nome_livro = ?
				String busca = (nomePessoa != null) ? nomePessoa : nomeLivro;
				ps.setString(1, busca);
			}
			
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
	
	public boolean update(Reservas reserva) {
		
		String query = "UPDATE reservas SET nome_pessoa = ?, nome_livro = ?, " +
					   "data_devolucao = ? WHERE id = ?";
		
		try {
			ps = con.prepareStatement(query);
			
			ps.setString(1, reserva.getNomePessoa());
			ps.setString(2, reserva.getNomeLivro());
			ps.setString(3, reserva.getDataDevolucao());
			ps.setInt(4, reserva.getId());
			
			if(ps.executeUpdate() > 0) {
				ps.close();
				return true;
			}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean delete(int id) {
		
		String query = "DELETE FROM reservas WHERE id = ?";
		
		try {
			ps = con.prepareStatement(query);
		
			ps.setInt(1, id);
			
			if(ps.executeUpdate() > 0) {
				ps.close();
				return true;
			}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
}