package Controlador.Interfaces;

import Controlador.Clases.Contacto;

public interface Directorios {
    void agregarContacto(Contacto contacto);
    void buscarContacto(String nombre, String apellido);
    boolean editarContacto(String nombre, String apellido, String nuevoTelefono);
    boolean eliminarContacto(String nombre, String apellido);
}
