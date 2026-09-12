package models;

public class Cuenta {

    private String numeroCuenta;
    private long dniCliente;
    private double saldoActual;

    public Cuenta(String numeroCuenta, long dniCliente, double saldoActual) {
        this.numeroCuenta = numeroCuenta;
        this.dniCliente = dniCliente;
        this.saldoActual = saldoActual;
    }

    public Cuenta() {
    }

    public long getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(long dniCliente) {
        this.dniCliente = dniCliente;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }
}