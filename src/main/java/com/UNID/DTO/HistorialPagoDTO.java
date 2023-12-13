package com.UNID.DTO;

import java.util.Date;

public class HistorialPagoDTO {
	private int id;
	private String nombre;
	private double sueldoActual;
	private Date fechaDePago;
	private double pagoActual;
	private double pagoAnterior;
	private Integer pspId;

    // Constructor vacío para JPA y otras bibliotecas
	public HistorialPagoDTO() {
	}

    // Constructor con parámetros
	public HistorialPagoDTO(int id, String nombre, double sueldoActual, Date fechaDePago, double pagoActual,
			double pagoAnterior, Integer pspId) {
		this.id = id;
		this.nombre = nombre;
		this.sueldoActual = sueldoActual;
		this.fechaDePago = fechaDePago;
		this.pagoActual = pagoActual;
		this.pagoAnterior = pagoAnterior;
		this.pspId = pspId;
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
	
    public Integer getPspId() {
        return pspId;
    }

    public void setPspId(Integer pspId) {
        this.pspId = pspId;
    }

}