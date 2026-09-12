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

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
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

    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldoActual) {
            saldoActual -= monto;
            return true;
        }
        return false;
    }

    public boolean depositar(double monto) {
        if (monto > 0) {
            saldoActual += monto;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "numeroCuenta=" + numeroCuenta +
               ", dniCliente=" + dniCliente +
               ", saldoActual=" + saldoActual;
    }
}
