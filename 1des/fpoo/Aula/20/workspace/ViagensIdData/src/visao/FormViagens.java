package visao;
/*
 * Artigo sobre como trabalhar com Datas em Java
 * https://www.alura.com.br/artigos/como-converter-string-para-date-em-java
 * 
 * */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	private int id;
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

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

	private String listarTodas() {
		String acumulador = "Id\tData\tOrigem\tDestino\tDistância\tTempo\tVelocidade\n";
		for (Viagem v : ProcessaViagens.viagens) {
			acumulador += v.toString();
		}
		acumulador += "Horas de voo: " + ProcessaViagens.totalTempo();
		return acumulador;
	}

	private String obterData() {
		return formato.format(new Date());
	}

	private void adicionar() {
		try {
			String[] campos = JOptionPane.showInputDialog("(Id,Origem,Destino,Distancia,Tempo").split(",");

			ProcessaViagens.viagens.add(new Viagem(Integer.valueOf(campos[0]), formato.parse(obterData()), campos[1],
					campos[2], Integer.valueOf(campos[3]), Integer.valueOf(campos[4])));
		} catch (NumberFormatException | ParseException e) {
			System.out.println("Erro ao converter datas " + e);
		}
		texto.setText(listarTodas());
	}

	private void alterar() {
		try {
			id = Integer.valueOf(JOptionPane.showInputDialog("Qual o ID a ser alterado"));
			Viagem v = new Viagem(id, formato.parse("00/00/0000"), null, null, 0, 0);
			if (ProcessaViagens.viagens.contains(v)) {
				String[] campos = JOptionPane.showInputDialog("Data,Origem,Destino,Distancia,Tempo").split(",");
				v = new Viagem(id, formato.parse(campos[0]), campos[1], campos[2], Integer.valueOf(campos[3]),
						Integer.valueOf(campos[4]));
				ProcessaViagens.viagens.set(ProcessaViagens.viagens.indexOf(v), v);

				texto.setText(listarTodas());
			} else {
				JOptionPane.showMessageDialog(this, "Indice Inválido");
			}
		} catch (NumberFormatException e) {
			System.out.println("Erro ao converter números " + e);
		} catch (ParseException e) {
			System.out.println("Erro ao converter datas " + e);
		}
		texto.setText(listarTodas());
	}

	private void excluir() {
		try {
			id = Integer.valueOf(JOptionPane.showInputDialog("Qual o índice a ser alterado"));
			Viagem v = new Viagem(id, formato.parse("00/00/0000"), null, null, 0, 0);
			if (ProcessaViagens.viagens.contains(v)) {
				ProcessaViagens.viagens.remove(ProcessaViagens.viagens.indexOf(v));
				texto.setText(listarTodas());
			} else {
				JOptionPane.showMessageDialog(this, "Indice Inválido");
			}
		} catch (NumberFormatException e) {
			System.out.println("Erro ao converter números " + e);
		} catch (ParseException e) {
			System.out.println("Erro ao converter datas " + e);
		}
		texto.setText(listarTodas());
	}

	public static void main(String[] args) {
		// ProcessaViagens.preencherTeste();
		ProcessaViagens.abrirDAO();
		new FormViagens().setVisible(true);
	}

}
