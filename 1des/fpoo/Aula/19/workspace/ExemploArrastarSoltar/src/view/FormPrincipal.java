package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel panel; 
	DragPanel drag;

	FormPrincipal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Arrastando a imagem");
		setSize(900, 600);
		setLocationRelativeTo(null);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);
		
		drag = new DragPanel();
		drag.setBounds(20,20,840,520);
		panel.add(drag);
	}

}
