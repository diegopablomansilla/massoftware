package com.massoftware.service.monedas;

import com.massoftware.service.*;
import java.time.LocalDateTime;

public class MonedasCotizacionesFiltro extends GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Moneda
	private Monedas moneda;

	// Fecha cotización (desde)
	private LocalDateTime cotizacionFechaFrom;

	// Fecha cotización (hasta)
	private LocalDateTime cotizacionFechaTo;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Moneda
	public Monedas getMoneda() {
		return this.moneda;
	}

	// SET Moneda
	public void setMoneda(Monedas moneda){
		this.moneda = moneda;
	}

	// GET Fecha cotización (desde)
	public LocalDateTime getCotizacionFechaFrom() {
		return this.cotizacionFechaFrom;
	}

	// SET Fecha cotización (desde)
	public void setCotizacionFechaFrom(LocalDateTime cotizacionFechaFrom){
		this.cotizacionFechaFrom = cotizacionFechaFrom;
	}

	// GET Fecha cotización (hasta)
	public LocalDateTime getCotizacionFechaTo() {
		return this.cotizacionFechaTo;
	}

	// SET Fecha cotización (hasta)
	public void setCotizacionFechaTo(LocalDateTime cotizacionFechaTo){
		this.cotizacionFechaTo = cotizacionFechaTo;
	}
		
	public boolean equals(Object obj) {
		
		if (super.equals(obj) == false) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		MonedasCotizacionesFiltro other = (MonedasCotizacionesFiltro) obj;
		
		
		// -------------------------------------------------------------------
		
		if (other.getMoneda() == null && this.getMoneda() != null) {
			return false;
		}
		
		if (other.getMoneda() != null && this.getMoneda() == null) {
			return false;
		}
		
		if (other.getMoneda() != null && this.getMoneda() != null) {
		
			if (other.getMoneda().equals(this.getMoneda()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getCotizacionFechaFrom() == null && this.getCotizacionFechaFrom() != null) {
			return false;
		}
		
		if (other.getCotizacionFechaFrom() != null && this.getCotizacionFechaFrom() == null) {
			return false;
		}
		
		if (other.getCotizacionFechaFrom() != null && this.getCotizacionFechaFrom() != null) {
		
			if (other.getCotizacionFechaFrom().equals(this.getCotizacionFechaFrom()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getCotizacionFechaTo() == null && this.getCotizacionFechaTo() != null) {
			return false;
		}
		
		if (other.getCotizacionFechaTo() != null && this.getCotizacionFechaTo() == null) {
			return false;
		}
		
		if (other.getCotizacionFechaTo() != null && this.getCotizacionFechaTo() != null) {
		
			if (other.getCotizacionFechaTo().equals(this.getCotizacionFechaTo()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		return true;
		
		// -------------------------------------------------------------------
	}
		
	public MonedasCotizacionesFiltro clone() {
		
		MonedasCotizacionesFiltro other = new MonedasCotizacionesFiltro();
		
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		other.setUnlimited(this.getUnlimited());
		
		
		// -------------------------------------------------------------------
		
		if (this.getMoneda() != null) {
			other.setMoneda(this.getMoneda().clone());
		}
		other.setCotizacionFechaFrom(this.getCotizacionFechaFrom());
		other.setCotizacionFechaTo(this.getCotizacionFechaTo());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------