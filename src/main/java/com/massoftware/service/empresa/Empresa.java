package com.massoftware.service.empresa;

import com.massoftware.service.EntityId;
import com.massoftware.service.contabilidad.EjercicioContable;
import java.time.LocalDate;

public class Empresa extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Ejercicio
	private EjercicioContable ejercicioContable;

	// Fecha cierre ventas
	private LocalDate fechaCierreVentas;

	// Fecha cierre stock
	private LocalDate fechaCierreStock;

	// Fecha cierre fondo
	private LocalDate fechaCierreFondo;

	// Fecha cierre compras
	private LocalDate fechaCierreCompras;

	// Fecha cierre contabilidad
	private LocalDate fechaCierreContabilidad;

	// Fecha cierre garantia y devoluciones
	private LocalDate fechaCierreGarantiaDevoluciones;

	// Fecha cierre tambos
	private LocalDate fechaCierreTambos;

	// Fecha cierre RRHH
	private LocalDate fechaCierreRRHH;

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
	public LocalDate getFechaCierreVentas() {
		return this.fechaCierreVentas;
	}

	// SET Fecha cierre ventas
	public void setFechaCierreVentas(LocalDate fechaCierreVentas ){
		this.fechaCierreVentas = fechaCierreVentas;
	}

	// GET Fecha cierre stock
	public LocalDate getFechaCierreStock() {
		return this.fechaCierreStock;
	}

	// SET Fecha cierre stock
	public void setFechaCierreStock(LocalDate fechaCierreStock ){
		this.fechaCierreStock = fechaCierreStock;
	}

	// GET Fecha cierre fondo
	public LocalDate getFechaCierreFondo() {
		return this.fechaCierreFondo;
	}

	// SET Fecha cierre fondo
	public void setFechaCierreFondo(LocalDate fechaCierreFondo ){
		this.fechaCierreFondo = fechaCierreFondo;
	}

	// GET Fecha cierre compras
	public LocalDate getFechaCierreCompras() {
		return this.fechaCierreCompras;
	}

	// SET Fecha cierre compras
	public void setFechaCierreCompras(LocalDate fechaCierreCompras ){
		this.fechaCierreCompras = fechaCierreCompras;
	}

	// GET Fecha cierre contabilidad
	public LocalDate getFechaCierreContabilidad() {
		return this.fechaCierreContabilidad;
	}

	// SET Fecha cierre contabilidad
	public void setFechaCierreContabilidad(LocalDate fechaCierreContabilidad ){
		this.fechaCierreContabilidad = fechaCierreContabilidad;
	}

	// GET Fecha cierre garantia y devoluciones
	public LocalDate getFechaCierreGarantiaDevoluciones() {
		return this.fechaCierreGarantiaDevoluciones;
	}

	// SET Fecha cierre garantia y devoluciones
	public void setFechaCierreGarantiaDevoluciones(LocalDate fechaCierreGarantiaDevoluciones ){
		this.fechaCierreGarantiaDevoluciones = fechaCierreGarantiaDevoluciones;
	}

	// GET Fecha cierre tambos
	public LocalDate getFechaCierreTambos() {
		return this.fechaCierreTambos;
	}

	// SET Fecha cierre tambos
	public void setFechaCierreTambos(LocalDate fechaCierreTambos ){
		this.fechaCierreTambos = fechaCierreTambos;
	}

	// GET Fecha cierre RRHH
	public LocalDate getFechaCierreRRHH() {
		return this.fechaCierreRRHH;
	}

	// SET Fecha cierre RRHH
	public void setFechaCierreRRHH(LocalDate fechaCierreRRHH ){
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
		
		Empresa other = new Empresa();
		
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