<?php

	require("../process/process.login.php");

	include("configs.php");

	$lp = new LoginProcess();

	switch($_SERVER['REQUEST_METHOD']) {
		case "GET":
			$lp->doGet($_GET);
			break;

		case "POST":
			$lp->doPost($_POST);
			break;

		case "PUT":
			$lp->doPut($_PUT);
			break;

		case "DELETE":
			$lp->doDelete($_DELETE);
			break;
	}