<?php

	class Login {
		var $user;
		var $password;

		function getUser(){
			return $this->user;
		}
		function setUser($user){
			$this->user = $user;
		}

		function getPassword(){
			return $this->password;
		}
		function setPassword($password){
			$this->password = $password;
		}
	}

	class LoginDAO {
		function create($login) {
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

		function read($login) {
			$result = array();

			$doc = $login->getUser();
			$psw = $login->getPassword();
			
			try {
				$query = "SELECT usuarios.id, nome, tipo FROM usuarios 
				INNER JOIN logins
				ON usuarios.id = logins.usuarios_id
				INNER JOIN tipos_logins
				ON logins.tipos_logins_id = tipos_logins.id
				WHERE usuarios.cpf = '$doc' AND logins.senha = '$psw'";

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
