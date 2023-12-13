package com.UNID.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class HistorialPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private double sueldoActual;
    @Temporal(TemporalType.DATE)
    private Date fechaDePago;
    private double pagoActual;
    private double pagoAnterior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "psp_id")
    private PSP psp;

    // Constructor para JPA
    public HistorialPago() {}

    // Constructor
    public HistorialPago(String nombre, double sueldoActual, Date fechaDePago, double pagoActual, double pagoAnterior, PSP psp) {
        this.nombre = nombre;
        this.sueldoActual = sueldoActual;
        this.fechaDePago = fechaDePago;
        this.pagoActual = pagoActual;
        this.pagoAnterior = pagoAnterior;
        this.psp = psp;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoActual() {
        return sueldoActual;
    }

    public void setSueldoActual(double sueldoActual) {
        this.sueldoActual = sueldoActual;
    }

    public Date getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(Date fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    public double getPagoActual() {
        return pagoActual;
    }

    public void setPagoActual(double pagoActual) {
        this.pagoActual = pagoActual;
    }

    public double getPagoAnterior() {
        return pagoAnterior;
    }

    public void setPagoAnterior(double pagoAnterior) {
        this.pagoAnterior = pagoAnterior;
    }

    public PSP getPsp() {
        return psp;
    }

    public void setPsp(PSP psp) {
        this.psp = psp;
    }
}
