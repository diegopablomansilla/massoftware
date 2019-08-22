package com.massoftware.service.seguridad;

import com.massoftware.service.EntityId;
import com.massoftware.service.seguridad.SeguridadModulo;

public class SeguridadPuerta extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº puerta
	private Integer numero;

	// Nombre
	private String nombre;

	// I.D
	private String equate;

	// Módulo
	private SeguridadModulo seguridadModulo;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
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

	// GET I.D
	public String getEquate() {
		return this.equate;
	}

	// SET I.D
	public void setEquate(String equate ){
		this.equate = (equate == null || equate.trim().length() == 0) ? null : equate.trim();
	}

	// GET Módulo
	public SeguridadModulo getSeguridadModulo() {
		return this.seguridadModulo;
	}

	// SET Módulo
	public void setSeguridadModulo(SeguridadModulo seguridadModulo ){
		this.seguridadModulo = seguridadModulo;
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