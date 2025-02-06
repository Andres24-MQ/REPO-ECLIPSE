/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class CaptaTelefono extends JFrame implements ActionListener{
	private JButton btnFijo;
	private JButton btnMovil;
	private JButton btnSalir;
	
	private TelefonoFijo fijo;
	private TelefonoMovil movil;
	
	public CaptaTelefono(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,300);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setTitle("registra el telefono");
		
		btnFijo=new JButton("TelefonoFijo");
		btnFijo.setBounds(100, 50, 200, 30);
		add(btnFijo);
		
		btnFijo.addActionListener(this);
		
		btnMovil=new JButton("TelefonoMovil");
		btnMovil.setBounds(100, 150, 200, 30);
		add(btnMovil);
		
		btnMovil.addActionListener(this);
		
		btnSalir=new JButton("Salir");
		btnSalir.setBounds(150, 200, 100, 30);
		add(btnSalir);
		
		btnSalir.addActionListener(this);
		setVisible(true);
	}
public static void main(String[]args){
	new CaptaTelefono();
} 
	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getSource()==btnFijo){
			CapturaVehiculo("TelefonoFijo");
		}
		if (e.getSource()==btnMovil){
			CapturaVehiculo("TelefonoMovil");
		}
		if (e.getSource()==btnSalir){
			System.exit(0);;
		}
	}
	public void CapturaVehiculo(String cual){
		JFrame salida=new JFrame();
		
	JTextField txtMarca;
	JTextField txtModelo;
	JTextField txtNumero;

	JTextField txtExtension;
	JTextField txtMemoriaRam;
	JTextField txtAlmacenamiento;
	
	JLabel lblDato;
	
	JLabel lblMensaje;
	
	JButton btnGuardar;
	JButton btnMostrar;
	JButton btnLimpiar;
	JButton btnCerrar;
	
	salida.setSize(600,300);
	salida.setLocationRelativeTo(null);
	salida.setLayout(null);
	salida.setResizable(false);
	salida.setTitle("captura de " +cual);
	
	lblDato=new JLabel(cual);
	lblDato.setBounds(50,30,100,30);
	salida.add(lblDato);
	
	lblDato=new JLabel("Marca");
	lblDato.setBounds(150,10,100,30);
	salida.add(lblDato);
	
	lblDato=new JLabel("Modelo");
	lblDato.setBounds(305,10,100,30);
	salida.add(lblDato);
	
	lblDato=new JLabel("Numero");
	lblDato.setBounds(50,60,100,30);
	salida.add(lblDato);
	
	
	
	txtMarca=new JTextField();
	txtMarca.setBounds(150,35,150,20);
	salida.add(txtMarca);
	
	
	txtModelo=new JTextField();
	txtModelo.setBounds(305,35,150,20);
	salida.add(txtModelo);
	
	txtNumero=new JTextField();
	txtNumero.setBounds(150,65,50,20);
	salida.add(txtNumero);
	
	lblMensaje=new JLabel("...");
	lblMensaje.setBounds(50,220,400,40);
	salida.add(lblMensaje);
	
	
	
	txtExtension= new JTextField();
	txtMemoriaRam=new JTextField();
	txtAlmacenamiento=new JTextField();
	
	if(cual.equals("TelefonoFijo")){
		lblDato=new JLabel("Extension");
		lblDato.setBounds(50,90,100,30);
		salida.add(lblDato);
	
		txtExtension.setBounds(150,90,100,30);
		salida.add(txtExtension);
	}else{
		
		lblDato=new JLabel("Almacenamiento");
		lblDato.setBounds(50,130,100,30);
		salida.add(lblDato);
		
		txtAlmacenamiento=new JTextField();
		txtAlmacenamiento.setBounds(150,130,100,30);
		salida.add(txtAlmacenamiento);
		
		lblDato=new JLabel("MemoriaRam");
		lblDato.setBounds(55,90,100,30);
		salida.add(lblDato);

		txtMemoriaRam.setBounds(150,90,100,30);
		salida.add(txtMemoriaRam);
		
	}
	salida.setVisible(true);
	btnGuardar=new JButton ("Guardar");
	btnGuardar.setBounds(70, 180, 100, 30);
	salida.add(btnGuardar);
	
	btnGuardar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if (cual.equals("TelefonoFijo")){
		fijo=new TelefonoFijo();
		fijo.setMarca(txtMarca.getText());
		fijo.setModelo(txtModelo.getText());
		fijo.setNumero(Integer.parseInt(txtNumero.getText()));
		fijo.setExtension(Integer.parseInt(txtExtension.getText()));
		
	
	}else{
		movil= new TelefonoMovil();
		movil.setMarca(txtMarca.getText());
		movil.setModelo(txtModelo.getText());
		movil.setNumero(Integer.parseInt(txtNumero.getText()));
	
		movil.setMemoriaRam(Integer.parseInt(txtMemoriaRam.getText()));	
		


	
	
	}
	lblMensaje.setText("guardado con exito");
		}
	});
	btnMostrar=new JButton ("Mostrar");
			btnMostrar.setBounds(180, 180, 100, 30);
	salida.add(btnMostrar);
	
	btnMostrar.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			if(cual.equals("TelefonoFijo")){
				lblMensaje.setText("fijo: " +fijo.getMarca()+" modelo:" +fijo.getModelo()+" Numero: "+fijo.getNumero()+" Extension: "+
			fijo.getExtension());
			}
			else{lblMensaje.setText("MARCA: " +movil.getMarca()+"MODELO : " +movil.getModelo()+"numero: "+movil.getNumero()+"Memoria: "+
			movil.getMemoriaRam()+"almacen: "+ movil.getAlmacenamiento());
				
			}
			
		}
	});
	
	btnLimpiar=new JButton("Limpiar");
	btnLimpiar.setBounds(290, 180, 100, 30);
	salida.add(btnLimpiar);
	
	btnLimpiar.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
		txtMarca.setText(" ");
			txtModelo.setText(" ");
			txtNumero.setText(" ");
			txtExtension.setText(" ");
		
		txtMemoriaRam.setText(" ");
	
			
			
			
			lblMensaje.setText("...");
		}
	});
	
	btnCerrar= new JButton("Cerrar");
			btnCerrar.setBounds(400,180,100,30);
			salida.add(btnCerrar);
			
			btnCerrar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					salida.dispose();
				}
			});
		
		
			}
	}
	
