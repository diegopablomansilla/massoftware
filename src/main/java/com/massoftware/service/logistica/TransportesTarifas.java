package com.massoftware.service.logistica;

import com.massoftware.service.EntityId;
import java.math.BigDecimal;

public class TransportesTarifas extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Transporte
	private String nombreTransporte;

	// Nº Carga
	private Integer numeroCarga;

	// Carga
	private String nombreCarga;

	// Nº opción
	private Integer numero;

	// Ciudad
	private String nombreCiudad;

	// Precio flete
	private BigDecimal precioFlete;

	// Precio unidad facturación
	private BigDecimal precioUnidadFacturacion;

	// Precio unidad stock
	private BigDecimal precioUnidadStock;

	// Precio bultos
	private BigDecimal precioBultos;

	// Importe mínimo por entrega
	private BigDecimal importeMinimoEntrega;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Transporte
	public String getNombreTransporte() {
		return this.nombreTransporte;
	}

	// SET Transporte
	public void setNombreTransporte(String nombreTransporte ){
		this.nombreTransporte = (nombreTransporte == null || nombreTransporte.trim().length() == 0) ? null : nombreTransporte.trim();
	}

	// GET Nº Carga
	public Integer getNumeroCarga() {
		return this.numeroCarga;
	}

	// SET Nº Carga
	public void setNumeroCarga(Integer numeroCarga ){
		this.numeroCarga = numeroCarga;
	}

	// GET Carga
	public String getNombreCarga() {
		return this.nombreCarga;
	}

	// SET Carga
	public void setNombreCarga(String nombreCarga ){
		this.nombreCarga = (nombreCarga == null || nombreCarga.trim().length() == 0) ? null : nombreCarga.trim();
	}

	// GET Nº opción
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº opción
	public void setNumero(Integer numero ){
		this.numero = numero;
	}

	// GET Ciudad
	public String getNombreCiudad() {
		return this.nombreCiudad;
	}

	// SET Ciudad
	public void setNombreCiudad(String nombreCiudad ){
		this.nombreCiudad = (nombreCiudad == null || nombreCiudad.trim().length() == 0) ? null : nombreCiudad.trim();
	}

	// GET Precio flete
	public BigDecimal getPrecioFlete() {
		return this.precioFlete;
	}

	// SET Precio flete
	public void setPrecioFlete(BigDecimal precioFlete ){
		this.precioFlete = precioFlete;
	}

	// GET Precio unidad facturación
	public BigDecimal getPrecioUnidadFacturacion() {
		return this.precioUnidadFacturacion;
	}

	// SET Precio unidad facturación
	public void setPrecioUnidadFacturacion(BigDecimal precioUnidadFacturacion ){
		this.precioUnidadFacturacion = precioUnidadFacturacion;
	}

	// GET Precio unidad stock
	public BigDecimal getPrecioUnidadStock() {
		return this.precioUnidadStock;
	}

	// SET Precio unidad stock
	public void setPrecioUnidadStock(BigDecimal precioUnidadStock ){
		this.precioUnidadStock = precioUnidadStock;
	}

	// GET Precio bultos
	public BigDecimal getPrecioBultos() {
		return this.precioBultos;
	}

	// SET Precio bultos
	public void setPrecioBultos(BigDecimal precioBultos ){
		this.precioBultos = precioBultos;
	}

	// GET Importe mínimo por entrega
	public BigDecimal getImporteMinimoEntrega() {
		return this.importeMinimoEntrega;
	}

	// SET Importe mínimo por entrega
	public void setImporteMinimoEntrega(BigDecimal importeMinimoEntrega ){
		this.importeMinimoEntrega = importeMinimoEntrega;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNombreTransporte() != null && this.getNumeroCarga() != null){
			return this.getNombreTransporte() + " - " +  this.getNumeroCarga();
		} else if(this.getNombreTransporte() != null && this.getNumeroCarga() == null){
			return this.getNombreTransporte();
		} else if(this.getNombreTransporte() == null && this.getNumeroCarga() != null){
			return this.getNumeroCarga().toString();
		} else {
			return super.toString();
		}
	}
		
	public TransportesTarifas clone() {
		
		TransportesTarifas other = new TransportesTarifas();
		
		other.setId(this.getId());
		other.setNombreTransporte(this.getNombreTransporte());
		other.setNumeroCarga(this.getNumeroCarga());
		other.setNombreCarga(this.getNombreCarga());
		other.setNumero(this.getNumero());
		other.setNombreCiudad(this.getNombreCiudad());
		other.setPrecioFlete(this.getPrecioFlete());
		other.setPrecioUnidadFacturacion(this.getPrecioUnidadFacturacion());
		other.setPrecioUnidadStock(this.getPrecioUnidadStock());
		other.setPrecioBultos(this.getPrecioBultos());
		other.setImporteMinimoEntrega(this.getImporteMinimoEntrega());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------