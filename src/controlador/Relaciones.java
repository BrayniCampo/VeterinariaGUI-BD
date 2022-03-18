package controlador;
import dao.MascotaDao;
import dao.NacimientoDao;
import dao.PersonaDao;
import dao.PersonaProductoDao;
import dao.ProductoDao;
import gui.ActualizarMascotas;
import gui.ActualizarProductos;
import gui.ConsultarMascotas;
import gui.ConsultarPersonaGUI;
import gui.ConsultarProducto;
import gui.EliminarMascotasGUI;
import gui.EliminarProductos;
import gui.ListarMascotasGUI;
import gui.RegistrarMascotasGui;
import gui.RegistrarPersonasGui;
import gui.RegistrarProductosGui;
import gui.VentanaPrincipal;

public class Relaciones {
	
	public Relaciones() {
		
		VentanaPrincipal miVentanaPrincipal;
		RegistrarPersonasGui miRegistrarPersonasGui;
		RegistrarMascotasGui miRegistrarMascotasGui;
		RegistrarProductosGui miRegistrarProductosGui;
		Coordinador miCoordinador;
		PersonaDao miPersonaDao;
		NacimientoDao miNacimientoDao;
		MascotaDao miMascotaDao;
		ProductoDao miProductoDao;
		PersonaProductoDao miPersonaProductoDao;
		ConsultarPersonaGUI miConsultarPersonaGui;
		EliminarProductos miEliminarProductos;
		ConsultarProducto miConsultarProducto;
		ActualizarProductos miActualizarProducto;
		ActualizarMascotas miActualizarMascotas;
		ConsultarMascotas miConsultarMascotas;
		EliminarMascotasGUI miEliminarMascotasGui;
		ListarMascotasGUI miListandoMascotasGui;

		
		miVentanaPrincipal= new VentanaPrincipal();
		miRegistrarPersonasGui= new RegistrarPersonasGui(miVentanaPrincipal, true);
		miRegistrarMascotasGui= new RegistrarMascotasGui(miVentanaPrincipal, true,"");
		miRegistrarProductosGui= new RegistrarProductosGui(miVentanaPrincipal, true);
		miConsultarPersonaGui=new ConsultarPersonaGUI(miVentanaPrincipal, true);
		miEliminarProductos=new EliminarProductos(miVentanaPrincipal,true);
		miConsultarProducto=new ConsultarProducto(miVentanaPrincipal,true);
		miActualizarProducto=new ActualizarProductos(miVentanaPrincipal,true);
		miActualizarMascotas= new ActualizarMascotas(miVentanaPrincipal,true);
		miConsultarMascotas= new ConsultarMascotas(miVentanaPrincipal, true);
		miEliminarMascotasGui= new EliminarMascotasGUI(miVentanaPrincipal, true);
		miListandoMascotasGui = new ListarMascotasGUI(miVentanaPrincipal, true);
		
		
		
		miCoordinador= new Coordinador();
		miPersonaDao= new PersonaDao();
		miMascotaDao= new MascotaDao();
		miNacimientoDao= new NacimientoDao();
		miProductoDao= new ProductoDao();
		miPersonaProductoDao= new PersonaProductoDao();
		
		
		miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setRegistrarPersonasGui(miRegistrarPersonasGui);
		miCoordinador.setRegistrarMascotasGui(miRegistrarMascotasGui);
		miCoordinador.setRegistrarProductosGui(miRegistrarProductosGui);
		miCoordinador.setPersonaDao(miPersonaDao);
		miCoordinador.setMascotaDao(miMascotaDao);
		miCoordinador.setNacimientoDao(miNacimientoDao);
		miCoordinador.setProductoDao(miProductoDao);
		miCoordinador.setPersonaProductoDao(miPersonaProductoDao);
		miCoordinador.setConsultarPersonaGUI(miConsultarPersonaGui);
		miCoordinador.setEliminarProductos(miEliminarProductos);
		miCoordinador.setConsultarProducto(miConsultarProducto);
		miCoordinador.setActualizarProductos(miActualizarProducto);
		miCoordinador.setActualizarMascotas(miActualizarMascotas);
		miCoordinador.setConsultarMascotas(miConsultarMascotas);
		miCoordinador.setEliminarMascotas(miEliminarMascotasGui);
		miCoordinador.setListarMascotas(miListandoMascotasGui);

		//A cada clase unica se le asigna la unica instancia del coordinador
		miVentanaPrincipal.setCoordinador(miCoordinador);
		miRegistrarPersonasGui.setCoordinador(miCoordinador);
		miRegistrarMascotasGui.setCoordinador(miCoordinador);
		miRegistrarProductosGui.setCoordinador(miCoordinador);
		miPersonaDao.setCoordinador(miCoordinador);
		miNacimientoDao.setCoordinador(miCoordinador);
		miMascotaDao.setCoordinador(miCoordinador);
		miProductoDao.setCoordinador(miCoordinador);
		miPersonaProductoDao.setCoordinador(miCoordinador);
		miConsultarPersonaGui.setCoordinador(miCoordinador);
		miEliminarProductos.setCoordinador(miCoordinador);
		miConsultarProducto.setCoordinador(miCoordinador);
		miActualizarProducto.setCoordinador(miCoordinador);
		miActualizarMascotas.setCoordinador(miCoordinador);
		miConsultarMascotas.setCoordinador(miCoordinador);
		miEliminarMascotasGui.setCoordinador(miCoordinador);
		miListandoMascotasGui.setCoordinador(miCoordinador);

		//Se muestra la ventana principal.
		miVentanaPrincipal.setVisible(true);
}

}