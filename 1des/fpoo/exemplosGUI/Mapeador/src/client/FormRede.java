package client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ProcessaPontos;
import domain.Ponto;

public class FormRede extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JButton salvar, cancelar, add, excluir, mapa;
	private ImageIcon icon;
	private JLabel cabecalho, ico;
	private JTextField tfId, tfDescr, tfOrigem, tfDestino;
	private JComboBox<String> cbIcone, cbPai;
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scroll;
	private Ponto ponto;

	FormRede() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("./assets/roteador.jpg").getImage());
		setTitle("Registro de Pontos de Rede");
		setSize(800, 520);
		painel = new JPanel();
		setContentPane(painel);
		setLocationRelativeTo(null);
		setLayout(null);

		// Montagem dos campos de entrada
		String esp = "                      ";
		cabecalho = new JLabel("ID" + esp + "        Descrição" + esp + "Tipo" + esp + " Origem" + esp + "Destino" + esp
				+ "Conectado à");
		cabecalho.setBounds(20, 10, 700, 25);
		painel.add(cabecalho);
		tfId = new JTextField();
		tfId.setBounds(20, 30, 100, 25);
		painel.add(tfId);
		tfDescr = new JTextField();
		tfDescr.setBounds(120, 30, 120, 25);
		painel.add(tfDescr);
		cbIcone = new JComboBox<String>(new String[] { "Switch", "Roteador", "PC", "Impressora", "LapTop","Servidor","DVR","Internet"});
		cbIcone.addActionListener(this);
		cbIcone.setBounds(240, 30, 100, 24);
		painel.add(cbIcone);
		tfOrigem = new JTextField();
		tfOrigem.setBounds(340, 30, 100, 25);
		painel.add(tfOrigem);
		tfDestino = new JTextField();
		tfDestino.setBounds(440, 30, 100, 25);
		painel.add(tfDestino);
		cbPai = new JComboBox<String>(ProcessaPontos.getPais());
		cbPai.setBounds(540, 30, 100, 24);
		painel.add(cbPai);

		// Botões Add e Del
		add = new JButton("Add");
		add.setBounds(642, 30, 60, 24);
		painel.add(add);
		add.addActionListener(this);
		excluir = new JButton("Del");
		excluir.setBounds(702, 30, 60, 24);
		// excluir.setEnabled(false);
		painel.add(excluir);
		excluir.addActionListener(this);

		// Montagem da Tabela (Read, Update)
		preencherTabela();

		// Montagem dos outros botões
		salvar = new JButton("Salvar");
		salvar.setBounds(20, 435, 120, 30);
		painel.add(salvar);
		salvar.addActionListener(this);

		cancelar = new JButton("Cancelar");
		cancelar.setBounds(150, 435, 120, 30);
		painel.add(cancelar);
		cancelar.addActionListener(this);

		mapa = new JButton("Desenhar Mapa");
		mapa.setBounds(555, 435, 150, 30);
		painel.add(mapa);
		mapa.addActionListener(this);

		icon = new ImageIcon(new ImageIcon("./assets/" + cbIcone.getSelectedItem().toString().toLowerCase() + ".jpg")
				.getImage().getScaledInstance(50, 50, 100));
		ico = new JLabel();
		ico.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
		ico.setBounds(714, 425, 50, 50);
		ico.setIcon(icon);
		painel.add(ico);

	}

	private void preencherTabela() {
		tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Descrição");
		tableModel.addColumn("Ícone");
		tableModel.addColumn("Origem");
		tableModel.addColumn("Destino");
		tableModel.addColumn("Pai");
		if (!ProcessaPontos.pontos.isEmpty()) {
			for (Ponto p : ProcessaPontos.pontos) {
				tableModel.addRow(p.getStringVetor());
			}
		}
		table = new JTable(tableModel);
		scroll = new JScrollPane(table);
		scroll.setBounds(20, 60, 745, 360);
		painel.add(scroll);
	}

	private void mostrarIcone() {
		icon = new ImageIcon(new ImageIcon("./assets/" + cbIcone.getSelectedItem().toString().toLowerCase() + ".jpg")
				.getImage().getScaledInstance(50, 50, 100));
		ico.setIcon(icon);
	}

	private void adicionar() {
		if (tfId.getText().equals("") || tfDescr.getText().equals("") || tfOrigem.getText().equals("")
				|| tfDestino.getText().equals("") || cbIcone.getSelectedItem().toString().equals("")) {
			JOptionPane.showMessageDialog(this, "Preecha todos os campos obrigatorios");
		} else {
			if (cbPai.getSelectedItem().toString().length() == 0)
				ponto = new Ponto(tfId.getText(), tfDescr.getText(), cbIcone.getSelectedItem().toString(),
						tfOrigem.getText(), tfDestino.getText(), "");
			else
				ponto = new Ponto(tfId.getText(), tfDescr.getText(), cbIcone.getSelectedItem().toString(),
						tfOrigem.getText(), tfDestino.getText(), cbPai.getSelectedItem().toString());
			if (ProcessaPontos.pontos.contains(ponto)) {
				JOptionPane.showMessageDialog(this, "Ponto de Rede ja está cadastrado");
			} else {
				ProcessaPontos.pontos.add(ponto);
				this.dispose();
				new FormRede().setVisible(true);
			}
		}
	}

	private void excluir() {
		if (table.getSelectedRow() >= 0) {
			if (ProcessaPontos.isPai(tableModel.getValueAt(table.getSelectedRow(), 0).toString()))
				JOptionPane.showMessageDialog(null, "Remova primeiro os pontos conectados a este equipamento");
			else {
				ProcessaPontos.pontos.remove(table.getSelectedRow());
				this.dispose();
				new FormRede().setVisible(true);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Selecione uma linha");
		}
	}

	private void salvar() {
		ProcessaPontos.pontos = new ArrayList<>();
		// Percorre a tabela passando os dados para lista do controle
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			ponto = new Ponto(tableModel.getValueAt(i, 0).toString(), tableModel.getValueAt(i, 1).toString(),
					tableModel.getValueAt(i, 2).toString(), tableModel.getValueAt(i, 3).toString(),
					tableModel.getValueAt(i, 4).toString(), tableModel.getValueAt(i, 5).toString());
			ProcessaPontos.pontos.add(ponto);
		}
		// Eecuta o método que salva no arquivo efetivamente
		if (ProcessaPontos.salvar()) {
			JOptionPane.showMessageDialog(this, "Registros salvos com sucesso.");
		} else {
			JOptionPane.showMessageDialog(this, "Erro ao salvar dados em arquivo");
		}
		dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvar) {
			salvar();
		} else if (e.getSource() == mapa) {
			new DialogMapa().setVisible(true);
		} else if (e.getSource() == excluir) {
			excluir();
		} else if (e.getSource() == add) {
			adicionar();
		} else if (e.getSource() == cancelar) {
			dispose();
		}

		if (e.getSource() == cbIcone) {
			mostrarIcone();
		}
	}

	public static void main(String[] args) {
		ProcessaPontos.preencheTestes();
		//ProcessaPontos.lerArquivo();
		new FormRede().setVisible(true);
	}

}
