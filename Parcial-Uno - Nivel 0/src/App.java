import java.util.List;
import java.util.Scanner;

import domain.Ahorro;
import domain.Corriente;
import domain.Cuenta;
import service.ServiceCuenta;

public class App {
    public static void main(String[] args) throws Exception {
        ServiceCuenta serviceCuenta = new ServiceCuenta();
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n===== MENU CUENTAS =====");
            System.out.println("a. Listar todas las cuentas Ahorro");
            System.out.println("b. Listar todas las cuentas Corriente");
            System.out.println("c. Crear cuenta de Ahorro");
            System.out.println("d. Crear cuenta Corriente");
            System.out.println("e. Obtener informacion de una cuenta por su numero");
            System.out.println("f. Retirar dinero");
            System.out.println("g. Depositar dinero");
            System.out.println("s. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextLine().trim().toLowerCase();

            switch (opcion) {
                case "a" -> listarPorTipo(serviceCuenta.obtenerCuentas(), true);
                case "b" -> listarPorTipo(serviceCuenta.obtenerCuentas(), false);
                case "c" -> {
                    System.out.print("Numero de cuenta: ");
                    String num = sc.nextLine();
                    System.out.print("DNI del cliente: ");
                    long dni = Long.parseLong(sc.nextLine());
                    System.out.print("Saldo inicial: ");
                    double saldo = Double.parseDouble(sc.nextLine());
                    System.out.print("Fecha de creacion (yyyy-MM-dd): ");
                    String fecha = sc.nextLine();
                    Ahorro ahorro = new Ahorro(num, dni, saldo, fecha);
                    if (serviceCuenta.crearCuenta(ahorro)) {
                        System.out.println("Cuenta de ahorro creada correctamente.");
                    } else {
                        System.out.println("Ya existe una cuenta con ese numero.");
                    }
                }
                case "d" -> {
                    System.out.print("Numero de cuenta: ");
                    String num = sc.nextLine();
                    System.out.print("DNI del cliente: ");
                    long dni = Long.parseLong(sc.nextLine());
                    System.out.print("Saldo inicial: ");
                    double saldo = Double.parseDouble(sc.nextLine());
                    System.out.print("Impuesto (ej. 0.004): ");
                    double impuesto = Double.parseDouble(sc.nextLine());
                    Corriente corriente = new Corriente(num, dni, saldo, impuesto);
                    if (serviceCuenta.crearCuenta(corriente)) {
                        System.out.println("Cuenta corriente creada correctamente.");
                    } else {
                        System.out.println("Ya existe una cuenta con ese numero.");
                    }
                }
                case "e" -> {
                    System.out.print("Numero de cuenta a buscar: ");
                    String num = sc.nextLine();
                    Cuenta cuenta = serviceCuenta.obtenernumeroCuenta(num);
                    if (cuenta != null) {
                        System.out.println(cuenta);
                    } else {
                        System.out.println("No existe una cuenta con ese numero.");
                    }
                }
                case "f" -> {
                    System.out.print("Numero de cuenta: ");
                    String num = sc.nextLine();
                    System.out.print("Monto a retirar: ");
                    double monto = Double.parseDouble(sc.nextLine());
                    if (serviceCuenta.retirarDinero(num, monto)) {
                        System.out.println("Retiro exitoso. Nuevo saldo: "
                                + serviceCuenta.obtenernumeroCuenta(num).getSaldoActual());
                    } else {
                        System.out.println("No se pudo retirar (cuenta inexistente o saldo insuficiente).");
                    }
                }
                case "g" -> {
                    System.out.print("Numero de cuenta: ");
                    String num = sc.nextLine();
                    System.out.print("Monto a depositar: ");
                    double monto = Double.parseDouble(sc.nextLine());
                    if (serviceCuenta.ingresarDinero(num, monto)) {
                        System.out.println("Deposito exitoso. Nuevo saldo: "
                                + serviceCuenta.obtenernumeroCuenta(num).getSaldoActual());
                    } else {
                        System.out.println("No se pudo depositar (cuenta inexistente o monto invalido).");
                    }
                }
                case "s" -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion no valida.");
            }
        } while (!opcion.equals("s"));

        sc.close();
    }

    private static void listarPorTipo(List<Cuenta> cuentas, boolean ahorro) {
        boolean hayAlguna = false;
        for (Cuenta cuenta : cuentas) {
            if (ahorro && cuenta instanceof Ahorro) {
                System.out.println(cuenta);
                hayAlguna = true;
            } else if (!ahorro && cuenta instanceof Corriente) {
                System.out.println(cuenta);
                hayAlguna = true;
            }
        }
        if (!hayAlguna) {
            System.out.println("No hay cuentas de ese tipo.");
        }
    }
}
