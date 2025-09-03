package Controlador.Clases;

import Controlador.Interfaces.Contactos;

public class Contacto implements Contactos {

    // 🏠 ATRIBUTOS PRIVADOS
    private String nombre;
    private String apellido;
    private String telefono;

    // 🏗️ CONSTRUCTOR
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

    // 📞 IMPLEMENTACIÓN del método de la interfaz
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

    // 📄 MÉTODO TOSTRING (para mostrar el contacto bonito)
    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + telefono;
    }

    // ⚖️ MÉTODO EQUALS (para comparar si dos contactos son "iguales")
    // Dos contactos son iguales si tienen el mismo nombre y apellido (ignorando mayúsculas).
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacto contacto = (Contacto) o;
        return nombre.equalsIgnoreCase(contacto.nombre) &&
               apellido.equalsIgnoreCase(contacto.apellido);
    }

    // #️⃣ MÉTODO HASHCODE (requerido si se sobrescribe equals)
    // Genera un código numérico basado en el nombre y apellido.
    @Override
    public int hashCode() {
        // Usamos una clase de ayuda para generar un hash a partir de varios campos.
        return java.util.Objects.hash(nombre.toLowerCase(), apellido.toLowerCase());
    }
}
