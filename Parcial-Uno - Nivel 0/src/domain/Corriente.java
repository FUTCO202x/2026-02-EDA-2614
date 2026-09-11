package domain;

public class Corriente extends Cuenta{
    private double impuesto;

    public Corriente(String numeroCuenta, long dniCliente, double saldoActual, double impuesto) {
        super(numeroCuenta, dniCliente, saldoActual);
        this.impuesto = impuesto;
    }

    public Corriente() {
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    
    public String toString() {
        return "Corriente [numeroCuenta=" + getNumeroCuenta() + ", dniCliente=" + getDniCliente()
                + ", saldoActual=" + getSaldoActual() + ", impuesto=" + impuesto + "]";
    }
}