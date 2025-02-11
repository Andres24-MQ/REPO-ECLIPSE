package lalo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class Layouts extends JFrame implements ActionListener, WindowListener{
	
	
	JPanel jpNorte,jpSur,jpEste,jpOeste,jpCentro;
	JButton jBtnAbrinr, jBtnGuardar, jBtnSalir;
	JLabel lblNomArc;
	JTextField txtNombre;
	
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
		
	}
	
	private void InitPanelCentro() {
		jpCentro.add(new JLabel("cuadro de texto"));
	}
	
	

	public static void main(String[] args) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
