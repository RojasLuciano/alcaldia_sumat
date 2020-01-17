package page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pages.Contribuyente.Contribuyente;


public class DB_SUMAT {

	private final String url = "jdbc:postgresql://ecsdev04/simat_test";
	private final String user = "postgres";
	private final String password = "psql";
	protected Connection connect = null;

	public Connection connect() {
		try {
			connect = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the PostgreSQL server successfully.");
		} catch (SQLException e) {
			System.out.println("Failed " + e.getMessage());
		}
		return connect;
	}
 
	public void close() {
		try {
			connect.close();
			System.out.println("Desconectado.");
		} catch (Exception e) {
		}
	} 

	/**
	 * La consulta regresa un contribuyente no asociado a usuarios web
	 * @return contribuyente TIPO, DOC, VER
	 */
	public Contribuyente GenerarUsuariosNoAsociados() {
		String tdoctpodoc = null;
		String condoc = null;
		String condigver = null;
		try {
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT\r\n" + "    tdoctpodoc,\r\n" + "    condoc,\r\n"
					+ "    condigver\r\n" + "FROM\r\n" + "    personas P,\r\n" + "    tdocide T\r\n" + "WHERE\r\n"
					+ "    T .tdoccod = contdoccod\r\n"
					+ "AND contpo = 'J' and conest='A' and condigver is not null\r\n" + "AND NOT EXISTS (\r\n"
					+ "    SELECT\r\n" + "        1\r\n" + "    FROM\r\n" + "        usuwebcontribuyente C\r\n"
					+ "    WHERE\r\n" + "        C .concod = P .concod\r\n" + ")\r\n" + "LIMIT 1");
			while (rs.next()) {
				tdoctpodoc = rs.getString("tdoctpodoc");
				condoc = rs.getString("condoc");
				condigver = rs.getString("condigver");
			}
		} catch (SQLException ex) {
			System.out.println("Error " + ex);
		}
		return new Contribuyente(tdoctpodoc, condoc, condigver);
	}
	
	
	
	/**
	 * Solo para ver la salida de la query
	 */
	public void GenerarUsuariosNoAsociados2() {
		String tdoctpodoc = null;
		String condoc = null;
		String condigver = null;
		try {
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT\r\n" + "    tdoctpodoc,\r\n" + "    condoc,\r\n"
					+ "    condigver\r\n" + "FROM\r\n" + "    personas P,\r\n" + "    tdocide T\r\n" + "WHERE\r\n"
					+ "    T .tdoccod = contdoccod\r\n"
					+ "AND contpo = 'J' and conest='A' and condigver is not null\r\n" + "AND NOT EXISTS (\r\n"
					+ "    SELECT\r\n" + "        1\r\n" + "    FROM\r\n" + "        usuwebcontribuyente C\r\n"
					+ "    WHERE\r\n" + "        C .concod = P .concod\r\n" + ")\r\n" + "LIMIT 1");
			while (rs.next()) {
				tdoctpodoc = rs.getString("tdoctpodoc");
				condoc = rs.getString("condoc");
				condigver = rs.getString("condigver");
			}
		} catch (SQLException ex) {
			System.out.println("Error " + ex);
		}
		System.out.println(tdoctpodoc+" "+condoc+" "+condigver);
	}
	
	
	
	
	
	
	/**
	 * Devuelve la ultima planilla generada por la cuenta 801177
	 * @return
	 */
	private String Eliminar_planilla(String cuenta) {
		String planilla="";
		String planilla_test="";
		try {
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select waplanum from webautoliq where waest='P' and wapadcta='"+cuenta+"' order by waid DESC LIMIT 1");
			while(rs.next()) {				 
				
				
				planilla = rs.getString("waplanum");
												
				planilla_test = "Z"+planilla.substring(3, planilla.length());
					
					
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return planilla_test;
	}
	
	
	
	public void eliminarplanilla(String cuenta) {
		
		try {
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("update webautoliq\r\n" + 
					"set waest='I'\r\n" + 
					"from prefijoplanilla\r\n" + 
					"WHERE\r\n" + 
					"	waest = 'P'\r\n" + 
					"AND ppletra = substr(\r\n" + 
					"	CAST ('"+Eliminar_planilla(cuenta)+"' AS VARCHAR),\r\n" + 
					"	1,\r\n" + 
					"	1\r\n" + 
					")\r\n" + 
					"AND waplanum = ppsuma - 30000000 + CAST (\r\n" + 
					"	substr(\r\n" + 
					"		'"+Eliminar_planilla(cuenta)+"',\r\n" + 
					"		2,     \r\n" + 
					"		LENGTH ('Z000802') \r\n" + 
					"	) AS INTEGER\r\n" + 
					")");
			while (rs.next()) { 
				
			}
		} catch (SQLException ex) {
			System.out.println("Error " + ex);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * (HABILITAR=1 | DESHABILITAR=0)
	 * @param decision
	 */
	public void Habilitar_Deshabilitar(int decision) {
		String opcion;
		
		
		switch (decision) {
		case 0: opcion = "UPDATE parametrodinamico SET pardinvalnum = 0 where pardincod like '%_HABILITADO%'";
		break;
		
		case 1: opcion = "UPDATE parametrodinamico SET pardinvalnum = 1 where pardincod like '%_HABILITADO%'";
		break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + decision);
		}
		
		try {
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(opcion);
			while(rs.next()) {
				System.out.println(rs.getString("pardincod") + rs.getString("pardindes") + rs.getString("pardinvalchr") + " |||||||||||| " + rs.getString("pardinvalnum"));
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
