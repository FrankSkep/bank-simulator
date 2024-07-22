package Entidades;

public class CuentaBancaria {

    private int numeroCuenta;
    private double saldo;
    private int clienteId;

    // Constructor
    public CuentaBancaria(double saldo, int clienteId) {
        this.saldo = saldo;
        this.clienteId = clienteId;
    }

    // Getters y Setters
    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

}
