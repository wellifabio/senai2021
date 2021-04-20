<?php

	require("../../domain/connection.php");
	require("../../domain/usuarios.php");
	require("../../domain/valida_documento.php");

	class UsuariosProcess {
		var $ud;
		var $u;

		function doGet($arr){
			if(isset($arr["id"])) {
				$ud = new UsuariosDAO();
				$result = $ud->read($arr["id"]);
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
						isset($arr["celular"]) &&
						isset($arr["rua"]) &&
						isset($arr["numero"]) &&
						isset($arr["bairro"]) &&
						isset($arr["cidade"]) &&
						isset($arr["uf"]) &&
						isset($arr["cpf"]) &&
						isset($arr["tipo"]) && 
						isset($arr["senha"])  
					) {
						$cpf_cnpj = new ValidaCPFCNPJ($arr["cpf"]);

						if ( $cpf_cnpj->valida() ) {
							$u = new Usuarios();
							$u->setNome($arr["nome"]);
							$u->setCelular($arr["celular"]);
							$u->setRua($arr["rua"]);
							$u->setNumero($arr["numero"]);
							$u->setBairro($arr["bairro"]);
							$u->setCidade($arr["cidade"]);
							$u->setUf($arr["uf"]);
							$u->setCpf($arr["cpf"]);
							$u->setTipo($arr["tipo"]);
							$u->setSenha($arr["senha"]);
			
							$ud = new UsuariosDAO();
							$result = $ud->create($u);
						}else {
							$result["status"] = "C008";
						}
					}else {
						$result["status"] = "C003";
					}
				}else if($arr["verbo"] == "DELETE") {
					if(isset($arr["id"])) {
						if($arr["id"] > 0) {
							$ud = new UsuariosDAO();
							$result = $ud->delete($arr["id"]);
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
						isset($arr["celular"]) &&
						isset($arr["rua"]) &&
						isset($arr["numero"]) &&
						isset($arr["bairro"]) &&
						isset($arr["cidade"]) &&
						isset($arr["uf"]) &&
						isset($arr["cpf"]) &&
						isset($arr["tipo"]) && 
						isset($arr["senha"])  
					) {
						$cpf_cnpj = new ValidaCPFCNPJ($arr["cpf"]);

						if ( $cpf_cnpj->valida() ) {
							$u = new Usuarios();
							$u->setId($arr["id"]);
							$u->setNome($arr["nome"]);
							$u->setCelular($arr["celular"]);
							$u->setRua($arr["rua"]);
							$u->setNumero($arr["numero"]);
							$u->setBairro($arr["bairro"]);
							$u->setCidade($arr["cidade"]);
							$u->setUf($arr["uf"]);
							$u->setCpf($arr["cpf"]);
							$u->setTipo($arr["tipo"]);
							$u->setSenha($arr["senha"]);
			
							$ud = new UsuariosDAO();
							$result = $ud->update($u);
						}else {
							$result["status"] = "C008";
						}
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
			$ud = new UsuariosDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doDelete($arr){
			if(isset($arr["id"])) {
				if($arr["id"] > 0) {
					$ud = new UsuariosDAO();
					$result = $ud->delete($arr["id"]);
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