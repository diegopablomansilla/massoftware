package com.massoftware.service.contabilidad;

import com.massoftware.service.EntityId;

public class EjercicioContable extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº ejercicio
	private Integer numero;

	// Apertura
	private java.time.LocalDate apertura;

	// Cierre
	private java.time.LocalDate cierre;

	// Cerrado
	private Boolean cerrado;

	// Cerrado módulos
	private Boolean cerradoModulos;

	// Coemntario
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

	// GET Nº ejercicio
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº ejercicio
	public void setNumero(Integer numero ){
		this.numero = numero;
	}

	// GET Apertura
	public java.time.LocalDate getApertura() {
		return this.apertura;
	}

	// SET Apertura
	public void setApertura(java.time.LocalDate apertura ){
		this.apertura = apertura;
	}

	// GET Cierre
	public java.time.LocalDate getCierre() {
		return this.cierre;
	}

	// SET Cierre
	public void setCierre(java.time.LocalDate cierre ){
		this.cierre = cierre;
	}

	// GET Cerrado
	public Boolean getCerrado() {
		return this.cerrado;
	}

	// SET Cerrado
	public void setCerrado(Boolean cerrado ){
		this.cerrado = (cerrado == null) ? false : cerrado;
	}

	// GET Cerrado módulos
	public Boolean getCerradoModulos() {
		return this.cerradoModulos;
	}

	// SET Cerrado módulos
	public void setCerradoModulos(Boolean cerradoModulos ){
		this.cerradoModulos = (cerradoModulos == null) ? false : cerradoModulos;
	}

	// GET Coemntario
	public String getComentario() {
		return this.comentario;
	}

	// SET Coemntario
	public void setComentario(String comentario ){
		this.comentario = (comentario == null || comentario.trim().length() == 0) ? null : comentario.trim();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNumero() != null && this.getApertura() != null){
			return this.getNumero() + " - " +  this.getApertura();
		} else if(this.getNumero() != null && this.getApertura() == null){
			return this.getNumero().toString();
		} else if(this.getNumero() == null && this.getApertura() != null){
			return this.getApertura().toString();
		} else {
			return super.toString();
		}
	}
		
	public EjercicioContable clone() {
		
		EjercicioContable other = (EjercicioContable) super.clone();
		
		other.setId(this.getId());
		other.setNumero(this.getNumero());
		other.setApertura(this.getApertura());
		other.setCierre(this.getCierre());
		other.setCerrado(this.getCerrado());
		other.setCerradoModulos(this.getCerradoModulos());
		other.setComentario(this.getComentario());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------