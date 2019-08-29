package com.massoftware.service.seguridad;

import com.massoftware.service.EntityId;

public class SeguridadPuertas extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nombre módulo
	private String nombreModulo;

	// Nº puerta
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

	// GET Nombre módulo
	public String getNombreModulo() {
		return this.nombreModulo;
	}

	// SET Nombre módulo
	public void setNombreModulo(String nombreModulo ){
		this.nombreModulo = (nombreModulo == null || nombreModulo.trim().length() == 0) ? null : nombreModulo.trim();
	}

	// GET Nº puerta
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº puerta
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
		if(this.getNombreModulo() != null && this.getNumero() != null){
			return this.getNombreModulo() + " - " +  this.getNumero();
		} else if(this.getNombreModulo() != null && this.getNumero() == null){
			return this.getNombreModulo();
		} else if(this.getNombreModulo() == null && this.getNumero() != null){
			return this.getNumero().toString();
		} else {
			return super.toString();
		}
	}
		
	public SeguridadPuertas clone() {
		
		SeguridadPuertas other = new SeguridadPuertas();
		
		other.setId(this.getId());
		other.setNombreModulo(this.getNombreModulo());
		other.setNumero(this.getNumero());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------