package com.massoftware.service.geo;

import com.massoftware.service.EntityId;

public class Provincias extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Pais
	private String nombrePais;

	// Nº provincia
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

	// GET Pais
	public String getNombrePais() {
		return this.nombrePais;
	}

	// SET Pais
	public void setNombrePais(String nombrePais ){
		this.nombrePais = (nombrePais == null || nombrePais.trim().length() == 0) ? null : nombrePais.trim();
	}

	// GET Nº provincia
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº provincia
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
		if(this.getNombrePais() != null && this.getNumero() != null){
			return this.getNombrePais() + " - " +  this.getNumero();
		} else if(this.getNombrePais() != null && this.getNumero() == null){
			return this.getNombrePais();
		} else if(this.getNombrePais() == null && this.getNumero() != null){
			return this.getNumero().toString();
		} else {
			return super.toString();
		}
	}
		
	public Provincias clone() {
		
		Provincias other = (Provincias) super.clone();
		
		other.setId(this.getId());
		other.setNombrePais(this.getNombrePais());
		other.setNumero(this.getNumero());
		other.setAbreviatura(this.getAbreviatura());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------