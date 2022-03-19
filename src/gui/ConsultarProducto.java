package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import vo.ProductoVo;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSeparator;
import java.awt.Color;

public class ConsultarProducto extends JDialog implements ActionListener {
	private JTextField textField;
	private JLabel lblTitulo;
	private JLabel lblNombre;
	private Coordinador miCoordinador;
	private JTextField textNombre;
	private JTextField textPrecio;
	private JButton btnBuscar;
	private JButton btnConsulta;

	public ConsultarProducto(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 441, 268);
		setLocationRelativeTo(null);
		iniciarComponentes();
		setTitle("Gestión de consultar");
		
	}
	
	public void iniciarComponentes() {
			getContentPane().setLayout(null);
		
			textField = new JTextField();
			textField.setBounds(147, 42, 89, 20);
			getContentPane().add(textField);
			textField.setColumns(10);
		
			lblTitulo = new JLabel("Ingrese el ID del producto");
			lblTitulo.setForeground(Color.RED);
			lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblTitulo.setBounds(99, 11, 208, 20);
			getContentPane().add(lblTitulo);
		
			lblNombre = new JLabel("Nombre:");
			lblNombre.setForeground(Color.BLACK);
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNombre.setBounds(24, 113, 67, 27);
			getContentPane().add(lblNombre);
			
			JLabel lblPrecio = new JLabel("Precio:");
			lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblPrecio.setBounds(221, 119, 67, 14);
			getContentPane().add(lblPrecio);
			
			textNombre = new JTextField();
			textNombre.setBounds(99, 117, 95, 20);
			getContentPane().add(textNombre);
			textNombre.setColumns(10);
			
			textPrecio = new JTextField();
			textPrecio.setBounds(298, 118, 103, 20);
			getContentPane().add(textPrecio);
			textPrecio.setColumns(10);
			
			btnBuscar = new JButton("BUSCAR");
			btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnBuscar.setBounds(263, 41, 95, 21);
			getContentPane().add(btnBuscar);
			
			btnConsulta = new JButton("Consultar todos los productos");
			btnConsulta.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnConsulta.addActionListener(this);
			btnConsulta.setBounds(99, 187, 260, 29);
			getContentPane().add(btnConsulta);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(0, 162, 425, 14);
			getContentPane().add(separator);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(0, 73, 425, -11);
			getContentPane().add(separator_1);
			btnBuscar.addActionListener(this);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar) {
			ProductoVo miProducto=miCoordinador.obtenerProducto(Long.parseLong(textField .getText()));
			if(miProducto!=null) {
				textNombre.setText(miProducto.getNombreProducto());
				textPrecio.setText(miProducto.getPrecioProducto()+"");
				
			}else {
				JOptionPane.showMessageDialog(null,"El producto no existe");
			}
		}
		if(e.getSource()==btnConsulta) {
			miCoordinador.mostrarVentanalistarProductos();
		}
			
	}


	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
	}


