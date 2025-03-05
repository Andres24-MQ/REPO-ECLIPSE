package paquete;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GuardarDatos {
    public static void guardarVentaTXT(Venta venta, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo, true)) {
            String lineaVenta = venta.getFolio() + "|" + venta.getFecha() + "|" + venta.getCliente().getNombre() + "|" + venta.getTotal() + "\n";
            writer.write(lineaVenta);

            // Guardar detalles de productos vendidos (ejemplo)
            for (ProductoVenta producto : venta.getProductos()) {
                String lineaProducto = "  - " + producto.getDescripcion() + "|" + producto.getCantidad() + "|" + producto.getPrecioUnitario() + "\n";
                writer.write(lineaProducto);
            }

            System.out.println("Venta guardada correctamente en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar venta en " + nombreArchivo + ": " + e.getMessage());
        }
    }
}
