package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Servico;

public class ServicoDAO {
	
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection con;
	private Servico servico;
	private String query = null;
	
	public ArrayList<Servico> realAll() throws SQLException{
		ArrayList<Servico> servicos = new ArrayList<>();
		query = "select * from servicos";
		
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
			servico = new Servico();
			servico.setId(rs.getInt("id"));
			servico.setPrestador(rs.getString("prestador"));
			servico.setHorasTrabalhadas(rs.getFloat("horas_trabalhadas"));
			servico.setValorHora(rs.getFloat("valor_hora"));
			servicos.add(servico);
		}
		con.close();
		return servicos;
	}
	
	public boolean create(Servico servico) throws SQLException{
		query = "insert into servicos value (?,?,?,?)";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.setInt(1, servico.getId());
		ps.setString(2, servico.getPrestador());
		ps.setDouble(3, servico.getValorHora());
		ps.setDouble(4, servico.getHorasTrabalhadas());
		
		if(ps.executeUpdate() > 0) {
			con.close();
			return true;
		}else {
			con.close();
			return false;
		}		
	}

	public boolean update(Servico servico) throws SQLException{
		query = "update servicos set prestador = ?, valor_hora = ?, horas_trabalhadas = ? where id = ?";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.setInt(4, servico.getId());
		ps.setString(1, servico.getPrestador());
		ps.setDouble(2, servico.getValorHora());
		ps.setDouble(3, servico.getHorasTrabalhadas());
		
		if(ps.executeUpdate() > 0) {
			con.close();
			return true;
		}else {
			con.close();
			return false;
		}		
	}
	
	public boolean delete(int id) throws SQLException {
		query = "delete from servicos where id = ?";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.setInt(1, id);
		if(ps.executeUpdate() > 0) {
			con.close();
			return true;
		}else {
			con.close();
			return false;
		}
	}
}
