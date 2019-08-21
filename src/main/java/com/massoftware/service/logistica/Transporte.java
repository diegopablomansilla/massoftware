package com.massoftware.service.logistica;

import com.massoftware.model.EntityId;
import com.massoftware.service.geo.CodigoPostal;

public class Transporte extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº transporte
	private Integer numero;

	// Nombre
	private String nombre;

	// CUIT
	private Long cuit;

	// Ingresos brutos
	private String ingresosBrutos;

	// Teléfono
	private String telefono;

	// Fax
	private String fax;

	// Código postal
	private CodigoPostal codigoPostal;

	// Domicilio
	private String domicilio;

	// Comentario
	private String comentario;

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

	// GET Ingresos brutos
	public String getIngresosBrutos() {
		return this.ingresosBrutos;
	}

	// SET Ingresos brutos
	public void setIngresosBrutos(String ingresosBrutos ){
		this.ingresosBrutos = (ingresosBrutos == null || ingresosBrutos.trim().length() == 0) ? null : ingresosBrutos.trim();
	}

	// GET Teléfono
	public String getTelefono() {
		return this.telefono;
	}

	// SET Teléfono
	public void setTelefono(String telefono ){
		this.telefono = (telefono == null || telefono.trim().length() == 0) ? null : telefono.trim();
	}

	// GET Fax
	public String getFax() {
		return this.fax;
	}

	// SET Fax
	public void setFax(String fax ){
		this.fax = (fax == null || fax.trim().length() == 0) ? null : fax.trim();
	}

	// GET Código postal
	public CodigoPostal getCodigoPostal() {
		return this.codigoPostal;
	}

	// SET Código postal
	public void setCodigoPostal(CodigoPostal codigoPostal ){
		this.codigoPostal = codigoPostal;
	}

	// GET Domicilio
	public String getDomicilio() {
		return this.domicilio;
	}

	// SET Domicilio
	public void setDomicilio(String domicilio ){
		this.domicilio = (domicilio == null || domicilio.trim().length() == 0) ? null : domicilio.trim();
	}

	// GET Comentario
	public String getComentario() {
		return this.comentario;
	}

	// SET Comentario
	public void setComentario(String comentario ){
		this.comentario = (comentario == null || comentario.trim().length() == 0) ? null : comentario.trim();
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