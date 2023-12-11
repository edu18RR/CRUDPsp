package com.UNID.DTO;

import java.util.Date;

public class PSPDTO {
    private int id;
    private String nombre;
    private String apellidos;
    private String correoContacto;
    private String telefono;
    private String estado;
    private Date fechaInicioContratacion;
    private Date fechaFinContrato;
    private String proyectoAsignado;
    private double sueldo;
    private String proyectosExtra;
    private String historialPago;

    // Constructor con todos los campos
    public PSPDTO(int id, String nombre, String apellidos, String correoContacto, String telefono, String estado, Date fechaInicioContratacion, Date fechaFinContrato, String proyectoAsignado, double sueldo, String proyectosExtra, String historialPago) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoContacto = correoContacto;
        this.telefono = telefono;
        this.estado = estado;
        this.fechaInicioContratacion = fechaInicioContratacion;
        this.fechaFinContrato = fechaFinContrato;
        this.proyectoAsignado = proyectoAsignado;
        this.sueldo = sueldo;
        this.proyectosExtra = proyectosExtra;
        this.historialPago = historialPago;
        
        
    }

    // Getters y setters para todos los campos
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoContacto() {
        return correoContacto;
    }

    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaInicioContratacion() {
        return fechaInicioContratacion;
    }

    public void setFechaInicioContratacion(Date fechaInicioContratacion) {
        this.fechaInicioContratacion = fechaInicioContratacion;
    }

    public Date getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(Date fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    public String getProyectoAsignado() {
        return proyectoAsignado;
    }

    public void setProyectoAsignado(String proyectoAsignado) {
        this.proyectoAsignado = proyectoAsignado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getProyectosExtra() {
        return proyectosExtra;
    }

    public void setProyectosExtra(String proyectosExtra) {
        this.proyectosExtra = proyectosExtra;
    }

    public String getHistorialPago() {
        return historialPago;
    }

    public void setHistorialPago(String historialPago) {
        this.historialPago = historialPago;
    }

}
