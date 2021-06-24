package controller;

import java.util.ArrayList;

import domain.Ponto;

public class ProcessaPontos {
	
	public static ArrayList<Ponto> pontos = new ArrayList<>();
	
	public static void preencheTestes() {
		pontos.add(new Ponto("RK01PT00","Switch Principal","./assets/switch.png","TI","TI",new Ponto()));
		pontos.add(new Ponto("RK01PT01","Switch Principal","./assets/pc.png","TI","TI",pontos.get(0)));
		pontos.add(new Ponto("RK01PT02","Switch Principal","./assets/pc.png","TI","TI",pontos.get(0)));
		pontos.add(new Ponto("RK01PT03","Switch Principal","./assets/pc.png","TI","TI",pontos.get(0)));
		pontos.add(new Ponto("RK01PT04","Switch Principal","./assets/switch.png","TI","TI",pontos.get(0)));
		pontos.add(new Ponto("RK02PT01","Switch Principal","./assets/pc.png","TI","TI",pontos.get(4)));
		pontos.add(new Ponto("RK02PT02","Switch Principal","./assets/pc.png","TI","TI",pontos.get(4)));
		pontos.add(new Ponto("RK02PT03","Switch Principal","./assets/pc.png","TI","TI",pontos.get(4)));
	}
}
