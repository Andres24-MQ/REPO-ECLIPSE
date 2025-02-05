/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquetee;

public class Telefono{
	private String Marca;
	private String Modelo;
	private int Numero;
	
	
public Telefono(){}
public Telefono (String marca, String modelo, int numero) {

    this.Marca = marca;
    this.Modelo = modelo;
    this.Numero = numero;
   
}

public void setMarca(String marca) {
    this.Marca = marca;
}

public String getMarca() {
    return Marca;
}

public void setModelo(String modelo) {
    this.Modelo = modelo;
}

public String getModelo() {
    return Modelo;
}
public int getNumero() {
	return Numero;
}
public void setNumero(int numero) {
	Numero = numero;
}

}
