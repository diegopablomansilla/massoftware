package com.massoftware.service.geo;

import com.massoftware.service.EntityId;

public class Paises extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº país
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

	// GET Nº país
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº país
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
		if(this.getNumero() != null && this.getAbreviatura() != null){
			return this.getNumero() + " - " +  this.getAbreviatura();
		} else if(this.getNumero() != null && this.getAbreviatura() == null){
			return this.getNumero().toString();
		} else if(this.getNumero() == null && this.getAbreviatura() != null){
			return this.getAbreviatura();
		} else {
			return super.toString();
		}
	}
		
	public Paises clone() {
		
		Paises other = new Paises();
		
		other.setId(this.getId());
		other.setNumero(this.getNumero());
		other.setAbreviatura(this.getAbreviatura());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------