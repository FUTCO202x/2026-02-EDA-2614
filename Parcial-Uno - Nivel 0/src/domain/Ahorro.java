public class Ahorro extends Cuenta {

    private String fechaCreacion;

    // Constructor vacío
    public Ahorro() {
        super();
    }

    // Constructor con todos los atributos
    public Ahorro(String numeroCuenta, long dniCliente, double saldoActual,
                  String fechaCreacion) {

        super(numeroCuenta, dniCliente, saldoActual);
        this.fechaCreacion = fechaCreacion;
    }

    // Getter y Setter
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    // toString con los atributos heredados
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
