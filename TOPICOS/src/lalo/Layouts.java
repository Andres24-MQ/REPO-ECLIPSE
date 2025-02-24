package lalo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class Layouts extends JFrame implements ActionListener, WindowListener{
	
	
	JPanel jpNorte,jpSur,jpEste,jpOeste,jpCentro;
	JButton jBtnAbrir, jBtnGuardar, jBtnSalir;
	JLabel lblNomArc, lblInfoNom;
	JTextField txtNombre;
	JTextArea txaDireccion;
	JComboBox<String> cmbLista;
	
	public Layouts() throws HeadlessException {
		super("Ejemplo de layouts");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900,700);
		setLocationRelativeTo(null);
		setVisible(true);
		addWindowListener(this);
		InitsComponents();
	}
	
	private void InitsComponents() {
		
		jpNorte = new JPanel();
		jpNorte.setBackground(new Color(100,100,100));
		jpNorte.setLayout(new FlowLayout());
		InitPanelNorte();
		add(jpNorte,BorderLayout.NORTH);
		
		jpSur = new JPanel();
		jpSur.setBackground(new Color(100,100,100));
		jpSur.setLayout(new FlowLayout());
		InitPanelCentro();
		add(jpSur,BorderLayout.SOUTH);
		
		jpEste = new JPanel();
		jpEste.setBackground(new Color(100,100,100));
		jpEste.setLayout(new FlowLayout());
		InitPanelEste();
		add(jpEste,BorderLayout.EAST);
		
		jpOeste = new JPanel();
		jpOeste.setBackground(new Color(100,100,100));
		jpOeste.setLayout(new FlowLayout());
		InitPanelOeste();
		add(jpNorte,BorderLayout.WEST);
		
		jpCentro = new JPanel();
		jpCentro.setBackground(new Color(100,100,100));
		jpCentro.setLayout(new FlowLayout());
		InitPanelCentro();
		add(jpNorte,BorderLayout.CENTER);
	}
	
	
	private void InitPanelEste() {
		
		
	}

	private void InitPanelNorte() {
		
		
	}

	private void InitPanelOeste() {
		jpOeste.add(new JLabel("Ejemplo FlowLayout"));
		jBtnAbrir = new JButton("Abrir...");
		jBtnAbrir.addActionListener(this);
	}
	
	private void InitPanelCentro() {
		jpCentro.add(new JLabel("cuadro de texto"));
		txtNombre =  new JTextField();
		txtNombre.setPreferredSize(new Dimension(80,15));
		jpCentro.add(txtNombre);
		lblInfoNom = new JLabel("Nombre:");
		jpCentro.add(lblInfoNom);
		jpCentro.add(new JLabel("Area de texto"));
		txaDireccion = new JTextArea(3,10);
		jpCentro.add(txaDireccion);
		jpCentro.add(new JLabel("Direccion:"));
		jpCentro.add(new JLabel("ComoBox"));
		jpCentro.add(new JLabel("Cuadro de texto 3"));
		jpCentro.add(new JLabel("Cuadro de texto 4"));
		jpCentro.add(new JLabel("Cuadro de texto 5"));
		jpCentro.add(new JLabel("Cuadro de texto 6"));
		jpCentro.add(new JLabel("Cuadro de texto 7"));
		jpCentro.add(new JLabel("Cuadro de texto 8"));
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


}
