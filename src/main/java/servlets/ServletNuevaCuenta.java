package servlets;

import java.io.IOException;
import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  


import beans.Cuenta;


public class ServletNuevaCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String[] noAutorizados= {"Juan Perez","Joselito Fernandez","Diego Pablo","Miguel Hernandez","Adrian Garrido"};


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("titular");
		Integer saldo=0;
		if(request.getParameter("saldo")!=null) {
			saldo=Integer.valueOf(request.getParameter("saldo"));
		}
		String errores;
//		System.out.println(nombre);
		if(!nombre.equals("")) {
//			System.out.println(saldo);
			if(saldo<0) {
//				System.out.println("entra");
				errores="Saldo Negativo";
				request.getSession().setAttribute("error", errores);
				Cuenta c= new Cuenta(nombre, 0);
				request.getSession().setAttribute("cuenta", c);
				response.sendRedirect("nuevaCuenta.jsp");
//				System.out.println("saldo negativo");
			}
			else {
				for (String no : noAutorizados) {
					if(nombre.equals(no)) {
						errores="Usuario no permitido";
						request.getSession().setAttribute("error", errores);
						Cuenta c= new Cuenta("", saldo);
						request.getSession().setAttribute("cuenta", c);
						response.sendRedirect("nuevaCuenta.jsp");
//						System.out.println("no vale");
					}
				}
			}
		}
		else {
			System.out.println("entra1");
			errores="Usuario vacio";
			request.getSession().setAttribute("error", errores);
			Cuenta c= new Cuenta("", saldo);
			request.getSession().setAttribute("cuenta", c);
			response.sendRedirect("nuevaCuenta.jsp");
//			System.out.println("ususario VAcio");
		}
		Cuenta c= new Cuenta(nombre, saldo);
//		System.out.println("funciona");
	}

}
