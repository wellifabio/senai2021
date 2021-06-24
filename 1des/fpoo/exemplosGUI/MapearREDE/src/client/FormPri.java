package client;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ProcessaPontos;
import domain.Ponto;

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
		
		imgs = new PanelDrag(ProcessaPontos.pontos);
		imgs.setBounds(20,20,580,400);
		panel.add(imgs);
	}

	public static void main(String[] args) {
		ProcessaPontos.preencheTestes();
		for(Ponto p: ProcessaPontos.pontos) {
			System.out.println(p.toString());
		}
		new FormPri().setVisible(true);
	}

}
