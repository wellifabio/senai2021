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
	private ArrayList<ImageIcon> imgs = new ArrayList<>();
	private ArrayList<Point> cantoImg = new ArrayList<>();
	private Point prevPoint, currPt;

	PanelDrag(ArrayList<Ponto> pontos) {
		int x = 0, y = 0;
		for (Ponto p : pontos) {
			imgs.add(new ImageIcon(new ImageIcon(p.getIcone()).getImage().getScaledInstance(100, 100, 100)));
			cantoImg.add(new Point(x, y));
			if (x == 300) {
				y += 100;
				x = 0;
			} else {
				x = 300;
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
				if (e.getX() >= p.getX() && e.getX() < (p.getX() + 150) && e.getY() >= p.getY()
						&& e.getY() < (p.getY() + 150)) {
					p.translate((int) (currPt.getX() - prevPoint.getX()), (int) (currPt.getY() - prevPoint.getY()));
					prevPoint = currPt;
				}
				repaint();
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int indice = 0;
		for (ImageIcon i : imgs) {
			i.paintIcon(this, g, (int) cantoImg.get(indice).getX(), (int) cantoImg.get(indice).getY());
			indice++;
		}
	}
}
