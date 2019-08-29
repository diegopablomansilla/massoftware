package com.massoftware.service.contabilidad;

import com.massoftware.service.EntityId;
import java.time.LocalDate;

public class AsientosContables extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº ejercicio
	private Integer numeroEjercicio;

	// Nº asiento
	private Integer numero;

	// Fecha
	private LocalDate fecha;

	// Detalle
	private String detalle;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº ejercicio
	public Integer getNumeroEjercicio() {
		return this.numeroEjercicio;
	}

	// SET Nº ejercicio
	public void setNumeroEjercicio(Integer numeroEjercicio ){
		this.numeroEjercicio = numeroEjercicio;
	}

	// GET Nº asiento
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº asiento
	public void setNumero(Integer numero ){
		this.numero = numero;
	}

	// GET Fecha
	public LocalDate getFecha() {
		return this.fecha;
	}

	// SET Fecha
	public void setFecha(LocalDate fecha ){
		this.fecha = fecha;
	}

	// GET Detalle
	public String getDetalle() {
		return this.detalle;
	}

	// SET Detalle
	public void setDetalle(String detalle ){
		this.detalle = (detalle == null || detalle.trim().length() == 0) ? null : detalle.trim();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNumeroEjercicio() != null && this.getNumero() != null){
			return this.getNumeroEjercicio() + " - " +  this.getNumero();
		} else if(this.getNumeroEjercicio() != null && this.getNumero() == null){
			return this.getNumeroEjercicio().toString();
		} else if(this.getNumeroEjercicio() == null && this.getNumero() != null){
			return this.getNumero().toString();
		} else {
			return super.toString();
		}
	}
		
	public AsientosContables clone() {
		
		AsientosContables other = new AsientosContables();
		
		other.setId(this.getId());
		other.setNumeroEjercicio(this.getNumeroEjercicio());
		other.setNumero(this.getNumero());
		other.setFecha(this.getFecha());
		other.setDetalle(this.getDetalle());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------