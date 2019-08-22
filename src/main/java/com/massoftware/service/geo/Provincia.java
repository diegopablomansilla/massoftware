package com.massoftware.service.geo;

import com.massoftware.service.EntityId;
import com.massoftware.service.geo.Pais;

public class Provincia extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº provincia
	private Integer numero;

	// Nombre
	private String nombre;

	// Abreviatura
	private String abreviatura;

	// Nº provincia AFIP
	private Integer numeroAFIP;

	// Nº provincia ingresos brutos
	private Integer numeroIngresosBrutos;

	// Nº provincia RENATEA
	private Integer numeroRENATEA;

	// País
	private Pais pais;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº provincia
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº provincia
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

	// GET Abreviatura
	public String getAbreviatura() {
		return this.abreviatura;
	}

	// SET Abreviatura
	public void setAbreviatura(String abreviatura ){
		this.abreviatura = (abreviatura == null || abreviatura.trim().length() == 0) ? null : abreviatura.trim();
	}

	// GET Nº provincia AFIP
	public Integer getNumeroAFIP() {
		return this.numeroAFIP;
	}

	// SET Nº provincia AFIP
	public void setNumeroAFIP(Integer numeroAFIP ){
		this.numeroAFIP = numeroAFIP;
	}

	// GET Nº provincia ingresos brutos
	public Integer getNumeroIngresosBrutos() {
		return this.numeroIngresosBrutos;
	}

	// SET Nº provincia ingresos brutos
	public void setNumeroIngresosBrutos(Integer numeroIngresosBrutos ){
		this.numeroIngresosBrutos = numeroIngresosBrutos;
	}

	// GET Nº provincia RENATEA
	public Integer getNumeroRENATEA() {
		return this.numeroRENATEA;
	}

	// SET Nº provincia RENATEA
	public void setNumeroRENATEA(Integer numeroRENATEA ){
		this.numeroRENATEA = numeroRENATEA;
	}

	// GET País
	public Pais getPais() {
		return this.pais;
	}

	// SET País
	public void setPais(Pais pais ){
		this.pais = pais;
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