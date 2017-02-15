package Controlador_Servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import proyectopatologias.PatologiaDAO;
import proyectopatologias.PatologiaDTO;

/**
 * Servlet implementation class PatologiaService
 */
@WebServlet("/PatologiaService")
public class PatologiaService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatologiaService() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Connection conn = 
		//Statement stmt =
		PatologiaDTO patol = null;
		String idS=request.getParameter("id");
		Gson gson =new Gson();
		String json=null;
		int id = Integer.parseInt(idS);
		
		
		try {
			
			
			patol =PatologiaDAO.buscarPatologiaID(id);
			System.out.println(patol.getNombre());
			//json =gson.toJson(patol);
			
			response.getWriter().append("Hola ").append(gson.toJson(patol));
			
			
			
		
		} catch (Throwable e) {
			
			System.out.println("CORRE, CORRE QUE HUBO UN ERROR");
			e.printStackTrace();
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
