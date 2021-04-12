<?php

	require("../../domain/connection.php");
	require("../../domain/materiais.php");

	class MateriaisProcess {
		var $md;
		var $m;

		function doGet($arr){
			if(isset($arr["id"])) {
				$md = new MateriaisDAO();
				$result = $md->read($arr["id"]);
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
						isset($arr["nome"]) &&
						isset($arr["cor"]) 
					){
						$m = new Materiais();
						$m->setNome($arr["nome"]);
						$m->setCor($arr["cor"]);
		
						$md = new MateriaisDAO();
						$result = $md->create($m);
					}else {
						$result["status"] = "C003";
					}
				}else if($arr["verbo"] == "DELETE") {
					if(isset($arr["id"])) {
						if($arr["id"] > 0) {
							$md = new MateriaisDAO();
							$result = $md->delete($arr["id"]);
						}else {
							$result["status"] = "C004";
						}				
					}else {
						$result["status"] = "C003";
					}
				}else if($arr["verbo"] == "PUT") {
					if(
						isset($arr["id"]) &&
						isset($arr["nome"]) &&
						isset($arr["cor"]) 
					){
						$m = new Materiais();
						$m->setId($arr["id"]);
						$m->setNome($arr["nome"]);
						$m->setCor($arr["cor"]);
		
						$md = new MateriaisDAO();
						$result = $md->update($m);
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
			$md = new MateriaisDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doDelete($arr){
			if(isset($arr["id"])) {
				if($arr["id"] > 0) {
					$md = new MateriaisDAO();
					$result = $md->delete($arr["id"]);
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