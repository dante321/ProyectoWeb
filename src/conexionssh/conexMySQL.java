package conexionssh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conexMySQL {

	private final static String cadena_conexion = "jdbc:mysql://localhost:3308/femxa";
	private final static String user = "adminGXjlxzG";
	private final static String password = "QBShkFDW_69e";
	
	public static Statement conectarMySQL(){
		
		Connection conn = null;
		Statement stmt =null;
		try{
			
		
		DriverManager.registerDriver (new com.mysql.jdbc.Driver());
		conn = DriverManager.getConnection (cadena_conexion, user, password);
		stmt = conn.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return stmt;
	}
	
	
	
}
