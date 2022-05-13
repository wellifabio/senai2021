package views;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import controllers.ProcessaProduto;
import models.Produto;

public class ProdutoPropriedades extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton btImagem, btCancelar, btSalvar;
	private JLabel lbId, lbNome, lbDescricao, lbPreco, lbQuantidade, lbSubtotal, lbImagem;
	private ImageIcon img;
	private Image image;
	private Image newImg;
	private File arquivo;
	private String imgIco = ".\\assets\\icone.png";
	Produto produto;

	ProdutoPropriedades(String cod) {
		// Propriedades do Formulário
		setTitle("Propriedades do Produto");
		setBounds(270, 180, 557, 370);
		setIconImage(new ImageIcon(imgIco).getImage());
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);

		// Pega e exibe os dados do Produto
		produto = ProcessaProduto.getProduto(Integer.parseInt(cod));		
		img = new ImageIcon(ProcessaProduto.getPd().getImgPath(produto));
		image = img.getImage();
		newImg = image.getScaledInstance(300, 250, java.awt.Image.SCALE_SMOOTH);
		lbId = new JLabel("Código do Produto: \t" + String.format("%d", produto.getCodigo()));
		lbNome = new JLabel("Nome: \t" + produto.getNome());
		lbDescricao = new JLabel("Descrição: " + produto.getDescricao());
		lbQuantidade = new JLabel("Quantidade: " + String.format("%d", produto.getQuantidade()));
		lbPreco = new JLabel("Preço: " + String.format("%.2f", produto.getPreco()));
		lbSubtotal = new JLabel("Valor do estoque: " + String.format("%.2f", produto.getSubtotal()));
		lbImagem = new JLabel();
		img = new ImageIcon(newImg);
		lbImagem.setIcon(img);
		lbId.setBounds(15, 40, 200, 30);
		lbNome.setBounds(15, 80, 200, 30);
		lbDescricao.setBounds(15, 120, 200, 30);
		lbQuantidade.setBounds(15, 160, 200, 30);
		lbPreco.setBounds(15, 200, 200, 30);
		lbSubtotal.setBounds(15, 240, 200, 30);
		lbImagem.setBounds(230, 38, 300, 250);
		panel.add(lbId);
		panel.add(lbNome);
		panel.add(lbDescricao);
		panel.add(lbQuantidade);
		panel.add(lbPreco);
		panel.add(lbSubtotal);
		panel.add(lbImagem);

		// Botão Imagem (CREATE)
		btImagem = new JButton("Carregar imagem");
		btImagem.setBounds(230, 10, 300, 25);
		panel.add(btImagem);
		btImagem.addActionListener(this);

		// Botão Cancelar (Cancela as alterações)
		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(230, 290, 150, 30);
		panel.add(btCancelar);
		btCancelar.addActionListener(this);

		// Botão Salvar (Renova a lista)
		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(378, 290, 150, 30);
		panel.add(btSalvar);
		btSalvar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btImagem == e.getSource()) {
			JFileChooser fc = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens tipo: png, jpg ou jpeg",
					new String[] { "png", "jpg", "jpeg" });
			fc.setFileFilter(filter);
			if (fc.showOpenDialog(this) != 1) {
				arquivo = fc.getSelectedFile();
				img = new ImageIcon(arquivo.getAbsolutePath());
				lbImagem.setIcon(
						new ImageIcon(img.getImage().getScaledInstance(300, 250, java.awt.Image.SCALE_SMOOTH)));
			}
		} else if (btSalvar == e.getSource()) {
			if (arquivo != null) {
				if (ProcessaProduto.getPd().saveImg(produto, arquivo)) {
					JOptionPane.showMessageDialog(this, "Alterada com sucesso.");
					this.dispose();
				}
			} else {
				dispose();
			}
		} else {
			this.dispose();
		}
	}

}
