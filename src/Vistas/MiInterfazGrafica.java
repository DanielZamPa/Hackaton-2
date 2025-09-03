package Vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiInterfazGrafica extends JFrame {

    // Paneles globales
    private JPanel genAgregar, panelConfirmar, panelListar;
    private JTable tablaContactos;

    // Datos de ejemplo para la tabla
    private String[][] contactos = {
            {"Juan", "Pérez", "3001234567"},
            {"María", "Gómez", "3012345678"},
            {"Pedro", "López", "3023456789"},
            {"Ana", "Martínez", "3034567890"},
            {"Luis", "Sánchez", "3045678901"},
            {"Carla", "Díaz", "3056789012"},
            {"José", "Ramírez", "3067890123"},
            {"Lucía", "Fernández", "3078901234"},
            {"Miguel", "Castro", "3089012345"},
            {"Sofía", "Moreno", "3090123456"}
    };

    public MiInterfazGrafica() {
        // Configuración de ventana
        setTitle("Mi Primera Interfaz Gráfica");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel app = new JPanel();
        app.setBounds(0, 0, 400, 400);
        app.setBackground(new Color(51, 51, 51));
        app.setLayout(null);

        // Header
        JPanel header = new JPanel();
        header.setBounds(20, 10, 320, 50);
        header.setOpaque(false);
        header.setLayout(null);

        JLabel titulo = new JLabel("Contacto App");
        titulo.setBounds(5, 5, 400, 20);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        header.add(titulo);

        JLabel subtitulo = new JLabel("Creado por Papitas Inc");
        subtitulo.setBounds(5, 30, 400, 12);
        subtitulo.setForeground(Color.GRAY);
        subtitulo.setFont(new Font("Arial", Font.BOLD, 12));
        header.add(subtitulo);

        // Panel contenedor
        JPanel genContenido = new JPanel();
        genContenido.setBounds(20, 70, 340, 250);
        genContenido.setBackground(new Color(255, 255, 255));
        genContenido.setLayout(null);

        // Lista desplegable
        String[] opciones = {"¿Qué deseas hacer?", "Agregar Contacto", "Confirmar Contacto", "Listar Contactos", "Buscar Contactos"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setBounds(10, 10, 320, 30);
        genContenido.add(comboBox);

        // Crear paneles
        crearPanelAgregar();
        crearPanelConfirmar();
        crearPanelListar();

        // Agregar paneles al contenedor
        genContenido.add(genAgregar);
        genContenido.add(panelConfirmar);
        genContenido.add(panelListar);

        // Evento del comboBox
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanel((String) comboBox.getSelectedItem());
            }
        });

        // Agregar a la ventana
        app.add(header);
        app.add(genContenido);
        add(app);
    }

    // ==============================
    // PANEL 1 - AGREGAR CONTACTO
    // ==============================
    private void crearPanelAgregar() {
        genAgregar = new JPanel();
        genAgregar.setBounds(10, 50, 320, 200);
        genAgregar.setLayout(null);
        genAgregar.setBackground(new Color(240, 248, 255));
        genAgregar.setVisible(false);

        JLabel lblTitulo = new JLabel("Añadir Contacto");
        lblTitulo.setBounds(10, 10, 200, 20);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        genAgregar.add(lblTitulo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 40, 80, 20);
        genAgregar.add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(100, 40, 180, 25);
        genAgregar.add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(10, 75, 80, 20);
        genAgregar.add(lblApellido);

        JTextField txtApellido = new JTextField();
        txtApellido.setBounds(100, 75, 180, 25);
        genAgregar.add(txtApellido);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(10, 110, 80, 20);
        genAgregar.add(lblTelefono);

        JTextField txtTelefono = new JTextField();
        txtTelefono.setBounds(100, 110, 180, 25);
        genAgregar.add(txtTelefono);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(100, 150, 100, 30);
        genAgregar.add(btnAgregar);

        JLabel lblMensaje = new JLabel("");
        lblMensaje.setBounds(10, 180, 300, 20);
        lblMensaje.setForeground(Color.GREEN);
        genAgregar.add(lblMensaje);

        btnAgregar.addActionListener(e -> {
            if (txtNombre.getText().trim().isEmpty() || txtApellido.getText().trim().isEmpty() || txtTelefono.getText().trim().isEmpty()) {
                lblMensaje.setText("⚠ Por favor, completa todos los campos.");
                lblMensaje.setForeground(Color.RED);
            } else {
                lblMensaje.setText("Contacto agregado exitosamente.");
                lblMensaje.setForeground(new Color(0, 128, 0));
                txtNombre.setText("");
                txtApellido.setText("");
                txtTelefono.setText("");
            }
        });
    }

    // ==============================
    // PANEL 2 - CONFIRMAR CONTACTO
    // ==============================
    private void crearPanelConfirmar() {
        panelConfirmar = new JPanel();
        panelConfirmar.setBounds(10, 50, 320, 200);
        panelConfirmar.setBackground(Color.GREEN);
        panelConfirmar.add(new JLabel("Aquí podrías confirmar un contacto"));
        panelConfirmar.setVisible(false);
    }

    // ==============================
    // PANEL 3 - LISTAR CONTACTOS
    // ==============================
    private void crearPanelListar() {
        panelListar = new JPanel();
        panelListar.setBounds(10, 50, 320, 200);
        panelListar.setLayout(new BorderLayout());
        panelListar.setVisible(false);

        // Modelo de tabla
        String[] columnas = {"ID", "Nombre", "Apellido", "Teléfono"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Cargar datos desde el array
        for (int i = 0; i < contactos.length; i++) {
            Object[] fila = {i + 1, contactos[i][0], contactos[i][1], contactos[i][2]};
            modelo.addRow(fila);
        }

        tablaContactos = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tablaContactos);
        panelListar.add(scroll, BorderLayout.CENTER);
    }

    // ==============================
    // MOSTRAR PANEL SEGÚN SELECCIÓN
    // ==============================
    private void mostrarPanel(String seleccion) {
        genAgregar.setVisible(false);
        panelConfirmar.setVisible(false);
        panelListar.setVisible(false);

        switch (seleccion) {
            case "Agregar Contacto":
                genAgregar.setVisible(true);
                break;
            case "Confirmar Contacto":
                panelConfirmar.setVisible(true);
                break;
            case "Listar Contactos":
                panelListar.setVisible(true);
                break;
        }
    }

    public static void main(String[] args) {
        MiInterfazGrafica ventana = new MiInterfazGrafica();
        ventana.setVisible(true);
    }
}
