package com.massoftware.service.monedas;

import com.massoftware.service.EntityId;
import com.massoftware.service.monedas.Moneda;

public class MonedasCotizaciones extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Fecha cotización
	private java.sql.Timestamp cotizacionFecha;

	// Compra
	private java.math.BigDecimal compra;

	// Venta
	private java.math.BigDecimal venta;

	// Moneda
	private Moneda moneda;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Fecha cotización
	public java.sql.Timestamp getCotizacionFecha() {
		return this.cotizacionFecha;
	}

	// SET Fecha cotización
	public void setCotizacionFecha(java.sql.Timestamp cotizacionFecha ){
		this.cotizacionFecha = cotizacionFecha;
	}

	// GET Compra
	public java.math.BigDecimal getCompra() {
		return this.compra;
	}

	// SET Compra
	public void setCompra(java.math.BigDecimal compra ){
		this.compra = compra;
	}

	// GET Venta
	public java.math.BigDecimal getVenta() {
		return this.venta;
	}

	// SET Venta
	public void setVenta(java.math.BigDecimal venta ){
		this.venta = venta;
	}

	// GET Moneda
	public Moneda getMoneda() {
		return this.moneda;
	}

	// SET Moneda
	public void setMoneda(Moneda moneda ){
		this.moneda = moneda;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getCotizacionFecha() != null && this.getCompra() != null){
			return this.getCotizacionFecha() + " - " +  this.getCompra();
		} else if(this.getCotizacionFecha() != null && this.getCompra() == null){
			return this.getCotizacionFecha().toString();
		} else if(this.getCotizacionFecha() == null && this.getCompra() != null){
			return this.getCompra().toString();
		} else {
			return super.toString();
		}
	}
		
	public MonedasCotizaciones clone() {
		
		MonedasCotizaciones other = (MonedasCotizaciones) super.clone();
		
		other.setId(this.getId());
		other.setCotizacionFecha(this.getCotizacionFecha());
		other.setCompra(this.getCompra());
		other.setVenta(this.getVenta());
		
		// -------------------------------------------------------------------
		
		if (this.getMoneda() != null) {
			other.setMoneda(this.getMoneda().clone());
		}
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------