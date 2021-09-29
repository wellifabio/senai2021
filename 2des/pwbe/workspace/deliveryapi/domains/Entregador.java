package domains;

import org.json.JSONException;
import org.json.JSONObject;

public class Entregador {
	
	//Atributos	
	private int id_entregador;
	private String nomeCompleto;
	private String veiculo;
	
	//Construtores	
	public Entregador() {
	}
	
	public Entregador(int id_entregador, String nomeCompleto, String veiculo) {
		this.id_entregador = id_entregador;
		this.nomeCompleto = nomeCompleto;
		this.veiculo = veiculo;
	}
	
	public Entregador(String id_entregador, String nomeCompleto, String veiculo) {
		this.id_entregador = Integer.valueOf(id_entregador);
		this.nomeCompleto = nomeCompleto;
		this.veiculo = veiculo;
	}
	
	//Getters && Setters
	public int getId_entregador() {
		return id_entregador;
	}
	public void setId_entregador(int id_entregador) {
		this.id_entregador = id_entregador;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	//Saídas
	@Override
	public String toString() {
		return id_entregador + "\t" + nomeCompleto + "\t" + veiculo + "\n";
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put("id_entregador", this.id_entregador);
			json.put("nomeCompleto", this.nomeCompleto);
			json.put("veiculo", this.veiculo);
		} catch (JSONException e) {
			System.out.println("Erro na conversÃ£o JSON " + e);
		}		
		return json;
	}
		
}
