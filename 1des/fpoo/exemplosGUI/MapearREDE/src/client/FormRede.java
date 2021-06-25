package client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.ProcessaPontos;
import domain.Ponto;

public class FormRede extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTextArea texto;
	private JButton salvar, cancelar, add, alterar, excluir, mapa;
	private String id;

	FormRede() {
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
		
		mapa = new JButton("Desenhar Mapa");
		mapa.setBounds(292, 430, 150, 30);
		painel.add(mapa);
		mapa.addActionListener(this);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvar) {
			if (ProcessaPontos.salvar()) {
				JOptionPane.showMessageDialog(this, "Registros salvos com sucesso.");
			} else {
				JOptionPane.showMessageDialog(this, "Erro ao salvar dados em arquivo");
			}
			dispose();
		} else if (e.getSource() == mapa) {
			new DialogMapa().setVisible(true);
		}else if (e.getSource() == excluir) {
			excluir();
		} else if (e.getSource() == add) {
			adicionar();
		} else if (e.getSource() == alterar) {
			alterar();
		} else {
			dispose();
		}
	}

	private String listarTodas() {
		String acumulador = "Id\tDescrição\tÍcone\tOrigem\tDestino\tPai\n";
		for (Ponto p : ProcessaPontos.pontos) {
			acumulador += p.toString();
		}
		return acumulador;
	}

	private void adicionar() {
		try {
			String[] campos = JOptionPane.showInputDialog("(Id,Descrição,Ícone,Origem,Destino,Pai").split(",");
			ProcessaPontos.pontos.add(new Ponto(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5]));
			texto.setText(listarTodas());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao preencher dados");
		}
	}

	private void alterar() {
		try {
			id = JOptionPane.showInputDialog("Qual o ID a ser alterado");
			Ponto p = new Ponto(id);
			if (ProcessaPontos.pontos.contains(p)) {
				String[] campos = JOptionPane.showInputDialog("Descrição,Ícone,Origem,Destino,Pai").split(",");
				p = new Ponto(id, campos[0], campos[1], campos[2], campos[3], campos[4]);
				ProcessaPontos.pontos.set(ProcessaPontos.pontos.indexOf(p), p);
				texto.setText(listarTodas());
			} else {
				JOptionPane.showMessageDialog(this, "ID Inválido");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao preencher dados");
		}
		texto.setText(listarTodas());
	}

	private void excluir() {
		try {
			id = JOptionPane.showInputDialog("Qual o ID a ser excluído");
			Ponto p = new Ponto(id);
			if (ProcessaPontos.pontos.contains(p)) {
				ProcessaPontos.pontos.remove(ProcessaPontos.pontos.indexOf(p));
				texto.setText(listarTodas());
			} else {
				JOptionPane.showMessageDialog(this, "ID Inválido");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao preencher dados");
		}
		texto.setText(listarTodas());
	}

	public static void main(String[] args) {
		// ProcessaPontos.preencheTestes();
		ProcessaPontos.lerArquivo();
		new FormRede().setVisible(true);
	}

}
