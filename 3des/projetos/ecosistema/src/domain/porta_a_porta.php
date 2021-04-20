<?php

	class Porta_a_porta {
		var $id;
		var $cooperativas_id;
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

	class Porta_a_portaDAO {
		function create($porta_a_porta) {
			$result = array();

			$cooperativas_id = $porta_a_porta->getCooperativas_id();
			$descricao = $porta_a_porta->getDescricao();
			$lat = $porta_a_porta->getLat();
			$longi = $porta_a_porta->getLongi();

			try {
				$query = "INSERT INTO porta_a_porta (cooperativas_id, descricao, lat, longi) VALUES ($cooperativas_id, '$descricao', $lat, $longi)";

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

				$query = "SELECT * FROM porta_a_porta" . $cond;

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

		function update($porta_a_porta) {
			$result = array();

			$id = $porta_a_porta->getId();
			$cooperativas_id = $porta_a_porta->getCooperativas_id();
			$descricao = $porta_a_porta->getDescricao();
			$lat = $porta_a_porta->getLat();
			$longi = $porta_a_porta->getLongi();

			try {
				$query = "UPDATE porta_a_porta SET 
						 cooperativas_id = $cooperativas_id, 
						 descricao = $descricao, 
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
				$query = "DELETE FROM porta_a_porta WHERE id = $id";

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
