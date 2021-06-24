package client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelDrag extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon[] imgs;
	private Point[] cantoImg;
	private Point prevPoint, currPt;

	PanelDrag(String[] path) {
		imgs = new ImageIcon[path.length];
		cantoImg = new Point[path.length];
		int x = 0;
		for (int i = 0; i < path.length; i++) {
			imgs[i] = new ImageIcon(new ImageIcon(path[i]).getImage().getScaledInstance(100, 100, 100));
			cantoImg[i] = new Point(x, 0);
			x += 100;
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
			for (int i = 0; i < imgs.length; i++) {
				if (e.getX() >= cantoImg[i].getX() && e.getX() < (cantoImg[i].getX() + 150)
						&& e.getY() >= cantoImg[i].getY() && e.getY() < (cantoImg[i].getY() + 150)) {
					cantoImg[i].translate((int) (currPt.getX() - prevPoint.getX()),
							(int) (currPt.getY() - prevPoint.getY()));
					prevPoint = currPt;
				}
				repaint();
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("Vetor de " + imgs.length);
		for (int i = 0; i < imgs.length; i++) {
			imgs[i].paintIcon(this, g, (int) cantoImg[i].getX(), (int) cantoImg[i].getY());
			System.out.println("cantoImg x = " + (int) cantoImg[i].getX() + " y = " + (int) cantoImg[i].getY());
		}
	}
}
