package ServletsProyecto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EjSession
 */
@WebServlet("/EjSession")
public class EjSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjSession() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nllamadas = 0;
		String uSname =request.getParameter("usuario");
	
		
		
		HttpSession session = request.getSession(true);
		
		
		
		session.setAttribute("usuario", uSname);
		
		if(session.getAttribute("usuario")!=null){
			
			session.setAttribute("contador", (int)session.getAttribute("contador")+1);
		}
		
		request.getRequestDispatcher("salida.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		
		
	}

}
