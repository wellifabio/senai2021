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
		setSize(800, 600);
		painel = new JPanel();
		setContentPane(painel);
		setLocationRelativeTo(null);
		setLayout(null);

		texto = new JTextArea(listarTodas());
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

		add = new JButton("Add");
		add.setBounds(300, 430, 100, 30);
		painel.add(add);
		add.addActionListener(this);

		alterar = new JButton("Alterar");
		alterar.setBounds(400, 430, 100, 30);
		painel.add(alterar);
		alterar.addActionListener(this);

		excluir = new JButton("Excluir");
		excluir.setBounds(500, 430, 100, 30);
		painel.add(excluir);
		excluir.addActionListener(this);

	}

	private String listarTodas() {
		String acumulador = "Origem\tDestino\tDistância\tTempo\tVelocidade\n";
		for (Viagem v : ProcessaViagens.viagens) {
			acumulador += v.toString();
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
		} else if (e.getSource() == cancelar) {
			dispose();
		} else if (e.getSource() == add) {
			String[] campos = JOptionPane
					.showInputDialog("Preencha (Origem,Destino,Distancia,Tempo) separados por virgula").split(",");
			ProcessaViagens.viagens
					.add(new Viagem(campos[0], campos[1], Integer.valueOf(campos[2]), Integer.valueOf(campos[3])));
			texto.setText(listarTodas());
		} else if (e.getSource() == alterar) {
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
		} else {
			indice = Integer.valueOf(JOptionPane.showInputDialog("Qual o índice a ser alterado"));
			if (indice < ProcessaViagens.viagens.size()) {
				ProcessaViagens.viagens.remove(indice);
				texto.setText(listarTodas());
			} else {
				JOptionPane.showMessageDialog(this, "Indice Inválido");
			}
		}
	}

	public static void main(String[] args) {
		ProcessaViagens.abrirDAO();
		new FormViagens().setVisible(true);
	}

}
