package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import models.Estacionamento;
import models.Vaga;
import models.dao.EstacionamentoDAO;

public class EstacionamentoProcess {

	public static ArrayList<Estacionamento> registros = new ArrayList<>();
	public static ArrayList<Estacionamento> estacionados = new ArrayList<>();
	public static ArrayList<Vaga> carros;
	public static ArrayList<Vaga> motos;
	private static EstacionamentoDAO ed = new EstacionamentoDAO();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void preencherVagas() {
		carros = new ArrayList<>();
		motos = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			if(ocupada("C0" + (i + 1)).length() > 0)
				carros.add(new Vaga("C0" + (i + 1),ocupada("C0" + (i + 1)),registros.indexOf(obterEstacionado("C0"+(i+1)))));
			else
				carros.add(new Vaga("C0" + (i + 1)));
			if(i < 3) {
				if(ocupada("M0" + (i + 1)).length() > 0)
					motos.add(new Vaga("M0" + (i + 1),ocupada("M0" + (i + 1)),registros.indexOf(obterEstacionado("M0"+(i+1)))));
				else
					motos.add(new Vaga("M0" + (i + 1)));
			}
		}
	}

	public static void abrir() {
		registros = ed.abrir();
	}

	public static boolean salvar() {
		if (ed.salvar(registros)) {
			return true;
		} else {
			return false;
		}
	}

	public static void obterEstacionados() {
		estacionados = new ArrayList<>();
		for (Estacionamento r : registros)
			if (r.getHoraSaida().equals(""))
				estacionados.add(r);
	}

	private static String ocupada(String vaga) {
		String placa = "";
		for (Estacionamento e : estacionados) {
			if (vaga.equals(e.getVaga()))
				placa = e.getPlaca();
		}
		return placa;
	}

	public static Estacionamento obterEstacionado(String vaga) {
		for (Estacionamento e : estacionados) {
			if (vaga.equals(e.getVaga())) {
				return e;
			}
		}
		return null;
	}

	public static void preencherTestes() {
		try {
			registros.add(new Estacionamento(getLastId(),"C01", "AAA1111", sdf.parse("30/06/2021"), "07:00", "10:00", 5.0));
			registros.add(new Estacionamento(getLastId(),"C02", "AAA2222", sdf.parse("30/06/2021"), "07:00", "10:00", 5.0));
			registros.add(new Estacionamento(getLastId(),"C05", "AAA3333", sdf.parse("30/06/2021"), "08:00", "11:00", 5.0));
			registros.add(new Estacionamento(getLastId(),"C04", "AAA4444", sdf.parse("30/06/2021"), "08:00", "16:00", 5.0));
			registros.add(new Estacionamento(getLastId(),"C03", "AAA5555", sdf.parse("30/06/2021"), "09:00", "15:00", 5.0));
			registros.add(new Estacionamento(getLastId(),"C06", "AAA6666", sdf.parse("30/06/2021"), "09:00", "14:00", 5.0));
			registros.add(new Estacionamento(getLastId(),"C08", "AAA7777", sdf.parse("30/06/2021"), "10:00", "12:00", 5.0));
			registros.add(new Estacionamento(getLastId(),"M01", "AAA8888", sdf.parse("30/06/2021"), "10:00", "11:00", 3.0));
			registros.add(new Estacionamento(getLastId(),"M02", "AAA9999", sdf.parse("30/06/2021"), "11:00", "12:00", 3.0));
			registros.add(new Estacionamento(getLastId(),"C01", "AAA0000", new Date(), "07:00", "10:00", 5.0));
			registros.add(new Estacionamento(getLastId(),"C02", "AAA1111", new Date(), "07:00", "", 5.0));
			registros.add(new Estacionamento(getLastId(),"C03", "AAA2222", new Date(), "08:00", "", 5.0));
			registros.add(new Estacionamento(getLastId(),"C07", "AAA3333", new Date(), "09:00", "", 5.0));
			registros.add(new Estacionamento(getLastId(),"M01", "AAA4444", new Date(), "08:00", "", 3.0));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static int getLastId() {
		if(registros.size() == 0) {
			return 1;
		}else {
			return registros.get(registros.size() - 1).getId() + 1;
		}
	} 
}
