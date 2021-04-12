<?php

	class Chamados_autonomos {
		var $id;
		var $usuario_autonomo_id;
		var $usuario_solicitatnte_id;
		var $status_cha;
		var $lat;
		var $longi;
		var $dia_horario;
		var $materiais;

		function getId(){
			return $this->id;
		}
		function setId($id){
			$this->id = $id;
		}

		function getUsuario_autonomo_id(){
			return $this->usuario_autonomo_id;
		}
		function setUsuario_autonomo_id($usuario_autonomo_id){
			$this->usuario_autonomo_id = $usuario_autonomo_id;
		}

		function getUsuario_solicitatnte_id(){
			return $this->usuario_solicitatnte_id;
		}
		function setUsuario_solicitatnte_id($usuario_solicitatnte_id){
			$this->usuario_solicitatnte_id = $usuario_solicitatnte_id;
		}

		function getStatus_cha(){
			return $this->status_cha;
		}
		function setStatus_cha($status_cha){
			$this->status_cha = $status_cha;
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

		function getDia_horario(){
			return $this->dia_horario;
		}
		function setDia_horario($dia_horario){
			$this->dia_horario = $dia_horario;
		}

		function getMateriais(){
			return $this->materiais;
		}
		function setMateriais($materiais){
			$this->materiais = $materiais;
		}
	}

	class Chamados_autonomosDAO {
		function create($ca) {
			$result = array();

			$autonomo_id = $ca->getUsuario_autonomo_id();
			$solicitante_id = $ca->getUsuario_solicitatnte_id();
			$status = $ca->getStatus_cha();
			$lat = $ca->getLat();
			$longi = $ca->getLongi();
			$dia_horario = $ca->getDia_horario();

			try {
				$query = "INSERT INTO chamados_autonomos (usuarios_autonomo_id, usuarios_solicitante_id, status_chamado_id, lat, longi, dia_horario) VALUES (" . 
						 "$autonomo_id, $solicitante_id, $status, $lat, $longi, '$dia_horario'" .
						 ")";

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

				$query = "SELECT * FROM chamados_autonomos" . $cond;

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

		function update($ca) {
			$result = array();

			$id = $ca->getId();
			$autonomo_id = $ca->getUsuario_autonomo_id();
			$solicitante_id = $ca->getUsuario_solicitatnte_id();
			$status = $ca->getStatus_cha();
			$lat = $ca->getLat();
			$longi = $ca->getLongi();
			$dia_horario = $ca->getDia_horario();

			try {
				$query = "UPDATE chamados_autonomos SET 
						  usuarios_autonomo_id = $autonomo_id,
						  usuarios_solicitante_id = $solicitante_id,
						  status_chamado_id = $status,
						  lat = $lat,
						  longi = $longi,
						  dia_horario = '$dia_horario'
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
				$query = "DELETE FROM chamados_autonomos WHERE id = $id";

				$con = new Connection();

				if(Connection::getInstance()->exec($query) >= 1) {
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
