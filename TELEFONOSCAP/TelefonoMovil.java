/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class TelefonoMovil extends Telefono {
	private int MemoriaRam;
	private int Almacenamiento;
	
	public TelefonoMovil(String marca, String modelo,int numero, int memoriaram, int almacenamiento) {
		super(marca, modelo,numero);

		}
	public TelefonoMovil(){}

	public int getMemoriaRam() {
		return MemoriaRam;
	}

	public void setMemoriaRam(int memoriaram) {
		MemoriaRam = memoriaram;
	}
	public int getAlmacenamiento() {
		return Almacenamiento;
	}
	public void setAlmacenamiento(int almacenamiento) {
		Almacenamiento = almacenamiento;
	}



}