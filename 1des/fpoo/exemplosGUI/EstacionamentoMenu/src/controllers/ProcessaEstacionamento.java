package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import models.Estacionamento;
import models.Vaga;
import models.dao.EstacionamentoDAO;

public class ProcessaEstacionamento {

	public static ArrayList<Estacionamento> estacionamentos = new ArrayList<>();
	public static ArrayList<Estacionamento> estacionados = new ArrayList<>();
	public static ArrayList<Vaga> carros;
	public static ArrayList<Vaga> motos;
	private static EstacionamentoDAO ed = new EstacionamentoDAO();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void preencherVagas() {
		carros = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			carros.add(new Vaga("C0" + (i + 1),isOupada("C0" + (i + 1))));
		}
		motos = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			motos.add(new Vaga("M0" + (i + 1),isOupada("M0" + (i + 1))));
		}
	}

	public static void abrir() {
		estacionamentos = ed.abrir();
	}

	public static boolean salvar() {
		if (ed.salvar(estacionamentos)) {
			return true;
		} else {
			return false;
		}
	}

	public static void obterEstacionados() {
		estacionados = new ArrayList<>();
		for (Estacionamento e : estacionamentos)
			if (e.getHoraSaida().equals(""))
				estacionados.add(e);
	}
	
	private static boolean isOupada(String vaga) {
		boolean status = false;
		for(Estacionamento e: estacionados) {
			if(vaga.equals(e.getVaga()))
				status = true;
		}
		return status;
	}
	
	public static String obterPlaca(String vaga) {
		String placa = "";
		for(Estacionamento e: estacionados) {
			if(vaga.equals(e.getVaga())) {
				placa = e.getPlaca();
			}
		}
		return placa;
	}
	
	public static void preencherTestes() {
		try {
			estacionamentos.add(new Estacionamento("C01", "AAA1111", sdf.parse("30/06/2021"), "07:00", "10:00", 5.0));
			estacionamentos.add(new Estacionamento("C02", "AAA2222", sdf.parse("30/06/2021"), "07:00", "10:00", 5.0));
			estacionamentos.add(new Estacionamento("C05", "AAA3333", sdf.parse("30/06/2021"), "08:00", "11:00", 5.0));
			estacionamentos.add(new Estacionamento("C04", "AAA4444", sdf.parse("30/06/2021"), "08:00", "16:00", 5.0));
			estacionamentos.add(new Estacionamento("C03", "AAA5555", sdf.parse("30/06/2021"), "09:00", "15:00", 5.0));
			estacionamentos.add(new Estacionamento("C06", "AAA6666", sdf.parse("30/06/2021"), "09:00", "14:00", 5.0));
			estacionamentos.add(new Estacionamento("C08", "AAA7777", sdf.parse("30/06/2021"), "10:00", "12:00", 5.0));
			estacionamentos.add(new Estacionamento("M01", "AAA8888", sdf.parse("30/06/2021"), "10:00", "11:00", 3.0));
			estacionamentos.add(new Estacionamento("M02", "AAA9999", sdf.parse("30/06/2021"), "11:00", "12:00", 3.0));
			estacionamentos.add(new Estacionamento("C01", "AAA0000", new Date(), "08:00", "10:00", 5.0));
			estacionamentos.add(new Estacionamento("C02", "AAA1111", new Date(), "08:00", "", 5.0));
			estacionamentos.add(new Estacionamento("C03", "AAA2222", new Date(), "08:00", "", 5.0));
			estacionamentos.add(new Estacionamento("M01", "AAA3333", new Date(), "08:00", "", 3.0));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
