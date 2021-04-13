<?php

	class Rotas {
		var $id;
		var $veiculos_id;
		var $nome;
		var $dia_hora;

		function getId(){
			return $this->id;
		}
		function setId($id){
			$this->id = $id;
		}

		function getVeiculos_id(){
			return $this->veiculos_id;
		}
		function setVeiculos_id($veiculos_id){
			$this->veiculos_id = $veiculos_id;
		}

		function getNome(){
			return $this->nome;
		}
		function setNome($nome){
			$this->nome = $nome;
		}

		function getDia_hora(){
			return $this->dia_hora;
		}
		function setDia_hora($dia_hora){
			$this->dia_hora = $dia_hora;
		}
	}

	class RotasDAO {
		function create($rotas) {
			$result = array();

			$veiculo = $rotas->getVeiculos_id();
			$nome = $rotas->getNome();
			$dia = $rotas->getDia_hora();

			try {
				$query = "INSERT INTO rotas (veiculos_id, nome, dia_horario) VALUES ($veiculo, '$nome', '$dia')";

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

				$query = "SELECT * FROM rotas" . $cond;

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

		function update($rotas) {
			$result = array();

			$id = $rotas->getId();
			$veiculo = $rotas->getVeiculos_id();
			$nome = $rotas->getNome();
			$dia = $rotas->getDia_hora();

			try {
				$query = "UPDATE rotas SET 
						 veiculos_id = $veiculo, 
						 nome = '$nome',
						 dia_horario = '$dia'
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
				$query = "DELETE FROM rotas WHERE id = $id";

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
