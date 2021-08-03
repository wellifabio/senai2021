package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ProcessaPontos;

public class DialogMapa extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private PanelDrag imgs;
	private JButton exportar, cancelar;
	private BufferedImage jImg;

	DialogMapa() {
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Arraste e solte os objetos para mapear sua rede");
		setIconImage(new ImageIcon("./assets/switch.png").getImage());
		setSize(1300,700);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);
		setLocationRelativeTo(null);

		imgs = new PanelDrag(ProcessaPontos.pontos);
		imgs.setBounds(5, 5, 1274, 615);
		panel.add(imgs);

		exportar = new JButton("Exportar");
		exportar.setBounds(533, 625, 120, 30);
		exportar.addActionListener(this);
		panel.add(exportar);

		cancelar = new JButton("Cancelar");
		cancelar.setBounds(658, 625, 120, 30);
		cancelar.addActionListener(this);
		panel.add(cancelar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exportar) {
			jImg = new BufferedImage(imgs.getWidth(), imgs.getHeight(), BufferedImage.TYPE_INT_ARGB);
			imgs.paint(jImg.createGraphics());
			try {
				ImageIO.write(jImg, "png", new File("./assets/mapa.png"));
				JOptionPane.showMessageDialog(this,
						"Esta imagem foi salva como \"mapa.png\" e está na pasta \"./assets/\" deste projeto.");
				dispose();
			} catch (IOException erro) {
				System.out.println("Erro ao salvar imagem: " + erro);
			}
		} else {
			dispose();
		}
	}

}
