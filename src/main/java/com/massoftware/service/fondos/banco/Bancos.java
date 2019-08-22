package com.massoftware.service.fondos.banco;

import com.massoftware.service.EntityId;

public class Bancos extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº banco
	private Integer numero;

	// Nombre
	private String nombre;

	// CUIT
	private Long cuit;

	// Vigente
	private Boolean vigente;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº banco
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº banco
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

	// GET CUIT
	public Long getCuit() {
		return this.cuit;
	}

	// SET CUIT
	public void setCuit(Long cuit ){
		this.cuit = cuit;
	}

	// GET Vigente
	public Boolean getVigente() {
		return this.vigente;
	}

	// SET Vigente
	public void setVigente(Boolean vigente ){
		this.vigente = (vigente == null) ? false : vigente;
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

} // END CLASS ----------------------------------------------------------------------------------------------------------