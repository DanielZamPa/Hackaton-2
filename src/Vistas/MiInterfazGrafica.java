package Vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class MiInterfazGrafica extends JFrame {

    // Paneles globales
    private JPanel genAgregar, panelBuscar, panelListar, panelBienvenida;
    private JTable tablaContactos;
    private String[][] contactos = {
            {"Juan", "Pérez", "3001234567"},
            {"Juan", "Gómez", "3012345678"},
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
        // Configuración ventana
        setTitle("Contactos: Papitas Inc");
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
        subtitulo.setFont(new Font("Arial", Font.BOLD, 10));
        header.add(subtitulo);

        // Panel contenedor principal
        JPanel genContenido = new JPanel();
        genContenido.setBounds(20, 70, 340, 275);
        genContenido.setBackground(new Color(255, 255, 255));
        genContenido.setLayout(null);

        // Lista desplegable
        String[] opciones = {"¿Qué deseas hacer?", "Agregar Contacto", "Buscar Contactos", "Listar Contactos"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setBounds(10, 10, 320, 30);
        genContenido.add(comboBox);

        // Crear paneles
        crearPanelBienvenida();
        crearPanelAgregar();
        crearPanelBuscar();
        crearPanelListar();

        // Agregar paneles al contenedor
        genContenido.add(panelBienvenida);
        genContenido.add(genAgregar);
        genContenido.add(panelBuscar);
        genContenido.add(panelListar);

        // Evento del comboBox
        comboBox.addActionListener(e -> mostrarPanel((String) comboBox.getSelectedItem()));

        // Agregar componentes a la app
        app.add(header);
        app.add(genContenido);
        add(app);
    }

    // ==============================
    // PANEL BIENVENIDA
    // ==============================
    private void crearPanelBienvenida() {
        panelBienvenida = new JPanel();
        panelBienvenida.setBounds(10, 50, 320, 200);
        panelBienvenida.setLayout(null);
        panelBienvenida.setBackground(new Color(240, 248, 255));
        panelBienvenida.setVisible(true);

        JLabel lblTitulo = new JLabel("Bienvenido a la App de Contactos");
        lblTitulo.setBounds(10, 10, 300, 20);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        panelBienvenida.add(lblTitulo);

        JLabel lblDev = new JLabel("<html>Desarrolladores:<br>• Daniel Zamora<br>• Sergio Gonzalez<br>• Andres Vanegas<br>• David Paez</html>");
        lblDev.setBounds(10, 40, 300, 100);
        lblDev.setFont(new Font("Arial", Font.PLAIN, 12));
        panelBienvenida.add(lblDev);
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
    // PANEL 2 - BUSCAR CONTACTOS
    // ==============================
    private void crearPanelBuscar() {
        panelBuscar = new JPanel();
        panelBuscar.setBounds(10, 50, 320, 250);
        panelBuscar.setLayout(null);
        panelBuscar.setBackground(new Color(240, 248, 255));
        panelBuscar.setVisible(false);

        JLabel lblTitulo = new JLabel("Buscar Contacto");
        lblTitulo.setBounds(10, 10, 200, 20);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        panelBuscar.add(lblTitulo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 40, 80, 20);
        panelBuscar.add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(90, 40, 200, 25);
        panelBuscar.add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(10, 70, 80, 20);
        panelBuscar.add(lblApellido);

        JTextField txtApellido = new JTextField();
        txtApellido.setBounds(90, 70, 200, 25);
        panelBuscar.add(txtApellido);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(10, 100, 80, 20);
        panelBuscar.add(lblTelefono);

        JTextField txtTelefono = new JTextField();
        txtTelefono.setBounds(90, 100, 200, 25);
        panelBuscar.add(txtTelefono);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(100, 130, 120, 30);
        panelBuscar.add(btnBuscar);

        JLabel lblResultado = new JLabel("");
        lblResultado.setBounds(10, 160, 300, 20);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 12));
        panelBuscar.add(lblResultado);

        // Botones para modificar y eliminar
        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBounds(10, 190, 90, 25);
        btnModificar.setVisible(false);
        panelBuscar.add(btnModificar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(110, 190, 90, 25);
        btnEliminar.setVisible(false);
        panelBuscar.add(btnEliminar);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(210, 190, 90, 25);
        btnLimpiar.setVisible(false);
        panelBuscar.add(btnLimpiar);

        // Evento buscar
        btnBuscar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            String telefono = txtTelefono.getText().trim();
            boolean encontrado = false;

            for (String[] contacto : contactos) {
                if ((!nombre.isEmpty() && contacto[0].equalsIgnoreCase(nombre)) ||
                        (!apellido.isEmpty() && contacto[1].equalsIgnoreCase(apellido)) ||
                        (!telefono.isEmpty() && contacto[2].equals(telefono))) {
                    lblResultado.setText("Encontrado: " + contacto[0] + " " + contacto[1] + " - " + contacto[2]);
                    lblResultado.setForeground(Color.GREEN);
                    btnModificar.setVisible(true);
                    btnEliminar.setVisible(true);
                    btnLimpiar.setVisible(true);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                lblResultado.setText("⚠ Contacto no encontrado");
                lblResultado.setForeground(Color.RED);
                btnModificar.setVisible(false);
                btnEliminar.setVisible(false);
                btnLimpiar.setVisible(true);
            }
        });

        // Evento limpiar
        btnLimpiar.addActionListener(e -> {
            txtNombre.setText("");
            txtApellido.setText("");
            txtTelefono.setText("");
            lblResultado.setText("");
            btnModificar.setVisible(false);
            btnEliminar.setVisible(false);
            btnLimpiar.setVisible(false);
        });
    }

    // ==============================
    // PANEL 3 - LISTAR CONTACTOS
    // ==============================
    private void crearPanelListar() {
        panelListar = new JPanel();
        panelListar.setBounds(10, 50, 320, 200);
        panelListar.setLayout(new BorderLayout());
        panelListar.setVisible(false);

        String[] columnas = {"ID", "Nombre", "Apellido", "Teléfono"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (int i = 0; i < contactos.length; i++) {
            Object[] fila = {i + 1, contactos[i][0], contactos[i][1], contactos[i][2]};
            modelo.addRow(fila);
        }

        tablaContactos = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tablaContactos);
        panelListar.add(scroll, BorderLayout.CENTER);
    }

    // ==============================
    // MOSTRAR PANEL
    // ==============================
    private void mostrarPanel(String seleccion) {
        panelBienvenida.setVisible(false);
        genAgregar.setVisible(false);
        panelBuscar.setVisible(false);
        panelListar.setVisible(false);

        switch (seleccion) {
            case "¿Qué deseas hacer?":
                panelBienvenida.setVisible(true);
                break;
            case "Agregar Contacto":
                genAgregar.setVisible(true);
                break;
            case "Buscar Contactos":
                panelBuscar.setVisible(true);
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
