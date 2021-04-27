<?php
	require("conexao.php");
	class UsuarioM {
		var $crm;
		var $login;
		var $senha;

		function getCrm(){
			return $this->crm;
		}
		function setCrm($crm){
			$this->crm = $crm;
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

	class UsuarioMDAO {
		function create($usuarioM){
			$resultado = array(); 
			$crm = $usuarioM->getCrm();
			$login = $usuarioM->getLogin();
			$senha = $usuarioM->getSenha();
		
            $query = "INSERT INTO usuarios VALUES ($crm,'$login',md5('$senha')";
            try{
                $con = new Conexao();
                if(Conexao::getInstancia()->exec($query) >= 1){
                    $resultado = $usuarioM;
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
			$usuarioM = [];
			$query = "SELECT * FROM usuarioM";
			try{
				$con = new Conexao();
				$resultSet = Conexao::getInstancia()->query($query);
				while($linha = $resultSet->fetchObject()){
					$usuarioM = new UsuarioM();
					$usuarioM->setCrm($linha->crm);
					$usuarioM->setLogin($linha->login);
					$usuarioM->setSenha($linha->senha);
					$usuarioM[] = $usuarioM;
				}
				$con = null;
			}catch(PDOException $e){
				$usuarioM["erro"] = "Erro ao conectar ao BD";
			}
			return $usuarioM;
		}

		function read($crm){
			$usuarioM = [];
			$query = "SELECT * FROM usuarioM WHERE crm = $crm";
			try{
				$con = new Conexao();
				$resultSet = Conexao::getInstancia()->query($query);
				while($linha = $resultSet->fetchObject()){
					$usuarioM = new UsuarioM();
					$usuarioM->setCrm($linha->crm);
					$usuarioM->setLogin($linha->login);
					$usuarioM->setSenha($linha->senha);
					$usuarioM[] = $usuarioM;
				}
				$con = null;
			}catch(PDOException $e){
				$usuarioM["erro"] = "Erro ao conectar ao BD";
			}
			return $usuarioM;
		}

		function readLogin($login){//Lista toda a tabela usuários
			$usuarioM = [];
			$query = "SELECT * FROM usuarioM WHERE login like '$login%'";
			try{
				$con = new Conexao();
				$resultSet = Conexao::getInstancia()->query($query);//O método query de PDO retorna uma tabela como resultSet
				while($linha = $resultSet->fetchObject()){
					$usuarioM = new UsuarioM();
					$usuarioM->setCrm($linha->crm);
					$usuarioM->setLogin($linha->login);
					$usuarioM->setSenha($linha->senha);
					$usuarioM[] = $usuarioM;
				}

				$con = null;
			}catch(PDOException $e){
				$usuarioM["erro"] = "Erro ao conectar ao BD";
			}
			return $usuarioM;
		}

		function update($usuarioM){
			$resultado = [];
			$login = $usuarioM->getLogin();
			$senha = $usuarioM->getSenha();
			$query = "UPDATE usuarioM SET senha = md5('$senha') WHERE login = '$login'";
			try{
                $con = new Conexao();
				$status = Conexao::getInstancia()->prepare($query);
				if($status->execute()){
					$resultado[] = $usuarioM;
				}
				$con = null;
			}catch(PDOException $e){
				$resultado["erro"] = "Erro ao conectar ao BD";	
			}
			return $resultado;
		}

		function del($login){
			$resultado = [];
			$query = "DELETE FROM usuarioM WHERE login='$login'";
			try{
				$con = new Conexao();
				if(Conexao::getInstancia()->exec($query)>=1){
					$resultado["msg"] = "Usuário Medico removido com sucesso";
				}
				$con = null;
			}catch(PDOException $e){
				$resultado["erro"] = "Erro ao conectar ao BD";	
			}
			return $resultado;
		}

		function login($login,$senha){
			$usuarioM = null;
			$query = "SELECT * FROM usuarioM WHERE login = '$login'";
			try{
				$con = new Conexao();
				$resultSet = Conexao::getInstancia()->query($query);
				if($resultSet->fetchObject()){	
					$query = "SELECT * FROM usuarioM WHERE login = '$login' AND senha = md5('$senha')";
					$resultSet = Conexao::getInstancia()->query($query);
					if($dados = $resultSet->fetchObject()){
						$usuarioM = new usuarioM();
						$usuarioM->setCrm($dados->crm);
						$usuarioM->setLogin($dados->login);
						$usuarioM->setSenha($dados->senha);
					} else {
						$usuarioM["erro"] = "A senha informada nao confere";
					}
				}else{
					$usuarioM["erro"] = "Login nao encontrado";	
				}

				$con = null;
			}catch(PDOException $e){
				$usuarioM["erro"] = "Erro ao conectar ao BD";	
			}
			return $usuarioM;
		}

		
	}
