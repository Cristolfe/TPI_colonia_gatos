/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.GUI;

import edu.ugd.tpi_colonia_gatos.modelo.Administrador;
import edu.ugd.tpi_colonia_gatos.modelo.Alimentacion;
import edu.ugd.tpi_colonia_gatos.modelo.AsignarGatoFamilia;
import edu.ugd.tpi_colonia_gatos.modelo.CapturaCastracion;
import edu.ugd.tpi_colonia_gatos.modelo.CertificadosAdopcion;
import edu.ugd.tpi_colonia_gatos.modelo.ControlVeterinario;
import edu.ugd.tpi_colonia_gatos.modelo.Diagnosticos;
import edu.ugd.tpi_colonia_gatos.modelo.Estudios;
import edu.ugd.tpi_colonia_gatos.modelo.Familia;
import edu.ugd.tpi_colonia_gatos.modelo.Gato;
import edu.ugd.tpi_colonia_gatos.modelo.HistorialMedico;
import edu.ugd.tpi_colonia_gatos.modelo.HogarAdopcion;
import edu.ugd.tpi_colonia_gatos.modelo.HogarTransito;
import edu.ugd.tpi_colonia_gatos.modelo.Hogares;
import edu.ugd.tpi_colonia_gatos.modelo.PostuladoParaAdopcion;
import edu.ugd.tpi_colonia_gatos.modelo.Tarea;
import edu.ugd.tpi_colonia_gatos.modelo.TrasporteHogar;
import edu.ugd.tpi_colonia_gatos.utiles.QRUtils;
import edu.ugd.tpi_colonia_gatos.modelo.Usuario;
import edu.ugd.tpi_colonia_gatos.modelo.Veterinario;
import edu.ugd.tpi_colonia_gatos.modelo.VisitaSeguimiento;
import edu.ugd.tpi_colonia_gatos.modelo.Voluntario;
import edu.ugd.tpi_colonia_gatos.modelo.ZonasAvistamientos;
import edu.ugd.tpi_colonia_gatos.persistencia.ControladorPersistente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;


/**
 *
 * @author wowle
 */
public class MainMenu extends javax.swing.JFrame {
    ControladorPersistente controlador = new ControladorPersistente();
    
 DefaultTableModel ModeloGatoAptitud = new DefaultTableModel(
    new Object[]{"ID Gato", "Nombre", "Estado de Salud", "Aptitud"}, 0
);
    
    DefaultTableModel ModeloGatoHistorial  = new DefaultTableModel(
    new Object[]{"ID Gato", "Nombre", "ID Historial"}, 0
);
    
    
    
    DefaultTableModel modeloPostulaciones = new DefaultTableModel(
    new Object[][]{},
    new String[]{"ID", "Gato", "Familia", "Fecha", "Aceptado"}
);
    
    
    
    DefaultTableModel modeloGatos = new DefaultTableModel(
     new Object[][]{},
       new String[]{"ID", "Nombre", "Color", "Características", "Foto (URL)"}
        );
    
    DefaultTableModel modeloUsuarios = new DefaultTableModel(
    new Object[]{"DNI", "Nombre", "Apellido", "Fecha de Nacimiento", "Tipo de Usuario", "Contraseña"},
    0
);
  
     DefaultTableModel modeloZonas = new DefaultTableModel(
    new Object[]{"ID", "Nombre"},
    0
);
    
DefaultTableModel modeloInicial = new DefaultTableModel(
    new Object[][]{{"N/A", "N/A", "N/A", "N/A"}},  
    new String[]{"N/A", "N/A", "N/A", "N/A"}       
);
     
     
     Familia usuarioFamiliar = new Familia();
     Voluntario usuarioVoluntario = new Voluntario();
     Veterinario usuarioVeterinario = new Veterinario();
     Administrador usuarioAdministrador = new Administrador();
     
     
    private JTextField txtUbicacion;
    private JSpinner spnFecha;
    private JSpinner spnHora;

     
     
     
     
     
     
