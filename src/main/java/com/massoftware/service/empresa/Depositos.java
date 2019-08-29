package com.massoftware.service.empresa;

import com.massoftware.service.EntityId;

public class Depositos extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº depósito
	private Integer numero;

	// Abreviatura
	private String abreviatura;

	// Nombre
	private String nombre;

	// Nombre sucursal
	private String nombreSucursal;

	// Nombre módulo
	private String nombreModulo;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº depósito
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº depósito
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

	// GET Nombre sucursal
	public String getNombreSucursal() {
		return this.nombreSucursal;
	}

	// SET Nombre sucursal
	public void setNombreSucursal(String nombreSucursal ){
		this.nombreSucursal = (nombreSucursal == null || nombreSucursal.trim().length() == 0) ? null : nombreSucursal.trim();
	}

	// GET Nombre módulo
	public String getNombreModulo() {
		return this.nombreModulo;
	}

	// SET Nombre módulo
	public void setNombreModulo(String nombreModulo ){
		this.nombreModulo = (nombreModulo == null || nombreModulo.trim().length() == 0) ? null : nombreModulo.trim();
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
		
	public Depositos clone() {
		
		Depositos other = new Depositos();
		
		other.setId(this.getId());
		other.setNumero(this.getNumero());
		other.setAbreviatura(this.getAbreviatura());
		other.setNombre(this.getNombre());
		other.setNombreSucursal(this.getNombreSucursal());
		other.setNombreModulo(this.getNombreModulo());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------