<?php

	class Usuarios {
		var $id;
		var $nome;
		var $celular;
		var $rua;
		var $numero;
		var $bairro;
		var $cidade;
		var $uf;
		var $cpf;
		var $senha;
		var $tipo;

		function getId(){
			return $this->id;
		}
		function setId($id){
			$this->id = $id;
		}

		function getNome(){
			return $this->nome;
		}
		function setNome($nome){
			$this->nome = $nome;
		}

		function getCelular(){
			return $this->celular;
		}
		function setCelular($celular){
			$this->celular = $celular;
		}

		function getRua(){
			return $this->rua;
		}
		function setRua($rua){
			$this->rua = $rua;
		}

		function getNumero(){
			return $this->numero;
		}
		function setNumero($numero){
			$this->numero = $numero;
		}

		function getBairro(){
			return $this->bairro;
		}
		function setBairro($bairro){
			$this->bairro = $bairro;
		}

		function getCidade(){
			return $this->cidade;
		}
		function setCidade($cidade){
			$this->cidade = $cidade;
		}

		function getUf(){
			return $this->uf;
		}
		function setUf($uf){
			$this->uf = $uf;
		}

		function getCpf(){
			return $this->cpf;
		}
		function setCpf($cpf){
			$this->cpf = $cpf;
		}

		function getSenha(){
			return $this->senha;
		}
		function setSenha($senha){
			$this->senha = $senha;
		}

		function getTipo(){
			return $this->tipo;
		}
		function setTipo($tipo){
			$this->tipo = $tipo;
		}
	}

	class UsuariosDAO {
		function create($usuarios) {
			$result = array();

			$nome = $usuarios->getNome();
			$cel = $usuarios->getCelular();
			$rua = $usuarios->getRua();
			$numero = $usuarios->getNumero();
			$bairro = $usuarios->getBairro();
			$cidade = $usuarios->getCidade();
			$uf = $usuarios->getUf();
			$cpf = $usuarios->getCpf();
			$tipo = $usuarios->getTipo();
			$senha = $usuarios->getSenha();

			try {
				$query = "INSERT INTO usuarios (nome, celular, rua, numero, bairro, cidade, uf, cpf) VALUES" .
				 		 " ('$nome', '$cel', '$rua', '$numero', '$bairro', '$cidade', '$uf', '$cpf')";

				$con = new Connection();

				if(Connection::getInstance()->exec($query) >= 1){
					$id = Connection::getInstance()->lastInsertId();

					$query = "INSERT INTO logins (usuarios_id, tipos_logins_id, senha) VALUES ($id, $tipo, '$senha')";
					
					if(Connection::getInstance()->exec($query) >= 1){
						$result["id"] = $id;
						$result["status"] = "C001";
					}else {
						$this->delete($id);
						$result["status"] = "C002";
					}
				}else {
					$result["status"] = "C002";
				}

				$con = null;
			}catch(PDOException $e) {
				//$result["err"] = $e->getMessage();
				$result["status"] = "PDO".$e->getCode();
			}

			return $result;
		}

		function read($id) {
			$result = array();

			try {
				if($id == 0) {
					$cond = "";
				}else {
					$cond = " WHERE id = $id";
				}

				$query = "SELECT * FROM usuarios" . $cond;

				$con = new Connection();

				$resultSet = Connection::getInstance()->query($query);

				while($row = $resultSet->fetchObject()){
					$result[] = $row;
				}

				$con = null;
			}catch(PDOException $e) {
				//$result["err"] = $e->getMessage();
				$result["status"] = "PDO".$e->getCode();
			}

			return $result;
		}

		function update($usuarios) {
			$result = array();

			$id = $usuarios->getId();
			$nome = $usuarios->getNome();
			$cel = $usuarios->getCelular();
			$rua = $usuarios->getRua();
			$numero = $usuarios->getNumero();
			$bairro = $usuarios->getBairro();
			$cidade = $usuarios->getCidade();
			$uf = $usuarios->getUf();
			$cpf = $usuarios->getCpf();
			$tipo = $usuarios->getTipo();
			$senha = $usuarios->getSenha();

			try {
				$query = "UPDATE usuarios SET 
						 nome = '$nome', celular = '$cel',
						 rua = '$rua', numero = '$numero',
						 bairro = '$bairro', cidade = '$cidade',
						 uf = '$uf', cpf = '$cpf' 
						 WHERE id = $id";

				$con = new Connection();

				$status = Connection::getInstance()->prepare($query);
				
				if($status->execute()){
					$query = "UPDATE logins SET tipos_logins_id = $tipo, senha = '$senha' WHERE usuarios_id = $id";
					
					$status = Connection::getInstance()->prepare($query);

					if($status->execute()){
						$result["status"] = "C001";
					}else {
						$result["status"] = "C002";
					}
				}else {
					$result["status"] = "C002";
				}

				$con = null;
			}catch(PDOException $e) {
				//$result["err"] = $e->getMessage();
				$result["status"] = "PDO".$e->getCode();
			}

			return $result;
		}

		function delete($id) {
			$result = array();

			try {
				$query = "DELETE FROM usuarios WHERE id = $id";

				$con = new Connection();

				if(Connection::getInstance()->exec($query) >= 1){
					$result["status"] = "C001";
				}else {
					$result["status"] = "C002";
				}

				$con = null;
			}catch(PDOException $e) {
				//$result["err"] = $e->getMessage();
				$result["status"] = "PDO".$e->getCode();
			}

			return $result;
		}
	}
