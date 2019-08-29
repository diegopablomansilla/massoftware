package com.massoftware.service.geo;

import com.massoftware.service.EntityId;

public class Ciudades extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Pais
	private String nombrePais;

	// Provincia
	private String nombreProvincia;

	// Nº ciudad
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

	// GET Pais
	public String getNombrePais() {
		return this.nombrePais;
	}

	// SET Pais
	public void setNombrePais(String nombrePais ){
		this.nombrePais = (nombrePais == null || nombrePais.trim().length() == 0) ? null : nombrePais.trim();
	}

	// GET Provincia
	public String getNombreProvincia() {
		return this.nombreProvincia;
	}

	// SET Provincia
	public void setNombreProvincia(String nombreProvincia ){
		this.nombreProvincia = (nombreProvincia == null || nombreProvincia.trim().length() == 0) ? null : nombreProvincia.trim();
	}

	// GET Nº ciudad
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº ciudad
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
		if(this.getNombrePais() != null && this.getNombreProvincia() != null){
			return this.getNombrePais() + " - " +  this.getNombreProvincia();
		} else if(this.getNombrePais() != null && this.getNombreProvincia() == null){
			return this.getNombrePais();
		} else if(this.getNombrePais() == null && this.getNombreProvincia() != null){
			return this.getNombreProvincia();
		} else {
			return super.toString();
		}
	}
		
	public Ciudades clone() {
		
		Ciudades other = new Ciudades();
		
		other.setId(this.getId());
		other.setNombrePais(this.getNombrePais());
		other.setNombreProvincia(this.getNombreProvincia());
		other.setNumero(this.getNumero());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------