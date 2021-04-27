<?php

    require("../../domain/connection.php");
    require("../../domain/usuariop.php");
	header("Content-type: application/json"); 
	$ud = new UsuarioDAO();

	include("putdel.php"); 
	
	
	if(!empty($_GET)){ 
		
		if($_GET["cpf"]=="0"){
			if(empty($_GET["login"])){
				echo json_encode($ud->readAll());
			} else {
				echo json_encode($ud->readLogin($_GET["login"]));
			}			
		} else {
			echo json_encode($ud->read($_GET["cpf"]));
		}
	}
	
	if(!empty($_POST)){
		if(!empty($_POST["crm"])){
			$usuarioP = new UsuarioM();
			$usuarioP->setCpf($_POST["cpf"]);
			$usuarioP->setLogin($_POST["login"]);
			$usuarioP->setSenha($_POST["senha"]);
			$status = $ud->create($usuarioM);
			if(is_object($status)){
				http_response_code(201);
			}
			echo json_encode($status);
		}
		if(!empty($_POST["login"])&&!empty($_POST["senha"])&&empty($_POST["cpf"])){
			$login = $_POST["login"];
			$senha = $_POST["senha"];
			$status = $ud->login($login,$senha);
			if(is_object($status)){
				header("location:$urlFront?login=".$status->getLogin()."&cpf=".$status->getCpf());
			} else {
				header("location:$urlFront?erro=".$status["erro"]);
			}
		}
	}
	
	if(!empty($_PUT)){ 
		$usuarioP = new UsuarioM();
		$usuarioP->setLogin($_PUT["login"]);
		$usuarioP->setSenha($_PUT["senha"]);
		echo json_encode($ud->update($usuarioP));
	}
	
	if(!empty($_DELETE)){ 
		$login = $_DELETE["login"];
		echo json_encode($ud->del($login));
	}
?>