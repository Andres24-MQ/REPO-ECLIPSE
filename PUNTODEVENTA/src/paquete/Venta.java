package paquete;

import java.util.List;
import java.util.Date;

public class Venta {
    private String folio;
    private List<ProductoVenta> productos;

    public Venta(String folio, List<ProductoVenta> productos) {
        this.folio = folio;
        this.productos = productos;
    }
    public String getFolio() {
        return folio;
    }
    public List<ProductoVenta> getProductos() {
        return productos;
    }
    public String toString() {
        return
        "-------------DATOS DE LA VENTA--------------" + "\n" + "\n"
        + "folio: " + folio + "\n" +"\n" 
        + productos + "\n" +"\n" ;
    }

}
