import java.util.List;
import java.util.Scanner;

import domain.Ahorro;
import domain.Corriente;
import domain.Cuenta;
import service.ServiceCuenta;

public class App {
    public static void main(String[] args) {
        ServiceCuenta serviceCuenta = new ServiceCuenta();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            System.out.println("\n--- MENÚ DE CUENTAS ---");
            System.out.println("a. Listar ahorros");
            System.out.println("b. Listar corrientes");
            System.out.println("c. Crear ahorro");
            System.out.println("d. Crear corriente");
            System.out.println("e. Obtener cuenta por número");
            System.out.println("f. Retirar dinero");
            System.out.println("g. Depositar dinero");
            System.out.println("x. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine().trim().toLowerCase();
            switch (opcion) {
                case "a":
                    listarCuentas(serviceCuenta.obtenerCuentas(), Ahorro.class);
                    break;
                case "b":
                    listarCuentas(serviceCuenta.obtenerCuentas(), Corriente.class);
                    break;
                case "c":
                    crearAhorro(scanner, serviceCuenta);
                    break;
                case "d":
                    crearCorriente(scanner, serviceCuenta);
                    break;
                case "e":
                    obtenerCuenta(scanner, serviceCuenta);
                    break;
                case "f":
                    moverDinero(scanner, serviceCuenta, true);
                    break;
                case "g":
                    moverDinero(scanner, serviceCuenta, false);
                    break;
                case "x":
                    System.out.println("Hasta luego.");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static <T extends Cuenta> void listarCuentas(List<Cuenta> cuentas, Class<T> tipo) {
        boolean encontrada = false;
        for (Cuenta cuenta : cuentas) {
            if (tipo.isInstance(cuenta)) {
                System.out.println(cuenta);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No hay cuentas de este tipo.");
        }
    }

    private static void crearAhorro(Scanner scanner, ServiceCuenta serviceCuenta) {
        String numeroCuenta = leerTexto(scanner, "Número de cuenta: ");
        Long dniCliente = leerLong(scanner, "DNI del cliente: ");
        Double saldoActual = leerDouble(scanner, "Saldo inicial: ");
        String fechaCreacion = leerTexto(scanner, "Fecha de creación: ");
        if (numeroCuenta == null || dniCliente == null || saldoActual == null || fechaCreacion == null) {
            return;
        }

        boolean creada = serviceCuenta.crearCuenta(
                new Ahorro(numeroCuenta, dniCliente, saldoActual, fechaCreacion));
        System.out.println(creada ? "Cuenta de ahorro creada." : "No se creó: el número ya existe o no es válido.");
    }

    private static void crearCorriente(Scanner scanner, ServiceCuenta serviceCuenta) {
        String numeroCuenta = leerTexto(scanner, "Número de cuenta: ");
        Long dniCliente = leerLong(scanner, "DNI del cliente: ");
        Double saldoActual = leerDouble(scanner, "Saldo inicial: ");
        Double impuesto = leerDouble(scanner, "Impuesto: ");
        if (numeroCuenta == null || dniCliente == null || saldoActual == null || impuesto == null) {
            return;
        }

        boolean creada = serviceCuenta.crearCuenta(
                new Corriente(numeroCuenta, dniCliente, saldoActual, impuesto));
        System.out.println(creada ? "Cuenta corriente creada." : "No se creó: el número ya existe o no es válido.");
    }

    private static void obtenerCuenta(Scanner scanner, ServiceCuenta serviceCuenta) {
        String numeroCuenta = leerTexto(scanner, "Número de cuenta: ");
        if (numeroCuenta == null) {
            return;
        }
        Cuenta cuenta = serviceCuenta.obtenernumeroCuenta(numeroCuenta);
        System.out.println(cuenta == null ? "No existe una cuenta con ese número." : cuenta);
    }

    private static void moverDinero(Scanner scanner, ServiceCuenta serviceCuenta, boolean esRetiro) {
        String numeroCuenta = leerTexto(scanner, "Número de cuenta: ");
        Double monto = leerDouble(scanner, esRetiro ? "Monto a retirar: " : "Monto a depositar: ");
        if (numeroCuenta == null || monto == null) {
            return;
        }

        boolean exitoso = esRetiro
                ? serviceCuenta.retirarDinero(numeroCuenta, monto)
                : serviceCuenta.ingresarDinero(numeroCuenta, monto);
        System.out.println(exitoso ? "Operación realizada correctamente."
                : "Operación fallida: verifique la cuenta y que el monto sea válido.");
    }

    private static String leerTexto(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.hasNextLine() ? scanner.nextLine().trim() : null;
    }

    private static Long leerLong(Scanner scanner, String mensaje) {
        while (scanner.hasNextLine()) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                return Long.parseLong(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número entero válido.");
            }
        }
        return null;
    }

    private static Double leerDouble(Scanner scanner, String mensaje) {
        while (scanner.hasNextLine()) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                double valor = Double.parseDouble(entrada);
                if (Double.isFinite(valor)) {
                    return valor;
                }
            } catch (NumberFormatException e) {
                // Se vuelve a solicitar el dato en el siguiente ciclo.
            }
            System.out.println("Ingrese un número válido.");
        }
        return null;
    }
}
