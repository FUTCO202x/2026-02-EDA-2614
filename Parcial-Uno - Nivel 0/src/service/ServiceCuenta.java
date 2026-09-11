package service;

import java.util.ArrayList;
import java.util.List;

import domain.Ahorro;
import domain.Corriente;
import domain.Cuenta;

public class ServiceCuenta implements IServiceCuenta {

    private final List<Cuenta> cuentas = new ArrayList<>();

    public ServiceCuenta() {
        cuentas.add(new Ahorro("530012345601", 1002345678, 2_450_000.00, "2023-03-14"));
        cuentas.add(new Ahorro("530012345602", 1002345911, 875_300.50, "2024-07-02"));
        cuentas.add(new Ahorro("530012345603", 1003456789, 12_300_000.00, "2022-11-30"));
        cuentas.add(new Ahorro("530012345604", 1004567890, 150_000.00, "2025-01-08"));
        cuentas.add(new Ahorro("530012345605", 1005678901, 5_620_750.25, "2021-06-19"));
        cuentas.add(new Ahorro("530012345606", 1006789012, 980_000.00, "2024-09-27"));
        cuentas.add(new Ahorro("530012345607", 1007890123, 3_100_000.00, "2023-12-05"));
        cuentas.add(new Ahorro("530012345608", 1008901234, 45_000.00, "2025-04-11"));

        cuentas.add(new Corriente("770098765401", 1009012345, 8_750_000.00, 0.004));
        cuentas.add(new Corriente("770098765402", 1010123456, 1_230_500.00, 0.004));
        cuentas.add(new Corriente("770098765403", 1011234567, 22_400_000.00, 0.004));
        cuentas.add(new Corriente("770098765404", 1012345678, 690_000.00, 0.004));
        cuentas.add(new Corriente("770098765405", 1013456789, 3_500_000.00, 0.004));
        cuentas.add(new Corriente("770098765406", 1014567890, 15_900_000.00, 0.004));
        cuentas.add(new Corriente("770098765407", 1015678901, 260_000.00, 0.004));
        cuentas.add(new Corriente("770098765408", 1016789012, 9_050_000.00, 0.004));
    }

    @Override
    public List<Cuenta> obtenerCuentas() {
        return cuentas;
    }

    @Override
    public Cuenta obtenernumeroCuenta(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    @Override
    public boolean crearCuenta(Cuenta cuenta) {
        if (obtenernumeroCuenta(cuenta.getNumeroCuenta()) != null) {
            return false;
        }
        cuentas.add(cuenta);
        return true;
    }

    @Override
    public boolean retirarDinero(String numeroCuenta, double retiro) {
        Cuenta cuenta = obtenernumeroCuenta(numeroCuenta);
        if (cuenta == null) {
            return false;
        }
        return cuenta.retirar(retiro);
    }

    @Override
    public boolean ingresarDinero(String numeroCuenta, double ingreso) {
        Cuenta cuenta = obtenernumeroCuenta(numeroCuenta);
        if (cuenta == null) {
            return false;
        }
        return cuenta.depositar(ingreso);
    }
}