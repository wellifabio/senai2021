<?php

	require("../../domain/connection.php");
	require("../../domain/cooperativas.php");

	class CooperativasProcess {
		var $cd;
		var $c;

		function doGet($arr){
			if(isset($arr["id"])) {
				$cd = new CooperativasDAO();
				$result = $cd->read($arr["id"]);
			}else {
				$result["status"] = "C003";
			}
			
			http_response_code(200);
			echo json_encode($result);
		}


		function doPost($arr){
			if(isset($arr["verbo"])) {
				if($arr["verbo"] == "POST") {
					if(isset($arr["nome"])) {
						$c = new Cooperativas();
						$c->setNome($arr["nome"]);
			
						$cd = new CooperativasDAO();
						$result = $cd->create($c);
					}else {
						$result["status"] = "C003";
					}
				}else if($arr["verbo"] == "DELETE") {
					if(isset($arr["id"])) {
						if($arr["id"] > 0) {
							$cd = new CooperativasDAO();
							$result = $cd->delete($arr["id"]);
						}else {
							$result["status"] = "C004";
						}				
					}else {
						$result["status"] = "C003";
					}
				}else if($arr["verbo"] == "PUT") {
					if(isset($arr["id"]) && isset($arr["nome"])) {
						$c = new Cooperativas();
						$c->setId($arr["id"]);
						$c->setNome($arr["nome"]);
			
						$cd = new CooperativasDAO();
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
			$cd = new CooperativasDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doDelete($arr){
			if(isset($arr["id"])) {
				if($arr["id"] > 0) {
					$cd = new CooperativasDAO();
					$result = $cd->delete($arr["id"]);
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