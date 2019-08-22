package com.massoftware.service.contabilidad;

import com.massoftware.service.EntityId;
import com.massoftware.service.contabilidad.AsientoContable;
import com.massoftware.service.contabilidad.CuentaContable;

public class AsientoContableItem extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº item
	private Integer numero;

	// Fecha
	private java.util.Date fecha;

	// Detalle
	private String detalle;

	// Asiento contable
	private AsientoContable asientoContable;

	// Cuenta contable
	private CuentaContable cuentaContable;

	// Debe
	private java.math.BigDecimal debe;

	// Haber
	private java.math.BigDecimal haber;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº item
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº item
	public void setNumero(Integer numero ){
		this.numero = numero;
	}

	// GET Fecha
	public java.util.Date getFecha() {
		return this.fecha;
	}

	// SET Fecha
	public void setFecha(java.util.Date fecha ){
		this.fecha = fecha;
	}

	// GET Detalle
	public String getDetalle() {
		return this.detalle;
	}

	// SET Detalle
	public void setDetalle(String detalle ){
		this.detalle = (detalle == null || detalle.trim().length() == 0) ? null : detalle.trim();
	}

	// GET Asiento contable
	public AsientoContable getAsientoContable() {
		return this.asientoContable;
	}

	// SET Asiento contable
	public void setAsientoContable(AsientoContable asientoContable ){
		this.asientoContable = asientoContable;
	}

	// GET Cuenta contable
	public CuentaContable getCuentaContable() {
		return this.cuentaContable;
	}

	// SET Cuenta contable
	public void setCuentaContable(CuentaContable cuentaContable ){
		this.cuentaContable = cuentaContable;
	}

	// GET Debe
	public java.math.BigDecimal getDebe() {
		return this.debe;
	}

	// SET Debe
	public void setDebe(java.math.BigDecimal debe ){
		this.debe = debe;
	}

	// GET Haber
	public java.math.BigDecimal getHaber() {
		return this.haber;
	}

	// SET Haber
	public void setHaber(java.math.BigDecimal haber ){
		this.haber = haber;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNumero() != null && this.getFecha() != null){
			return this.getNumero() + " - " +  this.getFecha();
		} else if(this.getNumero() != null && this.getFecha() == null){
			return this.getNumero().toString();
		} else if(this.getNumero() == null && this.getFecha() != null){
			return this.getFecha().toString();
		} else {
			return super.toString();
		}
	}
		
	public AsientoContableItem clone() {
		
		AsientoContableItem other = (AsientoContableItem) super.clone();
		
		other.setId(this.getId());
		other.setNumero(this.getNumero());
		other.setFecha(this.getFecha());
		other.setDetalle(this.getDetalle());
		
		// -------------------------------------------------------------------
		
		if (this.getAsientoContable() != null) {
			other.setAsientoContable(this.getAsientoContable().clone());
		}
		
		// -------------------------------------------------------------------
		
		if (this.getCuentaContable() != null) {
			other.setCuentaContable(this.getCuentaContable().clone());
		}
		other.setDebe(this.getDebe());
		other.setHaber(this.getHaber());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------