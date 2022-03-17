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

public class ActualizarProductos extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JLabel lblTitulo;
	private JLabel lblNombre;
	private JTextField textNombre;
	private JTextField textPrecio;
	private JButton btnBuscar;
	private JButton btnActualizar;
	private JLabel lblPrecio;
	private Coordinador miCoordinador;

	public ActualizarProductos(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 350, 289);
		setLocationRelativeTo(null);
		iniciarComponentes();
		setTitle("Gestión de consultar");
		
	}
	
	public void iniciarComponentes() {
			getContentPane().setLayout(null);
		
			textField = new JTextField();
			textField.setBounds(115, 47, 86, 20);
			getContentPane().add(textField);
			textField.setColumns(10);
		
			lblTitulo = new JLabel("Ingrese el ID del producto");
			lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblTitulo.setBounds(73, 11, 192, 20);
			getContentPane().add(lblTitulo);
		
			lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNombre.setBounds(24, 113, 67, 27);
			getContentPane().add(lblNombre);
			
			lblPrecio = new JLabel("Precio:");
			lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblPrecio.setBounds(24, 172, 67, 14);
			getContentPane().add(lblPrecio);
			
			textNombre = new JTextField();
			textNombre.setBounds(115, 117, 86, 20);
			getContentPane().add(textNombre);
			textNombre.setColumns(10);
			
			textPrecio = new JTextField();
			textPrecio.setBounds(115, 170, 86, 20);
			getContentPane().add(textPrecio);
			textPrecio.setColumns(10);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnBuscar.setBounds(223, 45, 89, 23);
			getContentPane().add(btnBuscar);
			btnBuscar.addActionListener(this);
			
			btnActualizar = new JButton("Actualizar");
			btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnActualizar.setBounds(115, 216, 103, 23);
			getContentPane().add(btnActualizar);
			btnActualizar.addActionListener(this);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar) {
			ProductoVo miProducto=miCoordinador.obtenerProducto(Long.parseLong(textField .getText()));
			System.out.println(miProducto);
			if(miProducto!=null) {
				textNombre.setText(miProducto.getNombreProducto());
				textPrecio.setText(miProducto.getPrecioProducto()+"");
				
			}else {
				JOptionPane.showMessageDialog(null,"El producto no existe");
			}
		}
		if(e.getSource()==btnActualizar) {
			ProductoVo miProducto=new ProductoVo();
			miProducto.setIdProducto(Long.parseLong(textField.getText()))
			miProducto.setNombreProducto(textNombre.getText());
			miProducto.setPrecioProducto(Double.parseDouble(textPrecio.getText()));
			
			System.out.println(miProducto);
			String res=miCoordinador.actualizarProductos(miProducto);
			System.out.println(res);
		}
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}

}
