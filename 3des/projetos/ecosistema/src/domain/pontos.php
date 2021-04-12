<?php

	class Pontos {
		var $id;
		var $rotas_id;
		var $lat;
		var $longi;

		function getId(){
			return $this->id;
		}
		function setId($id){
			$this->id = $id;
		}

		function getRotas_id(){
			return $this->rotas_id;
		}
		function setRotas_id($rotas_id){
			$this->rotas_id = $rotas_id;
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

	class PontosDAO {
		function create($p) {
			$result = array();

			$rotas_id = $p->getRotas_id();
			$lat = $p->getLat();
			$longi = $p->getLongi();

			try {
				$query = "INSERT INTO pontos (rotas_id, lat, longi) VALUES ($rotas_id, $lat, $longi)";

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

				$query = "SELECT * FROM pontos" . $cond;

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

		function update($p) {
			$result = array();

			$id = $p->getId();
			$rotas_id = $p->getRotas_id();
			$lat = $p->getLat();
			$longi = $p->getLongi();

			try {
				$query = "UPDATE pontos SET 
						 rotas_id = $rotas_id, 
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
				$query = "DELETE FROM pontos WHERE id = $id";

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
