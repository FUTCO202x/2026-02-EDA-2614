package domain;

public class Cuenta {
    private String numeroCuenta;
    private long dniCliente;
    private double saldoActual;

    public Cuenta() {
    }

    public Cuenta(String numeroCuenta, long dniCliente, double saldoActual) {
        this.numeroCuenta = numeroCuenta;
        this.dniCliente = dniCliente;
        this.saldoActual = saldoActual;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public long getDniCliente() {
        return dniCliente;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public boolean retirar(double monto) {
        if (monto <= 0 || monto > saldoActual) {
            return false;
        }
        saldoActual -= monto;
        return true;
    }

    public boolean depositar(double monto) {
        if (monto <= 0) {
            return false;
        }
        saldoActual += monto;
        return true;
    }
}