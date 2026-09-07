package models;

public class Cuenta {
    private String numeroCuenta;
    private long dniCliente;
    private double saldoCuenta;

    public Cuenta(String numeroCuenta, long dniCliente, double saldoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.dniCliente = dniCliente;
        this.saldoCuenta = saldoCuenta;
    }

    public Cuenta() {

    }

    public long getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(long dniCliente) {
        this.dniCliente = dniCliente;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

}
