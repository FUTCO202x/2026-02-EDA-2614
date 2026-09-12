import java.util.List;
import java.util.Scanner;

import domain.Ahorro;
import domain.Corriente;
import domain.Cuenta;
import service.ServiceCuenta;

public class App {

	public static void main(String[] args) throws Exception {

		ServiceCuenta serviceCuenta = new ServiceCuenta();
		Scanner scanner = new Scanner(System.in);
		boolean salir = false;

		while (!salir) {
			mostrarMenu();
			String opcion = scanner.nextLine().trim().toLowerCase();

			switch (opcion) {
			case "a":
				listarAhorros(serviceCuenta);
				break;
			case "b":
				listarCorrientes(serviceCuenta);
				break;
			case "c":
				crearCuentaAhorro(serviceCuenta, scanner);
				break;
			case "d":
				crearCuentaCorriente(serviceCuenta, scanner);
				break;
			case "e":
				obtenerInformacionCuenta(serviceCuenta, scanner);
				break;
			case "f":
				retirarDinero(serviceCuenta, scanner);
				break;
			case "g":
				depositarDinero(serviceCuenta, scanner);
				break;
			case "h":
				salir = true;
				System.out.println("Saliendo de la aplicacion...");
				break;
			default:
				System.out.println("Opcion invalida, intente de nuevo.");
			}
			System.out.println();
		}

		scanner.close();
	}

	private static void mostrarMenu() {
		System.out.println("=========== MENU CUENTAS ===========");
		System.out.println("a. Listar todas las cuentas Ahorro");
		System.out.println("b. Listar todas las cuentas Corriente");
		System.out.println("c. Crear cuenta de Ahorro");
		System.out.println("d. Crear cuenta Corriente");
		System.out.println("e. Obtener la informacion de la cuenta por numero");
		System.out.println("f. Retirar Dinero");
		System.out.println("g. Depositar Dinero");
		System.out.println("h. Salir");
		System.out.print("Seleccione una opcion: ");
	}

	private static void listarAhorros(ServiceCuenta serviceCuenta) {
		List<Cuenta> cuentas = serviceCuenta.obtenerCuentas();
		System.out.println("--- Cuentas de Ahorro ---");
		for (Cuenta cuenta : cuentas) {
			if (cuenta instanceof Ahorro) {
				System.out.println(cuenta);
			}
		}
	}

	private static void listarCorrientes(ServiceCuenta serviceCuenta) {
		List<Cuenta> cuentas = serviceCuenta.obtenerCuentas();
		System.out.println("--- Cuentas Corriente ---");
		for (Cuenta cuenta : cuentas) {
			if (cuenta instanceof Corriente) {
				System.out.println(cuenta);
			}
		}
	}

	private static void crearCuentaAhorro(ServiceCuenta serviceCuenta, Scanner scanner) {
		System.out.print("Numero de cuenta: ");
		String numeroCuenta = scanner.nextLine().trim();

		System.out.print("DNI del cliente: ");
		long dniCliente = Long.parseLong(scanner.nextLine().trim());

		System.out.print("Saldo inicial: ");
		double saldoActual = Double.parseDouble(scanner.nextLine().trim());

		System.out.print("Fecha de creacion (aaaa-mm-dd): ");
		String fechaCreacion = scanner.nextLine().trim();

		Ahorro ahorro = new Ahorro(numeroCuenta, dniCliente, saldoActual, fechaCreacion);
		boolean creada = serviceCuenta.crearCuenta(ahorro);

		if (creada) {
			System.out.println("Cuenta de Ahorro creada correctamente.");
		} else {
			System.out.println("No se pudo crear la cuenta. Verifique que el numero no exista.");
		}
	}

	private static void crearCuentaCorriente(ServiceCuenta serviceCuenta, Scanner scanner) {
		System.out.print("Numero de cuenta: ");
		String numeroCuenta = scanner.nextLine().trim();

		System.out.print("DNI del cliente: ");
		long dniCliente = Long.parseLong(scanner.nextLine().trim());

		System.out.print("Saldo inicial: ");
		double saldoActual = Double.parseDouble(scanner.nextLine().trim());

		System.out.print("Impuesto: ");
		double impuesto = Double.parseDouble(scanner.nextLine().trim());

		Corriente corriente = new Corriente(numeroCuenta, dniCliente, saldoActual, impuesto);
		boolean creada = serviceCuenta.crearCuenta(corriente);

		if (creada) {
			System.out.println("Cuenta Corriente creada correctamente.");
		} else {
			System.out.println("No se pudo crear la cuenta. Verifique que el numero no exista.");
		}
	}

	private static void obtenerInformacionCuenta(ServiceCuenta serviceCuenta, Scanner scanner) {
		System.out.print("Ingrese el numero de cuenta: ");
		String numeroCuenta = scanner.nextLine().trim();

		Cuenta cuenta = serviceCuenta.obtenernumeroCuenta(numeroCuenta);
		if (cuenta != null) {
			System.out.println(cuenta);
		} else {
			System.out.println("No existe una cuenta con ese numero.");
		}
	}

	private static void retirarDinero(ServiceCuenta serviceCuenta, Scanner scanner) {
		System.out.print("Ingrese el numero de cuenta: ");
		String numeroCuenta = scanner.nextLine().trim();

		System.out.print("Monto a retirar: ");
		double monto = Double.parseDouble(scanner.nextLine().trim());

		boolean exito = serviceCuenta.retirarDinero(numeroCuenta, monto);
		if (exito) {
			System.out.println("Retiro realizado con exito.");
		} else {
			System.out.println("No se pudo realizar el retiro (cuenta inexistente o saldo insuficiente).");
		}
	}

	private static void depositarDinero(ServiceCuenta serviceCuenta, Scanner scanner) {
		System.out.print("Ingrese el numero de cuenta: ");
		String numeroCuenta = scanner.nextLine().trim();

		System.out.print("Monto a depositar: ");
		double monto = Double.parseDouble(scanner.nextLine().trim());

		boolean exito = serviceCuenta.ingresarDinero(numeroCuenta, monto);
		if (exito) {
			System.out.println("Deposito realizado con exito.");
		} else {
			System.out.println("No se pudo realizar el deposito.");
		}
	}

}