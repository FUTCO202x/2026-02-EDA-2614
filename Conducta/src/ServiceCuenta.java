package Requerimientos;

import java.util.ArrayList;
import java.util.List;


public class ServiceCuenta implements IServiceCuenta {
    
    private List<Cuenta> cuentas;

    public ServiceCuenta() {
        cuentas = new ArrayList<>();
    }

    
    
    @Override
    public List<Cuenta> listarTodasLasCuentas() {
        return cuentas;
    }

    @Override
    public Cuenta obtenerDatosCuenta(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    @Override
    public void crearCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
    
}
