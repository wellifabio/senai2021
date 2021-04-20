<?php

	require("../../domain/connection.php");
	require("../../domain/ecopontos.php");

	class EcopontosProcess {
		var $ed;
		var $e;

		function doGet($arr){
			if(isset($arr["id"])) {
				$ed = new EcopontosDAO();
				$result = $ed->read($arr["id"]);
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
						isset($arr["cooperativas_id"]) &&
						isset($arr["nome"]) &&
						isset($arr["descricao"]) &&
						isset($arr["lat"]) &&
						isset($arr["longi"]) 
					){
						$e = new Ecopontos();
						$e->setCooperativas_id($arr["cooperativas_id"]);
						$e->setNome($arr["nome"]);
						$e->setDescricao($arr["descricao"]);
						$e->setLat($arr["lat"]);
						$e->setLongi($arr["longi"]);
		
						$ed = new EcopontosDAO();
						$result = $ed->create($e);
					}
				}else if($arr["verbo"] == "DELETE") {
					if(isset($arr["id"])) {
						if($arr["id"] > 0) {
							$ed = new EcopontosDAO();
							$result = $ed->delete($arr["id"]);
						}else {
							$result["status"] = "C004";
						}
					}else {
						$result["status"] = "C003";
					}
				}else if($arr["verbo"] == "PUT") {
					if(
						isset($arr["id"]) &&
						isset($arr["cooperativas_id"]) &&
						isset($arr["nome"]) &&
						isset($arr["descricao"]) &&
						isset($arr["lat"]) &&
						isset($arr["longi"]) 
					){
						$e = new Ecopontos();
						$e->setId($arr["id"]);
						$e->setCooperativas_id($arr["cooperativas_id"]);
						$e->setNome($arr["nome"]);
						$e->setDescricao($arr["descricao"]);
						$e->setLat($arr["lat"]);
						$e->setLongi($arr["longi"]);
		
						$ed = new EcopontosDAO();
						$result = $ed->update($e);
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
			$ed = new EcopontosDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doDelete($arr){
			if(isset($arr["id"])) {
				if($arr["id"] > 0) {
					$ed = new EcopontosDAO();
					$result = $ed->delete($arr["id"]);
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