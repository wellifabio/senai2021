package controllers;

import javax.swing.JOptionPane;

import models.dao.RelatorioDAO;

public class ProcessaRelatorio {
	
	private static RelatorioDAO rd = new RelatorioDAO();

	public static void setRd(String dados, String arquivo) {
		if(rd.saveReport(dados, arquivo)) {
			JOptionPane.showMessageDialog(null, "Relatório salvo com sucesso.");
		}else {
			JOptionPane.showMessageDialog(null, "Erro ao salvar relatório.");
		}
	}
}
