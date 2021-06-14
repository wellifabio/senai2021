package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormImages extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton bt;
	private JPanel panelPri;

	public FormImages() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Clique e arraste para inserir uma imagem e uma linha");
		setSize(900, 600);
		setLocationRelativeTo(null);
		panelPri = new JPanel();
		setContentPane(panelPri);
		setLayout(null);

		bt = new JButton("Ok");
		bt.setBounds(20, 10, 150, 30);
		panelPri.add(bt);

		PanelLinhaIMG imgs = new PanelLinhaIMG();
		panelPri.add(imgs);

	}

}
