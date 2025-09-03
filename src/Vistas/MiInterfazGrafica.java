package Vistas;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiInterfazGrafica extends JFrame {
    public MiInterfazGrafica() {
        // Configuración de la ventana
        setTitle("Mi Primera Interfaz Gráfica");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Diseño absoluto

        // Crear un botón
        JButton boton = new JButton("Haz clic aquí");
        boton.setBounds(130, 100, 150, 30); // Posición y tamaño

        // Agregar acción al botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "¡Hola, mundo!");
            }
        });

        // Agregar el botón a la ventana
        add(boton);
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        MiInterfazGrafica ventana = new MiInterfazGrafica();
        ventana.setVisible(true);
    }
}

