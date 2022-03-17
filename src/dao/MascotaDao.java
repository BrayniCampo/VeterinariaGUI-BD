package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import vo.MascotaVo;

public class MascotaDao {

	private Coordinador miCoordinador;

	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

	public String registrarMascotas(MascotaVo miAnimal) {
		
		String resultado="";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = conexion.getConnection();
		
		String consulta = "INSERT INTO mascotas (id_mascotas, nombre, raza, color, sexo, persona_id)"
							+"VALUES (?,?,?,?,?,?)";
		
		try {
			
			preStatement = connection.prepareStatement(consulta);
			preStatement.setLong(1, miAnimal.getIdMascota());
			preStatement.setString(2, miAnimal.getNombre());
			preStatement.setString(3, miAnimal.getRaza());
			preStatement.setString(4, miAnimal.getColorMascota());
			preStatement.setString(5, miAnimal.getSexo());
			preStatement.setLong(6, miAnimal.getIdDueno());
			preStatement.execute();
			resultado="Se ha registrado la mascota satisfactoriamente";
			
			
		}catch (SQLException e) {
			
			System.out.println("No se pudo registrar la mascota. Verifique que el dueño exista"
					+ e.getMessage());
					e.printStackTrace();
					resultado="No se pudo regitrar la mascota";
			
		}catch (Exception e) {
			
			System.out.println("Lo sentimos, no se pudo registrar la mascota. " + e.getMessage());
			e.printStackTrace();
			resultado="No se pudo registrar la mascota";
			
		}finally {
			conexion.desconectar();
		}
		
		return resultado;
	}
}
