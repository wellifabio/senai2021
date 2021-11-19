package controll;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.ReceitaDAO;

@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/imagem")
public class ProcessaFoto extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ReceitaDAO rd = new ReceitaDAO();
	private OutputStream out;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = 1;
		out = resp.getOutputStream();
		if(req.getParameter("id")!=null)
			if (!req.getParameter("id").isEmpty())
				id = Integer.parseInt(req.getParameter("id"));
		try {
			byte[] buffer = new byte[rd.read(id).getFoto().available()];
			InputStream is = rd.read(id).getFoto();
			int bytesread = 0;
			while((bytesread = is.read(buffer))!=-1){
			    out.write(buffer,0,bytesread);
			}
			out.flush();
			out.close();
			is.close();
		} catch (SQLException e) {
			System.out.println("Erro ao conectar no banco de dados "+e);
		}
	}

}
