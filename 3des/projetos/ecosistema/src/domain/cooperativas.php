<?php

	class Cooperativas {
		var $id;
		var $nome;

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
	}

	class CooperativasDAO {
		function create($cooperativas) {
			$result = array();

			$nome = $cooperativas->getNome();

			try {
				$query = "INSERT INTO cooperativas (nome) VALUES ('$nome')";

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

				$query = "SELECT * FROM cooperativas" . $cond;

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

		function update($c) {
			$result = array();

			$id = $c->getId();
			$nome = $c->getNome();

			try {
				$query = "UPDATE cooperativas SET nome = '$nome' WHERE id = $id";

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
				$query = "DELETE FROM cooperativas WHERE id = $id";
				
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
