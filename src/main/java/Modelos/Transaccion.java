package Modelos;

import java.time.LocalDateTime;

public class Transaccion {
    
    private int idCuentaBancaria;
    private LocalDateTime fecha;
    private String tipo; // (Deposito, Retiro o Transferencia)
    private double monto;
    private String descripcion;
    

    // Constructor
    public Transaccion(int idCuenta, LocalDateTime fecha, String tipo, double monto, String descripcion) {
        this.idCuentaBancaria = idCuenta;
        this.fecha = fecha;
        this.tipo = tipo;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getNumCuenta() {
        return idCuentaBancaria;
    }

    public void setNumCuenta(int numCuenta) {
        this.idCuentaBancaria = numCuenta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
