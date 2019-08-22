package com.massoftware.service.fondos;

import com.massoftware.service.EntityId;
import com.massoftware.service.fondos.CuentaFondo;

public class Chequera extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº chequera
	private Integer numero;

	// Nombre
	private String nombre;

	// Cuenta fondo
	private CuentaFondo cuentaFondo;

	// Primer número
	private Integer primerNumero;

	// Último número
	private Integer ultimoNumero;

	// Próximo número
	private Integer proximoNumero;

	// Obsoleto
	private Boolean bloqueado;

	// Impresión diferida
	private Boolean impresionDiferida;

	// Formato
	private String formato;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº chequera
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº chequera
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

	// GET Cuenta fondo
	public CuentaFondo getCuentaFondo() {
		return this.cuentaFondo;
	}

	// SET Cuenta fondo
	public void setCuentaFondo(CuentaFondo cuentaFondo ){
		this.cuentaFondo = cuentaFondo;
	}

	// GET Primer número
	public Integer getPrimerNumero() {
		return this.primerNumero;
	}

	// SET Primer número
	public void setPrimerNumero(Integer primerNumero ){
		this.primerNumero = primerNumero;
	}

	// GET Último número
	public Integer getUltimoNumero() {
		return this.ultimoNumero;
	}

	// SET Último número
	public void setUltimoNumero(Integer ultimoNumero ){
		this.ultimoNumero = ultimoNumero;
	}

	// GET Próximo número
	public Integer getProximoNumero() {
		return this.proximoNumero;
	}

	// SET Próximo número
	public void setProximoNumero(Integer proximoNumero ){
		this.proximoNumero = proximoNumero;
	}

	// GET Obsoleto
	public Boolean getBloqueado() {
		return this.bloqueado;
	}

	// SET Obsoleto
	public void setBloqueado(Boolean bloqueado ){
		this.bloqueado = (bloqueado == null) ? false : bloqueado;
	}

	// GET Impresión diferida
	public Boolean getImpresionDiferida() {
		return this.impresionDiferida;
	}

	// SET Impresión diferida
	public void setImpresionDiferida(Boolean impresionDiferida ){
		this.impresionDiferida = (impresionDiferida == null) ? false : impresionDiferida;
	}

	// GET Formato
	public String getFormato() {
		return this.formato;
	}

	// SET Formato
	public void setFormato(String formato ){
		this.formato = (formato == null || formato.trim().length() == 0) ? null : formato.trim();
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
		
	public Chequera clone() {
		
		Chequera other = (Chequera) super.clone();
		
		other.setId(this.getId());
		other.setNumero(this.getNumero());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		if (this.getCuentaFondo() != null) {
			other.setCuentaFondo(this.getCuentaFondo().clone());
		}
		other.setPrimerNumero(this.getPrimerNumero());
		other.setUltimoNumero(this.getUltimoNumero());
		other.setProximoNumero(this.getProximoNumero());
		other.setBloqueado(this.getBloqueado());
		other.setImpresionDiferida(this.getImpresionDiferida());
		other.setFormato(this.getFormato());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------