package paquete;

public class ProductoVenta {
    private String descripcion;
    private int cantidad;
    private double precioUnitario;
    private double precioTotal;

    public ProductoVenta(String descripcion, int cantidad, double precioUnitario,double precioTotal) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }
    public double getPrecioTotal() {
        return precioTotal;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public String toString() {
        return
        "Descripcion: " + descripcion +"\n" +"\n" 
        +"Cantidad: " + cantidad  + "\n" +"\n" 
        +"Preco unitario: " + precioUnitario + "\n" +"\n" 
        + "\n"+"\n" + "----------" + "\n"+"\n"
        +"Importe Total: " +precioTotal;
    }
}
