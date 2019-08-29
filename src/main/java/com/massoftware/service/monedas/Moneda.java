package com.massoftware.service.monedas;

import com.massoftware.service.EntityId;
import java.math.BigDecimal;
import com.massoftware.service.afip.MonedaAFIP;

public class Moneda extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº moneda
	private Integer numero;

	// Nombre
	private String nombre;

	// Abreviatura
	private String abreviatura;

	// Cotización
	private BigDecimal cotizacion;

	// Fecha cotización
	private java.sql.Timestamp cotizacionFecha;

	// Control de actualizacion
	private Boolean controlActualizacion;

	// Moneda AFIP
	private MonedaAFIP monedaAFIP;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº moneda
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº moneda
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

	// GET Cotización
	public BigDecimal getCotizacion() {
		return this.cotizacion;
	}

	// SET Cotización
	public void setCotizacion(BigDecimal cotizacion ){
		this.cotizacion = cotizacion;
	}

	// GET Fecha cotización
	public java.sql.Timestamp getCotizacionFecha() {
		return this.cotizacionFecha;
	}

	// SET Fecha cotización
	public void setCotizacionFecha(java.sql.Timestamp cotizacionFecha ){
		this.cotizacionFecha = cotizacionFecha;
	}

	// GET Control de actualizacion
	public Boolean getControlActualizacion() {
		return this.controlActualizacion;
	}

	// SET Control de actualizacion
	public void setControlActualizacion(Boolean controlActualizacion ){
		this.controlActualizacion = (controlActualizacion == null) ? false : controlActualizacion;
	}

	// GET Moneda AFIP
	public MonedaAFIP getMonedaAFIP() {
		return this.monedaAFIP;
	}

	// SET Moneda AFIP
	public void setMonedaAFIP(MonedaAFIP monedaAFIP ){
		this.monedaAFIP = monedaAFIP;
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
		
	public Moneda clone() {
		
		Moneda other = new Moneda();
		
		other.setId(this.getId());
		other.setNumero(this.getNumero());
		other.setNombre(this.getNombre());
		other.setAbreviatura(this.getAbreviatura());
		other.setCotizacion(this.getCotizacion());
		other.setCotizacionFecha(this.getCotizacionFecha());
		other.setControlActualizacion(this.getControlActualizacion());
		
		// -------------------------------------------------------------------
		
		if (this.getMonedaAFIP() != null) {
			other.setMonedaAFIP(this.getMonedaAFIP().clone());
		}
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------