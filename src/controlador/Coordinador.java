package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.MascotaDao;
import dao.NacimientoDao;
import dao.PersonaDao;
import dao.PersonaProductoDao;
import dao.ProductoDao;
import gui.ActualizarPersonasGui;
import gui.ActualizarProductos;
import gui.ConsultarPersonaGUI;
import gui.ConsultarProducto;
import gui.EliminarPersonas;
import gui.EliminarProductos;
import gui.ListarPersonasGui;
import gui.ListarProductos;
import gui.RegistrarMascotasGui;
import gui.RegistrarPersonasGui;
import gui.RegistrarProductosGui;
import gui.VentanaPrincipal;
import vo.Nacimiento;
import vo.PersonaVo;
import vo.PersonasProductoVo;
import vo.ProductoVo;
public class Coordinador {
	
	VentanaPrincipal miVentanaPrincipal;
	RegistrarPersonasGui miRegistrarPersonasGui;
	ListarPersonasGui miListarPersonasGui;
	ActualizarPersonasGui miActualizarPersonasGui;
	RegistrarMascotasGui miRegistrarMascotasGui;
	RegistrarProductosGui miRegistrarProductosGui;
	PersonaDao miPersonaDao;
	NacimientoDao miNacimientoDao;
	MascotaDao miMascotaDao;
	ProductoDao miProductoDao;
	PersonaProductoDao miPersonaProductoDao;
	ConsultarPersonaGUI consultarPersona;
	EliminarProductos miEliminarProducto;
	ConsultarProducto miConsultarProducto;
	ActualizarProductos miActualizarProducto;
	ListarProductos listarProductos;
	EliminarPersonas eliminarPersona;
	

	public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
	this.miVentanaPrincipal=miVentanaPrincipal;
	}

	
	public void setRegistrarPersonasGui(RegistrarPersonasGui miRegistrarPersonasGui) {
	this.miRegistrarPersonasGui=miRegistrarPersonasGui;
	}

	public void setEliminarPersona(EliminarPersonas eliminarPersona) {
		this.eliminarPersona=eliminarPersona;
	}
	public void setRegistrarMascotasGui(RegistrarMascotasGui miRegistrarMascotasGui) {
	this.miRegistrarMascotasGui=miRegistrarMascotasGui;
	}

	public void setRegistrarProductosGui(RegistrarProductosGui miRegistrarProductosGui){

	this.miRegistrarProductosGui=miRegistrarProductosGui;
	}
	
	public void setEliminarProductos(EliminarProductos miEliminarProducto) {
		this. miEliminarProducto=miEliminarProducto;
	}
	
	public void setConsultarProducto(ConsultarProducto miConsultarProducto) {
		this.miConsultarProducto=miConsultarProducto;
	}

	public void setPersonaDao(PersonaDao miPersonaDao) {
	this.miPersonaDao=miPersonaDao;
	}

	public void setMascotaDao(MascotaDao miMascotaDao) {
	this.miMascotaDao=miMascotaDao;
	}

	public void setNacimientoDao(NacimientoDao miNacimientoDao) {
	this.miNacimientoDao=miNacimientoDao;
	}

	public void setProductoDao(ProductoDao miProductoDao) {
	this.miProductoDao=miProductoDao;
	}

	public void setPersonaProductoDao(PersonaProductoDao miPersonaProductoDao) {
	this.miPersonaProductoDao=miPersonaProductoDao;
	}
	
	public void setConsultarPersonaGUI(ConsultarPersonaGUI miConsultarPersonaGui) {
		// TODO Auto-generated method stub
		this.consultarPersona=miConsultarPersonaGui;
	}
	
	public void setActualizarProductos(ActualizarProductos miActualizarProducto) {
		this.miActualizarProducto=miActualizarProducto;
		
	}
	public PersonaVo setConsultarPersona(Long idDocumento) {
		return miPersonaDao.consultarPersona(idDocumento);
	}
	
	public Nacimiento consultarNacimiento(Long idNacimiento) {
		return miNacimientoDao.consultarNacimiento(idNacimiento);
		}
	

	public void mostrarVentanaRegistroMascotas() {
		miRegistrarMascotasGui.setVisible(true);
	}
	
	

	public void mostrarVentanaRegistroPersonas() {
		miRegistrarPersonasGui.setVisible(true);
	}
	
	public void mostrarVentanaRegistroProductos() {
		miRegistrarProductosGui.setVisible(true);
		
	}
	
	public String registrarPersona(PersonaVo miPersona) {
		return miPersonaDao.registrarPersona(miPersona);
	}

	public Long registrarNacimiento(PersonaVo miPersona) {
		return miNacimientoDao.registrarNacimiento(miPersona.getNacimiento());
	}

	public void mostrarVentanaConsultaPersonas() {
		consultarPersona.setVisible(true);
		
	}
	
	public void mostrarVentanaEliminarProductos() {
		miEliminarProducto.setVisible(true);
	}
	
	public void mostrarVentanaEliminarPersona() {
		eliminarPersona.setVisible(true);
	}
	public void mostrarVentanaActualizarProductos() {
		miActualizarProducto.setVisible(true);
	}

	public String registrarProducto(ProductoVo miProducto) {
	
		return miProductoDao.registrarProducto(miProducto);
	}

	public String  eliminarProducto(Long idProducto) {
		return miProductoDao.eliminarProducto(idProducto);
	}

	public String eliminarPersona(Long idPersona) {
		return miPersonaDao.eliminarPersona(idPersona);
	}
	public void mostrarVentanaConsultaProductos() {
		miConsultarProducto.setVisible(true);
		
	}

	public ProductoVo obtenerProducto(Long idProducto) {
		return miProductoDao.consultarProducto(idProducto);
	}

	public String actualizarProductos(ProductoVo miProducto) {
		return miProductoDao.actualizarProducto(miProducto);
	}
	public void mostrarVentanalistarProductos() {
		ArrayList<ProductoVo> producto = miProductoDao.imprimirProductos();
		listarProductos.llenar(producto);
		listarProductos.setVisible(true);
		
		}
		
	

	public String crearProducto(PersonasProductoVo miproductoPers) {
		return	miPersonaProductoDao.registrarProducto(miproductoPers);
	}
	public void setListarPersonasGui(ListarPersonasGui miListarPersonasGui) {
		// TODO Auto-generated method stub
		this.miListarPersonasGui = miListarPersonasGui;
	}
	
	public void setListarProductos(ListarProductos listarProductos) {
		this.listarProductos=listarProductos;
	}
	public void mostrarListarPersonas() {
		ArrayList<PersonaVo> personas = miPersonaDao.imprimirPersonas();
		miListarPersonasGui.setVisible(true);
		miListarPersonasGui.llenar(personas);
	}
	public void setActualizarPersona(ActualizarPersonasGui miActualizarPersonasGui) {
		// TODO Auto-generated method stub
		this.miActualizarPersonasGui = miActualizarPersonasGui;
	}
	public void mostrarActualizarPersonasGui() {
		miActualizarPersonasGui.setVisible(true);
	}
	public String actualizarNacimiento(Nacimiento nacimiento) {
		// TODO Auto-generated method stub
		return miNacimientoDao.actualizarNacimiento(nacimiento);
	}
	public String actualizarPersona(PersonaVo p) {
		// TODO Auto-generated method stub
		return miPersonaDao.actualizarPersona(p);
	}

	

	

	

	


}
