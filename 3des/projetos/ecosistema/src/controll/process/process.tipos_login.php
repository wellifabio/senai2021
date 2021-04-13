<?php

	require("../../domain/connection.php");
	require("../../domain/tipos_login.php");

	class Tipos_loginProcess {
		var $td;
		var $t;

		function doGet($arr){
			if(isset($arr["id"])) {
				$td = new Tipos_loginDAO();
				$result = $td->read($arr["id"]);
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
						isset($arr["tipo"])
					){
						$t = new Tipos_login();
						$t->setTipo($arr["tipo"]);
		
						$td = new Tipos_loginDAO();
						$result = $td->create($t);
					}
				}else if($arr["verbo"] == "DELETE") {
					if(isset($arr["id"])) {
						if($arr["id"] > 0) {
							$td = new Tipos_loginDAO();
							$result = $td->delete($arr["id"]);
						}else {
							$result["status"] = "C004";
						}				
					}else {
						$result["status"] = "C003";
					}
				}else if($arr["verbo"] == "PUT") {
					if(
						isset($arr["id"]) &&
						isset($arr["tipo"])
					){
						$t = new Tipos_login();
						$t->setId($arr["id"]);
						$t->setTipo($arr["tipo"]);
		
						$td = new Tipos_loginDAO();
						$result = $td->update($t);
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
			$td = new Tipos_loginDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doDelete($arr){
			if(isset($arr["id"])) {
				if($arr["id"] > 0) {
					$td = new Tipos_loginDAO();
					$result = $td->delete($arr["id"]);
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