package com.massoftware.service.geo;

import com.massoftware.service.EntityId;

public class CodigosPostales extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Pais
	private String nombrePais;

	// Provincia
	private String nombreProvincia;

	// Ciudad
	private String nombreCiudad;

	// Código
	private String codigo;

	// Secuencia
	private Integer numero;

	// Número calle
	private String numeroCalle;

	// Calle
	private String nombreCalle;

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

	// GET Ciudad
	public String getNombreCiudad() {
		return this.nombreCiudad;
	}

	// SET Ciudad
	public void setNombreCiudad(String nombreCiudad ){
		this.nombreCiudad = (nombreCiudad == null || nombreCiudad.trim().length() == 0) ? null : nombreCiudad.trim();
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

	// GET Número calle
	public String getNumeroCalle() {
		return this.numeroCalle;
	}

	// SET Número calle
	public void setNumeroCalle(String numeroCalle ){
		this.numeroCalle = (numeroCalle == null || numeroCalle.trim().length() == 0) ? null : numeroCalle.trim();
	}

	// GET Calle
	public String getNombreCalle() {
		return this.nombreCalle;
	}

	// SET Calle
	public void setNombreCalle(String nombreCalle ){
		this.nombreCalle = (nombreCalle == null || nombreCalle.trim().length() == 0) ? null : nombreCalle.trim();
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
		
	public CodigosPostales clone() {
		
		CodigosPostales other = new CodigosPostales();
		
		other.setId(this.getId());
		other.setNombrePais(this.getNombrePais());
		other.setNombreProvincia(this.getNombreProvincia());
		other.setNombreCiudad(this.getNombreCiudad());
		other.setCodigo(this.getCodigo());
		other.setNumero(this.getNumero());
		other.setNumeroCalle(this.getNumeroCalle());
		other.setNombreCalle(this.getNombreCalle());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------