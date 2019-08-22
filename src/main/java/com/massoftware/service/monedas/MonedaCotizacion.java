package com.massoftware.service.monedas;

import com.massoftware.service.EntityId;
import com.massoftware.service.monedas.Moneda;
import com.massoftware.service.seguridad.Usuario;

public class MonedaCotizacion extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Fecha cotización
	private java.sql.Timestamp cotizacionFecha;

	// Compra
	private java.math.BigDecimal compra;

	// Venta
	private java.math.BigDecimal venta;

	// Fecha cotización (Auditoria)
	private java.sql.Timestamp cotizacionFechaAuditoria;

	// Moneda
	private Moneda moneda;

	// Usuario
	private Usuario usuario;

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

	// GET Fecha cotización (Auditoria)
	public java.sql.Timestamp getCotizacionFechaAuditoria() {
		return this.cotizacionFechaAuditoria;
	}

	// SET Fecha cotización (Auditoria)
	public void setCotizacionFechaAuditoria(java.sql.Timestamp cotizacionFechaAuditoria ){
		this.cotizacionFechaAuditoria = cotizacionFechaAuditoria;
	}

	// GET Moneda
	public Moneda getMoneda() {
		return this.moneda;
	}

	// SET Moneda
	public void setMoneda(Moneda moneda ){
		this.moneda = moneda;
	}

	// GET Usuario
	public Usuario getUsuario() {
		return this.usuario;
	}

	// SET Usuario
	public void setUsuario(Usuario usuario ){
		this.usuario = usuario;
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

} // END CLASS ----------------------------------------------------------------------------------------------------------