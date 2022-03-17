package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import vo.PersonaVo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ConsultarPersonaGUI extends JDialog implements ActionListener{

	private final JPanel contentPanel=new JPanel();
	private JButton btnConsultar;
	private JTextField txtNombre;
	private JTextField txtProfesion;
	private JTextField txtTelefono;
	private JTextField txtTipo;
	private JTextField txtCiudad;
	private JTextField txtDepartamento;
	private JTextField txtPais;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAnio;
	private JTextField txtDocumento;
	Coordinador miCoordinador;

	public ConsultarPersonaGUI(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 350, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		iniciarComponentes();
		setTitle("Gestión de Consultas");
		
	}
	
	public void iniciarComponentes() {
	
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(167, 29, 89, 23);
		contentPanel.add(btnConsultar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 102, 86, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtProfesion = new JTextField();
		txtProfesion.setBounds(10, 153, 86, 20);
		contentPanel.add(txtProfesion);
		txtProfesion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(10, 218, 86, 20);
		contentPanel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(167, 102, 86, 20);
		contentPanel.add(txtTipo);
		txtTipo.setColumns(10);
		
		txtCiudad = new JTextField();
		txtCiudad.setBounds(167, 153, 86, 20);
		contentPanel.add(txtCiudad);
		txtCiudad.setColumns(10);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setBounds(167, 218, 86, 20);
		contentPanel.add(txtDepartamento);
		txtDepartamento.setColumns(10);
		
		txtPais = new JTextField();
		txtPais.setBounds(321, 102, 86, 20);
		contentPanel.add(txtPais);
		txtPais.setColumns(10);
		
		txtDia = new JTextField();
		txtDia.setBounds(321, 153, 86, 20);
		contentPanel.add(txtDia);
		txtDia.setColumns(10);
		
		txtMes = new JTextField();
		txtMes.setBounds(321, 198, 86, 20);
		contentPanel.add(txtMes);
	
	}	 
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnConsultar) {
				
				Long idDocumento=Long.parseLong(txtDocumento.getText());
				PersonaVo p=miCoordinador.setConsultarPersona(idDocumento);
				
				if (p!=null) {
					
					p.setNacimiento(miCoordinador.consultarNacimiento(p.getNacimiento().getIdNacimiento()));
					System.out.println(p);				
					txtNombre.setText(p.getNombre());
					txtProfesion.setText(p.getProfesion());
					txtTelefono.setText(p.getTelefono());
					txtTipo.setText(p.getTipo()+"");
					
					txtCiudad.setText(p.getNacimiento().getCiudadNacimiento());
					txtDepartamento.setText(p.getNacimiento().getDepartamentoNacimiento());
					txtPais.setText(p.getNacimiento().getPaisNacimiento());
					txtDia.setText(p.getNacimiento().getFechaNacimiento().getDayOfMonth()+"");
					txtMes.setText(p.getNacimiento().getFechaNacimiento().getMonthValue()+"");
					txtAnio.setText(p.getNacimiento().getFechaNacimiento().getYear()+"");
						
				}else {
					JOptionPane.showMessageDialog(null,"No se encuentra la persona, verifique el documento","ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
				}			
			}

		}


		public void setCoordinador(Coordinador miCoordinador) {
			// TODO Auto-generated method stub
			this.miCoordinador=miCoordinador;
		}
}
