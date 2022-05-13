package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelLinhaIMG extends JPanel {
	private static final long serialVersionUID = 1L;
	private Point ponto;
	private Posicao p1 = null, p2 = null;
	private ImageIcon pc = new ImageIcon(new ImageIcon("./assets/pc.png").getImage().getScaledInstance(100, 100, 100));
	private Image imgPc = pc.getImage();

	public PanelLinhaIMG() {
		
		setBounds(20, 50, 840, 490);
		
		addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				try {
					ponto = getMousePosition();
					p1 = new Posicao(ponto.x, ponto.y);
				} catch (Exception er) {
				}
			}

			public void mouseReleased(MouseEvent e) {
				try {
					ponto = getMousePosition();
					p2 = new Posicao(ponto.x, ponto.y);
				} catch (Exception er) {
				}
				repaint();
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}
		});
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, 840, 490);
		g.setColor(Color.BLUE);
		if (p1 != null && p2 != null) {
			g.clearRect(0, 0, 840, 490);
			g.drawImage(imgPc,p1.getX(),p1.getY(),this);
			g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
	}
}
