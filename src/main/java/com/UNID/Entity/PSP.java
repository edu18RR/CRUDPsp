package com.UNID.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PSP")
public class PSP {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellidos;
	private String correoContacto;
	private String telefono;
	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechaInicioContratacion;

	@Temporal(TemporalType.DATE)
	private Date fechaFinContrato;

	private String proyectoAsignado;
	private double sueldo;
	private String proyectosExtra;

    @OneToMany(mappedBy = "psp", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistorialPago> historialPagos = new ArrayList<>();

	// Constructor - Hibernate
	protected PSP() {
		// Constructor vacío
	}

	// Constructor con parámetros
	public PSP(int id, String nombre, String apellidos, String correoContacto, String telefono, String estado,
			Date fechaInicioContratacion, Date fechaFinContrato, String proyectoAsignado, double sueldo,
			String proyectosExtra, String historialPago) {
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

	}
	
    public void addHistorialPago(HistorialPago historialPago) {
        historialPagos.add(historialPago);
        historialPago.setPsp(this);
    }

    public void removeHistorialPago(HistorialPago historialPago) {
        historialPagos.remove(historialPago);
        historialPago.setPsp(null);
    }
    
    // Getters y setters para la lista de historialPagos
    public List<HistorialPago> getHistorialPagos() {
        return this.historialPagos;
    }

    public void setHistorialPagos(List<HistorialPago> historialPagos) {
        this.historialPagos = historialPagos;
    }

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
  
}
