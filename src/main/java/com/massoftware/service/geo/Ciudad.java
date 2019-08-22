package com.massoftware.service.geo;

import com.massoftware.service.EntityId;
import com.massoftware.service.geo.Provincia;

public class Ciudad extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº ciudad
	private Integer numero;

	// Nombre
	private String nombre;

	// Departamento
	private String departamento;

	// Nº provincia AFIP
	private Integer numeroAFIP;

	// Provincia
	private Provincia provincia;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº ciudad
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº ciudad
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

	// GET Departamento
	public String getDepartamento() {
		return this.departamento;
	}

	// SET Departamento
	public void setDepartamento(String departamento ){
		this.departamento = (departamento == null || departamento.trim().length() == 0) ? null : departamento.trim();
	}

	// GET Nº provincia AFIP
	public Integer getNumeroAFIP() {
		return this.numeroAFIP;
	}

	// SET Nº provincia AFIP
	public void setNumeroAFIP(Integer numeroAFIP ){
		this.numeroAFIP = numeroAFIP;
	}

	// GET Provincia
	public Provincia getProvincia() {
		return this.provincia;
	}

	// SET Provincia
	public void setProvincia(Provincia provincia ){
		this.provincia = provincia;
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