package viewers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.EstacionamentoProcess;
import models.Estacionamento;

public class FormCRUD extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel lbCabecalho = new JLabel(
			"ID        Vaga              Placa                Data                 Entrada              Saída           Valor");
	private JComboBox<String> cbVaga = new JComboBox<String>(
			new String[] { "C01", "C02", "C03", "C04", "C05", "C06", "C07", "C08", "M01", "M02", "M03" });
	private JTextField tfId = new JTextField();
	private JTextField tfPlaca = new JTextField();
	private JTextField tfData = new JTextField();
	private JTextField tfEntrada = new JTextField();
	private JTextField tfSaida = new JTextField();
	private JTextField tfValor = new JTextField();
	private JButton btAtt, btDel, btCancelar, btSalvar;;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scroll;
	private Estacionamento estacionamento;
	private SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

	FormCRUD() {
		setIconImage(new ImageIcon("./assets/moto.png").getImage());
		setTitle("Banco de dados de estacionamentos");
		setSize(600, 400);
		painel = new JPanel();
		setContentPane(painel);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);

		// Label e TextFiels para Cadastro
		lbCabecalho.setBounds(10, 10, 550, 20);
		tfId.setBounds(10, 30, 40, 24);
		cbVaga.setBounds(50, 30, 60, 24);
		tfPlaca.setBounds(110, 30, 80, 25);
		tfData.setBounds(190, 30, 80, 25);
		tfEntrada.setBounds(270, 30, 70, 25);
		tfSaida.setBounds(340, 30, 70, 25);
		tfValor.setBounds(410, 30, 70, 25);
		painel.add(lbCabecalho);
		painel.add(tfId);
		painel.add(cbVaga);
		painel.add(tfPlaca);
		painel.add(tfData);
		painel.add(tfEntrada);
		painel.add(tfSaida);
		painel.add(tfValor);

		// Botão Atualizar
		btAtt = new JButton("Atualizar");
		btAtt.setBounds(480, 30, 88, 24);
		painel.add(btAtt);
		btAtt.addActionListener(this);

		// Tabela de Professores (READ, UPDATE)
		tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Vaga");
		tableModel.addColumn("Placa");
		tableModel.addColumn("Data");
		tableModel.addColumn("Entrada");
		tableModel.addColumn("Saída");
		tableModel.addColumn("Valor");
		tableModel.addColumn("Total");
		if (!EstacionamentoProcess.registros.isEmpty()) {
			for (Estacionamento e : EstacionamentoProcess.registros) {
				tableModel.addRow(e.toVetor());
			}
		}
		table = new JTable(tableModel);
		scroll = new JScrollPane(table);
		scroll.setBounds(10, 55, 559, 275);
		painel.add(scroll);

		// Botão Deletar (DELETE)
		btDel = new JButton("Del");
		btDel.setBounds(278, 330, 59, 24);
		painel.add(btDel);
		btDel.addActionListener(this);

		// Botão Cancelar (Cancela as alterações)
		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(328, 330, 120, 24);
		painel.add(btCancelar);
		btCancelar.addActionListener(this);

		// Botão Salvar (Renova a lista)
		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(448, 330, 120, 24);
		painel.add(btSalvar);
		btSalvar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btDel) {
			// Ao ser pressionado o botão Del
			if (table.getSelectedRow() >= 0) {
				tableModel.removeRow(table.getSelectedRow());
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma linha");
			}
		} else if (e.getSource() == btCancelar) {
			dispose();
		} else { // Senão, só resta o botão salvar
			// Limpa a lista anterior
			EstacionamentoProcess.registros = new ArrayList<>();
			;
			// Passando os dados da tabela para a Lista
			for (int i = 0; i < tableModel.getRowCount(); i++) {
				try {
					estacionamento = new Estacionamento();
					estacionamento.setId(Integer.parseInt((String) tableModel.getValueAt(i, 0)));
					estacionamento.setVaga((String) tableModel.getValueAt(i, 1));
					estacionamento.setPlaca((String) tableModel.getValueAt(i, 2));
					estacionamento.setData(data.parse((String) tableModel.getValueAt(i, 3)));
					estacionamento.setHoraEntrada((String) tableModel.getValueAt(i, 4));
					estacionamento.setHoraSaida((String) tableModel.getValueAt(i, 5));
					estacionamento.setValorHora(Double.valueOf((String) tableModel.getValueAt(i, 6)));
					EstacionamentoProcess.registros.add(estacionamento);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
			if (EstacionamentoProcess.salvar()) {
				JOptionPane.showMessageDialog(null, "Alterações salvas com sucesso");
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao salvar alterações");
			}
			dispose();
		}
	}
}
