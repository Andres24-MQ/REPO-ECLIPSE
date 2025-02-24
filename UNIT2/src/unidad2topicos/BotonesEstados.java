package unidad2topicos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotonesEstados  extends JButton implements ActionListener{
	 private static final long serialVersionUID = 1L;

	private ImageIcon imagenOff, imagenOn;
	private boolean encendido;
	
	public BotonesEstados(ImageIcon ImagenOff, ImageIcon ImagenOn) {
		super();
		imagenOff = ImagenOff;
		imagenOn = ImagenOn;
		setIcon(imagenOff);
		setFocusPainted(false);
		addActionListener(this);
		encendido=false;
	}
	
	public BotonesEstados(String ImagenOff, String ImagenOn) {
		this( new ImageIcon(ImagenOff), new ImageIcon(ImagenOn));
	}
	public boolean isEncendido() {
		return encendido;
	}
	
	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
		if(encendido)
			setIcon(imagenOn);
		else
			setIcon(imagenOff);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (encendido) 
			setIcon(imagenOff);
			else
				setIcon(imagenOn);
			encendido=!encendido;
		
		
	}
	
	
}
