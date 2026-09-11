package domain;

public class Ahorro extends Cuenta {

    private String fechaCreacion;

    public Ahorro() {
        super("", 0, 0.0);
        this.fechaCreacion = "";
    }

    public Ahorro(String numeroCuenta, long dniCliente, double saldoActual, String fechaCreacion) {
        super(numeroCuenta, dniCliente, saldoActual);
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    @Override
    public String toString() {
        return "Ahorro{" +
                "numeroCuenta='" + getNumeroCuenta() + '\'' +
                ", dniCliente=" + getDniCliente() +
                ", saldoActual=" + getSaldoActual() +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                '}';
    }
}