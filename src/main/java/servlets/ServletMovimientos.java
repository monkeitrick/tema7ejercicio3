package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cuenta;


public class ServletMovimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cuenta c= (Cuenta) request.getSession().getAttribute("cuenta");
		if(request.getParameter("ingresoGasto")!=null) {
			Integer valor=Integer.valueOf(request.getParameter("cantidad"));
			String movimientos=request.getParameter("ingresoGasto");
			if(movimientos.equals("ingresar")) {
				c.ingresar(valor);
			}
			else {
				boolean gasto=c.gastar(valor);
				if(gasto==false) {
					request.getSession().setAttribute("noGasto", "La cuenta tiene menos dinero del que quieres gastar");
				}
			}
			request.getSession().setAttribute("cuenta", c);
			response.sendRedirect("movimientos.jsp");
		}
	}

}
