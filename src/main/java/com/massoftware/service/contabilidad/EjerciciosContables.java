package com.massoftware.service.contabilidad;

import com.massoftware.service.EntityId;
import java.time.LocalDate;

public class EjerciciosContables extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº ejercicio
	private Integer numero;

	// Apertura
	private LocalDate apertura;

	// Cierre
	private LocalDate cierre;

	// Cerrado
	private Boolean cerrado;

	// Cerrado módulos
	private Boolean cerradoModulos;

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
	public LocalDate getApertura() {
		return this.apertura;
	}

	// SET Apertura
	public void setApertura(LocalDate apertura ){
		this.apertura = apertura;
	}

	// GET Cierre
	public LocalDate getCierre() {
		return this.cierre;
	}

	// SET Cierre
	public void setCierre(LocalDate cierre ){
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
		
	public EjerciciosContables clone() {
		
		EjerciciosContables other = (EjerciciosContables) super.clone();
		
		other.setId(this.getId());
		other.setNumero(this.getNumero());
		other.setApertura(this.getApertura());
		other.setCierre(this.getCierre());
		other.setCerrado(this.getCerrado());
		other.setCerradoModulos(this.getCerradoModulos());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------