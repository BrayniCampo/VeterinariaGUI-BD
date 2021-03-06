package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import vo.Nacimiento;
import vo.PersonaVo; 

public class PersonaDao {
	
	private Coordinador micoordinador;
	
	public void setCoordinador (Coordinador miCoordinador) {
		this.micoordinador=miCoordinador;
	}
	public String registrarPersona(PersonaVo miPersona) {
		//Aqui se realizaria toda la logica de regisro de la persona
		String resultado="";
		Connection connection= null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement=null;
		
		connection = conexion.getConnection();
		String consulta="INSERT INTO persona (id_persona,nombre_persona,profesion_persona,telefono_persona,tipo_persona,nacimiento_id)"+ "VALUES (?,?,?,?,?,?)";
		try {
			preStatement=connection.prepareStatement(consulta);
			preStatement.setLong(1,miPersona.getIdPersona());
			preStatement.setString(2,miPersona.getNombre());
			preStatement.setString(3,miPersona.getProfesion());
			preStatement.setString(4,miPersona.getTelefono());
			preStatement.setInt(5,miPersona.getTipo());
			preStatement.setLong(6,miPersona.getNacimiento().getIdNacimiento());
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
	
	public PersonaVo consultarPersona(Long idDocumento) {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		PersonaVo miPersona=null;
		Nacimiento miNacimiento=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM persona where id_persona= ? ";
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, idDocumento);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					miPersona=new PersonaVo();
					miPersona.setIdPersona(result.getLong("id_persona"));
					miPersona.setNombre(result.getString("nombre_persona"));
					miPersona.setProfesion(result.getString("profesion_persona"));
					miPersona.setTelefono(result.getString("telefono_persona"));
					miPersona.setTipo(result.getInt("tipo_persona"));
					
					miNacimiento =new Nacimiento();
					miNacimiento.setIdNacimiento(Long.parseLong(result.getString("nacimiento_id")));
					miPersona.setNacimiento(miNacimiento);		
				}		
				   miConexion.desconectar();
			}else{
				miPersona=null;
			}			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona: "+e.getMessage());
		}
			return miPersona;

	}
	
	public Nacimiento consultarNacimiento(Long idNacimiento) {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
				
		connection=miConexion.getConnection();
		
		Nacimiento miNacimiento = null;
		
		String consulta="SELECT * FROM nacimiento where id_nacimiento= ? ";
		
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, idNacimiento);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					miNacimiento=new Nacimiento();
					miNacimiento.setIdNacimiento(result.getLong("id_nacimiento"));
					miNacimiento.setCiudadNacimiento(result.getString("ciudad_nacimiento"));
					miNacimiento.setDepartamentoNacimiento(result.getString("departamento_nacimiento"));
					miNacimiento.setPaisNacimiento(result.getString("pais_nacimiento"));
					miNacimiento.setFechaNacimiento(LocalDate.parse(result.getDate("fecha_nacimiento")+""));
				}		
				   miConexion.desconectar();
			}						   
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("Error en la consulta de la persona: "+e.getMessage());
		}
		return miNacimiento;		
	}

	public ArrayList<PersonaVo> imprimirPersonas() {
		ArrayList<PersonaVo> personas = new ArrayList<PersonaVo>();
		Connection connection=null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		PersonaVo miPersona=null;
		Nacimiento miNacimiento=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM persona";
		
		try {
			
			if(connection!=null) {
				statement=connection.prepareStatement(consulta);

				result=statement.executeQuery();
				
				while(result.next()==true) {
					miPersona=new PersonaVo();
					miPersona.setIdPersona(result.getLong("id_persona"));
					miPersona.setNombre(result.getString("nombre_persona"));
					miPersona.setProfesion(result.getString("profesion_persona"));
					miPersona.setTelefono(result.getString("telefono_persona"));
					miPersona.setTipo(result.getInt("tipo_persona"));
					
					
					miNacimiento=micoordinador.consultarNacimiento(result.getLong("nacimiento_id"));

					miPersona.setNacimiento(miNacimiento);
					
					personas.add(miPersona);
				}
				
				miConexion.desconectar();
				
			}else {
				miPersona=null;
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error en la consulta de la persona: "+e.getMessage());
		}
		return personas;
	}
	
	
	
	
	public String actualizarPersona(PersonaVo p) {
		
		String resultado="";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement preStatement = null;
		connection = miConexion.getConnection();
		
		String consulta="UPDATE persona "
				+ " SET nombre_persona= ?, profesion_persona = ?, telefono_persona = ?, tipo_persona = ?, nacimiento_id = ?"
				+ " WHERE id_persona =?";
		
		try {
			
			preStatement = connection.prepareStatement(consulta);
			
			preStatement.setString(1, p.getNombre());
			preStatement.setString(2, p.getProfesion());
			preStatement.setString(3, p.getTelefono());
			preStatement.setInt(4, p.getTipo());
			preStatement.setLong(5, p.getNacimiento().getIdNacimiento());
			preStatement.setLong(6, p.getIdPersona());
			
			preStatement.executeUpdate();
			
			resultado="ok";
			
			miConexion.desconectar();	
			
		} catch (SQLException e) {
			System.out.println("Error en la inserccion de datos de persona:"+e);
			resultado="No Logrado";
		}
		
		return resultado;
		
	}

public String eliminarPersona(Long idPersona) {
		
		String resultado="";
		Connection connection=null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement=null;
		
		connection=conexion.getConnection();
		String consulta="DELETE FROM persona where id_persona=?";
		try {
		preStatement=connection.prepareStatement(consulta);
		preStatement.setLong(1,idPersona);
		
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


	
	

