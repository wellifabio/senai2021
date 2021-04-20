<?php

	require("../../domain/connection.php");
	require("../../domain/rotas.php");

	class RotasProcess {
		var $rd;
		var $r;

		function doGet($arr){
			if(isset($arr["id"])) {
				$rd = new RotasDAO();
				$result = $rd->read($arr["id"]);
			}else {
				$result["status"] = "C003";
			}

			http_response_code(200);
			echo json_encode($result);
		}


		function doPost($arr){
			if(isset($arr["verbo"])) {
				if($arr["verbo"] == "POST") {
					if(
						isset($arr["veiculos_id"]) &&
						isset($arr["nome"]) &&
						isset($arr["dia_horario"]) 
					){
						$r = new Rotas();
						$r->setVeiculos_id($arr["veiculos_id"]);
						$r->setNome($arr["nome"]);
						$r->setDia_hora($arr["dia_horario"]);
			
						$rd = new RotasDAO();
						$result = $rd->create($r);				
					}else {
						$result["status"] = "C003";
					}
				}else if($arr["verbo"] == "DELETE") {
					if(isset($arr["id"])) {
						if($arr["id"] > 0) {
							$rd = new RotasDAO();
							$result = $rd->delete($arr["id"]);
						}else {
							$result["status"] = "C004";
						}				
					}else {
						$result["status"] = "C003";
					}
				}else if($arr["verbo"] == "PUT") {
					if(
						isset($arr["id"]) &&
						isset($arr["veiculos_id"]) &&
						isset($arr["nome"]) &&
						isset($arr["dia_horario"]) 
					){
						$r = new Rotas();
						$r->setId($arr["id"]);
						$r->setVeiculos_id($arr["veiculos_id"]);
						$r->setNome($arr["nome"]);
						$r->setDia_hora($arr["dia_horario"]);
			
						$rd = new RotasDAO();
						$result = $rd->update($r);				
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
			$rd = new RotasDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doDelete($arr){
			if(isset($arr["id"])) {
				if($arr["id"] > 0) {
					$rd = new RotasDAO();
					$result = $rd->delete($arr["id"]);
				}else {
					$result["status"] = "C004";
				}				
			}else {
				$result["status"] = "C003";
			}

			http_response_code(200);
			echo json_encode($result);
		}
	}