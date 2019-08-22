package com.massoftware.service.fondos;

import com.massoftware.service.EntityId;
import com.massoftware.service.seguridad.SeguridadPuerta;

public class Caja extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº caja
	private Integer numero;

	// Nombre
	private String nombre;

	// Puerta
	private SeguridadPuerta seguridadPuerta;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº caja
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº caja
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

	// GET Puerta
	public SeguridadPuerta getSeguridadPuerta() {
		return this.seguridadPuerta;
	}

	// SET Puerta
	public void setSeguridadPuerta(SeguridadPuerta seguridadPuerta ){
		this.seguridadPuerta = seguridadPuerta;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNumero() != null && this.getNombre() != null){
			return this.getNumero() + " - " +  this.getNombre();
		} else if(this.getNumero() != null && this.getNombre() == null){
			return this.getNumero().toString();
		} else if(this.getNumero() == null && this.getNombre() != null){
			return this.getNombre();
		} else {
			return super.toString();
		}
	}
		
	public Caja clone() {
		
		Caja other = (Caja) super.clone();
		
		other.setId(this.getId());
		other.setNumero(this.getNumero());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		if (this.getSeguridadPuerta() != null) {
			other.setSeguridadPuerta(this.getSeguridadPuerta().clone());
		}
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------