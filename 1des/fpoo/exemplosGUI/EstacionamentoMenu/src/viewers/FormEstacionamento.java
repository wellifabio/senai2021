package viewers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controllers.ProcessaEstacionamento;

public class FormEstacionamento extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Painel painel;
	private ImageIcon img = new ImageIcon("./assets/planta.png"), carro = new ImageIcon("./assets/carro.png"),
			moto = new ImageIcon("./assets/moto.png");
	private JMenuBar barraMenu = new JMenuBar();
	private JMenu menuArquivo, menuSistema;
	private JMenuItem itemBD, itemRelatorios, itemSair;
	private JButton vc1;

	FormEstacionamento() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("./assets/moto.png").getImage());
		setTitle("Estacionamento \"Bunitinho\"");
		setSize(615, 485);
		painel = new Painel();
		setJMenuBar(barraMenu);
		setContentPane(painel);
		setLocationRelativeTo(null);
		setLayout(null);

		// Barra de Menús
		menuArquivo = new JMenu("Arquivo");
		menuSistema = new JMenu("Sistema");
		barraMenu.add(menuArquivo);
		barraMenu.add(menuSistema);
		itemBD = new JMenuItem("Banco de Dados");
		itemRelatorios = new JMenuItem("Relatórios");
		itemSair = new JMenuItem("Sair do Sistema");
		menuArquivo.add(itemBD);
		menuSistema.add(itemRelatorios);
		menuSistema.add(itemSair);

		// Ações do Menú
		itemBD.addActionListener(this);
		itemRelatorios.addActionListener(this);
		itemSair.addActionListener(this);

		vc1 = new JButton("");
		vc1.setBackground(new Color(1f,1f,1f,.5f ));
		vc1.setBounds(50, 50, 65, 121);
		painel.add(vc1);
	}

	private class Painel extends JPanel {
		private static final long serialVersionUID = 1L;

		protected void paintComponent(final Graphics g) {
			super.paintComponent(g);
			g.drawImage(img.getImage(), 0, 0, this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == itemBD) {
			new FormCRUD().setModal(true);
		} else if (e.getSource() == itemRelatorios) {
			new FormRelatorio().setModal(true);
		} else {
			dispose();
		}
	}

	public static void main(String[] args) {
		// ProcessaEstacionamento.abrir();
		ProcessaEstacionamento.preencherTestes();
		new FormEstacionamento().setVisible(true);
	}

}
