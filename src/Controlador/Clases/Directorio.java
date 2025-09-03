package Controlador.Clases;


import Controlador.Interfaces.Directorios;
import Controlador.Clases.Contacto;
import java.util.ArrayList;
import java.util.List;

public class Directorio implements Directorios {
    private List<Contacto> contactos;
    private int maxSize;

    // Constructor con tamaño personalizado maxsizedefine el tamaño maximo del directorio, limite de contactos
    public Directorio(int maxSize) {
        this.maxSize = maxSize;
        this.contactos = new ArrayList<>();
    }

    // Constructor por defecto (10 contactos)
    public Directorio() {
        this(10);
    }

    @Override
    public void agregarContacto(Contacto contacto) {
        // La validación de nombre/apellido ya la hace el constructor de Contacto, no es necesaria aquí.
        if (agendaLlena()) {
            System.out.println("La agenda está llena.");
            return;
        }

        if (existeContacto(contacto)) {
            System.out.println("El contacto ya existe.");
            return;
        }

        contactos.add(contacto);
        System.out.println("Contacto agregado correctamente.");


    }

    private boolean agendaLlena() {
        return contactos.size() >= maxSize;
    }

    private boolean existeContacto(Contacto contacto) {
        for (Contacto c : contactos) {
            if (contacto.equals(c)) {
                return true;
            }
        }
        return false;
    }

    // Método para que otras clases puedan ver la lista de contactos
    public List<Contacto> getContactos() {
        return this.contactos;
    }

    @Override
    public void buscarContacto(String nombre, String apellido) {
    }

    @Override
    public boolean editarContacto(String nombre, String apellido, String nuevoTelefono) {
        return false;
    }

    @Override
    public boolean eliminarContacto(String nombre, String apellido) {
        return false;

    }
}
