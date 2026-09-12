package domain;

public class Ahorro extends Cuenta {
    private String fechaCreacion;

    public Ahorro() {
        super();
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
        return "Ahorro [" + super.toString() +
               ", fechaCreacion=" + fechaCreacion + "]";
    }
}
