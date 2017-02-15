package proyectopatologias;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pool_Conexiones.Pool;

public class PatologiaDAO {
	
	/*
	 * Se instanciara el objeto pool que creamos en otro paquete.
	 * Este tendra que pedir una conexion cuando se use un metodo.
	 */

	public static PatologiaDTO buscarPatologiaID(int id) throws Throwable
	{
		Pool pool = null;
		
		ResultSet rset = null;
		PatologiaDTO patologia = null;
		Pool.getInstance();
		Connection conn=null;
		conn=Pool.getConnection();
		System.out.println(conn);
		
		Statement stmt=null;
		stmt=conn.createStatement();
		rset = stmt.executeQuery(Consultas.CONSULTA_PATOLOGIA_ID + id);
		while (rset.next())
		{
			patologia = new PatologiaDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), buscarSintomasPatologiaID(id, conn));
		}
		pool.liberarRecursos(conn, stmt, rset);
		
		return patologia;
	}
	
	public static List<Sintoma> buscarSintomasPatologiaID (int id, Connection conn) throws SQLException
	{
		List<Sintoma> lista_sintomas = new ArrayList<Sintoma>();
		
		String descripcion_sintoma = null;
		int id_sintoma = 0;
		Sintoma sintoma = null;
		ResultSet rset2 = null;
		Statement stmt2 = null;
		
		//pool.getInstance(); Connection conn2=pool.getConnection();
		
		
		stmt2 = conn.createStatement();
		rset2 = stmt2.executeQuery(Consultas.CONSULTA_LISTA_SINTOMA_POR_PATOLOGIA_ID +id+")");
		while (rset2.next())
	    {
			id_sintoma = rset2.getInt(1);
			descripcion_sintoma = rset2.getString(2);
			sintoma = new Sintoma(id_sintoma, descripcion_sintoma);
			lista_sintomas.add(sintoma);
		}
		//pool.liberarRecursos(conn2, stmt2, rset2);
		
		return lista_sintomas;
	}
}
