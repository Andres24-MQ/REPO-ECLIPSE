package paquete;

import java.util.List;

public class Venta {
        private int folio;
    private String claveCliente;
    private String nombreCliente;
    private Date fecha;
    private List<ProductoVenta> productos;

    public Venta(int folio, String claveCliente, String nombreCliente, Date fecha, List<ProductoVenta> productos) {
        this.folio = folio;
        this.claveCliente = claveCliente;     
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.productos = productos;

    }

    public int getFolio() {
        return folio;
    }

    public String getClaveCliente() {
        return claveCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public List<ProductoVenta> getProductos() {
        return productos;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
}
