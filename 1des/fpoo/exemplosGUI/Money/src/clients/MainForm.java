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
	private JPanel mainPanel, cashPanel, coinPanel;
	private JTextArea text;
	private JLabel orientacao;
	private JTextField entrada;
	private JButton bContar;
	private String[] vals;
	private JLabel[] imgCashs, imgCoins;

	MainForm() {
		// Configurações básicas do Frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Contando Dinheiro");
		img = new ImageIcon("./assets/m25.png");
		setIconImage(img.getImage());
		setBounds(100, 100, 950, 660);
		mainPanel = new JPanel();
		//mainPanel.setBackground(Color.WHITE);
		setContentPane(mainPanel);
		setLayout(null);
		// setLayout(new FlowLayout());
		// setLayout(new BorderLayout());
		// setLayout(new GridLayout(5,5));

		// Campo de entrada e botão de ação
		orientacao = new JLabel("Digite o montante ex: 175,45");
		orientacao.setBounds(25, 20, 300, 30);
		mainPanel.add(orientacao);
		entrada = new JTextField("388,90");
		entrada.setBounds(20, 50, 300, 30);
		mainPanel.add(entrada);
		bContar = new JButton("Contar");
		bContar.setBounds(20, 90, 300, 30);
		mainPanel.add(bContar);
		bContar.addActionListener(this);

		// Àrea de texto para SAÍDA
		text = new JTextArea();
		text.setBounds(20, 130, 300, 380);
		text.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		mainPanel.add(text);

		// Painel para exibir as imagens das Notas
		cashPanel = new JPanel();
		cashPanel.setBounds(340, 20, 570, 490);
		cashPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.GRAY));
		mainPanel.add(cashPanel);

		// Painel para exibir as imagens das Moedas
		coinPanel = new JPanel();
		coinPanel.setBounds(20, 520, 890, 80);
		coinPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.GRAY));
		mainPanel.add(coinPanel);

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
		if (!entrada.getText().isEmpty()) {
			if (entrada.getText().contains(",")) {
				vals = entrada.getText().split(",");
				int val1 = Integer.valueOf(vals[0]); //Converte de String para int
				int val2 = Integer.valueOf(vals[1]); //Converte de String para int
				ProcessMoney.contCashs(val1);
				ProcessMoney.contCoins(val2);
			} else {
				ProcessMoney.contCashs(Integer.valueOf(entrada.getText()));
			}
			return true;
		} else {
			return false;
		}
	}

	private void showMoney() {
		this.repaint();
		imgCashs = new JLabel[ProcessMoney.contCashs()];
		imgCoins = new JLabel[ProcessMoney.contCoins()];
		cashPanel.removeAll();
		coinPanel.removeAll();
		int i = 0;
		for (Cash c : ProcessMoney.cashs) {
			if (c.getQtd() > 0) {
				img = new ImageIcon(new ImageIcon(c.getImg()).getImage().getScaledInstance(250, 114, 100));
				imgCashs[i] = new JLabel("x " + c.getQtd());
				imgCashs[i].setIcon(img);
				cashPanel.add(imgCashs[i]);
				i++;
			}
		}
		i = 0;
		for (Coin c : ProcessMoney.coins) {
			if (c.getQtd() > 0) {
				img = new ImageIcon(new ImageIcon(c.getImg()).getImage().getScaledInstance(70, 70, 100));
				imgCoins[i] = new JLabel("x " + c.getQtd());
				imgCoins[i].setIcon(img);
				coinPanel.add(imgCoins[i]);
				i++;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bContar) {
			ProcessMoney.fillCashs();
			ProcessMoney.fillCoins();
			if (calc()) {
				text.setText(listAll());
				showMoney();
			}
		}
	}
}
