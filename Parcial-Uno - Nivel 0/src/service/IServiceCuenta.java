package service;

import java.util.List;

import domain.Cuenta;

public interface IServiceCuenta {

	List<Cuenta> obtenerCuentas();

	Cuenta obtenernumeroCuenta(String numeroCuenta);

	boolean crearCuenta(Cuenta cuenta);

	boolean retirarDinero(String numeroCuenta, double monto);

	boolean ingresarDinero(String numeroCuenta, double monto);

}
