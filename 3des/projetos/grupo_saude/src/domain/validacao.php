<?php

	class Validacao {
		var $id;
		var $id_medico;
		var $num_crm;
		var $carterinha;
		var $status;

		function getId(){
			return $this->id;
		}
		function setId($id){
			$this->id = $id;
		}

		function getId_medico(){
			return $this->id_medico;
		}
		function setId_medico($id_medico){
			$this->id_medico = $id_medico;
		}

		function getNum_crm(){
			return $this->num_crm;
		}
		function setNum_crm($num_crm){
			$this->num_crm = $num_crm;
		}

		function getCarterinha(){
			return $this->carterinha;
		}
		function setCarterinha($carterinha){
			$this->carterinha = $carterinha;
		}

		function getStatus(){
			return $this->status;
		}
		function setStatus($status){
			$this->status = $status;
		}
	}

	class ValidacaoDAO {
		function create($validacao) {
			$result = array();

			try {
				$query = "INSERT INTO table_name (column1, column2) VALUES (value1, value2)";

				$con = new Connection();

				if(Connection::getInstance()->exec($query) >= 1){
				}

				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}

		function read() {
			$result = array();

			try {
				$query = "SELECT column1, column2 FROM table_name WHERE condition";

				$con = new Connection();

				$resultSet = Connection::getInstance()->query($query);

				while($row = $resultSet->fetchObject()){
				}

				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}

		function update() {
			$result = array();

			try {
				$query = "UPDATE table_name SET column1 = value1, column2 = value2 WHERE condition";

				$con = new Connection();

				$status = Connection::getInstance()->prepare($query);

				if($status->execute()){
				}

				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}

		function delete() {
			$result = array();

			try {
				$query = "DELETE FROM table_name WHERE condition";

				$con = new Connection();

				if(Connection::getInstance()->exec($query) >= 1){
				}

				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}
	}
