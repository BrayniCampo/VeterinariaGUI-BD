package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import vo.PersonaVo;
import vo.ProductoVo;

public class ProductoDao {

	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}

	public String registrarProducto(ProductoVo miProducto) {
		//Aqui se realizaria toda la logica de regisro de la persona
		String resultado="";
		Connection connection= null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement=null;
		
		connection = conexion.getConnection();
		String consulta="INSERT INTO producto (nombreProducto,precioProducto)"+ "VALUES (?,?)";
		try {
			preStatement=connection.prepareStatement(consulta);
			//preStatement.setLong(1,miProducto.getIdProducto());
			preStatement.setString(1,miProducto.getNombreProducto());
			preStatement.setDouble(2,miProducto.getPrecioProducto());
			
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
	
	public String consultarProducto(Long idProducto) {
		String resultado="";
		Connection connection=null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement=null;
		
		connection=conexion.getConnection();
		String consulta="DELETE FROM producto where idProducto=?";
		try {
		preStatement=connection.prepareStatement(consulta);
		preStatement.setLong(1,idProducto);
		
		preStatement.execute();
		resultado="ok";
	}catch (SQLException e) {
		System.out.println("No se pudo eliminar la persona, verifique el documento exista"
				+e.getMessage());
		e.printStackTrace();
		resultado="No se pudo eliminar la persona";
	}catch (Exception e) {
		System.out.println("No se pudo eliminar la persona"+e.getMessage());
		e.printStackTrace();
		resultado="No se pudo eliminar la persona";
	}
	finally{
		conexion.desconectar();
	}
	return resultado;
		
	}

		
	
	public String eliminarProducto(Long idProducto) {
		
		String resultado="";
		Connection connection=null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement=null;
		
		connection=conexion.getConnection();
		String consulta="DELETE FROM producto where idProducto=?";
		try {
		preStatement=connection.prepareStatement(consulta);
		preStatement.setLong(1,idProducto);
		
		preStatement.execute();
		resultado="ok";
	}catch (SQLException e) {
		System.out.println("No se pudo eliminar la persona, verifique el documento exista"
				+e.getMessage());
		e.printStackTrace();
		resultado="No se pudo eliminar la persona";
	}catch (Exception e) {
		System.out.println("No se pudo eliminar la persona"+e.getMessage());
		e.printStackTrace();
		resultado="No se pudo eliminar la persona";
	}
	finally{
		conexion.desconectar();
	}
	return resultado;
		
	}

}
