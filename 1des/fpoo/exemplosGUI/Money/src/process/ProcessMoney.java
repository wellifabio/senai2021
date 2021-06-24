package process;

import java.util.ArrayList;

import domains.Cash;
import domains.Coin;

public class ProcessMoney {

	public static ArrayList<Cash> cashs;
	public static ArrayList<Coin> coins;

	public static void fillCashs() {
		cashs = new ArrayList<>();
		cashs.add(new Cash(200, 0, "duzentos", "./assets/c200b.jpg"));
		cashs.add(new Cash(100, 0, "cem", "./assets/c100b.jpg"));
		cashs.add(new Cash(50, 0, "ciquenta", "./assets/c50b.jpg"));
		cashs.add(new Cash(20, 0, "vinte", "./assets/c20b.jpg"));
		cashs.add(new Cash(10, 0, "dez", "./assets/c10b.jpg"));
		cashs.add(new Cash(5, 0, "cinco", "./assets/c05b.jpg"));
		cashs.add(new Cash(2, 0, "dois", "./assets/c02b.jpg"));
	}

	public static void fillCoins() {
		coins = new ArrayList<>();
		coins.add(new Coin(100, 0, "um", "./assets/m1.png"));
		coins.add(new Coin(50, 0, "ciquenta", "./assets/m50.png"));
		coins.add(new Coin(25, 0, "vinte e cinco", "./assets/m25.png"));
		coins.add(new Coin(10, 0, "dez", "./assets/m10.png"));
		coins.add(new Coin(5, 0, "cinco", "./assets/m05.png"));
		
	}
	
	public static void contCashs(int value) {
		while(value > 0) {
			for(Cash c: cashs) {
				if(value >= c.getVal()) {
					value -= c.getVal();
					c.setQtd(c.getQtd()+1);
					break;
				}
			}
			if (value == 1) {
				value = 0;
				coins.get(0).setQtd(coins.get(0).getQtd()+1);
				break;
			}
		}
	}
	
	public static int contCashs() {
		int tot = 0;
		for(Cash c: cashs) {
			if(c.getQtd() > 0) {
				tot++;
			}
		}
		return tot;
	}
	
	public static void contCoins(int value) {
		while(value >= 5) {
			for(Coin c: coins) {
				if(value >= c.getVal()) {
					value -= c.getVal();
					c.setQtd(c.getQtd()+1);
					break;
				}
			}
		}
	}
	
	public static int contCoins() {
		int tot = 0;
		for(Coin c: coins) {
			if(c.getQtd() > 0) {
				tot++;
			}
		}
		return tot;
	}
}
