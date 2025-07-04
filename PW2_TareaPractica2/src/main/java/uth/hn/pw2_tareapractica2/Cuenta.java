package uth.hn.pw2_tareapractica2;

public class Cuenta {
    private String cuenta;
    private String pin;
    private String nombre;
    private double saldo;

    public Cuenta() {
        this.cuenta = "sin cuenta";
        this.pin = "sin pin";
        this.nombre = "sin nombre";
        this.saldo = 0;
    }

    public Cuenta(String cuenta, String pin, String nombre, double saldo) {
        this.cuenta = cuenta;
        this.pin = pin;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
