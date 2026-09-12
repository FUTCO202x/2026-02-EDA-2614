package models;

public class Corriente extends Cuenta {

    private double impuesto;

    public Corriente() {
        super();
    }

    public Corriente(String numeroCuenta, long dniCliente, double saldoCuenta, double impuesto) {
        super(numeroCuenta, dniCliente, saldoCuenta);
        this.impuesto = impuesto;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    @Override
    public String toString() {
        return "Corriente [numeroCuenta=" + getNumeroCuenta()
                + ", dniCliente=" + getDniCliente()
                + ", saldoCuenta=" + getSaldoCuenta()
                + ", impuesto=" + impuesto + "]";
    }
}
