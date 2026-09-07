package service;

import java.util.List;

import domain.Cuenta;

public interface IServiceCuenta {
    List<Cuenta> obtenerCuentas();

    // Devuelve null si no existe ninguna cuenta con ese número
    Cuenta obtenernumeroCuenta(String numeroCuenta);

    // true si se creó, false si ya existía una cuenta con ese número
    boolean crearCuenta(Cuenta cuenta);

    // true si el retiro fue exitoso, false si la cuenta no existe
    // o si el saldo es insuficiente
    boolean retirarDinero(String numeroCuenta, double retiro);

    // true si el depósito fue exitoso, false si la cuenta no existe
    boolean ingresarDinero(String numeroCuenta, double ingreso);
}