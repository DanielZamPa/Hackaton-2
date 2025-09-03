// 📁 Archivo: Interfaces/Contactos.java
// 🎯 Esta interfaz define las "reglas del juego" para todo el proyecto

package Controlador.Interfaces;

public interface Contactos {

    // 🔢 CONSTANTES DEL PROYECTO (valores que NUNCA cambian)
    // public static final = son valores fijos para todo el proyecto
    // Es como tener las "reglas oficiales" escritas en piedra

    // Configuraciones para teléfonos
    int MIN_LONGITUD_TELEFONO = 7;   // Mínimo 7 dígitos (ej: 1234567)
    int MAX_LONGITUD_TELEFONO = 15;  // Máximo 15 dígitos (números internacionales)

    // Configuración para la agenda (para tus compañeros)
    int TAMAÑO_AGENDA_DEFAULT = 10;  // Si no especifican tamaño, serán 10 contactos

    // 📝 MENSAJES DE ERROR ESTÁNDAR (para que todo el equipo use los mismos)
    // Esto hace que el programa se vea más profesional y consistente
    String ERROR_NOMBRE_VACIO = "❌ Error: El nombre no puede estar vacío";
    String ERROR_APELLIDO_VACIO = "❌ Error: El apellido no puede estar vacío";
    String ERROR_TELEFONO_INVALIDO = "❌ Error: El teléfono debe tener entre " +
            MIN_LONGITUD_TELEFONO + " y " +
            MAX_LONGITUD_TELEFONO + " números";
    String ERROR_CONTACTO_DUPLICADO = "❌ Error: Ya existe un contacto con ese nombre y apellido";
    String ERROR_AGENDA_LLENA = "❌ Error: La agenda está llena, no se puede agregar más contactos";

    // 🎨 MENSAJES DE ÉXITO (para hacer el programa más amigable)
    String EXITO_CONTACTO_AGREGADO = "✅ Contacto agregado exitosamente";
    String EXITO_CONTACTO_ELIMINADO = "✅ Contacto eliminado exitosamente";
    String EXITO_TELEFONO_MODIFICADO = "✅ Teléfono modificado exitosamente";

    // 📋 MÉTODOS QUE DEBE IMPLEMENTAR CUALQUIER CLASE DE CONTACTO
    // (Como un "contrato" que dice qué debe poder hacer un contacto)

    /**
     * 📞 Valida si un teléfono tiene el formato correcto
     * @param telefono el número a validar
     * @return true si es válido, false si no lo es
     */
    boolean esTelefonoValido(String telefono);

    /**
     * 👥 Compara si este contacto es igual a otro
     * @param otroContacto el contacto con el que comparar
     * @return true si son iguales (mismo nombre y apellido), false si no
     */
    boolean sonIguales(Object otroContacto);

    /**
     * 📄 Devuelve la información del contacto en formato texto
     * @return String con la información del contacto
     */
    String obtenerInformacion();

    /**
     * ✅ Verifica si los datos básicos del contacto son válidos
     * @return true si nombre, apellido y teléfono son válidos
     */
    boolean esValido();
}

// 📚 EXPLICACIÓN PARA EL EQUIPO:
// 
// Esta interfaz es como el "manual de instrucciones" del proyecto.
// 
// 🎯 BENEFICIOS:
// 1. Todo el equipo usa los mismos mensajes de error
// 2. Si quieren cambiar la longitud del teléfono, solo cambian AQUÍ
// 3. Hace el código más profesional y organizado
// 4. Los jueces del hackathon van a ver que saben trabajar en equipo
//
// 🤝 CÓMO USARLA:
// - En clase Contacto: implements Contactos
// - Para usar constantes: Contactos.MIN_LONGITUD_TELEFONO
// - Para usar mensajes: Contactos.ERROR_NOMBRE_VACIO