package view;

import java.io.IOException;
import java.io.PrintWriter;

import controll.ChamadoControll;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ChamadoModel;

@WebServlet("/chamados")
public class Chamados extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();		
		//int id = Integer.parseInt(req.getParameter("id"));		
		ChamadoControll cc = new ChamadoControll();	
		String data = cc.listar();		
		pw.write(data);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();

		int id = Integer.parseInt(req.getParameter("id"));
		String data = req.getParameter("data");
		String status = req.getParameter("status");
		String responsavel = req.getParameter("responsavel");
		float valor = Float.parseFloat(req.getParameter("valor"));
		
		ChamadoModel cm = new ChamadoModel(id, data, status, responsavel, valor);
		ChamadoControll cc = new ChamadoControll();
		String ret = cc.cadastrar(cm);
		if(ret.equals("")) {
			resp.setStatus(400);
		}else {
			resp.setStatus(201);
		}
		pw.write(ret);
		
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		
		ChamadoControll cc = new ChamadoControll();
		String id = req.getParameter("id");
		
		if(cc.excluir(id)) {
			pw.write("Chamado excluido");
		}else {
			pw.write("Não foi possível excluir");
		}
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		
		int id = Integer.parseInt(req.getParameter("id"));
		String data = req.getParameter("data");
		String status = req.getParameter("status");
		String responsavel = req.getParameter("responsavel");
		float valor = Float.parseFloat(req.getParameter("valor"));
		
		ChamadoModel c = new ChamadoModel(id,data,status,responsavel,valor);
		ChamadoControll cc = new ChamadoControll();
		
		if(cc.alterar(c)) {
			pw.write("Chamado alterado");
		}else {
			pw.write("Não foi possível alterar");
		}
	}
	
}