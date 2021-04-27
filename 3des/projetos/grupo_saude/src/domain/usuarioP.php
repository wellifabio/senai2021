<?php

	class UsuarioP {
		var $cpf;
		var $login;
		var $senha;

		function getCpf(){
			return $this->cpf;
		}
		function setCpf($cpf){
			$this->cpf = $cpf;
		}

		function getLogin(){
			return $this->login;
		}
		function setLogin($login){
			$this->login = $login;
		}

		function getSenha(){
			return $this->senha;
		}
		function setSenha($senha){
			$this->senha = $senha;
		}
	}

	class UsuarioPDAO {
		function create($usuarioP){
			$resultado = array(); 
			$cpf = $usuarioP->getCpf();
			$login = $usuarioP->getLogin();
			$senha = $usuarioP->getSenha();
		
            $query = "INSERT INTO usuarios VALUES ($cpf,'$login',md5('$senha')";
            try{
                $con = new Conexao();
                if(Conexao::getInstancia()->exec($query) >= 1){
                    $resultado = $usuarioP;
                }else{
					$resultado["erro"] = "Erro criar usuário Medico";
				}
                $con = null;
            } catch (PDOException $e) {
                $resultado["erro"] = "Erro ao conectar ao BD";
            }
            return $resultado;
		}

		function readAll(){
			$usuarioP = [];
			$query = "SELECT * FROM usuarioP";
			try{
				$con = new Conexao();
				$resultSet = Conexao::getInstancia()->query($query);
				while($linha = $resultSet->fetchObject()){
					$usuarioP = new usuarioP();
					$usuarioP->setCpf($linha->cpf);
					$usuarioP->setLogin($linha->login);
					$usuarioP->setSenha($linha->senha);
					$usuarioP[] = $usuarioP;
				}
				$con = null;
			}catch(PDOException $e){
				$usuarioP["erro"] = "Erro ao conectar ao BD";
			}
			return $usuarioP;
		}

		function read($cpf){
			$usuarioP = [];
			$query = "SELECT * FROM usuarioP WHERE cpf = $cpf";
			try{
				$con = new Conexao();
				$resultSet = Conexao::getInstancia()->query($query);
				while($linha = $resultSet->fetchObject()){
					$usuarioP = new usuarioP();
					$usuarioP->setCpf($linha->cpf);
					$usuarioP->setLogin($linha->login);
					$usuarioP->setSenha($linha->senha);
					$usuarioP[] = $usuarioP;
				}
				$con = null;
			}catch(PDOException $e){
				$usuarioP["erro"] = "Erro ao conectar ao BD";
			}
			return $usuarioP;
		}

		function readLogin($login){//Lista toda a tabela usuários
			$usuarioP = [];
			$query = "SELECT * FROM usuarioP WHERE login like '$login%'";
			try{
				$con = new Conexao();
				$resultSet = Conexao::getInstancia()->query($query);//O método query de PDO retorna uma tabela como resultSet
				while($linha = $resultSet->fetchObject()){
					$usuarioP = new usuarioP();
					$usuarioP->setCpf($linha->cpf);
					$usuarioP->setLogin($linha->login);
					$usuarioP->setSenha($linha->senha);
					$usuarioP[] = $usuarioP;
				}

				$con = null;
			}catch(PDOException $e){
				$usuarioP["erro"] = "Erro ao conectar ao BD";
			}
			return $usuarioP;
		}

		function update($usuarioP){
			$resultado = [];
			$login = $usuarioP->getLogin();
			$senha = $usuarioP->getSenha();
			$query = "UPDATE usuarioP SET senha = md5('$senha') WHERE login = '$login'";
			try{
                $con = new Conexao();
				$status = Conexao::getInstancia()->prepare($query);
				if($status->execute()){
					$resultado[] = $usuarioP;
				}
				$con = null;
			}catch(PDOException $e){
				$resultado["erro"] = "Erro ao conectar ao BD";	
			}
			return $resultado;
		}

		function del($login){
			$resultado = [];
			$query = "DELETE FROM usuarioP WHERE login='$login'";
			try{
				$con = new Conexao();
				if(Conexao::getInstancia()->exec($query)>=1){
					$resultado["msg"] = "Usuário Paciente removido com sucesso";
				}
				$con = null;
			}catch(PDOException $e){
				$resultado["erro"] = "Erro ao conectar ao BD";	
			}
			return $resultado;
		}

		function login($login,$senha){
			$usuarioP = null;
			$query = "SELECT * FROM usuarioP WHERE login = '$login'";
			try{
				$con = new Conexao();
				$resultSet = Conexao::getInstancia()->query($query);
				if($resultSet->fetchObject()){	
					$query = "SELECT * FROM usuarioP WHERE login = '$login' AND senha = md5('$senha')";
					$resultSet = Conexao::getInstancia()->query($query);
					if($dados = $resultSet->fetchObject()){
						$usuarioP = new usuarioP();
						$usuarioP->setCpf($dados->cpf);
						$usuarioP->setLogin($dados->login);
						$usuarioP->setSenha($dados->senha);

					} else {
						$usuarioP["erro"] = "A senha informada nao confere";
					}
				}else{
					$usuarioP["erro"] = "Login nao encontrado";	
				}
				$con = null;
			}catch(PDOException $e){
				$usuarioP["erro"] = "Erro ao conectar ao BD";	
			}
			return $usuarioP;
		}

		
	}
