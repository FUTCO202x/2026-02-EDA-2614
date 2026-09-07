import models.Cuenta;

public class App {
    public static void main(String[] args) throws Exception {
        Cuenta cuenta=new Cuenta();
        cuenta.setNumeroCuenta("12345");
        cuenta.setDniCliente(987654321);
        cuenta.setSaldoCuenta(50000);

        System.out.println(cuenta.getNumeroCuenta());
        System.out.println(cuenta.getDniCliente());
        System.out.println(cuenta.getSaldoCuenta());

        Cuenta cuenta2=new Cuenta("555-888",88899,150000);
    }
}
