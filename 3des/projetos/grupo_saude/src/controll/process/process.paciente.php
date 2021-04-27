<?php

	require("../../domain/connection.php");
	require("../../domain/paciente.php");

	class PacienteProcess {
		var $pd;

		
		function doGet($arr){
			$pd = new PacienteDAO();
			$sucess = array();
			if(isset($arr["cpf"])){
				if ($arr["cpf"] == "0"){
					$sucess = $pd->readAll();
				}else { 
					$sucess = $pd->read($arr["cpf"]);
				}
				http_response_code(200);
	
			} else {
				$sucess["erro"] = "O método get da da requisição de pacientes necessita do campo 'cpf'";
				http_response_code(400);
			}
			echo json_encode($sucess);
		}


		function doPost($arr){
			$pd = new PacienteDAO();
			$sucess = array();
			if(isset($arr["acao"])){
				switch($arr["acao"]){
					case 'create':
						$paciente = new Paciente();
						$paciente->setCpf($arr["cpf"]);
						$paciente->setNome($arr["nome"]);
						$paciente->setCidade($arr["cidade"]);
						$paciente->setTipo_sanguineo($arr["tipo_sanguineo"]);
						$paciente->setData_de_nascimento($arr["data_de_nascimento"]);
						$paciente->setTelefone($arr["telefone"]);
						$paciente->setE_mail($arr["e_mail"]);
						$sucess = $pd->create($paciente);
						http_response_code(200);		
						break;
					case 'update':
						$paciente = new Paciente();
						$paciente->setCpf($arr["cpf"]);
						$paciente->setNome($arr["nome"]);
						$paciente->setCidade($arr["cidade"]);
						$paciente->setTipo_sanguineo($arr["tipo_sanguineo"]);
						$paciente->setData_de_nascimento($arr["data_de_nascimento"]);
						$paciente->setTelefone($arr["telefone"]);
						$paciente->setE_mail($arr["e_mail"]);
						$sucess = $pd->update($paciente);
						break;
					case 'delete':
						$sucess = $pd->delete($arr["cpf"]);
						http_response_code(200);
						break;
					default:
						$sucess["erro"] = "O campo acao deve ser preencido com 'create, update ou delete'";
						http_response_code(400);
						break;
				}
			} else{
				$sucess["erro"] = "Para processar uma requisição POST de paciente envie a 'acao=create,update,delete'";
				http_response_code(400);
			}
			echo json_encode($sucess);
		}

	}