import java.util.ArrayList;
import java.util.List;

public class ServiceCuenta implements IServiceCuenta {

    private final List<Cuenta> cuentas = new ArrayList<>();

    // Constructor
    public ServiceCuenta() {

        // Cuentas de ejemplo
        cuentas.add(new Ahorro(
                "530012345601",
                1002345678L,
                2450000.00,
                "2023-03-14"
        ));

        cuentas.add(new Ahorro(
                "530012345602",
                1002345911L,
                875300.50,
                "2024-07-02"
        ));

        cuentas.add(new Ahorro(
                "530012345603",
                1003456789L,
                12300000.00,
                "2022-11-30"
        ));

        cuentas.add(new Ahorro(
                "530012345604",
                1004567890L,
                150000.00,
                "2025-01-08"
        ));

        cuentas.add(new Ahorro(
                "530012345605",
                1005678901L,
                5620.75,
                "2021-06-19"
        ));

        cuentas.add(new Ahorro(
                "530012345606",
                1006789012L,
                980000.00,
                "2024-09-27"
        ));

        cuentas.add(new Ahorro(
                "530012345607",
                1007890123L,
                3100000.00,
                "2023-12-05"
        ));

        cuentas.add(new Ahorro(
                "530012345608",
                1008901234L,
                45000.00,
                "2025-04-11"
        ));

        // Cuentas corrientes
        cuentas.add(new Corriente(
                "770098765401",
                1009012345L,
                8750000.00,
                0.004
        ));

        cuentas.add(new Corriente(
                "770098765402",
                1010123456L,
                1230500.00,
                0.004
        ));

        cuentas.add(new Corriente(
                "770098765403",
                10111234567L,
                22400000.00,
                0.004
        ));

        cuentas.add(new Corriente(
                "770098765404",
                1012345678L,
                690000.00,
                0.004
        ));

        cuentas.add(new Corriente(
                "770098765405",
                1013456789L,
                3580000.00,
                0.004
        ));

        cuentas.add(new Corriente(
                "770098765406",
                1014567890L,
                15900000.00,
                0.004
        ));

        cuentas.add(new Corriente(
                "770098765407",
                1015678901L,
                260000.00,
                0.004
        ));

        cuentas.add(new Corriente(
                "770098765408",
                1016789012L,
                9050000.00,
                0.004
        ));
    }

    // Listar cuentas de ahorro
    @Override
    public List<Ahorro> listarAhorros() {

        List<Ahorro> ahorros = new ArrayList<>();

        for (Cuenta cuenta : cuentas) {
            if (cuenta instanceof Ahorro) {
                ahorros.add((Ahorro) cuenta);
            }
        }

        return ahorros;
    }

    // Listar cuentas corrientes
    @Override
    public List<Corriente> listarCorrientes() {

        List<Corriente> corrientes = new ArrayList<>();

        for (Cuenta cuenta : cuentas) {
            if (cuenta instanceof Corriente) {
                corrientes.add((Corriente) cuenta);
            }
        }

        return corrientes;
    }

    // Crear cuenta de ahorro
    @Override
    public void crearAhorro(Ahorro ahorro) {
        cuentas.add(ahorro);
    }

    // Crear cuenta corriente
    @Override
    public void crearCorriente(Corriente corriente) {
        cuentas.add(corriente);
    }

    // Buscar cuenta por número
    @Override
    public Cuenta obtenerCuenta(String numeroCuenta) {

        for (Cuenta cuenta : cuentas) {

            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }

        return null;
    }

    // Retirar dinero
    @Override
    public boolean retirarDinero(String numeroCuenta, double monto) {

        if (monto <= 0) {
            return false;
        }

        Cuenta cuenta = obtenerCuenta(numeroCuenta);

        if (cuenta == null) {
            return false;
        }

        if (cuenta.getSaldoActual() < monto) {
            return false;
        }

        cuenta.setSaldoActual(cuenta.getSaldoActual() - monto);

        return true;
    }

    // Depositar dinero
    @Override
    public boolean depositarDinero(String numeroCuenta, double monto) {

        if (monto <= 0) {
            return false;
        }

        Cuenta cuenta = obtenerCuenta(numeroCuenta);

        if (cuenta == null) {
            return false;
        }

        cuenta.setSaldoActual(cuenta.getSaldoActual() + monto);

        return true;
    }
}
