package com.massoftware.service.contabilidad;

import com.massoftware.service.EntityId;

public class EjercicioContable extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº ejercicio
	private Integer numero;

	// Apertura
	private java.util.Date apertura;

	// Cierre
	private java.util.Date cierre;

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
	public java.util.Date getApertura() {
		return this.apertura;
	}

	// SET Apertura
	public void setApertura(java.util.Date apertura ){
		this.apertura = apertura;
	}

	// GET Cierre
	public java.util.Date getCierre() {
		return this.cierre;
	}

	// SET Cierre
	public void setCierre(java.util.Date cierre ){
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

} // END CLASS ----------------------------------------------------------------------------------------------------------