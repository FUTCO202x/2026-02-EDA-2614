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

    public boolean retirar(double monto) {
        if (!Double.isFinite(monto) || monto <= 0 || monto > saldoActual) {
            return false;
        }
        saldoActual -= monto;
        return true;
    }

    public boolean depositar(double monto) {
        if (!Double.isFinite(monto) || monto <= 0 || !Double.isFinite(saldoActual + monto)) {
            return false;
        }
        saldoActual += monto;
        return true;
    }

    @Override
    public String toString() {
        return "Cuenta{numeroCuenta='" + numeroCuenta + "', dniCliente=" + dniCliente
                + ", saldoActual=" + saldoActual + "}";
    }
}