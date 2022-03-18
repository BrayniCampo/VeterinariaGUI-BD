package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Coordinador;
import vo.PersonaVo;
import vo.ProductoVo;

import javax.swing.JTable;
import javax.swing.JSeparator;

public class ListarProductos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Coordinador miCoordinador;
	private ArrayList<ProductoVo> productos;
	private JTable miTabla;
	private JLabel titulo;
	private JScrollPane miScrollPane;
	DefaultTableModel modelo;

	
	public ListarProductos(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 577, 356);
		setLocationRelativeTo(null);
		iniciarComponentes();
		setTitle("Gestión de consultar");
		
	}
	
	private void iniciarComponentes() {
		
		
		
		titulo = new JLabel("LISTA DE PRODUCTOS");
		titulo.setForeground(Color.RED);
		titulo.setBounds(220,20,180,30);
		titulo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		contentPanel.add(titulo);
		
		miScrollPane = new JScrollPane();
		miScrollPane.setBounds(10,80,630,247);
		contentPanel.add(miScrollPane);
		
		getContentPane().add(contentPanel);
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	public void setPersonas(ArrayList<ProductoVo> productos) {
		this.productos = productos;
	}
	
	public void llenar(ArrayList<ProductoVo> productos) {
		String titulos [] = {"ID Producto","nombre","Precio"};
		
		System.out.println(productos.size());
		int celdas;
		if(productos.size()<15) {
			celdas=14;
		}else {
			celdas=productos.size();
		}
		String cuadro [][]= new String [celdas][3];
		if(productos.size()>0) {
			
			
			for (int i=0;i<productos.size();i++) {
				cuadro[i][0]=productos.get(i).getIdProducto()+"";
				cuadro[i][1]=productos.get(i).getNombreProducto();
				cuadro[i][2]=productos.get(i).getPrecioProducto()+"";
				
			}
		}else {
			 cuadro = new String [14][3];
		}
		
		miTabla = new JTable(cuadro,titulos);
		miScrollPane.setViewportView(miTabla);
	}
	
	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	
}
