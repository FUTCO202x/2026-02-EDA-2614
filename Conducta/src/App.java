
package Requerimientos;

import java.util.List;
import java.util.Scanner;


public class App {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServiceCuenta serviceCuenta = new ServiceCuenta();

        int opcionletra;

        do {
            System.out.println("\n--------------------MENU--------------------");
            System.out.println("a. Listar todas las cuentas Ahorro");
            System.out.println("b. Listar todas las cuentas Corriente");
            System.out.println("c. Crear cuenta de Ahorro");
            System.out.println("d. Crear cuenta Corriente");
            System.out.println("e. Obtener la información de la cuenta por el numero de cuenta");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            String opcionnumero = sc.nextLine();
            opcionletra = opcionnumero.equalsIgnoreCase("a") ? 1
                    : opcionnumero.equalsIgnoreCase("b") ? 2
                    : opcionnumero.equalsIgnoreCase("c") ? 3
                    : opcionnumero.equalsIgnoreCase("d") ? 4
                    : opcionnumero.equalsIgnoreCase("e") ? 5
                    : opcionnumero.equals("0") ? 0 : -1;

            switch (opcionletra) {
                case 1:
                    listarAhorro(serviceCuenta.listarTodasLasCuentas());
                    break;
                    
                case 2:
                    listarCorriente(serviceCuenta.listarTodasLasCuentas());
                    break;
                    
                case 3:
                    System.out.print("Numero de cuenta: ");
                    String numeroAhorro = sc.nextLine();

                    System.out.print("DNI del cliente: ");
                    long dniAhorro = Long.parseLong(sc.nextLine());

                    System.out.print("Saldo actual: ");
                    double saldoAhorro = Double.parseDouble(sc.nextLine());

                    System.out.print("Fecha de creacion: ");
                    String fechaCreacion = sc.nextLine();

                    serviceCuenta.crearCuenta(
                            new Ahorro(numeroAhorro, dniAhorro, saldoAhorro, fechaCreacion)
                    );
                    System.out.println("Cuenta de Ahorro creada.");
                    break;
                    
                case 4:
                    System.out.print("Numero de cuenta: ");
                    String numeroCorriente = sc.nextLine();

                    System.out.print("DNI del cliente: ");
                    long dniCorriente = Long.parseLong(sc.nextLine());

                    System.out.print("Saldo actual: ");
                    double saldoCorriente = Double.parseDouble(sc.nextLine());

                    System.out.print("Impuesto: ");
                    double impuesto = Double.parseDouble(sc.nextLine());

                    serviceCuenta.crearCuenta(
                            new Corriente(numeroCorriente, dniCorriente, saldoCorriente, impuesto)
                    );
                    System.out.println("Cuenta Corriente creada.");
                    break;
                    
                case 5:
                    System.out.print("Ingrese el numero de cuenta: ");
                    String numeroCuenta = sc.nextLine();

                    Cuenta cuenta = serviceCuenta.obtenerDatosCuenta(numeroCuenta);

                    if (cuenta != null) {
                        System.out.println(cuenta);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;
                    
                case 0:
                    System.out.println("----------------Programa Finalizado.----------------");
                    break;
                default:
                    System.out.println("Opcion no Invalida. ¡Por favor digite una opción valida!");
            }
        } while (opcionletra != 0);

        sc.close();
    }

    private static void listarAhorro(List<Cuenta> cuentas) {
        boolean existenciaCuenta = false;
        for (Cuenta cuenta : cuentas) {
            if (cuenta instanceof Ahorro) {
                System.out.println(cuenta);
                existenciaCuenta = true;
            }
        }

        if (!existenciaCuenta) {
            System.out.println(" || No hay cuenta de Ahorro registrada. Debe registrar una cuenta primero. || ");
        }
    }

    
    private static void listarCorriente(List<Cuenta> cuentas) {
        boolean existenciaCuenta = false;
        for (Cuenta cuenta : cuentas) {
            if (cuenta instanceof Corriente) {
                System.out.println(cuenta);
                existenciaCuenta = true;
            }
        }
        
         if (!existenciaCuenta) {
            System.out.println(" || No hay cuenta Corriente registrada. Debe registrar una cuenta primero. ||");
        }
    }
    
    
}