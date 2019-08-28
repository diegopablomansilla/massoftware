package com.massoftware.service.logistica;

import com.massoftware.service.EntityId;

public class Transportes extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº transporte
	private Integer numero;

	// CUIT
	private Long cuit;

	// Nombre
	private String nombre;

	// Domicilio
	private String domicilio;

	// CP
	private String codigoPostal;

	// Ciudad
	private String nombreCiudad;

	// Provincia
	private String nombreProvincia;

	// Pais
	private String nombrePais;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº transporte
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº transporte
	public void setNumero(Integer numero ){
		this.numero = numero;
	}

	// GET CUIT
	public Long getCuit() {
		return this.cuit;
	}

	// SET CUIT
	public void setCuit(Long cuit ){
		this.cuit = cuit;
	}

	// GET Nombre
	public String getNombre() {
		return this.nombre;
	}

	// SET Nombre
	public void setNombre(String nombre ){
		this.nombre = (nombre == null || nombre.trim().length() == 0) ? null : nombre.trim();
	}

	// GET Domicilio
	public String getDomicilio() {
		return this.domicilio;
	}

	// SET Domicilio
	public void setDomicilio(String domicilio ){
		this.domicilio = (domicilio == null || domicilio.trim().length() == 0) ? null : domicilio.trim();
	}

	// GET CP
	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	// SET CP
	public void setCodigoPostal(String codigoPostal ){
		this.codigoPostal = (codigoPostal == null || codigoPostal.trim().length() == 0) ? null : codigoPostal.trim();
	}

	// GET Ciudad
	public String getNombreCiudad() {
		return this.nombreCiudad;
	}

	// SET Ciudad
	public void setNombreCiudad(String nombreCiudad ){
		this.nombreCiudad = (nombreCiudad == null || nombreCiudad.trim().length() == 0) ? null : nombreCiudad.trim();
	}

	// GET Provincia
	public String getNombreProvincia() {
		return this.nombreProvincia;
	}

	// SET Provincia
	public void setNombreProvincia(String nombreProvincia ){
		this.nombreProvincia = (nombreProvincia == null || nombreProvincia.trim().length() == 0) ? null : nombreProvincia.trim();
	}

	// GET Pais
	public String getNombrePais() {
		return this.nombrePais;
	}

	// SET Pais
	public void setNombrePais(String nombrePais ){
		this.nombrePais = (nombrePais == null || nombrePais.trim().length() == 0) ? null : nombrePais.trim();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNumero() != null && this.getCuit() != null){
			return this.getNumero() + " - " +  this.getCuit();
		} else if(this.getNumero() != null && this.getCuit() == null){
			return this.getNumero().toString();
		} else if(this.getNumero() == null && this.getCuit() != null){
			return this.getCuit().toString();
		} else {
			return super.toString();
		}
	}
		
	public Transportes clone() {
		
		Transportes other = (Transportes) super.clone();
		
		other.setId(this.getId());
		other.setNumero(this.getNumero());
		other.setCuit(this.getCuit());
		other.setNombre(this.getNombre());
		other.setDomicilio(this.getDomicilio());
		other.setCodigoPostal(this.getCodigoPostal());
		other.setNombreCiudad(this.getNombreCiudad());
		other.setNombreProvincia(this.getNombreProvincia());
		other.setNombrePais(this.getNombrePais());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------