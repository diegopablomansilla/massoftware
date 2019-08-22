package com.massoftware.service.geo;

import com.massoftware.service.EntityId;
import com.massoftware.service.geo.Ciudad;

public class CodigoPostal extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Código
	private String codigo;

	// Secuencia
	private Integer numero;

	// Calle
	private String nombreCalle;

	// Número calle
	private String numeroCalle;

	// Ciudad
	private Ciudad ciudad;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Código
	public String getCodigo() {
		return this.codigo;
	}

	// SET Código
	public void setCodigo(String codigo ){
		this.codigo = (codigo == null || codigo.trim().length() == 0) ? null : codigo.trim();
	}

	// GET Secuencia
	public Integer getNumero() {
		return this.numero;
	}

	// SET Secuencia
	public void setNumero(Integer numero ){
		this.numero = numero;
	}

	// GET Calle
	public String getNombreCalle() {
		return this.nombreCalle;
	}

	// SET Calle
	public void setNombreCalle(String nombreCalle ){
		this.nombreCalle = (nombreCalle == null || nombreCalle.trim().length() == 0) ? null : nombreCalle.trim();
	}

	// GET Número calle
	public String getNumeroCalle() {
		return this.numeroCalle;
	}

	// SET Número calle
	public void setNumeroCalle(String numeroCalle ){
		this.numeroCalle = (numeroCalle == null || numeroCalle.trim().length() == 0) ? null : numeroCalle.trim();
	}

	// GET Ciudad
	public Ciudad getCiudad() {
		return this.ciudad;
	}

	// SET Ciudad
	public void setCiudad(Ciudad ciudad ){
		this.ciudad = ciudad;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getCodigo() != null && this.getNumero() != null){
			return this.getCodigo() + " - " +  this.getNumero();
		} else if(this.getCodigo() != null && this.getNumero() == null){
			return this.getCodigo();
		} else if(this.getCodigo() == null && this.getNumero() != null){
			return this.getNumero().toString();
		} else {
			return super.toString();
		}
	}
		
	public CodigoPostal clone() {
		
		CodigoPostal other = (CodigoPostal) super.clone();
		
		other.setId(this.getId());
		other.setCodigo(this.getCodigo());
		other.setNumero(this.getNumero());
		other.setNombreCalle(this.getNombreCalle());
		other.setNumeroCalle(this.getNumeroCalle());
		
		// -------------------------------------------------------------------
		
		if (this.getCiudad() != null) {
			other.setCiudad(this.getCiudad().clone());
		}
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------