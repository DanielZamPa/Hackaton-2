// 📁 Archivo: Vistas/Main.java
// 🎯 Programa interactivo para probar validaciones de Contacto

// 📦 IMPORTS
import Controlador.Clases.Contacto;
import Controlador.Clases.Directorio;
import java.util.List;
import java.util.Scanner;   // Para leer desde la consola

public class Main {
    // 📋 Lista para guardar los contactos que creemos
    private static Directorio directorio = new Directorio(); // Usamos el constructor por defecto (10 contactos)
    private static Scanner scanner = new Scanner(System.in);

    // 📋 MOSTRAR MENÚ PRINCIPAL
    private static void mostrarMenu() {
        System.out.println("\n" + "=== MENÚ PRINCIPAL ===");
        System.out.println("1️⃣  Crear contacto nuevo");
        System.out.println("2️⃣  Listar contactos creados");
        System.out.println("3️⃣  Comparar dos contactos");
        System.out.println("4️⃣  Modificar teléfono");
        System.out.println("0️⃣  Salir");
        System.out.print("👉 Selecciona una opción: ");
    }
    public static void main(String[] args) {

        System.out.println("=".repeat(50));
        System.out.println("🎯 PROBADOR DE VALIDACIONES - CONTACTOS");
        System.out.println("📚 Hackathon Java - Equipo Increíble");
        System.out.println("=".repeat(50));

        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    crearContactoInteractivo();
                    break;
                case 2:
                    listarContactos();
                    break;
                case 3:
                    compararContactos();
                    break;
                case 4:
                    modificarTelefono();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("🎉 ¡Gracias por probar el sistema!");
                    break;
                default:
                    System.out.println("❌ Opción inválida. Intenta de nuevo.");
            }

            if (continuar) {
                System.out.println("\n" + "Presiona ENTER para continuar...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    // 🔢 LEER OPCIÓN DEL USUARIO
    private static int leerOpcion() {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            return opcion;
        } catch (Exception e) {
            scanner.nextLine(); // Limpiar el scanner
            return -1; // Opción inválida
        }
    }

    // 1️⃣ CREAR CONTACTO INTERACTIVO
    private static void crearContactoInteractivo() {
        System.out.println("\n" + "=== CREAR CONTACTO NUEVO ===");

        System.out.print("📝 Ingresa el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("📝 Ingresa el apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("📞 Ingresa el teléfono (7-15 dígitos): ");
        String telefono = scanner.nextLine();

        try {
            Contacto nuevoContacto = new Contacto(nombre, apellido, telefono);
            // Usamos el método de nuestro objeto Directorio
            directorio.agregarContacto(nuevoContacto);
            // El método agregarContacto ya imprime su propio mensaje de éxito/error.
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("💡 Tip: Revisa que el nombre y apellido no estén vacíos, y el teléfono tenga entre 7-15 números.");
        }
    }

    // 2️⃣ LISTAR CONTACTOS
    private static void listarContactos() {
        System.out.println("\n" + "=== CONTACTOS CREADOS ===");
        List<Contacto> lista = directorio.getContactos(); // Obtenemos la lista desde el directorio

        if (lista.isEmpty()) {
            System.out.println("📭 No hay contactos creados aún.");
            return;
        }

        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i).obtenerInformacion());
        }
    }

    // 3️⃣ COMPARAR CONTACTOS
    private static void compararContactos() {
        System.out.println("\n" + "=== COMPARAR CONTACTOS ===");

        List<Contacto> lista = directorio.getContactos();

        if (lista.size() < 2) {
            System.out.println("📭 Necesitas al menos 2 contactos para comparar.");
            return;
        }

        listarContactos();

        System.out.print("👉 Selecciona el primer contacto (número): ");
        int indice1 = leerOpcion() - 1;

        System.out.print("👉 Selecciona el segundo contacto (número): ");
        int indice2 = leerOpcion() - 1;

        if (indice1 >= 0 && indice1 < lista.size() &&
                indice2 >= 0 && indice2 < lista.size()) {

            Contacto c1 = lista.get(indice1);
            Contacto c2 = lista.get(indice2);

            System.out.println("👥 Contacto 1: " + c1.obtenerInformacion());
            System.out.println("👥 Contacto 2: " + c2.obtenerInformacion());

            // Usamos el método .equals() que definimos en la clase Contacto
            if (c1.equals(c2)) {
                System.out.println("✅ Son IGUALES (mismo nombre y apellido)");
            } else {
                System.out.println("❌ Son DIFERENTES");
            }

        } else {
            System.out.println("❌ Índices inválidos.");
        }
    }

    // 4️⃣ MODIFICAR TELÉFONO
    private static void modificarTelefono() {
        System.out.println("\n" + "=== MODIFICAR TELÉFONO ===");

        List<Contacto> lista = directorio.getContactos();

        if (lista.isEmpty()) {
            System.out.println("📭 No hay contactos para modificar.");
            return;
        }

        listarContactos();

        System.out.print("👉 Selecciona el contacto a modificar (número): ");
        int indice = leerOpcion() - 1;

        if (indice >= 0 && indice < lista.size()) {
            Contacto contacto = lista.get(indice);

            System.out.println("📞 Teléfono actual: " + contacto.getTelefono());
            System.out.print("📞 Nuevo teléfono (7-15 dígitos): ");
            String nuevoTelefono = scanner.nextLine();

            try {
                contacto.setTelefono(nuevoTelefono);
                System.out.println("✅ ¡Teléfono modificado exitosamente!");
                System.out.println("👤 " + contacto.obtenerInformacion());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            System.out.println("❌ Índice inválido.");
        }
    }
}//Cierre de clase main