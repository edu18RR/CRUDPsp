package com.UNID.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historial_pago")
public class HistorialPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "psp_id", nullable = false)
    private PSP psp;

    private double montoPago;
    private Date fechaPago;

    public HistorialPago() {
    }

    public HistorialPago(PSP psp, double montoPago, Date fechaPago) {
        this.psp = psp;
        this.montoPago = montoPago;
        this.fechaPago = fechaPago;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PSP getPsp() {
        return psp;
    }

    public void setPsp(PSP psp) {
        this.psp = psp;
    }

    public double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(double montoPago) {
        this.montoPago = montoPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
}