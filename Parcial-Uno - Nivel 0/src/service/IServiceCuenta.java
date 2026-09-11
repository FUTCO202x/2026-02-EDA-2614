import java.util.List;

public interface IServiceCuenta {

    List<Ahorro> listarAhorros();

    List<Corriente> listarCorrientes();

    void crearAhorro(Ahorro ahorro);

    void crearCorriente(Corriente corriente);

    Cuenta obtenerCuenta(String numeroCuenta);

    boolean retirarDinero(String numeroCuenta, double monto);

    boolean depositarDinero(String numeroCuenta, double monto);
}

