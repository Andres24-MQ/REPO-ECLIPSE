package paquete;

import com.mycompanyiaiaia.punto.Cliente;
import com.mycompanyiaiaia.punto.Venta;
import com.mycompanyiaiaia.punto.ProductoVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.Desktop;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewJFrame extends JFrame {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Venta> ventas = new ArrayList<>();
    private DefaultTableModel tableModel;

    private JLabel Titulo, jLabel2, jLabel3, jLabel4, jLabel5, jLabel7, jLabel9, jLabel10, jLabel11, jLabel12, lblFolio,lblPU;
    private JTextField jTextField1, jTextFieldNombre, jTextFieldDireccion, jTextFieldRFC;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JButton jButton1, jButton2, jButton3, jButton4, jButton5, jButtonLimpiarTabla;
    private JLabel jLabelSubtotal, jLabelDescuento, jLabelImpuesto, jLabelTotal;

    
    private JLabel jLabelCantidad, jLabelDescripcion, jLabelPU, lblnomarc;
    private JTextField jTextFieldCantidad;
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
        jLabel9 = new JLabel("Subtotal:");
        jLabel10 = new JLabel("Descuento:");
        jLabel11 = new JLabel("Impuesto:");
        jLabel12 = new JLabel("Total:");

        jTextField1 = new JTextField();
        jTextFieldNombre = new JTextField();
        jTextFieldDireccion = new JTextField();
        jTextFieldRFC = new JTextField();
        lblFolio = new JLabel(String.valueOf(System.currentTimeMillis()));
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
        lblPU = new JLabel();
        jComboBoxDescripcion.setSelectedItem("Pizza");
        lblPU.setText("140");
        jButtonAnadir = new JButton("Añadir");
        lblnomarc = new JLabel();

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
        lblFolio.setBounds(400, 50, 100, 20);

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
        lblPU.setBounds(170, 320, 100, 20);
        jButtonAnadir.setBounds(20, 350, 120, 30);
        lblnomarc.setBounds(220, 600, 100, 20);

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
        add(lblFolio);
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
        add(lblnomarc);

        // Agregar nuevos componentes
        add(jLabelCantidad);
        add(jTextFieldCantidad);
        add(jLabelDescripcion);
        add(jComboBoxDescripcion);
        add(jLabelPU);
        add(lblPU);
        add(jButtonAnadir);

jButtonAnadir.addActionListener(e -> añadirFilaATabla());

jButtonLimpiarTabla.addActionListener(e -> LimpiarTabla());

jButton5.addActionListener(e -> BorrarDatosDelUsu());

jButton3.addActionListener(e -> GuardarDatos());

jButton4.addActionListener(e -> consultar());

jButton2.addActionListener(e -> modificar());


jComboBoxDescripcion.addActionListener(e -> {
    String TipoSeleccionado = (String) jComboBoxDescripcion.getSelectedItem();
    switch (TipoSeleccionado) {
        case "Pizza":
            lblPU.setText("140");
            break;
        case "Sushi":
            lblPU.setText("200");
            break;
        case "Tacos":
            lblPU.setText("100");
            break;
        case "Helado":
            lblPU.setText("50");
            break;
        default:
            break;
    }
});


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 720); 
        setVisible(true);
    }
    
    //METODOS
    private void GuardarDatos(){
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccionar ubicación para guardar");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setCurrentDirectory(new File("C:/PUNTITO"));
        chooser.setAcceptAllFileFilterUsed(true);
        chooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto", "txt"));

        int seleccion = chooser.showSaveDialog(null);
        if (seleccion != JFileChooser.APPROVE_OPTION) {
            return; 
        }

        // OBTENER LA RUTA SELECCIONADA
        File archivoSeleccionado = chooser.getSelectedFile();
        String rutaArchivo = archivoSeleccionado.getAbsolutePath();

        if (!rutaArchivo.toLowerCase().endsWith(".txt")) {
            rutaArchivo += ".txt";
        }
        
        //JALAS LOS DATOS
        String folio =  lblFolio.getText();
        String ClaveCliente = jTextField1.getText();
        String nombreCliente = jTextFieldNombre.getText();
        String DireccionCliente = jTextFieldDireccion.getText();
        String RFC = jTextFieldRFC.getText();
        Double precioTotal = Double.parseDouble(jLabelTotal.getText());


        List<ProductoVenta> productos = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            int cantidad = (int) model.getValueAt(i, 0);
            String descripcion = (String) model.getValueAt(i, 1);
            Double PrecioUnitario = (Double) model.getValueAt(i, 2);

        //OBJETO PRODUCTOVENTA
        ProductoVenta producto = new ProductoVenta(descripcion, cantidad, 
        PrecioUnitario,precioTotal);
        productos.add(producto);
        }

        //OBJETO CLIENTE
        Cliente cliente = new Cliente(ClaveCliente, nombreCliente, 
        DireccionCliente, RFC); 

        //OBJETO VENTA
        Venta venta = new Venta(folio,productos);

        guardarVentaTXT(venta,cliente, rutaArchivo);
        System.out.println(cliente.toString());
        System.out.println(venta.toString());
    }

    private void guardarVentaTXT(Venta venta,Cliente cliente, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(cliente.toString());
            writer.newLine();
            writer.write(venta.toString()); 
            writer.newLine();
            writer.flush();

            JOptionPane.showMessageDialog(null, "Venta guardada correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la venta.");
        }
    }

    private void consultar() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setCurrentDirectory(new File("C:/PUNTITO"));
        chooser.setAcceptAllFileFilterUsed(true);
        chooser.setFileFilter(new FileNameExtensionFilter("Tickets: ", "txt", "txt"));
        
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            lblnomarc.setText("Consulta: " + selectedFile.getName());
            
            try {
                Desktop.getDesktop().open(selectedFile); // Abre el archivo con el programa predeterminado
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
        private void modificar() {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            chooser.setCurrentDirectory(new File("C:/PUNTITO"));
            chooser.setAcceptAllFileFilterUsed(true);
            chooser.setFileFilter(new FileNameExtensionFilter("Tickets: ", "txt", "txt"));
            
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                lblnomarc.setText("Consulta: " + selectedFile.getName());
                
                try {
                    Desktop.getDesktop().open(selectedFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
                int cantidad = Integer.parseInt(jTextFieldCantidad.getText());
                String descripcion = (String) jComboBoxDescripcion.getSelectedItem();
                double pu = Double.parseDouble(lblPU.getText());

                double importeFila = cantidad * pu;
                tableModel.addRow(new Object[]{cantidad, descripcion, pu, importeFila});

                double importe = 0;
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    importe += (double) tableModel.getValueAt(i, 3);
                }

                double descuento = 100;
                double impuesto = importe * 0.16;
                double total = 0;

                if (importe <= 50) {
                    total = importe + impuesto;
                    descuento = 0;
                }else{
                    total = importe - descuento + impuesto;
                }
                    jLabelSubtotal.setText(String.format("%.2f", importe));
                    jLabelDescuento.setText(String.format("%.2f", descuento));
                    jLabelImpuesto.setText(String.format("%.2f", impuesto));
                    jLabelTotal.setText(String.format("%.2f", total));

                    jTextFieldCantidad.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Por favor, ingresa valores válidos en Cantidad y Precio Unitario.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }


    public static void main(String[] args) {
        new NewJFrame();
    }
}
