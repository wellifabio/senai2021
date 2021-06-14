package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DragPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon pc = new ImageIcon(new ImageIcon("./assets/pc.png").getImage().getScaledInstance(150, 150, 100));
	private Point cantoPc;
	private Point prevPt;

	DragPanel() {
		cantoPc = new Point(0, 0);
		Click click = new Click();
		Drag drag = new Drag();
		addMouseListener(click);
		addMouseMotionListener(drag);
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.RED));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		pc.paintIcon(this, g, (int) cantoPc.getX(), (int) cantoPc.getY());
	}

	public class Click extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			prevPt = e.getPoint();
		}
	}

	public class Drag extends MouseMotionAdapter {
		public void mouseDragged(MouseEvent e) {
			Point currPt = e.getPoint();

			// * Arrastando ao clicar em qualquer lugar da tela
			// cantoImg.translate((int) (currPt.getX() - prevPt.getX()), (int)
			// (currPt.getY() - prevPt.getY()));
			// prevPt = currPt;
			// repaint();

			// Arrastando somente se clicar na imagem
			if (e.getX() >= cantoPc.getX() && e.getX() < (cantoPc.getX() + 150) && e.getY() >= cantoPc.getY()
					&& e.getY() < (cantoPc.getY() + 150)) {
				cantoPc.translate((int) (currPt.getX() - prevPt.getX()), (int) (currPt.getY() - prevPt.getY()));
				prevPt = currPt;
				repaint();
			}
		}
	}

}
