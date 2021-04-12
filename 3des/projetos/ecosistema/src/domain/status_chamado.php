<?php

	class Status_chamado {
		var $id;
		var $status_cha;

		function getId(){
			return $this->id;
		}
		function setId($id){
			$this->id = $id;
		}

		function getStatus_cha(){
			return $this->status_cha;
		}
		function setStatus_cha($status_cha){
			$this->status_cha = $status_cha;
		}
	}

	class Status_chamadoDAO {
		function create($status_chamado) {
			$result = array();

			$status = $status_chamado->getStatus_cha();

			try {
				$query = "INSERT INTO status_chamado (status_cha) VALUES ('$status')";

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

				$query = "SELECT * FROM status_chamado";

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

		function update($status_chamado) {
			$result = array();

			$id = $status_chamado->getId();
			$status = $status_chamado->getStatus_cha();

			try {
				$query = "UPDATE status_chamado SET 
						 status_cha = '$status' 
						 WHERE id = $id";

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
				$query = "DELETE FROM status_chamado WHERE id = $id";

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
