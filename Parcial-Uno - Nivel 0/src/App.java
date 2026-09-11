import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        IServiceCuenta servicio = new ServiceCuenta();

        int opcion;

        do {

            System.out.println();
            System.out.println("======================================");
            System.out.println("       SISTEMA DE CUENTAS");
            System.out.println("======================================");
            System.out.println("a. Listar todas las cuentas Ahorro");
            System.out.println("b. Listar todas las cuentas Corriente");
            System.out.println("c. Crear cuenta de Ahorro");
            System.out.println("d. Crear cuenta Corriente");
            System.out.println("e. Obtener información de una cuenta");
            System.out.println("f. Retirar Dinero");
            System.out.println("g. Depositar Dinero");
            System.out.println("h. Salir");
            System.out.println("======================================");
            System.out.print("Seleccione una opción: ");

            String entrada = scanner.nextLine();

            if (entrada.isEmpty()) {
                continue;
            }

            char opcionChar = Character.toLowerCase(entrada.charAt(0));

            switch (opcionChar) {

                // ==========================================
                // A. LISTAR AHORROS
                // ==========================================
                case 'a':

                    List<Ahorro> ahorros = servicio.listarAhorros();

                    System.out.println();
                    System.out.println("===== CUENTAS DE AHORRO =====");

                    if (ahorros.isEmpty()) {
                        System.out.println("No hay cuentas de ahorro.");
                    } else {

                        for (Ahorro ahorro : ahorros) {
                            System.out.println(ahorro);
                        }
                    }

                    break;

                // ==========================================
                // B. LISTAR CORRIENTES
                // ==========================================
                case 'b':

                    List<Corriente> corrientes = servicio.listarCorrientes();

                    System.out.println();
                    System.out.println("===== CUENTAS CORRIENTES =====");

                    if (corrientes.isEmpty()) {
                        System.out.println("No hay cuentas corrientes.");
                    } else {

                        for (Corriente corriente : corrientes) {
                            System.out.println(corriente);
                        }
                    }

                    break;

                // ==========================================
                // C. CREAR AHORRO
                // ==========================================
                case 'c':

                    System.out.println();
                    System.out.println("===== CREAR CUENTA DE AHORRO =====");

                    System.out.print("Número de cuenta: ");
                    String numeroAhorro = scanner.nextLine();

                    System.out.print("DNI del cliente: ");
                    long dniAhorro = Long.parseLong(scanner.nextLine());

                    System.out.print("Saldo inicial: ");
                    double saldoAhorro = Double.parseDouble(scanner.nextLine());

                    System.out.print("Fecha de creación (YYYY-MM-DD): ");
                    String fechaCreacion = scanner.nextLine();

                    Ahorro nuevoAhorro = new Ahorro(
                            numeroAhorro,
                            dniAhorro,
                            saldoAhorro,
                            fechaCreacion
                    );

                    servicio.crearAhorro(nuevoAhorro);

                    System.out.println("Cuenta de ahorro creada correctamente.");

                    break;

                // ==========================================
                // D. CREAR CORRIENTE
                // ==========================================
                case 'd':

                    System.out.println();
                    System.out.println("===== CREAR CUENTA CORRIENTE =====");

                    System.out.print("Número de cuenta: ");
                    String numeroCorriente = scanner.nextLine();

                    System.out.print("DNI del cliente: ");
                    long dniCorriente = Long.parseLong(scanner.nextLine());

                    System.out.print("Saldo inicial: ");
                    double saldoCorriente = Double.parseDouble(scanner.nextLine());

                    System.out.print("Impuesto: ");
                    double impuesto = Double.parseDouble(scanner.nextLine());

                    Corriente nuevaCorriente = new Corriente(
                            numeroCorriente,
                            dniCorriente,
                            saldoCorriente,
                            impuesto
                    );

                    servicio.crearCorriente(nuevaCorriente);

                    System.out.println("Cuenta corriente creada correctamente.");

                    break;

                // ==========================================
                // E. BUSCAR CUENTA
                // ==========================================
                case 'e':

                    System.out.println();
                    System.out.println("===== INFORMACIÓN DE CUENTA =====");

                    System.out.print("Número de cuenta: ");
                    String numeroBuscar = scanner.nextLine();

                    Cuenta cuentaEncontrada =
                            servicio.obtenerCuenta(numeroBuscar);

                    if (cuentaEncontrada == null) {
                        System.out.println("La cuenta no existe.");
                    } else {
                        System.out.println(cuentaEncontrada);
                    }

                    break;

                // ==========================================
                // F. RETIRAR DINERO
                // ==========================================
                case 'f':

                    System.out.println();
                    System.out.println("===== RETIRAR DINERO =====");

                    System.out.print("Número de cuenta: ");
                    String numeroRetiro = scanner.nextLine();

                    System.out.print("Monto a retirar: ");
                    double montoRetiro =
                            Double.parseDouble(scanner.nextLine());

                    boolean retiroRealizado =
                            servicio.retirarDinero(
                                    numeroRetiro,
                                    montoRetiro
                            );

                    if (retiroRealizado) {

                        System.out.println(
                                "Retiro realizado correctamente."
                        );

                        Cuenta cuenta =
                                servicio.obtenerCuenta(numeroRetiro);

                        System.out.println(
                                "Nuevo saldo: "
                                        + cuenta.getSaldoActual()
                        );

                    } else {

                        System.out.println(
                                "No se pudo realizar el retiro."
                        );

                        System.out.println(
                                "Verifique la cuenta, el monto "
                                        + "y que tenga saldo suficiente."
                        );
                    }

                    break;

                // ==========================================
                // G. DEPOSITAR DINERO
                // ==========================================
                case 'g':

                    System.out.println();
                    System.out.println("===== DEPOSITAR DINERO =====");

                    System.out.print("Número de cuenta: ");
                    String numeroDeposito = scanner.nextLine();

                    System.out.print("Monto a depositar: ");
                    double montoDeposito =
                            Double.parseDouble(scanner.nextLine());

                    boolean depositoRealizado =
                            servicio.depositarDinero(
                                    numeroDeposito,
                                    montoDeposito
                            );

                    if (depositoRealizado) {

                        System.out.println(
                                "Depósito realizado correctamente."
                        );

                        Cuenta cuenta =
                                servicio.obtenerCuenta(numeroDeposito);

                        System.out.println(
                                "Nuevo saldo: "
                                        + cuenta.getSaldoActual()
                        );

                    } else {

                        System.out.println(
                                "No se pudo realizar el depósito."
                        );

                        System.out.println(
                                "Verifique la cuenta y el monto."
                        );
                    }

                    break;

                // ==========================================
                // H. SALIR
                // ==========================================
                case 'h':

                    System.out.println(
                            "Gracias por utilizar el sistema."
                    );

                    break;

                default:

                    System.out.println(
                            "Opción inválida."
                    );
            }

        } while (entradaValida(scanner));

        scanner.close();
    }

    private static boolean entradaValida(Scanner scanner) {

        // Este método no se utiliza para controlar la opción,
        // solamente mantiene abierto el Scanner.
        return false;
    }
}

