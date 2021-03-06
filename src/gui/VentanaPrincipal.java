package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private AbstractButton itemRegistrarPersonas;
	private JMenuItem itemConsultarPersonas;
	private JMenuItem itemEliminarPersonas;
	private JMenuItem itemRegistrarMascotas;
	private JMenuItem itemConsultarMascotas;
	private JMenuItem itemActualizarMascotas;
	private JMenuItem itemEliminarMascotas;
	private JMenuItem itemEliminarProductos;
	private JMenuItem itemActualizarProductos;
	private JMenuItem itemConsultaProductos;
	private JMenuItem itemRegistroProductos;
	private JMenuItem itemActualizarPersonas;
	private JMenuItem itemListarMascotas;
	private JMenuBar menuBar;
	private JMenu menuPersonas;
	private JMenu MenuMascotas;
	private JMenu menuProductos;
	private JLabel lblTitulo;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblImagen;
	private Coordinador miCoordinador;

	
	public VentanaPrincipal() {
		iniciarComponentes();	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,500);
		setResizable(false);
		setTitle("Clinica Veterinaria");
		setLocationRelativeTo(null);
	}

	private void iniciarComponentes() {
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuPersonas = new JMenu("Gestionar Personas");
		menuBar.add(menuPersonas);
		
		itemRegistrarPersonas = new JMenuItem("Registrar");
		itemRegistrarPersonas.addActionListener(this);
		menuPersonas.add(itemRegistrarPersonas);
		
		itemConsultarPersonas = new JMenuItem("Consultar");
		itemConsultarPersonas.addActionListener(this);
		menuPersonas.add(itemConsultarPersonas);
		
		itemActualizarPersonas = new JMenuItem("Actualizar");
		itemActualizarPersonas.addActionListener(this);
		menuPersonas.add(itemActualizarPersonas);
		
		itemEliminarPersonas = new JMenuItem("Eliminar");
		itemEliminarPersonas.addActionListener(this);
		menuPersonas.add(itemEliminarPersonas);
		

		MenuMascotas = new JMenu("Gestionar Mascotas");
		menuBar.add(MenuMascotas);
		
		itemRegistrarMascotas = new JMenuItem("Registrar");
		itemRegistrarMascotas.addActionListener(this);
		MenuMascotas.add(itemRegistrarMascotas);
		
		itemConsultarMascotas = new JMenuItem("Consultar");
		itemConsultarMascotas.addActionListener(this);
		MenuMascotas.add(itemConsultarMascotas);
		
		itemActualizarMascotas = new JMenuItem("Actualizar");
		itemActualizarMascotas.addActionListener(this);
		MenuMascotas.add(itemActualizarMascotas);
		
		itemEliminarMascotas = new JMenuItem("Eliminar");
		itemEliminarMascotas.addActionListener(this);
		MenuMascotas.add(itemEliminarMascotas);
		
		itemListarMascotas = new JMenuItem("Listar");
		itemListarMascotas.addActionListener(this);
		MenuMascotas.add(itemListarMascotas);
		
		menuProductos = new JMenu("Gestionar Productos");
		menuBar.add(menuProductos);
		
		itemRegistroProductos = new JMenuItem("Registrar");
		itemRegistroProductos.addActionListener(this);
		menuProductos.add(itemRegistroProductos);
		
		itemConsultaProductos = new JMenuItem("Consultar");
		itemConsultaProductos.addActionListener(this);
		menuProductos.add(itemConsultaProductos);
		
		itemActualizarProductos = new JMenuItem("Actualizar");
		itemActualizarProductos.addActionListener(this);
		menuProductos.add(itemActualizarProductos);
		
		itemEliminarProductos = new JMenuItem("Eliminar");
		itemEliminarProductos.addActionListener(this);
		
		menuProductos.add(itemEliminarProductos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblTitulo = new JLabel("GESTION CLINICA VETERINARIA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		contentPane.add(lblTitulo, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		lblImagen = new JLabel();
		lblImagen.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/veterinario.jpg")));
		panel.add(lblImagen, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==itemRegistrarPersonas) {
			
			miCoordinador.mostrarVentanaRegistroPersonas();
		}
		if(e.getSource()==itemActualizarPersonas) {
			miCoordinador.mostrarActualizarPersonasGui();
		}
		if (e.getSource()==itemRegistrarMascotas) {
			miCoordinador.mostrarVentanaRegistroMascotas();
		}
		if(e.getSource()==itemActualizarMascotas) {
			miCoordinador.mostrarVentanaActualizarMascotas();
		}
		if(e.getSource()==itemConsultarMascotas) {
			miCoordinador.mostrarVentanaConsultarMascotas();
		}
		if(e.getSource()==itemEliminarMascotas) {
			miCoordinador.mostrarVentanaEliminarMascotas();
		}
		if(e.getSource()==itemListarMascotas) {
			miCoordinador.mostrarVentanaListarMascotas();
		}
		if (e.getSource()==itemRegistroProductos) {
			miCoordinador.mostrarVentanaRegistroProductos();
		}
		if(e.getSource()==itemConsultarPersonas) {
			miCoordinador.mostrarVentanaConsultaPersonas();
		}
		if(e.getSource()==itemEliminarProductos) {
			miCoordinador.mostrarVentanaEliminarProductos();
		}
		if(e.getSource()==itemConsultaProductos) {
			miCoordinador.mostrarVentanaConsultaProductos();
		}
		if(e.getSource()==itemActualizarProductos) {
			miCoordinador.mostrarVentanaActualizarProductos();
		}
		if(e.getSource()==itemEliminarPersonas) {
			miCoordinador.mostrarVentanaEliminarPersona();
		}
	}

	public void setCoordinador(Coordinador miCoordinador) {
		
		this.miCoordinador=miCoordinador;
	}



}
