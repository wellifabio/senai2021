<?php

	class Veiculos {
		var $id;
		var $cooperativas_id;
		var $placa;
		var $modelo;
		var $marca;
		var $capacidade_carga_kg;
		var $ecopontos;

		function getId(){
			return $this->id;
		}
		function setId($id){
			$this->id = $id;
		}

		function getCooperativas_id(){
			return $this->cooperativas_id;
		}
		function setCooperativas_id($cooperativas_id){
			$this->cooperativas_id = $cooperativas_id;
		}

		function getPlaca(){
			return $this->placa;
		}
		function setPlaca($placa){
			$this->placa = $placa;
		}

		function getModelo(){
			return $this->modelo;
		}
		function setModelo($modelo){
			$this->modelo = $modelo;
		}

		function getMarca(){
			return $this->marca;
		}
		function setMarca($marca){
			$this->marca = $marca;
		}

		function getCapacidade_carga_kg(){
			return $this->capacidade_carga_kg;
		}
		function setCapacidade_carga_kg($capacidade_carga_kg){
			$this->capacidade_carga_kg = $capacidade_carga_kg;
		}

		function getEcopontos(){
			return $this->ecopontos;
		}
		function setEcopontos($ecopontos){
			$this->ecopontos = $ecopontos;
		}
	}

	class VeiculosDAO {
		function create($veiculos) {
			$result = array();

			$coop_id = $veiculos->getCooperativas_id();
			$placa = $veiculos->getPlaca();
			$modelo = $veiculos->getModelo();
			$marca = $veiculos->getMarca();
			$capacidade = $veiculos->getCapacidade_carga_kg();

			try {
				$query = "INSERT INTO veiculos (cooperativas_id, placa, modelo, marca, capacidade_carga_kg) VALUES " .
						 "($coop_id, '$placa', '$modelo', '$marca', $capacidade)";

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

				$query = "SELECT * FROM veiculos" . $cond;

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

		function update($veiculos) {
			$result = array();

			$id = $veiculos->getId();
			$coop_id = $veiculos->getCooperativas_id();
			$placa = $veiculos->getPlaca();
			$modelo = $veiculos->getModelo();
			$marca = $veiculos->getMarca();
			$capacidade = $veiculos->getCapacidade_carga_kg();

			try {
				$query = "UPDATE veiculos SET 
						 cooperativas_id = $coop_id, placa = '$placa',
						 modelo = '$modelo', marca = '$marca',
						 capacidade_carga_kg = $capacidade
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
				$query = "DELETE FROM veiculos WHERE id = $id";

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
