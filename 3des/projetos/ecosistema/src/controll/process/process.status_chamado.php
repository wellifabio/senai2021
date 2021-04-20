<?php

	require("../../domain/connection.php");
	require("../../domain/status_chamado.php");

	class Status_chamadoProcess {
		var $sd;
		var $s;

		function doGet($arr){
			if(isset($arr["id"])) {
				$sd = new Status_chamadoDAO();
				$result = $sd->read($arr["id"]);
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
						isset($arr["status_chamado"])
					){
						$s = new Status_chamado();
						$s->setStatus_cha($arr["status_chamado"]);
		
						$sd = new Status_chamadoDAO();
						$result = $sd->create($s);
					}else {
						$result["status"] = "C003";
					}
				}else if($arr["verbo"] == "DELETE") {
					if(isset($arr["id"])) {
						if($arr["id"] > 0) {
							$sd = new Status_chamadoDAO();
							$result = $sd->delete($arr["id"]);
						}else {
							$result["status"] = "C004";
						}				
					}else {
						$result["status"] = "C003";
					}
				}else if($arr["verbo"] == "PUT") {
					if(
						isset($arr["id"]) &&
						isset($arr["status_chamado"])
					){
						$s = new Status_chamado();
						$s->setId($arr["id"]);
						$s->setStatus_cha($arr["status_chamado"]);
		
						$sd = new Status_chamadoDAO();
						$result = $sd->update($s);
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
			$sd = new Status_chamadoDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doDelete($arr){
			if(isset($arr["id"])) {
				if($arr["id"] > 0) {
					$sd = new Status_chamadoDAO();
					$result = $sd->delete($arr["id"]);
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