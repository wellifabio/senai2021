package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Receita;

public class ReceitaDAO {
	private Connection con;
	private PreparedStatement ps;
	private Receita r;
	private List<Receita> lr;

	public boolean create(Receita r) throws SQLException {
		String sql = "INSERT INTO Receitas VALUES (default,?,?,?,?);";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, r.getNome());
		ps.setString(2, r.getIngredientes());
		ps.setString(3, r.getModoDeFazer());
		ps.setBlob(4, r.getFoto());
		if (ps.executeUpdate() > 0) {
			con.close();
			return true;
		} else {
			return false;
		}
	}

	public Receita read(int id) throws SQLException {
		String sql = "SELECT * FROM Receitas WHERE receita_id = ?;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			r = new Receita();
			r.setId(rs.getInt("receita_id"));
			r.setNome(rs.getString("nome"));
			r.setIngredientes(rs.getString("ingredientes"));
			r.setModoDeFazer(rs.getString("modo_de_fazer"));
			r.setFoto(rs.getBlob("foto").getBinaryStream());
		}
		con.close();
		return r;
	}

	public boolean update(Receita r) throws SQLException {
		String sql = "UPDATE Receitas SET nome = ?, ingredientes = ?, modo_de_fazer = ?, foto = ? where receita_id = ?;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, r.getNome());
		ps.setString(2, r.getIngredientes());
		ps.setString(3, r.getModoDeFazer());
		ps.setBlob(4, r.getFoto());
		ps.setInt(5, r.getId());
		if (ps.executeUpdate() > 0) {
			con.close();
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(int id) throws SQLException {
		String sql = "DELETE FROM Receitas WHERE receita_id = ?;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		if (ps.executeUpdate() > 0) {
			con.close();
			return true;
		} else {
			return false;
		}
	}

	public List<Receita> list() throws SQLException {
		String sql = "SELECT * FROM Receitas;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		lr = new ArrayList<Receita>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			r = new Receita();
			r.setId(rs.getInt("receita_id"));
			r.setNome(rs.getString("nome"));
			r.setIngredientes(rs.getString("ingredientes"));
			r.setModoDeFazer(rs.getString("modo_de_fazer"));
			lr.add(r);
		}
		con.close();
		return lr;
	}

}
