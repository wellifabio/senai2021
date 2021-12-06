package controll;

import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import dao.ServicoDAO;
import model.Servico;

public class ServicoProcess {
	public static ArrayList<Servico> servicos;
	public static ServicoDAO sd = new ServicoDAO();
	
	public static void carregar() throws SQLException{
		servicos = sd.realAll();
	}
	
	public static boolean create(String body) throws JSONException, SQLException {
		Servico serv = new Servico();
		JSONObject jo = new JSONObject(body);
		serv.setId(jo.getInt("id"));
		serv.setPrestador(jo.getString("prestador"));
		serv.setHorasTrabalhadas(jo.getDouble("horas_trabalhadas"));
		serv.setValorHora(jo.getDouble("valor_hora"));
		return sd.create(serv);
	}
	
	public static boolean apagar(String id) throws SQLException{
		int FID = Integer.parseInt(id);
		return sd.delete(FID);
	}
	
	public static boolean atualizar(String body) throws JSONException, SQLException {
		JSONObject jo = new JSONObject(body);
		Servico servico = new Servico();
		servico.setId(jo.getInt("id"));
		servico.setPrestador(jo.getString("prestador"));
		servico.setHorasTrabalhadas(jo.getDouble("horas_trabalhadas"));
		servico.setValorHora(jo.getDouble("valor_hora"));
		return sd.update(servico);
	}
}
