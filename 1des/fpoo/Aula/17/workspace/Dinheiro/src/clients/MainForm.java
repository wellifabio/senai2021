package clients;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import domains.Cash;
import domains.Coin;
import process.ProcessMoney;

public class MainForm extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ImageIcon img;
	private JPanel panel;
	private JTextArea text;
	private JLabel orientacao;
	private JTextField entrada;
	private JButton bContar;
	private String valor;
	private String[] valores;
	private JLabel[] imgCashs, imgCoins;

	MainForm() {
		// Configurações básicas do Frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Contando Dinheiro");
		img = new ImageIcon("./assets/m1.png");
		setIconImage(img.getImage());
		setBounds(100, 100, 900, 480);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);

		// Campo de entrada e botão de ação
		orientacao = new JLabel("Digite o montante ex: 175,45");
		orientacao.setBounds(25, 20, 300, 30);
		panel.add(orientacao);
		entrada = new JTextField();
		entrada.setBounds(20, 50, 300, 30);
		panel.add(entrada);
		bContar = new JButton("Contar");
		bContar.setBounds(20, 90, 300, 30);
		panel.add(bContar);
		bContar.addActionListener(this);

		// Àrea de texto para SAÍDA
		text = new JTextArea();
		text.setBounds(20, 130, 300, 200);
		text.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		panel.add(text);
	}

	private String listAll() {
		String txt = "";
		for (Cash c : ProcessMoney.cashs) {
			txt += c.toString() + "\n";
		}
		for (Coin c : ProcessMoney.coins) {
			txt += c.toString() + "\n";
		}
		return txt;
	}

	private boolean calc() {
		valor = entrada.getText();
		if (valor != "") {
			if (valor.contains(",")) {
				valores = valor.split(",");
				ProcessMoney.contCashs(Integer.valueOf(valores[0]));
				ProcessMoney.contCoins(Integer.valueOf(valores[1]));
			} else {
				ProcessMoney.contCashs(Integer.valueOf(valor));
			}
			return true;
		} else {
			return false;
		}
	}

	private void showCash() {
		setLayout(null);
		imgCashs = new JLabel[ProcessMoney.contCashs()];
		int x = 400, y = 20;
		for (JLabel l : imgCashs) {
			l = new JLabel();
			l.setText(valor);
			l.setBounds(x, y, 50, 50);
			x += 20;
			y += 20;
			panel.add(l);
		}

		imgCoins = new JLabel[ProcessMoney.contCoins()];
		x = 20;
		y = 400;
		for (JLabel l : imgCoins) {
			l = new JLabel();
			l.setBounds(x, y, 50, 50);
			x += 20;
			y += 20;
			panel.add(l);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bContar) {
			ProcessMoney.fillCashs();
			ProcessMoney.fillCoins();
			if (calc()) {
				text.setText(listAll());
				showCash();
			}
		}
	}
}
