package client;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormPri extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private PanelDrag imgs;
	
	FormPri(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Arraste e Solte");
		setSize(640,480);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);
		setLocationRelativeTo(null);
		
		String[] itens = new String[8];
		itens[0] = "./assets/switch.png";
		itens[1] = "./assets/pc.png";
		itens[2] = "./assets/pc.png";
		itens[3] = "./assets/pc.png";
		itens[4] = "./assets/switch.png";
		itens[5] = "./assets/pc.png";
		itens[6] = "./assets/pc.png";
		itens[7] = "./assets/pc.png";
		imgs = new PanelDrag(itens);
		imgs.setBounds(20,20,580,400);
		panel.add(imgs);
	}

	public static void main(String[] args) {
		new FormPri().setVisible(true);
	}

}
