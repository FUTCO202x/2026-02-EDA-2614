package service;

import java.util.List;
import models.Cuenta;

public interface IServiceCuenta {

    List<Cuenta> ListarCuenta();

    Cuenta obtenerCuenta(String numeroCuenta);

    void crearCuenta(Cuenta cuenta);
}