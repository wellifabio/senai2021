package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import models.Estacionamento;
import models.dao.EstacionamentoDAO;

public class ProcessaEstacionamento {

	public static ArrayList<Estacionamento> estacionamentos = new ArrayList<>();
	private static EstacionamentoDAO ed = new EstacionamentoDAO();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void preencherTestes() {
		try {
			estacionamentos.add(new Estacionamento("VC01", "AAA1111", sdf.parse("30/06/2021"), "07:00", "10:00", 5.0));
			estacionamentos.add(new Estacionamento("VC02", "AAA2222", sdf.parse("30/06/2021"), "07:00", "10:00", 5.0));
			estacionamentos.add(new Estacionamento("VC05", "AAA3333", sdf.parse("30/06/2021"), "08:00", "11:00", 5.0));
			estacionamentos.add(new Estacionamento("VC04", "AAA4444", sdf.parse("30/06/2021"), "08:00", "16:00", 5.0));
			estacionamentos.add(new Estacionamento("VC03", "AAA5555", sdf.parse("30/06/2021"), "09:00", "15:00", 5.0));
			estacionamentos.add(new Estacionamento("VC06", "AAA6666", sdf.parse("30/06/2021"), "09:00", "14:00", 5.0));
			estacionamentos.add(new Estacionamento("VC08", "AAA7777", sdf.parse("30/06/2021"), "10:00", "12:00", 5.0));
			estacionamentos.add(new Estacionamento("VM01", "AAA8888", sdf.parse("30/06/2021"), "10:00", "11:00", 3.0));
			estacionamentos.add(new Estacionamento("VM02", "AAA9999", sdf.parse("30/06/2021"), "11:00", "12:00", 3.0));
			estacionamentos.add(new Estacionamento("VC01", "AAA0000", new Date(), "08:00", "10:00", 5.0));
			estacionamentos.add(new Estacionamento("VC02", "AAA1111", new Date(), "08:00", "", 5.0));
			estacionamentos.add(new Estacionamento("VC03", "AAA2222", new Date(), "08:00", "", 5.0));
			estacionamentos.add(new Estacionamento("VM01", "AAA3333", new Date(), "08:00", "", 3.0));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void abrir() {
		estacionamentos = ed.abrir();
	}
	
	public static boolean salvar() {
		if(ed.salvar(estacionamentos)) {
			return true;
		} else {
			return false;
		}
	}
}
