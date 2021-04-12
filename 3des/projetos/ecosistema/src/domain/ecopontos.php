<?php

	class Ecopontos {
		var $id;
		var $cooperativas_id;
		var $nome;
		var $descricao;
		var $lat;
		var $longi;

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

		function getNome(){
			return $this->nome;
		}
		function setNome($nome){
			$this->nome = $nome;
		}

		function getDescricao(){
			return $this->descricao;
		}
		function setDescricao($descricao){
			$this->descricao = $descricao;
		}

		function getLat(){
			return $this->lat;
		}
		function setLat($lat){
			$this->lat = $lat;
		}

		function getLongi(){
			return $this->longi;
		}
		function setLongi($longi){
			$this->longi = $longi;
		}
	}

	class EcopontosDAO {
		function create($ecopontos) {
			$result = array();

			$coop = $ecopontos->getCooperativas_id();
			$nome = $ecopontos->getNome();
			$descricao = $ecopontos->getDescricao();
			$lat = $ecopontos->getLat();
			$longi = $ecopontos->getLongi();

			try {
				$query = "INSERT INTO ecopontos (cooperativas_id, nome, descricao, lat, longi) VALUES" . 
						 " ($coop, '$nome', '$descricao', $lat, $longi)";

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

				$query = "SELECT * FROM ecopontos" . $cond;

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

		function update($e) {
			$result = array();

			$id = $e->getId();
			$coop_id = $e->getCooperativas_id();
			$nome = $e->getNome();
			$descricao = $e->getDescricao();
			$lat = $e->getLat();
			$longi = $e->getLongi();

			try {
				$query = "UPDATE ecopontos SET 
						  cooperativas_id = $coop_id, 
						  nome = '$nome',
						  descricao = '$descricao',
						  lat = $lat,
						  longi = $longi
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
				$query = "DELETE FROM ecopontos WHERE id = $id";

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
