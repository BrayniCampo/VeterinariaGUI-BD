package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import vo.MascotaVo;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListarMascotasGUI extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblListaDeMascotas;
	private JScrollPane scrollTablas;
	private JTable tablaDeMascotas;
	Coordinador miCoordinador;
	private ArrayList<MascotaVo> mascotas;

	public ListarMascotasGUI(VentanaPrincipal ventanaPrincipal, boolean modal) {
		setBounds(100, 100, 668, 384);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblListaDeMascotas = new JLabel("LISTA DE MASCOTAS");
		lblListaDeMascotas.setForeground(Color.RED);
		lblListaDeMascotas.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblListaDeMascotas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeMascotas.setBounds(189, 22, 252, 23);
		contentPanel.add(lblListaDeMascotas);
		
		scrollTablas = new JScrollPane();
		scrollTablas.setBounds(10,55,630,247);
		contentPanel.add(scrollTablas);
		
		
		
	}
	
	public void setPersonas(ArrayList<MascotaVo> mascotas) {
		this.mascotas = mascotas;
	}
	public void ListandoAnimales(ArrayList<MascotaVo>mascotas) {
		
		String titulos [] = {"Id de Mascota", "Nombre", "Color", "Raza", "Sexo", "Id del Dueño"};
		System.out.println(mascotas.size());
		
		int celdas;
		
		if(mascotas.size()<15) {
			celdas=14;
		}else {
			celdas=mascotas.size();
		}
		
		String cuadro[][]= new String [celdas][9];
		
		if(mascotas.size()>0) {
			for(int i=0;i<mascotas.size();i++) {
				
				cuadro[i][0]=mascotas.get(i).getIdMascota()+"";
				cuadro[i][1]=mascotas.get(i).getNombre();
				cuadro[i][2]=mascotas.get(i).getColorMascota();
				cuadro[i][3]=mascotas.get(i).getRaza();
				cuadro[i][4]=mascotas.get(i).getSexo()+"";
				cuadro[i][5]=mascotas.get(i).getIdDueno()+"";
			}
		}else {
			
			cuadro = new String [14][9];
		}
		
		tablaDeMascotas = new JTable(cuadro, titulos);
		scrollTablas.setViewportView(tablaDeMascotas);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		
		this.miCoordinador=miCoordinador;
		
	}


}
