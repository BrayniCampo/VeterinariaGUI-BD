package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import vo.PersonaVo;
import vo.ProductoVo;

public class ProductoDao {

	private Coordinador miCoordinador;
	private ProductoVo miProducto;

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
	
	public ProductoVo consultarProducto(Long idProducto) {
		ProductoVo miProducto=null;
		
		ResultSet  result=null;
		
		Connection connection=null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement=null;
		
		connection=conexion.getConnection();
		String consulta="SELECT * FROM producto where idProducto=?";
		
		
		try {
			if(connection!=null) {
				preStatement=connection.prepareStatement(consulta);
				preStatement.setLong(1,idProducto);
				result=preStatement.executeQuery();
				
				if(result.next()) {
					miProducto=new ProductoVo();
					miProducto.setNombreProducto(result.getString("nombreProducto"));
					miProducto.setPrecioProducto(result.getDouble("precioProducto"));
				}
				conexion.desconectar();
			}else {
				miProducto=null;
			}
			
     	}catch (SQLException e) {
		System.out.println("No se pudo encontrar el producto, verifique que  exista"
				+e.getMessage());
		
	}
	return miProducto;
		
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
	
	public String actualizarProducto(ProductoVo miProducto) {
		
		String resultado="";
		Connection connection=null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement=null;
		
		connection=conexion.getConnection();
		String consulta="UPDATE producto"+"SET nombreProducto=?,"+"precioProducto=?"+"where idProducto=?";
		try {
			preStatement=connection.prepareStatement(consulta);
			preStatement.setString(1,miProducto.getNombreProducto());
			preStatement.setDouble(2,miProducto.getPrecioProducto());
			preStatement.setLong(3,miProducto.getIdProducto());
			
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
