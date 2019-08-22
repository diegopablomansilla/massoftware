package com.massoftware.service.contabilidad;

import com.massoftware.service.EntityId;
import com.massoftware.service.contabilidad.EjercicioContable;
import com.massoftware.service.contabilidad.MinutaContable;
import com.massoftware.service.empresa.Sucursal;
import com.massoftware.service.contabilidad.AsientoContableModulo;

public class AsientoContable extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº asiento
	private Integer numero;

	// Fecha
	private java.util.Date fecha;

	// Detalle
	private String detalle;

	// Ejercicio
	private EjercicioContable ejercicioContable;

	// Minuta contable
	private MinutaContable minutaContable;

	// Sucursal
	private Sucursal sucursal;

	// Módulo
	private AsientoContableModulo asientoContableModulo;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº asiento
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº asiento
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

	// GET Ejercicio
	public EjercicioContable getEjercicioContable() {
		return this.ejercicioContable;
	}

	// SET Ejercicio
	public void setEjercicioContable(EjercicioContable ejercicioContable ){
		this.ejercicioContable = ejercicioContable;
	}

	// GET Minuta contable
	public MinutaContable getMinutaContable() {
		return this.minutaContable;
	}

	// SET Minuta contable
	public void setMinutaContable(MinutaContable minutaContable ){
		this.minutaContable = minutaContable;
	}

	// GET Sucursal
	public Sucursal getSucursal() {
		return this.sucursal;
	}

	// SET Sucursal
	public void setSucursal(Sucursal sucursal ){
		this.sucursal = sucursal;
	}

	// GET Módulo
	public AsientoContableModulo getAsientoContableModulo() {
		return this.asientoContableModulo;
	}

	// SET Módulo
	public void setAsientoContableModulo(AsientoContableModulo asientoContableModulo ){
		this.asientoContableModulo = asientoContableModulo;
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

} // END CLASS ----------------------------------------------------------------------------------------------------------