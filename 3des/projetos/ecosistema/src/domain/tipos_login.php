<?php

	class Tipos_login {
		var $id;
		var $tipo;

		function getId(){
			return $this->id;
		}
		function setId($id){
			$this->id = $id;
		}

		function getTipo(){
			return $this->tipo;
		}
		function setTipo($tipo){
			$this->tipo = $tipo;
		}
	}

	class Tipos_loginDAO {
		function create($tipos_login) {
			$result = array();

			$tipo = $tipos_login->getTipo();

			try {
				$query = "INSERT INTO tipos_logins (tipo) VALUES ('$tipo')";

				$con = new Connection();

				if(Connection::getInstance()->exec($query) >= 1){
					$result["id"] = Connection::getInstance()->lastInsertId();
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

		function read($id) {
			$result = array();

			try {
				if($id == 0) {
					$cond = "";
				}else {
					$cond = " WHERE id = $id";
				}

				$query = "SELECT * FROM tipos_logins" . $cond;

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

		function update($tipos_login) {
			$result = array();

			$id = $tipos_login->getId();
			$tipo = $tipos_login->getTipo();

			try {
				$query = "UPDATE tipos_logins SET tipo = '$tipo' WHERE id = $id";

				$con = new Connection();

				$status = Connection::getInstance()->prepare($query);

				if($status->execute()){
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

		function delete($id) {
			$result = array();

			try {
				$query = "DELETE FROM tipos_logins WHERE id = $id";

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
