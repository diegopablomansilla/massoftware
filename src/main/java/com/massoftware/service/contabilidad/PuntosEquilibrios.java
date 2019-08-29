package com.massoftware.service.contabilidad;

import com.massoftware.service.EntityId;

public class PuntosEquilibrios extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Ejercicio
	private Integer nombreEjercicioContable;

	// Nº cc
	private Integer numero;

	// Nombre
	private String nombre;

	// Tipo punto equilibrio
	private String nombreTipoPuntoEquilibrio;

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

	// GET Nombre
	public String getNombre() {
		return this.nombre;
	}

	// SET Nombre
	public void setNombre(String nombre ){
		this.nombre = (nombre == null || nombre.trim().length() == 0) ? null : nombre.trim();
	}

	// GET Tipo punto equilibrio
	public String getNombreTipoPuntoEquilibrio() {
		return this.nombreTipoPuntoEquilibrio;
	}

	// SET Tipo punto equilibrio
	public void setNombreTipoPuntoEquilibrio(String nombreTipoPuntoEquilibrio ){
		this.nombreTipoPuntoEquilibrio = (nombreTipoPuntoEquilibrio == null || nombreTipoPuntoEquilibrio.trim().length() == 0) ? null : nombreTipoPuntoEquilibrio.trim();
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
		
	public PuntosEquilibrios clone() {
		
		PuntosEquilibrios other = new PuntosEquilibrios();
		
		other.setId(this.getId());
		other.setNombreEjercicioContable(this.getNombreEjercicioContable());
		other.setNumero(this.getNumero());
		other.setNombre(this.getNombre());
		other.setNombreTipoPuntoEquilibrio(this.getNombreTipoPuntoEquilibrio());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------