    public MainMenu() {
        initComponents();
      
        tabla_aptitud.setModel(ModeloGatoAptitud);
        table_historialmedico.setModel(ModeloGatoHistorial);
        tab_lista_gatos.setModel(modeloGatos);
        tabla_lista_postulaciones.setModel(modeloPostulaciones);
        tabla_reportes.setModel(modeloInicial);
        tabla_lista_zona.setModel(modeloZonas);
        tabla_lista_usuarios.setModel(modeloUsuarios);
       
        inicializarBoxContenedoresGatos();
        configurarEventos();
/*
        ocultarPestañas(Tab_Principal);
        ocultarPestañas(tab_administrador);
        ocultarPestañas(tab_veterinarios);
        ocultarPestañas(tab_voluntarios);
        ocultarPestañas(tab_familiar);
        ocultarPestañas(Tab_inicio_registrar);
     */
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dialogo = new javax.swing.JOptionPane();
        jOptionPane = new javax.swing.JOptionPane();
        Tab_Principal = new javax.swing.JTabbedPane();
        PrincipalLog = new javax.swing.JPanel();
        labelTituloLOG = new javax.swing.JLabel();
        Tab_inicio_registrar = new javax.swing.JTabbedPane();
        Panel_inicio_sesion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TF_DNI_Log = new javax.swing.JTextField();
        TF_PASS_Log = new javax.swing.JTextField();
        BT_Iniciar_sesion = new javax.swing.JButton();
        BT_registrarse = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Panel_inicio_sesion1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TF_registro_dni = new javax.swing.JTextField();
        TF_registro_nombre = new javax.swing.JTextField();
        TF_registro_fechanac = new javax.swing.JTextField();
        TF_registro_direccion = new javax.swing.JTextField();
        TF_registro_apellido = new javax.swing.JTextField();
        btConfirmaRegistro1 = new javax.swing.JButton();
        btcancelarRegistro = new javax.swing.JButton();
        TF_registro_pass = new javax.swing.JTextField();
        GestionVoluntarios = new javax.swing.JPanel();
        tab_voluntarios = new javax.swing.JTabbedPane();
        GestionGatoTab1 = new javax.swing.JPanel();
        labelTituloLOG2 = new javax.swing.JLabel();
        bt_RegistrarTarea = new javax.swing.JButton();
        bt_RegistrarGato = new javax.swing.JButton();
        bt_volverGestionGatos = new javax.swing.JButton();
        bt_RegistrarTarea1 = new javax.swing.JButton();
        bt_RegistrarHogar = new javax.swing.JButton();
        RegistrarGato = new javax.swing.JPanel();
        labelTituloLOG1 = new javax.swing.JLabel();
        bt_VolverRegistroGato = new javax.swing.JButton();
        bt_confirmarRegistroGato = new javax.swing.JButton();
        G_color = new javax.swing.JTextField();
        G_caracteristica = new javax.swing.JTextField();
        G_foto = new javax.swing.JTextField();
        G_nombre = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        G_estadoSalud = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1_zonas = new javax.swing.JComboBox<>();
        RegistrarTarea = new javax.swing.JPanel();
        labelTituloLOG3 = new javax.swing.JLabel();
        btnAlimentacion = new javax.swing.JButton();
        btnCaptura = new javax.swing.JButton();
        btnTransporte = new javax.swing.JButton();
        btnAsignarFamiliar = new javax.swing.JButton();
        btnVolverTareas = new javax.swing.JButton();
        btnVisita = new javax.swing.JButton();
        btnControlVeterinario1 = new javax.swing.JButton();
        VoluntarioGestionAdopcion = new javax.swing.JPanel();
        labelTituloLOG4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabla_lista_postulaciones = new javax.swing.JTable();
        bt_ListarGatos1 = new javax.swing.JButton();
        bt_postularseParaAdoptarlo1 = new javax.swing.JButton();
        bt_volverFamilia1 = new javax.swing.JButton();
        GestionAdministrador = new javax.swing.JPanel();
        tab_administrador = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        labelTituloLOG11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bt_volerAlINicio = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        labelTituloLOG9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_lista_usuarios = new javax.swing.JTable();
        bt_Listar = new javax.swing.JButton();
        bt_crearUsuarioGU = new javax.swing.JButton();
        bt_MOdificarUsuario = new javax.swing.JButton();
        bt_EliminarUusario = new javax.swing.JButton();
        bt_volverGestionUsuarios = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        labelTituloLOG10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_lista_zona = new javax.swing.JTable();
        bt_ListarZona = new javax.swing.JButton();
        bt_crearZona = new javax.swing.JButton();
        bt_modificarZona = new javax.swing.JButton();
        bt_EliminarZona = new javax.swing.JButton();
        bt_volverZonas = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        labelTituloLOG14 = new javax.swing.JLabel();
        bt_volverReportes = new javax.swing.JButton();
        bt_adoptadosreporte = new javax.swing.JButton();
        bt_ReporteXZona = new javax.swing.JButton();
        bt_reportesEsterelizados = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla_reportes = new javax.swing.JTable();
        labelReportes = new javax.swing.JLabel();
        GestionVeterinario = new javax.swing.JPanel();
        tab_veterinarios = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        labelTituloLOG12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_historialmedico = new javax.swing.JTable();
        labelTituloLOG15 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        labelTituloLOG17 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabla_aptitud = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        tab_familiar = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        labelTituloLOG13 = new javax.swing.JLabel();
        scrollistagatros = new javax.swing.JScrollPane();
        tab_lista_gatos = new javax.swing.JTable();
        bt_ListarGatos = new javax.swing.JButton();
        bt_postularseParaAdoptarlo = new javax.swing.JButton();
        bt_volverFamilia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 700));

        Tab_Principal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Tab_Principal.setMaximumSize(new java.awt.Dimension(800, 700));
        Tab_Principal.setMinimumSize(new java.awt.Dimension(800, 700));
        Tab_Principal.setPreferredSize(new java.awt.Dimension(800, 700));

        PrincipalLog.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PrincipalLog.setMaximumSize(new java.awt.Dimension(800, 700));
        PrincipalLog.setMinimumSize(new java.awt.Dimension(800, 700));
        PrincipalLog.setPreferredSize(new java.awt.Dimension(800, 700));

        labelTituloLOG.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelTituloLOG.setText("Colonia de Gatos");
        labelTituloLOG.setToolTipText("");
        labelTituloLOG.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Panel_inicio_sesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Inicio de sesión");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TF_DNI_Log.setText("Ingrese su DNI");
        TF_DNI_Log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_DNI_LogActionPerformed(evt);
            }
        });

        TF_PASS_Log.setText("Ingrese su contraseña");
        TF_PASS_Log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_PASS_LogActionPerformed(evt);
            }
        });

        BT_Iniciar_sesion.setText("Iniciar");
        BT_Iniciar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_Iniciar_sesionActionPerformed(evt);
            }
        });

        BT_registrarse.setText("Registrarse");
        BT_registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_registrarseActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("no posees cuenta?");

        javax.swing.GroupLayout Panel_inicio_sesionLayout = new javax.swing.GroupLayout(Panel_inicio_sesion);
        Panel_inicio_sesion.setLayout(Panel_inicio_sesionLayout);
        Panel_inicio_sesionLayout.setHorizontalGroup(
            Panel_inicio_sesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_inicio_sesionLayout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BT_registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
            .addGroup(Panel_inicio_sesionLayout.createSequentialGroup()
                .addGroup(Panel_inicio_sesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_inicio_sesionLayout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addGroup(Panel_inicio_sesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TF_PASS_Log, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_DNI_Log, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Panel_inicio_sesionLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(BT_Iniciar_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_inicio_sesionLayout.setVerticalGroup(
            Panel_inicio_sesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_inicio_sesionLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TF_DNI_Log, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TF_PASS_Log, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(BT_Iniciar_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addGroup(Panel_inicio_sesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BT_registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(14, 14, 14))
        );

        Tab_inicio_registrar.addTab("tab1", Panel_inicio_sesion);

        Panel_inicio_sesion1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Registro");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TF_registro_dni.setText("Ingrese su DNI");
        TF_registro_dni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_registro_dniActionPerformed(evt);
            }
        });

        TF_registro_nombre.setText("Ingrese su Nombre");
        TF_registro_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_registro_nombreActionPerformed(evt);
            }
        });

        TF_registro_fechanac.setText("Ingrese su Fecha de Nac");
        TF_registro_fechanac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_registro_fechanacActionPerformed(evt);
            }
        });

        TF_registro_direccion.setText("Ingrese su Direccion");
        TF_registro_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_registro_direccionActionPerformed(evt);
            }
        });

        TF_registro_apellido.setText("Ingrese su Apellido");
        TF_registro_apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_registro_apellidoActionPerformed(evt);
            }
        });

        btConfirmaRegistro1.setText("Registrar");
        btConfirmaRegistro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmaRegistro1ActionPerformed(evt);
            }
        });

        btcancelarRegistro.setText("Volver");
        btcancelarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcancelarRegistroActionPerformed(evt);
            }
        });

        TF_registro_pass.setText("Ingrese su Contraseña");
        TF_registro_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_registro_passActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_inicio_sesion1Layout = new javax.swing.GroupLayout(Panel_inicio_sesion1);
        Panel_inicio_sesion1.setLayout(Panel_inicio_sesion1Layout);
        Panel_inicio_sesion1Layout.setHorizontalGroup(
            Panel_inicio_sesion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_inicio_sesion1Layout.createSequentialGroup()
                .addGroup(Panel_inicio_sesion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_inicio_sesion1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addGroup(Panel_inicio_sesion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TF_registro_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_registro_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_registro_fechanac, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_registro_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_registro_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_registro_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Panel_inicio_sesion1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(btConfirmaRegistro1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btcancelarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        Panel_inicio_sesion1Layout.setVerticalGroup(
            Panel_inicio_sesion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_inicio_sesion1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TF_registro_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(TF_registro_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TF_registro_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TF_registro_fechanac, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TF_registro_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(TF_registro_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(Panel_inicio_sesion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConfirmaRegistro1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(btcancelarRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        Tab_inicio_registrar.addTab("tab1", Panel_inicio_sesion1);

        javax.swing.GroupLayout PrincipalLogLayout = new javax.swing.GroupLayout(PrincipalLog);
        PrincipalLog.setLayout(PrincipalLogLayout);
        PrincipalLogLayout.setHorizontalGroup(
            PrincipalLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(PrincipalLogLayout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addComponent(Tab_inicio_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PrincipalLogLayout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(labelTituloLOG, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PrincipalLogLayout.setVerticalGroup(
            PrincipalLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLogLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(labelTituloLOG)
                .addGap(28, 28, 28)
                .addComponent(Tab_inicio_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        Tab_Principal.addTab("tab1", PrincipalLog);

        GestionVoluntarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        GestionVoluntarios.setMaximumSize(new java.awt.Dimension(800, 700));
        GestionVoluntarios.setMinimumSize(new java.awt.Dimension(800, 700));
        GestionVoluntarios.setPreferredSize(new java.awt.Dimension(800, 700));

        labelTituloLOG2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelTituloLOG2.setText("Gestion Voluntarios");
        labelTituloLOG2.setToolTipText("");
        labelTituloLOG2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        bt_RegistrarTarea.setText("Registrar Tarea");
        bt_RegistrarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_RegistrarTareaActionPerformed(evt);
            }
        });

        bt_RegistrarGato.setText("Registrar Gato");
        bt_RegistrarGato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_RegistrarGatoActionPerformed(evt);
            }
        });

        bt_volverGestionGatos.setText("Salir");
        bt_volverGestionGatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_volverGestionGatosActionPerformed(evt);
            }
        });

        bt_RegistrarTarea1.setText("Gestion Adopcion");
        bt_RegistrarTarea1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_RegistrarTarea1ActionPerformed(evt);
            }
        });

        bt_RegistrarHogar.setText("Registrar Hogar");
        bt_RegistrarHogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_RegistrarHogarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GestionGatoTab1Layout = new javax.swing.GroupLayout(GestionGatoTab1);
        GestionGatoTab1.setLayout(GestionGatoTab1Layout);
        GestionGatoTab1Layout.setHorizontalGroup(
            GestionGatoTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionGatoTab1Layout.createSequentialGroup()
                .addGroup(GestionGatoTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GestionGatoTab1Layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(bt_volverGestionGatos, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GestionGatoTab1Layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(labelTituloLOG2))
                    .addGroup(GestionGatoTab1Layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addGroup(GestionGatoTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_RegistrarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_RegistrarGato, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_RegistrarTarea1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_RegistrarHogar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(236, Short.MAX_VALUE))
        );
        GestionGatoTab1Layout.setVerticalGroup(
            GestionGatoTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionGatoTab1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(labelTituloLOG2)
                .addGap(42, 42, 42)
                .addComponent(bt_RegistrarGato, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_RegistrarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_RegistrarTarea1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_RegistrarHogar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(bt_volverGestionGatos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );

        tab_voluntarios.addTab("tab3", GestionGatoTab1);

        RegistrarGato.setMaximumSize(new java.awt.Dimension(800, 600));
        RegistrarGato.setMinimumSize(new java.awt.Dimension(800, 600));
        RegistrarGato.setPreferredSize(new java.awt.Dimension(800, 600));

        labelTituloLOG1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelTituloLOG1.setText("Registrar Gato");
        labelTituloLOG1.setToolTipText("");
        labelTituloLOG1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        bt_VolverRegistroGato.setText("Volver");
        bt_VolverRegistroGato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_VolverRegistroGatoActionPerformed(evt);
            }
        });

        bt_confirmarRegistroGato.setText("Confirmar");
        bt_confirmarRegistroGato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmarRegistroGatoActionPerformed(evt);
            }
        });

        G_color.setText("Ingrese el color");
        G_color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G_colorActionPerformed(evt);
            }
        });

        G_caracteristica.setText("Ingrese el caracteristica");
        G_caracteristica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G_caracteristicaActionPerformed(evt);
            }
        });

        G_foto.setText("Ingrese la url de la foto");

        G_nombre.setText("Ingrese el nombre");
        G_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G_nombreActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setToolTipText("");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Seleccione estado de salud");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setToolTipText("");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Seleccione Zona");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout RegistrarGatoLayout = new javax.swing.GroupLayout(RegistrarGato);
        RegistrarGato.setLayout(RegistrarGatoLayout);
        RegistrarGatoLayout.setHorizontalGroup(
            RegistrarGatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarGatoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_confirmarRegistroGato, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(bt_VolverRegistroGato, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(RegistrarGatoLayout.createSequentialGroup()
                .addGroup(RegistrarGatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistrarGatoLayout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(labelTituloLOG1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistrarGatoLayout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addGroup(RegistrarGatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(G_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G_caracteristica, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G_color, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(283, Short.MAX_VALUE))
            .addGroup(RegistrarGatoLayout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addGroup(RegistrarGatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(RegistrarGatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(G_estadoSalud, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1_zonas, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RegistrarGatoLayout.setVerticalGroup(
            RegistrarGatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarGatoLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(labelTituloLOG1)
                .addGap(70, 70, 70)
                .addComponent(G_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(G_color, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(G_caracteristica, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(G_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(RegistrarGatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(G_estadoSalud)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(RegistrarGatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1_zonas))
                .addGap(27, 27, 27)
                .addGroup(RegistrarGatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_VolverRegistroGato, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_confirmarRegistroGato, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107))
        );

        tab_voluntarios.addTab("tab1", RegistrarGato);

        labelTituloLOG3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelTituloLOG3.setText("Registrar Tareas");
        labelTituloLOG3.setToolTipText("");
        labelTituloLOG3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnAlimentacion.setText("Alimentacion");
        btnAlimentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlimentacionActionPerformed(evt);
            }
        });

        btnCaptura.setText("Captura Castración");
        btnCaptura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapturaActionPerformed(evt);
            }
        });

        btnTransporte.setText("Trasporte a Hogar");
        btnTransporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransporteActionPerformed(evt);
            }
        });

        btnAsignarFamiliar.setText("Asignar Gato a Familair");
        btnAsignarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarFamiliarActionPerformed(evt);
            }
        });

        btnVolverTareas.setText("Volver");
        btnVolverTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverTareasActionPerformed(evt);
            }
        });

        btnVisita.setText("Visita de seguimiento");
        btnVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisitaActionPerformed(evt);
            }
        });

        btnControlVeterinario1.setText("Control Veterinario");
        btnControlVeterinario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlVeterinario1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegistrarTareaLayout = new javax.swing.GroupLayout(RegistrarTarea);
        RegistrarTarea.setLayout(RegistrarTareaLayout);
        RegistrarTareaLayout.setHorizontalGroup(
            RegistrarTareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarTareaLayout.createSequentialGroup()
                .addGroup(RegistrarTareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistrarTareaLayout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(labelTituloLOG3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistrarTareaLayout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addGroup(RegistrarTareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCaptura, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAlimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAsignarFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnControlVeterinario1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(RegistrarTareaLayout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(btnVolverTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(272, Short.MAX_VALUE))
        );
        RegistrarTareaLayout.setVerticalGroup(
            RegistrarTareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarTareaLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(labelTituloLOG3)
                .addGap(62, 62, 62)
                .addComponent(btnAlimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCaptura, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAsignarFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnControlVeterinario1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnVolverTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        tab_voluntarios.addTab("tab3", RegistrarTarea);

        labelTituloLOG4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelTituloLOG4.setText("Gestionar Adopciones");
        labelTituloLOG4.setToolTipText("");
        labelTituloLOG4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tabla_lista_postulaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tabla_lista_postulaciones);

        bt_ListarGatos1.setText("Refrescar Lista");
        bt_ListarGatos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ListarGatos1ActionPerformed(evt);
            }
        });

        bt_postularseParaAdoptarlo1.setText("Aceptar Solicitud");
        bt_postularseParaAdoptarlo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_postularseParaAdoptarlo1ActionPerformed(evt);
            }
        });

        bt_volverFamilia1.setText("Volver");
        bt_volverFamilia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_volverFamilia1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout VoluntarioGestionAdopcionLayout = new javax.swing.GroupLayout(VoluntarioGestionAdopcion);
        VoluntarioGestionAdopcion.setLayout(VoluntarioGestionAdopcionLayout);
        VoluntarioGestionAdopcionLayout.setHorizontalGroup(
            VoluntarioGestionAdopcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VoluntarioGestionAdopcionLayout.createSequentialGroup()
                .addContainerGap(229, Short.MAX_VALUE)
                .addComponent(labelTituloLOG4, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
            .addGroup(VoluntarioGestionAdopcionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(VoluntarioGestionAdopcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bt_postularseParaAdoptarlo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(bt_volverFamilia1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_ListarGatos1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        VoluntarioGestionAdopcionLayout.setVerticalGroup(
            VoluntarioGestionAdopcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VoluntarioGestionAdopcionLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(labelTituloLOG4)
                .addGroup(VoluntarioGestionAdopcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VoluntarioGestionAdopcionLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VoluntarioGestionAdopcionLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(bt_ListarGatos1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(bt_postularseParaAdoptarlo1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191)
                        .addComponent(bt_volverFamilia1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tab_voluntarios.addTab("tab4", VoluntarioGestionAdopcion);

        javax.swing.GroupLayout GestionVoluntariosLayout = new javax.swing.GroupLayout(GestionVoluntarios);
        GestionVoluntarios.setLayout(GestionVoluntariosLayout);
        GestionVoluntariosLayout.setHorizontalGroup(
            GestionVoluntariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(GestionVoluntariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tab_voluntarios))
        );
        GestionVoluntariosLayout.setVerticalGroup(
            GestionVoluntariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(GestionVoluntariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(GestionVoluntariosLayout.createSequentialGroup()
                    .addComponent(tab_voluntarios, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 32, Short.MAX_VALUE)))
        );

        Tab_Principal.addTab("tab2", GestionVoluntarios);

        GestionAdministrador.setMaximumSize(new java.awt.Dimension(800, 700));
        GestionAdministrador.setMinimumSize(new java.awt.Dimension(800, 700));
        GestionAdministrador.setPreferredSize(new java.awt.Dimension(800, 700));

        labelTituloLOG11.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelTituloLOG11.setText("Gestion de Administrador");
        labelTituloLOG11.setToolTipText("");
        labelTituloLOG11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton1.setText("Gestion de Usuarios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Gestion de Zonas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bt_volerAlINicio.setText("Salir");
        bt_volerAlINicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_volerAlINicioActionPerformed(evt);
            }
        });

        jButton3.setText("Gestion de Reportes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(196, Short.MAX_VALUE)
                .addComponent(labelTituloLOG11, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGap(315, 315, 315)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(bt_volerAlINicio, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(labelTituloLOG11)
                .addGap(75, 75, 75)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(bt_volerAlINicio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        tab_administrador.addTab("tab2", jPanel5);

        labelTituloLOG9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelTituloLOG9.setText("Gestion Usuarios");
        labelTituloLOG9.setToolTipText("");
        labelTituloLOG9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tabla_lista_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla_lista_usuarios);

        jScrollPane2.setViewportView(jScrollPane1);

        bt_Listar.setText("Refrescar Lista");
        bt_Listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ListarActionPerformed(evt);
            }
        });

        bt_crearUsuarioGU.setText("Crear Usuario");
        bt_crearUsuarioGU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_crearUsuarioGUActionPerformed(evt);
            }
        });

        bt_MOdificarUsuario.setText("Modificar Usuario");
        bt_MOdificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_MOdificarUsuarioActionPerformed(evt);
            }
        });

        bt_EliminarUusario.setText("Eliminar Usuario");
        bt_EliminarUusario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_EliminarUusarioActionPerformed(evt);
            }
        });

        bt_volverGestionUsuarios.setText("Volver");
        bt_volverGestionUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_volverGestionUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_crearUsuarioGU, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(bt_MOdificarUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(bt_EliminarUusario, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(bt_volverGestionUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(bt_Listar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(labelTituloLOG9, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labelTituloLOG9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(bt_Listar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_crearUsuarioGU, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_MOdificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_EliminarUusario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_volverGestionUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        tab_administrador.addTab("tab1", jPanel3);

        labelTituloLOG10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelTituloLOG10.setText("Gestion de Zonas");
        labelTituloLOG10.setToolTipText("");
        labelTituloLOG10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tabla_lista_zona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tabla_lista_zona);

        bt_ListarZona.setText("Refrescar Lista");
        bt_ListarZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ListarZonaActionPerformed(evt);
            }
        });

        bt_crearZona.setText("Agregar Zona");
        bt_crearZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_crearZonaActionPerformed(evt);
            }
        });

        bt_modificarZona.setText("Modificar Zona");
        bt_modificarZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_modificarZonaActionPerformed(evt);
            }
        });

        bt_EliminarZona.setText("Eliminar Zona");
        bt_EliminarZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_EliminarZonaActionPerformed(evt);
            }
        });

        bt_volverZonas.setText("Volver");
        bt_volverZonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_volverZonasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(labelTituloLOG10, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_crearZona, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(bt_modificarZona, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(bt_EliminarZona, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(bt_volverZonas, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(bt_ListarZona, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(25, 25, 25))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(labelTituloLOG10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(bt_ListarZona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_crearZona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_modificarZona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_EliminarZona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_volverZonas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        tab_administrador.addTab("tab3", jPanel6);

        labelTituloLOG14.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelTituloLOG14.setText("Gestion de Reportes");
        labelTituloLOG14.setToolTipText("");
        labelTituloLOG14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        bt_volverReportes.setText("Volver");
        bt_volverReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_volverReportesActionPerformed(evt);
            }
        });

        bt_adoptadosreporte.setText("Gatos  Adoptados");
        bt_adoptadosreporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_adoptadosreporteActionPerformed(evt);
            }
        });

        bt_ReporteXZona.setText("Gatos por Zona");
        bt_ReporteXZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ReporteXZonaActionPerformed(evt);
            }
        });

        bt_reportesEsterelizados.setText("Gatos  Esterelizados");
        bt_reportesEsterelizados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_reportesEsterelizadosActionPerformed(evt);
            }
        });

        tabla_reportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tabla_reportes);

        labelReportes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(219, 219, 219)
                                .addComponent(labelTituloLOG14, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_ReporteXZona, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bt_volverReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(bt_reportesEsterelizados, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                        .addComponent(bt_adoptadosreporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(labelTituloLOG14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(labelReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(bt_ReporteXZona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(bt_reportesEsterelizados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(bt_adoptadosreporte, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(bt_volverReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        tab_administrador.addTab("tab4", jPanel9);

        javax.swing.GroupLayout GestionAdministradorLayout = new javax.swing.GroupLayout(GestionAdministrador);
        GestionAdministrador.setLayout(GestionAdministradorLayout);
        GestionAdministradorLayout.setHorizontalGroup(
            GestionAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionAdministradorLayout.createSequentialGroup()
                .addComponent(tab_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2, Short.MAX_VALUE))
        );
        GestionAdministradorLayout.setVerticalGroup(
            GestionAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionAdministradorLayout.createSequentialGroup()
                .addComponent(tab_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );

        Tab_Principal.addTab("tab3", GestionAdministrador);

        GestionVeterinario.setMaximumSize(new java.awt.Dimension(800, 700));
        GestionVeterinario.setMinimumSize(new java.awt.Dimension(800, 700));
        GestionVeterinario.setPreferredSize(new java.awt.Dimension(800, 700));

        labelTituloLOG12.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelTituloLOG12.setText("Gestion de Veterinario");
        labelTituloLOG12.setToolTipText("");
        labelTituloLOG12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton4.setText("Historial Medico");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton8.setText("Salir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Certificados de adopcion");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(225, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(labelTituloLOG12, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(344, 344, 344))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(labelTituloLOG12)
                .addGap(106, 106, 106)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203))
        );

        tab_veterinarios.addTab("tab1", jPanel2);

        table_historialmedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(table_historialmedico);

        labelTituloLOG15.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelTituloLOG15.setText("Historial Medico");
        labelTituloLOG15.setToolTipText("");
        labelTituloLOG15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton5.setText("Volver");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Ver Historial  Selecc.");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Listar Gatos");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(labelTituloLOG15, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelTituloLOG15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        tab_veterinarios.addTab("tab2", jPanel10);

        labelTituloLOG17.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelTituloLOG17.setText("Certificados Aptitud");
        labelTituloLOG17.setToolTipText("");
        labelTituloLOG17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tabla_aptitud.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tabla_aptitud);

        jButton10.setText("Listar Gatos");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Crear Certificado");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Volver");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(labelTituloLOG17, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(labelTituloLOG17)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
        );

        tab_veterinarios.addTab("tab3", jPanel11);

        javax.swing.GroupLayout GestionVeterinarioLayout = new javax.swing.GroupLayout(GestionVeterinario);
        GestionVeterinario.setLayout(GestionVeterinarioLayout);
        GestionVeterinarioLayout.setHorizontalGroup(
            GestionVeterinarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab_veterinarios)
        );
        GestionVeterinarioLayout.setVerticalGroup(
            GestionVeterinarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionVeterinarioLayout.createSequentialGroup()
                .addComponent(tab_veterinarios, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );

        Tab_Principal.addTab("tab4", GestionVeterinario);

        labelTituloLOG13.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelTituloLOG13.setText("Gestion de Familias");
        labelTituloLOG13.setToolTipText("");
        labelTituloLOG13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tab_lista_gatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollistagatros.setViewportView(tab_lista_gatos);

        bt_ListarGatos.setText("Ver Gatos");
        bt_ListarGatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ListarGatosActionPerformed(evt);
            }
        });

        bt_postularseParaAdoptarlo.setText("Postularse para adoptarlo");
        bt_postularseParaAdoptarlo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_postularseParaAdoptarloActionPerformed(evt);
            }
        });

        bt_volverFamilia.setText("Salir");
        bt_volverFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_volverFamiliaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTituloLOG13, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(231, 231, 231))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollistagatros, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bt_postularseParaAdoptarlo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(bt_volverFamilia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_ListarGatos, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(labelTituloLOG13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(scrollistagatros, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(bt_ListarGatos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(bt_postularseParaAdoptarlo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191)
                        .addComponent(bt_volverFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
        );

        tab_familiar.addTab("tab1", jPanel8);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab_familiar)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab_familiar)
        );

        Tab_Principal.addTab("tab5", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tab_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tab_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TF_DNI_LogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_DNI_LogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_DNI_LogActionPerformed

    private void BT_Iniciar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_Iniciar_sesionActionPerformed
        try {
           int dni = Integer.parseInt(TF_DNI_Log.getText().trim());
           String pass = TF_PASS_Log.getText().trim();

           Usuario usuario = controlador.autenticarUsuario(dni, pass);

           if (usuario == null) {
               Dialogo.showMessageDialog(this, "Usuario no encontrado.");
               return;
           }

           if (!usuario.getPass().equals(pass)) {
               Dialogo.showMessageDialog(this, "Contraseña incorrecta.");
               return;
           }

           
           String mensaje = "¡Bienvenido " + usuario.getNombre() + " " + usuario.getApellido() + "!";
           int opcion = Dialogo.showConfirmDialog(
               this,
               mensaje,
               "Inicio de sesión exitoso",
               Dialogo.DEFAULT_OPTION
           );

           if (opcion == Dialogo.OK_OPTION) {
               
               if (usuario instanceof Administrador) {
                    usuarioAdministrador = (Administrador) usuario;
                   Tab_Principal.setSelectedIndex(2);
                   tab_administrador.setSelectedIndex(0);
               } else if (usuario instanceof Veterinario) {
                    usuarioVeterinario = (Veterinario) usuario;
                   Tab_Principal.setSelectedIndex(3);
                   tab_veterinarios.setSelectedIndex(0);
               } else if (usuario instanceof Voluntario) {
                   usuarioVoluntario = (Voluntario) usuario;
                   Tab_Principal.setSelectedIndex(1);
                   tab_voluntarios.setSelectedIndex(0);
               } else if (usuario instanceof Familia) {
                   
                   usuarioFamiliar = (Familia) usuario;
                   Tab_Principal.setSelectedIndex(4);
                   tab_familiar.setSelectedIndex(0);
               }
           }

       } catch (NumberFormatException e) {
           Dialogo.showMessageDialog(this, "Ingrese un DNI válido (solo números).");
       } catch (Exception ex) {
           Dialogo.showMessageDialog(this, "Error al iniciar sesión: " + ex.getMessage());
         
       }
  
    }//GEN-LAST:event_BT_Iniciar_sesionActionPerformed

    private void BT_registrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_registrarseActionPerformed
        // TODO add your handling code here:
        Tab_inicio_registrar.setSelectedIndex(1); //cambia la pestaña del tab
    }//GEN-LAST:event_BT_registrarseActionPerformed

    private void TF_PASS_LogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_PASS_LogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_PASS_LogActionPerformed

    private void TF_registro_dniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_registro_dniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_registro_dniActionPerformed

    private void TF_registro_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_registro_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_registro_nombreActionPerformed

    private void TF_registro_fechanacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_registro_fechanacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_registro_fechanacActionPerformed

    private void TF_registro_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_registro_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_registro_direccionActionPerformed

    private void TF_registro_apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_registro_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_registro_apellidoActionPerformed

    private void btConfirmaRegistro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmaRegistro1ActionPerformed
        // TODO add your handling code here:
       try {
        
        int dni = Integer.parseInt(TF_registro_dni.getText());
        String nombre = TF_registro_nombre.getText();
        String apellido = TF_registro_apellido.getText();
        String direccion = TF_registro_direccion.getText();
        String pass = TF_registro_pass.getText();

       
        java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaNac = formato.parse(TF_registro_fechanac.getText());

       
        Familia nuevoFamiliar = new Familia();
        nuevoFamiliar.setDni(dni);
        nuevoFamiliar.setNombre(nombre);
        nuevoFamiliar.setApellido(apellido);
        nuevoFamiliar.setDireccion(direccion);
        nuevoFamiliar.setPass(pass);
        nuevoFamiliar.setFechNac(fechaNac);

      
        controlador.crearFamilia(nuevoFamiliar);

      
        Dialogo.showMessageDialog(this, 
            "Registro completado con éxito para " + nombre + " " + apellido,
            "Éxito", Dialogo.INFORMATION_MESSAGE);

     
        TF_registro_dni.setText("Ingrese su DNI");
        TF_registro_nombre.setText("Ingrese su Nombre");
        TF_registro_apellido.setText("Ingrese su Apellido");
        TF_registro_direccion.setText("Ingrese su Direccion");
        TF_registro_direccion.setText("Ingrese su contraseña");
        TF_registro_fechanac.setText("Ingrese su Fecha de Nac");
        TF_registro_pass.setText("Ingrese su contraseña");

    } catch (Exception e) {
        Dialogo.showMessageDialog(this, 
            "Error al registrar usuario: " + e.getMessage(), 
            "Error", Dialogo.ERROR_MESSAGE);
   
    }
        
        
        
        
        
    }//GEN-LAST:event_btConfirmaRegistro1ActionPerformed

    private void btcancelarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcancelarRegistroActionPerformed
        // TODO add your handling code here:
        Tab_inicio_registrar.setSelectedIndex(0);//Vuelve a inicio sesion
    }//GEN-LAST:event_btcancelarRegistroActionPerformed

    private void bt_RegistrarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_RegistrarTareaActionPerformed
        // TODO add your handling code here:
          tab_voluntarios.setSelectedIndex(2);
    }//GEN-LAST:event_bt_RegistrarTareaActionPerformed

    private void bt_RegistrarGatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_RegistrarGatoActionPerformed
        // TODO add your handling code here:
        tab_voluntarios.setSelectedIndex(1);
    }//GEN-LAST:event_bt_RegistrarGatoActionPerformed

    private void G_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_G_nombreActionPerformed

    private void G_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G_colorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_G_colorActionPerformed

    private void G_caracteristicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G_caracteristicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_G_caracteristicaActionPerformed

    private void bt_confirmarRegistroGatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmarRegistroGatoActionPerformed
        // TODO add your handling code here:
        
    try {
       
      String nombre = G_nombre.getText();
       String color = G_color.getText();
       String caracteristicas = G_caracteristica.getText();
       String foto = G_foto.getText();
       Gato.EstadoSalud estado = (Gato.EstadoSalud) G_estadoSalud.getSelectedItem();
       Gato.EstadoAdopcion situacion = Gato.EstadoAdopcion.NOAPTO;

      
       ZonasAvistamientos zonaSeleccionada = (ZonasAvistamientos) jComboBox1_zonas.getSelectedItem();
       if (zonaSeleccionada == null) {
           throw new Exception("Debe seleccionar una zona.");
       }


       Gato nuevoGato = new Gato(nombre, color, caracteristicas, foto, estado, situacion);
       nuevoGato.setZonas(zonaSeleccionada);  // ✅ Aquí se asocia el gato con la zona
       HistorialMedico med_historial = new HistorialMedico();
       nuevoGato.setMedHistorial(med_historial);
       controlador.crearGato(nuevoGato);
    
       
       int id = nuevoGato.getIdGato();
       System.out.println("Nuevo gato ID: " + id);

       String datosQR = "ID: " + id + "\nNombre: " + nombre;
       String qrBase64 = QRUtils.generarQRBase64(datosQR);

       nuevoGato.setCodigoQR(qrBase64);
       controlador.editarGato(nuevoGato);

         Dialogo.showMessageDialog(this,
            "Registro correcto gato:\n" );
        

    } catch (Exception e) {
        
        Dialogo.showMessageDialog(this,
            "Error al registrar el gato:\n" + e.getMessage(),
            "Error", Dialogo.ERROR_MESSAGE);
       
                
        javax.swing.JOptionPane.showMessageDialog(this, "Error al generar QR: " + e.getMessage());
        
    }
  
    }//GEN-LAST:event_bt_confirmarRegistroGatoActionPerformed

    private void bt_RegistrarTarea1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_RegistrarTarea1ActionPerformed
        // TODO add your handling code here:
          tab_voluntarios.setSelectedIndex(3);
    }//GEN-LAST:event_bt_RegistrarTarea1ActionPerformed

    private void TF_registro_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_registro_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_registro_passActionPerformed

    private void bt_ListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ListarActionPerformed
        // TODO add your handling code here:
        listarUsuarios();
    }//GEN-LAST:event_bt_ListarActionPerformed

    private void bt_crearUsuarioGUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_crearUsuarioGUActionPerformed
        // TODO add your handling code here:
        crearUsuario();
    }//GEN-LAST:event_bt_crearUsuarioGUActionPerformed

    private void bt_EliminarUusarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_EliminarUusarioActionPerformed
        // TODO add your handling code here:
        eliminarUsuarioSeleccionado();
    }//GEN-LAST:event_bt_EliminarUusarioActionPerformed

    private void bt_MOdificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_MOdificarUsuarioActionPerformed
        // TODO add your handling code here:
        modificarUsuarioSeleccionado();
    }//GEN-LAST:event_bt_MOdificarUsuarioActionPerformed

    private void bt_ListarZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ListarZonaActionPerformed
        // TODO add your handling code here:
        listarZonas();
    }//GEN-LAST:event_bt_ListarZonaActionPerformed

    private void bt_crearZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_crearZonaActionPerformed
        // TODO add your handling code here:
        crearZona();
    }//GEN-LAST:event_bt_crearZonaActionPerformed

    private void bt_modificarZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_modificarZonaActionPerformed
        // TODO add your handling code here:
        modificarZonaSeleccionada();
    }//GEN-LAST:event_bt_modificarZonaActionPerformed

    private void bt_EliminarZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_EliminarZonaActionPerformed
        // TODO add your handling code here:
        eliminarZonaSeleccionada();
    }//GEN-LAST:event_bt_EliminarZonaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tab_administrador.setSelectedIndex(1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        tab_administrador.setSelectedIndex(2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bt_volerAlINicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_volerAlINicioActionPerformed
        // TODO add your handling code here:
        
        Tab_Principal.setSelectedIndex(0);
    }//GEN-LAST:event_bt_volerAlINicioActionPerformed

    private void bt_volverGestionUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_volverGestionUsuariosActionPerformed
        // TODO add your handling code here:
        tab_administrador.setSelectedIndex(0);
    }//GEN-LAST:event_bt_volverGestionUsuariosActionPerformed

    private void bt_volverZonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_volverZonasActionPerformed
        // TODO add your handling code here:
        tab_administrador.setSelectedIndex(0);
    }//GEN-LAST:event_bt_volverZonasActionPerformed

    private void bt_volverGestionGatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_volverGestionGatosActionPerformed
        // TODO add your handling code here:
        Tab_Principal.setSelectedIndex(0);
    }//GEN-LAST:event_bt_volverGestionGatosActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        tab_administrador.setSelectedIndex(3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bt_volverReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_volverReportesActionPerformed
        // TODO add your handling code here:
        tab_administrador.setSelectedIndex(0);
    }//GEN-LAST:event_bt_volverReportesActionPerformed

    private void bt_adoptadosreporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_adoptadosreporteActionPerformed
        // TODO add your handling code here:
     try {
        
        List<PostuladoParaAdopcion> lista = controlador.obtenerAdoptados();

       
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Postulación");
        modelo.addColumn("Nombre del Gato");
        modelo.addColumn("DNI Familia");
        modelo.addColumn("Nombre Familia");

   
        for (PostuladoParaAdopcion p : lista) {
            Object[] fila = {
                p.getIdPostulacion(),
                p.getGato().getNombre(),
                p.getFamilia().getDni(),
                p.getFamilia().getNombre()
            };
            modelo.addRow(fila);
        }

        tabla_reportes.setModel(modelo);

       
        int total = lista.size();
        labelReportes.setText("Total gatos adoptados: " + total);

    } catch (Exception e) {
        Dialogo.showMessageDialog(this, 
            "Error al generar el reporte: " + e.getMessage(), 
            "Error", Dialogo.ERROR_MESSAGE);
      
    }
    }//GEN-LAST:event_bt_adoptadosreporteActionPerformed

    private void bt_ReporteXZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ReporteXZonaActionPerformed
        // TODO add your handling code here:
        try {
            
            List<Gato> gatos = controlador.obtenerGatos();

            
            Map<String, Long> conteoPorZona = gatos.stream()
                    .collect(Collectors.groupingBy(
                            g -> g.getZonas() != null ? g.getZonas().getNombreZona() : "Sin zona",
                            Collectors.counting()
                    ));

            
            DefaultTableModel modelo = new DefaultTableModel(
                    new Object[][]{},
                    new String[]{"Zona", "Total de Gatos"}
            );

         
            for (Map.Entry<String, Long> entry : conteoPorZona.entrySet()) {
                modelo.addRow(new Object[]{entry.getKey(), entry.getValue()});
            }

           
            tabla_reportes.setModel(modelo);

          
            labelReportes.setText("");

        } catch (Exception e) {
            Dialogo.showMessageDialog(this, "Error al generar reporte por zona: " + e.getMessage());
            
        }

    }//GEN-LAST:event_bt_ReporteXZonaActionPerformed

    private void bt_reportesEsterelizadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_reportesEsterelizadosActionPerformed
        // TODO add your handling code here:
          try {
        
        List<Gato> gatos = controlador.obtenerGatos();

       
        List<Gato> gatosEsterilizados = gatos.stream()
                .filter(g -> g.getEstadoActual() == Gato.EstadoSalud.ESTERILIZADO)
                .toList();

       
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID Gato", "Nombre", "Color", "Zona"}
        );

   
        for (Gato g : gatosEsterilizados) {
            modelo.addRow(new Object[]{
                    g.getIdGato(),
                    g.getNombre(),
                    g.getColor(),
                    g.getZonas() != null ? g.getZonas().getNombreZona() : "Sin zona"
            });
        }

        
        tabla_reportes.setModel(modelo);

       
        labelReportes.setText("Total gatos esterilizados: " + gatosEsterilizados.size());

    } catch (Exception e) {
        Dialogo.showMessageDialog(this, "Error al generar reporte: " + e.getMessage());
        
    }
          
    }//GEN-LAST:event_bt_reportesEsterelizadosActionPerformed

    private void bt_ListarGatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ListarGatosActionPerformed
        // TODO add your handling code here:
        listarGatos();
    }//GEN-LAST:event_bt_ListarGatosActionPerformed

    private void bt_volverFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_volverFamiliaActionPerformed
        // TODO add your handling code here:
        Tab_Principal.setSelectedIndex(0);
    }//GEN-LAST:event_bt_volverFamiliaActionPerformed

    private void bt_postularseParaAdoptarloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_postularseParaAdoptarloActionPerformed
        // TODO add your handling code here:
      PostularParaAdopcion();
    }//GEN-LAST:event_bt_postularseParaAdoptarloActionPerformed

    private void bt_ListarGatos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ListarGatos1ActionPerformed
        // TODO add your handling code here:
        listarPostulaciones();
        
    }//GEN-LAST:event_bt_ListarGatos1ActionPerformed

    private void bt_postularseParaAdoptarlo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_postularseParaAdoptarlo1ActionPerformed
        // TODO add your handling code here:
        aceptarPostulacion();
        
    }//GEN-LAST:event_bt_postularseParaAdoptarlo1ActionPerformed

    private void bt_volverFamilia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_volverFamilia1ActionPerformed
        // TODO add your handling code here:
        tab_voluntarios.setSelectedIndex(0);
    }//GEN-LAST:event_bt_volverFamilia1ActionPerformed

    private void bt_VolverRegistroGatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_VolverRegistroGatoActionPerformed
        // TODO add your handling code here:
          tab_voluntarios.setSelectedIndex(0);
    }//GEN-LAST:event_bt_VolverRegistroGatoActionPerformed

    private void btnAlimentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlimentacionActionPerformed
        // TODO add your handling code here:
   
    }//GEN-LAST:event_btnAlimentacionActionPerformed

    private void btnCapturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCapturaActionPerformed

    private void btnTransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTransporteActionPerformed

    private void btnAsignarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarFamiliarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAsignarFamiliarActionPerformed

    private void btnVolverTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverTareasActionPerformed
        // TODO add your handling code here:
        tab_voluntarios.setSelectedIndex(0);
    }//GEN-LAST:event_btnVolverTareasActionPerformed

    private void btnVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVisitaActionPerformed

    private void bt_RegistrarHogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_RegistrarHogarActionPerformed
        // TODO add your handling code here:
        mostrarFormularioHogar();
    }//GEN-LAST:event_bt_RegistrarHogarActionPerformed

    private void btnControlVeterinario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControlVeterinario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnControlVeterinario1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    HistorialMedico historial = obtenerHistorialSeleccionado();
    mostrarHistorial(historial);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        cargarTablaGatosHistorial();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        tab_veterinarios.setSelectedIndex(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        Tab_Principal.setSelectedIndex(0);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        tab_veterinarios.setSelectedIndex(1);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
         tab_veterinarios.setSelectedIndex(2);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        tab_veterinarios.setSelectedIndex(0);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    
        
    int fila = tabla_aptitud.getSelectedRow();
    
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un gato primero.");
        return;
    }

    int idGato = (int) ModeloGatoAptitud.getValueAt(fila, 0);
    Gato gato = controlador.buscarPorId(idGato);  // tu método existente

    int confirmar = JOptionPane.showConfirmDialog(
        this,
        "¿Crear certificado para el gato?\n" +
        "Nombre: " + gato.getNombre() + "\n" +
        "Veterinario: " + usuarioVeterinario.getNombre() + "\n" +
        "Fecha: " + LocalDate.now(),
        "Confirmar Certificado",
        JOptionPane.YES_NO_OPTION
    );

    if (confirmar == JOptionPane.YES_OPTION) {
        
        CertificadosAdopcion certificado_aptitud =new CertificadosAdopcion(LocalDate.now(),gato, usuarioVeterinario );
        controlador.crearCertificadoAptitud(certificado_aptitud);
        JOptionPane.showMessageDialog(this, "Certificado creado con éxito.");
    }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
     ModeloGatoAptitud.setRowCount(0); // limpiar tabla

   
    List<Gato> lista = controlador.obtenerGatos(); // <-- reemplazá con tu método real

    for (Gato g : lista) {
        if (g.getEstadoActual() == Gato.EstadoSalud.ESTERILIZADO &&
            g.getEstado_adopcion() == Gato.EstadoAdopcion.NOAPTO) {

            ModeloGatoAptitud.addRow(new Object[]{
                g.getIdGato(),
                g.getNombre(),
                g.getEstadoActual().toString(),
                g.getEstado_adopcion().toString()
            });
        }
    }
    
    }//GEN-LAST:event_jButton10ActionPerformed

    
    
