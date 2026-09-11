package service;

import java.util.List;

import domain.Cuenta;

public interface IServiceCuenta {
    List<Cuenta> obtenerCuentas();
    Cuenta obtenerCuenta(String numeroCuenta);
    void crearCuenta(Cuenta cuenta);


   
}