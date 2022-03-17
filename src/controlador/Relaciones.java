package controlador;
import dao.MascotaDao;
import dao.NacimientoDao;
import dao.PersonaDao;
import dao.PersonaProductoDao;
import dao.ProductoDao;
import gui.ConsultarPersonaGUI;
import gui.ConsultarProducto;
import gui.EliminarProductos;
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

		
		miVentanaPrincipal= new VentanaPrincipal();
		miRegistrarPersonasGui= new RegistrarPersonasGui(miVentanaPrincipal, true);
		miRegistrarMascotasGui= new RegistrarMascotasGui(miVentanaPrincipal, true,"");
		miRegistrarProductosGui= new RegistrarProductosGui(miVentanaPrincipal, true);
		miConsultarPersonaGui=new ConsultarPersonaGUI(miVentanaPrincipal, true);
		miEliminarProductos=new EliminarProductos(miVentanaPrincipal,true);
		miConsultarProducto=new ConsultarProducto(miVentanaPrincipal,true);
		
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

		//Se muestra la ventana principal.
		miVentanaPrincipal.setVisible(true);
}

}