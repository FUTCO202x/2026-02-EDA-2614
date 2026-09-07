package service;

import java.util.ArrayList;
import java.util.List;

import domain.Ahorro;
import domain.Corriente;
import domain.Cuenta;

public class ServiceCuenta implements IServiceCuenta {

    private final List<Cuenta> cuentas = new ArrayList<>();

    public ServiceCuenta() {
        cuentas.add(new Ahorro("1001", 123, 1500.00,"2024-09-22"));
        cuentas.add(new Corriente("1002", 124, 2000.00,0.3));
        cuentas.add(new Corriente("1003", 125, 500.00,0.5));
        cuentas.add(new Corriente("1004", 126, 750.00,0.7));
        cuentas.add(new Ahorro("1005", 127, 3000.00,"2024-10-22"));
        cuentas.add(new Ahorro("1005", 127, 3000.00,"2024-10-22"));
        cuentas.add(new Ahorro("1005", 127, 3000.00,"2024-10-22"));
        cuentas.add(new Ahorro("1006", 128, 1200.00,"2023-12-02"));
        cuentas.add(new Ahorro("1007", 129, 1800.00,"2023-12-00"));
        cuentas.add(new Ahorro("1008", 130, 950.00,"2024-2009"));
        cuentas.add(new Ahorro("1009", 131, 4000.00,"2024-12-22"));
        cuentas.add(new Corriente("1010", 132, 600.00,0.4));
        cuentas.add(new Corriente("1011", 133, 2200.00,0.5));
        cuentas.add(new Corriente("1012", 134, 3300.00,0.5));
        cuentas.add(new Corriente("1013", 135, 1100.00,0.5));
        cuentas.add(new Corriente("1014", 136, 2700.00,0.3));
        cuentas.add(new Ahorro("1015", 137, 800.00,"2025-05-05"));
        cuentas.add(new Corriente("1016", 138, 1600.00,03));
        cuentas.add(new Corriente("1017", 139, 2500.00,0.3));
        cuentas.add(new Ahorro("1018", 140, 1000.00,"2024-11-05"));
        cuentas.add(new Ahorro("1019", 141, 1900.00,"2025-01-10"));
        cuentas.add(new Corriente("1020", 142, 2900.00,0.3));
    }

    @Override
    public List<Cuenta> obtenerCuentas() {
        return cuentas;
    }

}
