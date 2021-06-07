package views;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controlls.Conversao;
import models.Contexto;

/*
 * Design Patterns Comportamental Interpreter
 * pouco utilizado, somente em casos específicos
 * onda interpretação ou conversão de tipos de dados
 * se faz necessária
 * Este exemplo converte galões americanos de gasolina
 * em litros, copos e MLs:
 * https://www.youtube.com/watch?v=6CVymSJQuJE
 *
 * */

public class QuestaoPrincipal {

	private static JFrame tela;
	private static Conversao questao;
	private static String de;
	private static String para;
	private static double quantidade;

	public static void main(String[] args) {

		tela = new JFrame();
		String questaoEntrada = JOptionPane.showInputDialog(tela,"Qual sua questão");
		questao = new Conversao(questaoEntrada);
		de = questao.getDe();
		para = questao.getPara();
		quantidade = questao.getQuantidade();

		JOptionPane.showMessageDialog(tela, "de: "+ de + ", para: "+para+", quantidade:"+quantidade);
		
		try {
			Class classeTemp = Class.forName(de);
			Constructor con = classeTemp.getConstructor();
			Object converteDe = (Contexto) con.newInstance();
			Class[] parametros = new Class[] {Double.TYPE};
			Method metodoConversao = classeTemp.getMethod(para, parametros);
			Object[] params = new Object[] {new Double(quantidade)};
			String paraQuant = (String) metodoConversao.invoke(converteDe, params);
			String respostaQuestao = questao.getResposta() + paraQuant + " " + para;
			JOptionPane.showMessageDialog(tela, respostaQuestao);
			tela.dispose();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(tela, "ClassNotFoundException: "+e);
			tela.dispose();
		} catch (NoSuchMethodException e) {
			JOptionPane.showMessageDialog(tela, "NoSuchMethodException: "+e);
			tela.dispose();
		} catch (SecurityException e) {
			JOptionPane.showMessageDialog(tela, "SecurityException: "+e);
			tela.dispose();
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(tela, "InstantiationException: "+e);
			tela.dispose();
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(tela, "IllegalAccessException: "+e);
			tela.dispose();
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(tela, "IllegalArgumentException: "+e);
			tela.dispose();
		} catch (InvocationTargetException e) {
			JOptionPane.showMessageDialog(tela, "InvocationTargetException: "+e);
			tela.dispose();
		}
		

	}

}
