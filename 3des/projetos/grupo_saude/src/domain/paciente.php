<?php

	class Paciente {
		var $cpf;
		var $nome;
		var $cidade;
		var $tipo_sanguineo;
		var $data_de_nascimento;
		var $telefone;
		var $e_mail;

		function getCpf(){
			return $this->cpf;
		}
		function setCpf($cpf){
			$this->cpf = $cpf;
		}

		function getNome(){
			return $this->nome;
		}
		function setNome($nome){
			$this->nome = $nome;
		}

		function getCidade(){
			return $this->cidade;
		}
		function setCidade($cidade){
			$this->cidade = $cidade;
		}

		function getTipo_sanguineo(){
			return $this->tipo_sanguineo;
		}
		function setTipo_sanguineo($tipo_sanguineo){
			$this->tipo_sanguineo = $tipo_sanguineo;
		}

		function getData_de_nascimento(){
			return $this->data_de_nascimento;
		}
		function setData_de_nascimento($data_de_nascimento){
			$this->data_de_nascimento = $data_de_nascimento;
		}

		function getTelefone(){
			return $this->telefone;
		}
		function setTelefone($telefone){
			$this->telefone = $telefone;
		}

		function getE_mail(){
			return $this->e_mail;
		}
		function setE_mail($e_mail){
			$this->e_mail = $e_mail;
		}
	}

	class PacienteDAO {
		function create($paciente) {
			$result = array();

			try {
				$query = "INSERT INTO Paciente VALUES('".$paciente->getCpf()."', '".$paciente->getNome()."', '".$paciente->getCidade()."',
				 '".$paciente->getTipo_sanguineo()."', '".$paciente->getData_de_nascimento()."', '".$paciente->getTelefone()."',
				  '".$paciente->getE_mail()."')";

				$con = new Connection();

				if(Connection::getInstance()->exec($query) >= 1){
					$result["cpf"] = $paciente->getCpf();
					$result["nome"] = $paciente->getNome();
					$result["cidade"] = $paciente->getCidade();
					$result["tipo_sanguineo"] = $paciente->getTipo_sanguineo();
					$result["data_de_nascimento"] = $paciente->getData_de_nascimento();
					$result["telefone"] = $paciente->getTelefone();
					$result["e_mail"] = $paciente->getE_mail();
				}else{
					$result["erro"] = "Não foi possivel adicionar um novo paciente";
				}

				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}

		function read($cpf) {
			$result = array();

			try {
				$query = "SELECT * FROM paciente WHERE cpf = $cpf";
				$con = new Connection();

				$resultSet = Connection::getInstance()->query($query);
				
				while($row = $resultSet->fetchObject()){
					$paciente = new Paciente();
					$paciente->setCpf($row->cpf);
					$paciente->setNome($row->nome);
					$paciente->setCidade($row->cidade);
					$paciente->setTipo_sanguineo($row->tipo_sanguineo);
					$paciente->setData_de_nascimento($row->data_de_nascimento);
					$paciente->setTelefone($row->telefone);
					$paciente->setE_mail($row->e_mail);
					$result[] = $paciente;
				}

				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}

		function readAll() {
			$result = array();
			try {
				$query = "SELECT * FROM paciente";
				$con = new Connection();
				
				$resultSet = Connection::getInstance()->query($query);
				
				while($row = $resultSet->fetchObject()){
					$paciente = new Paciente();
					$paciente->setCpf($row->cpf);
					$paciente->setNome($row->nome);
					$paciente->setCidade($row->cidade);
					$paciente->setTipo_sanguineo($row->tipo_sanguineo);
					$paciente->setData_de_nascimento($row->data_de_nascimento);
					$paciente->setTelefone($row->telefone);
					$paciente->setE_mail($row->e_mail);
					$result[] = $paciente;
				}
				
				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}

		function update($paci) {
			$result = array();
			$cpf = $paci->getCpf();
			$nome = $paci->getNome();
			$cidade = $paci->getCidade();
			$tipo_sanguineo = $paci->getTipo_sanguineo();
			$data_de_nascimento = $paci->getData_de_nascimento();
			$telefone = $paci->getTelefone();
			$e_mail = $paci->getE_mail();

			try {
				$query = "UPDATE paciente SET nome = '$nome', cidade = '$cidade', tipo_sanguineo = '$tipo_sanguineo ', telefone = '$telefone', e_mail = '$e_mail', data_de_nascimento = '$data_de_nascimento' WHERE cpf = '$cpf'";
				$con = new Connection();
				$status = Connection::getInstance()->prepare($query);
				if($status->execute()){
					$result = $paci;
				}else{
					$result["erro"] = "Não foi possivel atualizar os dados desse paciente!";
				}
				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}

		function delete($cpf) {
			$result = array();

			try {
				$query = "DELETE FROM paciente WHERE cpf = '$cpf'";

				$con = new Connection();

				if(Connection::getInstance()->exec($query) >= 1){
					$result["msg"] = "Paciente removido com sucesso!";
				}else{
					$result["erro"] = "Paciente não removido!";
				}

				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}
	}
