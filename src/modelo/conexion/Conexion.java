package modelo.conexion;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
 
	private String nombreBd="bd_clinica";
	private String usuario="root";
	private String password="Sena1234";
	private String url="jdbc:mysql://localhost:3306/"+nombreBd+"?useUnicode=true&use"
						+"JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
						+"serverTimezone=UTC";
	
	Connection conn=null;
	
	public Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,usuario,password);
			if(conn!=null) {
				System.out.println("Conexion Exitosa a la BD:"+nombreBd);
			}else {
				System.out.println("*********No se pudo conectar"+nombreBd);
			
			}
		}catch (SQLException e) {
			System.out.println("Ocurre una SQLException: "+e.getMessage());
			System.out.println("Verifique que Mysql este encendido...");
		} catch (ClassNotFoundException e) {		
			System.out.println("Ocurre una ClassNotFoundException " +e.getMessage());
		}
	}
	
	public Connection getConnection() {
		return conn;
	}
	public void desconectar() {
		conn=null;
	}
	
}
