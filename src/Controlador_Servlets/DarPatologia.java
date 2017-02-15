package Controlador_Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import proyectopatologias.PatologiaDAO;
import proyectopatologias.PatologiaDTO;

/**
 * Servlet implementation class DarPatologia
 */
@WebServlet("/DarPatologia")
public class DarPatologia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DarPatologia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String id= request.getParameter("id");
	int id2 = Integer.parseInt(id);
	Gson gson =new Gson();
	String json=null;
	try {
		PatologiaDTO patol = PatologiaDAO.buscarPatologiaID(id2);
		json=gson.toJson(patol);
		response.getWriter().append(json);
	} catch (Throwable e) {
		e.printStackTrace();
	}	
		
		
		
}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	
	}

}
