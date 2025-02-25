package EjercicioClase.src;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Timer;

public class App extends JFrame implements ActionListener {
    // Declaración de variables
    JPanel jpNorte, jpSur, jpEste, jpOeste, jpCentro;
    JButton boton, btnGuardar, btnSalir;
    JLabel lblnomarc, lblInfoNom, lblCheck, lbllista, lblRadio;
    JLabel lblNombreMostrado, lblDireccionMostrada, lblSexoMostrado, lblEstudiosMostrado;
    JTextField txtNombre;
    JTextArea txtDireccion;
    JComboBox<String> cmbLista;
    JCheckBox chkOp1, chkOp2, chkOp3, chkOp4;
    JRadioButton rdoOp1, rdoOp2, rdoOp3;
    ButtonGroup grupoRadio;
    JMenuBar jmbMenu;
    JMenu jmArchivo, jmEdicion, jmAyuda;
    JMenuItem jmiAbrir, jmiGuardar, jmiSalir, jmiCopiar, jmiCortar, jmiPegar, jmiAcercaDe;
    JToolBar jtbHerramientas,jtbStatus;
    JButton btnOpen, btnSave, btnExit;
    JLabel lblInfo1, lblInfo2, lblFecha;
    Timer tiempo, tmrHora;

    public App() {
        setupFrame();
        initComponents();
        Menu(); 
        InitPanelNorte(); 
        initPanelSur(); 
        setVisible(true);
        
        tiempo = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblInfo1.setText("Listo");
                tiempo.stop();
            }
        });
        
        tmrHora = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblFecha.setText(new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date()));
            }
        });
        tmrHora.start();
    }
        

    private void setupFrame() {
        setTitle("REGISTRO");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        
        
    }

    // Colores a la pantalla //panel
    private void initComponents() {
        jpNorte = new JPanel();
        jpNorte.setBackground(Color.BLUE);
        add(jpNorte, BorderLayout.NORTH);

        jpSur = new JPanel();
        jpSur.setBackground(new Color(200, 100, 200));
        add(jpSur, BorderLayout.SOUTH);

        jpEste = new JPanel();
        jpEste.setBackground(Color.WHITE);
        add(jpEste, BorderLayout.EAST);

        jpOeste = new JPanel();
        jpOeste.setBackground(Color.YELLOW);
        jpOeste.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
        add(jpOeste, BorderLayout.WEST);
        initPanelOeste();

        jpCentro = new JPanel(new GridBagLayout());
        jpCentro.setBackground(new Color(173, 216, 230));
        add(jpCentro, BorderLayout.CENTER);
        initPanelCentro();
    }
    
    private void initPanelSur() {
        jtbStatus = new JToolBar("Status bar");
        jtbStatus.setFloatable(false);
        jtbStatus.setBorderPainted(false);
        jtbStatus.setPreferredSize(new Dimension(this.getWidth(), 30));
        MatteBorder matteBorder = new MatteBorder(5, 0, 0, 0, Color.LIGHT_GRAY);
        jtbStatus.setBorder(matteBorder);
        
        lblInfo1 = new JLabel("Listo");
        jtbStatus.add(lblInfo1);
        
        jtbStatus.add(new JToolBar.Separator());
        lblInfo2 = new JLabel("Informacion 2");
        jtbStatus.add(lblInfo2);
        jtbStatus.add(new JToolBar.Separator());
        jtbStatus.add(new JSeparator(JSeparator.VERTICAL));
        lblFecha = new JLabel("Fecha");
        jtbStatus.add(lblFecha);
        add(jtbStatus, BorderLayout.SOUTH);
    }
    
    private void ActualizaInfo1(String info) {
        lblInfo1.setText(info);
        tiempo.start();
    }
    
    private void ActualizaInfo2(String info) {
        lblInfo2.setText(info);
    }
    
    	
    // MENÚ EN LA ESQUINA
    private void Menu() {
        jmbMenu = new JMenuBar();
        jmbMenu.setAlignmentX(LEFT_ALIGNMENT);

        jmArchivo = new JMenu("Archivo");
        jmArchivo.setMnemonic(KeyEvent.VK_A);

        jmiAbrir = new JMenuItem("Abrir....");
        jmiAbrir.setMnemonic(KeyEvent.VK_A);
        jmiAbrir.addActionListener(this);
        jmArchivo.add(jmiAbrir);

        jmiGuardar = new JMenuItem("Guardar");
        jmiGuardar.setMnemonic(KeyEvent.VK_G);
        jmiGuardar.addActionListener(this);
        jmArchivo.add(jmiGuardar);

        jmiSalir = new JMenuItem("Salir");
        jmiSalir.setMnemonic(KeyEvent.VK_S);
        jmiSalir.addActionListener(this);
        jmArchivo.add(jmiSalir);

        jmbMenu.add(jmArchivo);

        // Agregar el menú Edición
        jmEdicion = new JMenu("Edición");
        jmEdicion.setMnemonic(KeyEvent.VK_E);

        jmiCopiar = new JMenuItem("Copiar");
        jmiCopiar.setMnemonic(KeyEvent.VK_C);
        jmiCopiar.addActionListener(this);
        jmEdicion.add(jmiCopiar);

        jmiCortar = new JMenuItem("Cortar");
        jmiCortar.setMnemonic(KeyEvent.VK_X);
        jmiCortar.addActionListener(this);
        jmEdicion.add(jmiCortar);

        jmiPegar = new JMenuItem("Pegar");
        jmiPegar.setMnemonic(KeyEvent.VK_V);
        jmiPegar.addActionListener(this);
        jmEdicion.add(jmiPegar);

        jmbMenu.add(jmEdicion);

        // Agregar el menú Ayuda
        jmAyuda = new JMenu("Ayuda");
        jmAyuda.setMnemonic(KeyEvent.VK_H);

        jmiAcercaDe = new JMenuItem("Acerca de...");
        jmiAcercaDe.setMnemonic(KeyEvent.VK_F1);
        jmiAcercaDe.addActionListener(this);
        jmAyuda.add(jmiAcercaDe);

        jmbMenu.add(jmAyuda);

        setJMenuBar(jmbMenu);
    }

    // BOTONES Y ÁREA DE TEXTO A LADO DERECHO Y DARLE COLOR A LAS LETRAS
    private void initPanelCentro() {
        GridBagConstraints A = new GridBagConstraints();
        A.insets = new Insets(5, 5, 5, 5);
        A.anchor = GridBagConstraints.WEST;

        A.gridx = 0; A.gridy = 0;
        jpCentro.add(new JLabel("Nombre:"), A);

        A.gridx = 1;
        txtNombre = new JTextField(15);
        jpCentro.add(txtNombre, A);

        A.gridx = 2;
        lblNombreMostrado = new JLabel(" ");
        lblNombreMostrado.setFont(new Font("Arial", Font.BOLD, 12));
        lblNombreMostrado.setForeground(Color.BLUE);
        jpCentro.add(lblNombreMostrado, A);

        A.gridx = 0; A.gridy = 1;
        jpCentro.add(new JLabel("Dirección:"), A);

        A.gridx = 1;
        txtDireccion = new JTextArea(3, 15);
        JScrollPane scrollPane = new JScrollPane(txtDireccion);
        jpCentro.add(scrollPane, A);

        A.gridx = 2;
        lblDireccionMostrada = new JLabel(" ");
        lblDireccionMostrada.setFont(new Font("Arial", Font.BOLD, 12));
        lblDireccionMostrada.setForeground(Color.BLUE);
        jpCentro.add(lblDireccionMostrada, A);

        A.gridx = 0; A.gridy = 2;
        jpCentro.add(new JLabel("Edad:"),A);

        A.gridx = 1;
        cmbLista = new JComboBox<>();
        cmbLista.addItem("18");
        cmbLista.addItem("19");
        cmbLista.addItem("20");
        cmbLista.addItem("21");
        
        jpCentro.add(cmbLista, A);

        A.gridx = 0; A.gridy = 3;
        jpCentro.add(new JLabel("Estudios:"), A);

        A.gridx = 1;
        chkOp1 = new JCheckBox("Secundaria");
        chkOp2 = new JCheckBox("Preparatoria");
        chkOp3 = new JCheckBox("Universidad");
        chkOp4 = new JCheckBox("NINGUNO");
        JPanel chkPanel = new JPanel();
        chkPanel.add(chkOp1);
        chkPanel.add(chkOp2);
        chkPanel.add(chkOp3);
        chkPanel.add(chkOp4);
        jpCentro.add(chkPanel, A);
        
        A.gridx = 2;
        lblEstudiosMostrado = new JLabel(" ");
        lblEstudiosMostrado.setFont(new Font("Arial", Font.BOLD, 12));
        lblEstudiosMostrado.setForeground(Color.BLUE);
        jpCentro.add(lblEstudiosMostrado, A);

        A.gridx = 0; A.gridy = 4;
        jpCentro.add(new JLabel("SEXO:"), A);

        A.gridx = 1;
        grupoRadio = new ButtonGroup();
        rdoOp1 = new JRadioButton("Femenino");
        rdoOp2 = new JRadioButton("Masculino");
        rdoOp3 = new JRadioButton("Otro");
        grupoRadio.add(rdoOp1);
        grupoRadio.add(rdoOp2);
        grupoRadio.add(rdoOp3);
        JPanel radioPanel = new JPanel();
        radioPanel.add(rdoOp1);
        radioPanel.add(rdoOp2);
        radioPanel.add(rdoOp3);
        jpCentro.add(radioPanel, A);
        
        A.gridx = 2;
        lblSexoMostrado = new JLabel(" ");
        lblSexoMostrado.setFont(new Font("Arial", Font.BOLD, 12));
        lblSexoMostrado.setForeground(Color.BLUE);
        jpCentro.add(lblSexoMostrado, A);

        // Agregar eventos para actualizar el texto al presionar Enter
        txtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    lblNombreMostrado.setText(txtNombre.getText());
                }
            }
        });

        txtDireccion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    lblDireccionMostrada.setText(txtDireccion.getText());
                }
            }
        });
        
        ActionListener sexoListener = e -> {
            JRadioButton selected = (JRadioButton) e.getSource();
            lblSexoMostrado.setText(selected.getText());
        };
        rdoOp1.addActionListener(sexoListener);
        rdoOp2.addActionListener(sexoListener);
        rdoOp3.addActionListener(sexoListener);

        ItemListener estudiosListener = e -> {
            ArrayList<String> seleccionados = new ArrayList<>();
            if (chkOp1.isSelected()) seleccionados.add("Secundaria");
            if (chkOp2.isSelected()) seleccionados.add("Preparatoria");
            if (chkOp3.isSelected()) seleccionados.add("Universidad");
            if (chkOp4.isSelected()) seleccionados.add("NINGUNO");
            lblEstudiosMostrado.setText(String.join(", ", seleccionados));
        };
        chkOp1.addItemListener(estudiosListener);
        chkOp2.addItemListener(estudiosListener);
        chkOp3.addItemListener(estudiosListener);
        chkOp4.addItemListener(estudiosListener);
    }

    private void initPanelOeste() {
        lblnomarc = new JLabel();
        //LAS QUE ESTAN EN EL COLOR AMARILLO
        jpOeste.add(new JLabel("OPCIONES"));
        
        boton = new JButton("Abrir");
      //  boton.addActionListener(this);
        jpOeste.add(boton);

        btnGuardar = new JButton("Guardar");
      //  btnGuardar.addActionListener(this);
        jpOeste.add(btnGuardar);

        btnSalir = new JButton("Salir");
      //  btnSalir.addActionListener(this);
        jpOeste.add(btnSalir);
        
        jpOeste.add(lblnomarc);
    }

    private void InitPanelNorte() {

    	//ESTAN EN LA ESQUINA DE LA IZQUIERDA
        jtbHerramientas = new JToolBar("Herramientas principales, JToolBar.HORIZONTAL");
        jtbHerramientas.setFloatable(true);
        jtbHerramientas.setAlignmentX(JToolBar.LEFT_ALIGNMENT);
        
        jtbHerramientas.addSeparator();
        
        btnOpen = new JButton("Abrir");
        btnOpen.setToolTipText("Abrir");
        btnOpen.addActionListener(this);
        jtbHerramientas.add(btnOpen);
        
        jtbHerramientas.add(new JToolBar.Separator());
        
        btnSave = new JButton("Guardar");
        btnSave.setToolTipText("Guardar");
        btnSave.addActionListener(this);
        jtbHerramientas.add(btnSave);
        
        jtbHerramientas.add(new JToolBar.Separator());
      
        
        btnExit = new JButton("Salir");
        btnExit.setToolTipText("Salir");
        btnExit.addActionListener(this);
        jtbHerramientas.add(btnExit);
        
        add(jtbHerramientas, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton || e.getSource() == jmiAbrir || e.getSource() == btnOpen) {
            JFileChooser chooser = new JFileChooser();
            ActualizaInfo1("Abrir Archivo");
            
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.setCurrentDirectory(new File("C:/"));
            chooser.setAcceptAllFileFilterUsed(true);
            chooser.setFileFilter(new FileNameExtensionFilter("Documentos", "pdf", "doc"));
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                lblnomarc.setText("Seleccionado: " + chooser.getSelectedFile().getName());
            }
        } else if (e.getSource() == btnGuardar || e.getSource() == jmiGuardar || e.getSource() == btnSave) {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            chooser.setCurrentDirectory(new File("C:/"));
            chooser.setAcceptAllFileFilterUsed(true);
            chooser.setFileFilter(new FileNameExtensionFilter("Documentos", "pdf", "doc"));
            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                lblnomarc.setText("Guardado: " + chooser.getSelectedFile().getName());
            }
        } else if (e.getSource() == btnSalir || e.getSource() == jmiSalir || e.getSource() == btnExit) {
            if (JOptionPane.showConfirmDialog(this, "¿SEGURO QUE QUIERE SALIR?", "Aviso del Sistema",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
               tmrHora.stop();
            	System.exit(0);
            }
        } else if (e.getSource() == jmiAcercaDe) {
            JOptionPane.showMessageDialog(this, "Aplicación de registro de datos", "Acerca de...", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
