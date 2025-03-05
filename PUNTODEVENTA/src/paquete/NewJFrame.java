package paquete;

import com.mycompanyiaiaia.punto.Cliente;
import com.mycompanyiaiaia.punto.Venta;
import com.mycompanyiaiaia.punto.ProductoVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.io.FileWriter;
import java.io.IOException;

public class NewJFrame extends JFrame {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Venta> ventas = new ArrayList<>();
    private DefaultTableModel tableModel;

    private JLabel Titulo, jLabel2, jLabel3, jLabel4, jLabel5, jLabel7, jLabel8, jLabel9, jLabel10, jLabel11, jLabel12, JLabelFecha;
    private JTextField jTextField1, jTextFieldNombre, jTextFieldDireccion, jTextFieldRFC, jTextFieldFolio;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JButton jButton1, jButton2, jButton3, jButton4, jButton5, jButtonLimpiarTabla;
    private JLabel jLabelSubtotal, jLabelDescuento, jLabelImpuesto, jLabelTotal;

    
    private JLabel jLabelCantidad, jLabelDescripcion, jLabelPU;
    private JTextField jTextFieldCantidad, jTextFieldPU;
    private JComboBox<String> jComboBoxDescripcion;
    private JButton jButtonAnadir;

    public NewJFrame() {
        initComponents();
    }