private Usuario mostrarFormularioUsuario(Usuario existente) {
    JTextField campoDni = new JTextField(existente != null ? String.valueOf(existente.getDni()) : "");
    JTextField campoNombre = new JTextField(existente != null ? existente.getNombre() : "");
    JTextField campoApellido = new JTextField(existente != null ? existente.getApellido() : "");
    JTextField campoDireccion = new JTextField(existente != null ? existente.getDireccion() : "");
    JTextField campoPass = new JTextField(existente != null ? existente.getPass() : "");
    JTextField campoFechaNac = new JTextField(existente != null && existente.getFechNac() != null
            ? new SimpleDateFormat("yyyy-MM-dd").format(existente.getFechNac())
            : "");

    String[] tipos = {"Administrador", "Veterinario", "Voluntario", "Familia"};
    JComboBox<String> comboTipo = new JComboBox<>(tipos);
    if (existente != null) comboTipo.setSelectedItem(existente.getClass().getSimpleName());

    
    if (existente != null) campoDni.setEditable(true);

    JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
    panel.add(new JLabel("DNI:"));
    panel.add(campoDni);
    panel.add(new JLabel("Nombre:"));
    panel.add(campoNombre);
    panel.add(new JLabel("Apellido:"));
    panel.add(campoApellido);
    panel.add(new JLabel("Dirección:"));
    panel.add(campoDireccion);
    panel.add(new JLabel("Contraseña:"));
    panel.add(campoPass);
    panel.add(new JLabel("Fecha de Nacimiento (yyyy-MM-dd):"));
    panel.add(campoFechaNac);
    panel.add(new JLabel("Tipo de Usuario:"));
    panel.add(comboTipo);

    int result = JOptionPane.showConfirmDialog(this, panel,
            existente == null ? "Crear Usuario" : "Modificar Usuario",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    if (result != JOptionPane.OK_OPTION) return null;

    try {
        int dni = Integer.parseInt(campoDni.getText().trim());
        String nombre = campoNombre.getText().trim();
        String apellido = campoApellido.getText().trim();
        String direccion = campoDireccion.getText().trim();
        String pass = campoPass.getText().trim();
        Date fechaNac = new SimpleDateFormat("yyyy-MM-dd").parse(campoFechaNac.getText().trim());
        String tipo = (String) comboTipo.getSelectedItem();

        return switch (tipo) {
            case "Administrador" -> new Administrador(dni, nombre, apellido, direccion, pass, fechaNac);
            case "Veterinario" -> new Veterinario(dni, nombre, apellido, direccion, pass, fechaNac);
            case "Voluntario" -> new Voluntario(dni, nombre, apellido, direccion, pass, fechaNac);
            case "Familia" -> new Familia(dni, nombre, apellido, direccion, pass, fechaNac);
            default -> throw new IllegalArgumentException("Tipo no válido");
        };
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Datos inválidos: " + ex.getMessage());
        return null;
    }
}


   private void eliminarUsuarioSeleccionado() {
    int fila = tabla_lista_usuarios.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccioná un usuario primero.");
        return;
    }
    try {
        int dni = (int) modeloUsuarios.getValueAt(fila, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar usuario " + dni + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            controlador.eliminarUsuario(dni); 
            JOptionPane.showMessageDialog(this, "Usuario eliminado.");
            listarUsuarios();
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al eliminar: " + ex.getMessage());
      
    }
}
    
    
    
private void crearUsuario() {
    Usuario nuevo = mostrarFormularioUsuario(null);
    if (nuevo == null) return;

    try {
       
        Usuario existente = controlador.obtenerUsuarioConDNI(nuevo.getDni());
        if (existente != null) {
            JOptionPane.showMessageDialog(this,
                "Ya existe un usuario con el DNI " + nuevo.getDni() + ".",
                "Error de creación",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

       
        controlador.crearUsuario(nuevo);
        JOptionPane.showMessageDialog(this, "Usuario creado exitosamente.");
        listarUsuarios();

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,
            "Error al crear usuario: " + ex.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
        ;
    }
}


  private void listarUsuarios() {
    try {
        modeloUsuarios.setRowCount(0); 
        List<Usuario> usuarios = controlador.obtenerUsuarios(); 
        if (usuarios != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 

            for (Usuario u : usuarios) {
                String tipo = u.getClass().getSimpleName();
                String fechaFormateada = (u.getFechNac() != null) ? sdf.format(u.getFechNac()) : "";

                modeloUsuarios.addRow(new Object[]{
                    u.getDni(),
                    u.getNombre(),
                    u.getApellido(),
                    fechaFormateada,
                    tipo,
                    u.getPass()
                });
            }
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al listar usuarios: " + ex.getMessage());
       
    }
}
    
  
private void modificarUsuarioSeleccionado() {
    int fila = tabla_lista_usuarios.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccioná un usuario primero.");
        return;
    }

    try {
        int dniOriginal = (int) modeloUsuarios.getValueAt(fila, 0);
        Usuario usuarioOriginal = controlador.obtenerUsuarioConDNI(dniOriginal);

        if (usuarioOriginal == null) {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado.");
            return;
        }

      
        Usuario nuevoUsuario = mostrarFormularioUsuario(usuarioOriginal);
        if (nuevoUsuario == null) {
            JOptionPane.showMessageDialog(this, "Modificación cancelada.");
            return;
        }

       
        controlador.eliminarUsuario(usuarioOriginal.getDni());

        
        controlador.crearUsuario(nuevoUsuario);

        JOptionPane.showMessageDialog(this, "Usuario modificado correctamente (se recreó el registro).");
        listarUsuarios();

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al modificar usuario: " + ex.getMessage());
    }
}

    
 private void inicializarBoxContenedoresGatos() {
    try {
        
        
        G_estadoSalud.removeAllItems();
   
      for (Gato.EstadoSalud estado : Gato.EstadoSalud.values()) {
        G_estadoSalud.addItem(estado);
   
      }
        
        
        
        jComboBox1_zonas.removeAllItems();
        
        List<ZonasAvistamientos> zonas = controlador.obtenerZonas();
        
        for (ZonasAvistamientos z : zonas) {
            jComboBox1_zonas.addItem(z);
        }

        
        
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Error al cargar zonas: " + e.getMessage(), 
            "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}

    
    
  private void listarZonas() {
    try {
        modeloZonas.setRowCount(0);
        List<ZonasAvistamientos> zonas = controlador.obtenerZonas(); 
        if (zonas != null) {
            

            for (ZonasAvistamientos u : zonas) {
                String tipo = u.getClass().getSimpleName();
              

                modeloZonas.addRow(new Object[]{
                    u.getIdAvistamiento(),
                    u.getNombreZona(),
                    
                });
            }
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al listar usuarios: " + ex.getMessage());
        ex.printStackTrace();
    }
}
    
 private ZonasAvistamientos mostrarFormularioZona(ZonasAvistamientos existente) {
    JTextField campoNombre = new JTextField(existente != null ? existente.getNombreZona() : "");

    JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
    panel.add(new JLabel("Nombre de la Zona:"));
    panel.add(campoNombre);

    int result = JOptionPane.showConfirmDialog(this, panel,
            existente == null ? "Crear Zona" : "Modificar Zona",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    if (result != JOptionPane.OK_OPTION) return null;

    String nombreZona = campoNombre.getText().trim();
    if (nombreZona.isEmpty()) {
        JOptionPane.showMessageDialog(this, "El nombre de la zona no puede estar vacío.");
        return null;
    }

    if (existente == null) {
        return new ZonasAvistamientos(nombreZona);
    } else {
        existente.setNombreZona(nombreZona);
        return existente;
    }
}
 
private void crearZona() {
    ZonasAvistamientos nueva = mostrarFormularioZona(null);
    if (nueva == null) return;

    try {
      
        List<ZonasAvistamientos> existentes = controlador.obtenerZonas();
        boolean duplicada = existentes.stream()
                .anyMatch(z -> z.getNombreZona().equalsIgnoreCase(nueva.getNombreZona()));

        if (duplicada) {
            JOptionPane.showMessageDialog(this,
                    "Ya existe una zona con el nombre \"" + nueva.getNombreZona() + "\".",
                    "Error de creación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        controlador.crearZona(nueva);
        JOptionPane.showMessageDialog(this, "Zona creada exitosamente.");
        listarZonas(); 

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al crear zona: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}
   
 private void modificarZonaSeleccionada() {
    int fila = tabla_lista_zona.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccioná una zona primero.");
        return;
    }

    try {
        int idZona = (int) modeloZonas.getValueAt(fila, 0);
        String nombreActual = (String) modeloZonas.getValueAt(fila, 1);

        ZonasAvistamientos zona = new ZonasAvistamientos(nombreActual);
        zona.setIdAvistamiento(idZona);

        ZonasAvistamientos modificada = mostrarFormularioZona(zona);
        if (modificada == null) return;

        controlador.modificarZona(modificada);
        JOptionPane.showMessageDialog(this, "Zona modificada correctamente.");
        listarZonas();

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al modificar zona: " + ex.getMessage());
        ex.printStackTrace();
    }
}
  
private void eliminarZonaSeleccionada() {
    int fila = tabla_lista_zona.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccioná una zona primero.");
        return;
    }

    try {
        int idZona = (int) modeloZonas.getValueAt(fila, 0);
        String nombre = (String) modeloZonas.getValueAt(fila, 1);

        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Eliminar la zona \"" + nombre + "\"?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            controlador.eliminarZona(idZona);
            JOptionPane.showMessageDialog(this, "Zona eliminada correctamente.");
            listarZonas();
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al eliminar zona: " + ex.getMessage());
        ex.printStackTrace();
    }
}
 

   private void ocultarPestañas(JTabbedPane tab) {
        tab.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
            @Override
            protected int calculateTabAreaHeight(int tabPlacement, int runCount, int maxTabHeight) {
                return 0;
            }

            @Override
            protected void installListeners() {
               
            }
        });
   }


private void listarGatos() {
    try {
         modeloGatos.setRowCount(0);

        List<Gato> gatos = controlador.listaGatosAptos();

        for (Gato g : gatos) {
            modeloGatos.addRow(new Object[]{
                    g.getIdGato(),
                    g.getNombre(),
                    g.getColor(),
                    g.getCaracteristicas(),
                    g.getFoto()
            });
        }


    } catch (Exception e) {
        Dialogo.showMessageDialog(this, "Error al listar gatos: " + e.getMessage());
        e.printStackTrace();
    }
}




private void PostularParaAdopcion() {                                              
    int filaSeleccionada = tab_lista_gatos.getSelectedRow();

    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar un gato de la lista.");
        return;
    }

   
    int idGato = (int) tab_lista_gatos.getValueAt(filaSeleccionada, 0);

    
    Gato gatoSeleccionado = controlador.obtenerGatoPorId(idGato);

    if (gatoSeleccionado == null) {
        JOptionPane.showMessageDialog(this, "No se encontró el gato en la base de datos.");
        return;
    }

    if (usuarioFamiliar == null) {
        JOptionPane.showMessageDialog(this, "Debe iniciar sesión como familia para postular.");
        return;
    }

    
    PostuladoParaAdopcion post = new PostuladoParaAdopcion(
        gatoSeleccionado,
        usuarioFamiliar,
        LocalDate.now(),
        false
    );

    controlador.crearPostulacion(post);
    JOptionPane.showMessageDialog(this, "Postulación creada correctamente.");
}




private void listarPostulaciones() {
    try {
         modeloPostulaciones.setRowCount(0);
        List<PostuladoParaAdopcion> postulaciones = controlador.obtenerPostulaciones();

      
        modeloPostulaciones.setRowCount(0);

        
        for (PostuladoParaAdopcion p : postulaciones) {
            modeloPostulaciones.addRow(new Object[]{
                p.getIdPostulacion(),
                p.getGato() != null ? p.getGato().getNombre() : "N/A",
                p.getFamilia() != null ? (p.getFamilia().getNombre() + " " + p.getFamilia().getApellido()) : "N/A",
                p.getFecha() != null ? p.getFecha().toString() : "N/A",
                p.getAceptado() != null && p.getAceptado() ? "Sí" : "No"
            });
        }

    } catch (Exception e) {
        Dialogo.showMessageDialog(this, "Error al listar postulaciones: " + e.getMessage());
        e.printStackTrace();
    }
}

private void aceptarPostulacion() {
    int fila = tabla_lista_postulaciones.getSelectedRow();

    if (fila == -1) {
        Dialogo.showMessageDialog(this, "Seleccione una postulación primero.");
        return;
    }

    try {
        int idPostulacion = (int) modeloPostulaciones.getValueAt(fila, 0);

        PostuladoParaAdopcion postulacion = controlador.obtenerPostulacionPorId(idPostulacion);

        if (postulacion == null) {
            Dialogo.showMessageDialog(this, "No se encontró la postulación seleccionada.");
            return;
        }

     
        postulacion.setAceptado(true);
        controlador.editarPostulacion(postulacion);

        
        Gato gato = postulacion.getGato();
        gato.setEstado_adopcion(Gato.EstadoAdopcion.ADOPTADO);
        controlador.editarGato(gato);

        Dialogo.showMessageDialog(this, "Postulación aceptada y gato marcado como adoptado.");

        listarPostulaciones();
        listarGatos();

    } catch (Exception e) {
        Dialogo.showMessageDialog(this, "Error al aceptar postulación: " + e.getMessage());
        e.printStackTrace();
    }
}


private void cargarTablaGatosHistorial() {
    try {
        List<Gato> gatos = controlador.obtenerGatos();
        ModeloGatoHistorial.setRowCount(0); 

        for (Gato g : gatos) {
            int idHistorial = (g.getMedHistorial() != null)
                    ? g.getMedHistorial().getIdHistorial()
                    : -1;

            ModeloGatoHistorial.addRow(new Object[]{
                g.getIdGato(),
                g.getNombre(),
                idHistorial
            });
        }

        table_historialmedico.setModel(ModeloGatoHistorial);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar gatos: " + e.getMessage());
        e.printStackTrace();
    }
}





// Métodos auxiliares
private LocalDate obtenerFechaSeleccionada() {
    Date date = (Date) spnFecha.getValue();
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
}

private LocalTime obtenerHoraSeleccionada() {
    Date date = (Date) spnHora.getValue();
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
}


private void mostrarFormularioTarea(String tipoTarea) {
    JDialog dialogo = new JDialog(this, "Registrar " + tipoTarea, true);
    dialogo.setSize(420, 260); 
    dialogo.setLocationRelativeTo(this);
    dialogo.setLayout(new BorderLayout(10, 10));
    dialogo.getContentPane().setBackground(new Color(250, 250, 250));


    JPanel panelCampos = new JPanel(new GridBagLayout());
    panelCampos.setOpaque(false);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(8, 8, 8, 8);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.weightx = 1;

    JLabel lblUbicacion = new JLabel("Ubicación:");
    JTextField txtUbicacion = new JTextField(20);

    gbc.gridx = 0; gbc.gridy = 0;
    panelCampos.add(lblUbicacion, gbc);
    gbc.gridx = 1;
    panelCampos.add(txtUbicacion, gbc);

    JTextField txtExtra1 = null;
    JTextField txtExtra2 = null;

    switch (tipoTarea) {
        case "CapturaCastracion":
        case "ControlVeterinario":
      
        case "VisitaSeguimiento":
            gbc.gridy++;
            JLabel lblGato = new JLabel("ID Gato:");
            txtExtra1 = new JTextField(10);
            gbc.gridx = 0;
            panelCampos.add(lblGato, gbc);
            gbc.gridx = 1;
            panelCampos.add(txtExtra1, gbc);
            break;
        case "AsignarGatoFamilia":
            gbc.gridy++;
            JLabel lblPostulacion = new JLabel("ID Postulación:");
            txtExtra1 = new JTextField(10);
            gbc.gridx = 0;
            panelCampos.add(lblPostulacion, gbc);
            gbc.gridx = 1;
            panelCampos.add(txtExtra1, gbc);
            break;
       case "TrasporteHogar":
          gbc.gridy++;
            JLabel lblHogar = new JLabel("ID Hogar:");
            txtExtra2 = new JTextField(10);
            gbc.gridx = 0;
            panelCampos.add(lblHogar, gbc);
            gbc.gridx = 1;
            panelCampos.add(txtExtra2, gbc);
            break;
       
    }
   
    JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
    JButton btnCancelar = new JButton("Cancelar");
    JButton btnAceptar = new JButton("Aceptar");

    btnCancelar.setPreferredSize(new Dimension(120, 35));
    btnAceptar.setPreferredSize(new Dimension(120, 35));

    panelBotones.add(btnCancelar);
    panelBotones.add(btnAceptar);
    panelBotones.setOpaque(false);


    dialogo.add(panelCampos, BorderLayout.CENTER);
    dialogo.add(panelBotones, BorderLayout.SOUTH);

    
    btnCancelar.addActionListener(e -> dialogo.dispose());

    
    btnAceptar.addActionListener(e -> {
        try {
            String ubicacion = txtUbicacion.getText().trim();
            if (ubicacion.isEmpty()) {
                JOptionPane.showMessageDialog(dialogo, "Ingrese la ubicación.");
                return;
            }

            LocalDate fecha = LocalDate.now();
            LocalTime hora = LocalTime.now();

            switch (tipoTarea) {
                case "Alimentacion" -> controlador.crearTarea(new Alimentacion(usuarioVoluntario, fecha, hora, ubicacion));
                case "CapturaCastracion" -> controlador.crearTarea(new CapturaCastracion(usuarioVoluntario, fecha, hora, ubicacion));
                case "AsignarGatoFamilia" -> controlador.crearTarea(new AsignarGatoFamilia(usuarioVoluntario, fecha, hora, ubicacion));
                case "TransporteHogar" -> controlador.crearTarea(new TrasporteHogar(usuarioVoluntario, fecha, hora, ubicacion));
                case "VisitaSeguimiento" -> controlador.crearTarea(new VisitaSeguimiento(usuarioVoluntario, fecha, hora, ubicacion));
                case "ControlVeterinario" -> controlador.crearTarea(new ControlVeterinario(usuarioVoluntario, fecha, hora, ubicacion));
            }

            JOptionPane.showMessageDialog(dialogo, "Tarea registrada correctamente.");
            dialogo.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(dialogo, "Error al registrar tarea: " + ex.getMessage());
            ex.printStackTrace();
        }
    });

    dialogo.setVisible(true);
}






//eventos para tareas
private void configurarEventos() {
    btnAlimentacion.addActionListener(e -> mostrarFormularioTarea("Alimentacion"));
    btnCaptura.addActionListener(e -> mostrarFormularioTarea("CapturaCastracion"));
    btnAsignarFamiliar.addActionListener(e -> mostrarFormularioTarea("AsignarGatoFamilia"));
    btnTransporte.addActionListener(e -> mostrarFormularioTarea("TransporteHogar"));
    btnVisita.addActionListener(e -> mostrarFormularioTarea("VisitaSeguimiento"));
    btnVolverTareas.addActionListener(e -> mostrarFormularioTarea("ControlVeterinario"));
}


private void mostrarFormularioHogar() {

    JDialog dialog = new JDialog(this, "Registrar Hogar", true);
    dialog.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.fill = GridBagConstraints.HORIZONTAL;

  
    gbc.gridx = 0;
    gbc.gridy = 0;
    dialog.add(new JLabel("Tipo de Hogar:"), gbc);

   
    gbc.gridx = 1;
    String[] tipos = {"Hogar de Tránsito", "Hogar de Adopción"};
    JComboBox<String> comboTipo = new JComboBox<>(tipos);
    dialog.add(comboTipo, gbc);

   
    gbc.gridx = 0;
    gbc.gridy = 1;
    dialog.add(new JLabel("Dirección:"), gbc);

  
    gbc.gridx = 1;
    JTextField txtDireccion = new JTextField(15);
    dialog.add(txtDireccion, gbc);

 
    JPanel panelBotones = new JPanel();
    JButton btnAceptar = new JButton("Aceptar");
    JButton btnCancelar = new JButton("Cancelar");
    panelBotones.add(btnCancelar);
    panelBotones.add(btnAceptar);

    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 2;
    dialog.add(panelBotones, gbc);

   
    btnCancelar.addActionListener(e -> dialog.dispose());

    
    btnAceptar.addActionListener(e -> {
        try {
            String direccion = txtDireccion.getText().trim();
            String tipoSeleccionado = (String) comboTipo.getSelectedItem();

            if (direccion.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Debe ingresar una dirección.");
                return;
            }

          
            Hogares nuevoHogar;
            if (tipoSeleccionado.equals("Hogar de Tránsito")) {
                nuevoHogar = new HogarTransito(direccion);
            } else {
                nuevoHogar = new HogarAdopcion(direccion);
            }

            controlador.crearHogar(nuevoHogar);
            JOptionPane.showMessageDialog(dialog, "Hogar registrado correctamente.");
            dialog.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(dialog, "Error al registrar hogar: " + ex.getMessage());
            ex.printStackTrace();
        }
    });

    dialog.pack();
    dialog.setLocationRelativeTo(this);
    dialog.setVisible(true);
}


private HistorialMedico obtenerHistorialSeleccionado() {
    int fila = table_historialmedico.getSelectedRow();

    if (fila != -1) {
        int idHistorial = (int) ModeloGatoHistorial.getValueAt(fila, 2);

        if (idHistorial != -1) {
            return controlador.findHistorialMedico(idHistorial);
        } else {
            JOptionPane.showMessageDialog(this, "El gato no tiene historial médico asignado.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccioná un gato primero.");
    }
    return null;
}

private void mostrarHistorial(HistorialMedico historial) {
    if (historial == null) return;

    StringBuilder sb = new StringBuilder();

    sb.append(" Estudios:\n");
    for (Estudios e : historial.getEstudios()) {
        sb.append(" - ").append(e.getFecha()).append(": ").append(e.getDescripcion()).append("\n");
    }

    sb.append("\n Diagnósticos:\n");
    for (Diagnosticos d : historial.getDiagnosticos()) {
        sb.append(" - ").append(d.getDescripcion()).append("\n");
    }

    JOptionPane.showMessageDialog(this,
        sb.toString(),
        "Historial Médico ID " + historial.getIdHistorial(),
        JOptionPane.INFORMATION_MESSAGE);
}







    
    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Iniciar_sesion;
    private javax.swing.JButton BT_registrarse;
    private javax.swing.JOptionPane Dialogo;
    private javax.swing.JTextField G_caracteristica;
    private javax.swing.JTextField G_color;
    private javax.swing.JComboBox<Gato.EstadoSalud> G_estadoSalud;
    private javax.swing.JTextField G_foto;
    private javax.swing.JTextField G_nombre;
    private javax.swing.JPanel GestionAdministrador;
    private javax.swing.JPanel GestionGatoTab1;
    private javax.swing.JPanel GestionVeterinario;
    private javax.swing.JPanel GestionVoluntarios;
    private javax.swing.JPanel Panel_inicio_sesion;
    private javax.swing.JPanel Panel_inicio_sesion1;
    private javax.swing.JPanel PrincipalLog;
    private javax.swing.JPanel RegistrarGato;
    private javax.swing.JPanel RegistrarTarea;
    private javax.swing.JTextField TF_DNI_Log;
    private javax.swing.JTextField TF_PASS_Log;
    private javax.swing.JTextField TF_registro_apellido;
    private javax.swing.JTextField TF_registro_direccion;
    private javax.swing.JTextField TF_registro_dni;
    private javax.swing.JTextField TF_registro_fechanac;
    private javax.swing.JTextField TF_registro_nombre;
    private javax.swing.JTextField TF_registro_pass;
    private javax.swing.JTabbedPane Tab_Principal;
    private javax.swing.JTabbedPane Tab_inicio_registrar;
    private javax.swing.JPanel VoluntarioGestionAdopcion;
    private javax.swing.JButton btConfirmaRegistro1;
    private javax.swing.JButton bt_EliminarUusario;
    private javax.swing.JButton bt_EliminarZona;
    private javax.swing.JButton bt_Listar;
    private javax.swing.JButton bt_ListarGatos;
    private javax.swing.JButton bt_ListarGatos1;
    private javax.swing.JButton bt_ListarZona;
    private javax.swing.JButton bt_MOdificarUsuario;
    private javax.swing.JButton bt_RegistrarGato;
    private javax.swing.JButton bt_RegistrarHogar;
    private javax.swing.JButton bt_RegistrarTarea;
    private javax.swing.JButton bt_RegistrarTarea1;
    private javax.swing.JButton bt_ReporteXZona;
    private javax.swing.JButton bt_VolverRegistroGato;
    private javax.swing.JButton bt_adoptadosreporte;
    private javax.swing.JButton bt_confirmarRegistroGato;
    private javax.swing.JButton bt_crearUsuarioGU;
    private javax.swing.JButton bt_crearZona;
    private javax.swing.JButton bt_modificarZona;
    private javax.swing.JButton bt_postularseParaAdoptarlo;
    private javax.swing.JButton bt_postularseParaAdoptarlo1;
    private javax.swing.JButton bt_reportesEsterelizados;
    private javax.swing.JButton bt_volerAlINicio;
    private javax.swing.JButton bt_volverFamilia;
    private javax.swing.JButton bt_volverFamilia1;
    private javax.swing.JButton bt_volverGestionGatos;
    private javax.swing.JButton bt_volverGestionUsuarios;
    private javax.swing.JButton bt_volverReportes;
    private javax.swing.JButton bt_volverZonas;
    private javax.swing.JButton btcancelarRegistro;
    private javax.swing.JButton btnAlimentacion;
    private javax.swing.JButton btnAsignarFamiliar;
    private javax.swing.JButton btnCaptura;
    private javax.swing.JButton btnControlVeterinario1;
    private javax.swing.JButton btnTransporte;
    private javax.swing.JButton btnVisita;
    private javax.swing.JButton btnVolverTareas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<ZonasAvistamientos> jComboBox1_zonas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JOptionPane jOptionPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel labelReportes;
    private javax.swing.JLabel labelTituloLOG;
    private javax.swing.JLabel labelTituloLOG1;
    private javax.swing.JLabel labelTituloLOG10;
    private javax.swing.JLabel labelTituloLOG11;
    private javax.swing.JLabel labelTituloLOG12;
    private javax.swing.JLabel labelTituloLOG13;
    private javax.swing.JLabel labelTituloLOG14;
    private javax.swing.JLabel labelTituloLOG15;
    private javax.swing.JLabel labelTituloLOG17;
    private javax.swing.JLabel labelTituloLOG2;
    private javax.swing.JLabel labelTituloLOG3;
    private javax.swing.JLabel labelTituloLOG4;
    private javax.swing.JLabel labelTituloLOG9;
    private javax.swing.JScrollPane scrollistagatros;
    private javax.swing.JTabbedPane tab_administrador;
    private javax.swing.JTabbedPane tab_familiar;
    private javax.swing.JTable tab_lista_gatos;
    private javax.swing.JTabbedPane tab_veterinarios;
    private javax.swing.JTabbedPane tab_voluntarios;
    private javax.swing.JTable tabla_aptitud;
    private javax.swing.JTable tabla_lista_postulaciones;
    private javax.swing.JTable tabla_lista_usuarios;
    private javax.swing.JTable tabla_lista_zona;
    private javax.swing.JTable tabla_reportes;
    private javax.swing.JTable table_historialmedico;
    // End of variables declaration//GEN-END:variables
}
