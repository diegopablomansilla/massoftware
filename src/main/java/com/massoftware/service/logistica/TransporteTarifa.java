package com.massoftware.service.logistica;

import com.massoftware.service.EntityId;
import com.massoftware.service.logistica.Carga;
import com.massoftware.service.geo.Ciudad;

public class TransporteTarifa extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº opción
	private Integer numero;

	// Carga
	private Carga carga;

	// Ciudad
	private Ciudad ciudad;

	// Precio flete
	private java.math.BigDecimal precioFlete;

	// Precio unidad facturación
	private java.math.BigDecimal precioUnidadFacturacion;

	// Precio unidad stock
	private java.math.BigDecimal precioUnidadStock;

	// Precio bultos
	private java.math.BigDecimal precioBultos;

	// Importe mínimo por entrega
	private java.math.BigDecimal importeMinimoEntrega;

	// Importe mínimo por carga
	private java.math.BigDecimal importeMinimoCarga;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº opción
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº opción
	public void setNumero(Integer numero ){
		this.numero = numero;
	}

	// GET Carga
	public Carga getCarga() {
		return this.carga;
	}

	// SET Carga
	public void setCarga(Carga carga ){
		this.carga = carga;
	}

	// GET Ciudad
	public Ciudad getCiudad() {
		return this.ciudad;
	}

	// SET Ciudad
	public void setCiudad(Ciudad ciudad ){
		this.ciudad = ciudad;
	}

	// GET Precio flete
	public java.math.BigDecimal getPrecioFlete() {
		return this.precioFlete;
	}

	// SET Precio flete
	public void setPrecioFlete(java.math.BigDecimal precioFlete ){
		this.precioFlete = precioFlete;
	}

	// GET Precio unidad facturación
	public java.math.BigDecimal getPrecioUnidadFacturacion() {
		return this.precioUnidadFacturacion;
	}

	// SET Precio unidad facturación
	public void setPrecioUnidadFacturacion(java.math.BigDecimal precioUnidadFacturacion ){
		this.precioUnidadFacturacion = precioUnidadFacturacion;
	}

	// GET Precio unidad stock
	public java.math.BigDecimal getPrecioUnidadStock() {
		return this.precioUnidadStock;
	}

	// SET Precio unidad stock
	public void setPrecioUnidadStock(java.math.BigDecimal precioUnidadStock ){
		this.precioUnidadStock = precioUnidadStock;
	}

	// GET Precio bultos
	public java.math.BigDecimal getPrecioBultos() {
		return this.precioBultos;
	}

	// SET Precio bultos
	public void setPrecioBultos(java.math.BigDecimal precioBultos ){
		this.precioBultos = precioBultos;
	}

	// GET Importe mínimo por entrega
	public java.math.BigDecimal getImporteMinimoEntrega() {
		return this.importeMinimoEntrega;
	}

	// SET Importe mínimo por entrega
	public void setImporteMinimoEntrega(java.math.BigDecimal importeMinimoEntrega ){
		this.importeMinimoEntrega = importeMinimoEntrega;
	}

	// GET Importe mínimo por carga
	public java.math.BigDecimal getImporteMinimoCarga() {
		return this.importeMinimoCarga;
	}

	// SET Importe mínimo por carga
	public void setImporteMinimoCarga(java.math.BigDecimal importeMinimoCarga ){
		this.importeMinimoCarga = importeMinimoCarga;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNumero() != null && this.getCarga() != null){
			return this.getNumero() + " - " +  this.getCarga();
		} else if(this.getNumero() != null && this.getCarga() == null){
			return this.getNumero().toString();
		} else if(this.getNumero() == null && this.getCarga() != null){
			return this.getCarga().toString();
		} else {
			return super.toString();
		}
	}
		
	public TransporteTarifa clone() {
		
		TransporteTarifa other = (TransporteTarifa) super.clone();
		
		other.setId(this.getId());
		other.setNumero(this.getNumero());
		
		// -------------------------------------------------------------------
		
		if (this.getCarga() != null) {
			other.setCarga(this.getCarga().clone());
		}
		
		// -------------------------------------------------------------------
		
		if (this.getCiudad() != null) {
			other.setCiudad(this.getCiudad().clone());
		}
		other.setPrecioFlete(this.getPrecioFlete());
		other.setPrecioUnidadFacturacion(this.getPrecioUnidadFacturacion());
		other.setPrecioUnidadStock(this.getPrecioUnidadStock());
		other.setPrecioBultos(this.getPrecioBultos());
		other.setImporteMinimoEntrega(this.getImporteMinimoEntrega());
		other.setImporteMinimoCarga(this.getImporteMinimoCarga());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------