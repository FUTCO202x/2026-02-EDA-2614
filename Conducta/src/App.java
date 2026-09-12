import java.util.List;
import java.util.Scanner;

import models.Ahorro;
import models.Corriente;
import models.Cuenta;
import models.ServiceCuenta;

public class App {

    private static final ServiceCuenta service = new ServiceCuenta();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            switch (opcion) {
                case 1:
                    listarPorTipo(Ahorro.class, "Ahorro");
                    break;
                case 2:
                    listarPorTipo(Corriente.class, "Corriente");
                    break;
                case 3:
                    crearAhorro();
                    break;
                case 4:
                    crearCorriente();
                    break;
                case 5:
                    buscarCuenta();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n===== MENU CUENTAS =====");
        System.out.println("1. Listar todas las cuentas Ahorro");
        System.out.println("2. Listar todas las cuentas Corriente");
        System.out.println("3. Crear cuenta de Ahorro");
        System.out.println("4. Crear cuenta Corriente");
        System.out.println("5. Obtener informacion de la cuenta por numero");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void listarPorTipo(Class<?> tipo, String nombreTipo) {
        List<Cuenta> cuentas = service.listarCuentas();
        System.out.println("\n--- Cuentas " + nombreTipo + " ---");
        boolean encontrada = false;
        for (Cuenta c : cuentas) {
            if (tipo.isInstance(c)) {
                System.out.println(c);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No hay cuentas de tipo " + nombreTipo + ".");
        }
    }

    private static void crearAhorro() {
        System.out.print("Numero de cuenta: ");
        String numero = sc.nextLine();
        long dni = leerLong("DNI cliente: ");
        double saldo = leerDouble("Saldo actual: ");
        System.out.print("Fecha de creacion (dd/mm/aaaa): ");
        String fecha = sc.nextLine();

        Ahorro ahorro = new Ahorro(numero, dni, saldo, fecha);
        service.crearCuenta(ahorro);
        System.out.println("Cuenta de ahorro creada correctamente.");
    }

    private static void crearCorriente() {
        System.out.print("Numero de cuenta: ");
        String numero = sc.nextLine();
        long dni = leerLong("DNI cliente: ");
        double saldo = leerDouble("Saldo actual: ");
        double impuesto = leerDouble("Impuesto: ");

        Corriente corriente = new Corriente(numero, dni, saldo, impuesto);
        service.crearCuenta(corriente);
        System.out.println("Cuenta corriente creada correctamente.");
    }

    private static void buscarCuenta() {
        System.out.print("Ingrese el numero de cuenta a buscar: ");
        String numero = sc.nextLine();
        Cuenta c = service.obtenerDatosCuenta(numero);
        if (c != null) {
            System.out.println("Cuenta encontrada:");
            System.out.println(c);
        } else {
            System.out.println("No se encontro ninguna cuenta con ese numero.");
        }
    }

    private static long leerLong(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Long.parseLong(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido, ingrese solo numeros.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido, ingrese un numero (use punto decimal).");
            }
        }
    }
}