    private void initComponents() {
        Titulo = new JLabel("PUNTO DE VENTA");
        jLabel2 = new JLabel("Clave Cliente:");
        jLabel3 = new JLabel("Nombre:");
        jLabel4 = new JLabel("Dirección:");
        jLabel5 = new JLabel("RFC:");
        jLabel7 = new JLabel("Folio:");
        jLabel8 = new JLabel("Fecha:");
        jLabel9 = new JLabel("Subtotal:");
        jLabel10 = new JLabel("Descuento:");
        jLabel11 = new JLabel("Impuesto:");
        jLabel12 = new JLabel("Total:");

        jTextField1 = new JTextField();
        jTextFieldNombre = new JTextField();
        jTextFieldDireccion = new JTextField();
        jTextFieldRFC = new JTextField();
        jTextFieldFolio = new JTextField();
        JLabelFecha = new JLabel(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        // Inicializa tableModel
        tableModel = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Cantidad", "Descripción", "P.U", "Importe"} 
        );

        jTable1 = new JTable(tableModel);
        jScrollPane1 = new JScrollPane(jTable1);

        jButton1 = new JButton("Nuevo");
        jButton2 = new JButton("Modificar");
        jButton3 = new JButton("Guardar");
        jButton4 = new JButton("Consultar");
        jButton5 = new JButton("Borrar");
        jButtonLimpiarTabla = new JButton("Limpiar Tabla");

        jLabelSubtotal = new JLabel("0.00");
        jLabelDescuento = new JLabel("0.00");
        jLabelImpuesto = new JLabel("0.00");
        jLabelTotal = new JLabel("0.00");

        // Nuevos componentes
        jLabelCantidad = new JLabel("Cantidad:");
        jTextFieldCantidad = new JTextField();
        jLabelDescripcion = new JLabel("Descripción:");
        jComboBoxDescripcion = new JComboBox<>(new String[]{"Pizza", "Sushi", "Tacos", "Helado"});
        jLabelPU = new JLabel("Precio Unitario:");
        jTextFieldPU = new JTextField();
        jButtonAnadir = new JButton("Añadir");

        setLayout(null);

        // Posicionamiento de los componentes
        Titulo.setBounds(200, 10, 150, 30);
        jLabel2.setBounds(20, 50, 100, 20);
        jTextField1.setBounds(120, 50, 100, 20);
        jLabel3.setBounds(20, 80, 100, 20);
        jTextFieldNombre.setBounds(120, 80, 200, 20);
        jLabel4.setBounds(20, 110, 100, 20);
        jTextFieldDireccion.setBounds(120, 110, 200, 20);
        jLabel5.setBounds(20, 140, 100, 20);
        jTextFieldRFC.setBounds(120, 140, 100, 20);
        jLabel7.setBounds(350, 50, 50, 20);
        jTextFieldFolio.setBounds(400, 50, 100, 20);
        jLabel8.setBounds(350, 80, 50, 20);
        JLabelFecha.setBounds(400, 80, 100, 20);

        jButton1.setBounds(20, 180, 100, 30);
        jButton5.setBounds(130, 180, 100, 30);
        jButton2.setBounds(240, 180, 100, 30);
        jButton4.setBounds(350, 180, 100, 30);
        jButton3.setBounds(180, 550, 120, 30);

        jLabelCantidad.setBounds(20, 260, 100, 20);
        jTextFieldCantidad.setBounds(120, 260, 100, 20);
        jLabelDescripcion.setBounds(20, 290, 100, 20);
        jComboBoxDescripcion.setBounds(120, 290, 150, 20);
        jLabelPU.setBounds(20, 320, 150, 20);
        jTextFieldPU.setBounds(170, 320, 100, 20);
        jButtonAnadir.setBounds(20, 350, 120, 30);

        jScrollPane1.setBounds(20, 390, 500, 150); 
        jLabel9.setBounds(350, 550, 80, 20);
        jLabelSubtotal.setBounds(430, 550, 80, 20);
        jLabel10.setBounds(350, 580, 80, 20);
        jLabelDescuento.setBounds(430, 580, 80, 20);
        jLabel11.setBounds(350, 610, 80, 20);
        jLabelImpuesto.setBounds(430, 610, 80, 20);
        jLabel12.setBounds(350, 640, 80, 20);
        jLabelTotal.setBounds(430, 640, 80, 20);
        jButtonLimpiarTabla.setBounds(20, 550, 150, 30);

        add(Titulo);
        add(jLabel2);
        add(jTextField1);
        add(jLabel3);
        add(jTextFieldNombre);
        add(jLabel4);
        add(jTextFieldDireccion);
        add(jLabel5);
        add(jTextFieldRFC);
        add(jLabel7);
        add(jTextFieldFolio);
        add(jLabel8);
        add(JLabelFecha);
        add(jButton1);
        add(jButton2);
        add(jButton3);
        add(jButton4);
        add(jButton5);
        add(jScrollPane1);
        add(jLabel9);
        add(jLabelSubtotal);
        add(jLabel10);
        add(jLabelDescuento);
        add(jLabel11);
        add(jLabelImpuesto);
        add(jLabel12);
        add(jLabelTotal);
        add(jButtonLimpiarTabla);

        // Agregar nuevos componentes
        add(jLabelCantidad);
        add(jTextFieldCantidad);
        add(jLabelDescripcion);
        add(jComboBoxDescripcion);
        add(jLabelPU);
        add(jTextFieldPU);
        add(jButtonAnadir);

jButtonAnadir.addActionListener(e -> añadirFilaATabla());

jButtonLimpiarTabla.addActionListener(e -> LimpiarTabla());

jButton5.addActionListener(e -> BorrarDatosDelUsu());

jButton3.addActionListener(e -> GuardarDatos());


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 720); // Ajustar el tamaño de la ventana
        setVisible(true);
    }
    
    //METODOS
    private void GuardarDatos(){
        int folio =  Integer.parseInt(jTextFieldFolio.getText());
        Date fechoria;
        fechoria = new SimpleDateFormat("yyyy-MM-dd").parse(JLabelFecha.getText());

        String ClaveCliente = jTextField1.getText();
        String nombreCliente = jTextFieldNombre.getText();
        String DireccionCliente = jTextFieldDireccion.getText();
        String RFC = jTextFieldRFC.getText();
        Cliente cliente = new Cliente(ClaveCliente, nombreCliente, 
        DireccionCliente, RFC); 


        List<ProductoVenta> productos = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            int cantidad = (int) model.getValueAt(i, 0);
            String descripcion = (String) model.getValueAt(i, 1);
            Double PrecioUnitario = (Double) model.getValueAt(i, 2);
            ProductoVenta producto = new ProductoVenta(descripcion, cantidad, 
            PrecioUnitario);
            productos.add(producto);
        }

        Venta venta = new Venta(folio,ClaveCliente,nombreCliente,fechoria,productos);
        GuardarDatos.guardarVentaTXT(venta, "ventas.txt");
    }

    private void LimpiarTabla(){
        tableModel.setRowCount(0);
            jLabelSubtotal.setText("0.00");
            jLabelDescuento.setText("0.00");
            jLabelImpuesto.setText("0.00");
            jLabelTotal.setText("0.00");
    }
    private void BorrarDatosDelUsu(){
        jTextField1.setText((String.format("")));
        jTextFieldNombre.setText((String.format("")));
        jTextFieldDireccion.setText((String.format("")));
        jTextFieldRFC.setText((String.format("")));
        
    }
    private void añadirFilaATabla() {
        try {
            // Obtener los valores de los campos de entrada
            int cantidad = Integer.parseInt(jTextFieldCantidad.getText());
            String descripcion = (String) jComboBoxDescripcion.getSelectedItem();
            double pu = Double.parseDouble(jTextFieldPU.getText());

        double importeFila = cantidad * pu;
        tableModel.addRow(new Object[]{cantidad, descripcion, pu, importeFila});

        double importe = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            importe += (double) tableModel.getValueAt(i, 3);
        }

        double descuento = 100;
        double impuesto = importe * 0.16;
        double total = 0;

        if (importe < 50) {
            total = importe + impuesto;
            descuento = 0;
        }else{
            total = importe - descuento + impuesto;
        }
        
            
            jLabelSubtotal.setText(String.format("%.2f", importe));
            jLabelDescuento.setText(String.format("%.2f", descuento));
            jLabelImpuesto.setText(String.format("%.2f", impuesto));
            jLabelTotal.setText(String.format("%.2f", total));
            // Limpiar los campos de entrada
            jTextFieldCantidad.setText("");
            jTextFieldPU.setText("");
        } catch (NumberFormatException ex) {
            // Manejar errores de conversión
            JOptionPane.showMessageDialog(this, "Por favor, ingresa valores válidos en Cantidad y Precio Unitario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        new NewJFrame();
    }
}
