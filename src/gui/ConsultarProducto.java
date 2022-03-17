package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarProducto extends JDialog implements ActionListener {
	private JTextField textField;
	private JLabel lblTitulo;
	private JLabel lblPrecio;
	private JLabel lblNombre;
	private JButton btnBuscar;
	private JLabel lblPrecioP;
	private JLabel lblNombreP;
	private Coordinador miCoordinador;

	public ConsultarProducto(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 350, 280);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		iniciarComponentes();
		setTitle("Gestión de consultar");
		
	}
	
	public void iniciarComponentes() {
		
			textField = new JTextField();
			textField.setBounds(85, 47, 86, 20);
			getContentPane().add(textField);
			textField.setColumns(10);
		
			lblTitulo = new JLabel("Ingrese el ID del producto");
			lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblTitulo.setBounds(56, 11, 192, 20);
			getContentPane().add(lblTitulo);
		
			lblPrecio = new JLabel("Producto:");
			lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblPrecio.setBounds(31, 106, 71, 20);
			getContentPane().add(lblPrecio);
		
			lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNombre.setBounds(31, 148, 71, 20);
			getContentPane().add(lblNombre);
		
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(190, 46, 75, 21);
			getContentPane().add(btnBuscar);
		
			lblPrecioP = new JLabel("");
			lblPrecioP.setBounds(163, 110, 98, 20);
			getContentPane().add(lblPrecioP);
		
			lblNombreP = new JLabel("");
			lblNombreP.setBounds(163, 152, 98, 20);
			getContentPane().add(lblNombreP);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
	}


