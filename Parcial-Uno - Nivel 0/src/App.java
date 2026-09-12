import java.util.List;
import java.util.Scanner;

import domain.Ahorro;
import domain.Corriente;
import domain.Cuenta;
import service.ServiceCuenta;

/// INTEGRANTES
/// OSCAR MONTES VARGAS
/// MARCOS TORREALBA
/// CRISTIAN CASSIANI

public class App {
    public static void main(String[] args) throws Exception {
        ServiceCuenta serviceCuenta = new ServiceCuenta();
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- MENU CUENTAS ---");
            System.out.println("a. Listar todas las cuentas Ahorro");
            System.out.println("b. Listar todas las cuentas Corriente");
            System.out.println("c. Crear cuenta Ahorro");
            System.out.println("d. Crear cuenta Corriente");
            System.out.println("e. Obtener cuenta por numero");
            System.out.println("f. Retirar dinero");
            System.out.println("g. Depositar dinero");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            String entrada = sc.nextLine().trim().toLowerCase();

            switch (entrada) {
                case "a":
                    System.out.println("--- Cuentas Ahorro ---");
                    for (Cuenta c : serviceCuenta.obtenerCuentas()) {
                        if (c instanceof Ahorro) {
                            System.out.println(c);
                        }
                    }
                    break;

                case "b":
                    System.out.println("--- Cuentas Corriente ---");
                    for (Cuenta c : serviceCuenta.obtenerCuentas()) {
                        if (c instanceof Corriente) {
                            System.out.println(c);
                        }
                    }
                    break;

                case "c":
                    System.out.print("Numero de cuenta: ");
                    String numAhorro = sc.nextLine();
                    System.out.print("DNI cliente: ");
                    long dniAhorro = Long.parseLong(sc.nextLine());
                    System.out.print("Saldo inicial: ");
                    double saldoAhorro = Double.parseDouble(sc.nextLine());
                    System.out.print("Fecha creacion (yyyy-mm-dd): ");
                    String fecha = sc.nextLine();
                    boolean creadaAhorro = serviceCuenta.crearCuenta(
                            new Ahorro(numAhorro, dniAhorro, saldoAhorro, fecha));
                    System.out.println(creadaAhorro ? "Cuenta creada." : "Ya existe una cuenta con ese numero.");
                    break;

                case "d":
                    System.out.print("Numero de cuenta: ");
                    String numCorriente = sc.nextLine();
                    System.out.print("DNI cliente: ");
                    long dniCorriente = Long.parseLong(sc.nextLine());
                    System.out.print("Saldo inicial: ");
                    double saldoCorriente = Double.parseDouble(sc.nextLine());
                    System.out.print("Impuesto: ");
                    double impuesto = Double.parseDouble(sc.nextLine());
                    boolean creadaCorriente = serviceCuenta.crearCuenta(
                            new Corriente(numCorriente, dniCorriente, saldoCorriente, impuesto));
                    System.out.println(creadaCorriente ? "Cuenta creada." : "Ya existe una cuenta con ese numero.");
                    break;

                case "e":
                    System.out.print("Numero de cuenta a buscar: ");
                    String numBuscar = sc.nextLine();
                    Cuenta encontrada = serviceCuenta.obtenernumeroCuenta(numBuscar);
                    System.out.println(encontrada != null ? encontrada : "No existe esa cuenta.");
                    break;

                case "f":
                    System.out.print("Numero de cuenta: ");
                    String numRetiro = sc.nextLine();
                    System.out.print("Monto a retirar: ");
                    double montoRetiro = Double.parseDouble(sc.nextLine());
                    boolean retiroOk = serviceCuenta.retirarDinero(numRetiro, montoRetiro);
                    System.out.println(retiroOk ? "Retiro exitoso." : "No se pudo retirar (cuenta inexistente o saldo insuficiente).");
                    break;

                case "g":
                    System.out.print("Numero de cuenta: ");
                    String numDeposito = sc.nextLine();
                    System.out.print("Monto a depositar: ");
                    double montoDeposito = Double.parseDouble(sc.nextLine());
                    boolean depositoOk = serviceCuenta.ingresarDinero(numDeposito, montoDeposito);
                    System.out.println(depositoOk ? "Deposito exitoso." : "No se pudo depositar (cuenta inexistente).");
                    break;

                case "0":
                    System.out.println("Saliendo...");
                    opcion = 0;
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }
        sc.close();
    }
}