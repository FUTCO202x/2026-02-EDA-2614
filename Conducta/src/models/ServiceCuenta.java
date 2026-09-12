package models;

import java.util.ArrayList;
import java.util.List;

public class ServiceCuenta implements IServiceCuenta {

    private final List<Cuenta> cuentas;

    public ServiceCuenta() {
        this.cuentas = new ArrayList<>();
    }

    @Override
    public List<Cuenta> listarCuentas() {
        return cuentas;
    }

    @Override
    public Cuenta obtenerDatosCuenta(String numeroCuenta) {
        for (Cuenta c : cuentas) {
            if (c.getNumeroCuenta() != null && c.getNumeroCuenta().equals(numeroCuenta)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void crearCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
}

