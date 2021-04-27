<?php

    require("../../domain/connection.php");
    require("../../domain/usuariom.php");
	header("Content-type: application/json"); 
	$ud = new UsuarioDAO();

	include("putdel.php"); 
	
	
	if(!empty($_GET)){ 
		
		if($_GET["crm"]=="0"){
			if(empty($_GET["login"])){
				echo json_encode($ud->readAll());
			} else {
				echo json_encode($ud->readLogin($_GET["login"]));
			}			
		} else {
			echo json_encode($ud->read($_GET["crm"]));
		}
	}
	
	if(!empty($_POST)){
		if(!empty($_POST["crm"])){
			$usuarioM = new UsuarioM();
			$usuarioM->setCrm($_POST["crm"]);
			$usuarioM->setLogin($_POST["login"]);
			$usuarioM->setSenha($_POST["senha"]);
			$status = $ud->create($usuarioM);
			if(is_object($status)){
				http_response_code(201);
			}
			echo json_encode($status);
		}
		if(!empty($_POST["login"])&&!empty($_POST["senha"])&&empty($_POST["crm"])){
			$login = $_POST["login"];
			$senha = $_POST["senha"];
			$status = $ud->login($login,$senha);
			if(is_object($status)){
				header("location:$urlFront?login=".$status->getLogin().."&crm=".$status->getCrm());
			} else {
				header("location:$urlFront?erro=".$status["erro"]);
			}
		}
	}
	
	if(!empty($_PUT)){ 
		$usuarioM = new UsuarioM();
		$usuarioM->setLogin($_PUT["login"]);
		$usuarioM->setSenha($_PUT["senha"]);
		echo json_encode($ud->update($usuarioM));
	}
	
	if(!empty($_DELETE)){ 
		$login = $_DELETE["login"];
		echo json_encode($ud->del($login));
	}
?>