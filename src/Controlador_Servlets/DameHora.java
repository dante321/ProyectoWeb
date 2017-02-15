package Controlador_Servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DameHora
 */
@WebServlet("/DameHora")
public class DameHora extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DameHora() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//System.out.println("Ha hecho una Call a get\n");
		PrintWriter dir =response.getWriter().append("A llamado al get");
		//dir.write("Pablito clavo un clavito en la cabeza de un calvito\n");
		//dir.write("Volaree.. oh oh, cantare... eh eh eh");
		
		Calendar cld = Calendar.getInstance();
		int hora= cld.get(Calendar.HOUR);
		int mins= cld.get(Calendar.MINUTE);
		int segs = cld.get(Calendar.SECOND);
		
		//dir.write("\"HOLA\"\nLa hora es: "+hora+":"+mins+":"+segs);
		dir.write("<h1 style=\"color:blue; text-aligne:center\">HOLA\n </h1><br>");
		dir.write("La hora es: "+hora+":"+mins+":"+segs);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
