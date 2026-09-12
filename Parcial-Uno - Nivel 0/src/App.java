import java.util.Scanner;

import domain.Ahorro;
import domain.Corriente;
import domain.Cuenta;
import service.ServiceCuenta;

public class App {
    public static void main(String[] args) throws Exception {
        ServiceCuenta serviceCuenta = new ServiceCuenta();
        Scanner scanner = new Scanner(System.in);
        String opcion = "";

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("a. Listar todas las cuentas Ahorro");
            System.out.println("b. Listar todas las cuentas Corriente");
            System.out.println("c. Crear cuenta de Ahorro");
            System.out.println("d. Crear cuenta Corriente");
            System.out.println("e. Obtener la información de la cuenta por el número");
            System.out.println("f. Retirar Dinero");
            System.out.println("g. Depositar Dinero");
            System.out.println("h. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextLine().toLowerCase();

            switch (opcion) {
                case "a":
                    System.out.println("\n-- CUENTAS DE AHORRO --");
                    for (Cuenta cuenta : serviceCuenta.obtenerCuentas()) {
                        if (cuenta instanceof Ahorro) {
                            System.out.println(cuenta.toString());
                        }
                    }
                    break;

                case "b":
                    System.out.println("\n-- CUENTAS CORRIENTES --");
                    for (Cuenta cuenta : serviceCuenta.obtenerCuentas()) {
                        if (cuenta instanceof Corriente) {
                            System.out.println(cuenta.toString());
                        }
                    }
                    break;

                case "c":
                    System.out.print("Ingrese número de cuenta: ");
                    String numAh = scanner.nextLine();
                    System.out.print("Ingrese DNI del cliente: ");
                    long dniAh = Long.parseLong(scanner.nextLine());
                    System.out.print("Ingrese saldo inicial: ");
                    double saldoAh = Double.parseDouble(scanner.nextLine());
                    System.out.print("Ingrese fecha de creación (ej. 2023-10-01): ");
                    String fecha = scanner.nextLine();
                    
                    boolean ahorroCreada = serviceCuenta.crearCuenta(new Ahorro(numAh, dniAh, saldoAh, fecha));
                    if (ahorroCreada) {
                        System.out.println("¡Cuenta de ahorro creada exitosamente!");
                    } else {
                        System.out.println("Error: Ya existe una cuenta con ese número.");
                    }
                    break;

                case "d":
                    System.out.print("Ingrese número de cuenta: ");
                    String numCor = scanner.nextLine();
                    System.out.print("Ingrese DNI del cliente: ");
                    long dniCor = Long.parseLong(scanner.nextLine());
                    System.out.print("Ingrese saldo inicial: ");
                    double saldoCor = Double.parseDouble(scanner.nextLine());
                    System.out.print("Ingrese valor de impuesto (ej. 0.004): ");
                    double impuesto = Double.parseDouble(scanner.nextLine());
                    
                    boolean corrienteCreada = serviceCuenta.crearCuenta(new Corriente(numCor, dniCor, saldoCor, impuesto));
                    if (corrienteCreada) {
                        System.out.println("¡Cuenta corriente creada exitosamente!");
                    } else {
                        System.out.println("Error: Ya existe una cuenta con ese número.");
                    }
                    break;

                case "e":
                    System.out.print("Ingrese el número de cuenta a buscar: ");
                    String numBuscar = scanner.nextLine();
                    Cuenta cuentaEncontrada = serviceCuenta.obtenernumeroCuenta(numBuscar);
                    
                    if (cuentaEncontrada != null) {
                        System.out.println("Información: " + cuentaEncontrada.toString());
                    } else {
                        System.out.println("La cuenta no existe.");
                    }
                    break;

                case "f":
                    System.out.print("Ingrese el número de cuenta: ");
                    String numRetiro = scanner.nextLine();
                    System.out.print("Ingrese el monto a retirar: ");
                    double montoRetiro = Double.parseDouble(scanner.nextLine());
                    
                    if (serviceCuenta.retirarDinero(numRetiro, montoRetiro)) {
                        System.out.println("Retiro exitoso.");
                    } else {
                        System.out.println("No se pudo realizar el retiro (Verifique el saldo o si la cuenta existe).");
                    }
                    break;

                case "g":
                    System.out.print("Ingrese el número de cuenta: ");
                    String numDeposito = scanner.nextLine();
                    System.out.print("Ingrese el monto a depositar: ");
                    double montoDeposito = Double.parseDouble(scanner.nextLine());
                    
                    if (serviceCuenta.ingresarDinero(numDeposito, montoDeposito)) {
                        System.out.println("Depósito exitoso.");
                    } else {
                        System.out.println("No se pudo realizar el depósito (Verifique el monto o si la cuenta existe).");
                    }
                    break;
                    
                case "h":
                    System.out.println("Saliendo de la aplicación...");
                    break;
                    
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (!opcion.equals("h"));

        scanner.close();
    }
}