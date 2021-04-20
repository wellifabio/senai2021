<?php

	require("../../domain/connection.php");
	require("../../domain/chamados_autonomos.php");

	class Chamados_autonomosProcess {
		var $cd;
		var $c;

		function doGet($arr){
			if(isset($arr["id"])) {
				$cd = new Chamados_autonomosDAO();
				$result = $cd->read($arr["id"]);
			}else {
				$result["status"] = "C003";
			}
			
			http_response_code(200);
			echo json_encode($result);
		}


		function doPost($arr){
			$cd = new Chamados_autonomosDAO();

			if(isset($arr["verbo"])) {
				if($arr["verbo"] == "POST") {
					if(
						isset($arr["autonomo_id"]) &&
						isset($arr["solicitante_id"]) &&
						isset($arr["status"]) &&
						isset($arr["lat"]) &&
						isset($arr["longi"]) &&
						isset($arr["dia_hora"]) 
					){
						$c = new Chamados_autonomos();
						$c->setUsuario_autonomo_id($arr["autonomo_id"]);
						$c->setUsuario_solicitatnte_id($arr["solicitante_id"]);
						$c->setStatus_cha($arr["status"]);
						$c->setLat($arr["lat"]);
						$c->setLongi($arr["longi"]);
						$c->setDia_horario($arr["dia_hora"]);
		
						$result = $cd->create($c);
					}else {
						$result["status"] = "C003";
					}
				}else if($arr["verbo"] == "DELETE") {
					if(isset($arr["id"])) {
						if($arr["id"] > 0) {
							$result = $cd->delete($arr["id"]);
						}else {
							$result["status"] = "C004";
						}	
					}else {
						$result["status"] = "C003";
					}
				}else if($arr["verbo"] == "PUT") {
					if(
						isset($arr["id"]) &&
						isset($arr["autonomo_id"]) &&
						isset($arr["solicitante_id"]) &&
						isset($arr["status"]) &&
						isset($arr["lat"]) &&
						isset($arr["longi"]) &&
						isset($arr["dia_hora"]) 
					){
						$c = new Chamados_autonomos();
						$c->setId($arr["id"]);
						$c->setUsuario_autonomo_id($arr["autonomo_id"]);
						$c->setUsuario_solicitatnte_id($arr["solicitante_id"]);
						$c->setStatus_cha($arr["status"]);
						$c->setLat($arr["lat"]);
						$c->setLongi($arr["longi"]);
						$c->setDia_horario($arr["dia_hora"]);
		
						$result = $cd->update($c);
					}else {
						$result["status"] = "C003";
					}
				}else {
					$result["status"] = "C005";
				}
			}else {
				$result["status"] = "C006";
			}
			
			http_response_code(200);
			echo json_encode($result);
		}


		function doPut($arr){
			$cd = new Chamados_autonomosDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doDelete($arr){
			$cd = new Chamados_autonomosDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}
	}