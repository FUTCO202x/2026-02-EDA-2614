import java.util.List;
import java.util.Scanner;

import domain.Ahorro;
import domain.Corriente;
import domain.Cuenta;
import service.ServiceCuenta;

public class App {
    public static void main(String[] args) throws Exception {
        ServiceCuenta serviceCuenta = new ServiceCuenta();
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("a. Listar todas las cuentas Ahorro");
            System.out.println("b. Listar todas las cuentas Corriente");
            System.out.println("c. Crear cuenta de Ahorro");
            System.out.println("d. Crear cuenta Corriente");
            System.out.println("e. Obtener la información de la cuenta por el número de la cuenta");
            System.out.println("f. Retirar Dinero");
            System.out.println("g. Depositar Dinero");
            System.out.println("h. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextLine().trim().toLowerCase();

            switch (opcion) {
                case "a":
                    listarCuentasAhorro(serviceCuenta);
                    break;
                case "b":
                    listarCuentasCorriente(serviceCuenta);
                    break;
                case "c":
                    crearCuentaAhorro(serviceCuenta, scanner);
                    break;
                case "d":
                    crearCuentaCorriente(serviceCuenta, scanner);
                    break;
                case "e":
                    obtenerCuentaPorNumero(serviceCuenta, scanner);
                    break;
                case "f":
                    retirarDinero(serviceCuenta, scanner);
                    break;
                case "g":
                    depositarDinero(serviceCuenta, scanner);
                    break;
                case "h":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
            }
        } while (!opcion.equals("h"));

        scanner.close();
    }

    private static void listarCuentasAhorro(ServiceCuenta service) {
        List<Ahorro> ahorros = service.obtenerCuentasAhorro();
        System.out.println("\n===== CUENTAS AHORRO =====");
        for (Ahorro ahorro : ahorros) {
            System.out.println(ahorro);
        }
    }

    private static void listarCuentasCorriente(ServiceCuenta service) {
        List<Corriente> corrientes = service.obtenerCuentasCorriente();
        System.out.println("\n===== CUENTAS CORRIENTE =====");
        for (Corriente corriente : corrientes) {
            System.out.println(corriente);
        }
    }

    private static void crearCuentaAhorro(ServiceCuenta service, Scanner scanner) {
        System.out.println("\n===== CREAR CUENTA AHORRO =====");
        System.out.print("Numero de cuenta: ");
        String numeroCuenta = scanner.nextLine().trim();
        System.out.print("DNI del cliente: ");
        long dniCliente = Long.parseLong(scanner.nextLine().trim());
        System.out.print("Saldo actual: ");
        double saldoActual = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Fecha de creacion (yyyy-MM-dd): ");
        String fechaCreacion = scanner.nextLine().trim();

        Ahorro ahorro = new Ahorro(numeroCuenta, dniCliente, saldoActual, fechaCreacion);
        if (service.crearCuenta(ahorro)) {
            System.out.println("Cuenta de ahorro creada exitosamente.");
        } else {
            System.out.println("Error: ya existe una cuenta con ese numero.");
        }
    }

    private static void crearCuentaCorriente(ServiceCuenta service, Scanner scanner) {
        System.out.println("\n===== CREAR CUENTA CORRIENTE =====");
        System.out.print("Numero de cuenta: ");
        String numeroCuenta = scanner.nextLine().trim();
        System.out.print("DNI del cliente: ");
        long dniCliente = Long.parseLong(scanner.nextLine().trim());
        System.out.print("Saldo actual: ");
        double saldoActual = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Impuesto: ");
        double impuesto = Double.parseDouble(scanner.nextLine().trim());

        Corriente corriente = new Corriente(numeroCuenta, dniCliente, saldoActual, impuesto);
        if (service.crearCuenta(corriente)) {
            System.out.println("Cuenta corriente creada exitosamente.");
        } else {
            System.out.println("Error: ya existe una cuenta con ese numero.");
        }
    }

    private static void obtenerCuentaPorNumero(ServiceCuenta service, Scanner scanner) {
        System.out.println("\n===== CONSULTAR CUENTA POR NUMERO =====");
        System.out.print("Numero de cuenta: ");
        String numeroCuenta = scanner.nextLine().trim();
        Cuenta cuenta = service.obtenernumeroCuenta(numeroCuenta);
        if (cuenta == null) {
            System.out.println("No existe ninguna cuenta con el numero " + numeroCuenta);
        } else {
            System.out.println(cuenta);
        }
    }

    private static void retirarDinero(ServiceCuenta service, Scanner scanner) {
        System.out.println("\n===== RETIRAR DINERO =====");
        System.out.print("Numero de cuenta: ");
        String numeroCuenta = scanner.nextLine().trim();
        System.out.print("Monto a retirar: ");
        double monto = Double.parseDouble(scanner.nextLine().trim());
        if (service.retirarDinero(numeroCuenta, monto)) {
            System.out.println("Retiro exitoso.");
        } else {
            System.out.println("Error: la cuenta no existe o el saldo es insuficiente.");
        }
    }

    private static void depositarDinero(ServiceCuenta service, Scanner scanner) {
        System.out.println("\n===== DEPOSITAR DINERO =====");
        System.out.print("Numero de cuenta: ");
        String numeroCuenta = scanner.nextLine().trim();
        System.out.print("Monto a depositar: ");
        double monto = Double.parseDouble(scanner.nextLine().trim());
        if (service.ingresarDinero(numeroCuenta, monto)) {
            System.out.println("Deposito exitoso.");
        } else {
            System.out.println("Error: la cuenta no existe o el monto es invalido.");
        }
    }
}