import java.util.List;
import java.util.Scanner;

import domain.Ahorro;
import domain.Corriente;
import domain.Cuenta;
import service.ServiceCuenta;

public class App {
    public static void main(String[] args) throws Exception {
        ServiceCuenta service = new ServiceCuenta();
        Scanner scanner = new Scanner(System.in);
        String opcion = "";

        while (!opcion.equals("0")) {
            System.out.println("\na. Listar Ahorro");
            System.out.println("b. Listar Corriente");
            System.out.println("c. Crear cuenta Ahorro");
            System.out.println("d. Crear cuenta Corriente");
            System.out.println("e. Buscar cuenta");
            System.out.println("f. Retirar dinero");
            System.out.println("g. Depositar dinero");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "a": {
                    List<Cuenta> cuentas = service.obtenerCuentas();
                    for (Cuenta c : cuentas) {
                        if (c instanceof Ahorro) {
                            System.out.println(c);
                        }
                    }
                    break;
                }
                case "b": {
                    List<Cuenta> cuentas = service.obtenerCuentas();
                    for (Cuenta c : cuentas) {
                        if (c instanceof Corriente) {
                            System.out.println(c);
                        }
                    }
                    break;
                }
                case "c": {
                    System.out.print("Numero de cuenta: ");
                    String numero = scanner.nextLine();
                    System.out.print("DNI: ");
                    long dni = Long.parseLong(scanner.nextLine());
                    System.out.print("Saldo: ");
                    double saldo = Double.parseDouble(scanner.nextLine());
                    System.out.print("Fecha de creacion: ");
                    String fecha = scanner.nextLine();
                    boolean creada = service.crearCuenta(new Ahorro(numero, dni, saldo, fecha));
                    System.out.println(creada ? "Cuenta creada." : "Ya existe esa cuenta.");
                    break;
                }
                case "d": {
                    System.out.print("Numero de cuenta: ");
                    String numero = scanner.nextLine();
                    System.out.print("DNI: ");
                    long dni = Long.parseLong(scanner.nextLine());
                    System.out.print("Saldo: ");
                    double saldo = Double.parseDouble(scanner.nextLine());
                    System.out.print("Impuesto: ");
                    double impuesto = Double.parseDouble(scanner.nextLine());
                    boolean creada = service.crearCuenta(new Corriente(numero, dni, saldo, impuesto));
                    System.out.println(creada ? "Cuenta creada." : "Ya existe esa cuenta.");
                    break;
                }
                case "e": {
                    System.out.print("Numero de cuenta: ");
                    String numero = scanner.nextLine();
                    Cuenta cuenta = service.obtenernumeroCuenta(numero);
                    System.out.println(cuenta != null ? cuenta : "Cuenta no encontrada.");
                    break;
                }
                case "f": {
                    System.out.print("Numero de cuenta: ");
                    String numero = scanner.nextLine();
                    System.out.print("Monto: ");
                    double monto = Double.parseDouble(scanner.nextLine());
                    boolean ok = service.retirarDinero(numero, monto);
                    System.out.println(ok ? "Retiro exitoso." : "No se pudo retirar.");
                    break;
                }
                case "g": {
                    System.out.print("Numero de cuenta: ");
                    String numero = scanner.nextLine();
                    System.out.print("Monto: ");
                    double monto = Double.parseDouble(scanner.nextLine());
                    boolean ok = service.ingresarDinero(numero, monto);
                    System.out.println(ok ? "Deposito exitoso." : "No se pudo depositar.");
                    break;
                }
            }
        }

        scanner.close();
    }
}