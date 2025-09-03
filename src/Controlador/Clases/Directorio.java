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
        if (contacto == null || contacto.getNombre().isEmpty() || contacto.getApellido().isEmpty()) {
            System.out.println("Nombre y apellido no pueden estar vacíos.");
            return;
        }

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
