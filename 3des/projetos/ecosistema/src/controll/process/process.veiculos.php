<?php

	require("../../domain/connection.php");
	require("../../domain/veiculos.php");

	class VeiculosProcess {
		var $vd;
		var $v;

		function doGet($arr){
			if(isset($arr["id"])) {
				$vd = new VeiculosDAO();
				$result = $vd->read($arr["id"]);
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
						isset($arr["placa"]) &&
						isset($arr["modelo"]) &&
						isset($arr["marca"]) &&
						isset($arr["capacidade"]) 
					){
						$v = new Veiculos();
						$v->setCooperativas_id($arr["cooperativas_id"]);
						$v->setPlaca($arr["placa"]);
						$v->setModelo($arr["modelo"]);
						$v->setMarca($arr["marca"]);
						$v->setCapacidade_carga_kg($arr["capacidade"]);
			
						$vd = new VeiculosDAO();
						$result = $vd->create($v);				
					}else {
						$result["status"] = "C003";
					}
				}else if($arr["verbo"] == "DELETE") {
					if(isset($arr["id"])) {
						if($arr["id"] > 0) {
							$vd = new VeiculosDAO();
							$result = $vd->delete($arr["id"]);
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
						isset($arr["placa"]) &&
						isset($arr["modelo"]) &&
						isset($arr["marca"]) &&
						isset($arr["capacidade"]) 
					){
						$v = new Veiculos();
						$v->setId($arr["id"]);
						$v->setCooperativas_id($arr["cooperativas_id"]);
						$v->setPlaca($arr["placa"]);
						$v->setModelo($arr["modelo"]);
						$v->setMarca($arr["marca"]);
						$v->setCapacidade_carga_kg($arr["capacidade"]);
			
						$vd = new VeiculosDAO();
						$result = $vd->update($v);				
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
			$vd = new VeiculosDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doDelete($arr){
			if(isset($arr["id"])) {
				if($arr["id"] > 0) {
					$vd = new VeiculosDAO();
					$result = $vd->delete($arr["id"]);
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