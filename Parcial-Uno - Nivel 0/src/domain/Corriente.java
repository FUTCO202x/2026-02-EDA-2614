package domain;

public class Corriente extends Cuenta{

    private double impuesto;

    public Corriente() {
        super();
    }

    public Corriente(String numeroCuenta, long dniCliente, double saldoActual, double impuesto) {
        super(numeroCuenta, dniCliente, saldoActual);
        this.impuesto = impuesto;
    }
    
    public double getImpuesto() {
        return impuesto;
    
    }

    public void setImpuesto(double impuesto){
        this.impuesto = impuesto;
    }
    
    @Override
	public String toString() {
		return "Corriente [" + super.toString() + ", impuesto=" + impuesto + "]";
	}

}
