package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import vo.ProductoVo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;

public class EliminarProductos extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField textId;
	private JButton btnEliminar;
	private Coordinador miCoordinador;
	private JButton btnBuscar;
	private JLabel lblMsj;
	private JTextArea textArea;
	private JTextField textNombre;
	private JTextField textPrecio;
	
public EliminarProductos(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 328, 297);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		iniciarComponentes();
		setTitle("Gestión de elimar");
		
	}
	
	public void iniciarComponentes() {

		setBounds(100, 100, 311, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMsj = new JLabel("");
		lblMsj.setBounds(67, 214, 140, 23);
		contentPane.add(lblMsj);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 71, 275, 176);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(15, 119, 86, 20);
		panel.add(textPrecio);
		textPrecio.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(15, 75, 86, 20);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		textId = new JTextField();
		textId.setBounds(95, 25, 86, 20);
		panel.add(textId);
		textId.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(191, 25, 65, 20);
		panel.add(btnBuscar);
		
		JLabel lblproducto = new JLabel("ID Producto");
		lblproducto.setBounds(10, 23, 91, 23);
		panel.add(lblproducto);
		lblproducto.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(134, 96, 89, 23);
		panel.add(btnEliminar);
		btnEliminar.addActionListener(this);
		
		
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel = new JLabel("ELIMINAR PRODUCTOS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(43, 11, 222, 49);
		contentPane.add(lblNewLabel);
		btnBuscar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar) {
			ProductoVo miProducto=miCoordinador.obtenerProducto(Long.parseLong(textId.getText()));
			System.out.println(miProducto);
			if(miProducto!=null) {
				textNombre.setText(miProducto.getNombreProducto());
				textPrecio.setText(miProducto.getPrecioProducto()+"");
				
			}else {
				JOptionPane.showMessageDialog(null,"El producto no existe");
			}
		}
		
		if(e.getSource()==btnEliminar) {
			Long idProducto=(Long.parseLong(textId.getText()));
			String resp=miCoordinador.eliminarProducto(idProducto);
					
			if(resp.equals("ok")) {
				lblMsj.setText("Se elimino Exitosamente");
			}else {
				lblMsj.setText("No se pudo eliminar");
			}
			
		}
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
}
