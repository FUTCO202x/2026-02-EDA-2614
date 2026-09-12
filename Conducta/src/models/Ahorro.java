package models;

public class Ahorro extends Cuenta {

    private String fechaCreacion;

    public Ahorro() {
        super();
    }

    public Ahorro(String numeroCuenta, long dniCliente, double saldoCuenta, String fechaCreacion) {
        super(numeroCuenta, dniCliente, saldoCuenta);
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
        return "Ahorro [numeroCuenta=" + getNumeroCuenta()
                + ", dniCliente=" + getDniCliente()
                + ", saldoCuenta=" + getSaldoCuenta()
                + ", fechaCreacion=" + fechaCreacion + "]";
    }
}
