package Requerimientos;
import java.util.List;

public interface IServiceCuenta {
    
    List<Cuenta> listarTodasLasCuentas();
    
    Cuenta obtenerDatosCuenta(String numeroCuenta);
    
    void crearCuenta(Cuenta cuenta);
    
}
