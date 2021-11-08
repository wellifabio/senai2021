package spring.delivery.routes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.delivery.controllers.ClienteProcess;
import spring.delivery.domains.Cliente;

@RestController
public class ClienteREST {

	private int indice = 0;

	//Método apenas para testar o status do server
	@GetMapping(path = "status")
	public String status() {
		return "{\"status\":\"Server Online at: localhost:8080\"}";
	}

	//CRUD - CREATE
	@PostMapping(path = "/clientes")
	public ResponseEntity<String> doPost(@RequestBody String body)
			throws SQLException, JSONException {
		int idCliente = ClienteProcess.create(body);
		if(idCliente > 0) {
			return new ResponseEntity<String>("{\"id_cliente\":"+idCliente+"}", HttpStatus.CREATED);	
		}else {
			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
		}		
	}

	//CRUD - READ
	@GetMapping(path = "/clientes")
	public ResponseEntity<String> doGet(@RequestParam Map<String, String> customQuery) throws JSONException, SQLException {
		ClienteProcess.carregarTodos();
		if (customQuery.get("id_cliente") != null) {
			if (ClienteProcess.clientes.contains(new Cliente(customQuery.get("id_cliente")))) {
				indice = ClienteProcess.clientes.indexOf(new Cliente(customQuery.get("id_cliente")));
				return new ResponseEntity(ClienteProcess.clientes.get(indice), HttpStatus.FOUND);
			} else {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity(ClienteProcess.clientes, HttpStatus.FOUND);
		}
	}

	//CRUD - UPDATE
	@PutMapping(path = "/clientes")
	public ResponseEntity<String> doPut(@RequestBody String body) throws SQLException{
		if (body != null) {// Se o corpo da requisição não for nulo
				if (ClienteProcess.update(body)) {// Se os dados foram registrados no banco
					// Responde com status http 410 alterado.
					return new ResponseEntity<String>(HttpStatus.OK);
				} else {
					return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
				}
		} else {//Se o corpo não foi devidamente preenchido
			//Escreve uma mensagem de como deve ser o corpo JSON da requisição
			String msg = "{\"id_cliente\":\"1\",\"cpf\":null,\"nome_completo\":\"Algum nome\",\"endereco\":\"cep,numero,complemento\",\"telefone\":\"numero\"}";
			//Responde com requisição não aceita erro http 406
			return new ResponseEntity<String>(msg,HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	//CRUD - DELETE
	@DeleteMapping(path = "/clientes")
	public ResponseEntity<String> doDelete(@RequestParam Map<String, String> customQuery) throws SQLException, JSONException{
		ClienteProcess.carregarTodos();
		if (customQuery.get("id_cliente") != null) {
			if (ClienteProcess.clientes.contains(new Cliente(customQuery.get("id_cliente")))) {
				if (ClienteProcess.delete(customQuery.get("id_cliente"))) {
					return new ResponseEntity<String>(HttpStatus.OK);
				}else {
					return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
				}
			} else {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<String>("{\"erro\":\"Informe id_cliente\"}", HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
