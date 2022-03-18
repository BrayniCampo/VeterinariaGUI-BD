package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import vo.PersonaVo;
import vo.PersonasProductoVo;
import vo.ProductoVo;

public class RegistrarProductosGui  extends JDialog implements ActionListener {

	private final JPanel contentPanel= new JPanel();
	private JTextField txtNombre,txtPrecio;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private Coordinador miCoordinador;
	private JLabel lblTitulo;
	private JPanel panel;
	private JLabel lblNombre;
	private JTextField textPersona;
	private JLabel lblIdPersona;
	
	public RegistrarProductosGui(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 412, 265);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Gestion de Mascotas");
		iniciarComponentes();
		
		
	}


	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTitulo = new JLabel("GESTIONAR PRODUCTOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPanel.add(lblTitulo);
				
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 49, 380, 154);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 11, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(88, 11, 86, 20);
		panel.add(txtNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(214, 11, 71, 21);
		panel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(269, 11, 86, 20);
		panel.add(txtPrecio);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 97, 331, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(274, 120, 89, 23);
		panel.add(btnCancelar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(175, 120, 89, 23);
		btnRegistrar.addActionListener(this);
		panel.add(btnRegistrar);
		
		textPersona = new JTextField();
		textPersona.setBounds(88, 55, 86, 20);
		panel.add(textPersona);
		textPersona.setColumns(10);
		
		lblIdPersona = new JLabel("ID Persona:");
		lblIdPersona.setBounds(18, 58, 60, 14);
		panel.add(lblIdPersona);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRegistrar) {
			ProductoVo miProducto=new ProductoVo();
			miProducto.setNombreProducto(txtNombre.getText());
			miProducto.setPrecioProducto(Double.parseDouble(txtPrecio.getText()));
			miProducto.setIdProducto(Long.parseLong(textPersona.getText()));
			
			PersonasProductoVo miproductoPers = new PersonasProductoVo();
			miproductoPers.setPersonaId(Long.parseLong(textPersona.getText()));
			//miproductoPers.setProductoId(Long.parseLong(textProducto.getText()));
			PersonaVo miPersona = miCoordinador.setConsultarPersona( miproductoPers.getPersonaId());
			
			if(miPersona!=null) {
				
				String res = miCoordinador.registrarProducto(miProducto);
				String result = miCoordinador.crearProducto(miproductoPers);
				if(res.equals("ok") && result.equals("ok")) {
					JOptionPane.showMessageDialog(null, "Registro Exitoso!!");
				}else {
					JOptionPane.showMessageDialog(null, res, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Persona no existente");
			}
			
		}
	}
			
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
}
