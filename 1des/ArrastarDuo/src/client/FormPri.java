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
		setLocationRelativeTo(null);
		setSize(640,480);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);
		
		imgs = new PanelDrag(new String[] {"./assets/switch.png","./assets/pc.png","./assets/pc.png","./assets/pc.png"});
		imgs.setBounds(20,20,580,400);
		panel.add(imgs);
	}

	public static void main(String[] args) {
		new FormPri().setVisible(true);
	}

}
