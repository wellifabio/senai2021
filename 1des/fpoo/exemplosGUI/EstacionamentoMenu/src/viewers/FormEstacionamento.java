package viewers;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controllers.ProcessaEstacionamento;
import models.Estacionamento;

public class FormEstacionamento extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Painel painel;
	private ImageIcon img = new ImageIcon("./assets/planta.png");
	private JMenuBar barraMenu = new JMenuBar();
	private JMenu menuArquivo, menuSistema;
	private JMenuItem itemBD, itemRelatorios, itemSair;
	private ArrayList<JButton> carros = new ArrayList<>();
	private ArrayList<JButton> motos = new ArrayList<>();
	private SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat hora = new SimpleDateFormat("hh:mm");

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

		desenhaVeiculos();
	}

	private void desenhaVeiculos() {
		ProcessaEstacionamento.obterEstacionados();
		ProcessaEstacionamento.preencherVagas();
		for (int i = 1; i <= 8; i++) {
			JButton c = new JButton();
			if (i < 5) {
				c.setBounds(i * 100 - 60, 50, 65, 121);
			} else {
				c.setBounds((850 - i * 100), 230, 65, 121);
			}
			c.setIcon(ProcessaEstacionamento.carros.get(i - 1).getImg());
			c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			c.setContentAreaFilled(false);
			c.setBorderPainted(false);
			c.addActionListener(this);
			painel.add(c);
			carros.add(c);
		}
		for (int i = 1; i <= 3; i++) {
			JButton m = new JButton();
			m.setBounds(470, i * 70 - 65, 75, 75);
			m.setIcon(ProcessaEstacionamento.motos.get(i - 1).getImg());
			m.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			m.setContentAreaFilled(false);
			m.setBorderPainted(false);
			m.addActionListener(this);
			painel.add(m);
			motos.add(m);
		}
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
		} else if (e.getSource() == itemSair) {
			JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso sistema.");
			dispose();
		} else if (e.getSource() == carros.get(0)) {
			try {
				if (ProcessaEstacionamento.carros.get(0).isStatus()) {
					ProcessaEstacionamento.estacionamentos.get(ProcessaEstacionamento.estacionamentos.indexOf(new Estacionamento(ProcessaEstacionamento.obterPlaca("C01"),
							data.parse(data.format(new Date()))))).setHoraSaida(hora.format(new Date()));
					dispose();
					new FormEstacionamento().setVisible(true);					
				} else {
					Estacionamento est = new Estacionamento("C01", JOptionPane.showInputDialog("Digite a Placa"),
							data.parse(data.format(new Date())), hora.format(new Date()), "", 5);
					ProcessaEstacionamento.estacionamentos.add(est);
					dispose();
					new FormEstacionamento().setVisible(true);
				}
			} catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			for (Estacionamento es : ProcessaEstacionamento.estacionados) {
				System.out.print(es.toString());
			}
		}

	}

	public static void main(String[] args) {
		// ProcessaEstacionamento.abrir();
		ProcessaEstacionamento.preencherTestes();
		new FormEstacionamento().setVisible(true);
	}

}
