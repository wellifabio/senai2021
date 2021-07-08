package viewers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class FormCRUD extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel painel;

	FormCRUD(){
		setIconImage(new ImageIcon("./assets/moto.png").getImage());
		setTitle("Banco de dados de estacionamentos");
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
