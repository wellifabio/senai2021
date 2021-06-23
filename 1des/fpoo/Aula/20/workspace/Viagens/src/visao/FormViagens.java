package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controle.ProcessaViagens;
import modelo.Viagem;

public class FormViagens extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTextArea texto;
	private JButton salvar, cancelar, add, alterar, excluir;
	private int indice;

	FormViagens() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Registro de Viagens");
		setSize(800, 520);
		painel = new JPanel();
		setContentPane(painel);
		setLocationRelativeTo(null);
		setLayout(null);

		texto = new JTextArea(listarTodas());
		texto.setEditable(false);
		texto.setBounds(20, 20, 745, 400);
		texto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
		painel.add(texto);

		salvar = new JButton("Salvar");
		salvar.setBounds(20, 430, 120, 30);
		painel.add(salvar);
		salvar.addActionListener(this);

		cancelar = new JButton("Cancelar");
		cancelar.setBounds(150, 430, 120, 30);
		painel.add(cancelar);
		cancelar.addActionListener(this);

		add = new JButton("Adicionar");
		add.setBounds(465, 430, 100, 30);
		painel.add(add);
		add.addActionListener(this);

		alterar = new JButton("Alterar");
		alterar.setBounds(565, 430, 100, 30);
		painel.add(alterar);
		alterar.addActionListener(this);

		excluir = new JButton("Excluir");
		excluir.setBounds(665, 430, 100, 30);
		painel.add(excluir);
		excluir.addActionListener(this);

	}

	private String listarTodas() {
		String acumulador = "Indice\tOrigem\tDestino\tDistância\tTempo\tVelocidade\n";
		int i = 0;
		for (Viagem v : ProcessaViagens.viagens) {
			acumulador += i + "\t" + v.toString();
			i++;
		}
		acumulador += "Horas de voo: " + ProcessaViagens.totalTempo();
		return acumulador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvar) {
			if (ProcessaViagens.salvarDAO()) {
				JOptionPane.showMessageDialog(this, "Viagens salvas com sucesso.");
			} else {
				JOptionPane.showMessageDialog(this, "Erro ao salvar dados em arquivo");
			}
			dispose();
		} else if (e.getSource() == cancelar) {
			dispose();
		} else if (e.getSource() == add) {
			adicionar();
		} else if (e.getSource() == alterar) {
			alterar();
		} else {
			excluir();
		}
	}

	private void excluir() {
		indice = Integer.valueOf(JOptionPane.showInputDialog("Qual o índice a ser alterado"));
		if (indice < ProcessaViagens.viagens.size()) {
			ProcessaViagens.viagens.remove(indice);
			texto.setText(listarTodas());
		} else {
			JOptionPane.showMessageDialog(this, "Indice Inválido");
		}
		texto.setText(listarTodas());
	}

	private void alterar() {
		indice = Integer.valueOf(JOptionPane.showInputDialog("Qual o índice a ser alterado"));
		if (indice < ProcessaViagens.viagens.size()) {
			String[] campos = JOptionPane
					.showInputDialog("Preencha (Origem,Destino,Distancia,Tempo) separados por virgula").split(",");
			ProcessaViagens.viagens.set(indice,
					new Viagem(campos[0], campos[1], Integer.valueOf(campos[2]), Integer.valueOf(campos[3])));
			texto.setText(listarTodas());
		} else {
			JOptionPane.showMessageDialog(this, "Indice Inválido");
		}
		texto.setText(listarTodas());
	}

	private void adicionar() {
		String[] campos = JOptionPane
				.showInputDialog("Preencha (Origem,Destino,Distancia,Tempo) separados por virgula").split(",");
		ProcessaViagens.viagens
				.add(new Viagem(campos[0], campos[1], Integer.valueOf(campos[2]), Integer.valueOf(campos[3])));
		texto.setText(listarTodas());	
	}

	public static void main(String[] args) {
		//ProcessaViagens.preencherTeste();
		ProcessaViagens.abrirDAO();
		new FormViagens().setVisible(true);
	}

}
