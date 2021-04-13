<?php

	require("../process/process.status_chamado.php");

	include("configs.php");

	$sp = new Status_chamadoProcess();

	switch($_SERVER['REQUEST_METHOD']) {
		case "GET":
			$sp->doGet($_GET);
			break;

		case "POST":
			$sp->doPost($_POST);
			break;

		case "PUT":
			$sp->doPut($_PUT);
			break;

		case "DELETE":
			$sp->doDelete($_DELETE);
			break;
	}