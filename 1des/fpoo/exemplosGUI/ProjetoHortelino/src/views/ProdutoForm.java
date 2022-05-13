package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.ProcessaProduto;
import models.Produto;

public class ProdutoForm extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scroll;
	private JButton btAdd, btDel, btCancelar, btSalvar;
	private JLabel lbCabecalho = new JLabel(new Produto().cabecalho());
	private JLabel lbTotalItens = new JLabel("Total de �tens:");
	private JLabel lbTotalDinheiro = new JLabel("Total em R$:");
	private int codigo;
	private JTextField tfCod = new JTextField();
	private JTextField tfNome = new JTextField();
	private JTextField tfDescricao = new JTextField();
	private JTextField tfPreco = new JTextField();
	private JTextField tfQuantidade = new JTextField();
	private JTextField tfTotalItens = new JTextField();
	private JTextField tfTotalDinheiro = new JTextField();
	private String imgIco = ".\\assets\\icone.png";
	private Produto produto;

	ProdutoForm() {
		// Propriedades do Formul�rio
		setTitle("Cadastro de Produtos");
		setBounds(250, 160, 597, 410);
		setIconImage(new ImageIcon(imgIco).getImage());
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);
		codigo = ProcessaProduto.getAutoCodigo();
		
		// Label e TextFiels para Cadastro
		lbCabecalho.setBounds(10, 10, 580, 20);
		tfCod.setBounds(10, 30, 40, 25);
		tfNome.setBounds(50, 30, 150, 25);
		tfDescricao.setBounds(200, 30, 150, 25);
		tfPreco.setBounds(350, 30, 80, 25);
		tfQuantidade.setBounds(430, 30, 70, 25);
		tfCod.setText(String.format("%d",codigo));
		tfCod.setEnabled(false);
		panel.add(lbCabecalho);
		panel.add(tfCod);
		panel.add(tfNome);
		panel.add(tfDescricao);
		panel.add(tfPreco);
		panel.add(tfQuantidade);

		// Bot�o Adicionar (CREATE)
		btAdd = new JButton("Add");
		btAdd.setBounds(500, 30, 68, 25);
		panel.add(btAdd);
		btAdd.addActionListener(this);

		// Tabela de Professores (READ, UPDATE)
		tableModel = new DefaultTableModel();
		tableModel.addColumn("C�digo");
		tableModel.addColumn("Produto");
		tableModel.addColumn("Descri��o");
		tableModel.addColumn("Pre�o");
		tableModel.addColumn("Quantidade");
		tableModel.addColumn("Subtotal");
		if (!ProcessaProduto.getProdutos().isEmpty()) {
			for (Produto p : ProcessaProduto.getProdutos()) {
				tableModel.addRow(p.getStringVetor());
			}
		}
		table = new JTable(tableModel);
		scroll = new JScrollPane(table);
		scroll.setBounds(10, 55, 559, 275);
		panel.add(scroll);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int lin = table.getSelectedRow();
				int col = table.getSelectedColumn();
				if (col == 0) {
					ProdutoPropriedades pp = new ProdutoPropriedades(table.getValueAt(lin, col).toString());
					pp.setModal(true);
					pp.setVisible(true);
				}
			}
		});
		
		//Totais
		tfTotalItens.setText(String.format("%d",ProcessaProduto.getTotalItens()));
		tfTotalDinheiro.setText(String.format("%.2f", ProcessaProduto.getTotalDinheiro()));
		lbTotalItens.setBounds(10,330,80,30);
		tfTotalItens.setBounds(90,335,50,25);
		lbTotalDinheiro.setBounds(140,330,70,30);
		tfTotalDinheiro.setBounds(210,335,60,25);
		panel.add(lbTotalItens);
		panel.add(tfTotalItens);
		panel.add(lbTotalDinheiro);
		panel.add(tfTotalDinheiro);

		// Bot�o Deletar (DELETE)
		btDel = new JButton("Del");
		btDel.setBounds(278, 330, 59, 30);
		panel.add(btDel);
		btDel.addActionListener(this);

		// Bot�o Cancelar (Cancela as altera��es)
		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(328, 330, 120, 30);
		panel.add(btCancelar);
		btCancelar.addActionListener(this);

		// Bot�o Salvar (Renova a lista)
		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(448, 330, 120, 30);
		panel.add(btSalvar);
		btSalvar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btAdd) {
			if (!tfNome.getText().isEmpty() && !tfDescricao.getText().isEmpty() && !tfPreco.getText().isEmpty()
					&& !tfQuantidade.getText().isEmpty()) {
				//Utiliza o Model Produto para filtrar os dados e preenche o tableModel
				produto = new Produto();
				produto.setCodigo(codigo);
				produto.setNome(tfNome.getText());
				produto.setDescricao(tfDescricao.getText());
				produto.setPreco(Double.parseDouble(tfPreco.getText()));
				produto.setQuantidade(Integer.parseInt(tfQuantidade.getText()));
				tableModel.addRow(produto.getStringVetor());
				//Limpar  os campos
				codigo++;
				tfCod.setText(String.format("%d", codigo));
				tfNome.setText("");
				tfDescricao.setText("");
				tfPreco.setText("");
				tfQuantidade.setText("");
				tfTotalItens.setText(String.format("%d",ProcessaProduto.getTotalItens()));
				tfTotalDinheiro.setText(String.format("%.2f", ProcessaProduto.getTotalDinheiro()));
			}

		} else if (e.getSource() == btDel) {
			// Ao ser pressionado o bot�o Del
			if (table.getSelectedRow() >= 0) {
				tableModel.removeRow(table.getSelectedRow());
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma linha");
			}
		} else if (e.getSource() == btCancelar) {
			dispose();
		} else { //Sen�o, s� resta o bot�o salvar
			ArrayList<Produto> produtos = new ArrayList<>();
			// Passando os dados da tabela para uma Lista (ArrayList)
			for (int i = 0; i < tableModel.getRowCount(); i++) {
				produto = new Produto();
				produto.setCodigo(Integer.parseInt((String) tableModel.getValueAt(i, 0)));
				produto.setNome((String) tableModel.getValueAt(i, 1));
				produto.setDescricao((String) tableModel.getValueAt(i, 2));
				produto.setPreco(Double.parseDouble((String) tableModel.getValueAt(i, 3)));
				produto.setQuantidade(Integer.parseInt((String) tableModel.getValueAt(i, 4)));
				produtos.add(produto);
			}
			ProcessaProduto.setProdutos(produtos);
			dispose();
		}
	}

}
