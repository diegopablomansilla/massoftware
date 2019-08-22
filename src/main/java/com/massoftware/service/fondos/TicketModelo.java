package com.massoftware.service.fondos;

import com.massoftware.service.EntityId;
import com.massoftware.service.fondos.Ticket;

public class TicketModelo extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº modelo
	private Integer numero;

	// Nombre
	private String nombre;

	// ticket
	private Ticket ticket;

	// Prueba lectura
	private String pruebaLectura;

	// activo
	private Boolean activo;

	// Longitud lectura
	private Integer longitudLectura;

	// Posición
	private Integer identificacionPosicion;

	// Identificación
	private Integer identificacion;

	// Posición
	private Integer importePosicion;

	// Longitud
	private Integer longitud;

	// Cantidad decimales
	private Integer cantidadDecimales;

	// Número posición
	private Integer numeroPosicion;

	// Número longitud
	private Integer numeroLongitud;

	// Prefijo identificación importación
	private String prefijoIdentificacion;

	// Posición prefijo
	private Integer posicionPrefijo;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº modelo
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº modelo
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

	// GET ticket
	public Ticket getTicket() {
		return this.ticket;
	}

	// SET ticket
	public void setTicket(Ticket ticket ){
		this.ticket = ticket;
	}

	// GET Prueba lectura
	public String getPruebaLectura() {
		return this.pruebaLectura;
	}

	// SET Prueba lectura
	public void setPruebaLectura(String pruebaLectura ){
		this.pruebaLectura = (pruebaLectura == null || pruebaLectura.trim().length() == 0) ? null : pruebaLectura.trim();
	}

	// GET activo
	public Boolean getActivo() {
		return this.activo;
	}

	// SET activo
	public void setActivo(Boolean activo ){
		this.activo = (activo == null) ? false : activo;
	}

	// GET Longitud lectura
	public Integer getLongitudLectura() {
		return this.longitudLectura;
	}

	// SET Longitud lectura
	public void setLongitudLectura(Integer longitudLectura ){
		this.longitudLectura = longitudLectura;
	}

	// GET Posición
	public Integer getIdentificacionPosicion() {
		return this.identificacionPosicion;
	}

	// SET Posición
	public void setIdentificacionPosicion(Integer identificacionPosicion ){
		this.identificacionPosicion = identificacionPosicion;
	}

	// GET Identificación
	public Integer getIdentificacion() {
		return this.identificacion;
	}

	// SET Identificación
	public void setIdentificacion(Integer identificacion ){
		this.identificacion = identificacion;
	}

	// GET Posición
	public Integer getImportePosicion() {
		return this.importePosicion;
	}

	// SET Posición
	public void setImportePosicion(Integer importePosicion ){
		this.importePosicion = importePosicion;
	}

	// GET Longitud
	public Integer getLongitud() {
		return this.longitud;
	}

	// SET Longitud
	public void setLongitud(Integer longitud ){
		this.longitud = longitud;
	}

	// GET Cantidad decimales
	public Integer getCantidadDecimales() {
		return this.cantidadDecimales;
	}

	// SET Cantidad decimales
	public void setCantidadDecimales(Integer cantidadDecimales ){
		this.cantidadDecimales = cantidadDecimales;
	}

	// GET Número posición
	public Integer getNumeroPosicion() {
		return this.numeroPosicion;
	}

	// SET Número posición
	public void setNumeroPosicion(Integer numeroPosicion ){
		this.numeroPosicion = numeroPosicion;
	}

	// GET Número longitud
	public Integer getNumeroLongitud() {
		return this.numeroLongitud;
	}

	// SET Número longitud
	public void setNumeroLongitud(Integer numeroLongitud ){
		this.numeroLongitud = numeroLongitud;
	}

	// GET Prefijo identificación importación
	public String getPrefijoIdentificacion() {
		return this.prefijoIdentificacion;
	}

	// SET Prefijo identificación importación
	public void setPrefijoIdentificacion(String prefijoIdentificacion ){
		this.prefijoIdentificacion = (prefijoIdentificacion == null || prefijoIdentificacion.trim().length() == 0) ? null : prefijoIdentificacion.trim();
	}

	// GET Posición prefijo
	public Integer getPosicionPrefijo() {
		return this.posicionPrefijo;
	}

	// SET Posición prefijo
	public void setPosicionPrefijo(Integer posicionPrefijo ){
		this.posicionPrefijo = posicionPrefijo;
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

} // END CLASS ----------------------------------------------------------------------------------------------------------