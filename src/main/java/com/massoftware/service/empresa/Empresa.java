package com.massoftware.service.empresa;

import com.massoftware.model.EntityId;
import com.massoftware.service.contabilidad.EjercicioContable;

public class Empresa extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Ejercicio
	private EjercicioContable ejercicioContable;

	// Fecha cierre ventas
	private java.util.Date fechaCierreVentas;

	// Fecha cierre stock
	private java.util.Date fechaCierreStock;

	// Fecha cierre fondo
	private java.util.Date fechaCierreFondo;

	// Fecha cierre compras
	private java.util.Date fechaCierreCompras;

	// Fecha cierre contabilidad
	private java.util.Date fechaCierreContabilidad;

	// Fecha cierre garantia y devoluciones
	private java.util.Date fechaCierreGarantiaDevoluciones;

	// Fecha cierre tambos
	private java.util.Date fechaCierreTambos;

	// Fecha cierre RRHH
	private java.util.Date fechaCierreRRHH;

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
	public java.util.Date getFechaCierreVentas() {
		return this.fechaCierreVentas;
	}

	// SET Fecha cierre ventas
	public void setFechaCierreVentas(java.util.Date fechaCierreVentas ){
		this.fechaCierreVentas = fechaCierreVentas;
	}

	// GET Fecha cierre stock
	public java.util.Date getFechaCierreStock() {
		return this.fechaCierreStock;
	}

	// SET Fecha cierre stock
	public void setFechaCierreStock(java.util.Date fechaCierreStock ){
		this.fechaCierreStock = fechaCierreStock;
	}

	// GET Fecha cierre fondo
	public java.util.Date getFechaCierreFondo() {
		return this.fechaCierreFondo;
	}

	// SET Fecha cierre fondo
	public void setFechaCierreFondo(java.util.Date fechaCierreFondo ){
		this.fechaCierreFondo = fechaCierreFondo;
	}

	// GET Fecha cierre compras
	public java.util.Date getFechaCierreCompras() {
		return this.fechaCierreCompras;
	}

	// SET Fecha cierre compras
	public void setFechaCierreCompras(java.util.Date fechaCierreCompras ){
		this.fechaCierreCompras = fechaCierreCompras;
	}

	// GET Fecha cierre contabilidad
	public java.util.Date getFechaCierreContabilidad() {
		return this.fechaCierreContabilidad;
	}

	// SET Fecha cierre contabilidad
	public void setFechaCierreContabilidad(java.util.Date fechaCierreContabilidad ){
		this.fechaCierreContabilidad = fechaCierreContabilidad;
	}

	// GET Fecha cierre garantia y devoluciones
	public java.util.Date getFechaCierreGarantiaDevoluciones() {
		return this.fechaCierreGarantiaDevoluciones;
	}

	// SET Fecha cierre garantia y devoluciones
	public void setFechaCierreGarantiaDevoluciones(java.util.Date fechaCierreGarantiaDevoluciones ){
		this.fechaCierreGarantiaDevoluciones = fechaCierreGarantiaDevoluciones;
	}

	// GET Fecha cierre tambos
	public java.util.Date getFechaCierreTambos() {
		return this.fechaCierreTambos;
	}

	// SET Fecha cierre tambos
	public void setFechaCierreTambos(java.util.Date fechaCierreTambos ){
		this.fechaCierreTambos = fechaCierreTambos;
	}

	// GET Fecha cierre RRHH
	public java.util.Date getFechaCierreRRHH() {
		return this.fechaCierreRRHH;
	}

	// SET Fecha cierre RRHH
	public void setFechaCierreRRHH(java.util.Date fechaCierreRRHH ){
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

} // END CLASS ----------------------------------------------------------------------------------------------------------