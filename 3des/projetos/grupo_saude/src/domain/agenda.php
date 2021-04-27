<?php

	class Agenda {
		var $id;
		var $id_medico;
		var $id_paciente;
		var $data_hora;
		var $id_status;

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

		function getId_paciente(){
			return $this->id_paciente;
		}
		function setId_paciente($id_paciente){
			$this->id_paciente = $id_paciente;
		}

		function getData_hora(){
			return $this->data_hora;
		}
		function setData_hora($data_hora){
			$this->data_hora = $data_hora;
		}

		function getId_status(){
			return $this->id_status;
		}
		function setId_status($id_status){
			$this->id_status = $id_status;
		}
	}

	class AgendaDAO {
		function create($agenda) {
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
