package service;

import domain.Ahorro;
import domain.Corriente;
import domain.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class ServiceCuenta implements IServiceCuenta {
    private List<Ahorro> cuentasAhorro = new ArrayList<>();
    private List<Corriente> cuentasCorriente = new ArrayList<>();

    @Override
    public List<Ahorro> listarAhorros() {
        return cuentasAhorro;
    }

    @Override
    public List<Corriente> listarCorrientes() {
        return cuentasCorriente;
    }

    @Override
    public void crearAhorro(Ahorro ahorro) {
        cuentasAhorro.add(ahorro);
    }

    @Override
    public void crearCorriente(Corriente corriente) {
        cuentasCorriente.add(corriente);
    }

    @Override
    public Cuenta obtenerCuentaPorNumero(String numeroCuenta) {
        for (Ahorro a : cuentasAhorro) {
            if (a.getNumeroCuenta().equals(numeroCuenta)) return a;
        }
        for (Corriente c : cuentasCorriente) {
            if (c.getNumeroCuenta().equals(numeroCuenta)) return c;
        }
        return null;
    }

    @Override
    public boolean retirarDinero(String numeroCuenta, double monto) {
        Cuenta cuenta = obtenerCuentaPorNumero(numeroCuenta);
        if (cuenta == null || cuenta.getSaldoActual() < monto) return false;
        cuenta.setSaldoActual(cuenta.getSaldoActual() - monto);
        return true;
    }

    @Override
    public boolean depositarDinero(String numeroCuenta, double monto) {
        Cuenta cuenta = obtenerCuentaPorNumero(numeroCuenta);
        if (cuenta == null) return false;
        cuenta.setSaldoActual(cuenta.getSaldoActual() + monto);
        return true;
    }
}