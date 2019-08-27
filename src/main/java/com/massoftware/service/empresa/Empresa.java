package com.massoftware.service.empresa;

import com.massoftware.service.EntityId;
import com.massoftware.service.contabilidad.EjercicioContable;

public class Empresa extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Ejercicio
	private EjercicioContable ejercicioContable;

	// Fecha cierre ventas
	private java.time.LocalDate fechaCierreVentas;

	// Fecha cierre stock
	private java.time.LocalDate fechaCierreStock;

	// Fecha cierre fondo
	private java.time.LocalDate fechaCierreFondo;

	// Fecha cierre compras
	private java.time.LocalDate fechaCierreCompras;

	// Fecha cierre contabilidad
	private java.time.LocalDate fechaCierreContabilidad;

	// Fecha cierre garantia y devoluciones
	private java.time.LocalDate fechaCierreGarantiaDevoluciones;

	// Fecha cierre tambos
	private java.time.LocalDate fechaCierreTambos;

	// Fecha cierre RRHH
	private java.time.LocalDate fechaCierreRRHH;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Ejercicio
	public EjercicioContable getEjercicioContable() {
		return this.ejercicioContable;
	}

	// SET Ejercicio
	public void setEjercicioContable(EjercicioContable ejercicioContable ){
		this.ejercicioContable = ejercicioContable;
	}

	// GET Fecha cierre ventas
	public java.time.LocalDate getFechaCierreVentas() {
		return this.fechaCierreVentas;
	}

	// SET Fecha cierre ventas
	public void setFechaCierreVentas(java.time.LocalDate fechaCierreVentas ){
		this.fechaCierreVentas = fechaCierreVentas;
	}

	// GET Fecha cierre stock
	public java.time.LocalDate getFechaCierreStock() {
		return this.fechaCierreStock;
	}

	// SET Fecha cierre stock
	public void setFechaCierreStock(java.time.LocalDate fechaCierreStock ){
		this.fechaCierreStock = fechaCierreStock;
	}

	// GET Fecha cierre fondo
	public java.time.LocalDate getFechaCierreFondo() {
		return this.fechaCierreFondo;
	}

	// SET Fecha cierre fondo
	public void setFechaCierreFondo(java.time.LocalDate fechaCierreFondo ){
		this.fechaCierreFondo = fechaCierreFondo;
	}

	// GET Fecha cierre compras
	public java.time.LocalDate getFechaCierreCompras() {
		return this.fechaCierreCompras;
	}

	// SET Fecha cierre compras
	public void setFechaCierreCompras(java.time.LocalDate fechaCierreCompras ){
		this.fechaCierreCompras = fechaCierreCompras;
	}

	// GET Fecha cierre contabilidad
	public java.time.LocalDate getFechaCierreContabilidad() {
		return this.fechaCierreContabilidad;
	}

	// SET Fecha cierre contabilidad
	public void setFechaCierreContabilidad(java.time.LocalDate fechaCierreContabilidad ){
		this.fechaCierreContabilidad = fechaCierreContabilidad;
	}

	// GET Fecha cierre garantia y devoluciones
	public java.time.LocalDate getFechaCierreGarantiaDevoluciones() {
		return this.fechaCierreGarantiaDevoluciones;
	}

	// SET Fecha cierre garantia y devoluciones
	public void setFechaCierreGarantiaDevoluciones(java.time.LocalDate fechaCierreGarantiaDevoluciones ){
		this.fechaCierreGarantiaDevoluciones = fechaCierreGarantiaDevoluciones;
	}

	// GET Fecha cierre tambos
	public java.time.LocalDate getFechaCierreTambos() {
		return this.fechaCierreTambos;
	}

	// SET Fecha cierre tambos
	public void setFechaCierreTambos(java.time.LocalDate fechaCierreTambos ){
		this.fechaCierreTambos = fechaCierreTambos;
	}

	// GET Fecha cierre RRHH
	public java.time.LocalDate getFechaCierreRRHH() {
		return this.fechaCierreRRHH;
	}

	// SET Fecha cierre RRHH
	public void setFechaCierreRRHH(java.time.LocalDate fechaCierreRRHH ){
		this.fechaCierreRRHH = fechaCierreRRHH;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getEjercicioContable() != null && this.getFechaCierreVentas() != null){
			return this.getEjercicioContable() + " - " +  this.getFechaCierreVentas();
		} else if(this.getEjercicioContable() != null && this.getFechaCierreVentas() == null){
			return this.getEjercicioContable().toString();
		} else if(this.getEjercicioContable() == null && this.getFechaCierreVentas() != null){
			return this.getFechaCierreVentas().toString();
		} else {
			return super.toString();
		}
	}
		
	public Empresa clone() {
		
		Empresa other = (Empresa) super.clone();
		
		other.setId(this.getId());
		
		// -------------------------------------------------------------------
		
		if (this.getEjercicioContable() != null) {
			other.setEjercicioContable(this.getEjercicioContable().clone());
		}
		other.setFechaCierreVentas(this.getFechaCierreVentas());
		other.setFechaCierreStock(this.getFechaCierreStock());
		other.setFechaCierreFondo(this.getFechaCierreFondo());
		other.setFechaCierreCompras(this.getFechaCierreCompras());
		other.setFechaCierreContabilidad(this.getFechaCierreContabilidad());
		other.setFechaCierreGarantiaDevoluciones(this.getFechaCierreGarantiaDevoluciones());
		other.setFechaCierreTambos(this.getFechaCierreTambos());
		other.setFechaCierreRRHH(this.getFechaCierreRRHH());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------