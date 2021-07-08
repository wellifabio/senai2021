package viewers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class FormRelatorio extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel painel;


	FormRelatorio(){
		setIconImage(new ImageIcon("./assets/moto.png").getImage());
		setTitle("Relatório do Dia");
		setSize(600, 400);
		painel = new JPanel();
		setContentPane(painel);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
