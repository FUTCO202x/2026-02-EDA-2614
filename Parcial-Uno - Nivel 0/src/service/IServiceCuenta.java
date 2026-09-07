package service;

import java.util.List;

import domain.Cuenta;

public interface IServiceCuenta {
    List<Cuenta> obtenerCuentas(); // Implementar
    Cuenta obtenernumeroCuenta(String numeroCuenta); // Implementar
    void crearCuenta(Cuenta cuenta); // Implementar
    void retirarDinero(String numeroCuenta,double retiro); // Implementar
    void ingresarDinero(String numeroCuenta,double ingreso); // Implementar
}
