package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import vo.PersonasProductoVo;
import vo.ProductoVo;

public class PersonaProductoDao {

	private Coordinador miCoordinador;
	private PersonasProductoVo personaProducto;
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}

	
	public String registrarProducto(PersonasProductoVo producto) {
		//Aqui se realizaria toda la logica de regisro de la persona
		String resultado="";
		Connection connection= null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement=null;
		
		connection = conexion.getConnection();
		String consulta="INSERT INTO personaProducto (idPersonaP)"+ "VALUES (?)";
		try {
			preStatement=connection.prepareStatement(consulta);
			//preStatement.setLong(1,miProducto.getIdProducto());
			//preStatement.setLong(1,producto.getProductoId());
			preStatement.setLong(1,producto.getPersonaId());
			
			preStatement.execute();
			
			resultado="ok";
		} catch (SQLException e) {
			System.out.println("No se pudo registrar la persona, verifique el documento exista"
					+e.getMessage());
			e.printStackTrace();
			resultado="No se pudo registrar la persona";
		}catch (Exception e) {
			System.out.println("No se pudo registrar la persona"+e.getMessage());
			e.printStackTrace();
			resultado="No se pudo registrar la persona";
		}
		finally{
			conexion.desconectar();
		}
		return resultado;
		
	}
	
	public PersonasProductoVo consultarProducto(Long idPersona) {
		PersonasProductoVo productoP=null;
		
		ResultSet  result=null;
		
		Connection connection=null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement=null;
		
		connection=conexion.getConnection();
		String consulta="SELECT * FROM personaProducto where idProducto=?";
		
		
		try {
			if(connection!=null) {
				preStatement=connection.prepareStatement(consulta);
				preStatement.setLong(1,idPersona);
				result=preStatement.executeQuery();
				
				if(result.next()) {
					productoP=new PersonasProductoVo();
					productoP.setPersonaId(result.getLong("idPersona"));
					productoP.setProductoId(result.getLong("idProducto"));
				}
				conexion.desconectar();
			}else {
				productoP=null;
			}
			
     	}catch (SQLException e) {
		System.out.println("No se pudo encontrar el producto, verifique que  exista"
				+e.getMessage());
		
	}
	return productoP;
		
	}

	
	
	public String eliminarProducto(Long idPersona) {
		
		String resultado="";
		Connection connection=null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement=null;
		
		connection=conexion.getConnection();
		String consulta="DELETE FROM personaProducto where idPersona=?";
		try {
		preStatement=connection.prepareStatement(consulta);
		preStatement.setLong(1,idPersona);
		
		preStatement.execute();
		resultado="ok";
	}catch (SQLException e) {
		System.out.println("No se pudo eliminar el producto, verifique el ID exista"
				+e.getMessage());
		e.printStackTrace();
		resultado="No se pudo eliminar el producto";
	}catch (Exception e) {
		System.out.println("No se pudo eliminar el producto"+e.getMessage());
		e.printStackTrace();
		resultado="No se pudo eliminar el producto";
	}
	finally{
		conexion.desconectar();
	}
	return resultado;
		
	}
	
	public String actualizarProducto(PersonasProductoVo miProducto) {
		
		String resultado="";
		Connection connection=null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement=null;
		
		connection=conexion.getConnection();
		String consulta="UPDATE personaProducto SET "
				+ "idPersona=?";
		
		try {
			preStatement=connection.prepareStatement(consulta);
			preStatement.setLong(1,miProducto.getPersonaId());
			
			
			preStatement.executeUpdate();
			resultado="ok";
		} catch (SQLException e) {
			System.out.println("No se pudo actualizar la persona, verifique que el producto exista"
					+e.getMessage());
			
			resultado="No se pudo actualizar el producto";
		}
		finally{
			
			conexion.desconectar();
		}
		return resultado;
		
		
	}

}
