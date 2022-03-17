package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class EliminarProductos extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField textId;
	private JButton btnEliminar;
	private Coordinador miCoordinador;
	private JButton btnBuscar;
	private JLabel lblMsj;
	
public EliminarProductos(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 624, 423);
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
		
		JLabel lblproducto = new JLabel("Ingrese el id del producto");
		lblproducto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblproducto.setBounds(67, 21, 170, 23);
		contentPane.add(lblproducto);
		
		textId = new JTextField();
		textId.setBounds(88, 55, 86, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
			
		
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setBounds(100, 192, 89, 23);
		contentPane.add(btnEliminar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(184, 55, 65, 20);
		contentPane.add(btnBuscar);
		
		lblMsj = new JLabel("");
		lblMsj.setBounds(67, 214, 140, 23);
		contentPane.add(lblMsj);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(49, 103, 188, 67);
		contentPane.add(textArea);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar) {
			
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
