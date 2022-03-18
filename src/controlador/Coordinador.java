package controlador;
import java.awt.Dialog;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.MascotaDao;
import dao.NacimientoDao;
import dao.PersonaDao;
import dao.PersonaProductoDao;
import dao.ProductoDao;
import gui.ActualizarMascotas;
import gui.ActualizarProductos;
import gui.ConsultarPersonaGUI;
import gui.ConsultarProducto;
import gui.EliminarMascotasGUI;
import gui.EliminarProductos;
import gui.ListarMascotasGUI;
import gui.RegistrarMascotasGui;
import gui.RegistrarPersonasGui;
import gui.RegistrarProductosGui;
import gui.VentanaPrincipal;
import vo.MascotaVo;
import vo.Nacimiento;
import vo.PersonaVo;
import vo.ProductoVo;
public class Coordinador {
	
	VentanaPrincipal miVentanaPrincipal;
	RegistrarPersonasGui miRegistrarPersonasGui;
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
	ActualizarMascotas miActualizarMascota;
	gui.ConsultarMascotas miConsultarMascotas;
	EliminarMascotasGUI miEliminarMascotasGUI;
	private ListarMascotasGUI miListandoMascotasGui;
	


	public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
	this.miVentanaPrincipal=miVentanaPrincipal;
	}

	public void setRegistrarPersonasGui(RegistrarPersonasGui miRegistrarPersonasGui) {
	this.miRegistrarPersonasGui=miRegistrarPersonasGui;
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
	public void mostrarVentanaConsultarMascotas() {
		miConsultarMascotas.setVisible(true);
		
	}
	public void mostrarVentanaEliminarMascotas() {
		miEliminarMascotasGUI.setVisible(true);
		
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
	public void mostrarVentanaActualizarProductos() {
		miActualizarProducto.setVisible(true);
	}
	
	public void mostrarVentanaActualizarMascotas() {
		miActualizarMascota.setVisible(true);
	}
	
	public void mostrarVentanaListarMascotas() {
		ArrayList<MascotaVo> mascotas = miMascotaDao.imprimirMascotas();
		miListandoMascotasGui.setVisible(true);
		miListandoMascotasGui.ListandoAnimales(mascotas);
	}
	


	public String registrarProducto(ProductoVo miProducto) {
	
		return miProductoDao.registrarProducto(miProducto);
	}

	public String  eliminarProducto(Long idProducto) {
		return miProductoDao.eliminarProducto(idProducto);
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

	public String RegistrarMascotasGui(MascotaVo miAnimal) {
		// TODO Auto-generated method stub
		return miMascotaDao.registrarMascotas(miAnimal);
	}

	public void setActualizarMascotas(ActualizarMascotas miActualizarMascotas) {
		// TODO Auto-generated method stub
		this.miActualizarMascota=miActualizarMascotas;
	}
	

	public String actualizarMascotas(MascotaVo miAnimal) {
		// TODO Auto-generated method stub
		return miMascotaDao.actualizarMascotar(miAnimal);
	}

	public MascotaVo ConsultarMascotas(Long idMascota) {
		return miMascotaDao.consultarMascotas(idMascota);
	}

	public void setConsultarMascotas(gui.ConsultarMascotas miConsultarMascotas) {
		this.miConsultarMascotas=miConsultarMascotas;
		
	}

	public String eliminarMascotas(MascotaVo miAnimal) {
		// TODO Auto-generated method stub
		return miMascotaDao.eliminarMascotas(miAnimal);
	}

	public void setEliminarMascotas(EliminarMascotasGUI miEliminarMascotasGui) {
		
		this.miEliminarMascotasGUI=miEliminarMascotasGui;
		
	}

	public void setListarMascotas(ListarMascotasGUI miListandoMascotasGui) {
		
		this.miListandoMascotasGui=miListandoMascotasGui;
		
	}







}
