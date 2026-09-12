package models;

import java.util.List;

public interface IServiceCuenta {

    List<Cuenta> listarCuentas();

    Cuenta obtenerDatosCuenta(String numeroCuenta);

    void crearCuenta(Cuenta cuenta);
}