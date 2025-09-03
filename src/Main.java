// 📁 Archivo: Vistas/Main.java
// 🎯 Programa interactivo para probar validaciones de Contacto

// 📦 IMPORTS
import Controlador.Clases.Contacto;
import Controlador.Interfaces.Contactos;
import java.util.Scanner;   // Para leer desde la consola
import java.util.ArrayList; // Para guardar múltiples contactos

public class Main {

    // 🎨 Colores para hacer la consola más bonita (opcional)
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";

    // 📋 Lista para guardar los contactos que creemos
    private static ArrayList<Contacto> contactos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(BLUE + "=".repeat(50));
        System.out.println("🎯 PROBADOR DE VALIDACIONES - CONTACTOS");
        System.out.println("📚 Hackathon Java - Equipo Increíble");
        System.out.println("=".repeat(50) + RESET);

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
                case 5:
                    probarValidaciones();
                    break;
                case 0:
                    continuar = false;
                    System.out.println(GREEN + "🎉 ¡Gracias por probar el sistema!" + RESET);
                    break;
                default:
                    System.out.println(RED + "❌ Opción inválida. Intenta de nuevo." + RESET);
            }

            if (continuar) {
                System.out.println("\n" + YELLOW + "Presiona ENTER para continuar..." + RESET);
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    // 📋 MOSTRAR MENÚ PRINCIPAL
    private static void mostrarMenu() {
        System.out.println("\n" + BLUE + "=== MENÚ PRINCIPAL ===" + RESET);
        System.out.println("1️⃣  Crear contacto nuevo");
        System.out.println("2️⃣  Listar contactos creados");
        System.out.println("3️⃣  Comparar dos contactos");
        System.out.println("4️⃣  Modificar teléfono");
        System.out.println("5️⃣  Probar validaciones (casos extremos)");
        System.out.println("0️⃣  Salir");
        System.out.print(YELLOW + "👉 Selecciona una opción: " + RESET);
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
        System.out.println("\n" + BLUE + "=== CREAR CONTACTO NUEVO ===" + RESET);

        System.out.print("📝 Ingresa el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("📝 Ingresa el apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("📞 Ingresa el teléfono (7-15 dígitos): ");
        String telefono = scanner.nextLine();

        try {
            Contacto nuevoContacto = new Contacto(nombre, apellido, telefono);
            contactos.add(nuevoContacto);

            System.out.println(GREEN + "✅ ¡Contacto creado exitosamente!" + RESET);
            System.out.println("👤 " + nuevoContacto.obtenerInformacion());
            System.out.println("✅ ¿Es válido? " + nuevoContacto.esValido());

        } catch (Exception e) {
            System.out.println(RED + e.getMessage() + RESET);
            System.out.println(YELLOW + "💡 Tip: Revisa que el nombre y apellido no estén vacíos, y el teléfono tenga entre 7-15 números." + RESET);
        }
    }

    // 2️⃣ LISTAR CONTACTOS
    private static void listarContactos() {
        System.out.println("\n" + BLUE + "=== CONTACTOS CREADOS ===" + RESET);

        if (contactos.isEmpty()) {
            System.out.println(YELLOW + "📭 No hay contactos creados aún." + RESET);
            return;
        }

        for (int i = 0; i < contactos.size(); i++) {
            System.out.println((i + 1) + ". " + contactos.get(i).obtenerInformacion());
        }
    }

    // 3️⃣ COMPARAR CONTACTOS
    private static void compararContactos() {
        System.out.println("\n" + BLUE + "=== COMPARAR CONTACTOS ===" + RESET);

        if (contactos.size() < 2) {
            System.out.println(YELLOW + "📭 Necesitas al menos 2 contactos para comparar." + RESET);
            return;
        }

        listarContactos();

        System.out.print("👉 Selecciona el primer contacto (número): ");
        int indice1 = leerOpcion() - 1;

        System.out.print("👉 Selecciona el segundo contacto (número): ");
        int indice2 = leerOpcion() - 1;

        if (indice1 >= 0 && indice1 < contactos.size() &&
                indice2 >= 0 && indice2 < contactos.size()) {

            Contacto c1 = contactos.get(indice1);
            Contacto c2 = contactos.get(indice2);

            System.out.println("👥 Contacto 1: " + c1.obtenerInformacion());
            System.out.println("👥 Contacto 2: " + c2.obtenerInformacion());

            boolean sonIguales = c1.sonIguales(c2);

            if (sonIguales) {
                System.out.println(GREEN + "✅ Son IGUALES (mismo nombre y apellido)" + RESET);
            } else {
                System.out.println(RED + "❌ Son DIFERENTES" + RESET);
            }

        } else {
            System.out.println(RED + "❌ Índices inválidos." + RESET);
        }
    }

    // 4️⃣ MODIFICAR TELÉFONO
    private static void modificarTelefono() {
        System.out.println("\n" + BLUE + "=== MODIFICAR TELÉFONO ===" + RESET);

        if (contactos.isEmpty()) {
            System.out.println(YELLOW + "📭 No hay contactos para modificar." + RESET);
            return;
        }

        listarContactos();

        System.out.print("👉 Selecciona el contacto a modificar (número): ");
        int indice = leerOpcion() - 1;

        if (indice >= 0 && indice < contactos.size()) {
            Contacto contacto = contactos.get(indice);

            System.out.println("📞 Teléfono actual: " + contacto.getTelefono());
            System.out.print("📞 Nuevo teléfono (7-15 dígitos): ");
            String nuevoTelefono = scanner.nextLine();

            try {
                contacto.setTelefono(nuevoTelefono);
                System.out.println(GREEN + "✅ ¡Teléfono modificado exitosamente!" + RESET);
                System.out.println("👤 " + contacto.obtenerInformacion());
            } catch (Exception e) {
                System.out.println(RED + e.getMessage() + RESET);
            }

        } else {
            System.out.println(RED + "❌ Índice inválido." + RESET);
        }
    }

    // 5️⃣ PROBAR VALIDACIONES (CASOS EXTREMOS)
    private static void probarValidaciones() {
        System.out.println("\n" + BLUE + "=== PRUEBAS AUTOMÁTICAS DE VALIDACIONES ===" + RESET);

        // Lista de casos de prueba
        String[][] casos = {
                {"Juan", "Pérez", "1234567890", "✅ VÁLIDO"},
                {"", "González", "9876543210", "❌ Nombre vacío"},
                {"María", "", "5555555555", "❌ Apellido vacío"},
                {"Pedro", "López", "123", "❌ Teléfono muy corto"},
                {"Ana", "Martín", "12345678901234567890", "❌ Teléfono muy largo"},
                {"Luis", "Ruiz", "123abc456", "❌ Teléfono con letras"},
                {"   ", "García", "7777777777", "❌ Nombre solo espacios"},
                {"Carlos", "   ", "8888888888", "❌ Apellido solo espacios"},
                {"Sofia", "Herrera", "", "❌ Teléfono vacío"},
                {"MARIA", "lopez", "1111111111", "✅ VÁLIDO (mayúsculas)"}
        };

        for (int i = 0; i < casos.length; i++) {
            System.out.println("\n🧪 Caso " + (i + 1) + ": " + casos[i][3]);
            System.out.println("📋 Datos: '" + casos[i][0] + "', '" + casos[i][1] + "', '" + casos[i][2] + "'");

            try {
                Contacto contacto = new Contacto(casos[i][0], casos[i][1], casos[i][2]);
                System.out.println(GREEN + "✅ Contacto creado: " + contacto.obtenerInformacion() + RESET);
            } catch (Exception e) {
                System.out.println(RED + "❌ " + e.getMessage() + RESET);
            }
        }
    }
}