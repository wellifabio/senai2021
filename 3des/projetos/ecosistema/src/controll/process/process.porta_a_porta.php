<?php

	require("../../domain/connection.php");
	require("../../domain/porta_a_porta.php");

	class Porta_a_portaProcess {
		var $pd;
		var $p;

		function doGet($arr){
			if(isset($arr["id"])) {
				$pd = new Porta_a_portaDAO();
				$result = $pd->read($arr["id"]);
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
						isset($arr["descricao"]) &&
						isset($arr["lat"]) &&
						isset($arr["longi"])
					){
						$p = new Porta_a_porta();
						$p->setCooperativas_id($arr["cooperativas_id"]);
						$p->setDescricao($arr["descricao"]);
						$p->setLat($arr["lat"]);
						$p->setLongi($arr["longi"]);
			
						$pd = new Porta_a_portaDAO();
						$result = $pd->create($p);				
					}else {
						$result["status"] = "C003";
					}
				}else if($arr["verbo"] == "DELETE") {
					if(isset($arr["id"])) {
						if($arr["id"] > 0) {
							$pd = new Porta_a_portaDAO();
							$result = $pd->delete($arr["id"]);
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
						isset($arr["descricao"]) &&
						isset($arr["lat"]) &&
						isset($arr["longi"])
					){
						$p = new Porta_a_porta();
						$p->setId($arr["id"]);
						$p->setCooperativas_id($arr["cooperativas_id"]);
						$p->setDescricao($arr["descricao"]);
						$p->setLat($arr["lat"]);
						$p->setLongi($arr["longi"]);
			
						$pd = new Porta_a_portaDAO();
						$result = $pd->update($p);				
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
			$pd = new Porta_a_portaDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doDelete($arr){
			if(isset($arr["id"])) {
				if($arr["id"] > 0) {
					$pd = new Porta_a_portaDAO();
					$result = $pd->delete($arr["id"]);
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