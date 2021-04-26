<?php

	require("../process/process.usuario.php");

	include("configs.php");

	$up = new UsuarioProcess();

	switch($_SERVER['REQUEST_METHOD']) {
		case "GET":
			$up->doGet($_GET);
			break;

		case "POST":
			$up->doPost($_POST);
			break;

		case "PUT":
			$up->doPut($_PUT);
			break;

		case "DELETE":
			$up->doDelete($_DELETE);
			break;
	}