import java.util.List;
import java.util.Scanner;

import domain.Ahorro;
import domain.Corriente;
import domain.Cuenta;
import service.ServiceCuenta;

public class App {

    public static void main(String[] args) {
        ServiceCuenta serviceCuenta = new ServiceCuenta();
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n========== MENÚ DE CUENTAS ==========");
            System.out.println("a. Listar todas las cuentas Ahorro");
            System.out.println("b. Listar todas las cuentas Corriente");
            System.out.println("c. Crear cuenta de Ahorro");
            System.out.println("d. Crear cuenta Corriente");
            System.out.println("e. Obtener información de una cuenta por número");
            System.out.println("f. Retirar Dinero");
            System.out.println("g. Depositar Dinero");
            System.out.println("x. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextLine().trim().toLowerCase();

            switch (opcion) {
                case "a":
                    listarCuentasAhorro(serviceCuenta);
                    break;
                case "b":
                    listarCuentasCorriente(serviceCuenta);
                    break;
                case "c":
                    crearCuentaAhorro(serviceCuenta, sc);
                    break;
                case "d":
                    crearCuentaCorriente(serviceCuenta, sc);
                    break;
                case "e":
                    obtenerCuentaPorNumero(serviceCuenta, sc);
                    break;
                case "f":
                    retirarDinero(serviceCuenta, sc);
                    break;
                case "g":
                    depositarDinero(serviceCuenta, sc);
                    break;
                case "x":
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (!opcion.equals("x"));

        sc.close();
    }

    private static void listarCuentasAhorro(ServiceCuenta service) {
        System.out.println("\n--- Cuentas de Ahorro ---");
        List<Cuenta> cuentas = service.obtenerCuentas();
        boolean hayAhorro = false;

        for (Cuenta c : cuentas) {
            if (c instanceof Ahorro) {
                System.out.println(c);
                hayAhorro = true;
            }
        }
        if (!hayAhorro) {
            System.out.println("No hay cuentas de ahorro registradas.");
        }
    }

    private static void listarCuentasCorriente(ServiceCuenta service) {
        System.out.println("\n--- Cuentas Corriente ---");
        List<Cuenta> cuentas = service.obtenerCuentas();
        boolean hayCorriente = false;

        for (Cuenta c : cuentas) {
            if (c instanceof Corriente) {
                System.out.println(c);
                hayCorriente = true;
            }
        }
        if (!hayCorriente) {
            System.out.println("No hay cuentas corriente registradas.");
        }
    }

    private static void crearCuentaAhorro(ServiceCuenta service, Scanner sc) {
        System.out.println("\n--- Crear Cuenta de Ahorro ---");
        try {
            System.out.print("Número de cuenta: ");
            String numeroCuenta = sc.nextLine().trim();

            System.out.print("DNI del cliente: ");
            long dniCliente = Long.parseLong(sc.nextLine().trim());

            System.out.print("Saldo inicial: ");
            double saldo = Double.parseDouble(sc.nextLine().trim());

            System.out.print("Fecha de creación (yyyy-MM-dd): ");
            String fecha = sc.nextLine().trim();

            Ahorro nueva = new Ahorro(numeroCuenta, dniCliente, saldo, fecha);
            boolean creada = service.crearCuenta(nueva);

            if (creada) {
                System.out.println("Cuenta de Ahorro creada exitosamente.");
            } else {
                System.out.println("Error: Ya existe una cuenta con ese número.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese valores numéricos válidos.");
        }
    }

    private static void crearCuentaCorriente(ServiceCuenta service, Scanner sc) {
        System.out.println("\n--- Crear Cuenta Corriente ---");
        try {
            System.out.print("Número de cuenta: ");
            String numeroCuenta = sc.nextLine().trim();

            System.out.print("DNI del cliente: ");
            long dniCliente = Long.parseLong(sc.nextLine().trim());

            System.out.print("Saldo inicial: ");
            double saldo = Double.parseDouble(sc.nextLine().trim());

            System.out.print("Impuesto (ej: 0.004): ");
            double impuesto = Double.parseDouble(sc.nextLine().trim());

            Corriente nueva = new Corriente(numeroCuenta, dniCliente, saldo, impuesto);
            boolean creada = service.crearCuenta(nueva);

            if (creada) {
                System.out.println("Cuenta Corriente creada exitosamente.");
            } else {
                System.out.println("Error: Ya existe una cuenta con ese número.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese valores numéricos válidos.");
        }
    }

    private static void obtenerCuentaPorNumero(ServiceCuenta service, Scanner sc) {
        System.out.println("\n--- Consultar Cuenta ---");
        System.out.print("Ingrese el número de cuenta: ");
        String numero = sc.nextLine().trim();

        Cuenta cuenta = service.obtenernumeroCuenta(numero);
        if (cuenta != null) {
            System.out.println("Cuenta encontrada:");
            System.out.println(cuenta);
        } else {
            System.out.println("No se encontró ninguna cuenta con ese número.");
        }
    }

    private static void retirarDinero(ServiceCuenta service, Scanner sc) {
        System.out.println("\n--- Retirar Dinero ---");
        try {
            System.out.print("Número de cuenta: ");
            String numero = sc.nextLine().trim();

            System.out.print("Monto a retirar: ");
            double monto = Double.parseDouble(sc.nextLine().trim());

            boolean exito = service.retirarDinero(numero, monto);
            if (exito) {
                System.out.println("Retiro exitoso.");
                Cuenta c = service.obtenernumeroCuenta(numero);
                System.out.println("Nuevo saldo: " + c.getSaldoActual());
            } else {
                System.out.println("Error: No se pudo realizar el retiro (cuenta no existe o saldo insuficiente).");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un monto válido.");
        }
    }

    private static void depositarDinero(ServiceCuenta service, Scanner sc) {
        System.out.println("\n--- Depositar Dinero ---");
        try {
            System.out.print("Número de cuenta: ");
            String numero = sc.nextLine().trim();

            System.out.print("Monto a depositar: ");
            double monto = Double.parseDouble(sc.nextLine().trim());

            boolean exito = service.ingresarDinero(numero, monto);
            if (exito) {
                System.out.println("Depósito exitoso.");
                // Mostrar saldo actualizado
                Cuenta c = service.obtenernumeroCuenta(numero);
                System.out.println("Nuevo saldo: " + c.getSaldoActual());
            } else {
                System.out.println("Error: No se pudo realizar el depósito (cuenta no existe o monto inválido).");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un monto válido.");
        }
    }
}