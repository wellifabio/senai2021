package viewers;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controllers.EstacionamentoProcess;
import models.Estacionamento;
import models.Vaga;

public class FormEstacionamento extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Painel painel;
	private ImageIcon img = new ImageIcon("./assets/planta.png");
	private JMenuBar barraMenu = new JMenuBar();
	private JMenu menuArquivo, menuSistema;
	private JMenuItem itemBD, itemRelatorios, itemSair;
	private ArrayList<JButton> carros = new ArrayList<>();
	private ArrayList<JButton> motos = new ArrayList<>();
	private SimpleDateFormat hora = new SimpleDateFormat("HH:mm");

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
		EstacionamentoProcess.obterEstacionados();
		EstacionamentoProcess.preencherVagas();
		for (int i = 1; i <= 8; i++) {
			JButton c = new JButton();
			JLabel p = new JLabel(EstacionamentoProcess.carros.get(i - 1).getPlaca());
			if (i < 5) {
				p.setBounds(i * 100 - 53, 65, 70, 20);
				c.setBounds(i * 100 - 60, 50, 65, 121);
			} else {
				c.setBounds((850 - i * 100), 230, 65, 121);
				p.setBounds((858 - i * 100), 312, 70, 20);
			}
			c.setIcon(EstacionamentoProcess.carros.get(i - 1).getImg());
			c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			c.setContentAreaFilled(false);
			c.setBorderPainted(false);
			c.addActionListener(this);
			painel.add(p);
			painel.add(c);
			carros.add(c);
		}
		for (int i = 1; i <= 3; i++) {
			JButton m = new JButton();
			JLabel p = new JLabel(EstacionamentoProcess.motos.get(i - 1).getPlaca());
			m.setBounds(470, i * 70 - 65, 75, 75);
			p.setBounds(470, i * 70 - 65, 75, 75);
			m.setIcon(EstacionamentoProcess.motos.get(i - 1).getImg());
			m.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			m.setContentAreaFilled(false);
			m.setBorderPainted(false);
			m.addActionListener(this);
			painel.add(p);
			painel.add(m);
			motos.add(m);
		}
		listar();
	}

	private class Painel extends JPanel {
		private static final long serialVersionUID = 1L;

		protected void paintComponent(final Graphics g) {
			super.paintComponent(g);
			g.drawImage(img.getImage(), 0, 0, this);
		}
	}

	private void registraVaga(Vaga vaga) {
		if (vaga.getPlaca().length() > 0) {
			if(JOptionPane.showConfirmDialog(this, "Confirma saída do veículo "+ vaga.getPlaca() +" as "+hora.format(new Date())) == 0) {
				EstacionamentoProcess.registros.get(vaga.getIndice()).setHoraSaida(hora.format(new Date()));
			}
			dispose();
			new FormEstacionamento().setVisible(true);
		} else {
			String placa = JOptionPane.showInputDialog("Digite a Placa").toUpperCase();
			if (placa.length() == 7) {
				Estacionamento est = new Estacionamento(EstacionamentoProcess.getLastId(),vaga.getCodigo(), placa, new Date(), hora.format(new Date()),
						"", 5);
				EstacionamentoProcess.registros.add(est);
				dispose();
				new FormEstacionamento().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Placa inválida");
			}
		}

	}

	void listar() {
		System.out.println("-----");
		for (Estacionamento r : EstacionamentoProcess.registros) {
			System.out.print(r.toString());
		}
		System.out.println("-----");
		for (Estacionamento es : EstacionamentoProcess.estacionados) {
			System.out.print(es.toString());
		}
		System.out.println("-----");
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
			registraVaga(EstacionamentoProcess.carros.get(0));
		} else if (e.getSource() == carros.get(1)) {
			registraVaga(EstacionamentoProcess.carros.get(1));
		} else if (e.getSource() == carros.get(2)) {
			registraVaga(EstacionamentoProcess.carros.get(2));
		} else if (e.getSource() == carros.get(3)) {
			registraVaga(EstacionamentoProcess.carros.get(3));
		} else if (e.getSource() == carros.get(4)) {
			registraVaga(EstacionamentoProcess.carros.get(4));
		} else if (e.getSource() == carros.get(5)) {
			registraVaga(EstacionamentoProcess.carros.get(5));
		} else if (e.getSource() == carros.get(6)) {
			registraVaga(EstacionamentoProcess.carros.get(6));
		} else if (e.getSource() == carros.get(7)) {
			registraVaga(EstacionamentoProcess.carros.get(7));
		} else if (e.getSource() == motos.get(0)) {
			registraVaga(EstacionamentoProcess.motos.get(0));
		} else if (e.getSource() == motos.get(1)) {
			registraVaga(EstacionamentoProcess.motos.get(1));
		} else if (e.getSource() == motos.get(2)) {
			registraVaga(EstacionamentoProcess.motos.get(2));
		}
	}

	public static void main(String[] args) {
		// ProcessaEstacionamento.abrir();
		Locale.setDefault(new Locale("pt", "BR"));
		EstacionamentoProcess.preencherTestes();
		new FormEstacionamento().setVisible(true);
	}

}
