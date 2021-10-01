package servlet;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/pedidos")
public class PedidoFiltro implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		if(req.getLocalAddr().equals(req.getRemoteAddr())) {
			chain.doFilter(req, resp);	
		}else {
			JSONObject json = new JSONObject();
			try {
				json.put("erro","Acesso negado");
			} catch (JSONException e) {
				System.out.println("Erro na conversão JSON " + e);
			}
			resp.getWriter().print(json.toString());
		}
	}
}
