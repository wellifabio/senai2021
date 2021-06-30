package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainForm extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JMenuBar barraMenu = new JMenuBar();
	private JMenu menuArquivo, menuSistema;
	private JMenuItem itemProdutos, itemCompras, itemRelatorios, itemSair;
	private ImageIcon fundo = new ImageIcon(".\\img\\fundo.jpeg");
	private JLabel lbFundo = new JLabel();

	MainForm() {
		// COnfigurações do Form principal
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Loja de Ferragens do Hortelino - Sistema de Compras");
		setBounds(200, 100, 700, 500);
		panel = new JPanel();
		setJMenuBar(barraMenu);
		setContentPane(panel);
		setLayout(null);

		// Barra de Menús
		menuArquivo = new JMenu("Arquivo");
		menuSistema = new JMenu("Sistema");
		barraMenu.add(menuArquivo);
		barraMenu.add(menuSistema);
		itemProdutos = new JMenuItem("Produtos");
		itemCompras = new JMenuItem("Compras");
		itemRelatorios = new JMenuItem("Relatórios");
		itemSair = new JMenuItem("Sair do Sistema");
		menuArquivo.add(itemProdutos);
		menuArquivo.add(itemCompras);
		menuSistema.add(itemRelatorios);
		menuSistema.add(itemSair);
		
		//Imagem de fundo
		lbFundo.setIcon(fundo);
		lbFundo.setBounds(20,15,650,405);
		panel.add(lbFundo);

		// Ações do Menú
		itemProdutos.addActionListener(this);
		itemCompras.addActionListener(this);
		itemRelatorios.addActionListener(this);
		itemSair.addActionListener(this);
	}

	//Ações ao clicar nos ítens do menú.
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == itemProdutos) {
			ProdutoForm pf = new ProdutoForm();
			pf.setModal(true);
			pf.setVisible(true);
		} else if (e.getSource() == itemCompras) {
			CompraForm cf = new CompraForm();
			cf.setModal(true);
			cf.setVisible(true);
		} else if (e.getSource() == itemRelatorios) {
			RelatorioForm rf = new RelatorioForm();
			rf.setModal(true);
			rf.setVisible(true);
		} else {
			dispose();
		}
	}

	//Método Main que  abre o Form principal e carrega os arquivos
	public static void main(String[] args) {
		//Abre o formulário principal
		MainForm mf = new MainForm();
		mf.setVisible(true);
	}

}
