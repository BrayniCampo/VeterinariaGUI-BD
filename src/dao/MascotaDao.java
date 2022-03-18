package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	
	public String actualizarMascotar(MascotaVo miAnimal) {
		
		String resultado="";
		Connection connection=null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement=null;
		
		connection=conexion.getConnection();
		
		String consulta= "UPDATE mascotas "+"SET color= ?, nombre=?, raza=?, sexo=?"+ "WHERE id_mascotas=?";
		
		try {
			
			preStatement=connection.prepareStatement(consulta);
			preStatement.setString(1, miAnimal.getColorMascota());
			preStatement.setString(2,miAnimal.getNombre());
			preStatement.setString(3, miAnimal.getRaza());
			preStatement.setString(4,  miAnimal.getSexo());
			preStatement.setLong(5, miAnimal.getIdMascota());
			
			preStatement.executeUpdate();
			resultado="perfecto";
		}catch (Exception e) {
			
			System.out.println("No se puede actualizar esta mascota. Verifique que esta exista"
					+e.getMessage());
			
			resultado="No se pudo actualizar los datos de la mascota";
		}finally{
			
			conexion.desconectar();
		}
		return resultado;
	}
	
	public MascotaVo consultarMascotas (Long idMascota) {
		
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;
		
		MascotaVo miAnimal = null;
		
		connection = miConexion.getConnection();
		
		String Consulta = "SELECT * FROM mascotas where id_mascotas=?";
		
		
		try {
			
			if(connection !=null) {
				statement = connection.prepareStatement(Consulta);
				statement.setLong(1, idMascota);
				result = statement.executeQuery();
				
				while(result.next() == true) {
					
					miAnimal = new MascotaVo();
					miAnimal.setIdMascota(result.getLong("id_mascotas"));
					miAnimal.setNombre(result.getString("nombre"));
					miAnimal.setRaza(result.getString("raza"));
					miAnimal.setColorMascota(result.getString("color"));
					miAnimal.setSexo(result.getString("sexo"));
					miAnimal.setIdDueno(result.getLong("persona_id"));
					
				
				}
				
				miConexion.desconectar();
			} else {
				
				miAnimal = null;
			}
		}catch (SQLException e) {			
			System.out.println("Hubo error en la consulta " +e.getMessage());
		}
		
		return miAnimal;
	}
	
	
	public String eliminarMascotas(MascotaVo miAnimal) {
		
		String resultado="";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement  preStatement = null;
		connection = miConexion.getConnection();
		
		String consulta="DELETE FROM mascotas WHERE id_mascotas =?";
		
		try {
			
			preStatement = connection.prepareStatement(consulta);
			
			preStatement.setLong(1,miAnimal.getIdMascota());
			preStatement.executeUpdate();
			
			resultado="perfecto";
			
			miConexion.desconectar();
		}catch (SQLException e) {
			
			System.out.println("ERROOOOR EN ELIMINAR MASCOTAS");
			resultado="Sorry ";
		}
		
		return resultado;
				
	}
	
	public ArrayList<MascotaVo> imprimirMascotas() {
		ArrayList<MascotaVo> mascotas = new ArrayList<MascotaVo>();
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		MascotaVo miMascota = null;

		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM mascotas";

		try {

			if (connection != null) {
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();

				while (result.next() == true) {
					miMascota = new MascotaVo();

					miMascota.setIdMascota(result.getLong("id_mascotas"));
					miMascota.setNombre(result.getString("nombre"));
					miMascota.setColorMascota(result.getString("color"));
					miMascota.setRaza(result.getString("raza"));
					miMascota.setSexo(result.getString("sexo"));
					miMascota.setIdDueno(result.getLong("persona_id"));

					mascotas.add(miMascota);
				}

				miConexion.desconectar();

			} else {
				miMascota = null;
			}

		} catch (SQLException e) {
			System.out.println("Error en la consulta de la mascota: " + e.getMessage());
		}
		return mascotas;
	}
}
