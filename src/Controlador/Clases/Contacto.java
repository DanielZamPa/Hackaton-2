// 📁 Archivo: Classes/Contacto.java
// 🎯 Esta clase representa UN contacto individual

package Controlador.Clases;

import Controlador.Interfaces.Contactos;

// 🤝 "implements Contactos" = esta clase PROMETE cumplir el contrato de la interfaz
public class Contacto implements Contactos {

    // 🏠 ATRIBUTOS PRIVADOS (las "cajitas" donde guardamos la información)
    private String nombre;
    private String apellido;
    private String telefono;

    // 🏗️ CONSTRUCTOR (el "fabricante" de contactos)
    public Contacto(String nombre, String apellido, String telefono) {

        // ✅ VALIDACIÓN 1: Nombre no puede estar vacío
        if (nombre == null || nombre.trim().isEmpty()) {
            // Usamos el mensaje de error de la interfaz (más profesional)
            throw new IllegalArgumentException(ERROR_NOMBRE_VACIO);
        }

        // ✅ VALIDACIÓN 2: Apellido no puede estar vacío
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_APELLIDO_VACIO);
        }

        // ✅ VALIDACIÓN 3: Teléfono debe tener formato correcto
        if (!esTelefonoValido(telefono)) {
            throw new IllegalArgumentException(ERROR_TELEFONO_INVALIDO);
        }

        // 🎉 Si llegamos aquí, TODO está bien, guardamos los datos
        this.nombre = nombre.trim();
        this.apellido = apellido.trim();
        this.telefono = telefono.trim();
    }

    // 📞 IMPLEMENTACIÓN del método de la interfaz (OBLIGATORIO)
    @Override
    public boolean esTelefonoValido(String telefono) {

        // Verificar que no sea null o vacío
        if (telefono == null || telefono.trim().isEmpty()) {
            return false;
        }

        telefono = telefono.trim();

        // 🔍 Usar las constantes de la interfaz (más mantenible)
        // Crear el patrón dinámicamente usando las constantes
        String patron = "^\\d{" + MIN_LONGITUD_TELEFONO + "," + MAX_LONGITUD_TELEFONO + "}$";
        return telefono.matches(patron);

        // 📝 EXPLICACIÓN DEL PATRÓN:
        // Si MIN=7 y MAX=15, se convierte en: "^\\d{7,15}$"
        // ^ = inicio, \\d = dígito, {7,15} = entre 7 y 15, $ = final
    }

    // 👥 IMPLEMENTACIÓN del método de la interfaz (OBLIGATORIO)
    @Override
    public boolean sonIguales(Object otroContacto) {
        // Reutilizamos nuestro método equals() que ya teníamos
        return this.equals(otroContacto);
    }

    // 📄 IMPLEMENTACIÓN del método de la interfaz (OBLIGATORIO)
    @Override
    public String obtenerInformacion() {
        // Reutilizamos nuestro método toString() que ya teníamos
        return this.toString();
    }

    // ✅ IMPLEMENTACIÓN del método de la interfaz (OBLIGATORIO)
    @Override
    public boolean esValido() {
        // Un contacto es válido si tiene nombre, apellido y teléfono válidos
        return nombre != null && !nombre.trim().isEmpty() &&
                apellido != null && !apellido.trim().isEmpty() &&
                esTelefonoValido(telefono);
    }

    // 👁️ MÉTODOS GETTER (para "ver" la información privada)
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    // 🔧 MÉTODO SETTER para cambiar el teléfono
    public void setTelefono(String nuevoTelefono) {
        if (!esTelefonoValido(nuevoTelefono)) {
            throw new IllegalArgumentException(ERROR_TELEFONO_INVALIDO);
        }
        this.telefono = nuevoTelefono.trim();
    }

    // ⚖️ MÉTODO EQUALS (para comparar contactos)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Contacto otroContacto = (Contacto) obj;

        // Comparar nombre y apellido sin importar mayúsculas/minúsculas
        return this.nombre.equalsIgnoreCase(otroContacto.nombre) &&
                this.apellido.equalsIgnoreCase(otroContacto.apellido);
    }

    // 🏷️ MÉTODO HASHCODE (necesario con equals)
    @Override
    public int hashCode() {
        return (nombre.toLowerCase() + apellido.toLowerCase()).hashCode();
    }

    // 📄 MÉTODO TOSTRING (para mostrar el contacto bonito)
    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + telefono;
    }
}
