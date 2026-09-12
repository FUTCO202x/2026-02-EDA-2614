import java.util.Scanner;
import models.Cuenta;
import models.Ahorro;
import models.Corriente;
import service.ServiceCuenta;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ServiceCuenta service = new ServiceCuenta();

        String opcion;

        do {

            System.out.println("\n--- MENU CUENTAS ---");
            System.out.println("a. Listar Ahorro");
            System.out.println("b. Listar Corriente");
            System.out.println("c. Crear Ahorro");
            System.out.println("d. Crear Corriente");
            System.out.println("e. Buscar cuenta");
            System.out.println("f. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextLine();

            switch (opcion) {

                case "a":

                    for (Cuenta cuenta : service.ListarCuenta()) {

                        if (cuenta instanceof Ahorro) {
                            System.out.println(cuenta);
                        }
                    }

                    break;

                case "b":

                    for (Cuenta cuenta : service.ListarCuenta()) {

                        if (cuenta instanceof Corriente) {
                            System.out.println(cuenta);
                        }
                    }

                    break;

                case "c":

                    System.out.print("Numero de cuenta: ");
                    String numero = scanner.nextLine();

                    System.out.print("DNI: ");
                    long dni = scanner.nextLong();

                    System.out.print("Saldo: ");
                    double saldo = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Fecha de creacion: ");
                    String fecha = scanner.nextLine();

                    Ahorro ahorro = new Ahorro(numero, dni, saldo, fecha);

                    service.crearCuenta(ahorro);

                    System.out.println("Cuenta Ahorro creada.");

                    break;

                case "d":

                    System.out.print("Numero de cuenta: ");
                    numero = scanner.nextLine();

                    System.out.print("DNI: ");
                    dni = scanner.nextLong();

                    System.out.print("Saldo: ");
                    saldo = scanner.nextDouble();

                    System.out.print("Impuesto: ");
                    double impuesto = scanner.nextDouble();
                    scanner.nextLine();

                    Corriente corriente = new Corriente(numero, dni, saldo, impuesto);

                    service.crearCuenta(corriente);

                    System.out.println("Cuenta Corriente creada.");

                    break;

                case "e":

                    System.out.print("Numero de cuenta: ");
                    numero = scanner.nextLine();

                    Cuenta cuenta = service.obtenerCuenta(numero);

                    if (cuenta != null) {
                        System.out.println(cuenta);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }

                    break;

                case "f":

                    System.out.println("Programa terminado.");

                    break;

                default:

                    System.out.println("Opcion no valida.");
            }

        } while (!opcion.equals("f"));

        scanner.close();
    }
}