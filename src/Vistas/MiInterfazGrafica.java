package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiInterfazGrafica extends JFrame {

    // Paneles globales
    private JPanel genAgregar;
    private JPanel genConfirmar;
    private JPanel genListar;
    private JLabel lblMensajeBuscar;

    public MiInterfazGrafica() {
        // Configuración básica de la ventana
        setTitle("Mi Primera Interfaz Gráfica");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Contenedor principal
        JPanel app = new JPanel();
        app.setBounds(0, 0, 400, 400);
        app.setBackground(new Color(51, 51, 51));
        app.setLayout(null);

        // Panel superior (header)
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

        // Contenedor central donde estarán los paneles
        JPanel genContenido = new JPanel();
        genContenido.setBounds(20, 70, 340, 250);
        genContenido.setBackground(new Color(255, 255, 255));
        genContenido.setLayout(null);

        // Crear lista desplegable
        String[] opciones = {
                "¿Qué deseas hacer?",
                "Agregar Contacto",
                "Confirmar Contacto",
                "Listar Contactos",
                "Buscar Contactos"
        };

        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setBounds(10, 10, 320, 30);
        genContenido.add(comboBox);

        // Crear los paneles usando métodos
        genAgregar = crearPanelAgregar();
        genConfirmar = crearPanelConfirmar();
        genListar = crearPanelListar();

        // Mensaje simple para la opción "Buscar Contactos"
        lblMensajeBuscar = new JLabel("Aquí podrás buscar contactos...");
        lblMensajeBuscar.setBounds(20, 70, 300, 30);
        lblMensajeBuscar.setForeground(Color.BLUE);
        lblMensajeBuscar.setVisible(false);
        genContenido.add(lblMensajeBuscar);

        // Agregar los paneles al contenedor
        genContenido.add(genAgregar);
        genContenido.add(genConfirmar);
        genContenido.add(genListar);

        // Control de visibilidad con el ComboBox
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccion = (String) comboBox.getSelectedItem();
                mostrarPanel(seleccion);
            }
        });

        // Agregar todo a la ventana
        app.add(header);
        app.add(genContenido);
        add(app);
    }

    // ============================
    // MÉTODO: Panel para Agregar Contactos
    // ============================
    private JPanel crearPanelAgregar() {
        JPanel panel = new JPanel();
        panel.setBounds(10, 50, 320, 200);
        panel.setLayout(null);
        panel.setBackground(new Color(240, 248, 255));
        panel.setVisible(false);

        JLabel lblTitulo = new JLabel("Añadir Contacto");
        lblTitulo.setBounds(10, 10, 200, 20);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblTitulo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 40, 80, 20);
        panel.add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(100, 40, 180, 25);
        panel.add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(10, 75, 80, 20);
        panel.add(lblApellido);

        JTextField txtApellido = new JTextField();
        txtApellido.setBounds(100, 75, 180, 25);
        panel.add(txtApellido);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(10, 110, 80, 20);
        panel.add(lblTelefono);

        JTextField txtTelefono = new JTextField();
        txtTelefono.setBounds(100, 110, 180, 25);
        panel.add(txtTelefono);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(100, 150, 100, 30);
        panel.add(btnAgregar);

        JLabel lblMensaje = new JLabel("");
        lblMensaje.setBounds(10, 180, 300, 20);
        lblMensaje.setForeground(Color.GREEN);
        panel.add(lblMensaje);

        btnAgregar.addActionListener(e -> {
            if (txtNombre.getText().trim().isEmpty()
                    || txtApellido.getText().trim().isEmpty()
                    || txtTelefono.getText().trim().isEmpty()) {
                lblMensaje.setText("⚠ Por favor, completa todos los campos.");
                lblMensaje.setForeground(Color.RED);
            } else {
                lblMensaje.setText("✅ Contacto agregado exitosamente.");
                lblMensaje.setForeground(new Color(0, 128, 0));
                txtNombre.setText("");
                txtApellido.setText("");
                txtTelefono.setText("");
            }
        });

        return panel;
    }

    // ============================
    // MÉTODO: Panel para Confirmar Contactos
    // ============================
    private JPanel crearPanelConfirmar() {
        JPanel panel = new JPanel();
        panel.setBounds(10, 50, 320, 200);
        panel.setBackground(new Color(220, 255, 220));
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("Aquí confirmarías los contactos.", SwingConstants.CENTER), BorderLayout.CENTER);
        panel.setVisible(false);
        return panel;
    }

    // ============================
    // MÉTODO: Panel para Listar Contactos
    // ============================
    private JPanel crearPanelListar() {
        JPanel panel = new JPanel();
        panel.setBounds(10, 50, 320, 200);
        panel.setBackground(new Color(220, 220, 255));
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("Aquí se listarían los contactos.", SwingConstants.CENTER), BorderLayout.CENTER);
        panel.setVisible(false);
        return panel;
    }

    // ============================
    // MÉTODO: Mostrar panel correcto
    // ============================
    private void mostrarPanel(String seleccion) {
        // Ocultar todos
        genAgregar.setVisible(false);
        genConfirmar.setVisible(false);
        genListar.setVisible(false);
        lblMensajeBuscar.setVisible(false);

        // Mostrar solo el que corresponde
        switch (seleccion) {
            case "Agregar Contacto":
                genAgregar.setVisible(true);
                break;
            case "Confirmar Contacto":
                genConfirmar.setVisible(true);
                break;
            case "Listar Contactos":
                genListar.setVisible(true);
                break;
            case "Buscar Contactos":
                lblMensajeBuscar.setVisible(true);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        MiInterfazGrafica ventana = new MiInterfazGrafica();
        ventana.setVisible(true);
    }
}
