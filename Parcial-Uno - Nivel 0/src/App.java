import java.util.List;
import java.util.Scanner;

import domain.Ahorro;
import domain.Corriente;
import domain.Cuenta;
import service.ServiceCuenta;

public class App {
    public static void main(String[] args) throws Exception {
        ServiceCuenta serviceCuenta=new ServiceCuenta();
         Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Listar cuentas Ahorro");
            System.out.println("2. Listar cuentas Corriente");
            System.out.println("3. Crear cuenta Ahorro");
            System.out.println("4. Crear cuenta Corriente");
            System.out.println("5. Obtener información de una cuenta");
            System.out.println("0. Salir");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Service.listarCuentas().stream()
                            .filter(c -> c instanceof Ahorro)
                            .forEach(System.out::println);
                    break;
                case 2:
                    Service.listarCuentas().stream()
                            .filter(c -> c instanceof Corriente)
                            .forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Número de cuenta: ");
                    String numA = sc.next();
                    System.out.print("DNI cliente: ");
                    long dniA = sc.nextLong();
                    System.out.print("Saldo inicial: ");
                    double saldoA = sc.nextDouble();
                    System.out.print("Fecha creación: ");
                    String fecha = sc.next();
                    Service.crearCuenta(new Ahorro(numA, dniA, saldoA, fecha));
                    break;
                case 4:
                    System.out.print("Número de cuenta: ");
                    String numC = sc.next();
                    System.out.print("DNI cliente: ");
                    long dniC = sc.nextLong();
                    System.out.print("Saldo inicial: ");
                    double saldoC = sc.nextDouble();
                    System.out.print("Impuesto: ");
                    double imp = sc.nextDouble();
                    Service.crearCuenta(new Corriente(numC, dniC, saldoC, imp));
                    break;
                case 5:
                    System.out.print("Ingrese número de cuenta: ");
                    String buscar = sc.next();
                    Cuenta cuenta = Service.obtenerCuenta(buscar);
                    System.out.println(cuenta != null ? cuenta : "Cuenta no encontrada");
                    break;
            }
        } while (opcion != 0);
        
    }


}
