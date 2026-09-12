import java.util.Scanner;

import domain.Ahorro;
import domain.Corriente;
import domain.Cuenta;
import service.ServiceCuenta;

public class App {
    public static void main(String[] args) throws Exception {
        ServiceCuenta serviceCuenta = new ServiceCuenta();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENU CUENTAS ---");
            System.out.println("a. Listar cuentas Ahorro");
            System.out.println("b. Listar cuentas Corriente");
            System.out.println("c. Crear cuenta Ahorro");
            System.out.println("d. Crear cuenta Corriente");
            System.out.println("e. Obtener cuenta por numero");
            System.out.println("f. Retirar dinero");
            System.out.println("g. Depositar dinero");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            String entrada = sc.nextLine().trim().toLowerCase();

            switch (entrada) {
                case "a":
                    serviceCuenta.listarAhorros().forEach(System.out::println);
                    break;
                case "b":
                    serviceCuenta.listarCorrientes().forEach(System.out::println);
                    break;
                case "c":
                    System.out.print("Numero cuenta: ");
                    String numA = sc.nextLine();
                    System.out.print("DNI cliente: ");
                    long dniA = Long.parseLong(sc.nextLine());
                    System.out.print("Saldo inicial: ");
                    double saldoA = Double.parseDouble(sc.nextLine());
                    System.out.print("Fecha creacion: ");
                    String fecha = sc.nextLine();
                    serviceCuenta.crearAhorro(new Ahorro(numA, dniA, saldoA, fecha));
                    System.out.println("Cuenta de ahorro creada.");
                    break;
                case "d":
                    System.out.print("Numero cuenta: ");
                    String numC = sc.nextLine();
                    System.out.print("DNI cliente: ");
                    long dniC = Long.parseLong(sc.nextLine());
                    System.out.print("Saldo inicial: ");
                    double saldoC = Double.parseDouble(sc.nextLine());
                    System.out.print("Impuesto: ");
                    double impuesto = Double.parseDouble(sc.nextLine());
                    serviceCuenta.crearCorriente(new Corriente(numC, dniC, saldoC, impuesto));
                    System.out.println("Cuenta corriente creada.");
                    break;
                case "e":
                    System.out.print("Numero cuenta a buscar: ");
                    String numBuscar = sc.nextLine();
                    Cuenta encontrada = serviceCuenta.obtenerCuentaPorNumero(numBuscar);
                    System.out.println(encontrada != null ? encontrada : "Cuenta no encontrada.");
                    break;
                case "f":
                    System.out.print("Numero cuenta: ");
                    String numRet = sc.nextLine();
                    System.out.print("Monto a retirar: ");
                    double montoRet = Double.parseDouble(sc.nextLine());
                    System.out.println(serviceCuenta.retirarDinero(numRet, montoRet) ? "Retiro exitoso." : "No se pudo retirar.");
                    break;
                case "g":
                    System.out.print("Numero cuenta: ");
                    String numDep = sc.nextLine();
                    System.out.print("Monto a depositar: ");
                    double montoDep = Double.parseDouble(sc.nextLine());
                    System.out.println(serviceCuenta.depositarDinero(numDep, montoDep) ? "Deposito exitoso." : "No se pudo depositar.");
                    break;
                case "0":
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
        sc.close();
    }
}