package com.massoftware.service.contabilidad;

import com.massoftware.service.*;
import com.massoftware.service.contabilidad.EjercicioContable;
import com.massoftware.service.contabilidad.MinutaContable;
import com.massoftware.service.contabilidad.AsientoContableModulo;
import com.massoftware.service.empresa.Sucursal;

public class AsientosContablesFiltro extends GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Nº asiento (desde)
	private Integer numeroFrom;

	// Nº asiento (hasta)
	private Integer numeroTo;

	// Detalle
	private String detalle;

	// Fecha (desde)
	private java.util.Date fechaFrom;

	// Fecha (hasta)
	private java.util.Date fechaTo;

	// Ejercicio
	private EjercicioContable ejercicioContable;

	// Minuta contable
	private MinutaContable minutaContable;

	// Módulo
	private AsientoContableModulo asientoContableModulo;

	// Sucursal
	private Sucursal sucursal;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Nº asiento (desde)
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}

	// SET Nº asiento (desde)
	public void setNumeroFrom(Integer numeroFrom){
		this.numeroFrom = numeroFrom;
	}

	// GET Nº asiento (hasta)
	public Integer getNumeroTo() {
		return this.numeroTo;
	}

	// SET Nº asiento (hasta)
	public void setNumeroTo(Integer numeroTo){
		this.numeroTo = numeroTo;
	}

	// GET Detalle
	public String getDetalle() {
		return this.detalle;
	}

	// SET Detalle
	public void setDetalle(String detalle){
		this.detalle = (detalle == null || detalle.trim().length() == 0) ? null : detalle.trim();
	}

	// GET Fecha (desde)
	public java.util.Date getFechaFrom() {
		return this.fechaFrom;
	}

	// SET Fecha (desde)
	public void setFechaFrom(java.util.Date fechaFrom){
		this.fechaFrom = fechaFrom;
	}

	// GET Fecha (hasta)
	public java.util.Date getFechaTo() {
		return this.fechaTo;
	}

	// SET Fecha (hasta)
	public void setFechaTo(java.util.Date fechaTo){
		this.fechaTo = fechaTo;
	}

	// GET Ejercicio
	public EjercicioContable getEjercicioContable() {
		return this.ejercicioContable;
	}

	// SET Ejercicio
	public void setEjercicioContable(EjercicioContable ejercicioContable){
		this.ejercicioContable = ejercicioContable;
	}

	// GET Minuta contable
	public MinutaContable getMinutaContable() {
		return this.minutaContable;
	}

	// SET Minuta contable
	public void setMinutaContable(MinutaContable minutaContable){
		this.minutaContable = minutaContable;
	}

	// GET Módulo
	public AsientoContableModulo getAsientoContableModulo() {
		return this.asientoContableModulo;
	}

	// SET Módulo
	public void setAsientoContableModulo(AsientoContableModulo asientoContableModulo){
		this.asientoContableModulo = asientoContableModulo;
	}

	// GET Sucursal
	public Sucursal getSucursal() {
		return this.sucursal;
	}

	// SET Sucursal
	public void setSucursal(Sucursal sucursal){
		this.sucursal = sucursal;
	}
		
	public boolean equals(Object obj) {
		
		if (super.equals(obj) == false) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		AsientosContablesFiltro other = (AsientosContablesFiltro) obj;
		
		
		// -------------------------------------------------------------------
		
		if (other.getNumeroFrom() == null && this.getNumeroFrom() != null) {
			return false;
		}
		
		if (other.getNumeroFrom() != null && this.getNumeroFrom() == null) {
			return false;
		}
		
		if (other.getNumeroFrom() != null && this.getNumeroFrom() != null) {
		
			if (other.getNumeroFrom().equals(this.getNumeroFrom()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getNumeroTo() == null && this.getNumeroTo() != null) {
			return false;
		}
		
		if (other.getNumeroTo() != null && this.getNumeroTo() == null) {
			return false;
		}
		
		if (other.getNumeroTo() != null && this.getNumeroTo() != null) {
		
			if (other.getNumeroTo().equals(this.getNumeroTo()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getDetalle() == null && this.getDetalle() != null) {
			return false;
		}
		
		if (other.getDetalle() != null && this.getDetalle() == null) {
			return false;
		}
		
		if (other.getDetalle() != null && this.getDetalle() != null) {
		
			if (other.getDetalle().equals(this.getDetalle()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getFechaFrom() == null && this.getFechaFrom() != null) {
			return false;
		}
		
		if (other.getFechaFrom() != null && this.getFechaFrom() == null) {
			return false;
		}
		
		if (other.getFechaFrom() != null && this.getFechaFrom() != null) {
		
			if (other.getFechaFrom().equals(this.getFechaFrom()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getFechaTo() == null && this.getFechaTo() != null) {
			return false;
		}
		
		if (other.getFechaTo() != null && this.getFechaTo() == null) {
			return false;
		}
		
		if (other.getFechaTo() != null && this.getFechaTo() != null) {
		
			if (other.getFechaTo().equals(this.getFechaTo()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getEjercicioContable() == null && this.getEjercicioContable() != null) {
			return false;
		}
		
		if (other.getEjercicioContable() != null && this.getEjercicioContable() == null) {
			return false;
		}
		
		if (other.getEjercicioContable() != null && this.getEjercicioContable() != null) {
		
			if (other.getEjercicioContable().equals(this.getEjercicioContable()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getMinutaContable() == null && this.getMinutaContable() != null) {
			return false;
		}
		
		if (other.getMinutaContable() != null && this.getMinutaContable() == null) {
			return false;
		}
		
		if (other.getMinutaContable() != null && this.getMinutaContable() != null) {
		
			if (other.getMinutaContable().equals(this.getMinutaContable()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getAsientoContableModulo() == null && this.getAsientoContableModulo() != null) {
			return false;
		}
		
		if (other.getAsientoContableModulo() != null && this.getAsientoContableModulo() == null) {
			return false;
		}
		
		if (other.getAsientoContableModulo() != null && this.getAsientoContableModulo() != null) {
		
			if (other.getAsientoContableModulo().equals(this.getAsientoContableModulo()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getSucursal() == null && this.getSucursal() != null) {
			return false;
		}
		
		if (other.getSucursal() != null && this.getSucursal() == null) {
			return false;
		}
		
		if (other.getSucursal() != null && this.getSucursal() != null) {
		
			if (other.getSucursal().equals(this.getSucursal()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		return true;
		
		// -------------------------------------------------------------------
	}
		
	public AsientosContablesFiltro clone() {
		
		AsientosContablesFiltro other = new AsientosContablesFiltro();
		
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		other.setUnlimited(this.getUnlimited());
		
		other.setNumeroFrom(this.getNumeroFrom());
		other.setNumeroTo(this.getNumeroTo());
		other.setDetalle(this.getDetalle());
		other.setFechaFrom(this.getFechaFrom());
		other.setFechaTo(this.getFechaTo());
		
		// -------------------------------------------------------------------
		
		if (this.getEjercicioContable() != null) {
			other.setEjercicioContable(this.getEjercicioContable().clone());
		}
		
		// -------------------------------------------------------------------
		
		if (this.getMinutaContable() != null) {
			other.setMinutaContable(this.getMinutaContable().clone());
		}
		
		// -------------------------------------------------------------------
		
		if (this.getAsientoContableModulo() != null) {
			other.setAsientoContableModulo(this.getAsientoContableModulo().clone());
		}
		
		// -------------------------------------------------------------------
		
		if (this.getSucursal() != null) {
			other.setSucursal(this.getSucursal().clone());
		}
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------