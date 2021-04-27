<?php

	class Medico {
		var $crm;
		var $nome;
		var $cidade;
		var $posto_atendimento;
		var $especialidade;
		var $telefone;
		var $e_mail;

		function getCrm(){
			return $this->crm;
		}
		function setCrm($crm){
			$this->crm = $crm;
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

		function getPosto_atendimento(){
			return $this->posto_atendimento;
		}
		function setPosto_atendimento($posto_atendimento){
			$this->posto_atendimento = $posto_atendimento;
		}

		function getEspecialidade(){
			return $this->especialidade;
		}
		function setEspecialidade($especialidade){
			$this->especialidade = $especialidade;
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

	class MedicoDAO {
		function create($medico) {
			$result = array();
			$crm = $medico->getCrm();
			$nome = $medico->getNome();
			$cidade = $medico->getCidade();
			$posto_atendimento = $medico->getPosto_atendimento();
			$especialidade = $medico->getEspecialidade();
			$telefone = $medico->getTelefone();
			$e_mail = $medico->getE_mail();

			try {
				$query = "INSERT INTO medico VALUES($crm, '$nome', '$cidade', '$posto_atendimento', '$especialidade','$telefone', '$e_mail')";
				$con = new Connection();
				if(Connection::getInstance()->exec($query) >= 1){
					$result = $medico;
				} else {
					$result["erro"] = "Erro ao cadastrar!";
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
				$query = "SELECT * FROM medico";

				$con = new Connection();
				$resultSet = Connection::getInstance()->query($query);
				while($row = $resultSet->fetchObject()){
					$med = new Medico();
					$med->setCrm($row->crm);
					$med->setNome($row->nome);
					$med->setCidade($row->cidade);
					$med->setPosto_atendimento($row->posto_atendimento);
					$med->setEspecialidade($row->especialidade);
					$med->setTelefone($row->telefone);
					$med->setE_mail($row->e_mail);
					$result[] = $med;
				}

				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}

		function read($crm) {
			$result = array();

			try {
				$query = "SELECT * FROM medico WHERE crm = $crm";

				$con = new Connection();

				$resultSet = Connection::getInstance()->query($query);

				while($row = $resultSet->fetchObject()){
					$med = new medico();
					$med->setCrm($row->crm);
					$med->setNome($row->nome);
					$med->setCidade($row->cidade);
					$med->setPosto_atendimento($row->posto_atendimento);
					$med->setEspecialidade($row->especialidade);
					$med->setTelefone($row->telefone);
					$med->setE_mail($row->e_mail);
					$result[] = $med;
				}

				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}

		function update($med) {
			$result = array();
			$crm = $med->getCrm();
			$nome = $med->getNome();
			$cidade = $med->getCidade();
			$posto_atendimento = $med->getPosto_atendimento();
			$especialidade = $med->getEspecialidade();
			$telefone = $med->getTelefone();
			$e_mail = $med->getE_mail();
			
			try {
				$query = "UPDATE medico SET nome = '$nome', cidade = '$cidade', posto_atendimento = '$posto_atendimento', telefone = '$telefone', e_mail = '$e_mail' WHERE crm = $crm";

				$con = new Connection();

				$status = Connection::getInstance()->prepare($query);

				if($status->execute()){
					$result = $med;
				} else {
					$result["erro"] = "Não foi possível atualizar os dados!";
				}

				$con = null;

			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}

		function delete($crm) {
			$result = array();

			try {
				$query = "DELETE FROM medico WHERE crm = $crm";

				$con = new Connection();

				if(Connection::getInstance()->exec($query) >= 1){
					$result["msg"] = "Medico removido com sucesso! ";
				}else {
					$result["erro"] = "Falha ao excluir!";
				}

				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}
	}
