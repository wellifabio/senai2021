package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private String id;
	private JLabel cabecalho;
	private JTextField tfId, tfDescr, tfOrigem, tfDestino;
	private JComboBox<String> cbIcone, cbPai;
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scroll;

	FormRede() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Registro de Viagens");
		setSize(800, 520);
		painel = new JPanel();
		setContentPane(painel);
		setLocationRelativeTo(null);
		setLayout(null);

		//Montagem dos campos de entrada
		cabecalho = new JLabel("ID           Descrição");
		cabecalho.setBounds(20,10,500,25);
		painel.add(cabecalho);	
		tfId = new JTextField();
		tfId.setBounds(20,30,100,25);
		painel.add(tfId);
		tfDescr = new JTextField();
		tfDescr.setBounds(120,30,120,25);
		painel.add(tfDescr);
		cbIcone = new JComboBox(new String[]{"switch.png","roteador.png","pc.png","impressora.png","notebook.png"});
		cbIcone.setBounds(240,30,100,24);
		painel.add(cbIcone);
		tfOrigem = new JTextField();
		tfOrigem.setBounds(340,30,100,25);
		painel.add(tfOrigem);
		tfDestino = new JTextField();
		tfDestino.setBounds(440,30,100,25);
		painel.add(tfDestino);
		cbPai = new JComboBox(ProcessaPontos.getPais());
		cbPai.setBounds(540,30,100,24);
		painel.add(cbPai);
		
		add = new JButton("Add");
		add.setBounds(642, 30, 60, 24);
		painel.add(add);
		add.addActionListener(this);
		excluir = new JButton("Del");
		excluir.setBounds(702, 30, 60, 24);
		excluir.setEnabled(false);
		painel.add(excluir);
		excluir.addActionListener(this);
		
		// Montagem da Tabela (Read, Update)
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
		} else {
			dispose();
		}
	}

	private void adicionar() {
		try {
			String[] campos = JOptionPane.showInputDialog("(Id,Descrição,Ícone,Origem,Destino,Pai").split(",");
			ProcessaPontos.pontos.add(new Ponto(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5]));
			
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
				
			} else {
				JOptionPane.showMessageDialog(this, "ID Inválido");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao preencher dados");
		}
		
	}

	private void excluir() {
		try {
			id = JOptionPane.showInputDialog("Qual o ID a ser excluído");
			Ponto p = new Ponto(id);
			if (ProcessaPontos.pontos.contains(p)) {
				ProcessaPontos.pontos.remove(ProcessaPontos.pontos.indexOf(p));
				
			} else {
				JOptionPane.showMessageDialog(this, "ID Inválido");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao preencher dados");
		}
		
	}

	public static void main(String[] args) {
		// ProcessaPontos.preencheTestes();
		ProcessaPontos.lerArquivo();
		new FormRede().setVisible(true);
	}

}
