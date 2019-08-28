package com.massoftware.service.logistica;

import com.massoftware.service.EntityId;

public class Cargas extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Transporte
	private String nombreTransporte;

	// Nº carga
	private Integer numero;

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

	// GET Transporte
	public String getNombreTransporte() {
		return this.nombreTransporte;
	}

	// SET Transporte
	public void setNombreTransporte(String nombreTransporte ){
		this.nombreTransporte = (nombreTransporte == null || nombreTransporte.trim().length() == 0) ? null : nombreTransporte.trim();
	}

	// GET Nº carga
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº carga
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

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNombreTransporte() != null && this.getNumero() != null){
			return this.getNombreTransporte() + " - " +  this.getNumero();
		} else if(this.getNombreTransporte() != null && this.getNumero() == null){
			return this.getNombreTransporte();
		} else if(this.getNombreTransporte() == null && this.getNumero() != null){
			return this.getNumero().toString();
		} else {
			return super.toString();
		}
	}
		
	public Cargas clone() {
		
		Cargas other = (Cargas) super.clone();
		
		other.setId(this.getId());
		other.setNombreTransporte(this.getNombreTransporte());
		other.setNumero(this.getNumero());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------