/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class TelefonoFijo extends Telefono {
	private int Extension;
	
public TelefonoFijo(String marca, String modelo, int numero,int extension) {
		super(marca, modelo,numero);
		
	}
public TelefonoFijo(){}
public int getExtension() {
	return Extension;
}
public void setExtension(int extension) {
	Extension = extension;
}



}
