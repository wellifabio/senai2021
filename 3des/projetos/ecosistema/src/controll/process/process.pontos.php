<?php

	require("../../domain/connection.php");
	require("../../domain/pontos.php");

	class PontosProcess {
		var $pd;
		var $p;

		function doGet($arr){
			if(isset($arr["id"])) {
				$pd = new PontosDAO();
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
						isset($arr["rotas_id"]) &&
						isset($arr["lat"]) &&
						isset($arr["longi"])
					){
						$p = new Pontos();
						$p->setRotas_id($arr["rotas_id"]);
						$p->setLat($arr["lat"]);
						$p->setLongi($arr["longi"]);
			
						$pd = new PontosDAO();
						$result = $pd->create($p);				
					}else {
						$result["status"] = "C003";
					}
				}else if($arr["verbo"] == "DELETE") {
					if(isset($arr["id"])) {
						if($arr["id"] > 0) {
							$pd = new PontosDAO();
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
						isset($arr["rotas_id"]) &&
						isset($arr["lat"]) &&
						isset($arr["longi"])
					){
						$p = new Pontos();
						$p->setId($arr["id"]);
						$p->setRotas_id($arr["rotas_id"]);
						$p->setLat($arr["lat"]);
						$p->setLongi($arr["longi"]);
			
						$pd = new PontosDAO();
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
			$pd = new PontosDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doDelete($arr){
			if(isset($arr["id"])) {
				if($arr["id"] > 0) {
					$pd = new PontosDAO();
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