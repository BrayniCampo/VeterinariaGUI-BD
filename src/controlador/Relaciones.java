package controlador;
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

public class Relaciones {
	
	public Relaciones() {
		
		VentanaPrincipal miVentanaPrincipal;
		RegistrarPersonasGui miRegistrarPersonasGui;
		ListarPersonasGui miListarPersonasGui;
		ActualizarPersonasGui miActualizarPersonasGui;
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
		ListarProductos miListarProductos;
		EliminarPersonas miEliminarPersona;

		
		miVentanaPrincipal= new VentanaPrincipal();
		miRegistrarPersonasGui= new RegistrarPersonasGui(miVentanaPrincipal, true);
		miListarPersonasGui= new ListarPersonasGui();
		miListarProductos=new ListarProductos(miVentanaPrincipal,true);
		miActualizarPersonasGui = new ActualizarPersonasGui(miVentanaPrincipal,true);
		miRegistrarMascotasGui= new RegistrarMascotasGui(miVentanaPrincipal, true,"");
		miRegistrarProductosGui= new RegistrarProductosGui(miVentanaPrincipal, true);
		miConsultarPersonaGui=new ConsultarPersonaGUI(miVentanaPrincipal, true);
		miEliminarProductos=new EliminarProductos(miVentanaPrincipal,true);
		miEliminarPersona=new EliminarPersonas (miVentanaPrincipal,true);
		miConsultarProducto=new ConsultarProducto(miVentanaPrincipal,true);
		miActualizarProducto=new ActualizarProductos(miVentanaPrincipal,true);
		
		miCoordinador= new Coordinador();
		miPersonaDao= new PersonaDao();
		miMascotaDao= new MascotaDao();
		miNacimientoDao= new NacimientoDao();
		miProductoDao= new ProductoDao();
		miPersonaProductoDao= new PersonaProductoDao();
		
		
		miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setRegistrarPersonasGui(miRegistrarPersonasGui);
		miCoordinador.setListarPersonasGui(miListarPersonasGui);
		miCoordinador.setActualizarPersona(miActualizarPersonasGui);
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
		miCoordinador.setEliminarPersona(miEliminarPersona);
		miCoordinador.setListarProductos(miListarProductos);

		//A cada clase unica se le asigna la unica instancia del coordinador
		miVentanaPrincipal.setCoordinador(miCoordinador);
		miRegistrarPersonasGui.setCoordinador(miCoordinador);
		miListarPersonasGui.setMiCoordinador(miCoordinador);
		miActualizarPersonasGui.setMiCoordinador(miCoordinador);
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
		miListarProductos.setCoordinador(miCoordinador);
		miEliminarPersona.setCoordinador(miCoordinador);

		//Se muestra la ventana principal.
		miVentanaPrincipal.setVisible(true);
}

}