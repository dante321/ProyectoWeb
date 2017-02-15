package Controlador_Servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import conexionssh.conexSSH;

/**
 * Application Lifecycle Listener implementation class ListenerWeb
 *
 */
@WebListener
public class ListenerWeb implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenerWeb() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("Termino el ciclo del listener");
    	
    	conexSSH.desconectate_D_SSH();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	
    	System.out.println("Se inicio el listener");
    	try {
			conexSSH.conectate_A_SSH();//Se conecta por ssh al servidor.
		} catch (Throwable e) {
			System.out.println("error al conectar al server");
			e.printStackTrace();
		}
    }
	
}
