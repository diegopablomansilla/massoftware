package com.massoftware.service.contabilidad;

import com.massoftware.service.EntityId;

public class CentrosCostosContables extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Ejercicio
	private Integer nombreEjercicioContable;

	// Nº cc
	private Integer numero;

	// Abreviatura
	private String abreviatura;

	// Nombre
	private String nombre;

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
	public Integer getNombreEjercicioContable() {
		return this.nombreEjercicioContable;
	}

	// SET Ejercicio
	public void setNombreEjercicioContable(Integer nombreEjercicioContable ){
		this.nombreEjercicioContable = nombreEjercicioContable;
	}

	// GET Nº cc
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº cc
	public void setNumero(Integer numero ){
		this.numero = numero;
	}

	// GET Abreviatura
	public String getAbreviatura() {
		return this.abreviatura;
	}

	// SET Abreviatura
	public void setAbreviatura(String abreviatura ){
		this.abreviatura = (abreviatura == null || abreviatura.trim().length() == 0) ? null : abreviatura.trim();
	}

	// GET Nombre
	public String getNombre() {
		return this.nombre;
	}

	// SET Nombre
	public void setNombre(String nombre ){
		this.nombre = (nombre == null || nombre.trim().length() == 0) ? null : nombre.trim();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNombreEjercicioContable() != null && this.getNumero() != null){
			return this.getNombreEjercicioContable() + " - " +  this.getNumero();
		} else if(this.getNombreEjercicioContable() != null && this.getNumero() == null){
			return this.getNombreEjercicioContable().toString();
		} else if(this.getNombreEjercicioContable() == null && this.getNumero() != null){
			return this.getNumero().toString();
		} else {
			return super.toString();
		}
	}
		
	public CentrosCostosContables clone() {
		
		CentrosCostosContables other = new CentrosCostosContables();
		
		other.setId(this.getId());
		other.setNombreEjercicioContable(this.getNombreEjercicioContable());
		other.setNumero(this.getNumero());
		other.setAbreviatura(this.getAbreviatura());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------