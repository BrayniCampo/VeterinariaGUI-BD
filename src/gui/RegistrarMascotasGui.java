package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import vo.MascotaVo;
import vo.PersonaVo;

public class RegistrarMascotasGui extends JDialog implements ActionListener{

	private final JPanel contentPanel=new JPanel();
	private JTextField txtIdDueno;
	private JTextField txtNombre;
	private JTextField txtRaza;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private Coordinador miCoordinador;
	private JTextField txtIdMascota;
	private JLabel lblNombre;
	private JLabel lblRaza;
	private JLabel lblSexo;
	private JComboBox comboBoxSexo;
	private JLabel lblColor;
	private JComboBox comboBoxColor;
	private JLabel lblIdMascota;
	private JLabel lblDueno;
	
	
	public RegistrarMascotasGui(VentanaPrincipal ventanaPrincipal, boolean modal, String documento) {
		super(ventanaPrincipal,modal);
		setSize( 408, 288);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Gestion de Mascotas");
		
		iniciarComponentes(documento);
		
	}


	private void iniciarComponentes(String documento) {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("GESTIONAR MASCOTAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPanel.add(lblTitulo);
				
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 49, 370, 192);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblDueno = new JLabel("Id Due\u00F1o:");
		lblDueno.setBounds(199, 17, 71, 21);
		panel.add(lblDueno);
		
		txtIdDueno = new JTextField();
		txtIdDueno.setBounds(269, 17, 86, 20);
		panel.add(txtIdDueno);
		txtIdDueno.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 49, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(88, 49, 86, 20);
		panel.add(txtNombre);
		
		lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(214, 49, 71, 21);
		panel.add(lblRaza);
		
		txtRaza = new JTextField();
		txtRaza.setColumns(10);
		txtRaza.setBounds(269, 49, 86, 20);
		panel.add(txtRaza);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 127, 331, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(271, 150, 89, 23);
		panel.add(btnCancelar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(172, 150, 89, 23);
		btnRegistrar.addActionListener(this);
		panel.add(btnRegistrar);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(24, 81, 71, 21);
		panel.add(lblSexo);
		
		comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Macho", "Hembra"}));
		comboBoxSexo.setBounds(88, 81, 86, 22);
		panel.add(comboBoxSexo);
		
		lblColor = new JLabel("Color:");
		lblColor.setBounds(214, 82, 71, 21);
		panel.add(lblColor);
		
		comboBoxColor = new JComboBox();
		comboBoxColor.setModel(new DefaultComboBoxModel(new String[] {"Blanco", "Negro", "Caf\u00E9", "Gris", "Manchas"}));
		comboBoxColor.setBounds(269, 81, 86, 22);
		panel.add(comboBoxColor);
		
		lblIdMascota = new JLabel("Id Mascota");
		lblIdMascota.setBounds(24, 21, 71, 13);
		panel.add(lblIdMascota);
		
		txtIdMascota = new JTextField();
		txtIdMascota.setBounds(88, 18, 86, 19);
		panel.add(txtIdMascota);
		txtIdMascota.setColumns(10);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btnRegistrar) {
			
			MascotaVo miAnimal = new MascotaVo();
			
			miAnimal.setIdMascota(Long.parseLong((txtIdMascota.getText())));
			miAnimal.setNombre(txtNombre.getText());
			miAnimal.setRaza(txtRaza.getText());
			miAnimal.setColorMascota((String) comboBoxColor.getSelectedItem());
			miAnimal.setSexo((String) comboBoxSexo.getSelectedItem());
			miAnimal.setIdDueno(Long.parseLong((txtIdDueno.getText())));
			
			PersonaVo miPersona = miCoordinador.setConsultarPersona(miAnimal.getIdDueno());
			
			if(miPersona != null) {
				
				String res = miCoordinador.RegistrarMascotasGui(miAnimal);
				
				if(res.equals("ok")) {
					JOptionPane.showMessageDialog(null, "Registro Exitoso!!");
				}else {
					//JOptionPane.showMessageDialog(null, res, "ERROR", JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(null, res);
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Id de Due�o no existente, Porfavor ingrese uno existente");
			}
			
			
			
		}else if(e.getSource()==btnCancelar) {
			this.dispose();
		}
	}
		



	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
}
