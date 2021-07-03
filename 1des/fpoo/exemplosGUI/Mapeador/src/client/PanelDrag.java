package client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import domain.Ponto;

public class PanelDrag extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Ponto> pontos = new ArrayList<>();
	private ArrayList<ImageIcon> imgs = new ArrayList<>();
	private ArrayList<Point> cantoImg = new ArrayList<>();
	private Point prevPoint, currPt;
	private int totColunas = 6, dim = 100;

	PanelDrag(ArrayList<Ponto> pontos) {
		this.pontos = pontos;
		if(pontos.size() <= 35) {
			totColunas = 6;
			dim = 100;
		}else {
			totColunas = 8;
			dim = 50;	
		}
		int x = 0, y = 0;
		for (Ponto p : pontos) {
			imgs.add(new ImageIcon(new ImageIcon("./assets/" + p.getIcone().toLowerCase() + ".png").getImage()
					.getScaledInstance(dim, dim, 100)));
			cantoImg.add(new Point(x, y));
			if (x == (totColunas * 150)) {
				y += 100;
				x = 0;
			} else {
				x += 100;
			}
		}
		Click click = new Click();
		Drag drag = new Drag();
		addMouseListener(click);
		addMouseMotionListener(drag);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
	}

	public class Click extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			prevPoint = e.getPoint();
		}
	}

	public class Drag extends MouseMotionAdapter {
		public void mouseDragged(MouseEvent e) {
			currPt = e.getPoint();
			for (Point p : cantoImg) {
				if (e.getX() >= p.getX() && e.getX() < (p.getX() + dim) && e.getY() >= p.getY()
						&& e.getY() < (p.getY() + dim)) {
					p.translate((int) (currPt.getX() - prevPoint.getX()), (int) (currPt.getY() - prevPoint.getY()));
					prevPoint = currPt;
				}
				repaint();
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < pontos.size(); i++) {
			if (pontos.get(i).getPai() != null && !pontos.get(i).getPai().equals("")) {
				g.setColor(Color.BLUE);
				int indiceDestino = pontos.indexOf(new Ponto(pontos.get(i).getPai()));
				g.drawLine((int) cantoImg.get(i).getX() + dim/2, (int) cantoImg.get(i).getY() + dim/2,
						(int) cantoImg.get(indiceDestino).getX() + dim/2, (int) cantoImg.get(indiceDestino).getY() + dim/2);
				g.drawString(pontos.get(i).getId(), (int) cantoImg.get(i).getX(), (int) cantoImg.get(i).getY() + dim / 5);
			}
			g.setColor(Color.GRAY);
			g.drawLine((int) cantoImg.get(i).getX(), (int) cantoImg.get(i).getY() + dim,
					(int) cantoImg.get(i).getX() + dim, (int) cantoImg.get(i).getY() + dim);
			g.setColor(Color.BLACK);
			g.drawString("|| " + pontos.get(i).getDescricao(), (int) cantoImg.get(i).getX() - 1,
					(int) cantoImg.get(i).getY() + dim - 2);
		}
		int indice = 0;
		for (ImageIcon i : imgs) {
			i.paintIcon(this, g, (int) cantoImg.get(indice).getX(), (int) cantoImg.get(indice).getY());
			indice++;
		}
	}
}
