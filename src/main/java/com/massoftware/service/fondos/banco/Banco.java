package com.massoftware.service.fondos.banco;

import com.massoftware.service.EntityId;

public class Banco extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº banco
	private Integer numero;

	// Nombre
	private String nombre;

	// CUIT
	private Long cuit;

	// Vigente
	private Boolean vigente;

	// Hoja
	private Integer hoja;

	// Primera fila
	private Integer primeraFila;

	// Última fila
	private Integer ultimaFila;

	// Fecha
	private String fecha;

	// Descripción
	private String descripcion;

	// Referencia 1
	private String referencia1;

	// Importe
	private String importe;

	// Referencia 2
	private String referencia2;

	// Saldo
	private String saldo;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº banco
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº banco
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

	// GET Vigente
	public Boolean getVigente() {
		return this.vigente;
	}

	// SET Vigente
	public void setVigente(Boolean vigente ){
		this.vigente = (vigente == null) ? false : vigente;
	}

	// GET Hoja
	public Integer getHoja() {
		return this.hoja;
	}

	// SET Hoja
	public void setHoja(Integer hoja ){
		this.hoja = hoja;
	}

	// GET Primera fila
	public Integer getPrimeraFila() {
		return this.primeraFila;
	}

	// SET Primera fila
	public void setPrimeraFila(Integer primeraFila ){
		this.primeraFila = primeraFila;
	}

	// GET Última fila
	public Integer getUltimaFila() {
		return this.ultimaFila;
	}

	// SET Última fila
	public void setUltimaFila(Integer ultimaFila ){
		this.ultimaFila = ultimaFila;
	}

	// GET Fecha
	public String getFecha() {
		return this.fecha;
	}

	// SET Fecha
	public void setFecha(String fecha ){
		this.fecha = (fecha == null || fecha.trim().length() == 0) ? null : fecha.trim();
	}

	// GET Descripción
	public String getDescripcion() {
		return this.descripcion;
	}

	// SET Descripción
	public void setDescripcion(String descripcion ){
		this.descripcion = (descripcion == null || descripcion.trim().length() == 0) ? null : descripcion.trim();
	}

	// GET Referencia 1
	public String getReferencia1() {
		return this.referencia1;
	}

	// SET Referencia 1
	public void setReferencia1(String referencia1 ){
		this.referencia1 = (referencia1 == null || referencia1.trim().length() == 0) ? null : referencia1.trim();
	}

	// GET Importe
	public String getImporte() {
		return this.importe;
	}

	// SET Importe
	public void setImporte(String importe ){
		this.importe = (importe == null || importe.trim().length() == 0) ? null : importe.trim();
	}

	// GET Referencia 2
	public String getReferencia2() {
		return this.referencia2;
	}

	// SET Referencia 2
	public void setReferencia2(String referencia2 ){
		this.referencia2 = (referencia2 == null || referencia2.trim().length() == 0) ? null : referencia2.trim();
	}

	// GET Saldo
	public String getSaldo() {
		return this.saldo;
	}

	// SET Saldo
	public void setSaldo(String saldo ){
		this.saldo = (saldo == null || saldo.trim().length() == 0) ? null : saldo.trim();
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
		
	public Banco clone() {
		
		Banco other = new Banco();
		
		other.setId(this.getId());
		other.setNumero(this.getNumero());
		other.setNombre(this.getNombre());
		other.setCuit(this.getCuit());
		other.setVigente(this.getVigente());
		other.setHoja(this.getHoja());
		other.setPrimeraFila(this.getPrimeraFila());
		other.setUltimaFila(this.getUltimaFila());
		other.setFecha(this.getFecha());
		other.setDescripcion(this.getDescripcion());
		other.setReferencia1(this.getReferencia1());
		other.setImporte(this.getImporte());
		other.setReferencia2(this.getReferencia2());
		other.setSaldo(this.getSaldo());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------