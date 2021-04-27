<?php

	require("../../domain/connection.php");
	require("../../domain/medico.php");

	class MedicoProcess {

		var $md;

		function doGet($arr){
			$md = new MedicoDAO();
			$sucess = array();

			if(isset($arr["crm"])){
				if ($arr["crm"] == "0") {
					$sucess = $md->readAll();
				} else {
					$sucess = $md->read($arr["crm"]);
				}
				http_response_code(200);	
			} else {
				$sucess["erro"] = "Requisições GET necessitam do campo crm";
			}
			echo json_encode($sucess);
		}

		function doPost($arr){
			$sucess = array();
			if(isset($arr["acao"])){
				switch($arr["acao"]){
					case "create";
						$md = new MedicoDAO();
						$medic = new Medico();
						$medic->setCrm($arr["crm"]);
						$medic->setNome($arr["nome"]);
						$medic->setCidade($arr["cidade"]);
						$medic->setPosto_atendimento($arr["posto_atendimento"]);
						$medic->setEspecialidade($arr["especialidade"]);
						$medic->setTelefone($arr["telefone"]);
						$medic->setE_mail($arr["e_mail"]);
						$sucess = $md->create($medic);
						http_response_code(200);
					break;
					case "update";
						$md = new MedicoDAO();
						$medic = new Medico();
						$medic->setCrm($arr["crm"]);
						$medic->setNome($arr["nome"]);
						$medic->setCidade($arr["cidade"]);
						$medic->setPosto_atendimento($arr["posto_atendimento"]);
						$medic->setEspecialidade($arr["especialidade"]);
						$medic->setTelefone($arr["telefone"]);
						$medic->setE_mail($arr["e_mail"]);
						$sucess = $md->update($medic);
						http_response_code(200);
					break;
					case "delete";
						$md = new MedicoDAO();
						$sucess = $md->delete($arr["crm"]);
						http_response_code(200);
					break;
					default;
						$sucess["erro"] = "O campo acao deve ser preenchido com 'create, update ou delete'";
						http_response_code(400);
					break;
				}
			}else{
				$sucess["erro"] = "Este servidor não possui suporte REST FUll, para processar sua requisição POST envie a acao='create, update ou delete'";
				http_response_code(400);
			}
			echo json_encode($sucess);
		}
	}