package com.massoftware.service.contabilidad;

import com.massoftware.model.EntityId;
import com.massoftware.service.contabilidad.EjercicioContable;
import com.massoftware.service.contabilidad.CuentaContableEstado;
import com.massoftware.service.contabilidad.CentroCostoContable;
import com.massoftware.service.contabilidad.PuntoEquilibrio;
import com.massoftware.service.contabilidad.CostoVenta;
import com.massoftware.service.seguridad.SeguridadPuerta;

public class CuentaContable extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Cuenta contable
	private String codigo;

	// Nombre
	private String nombre;

	// Ejercicio
	private EjercicioContable ejercicioContable;

	// Integra
	private String integra;

	// Cuenta de jerarquia
	private String cuentaJerarquia;

	// Imputable
	private Boolean imputable;

	// Ajusta por inflación
	private Boolean ajustaPorInflacion;

	// Estado
	private CuentaContableEstado cuentaContableEstado;

	// Cuenta con apropiación
	private Boolean cuentaConApropiacion;

	// Estado
	private CentroCostoContable centroCostoContable;

	// Cuenta agrupadora
	private String cuentaAgrupadora;

	// Porcentaje
	private java.math.BigDecimal porcentaje;

	// Punto de equilibrio
	private PuntoEquilibrio puntoEquilibrio;

	// Costo de venta
	private CostoVenta costoVenta;

	// Puerta
	private SeguridadPuerta seguridadPuerta;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Cuenta contable
	public String getCodigo() {
		return this.codigo;
	}

	// SET Cuenta contable
	public void setCodigo(String codigo ){
		this.codigo = (codigo == null || codigo.trim().length() == 0) ? null : codigo.trim();
	}

	// GET Nombre
	public String getNombre() {
		return this.nombre;
	}

	// SET Nombre
	public void setNombre(String nombre ){
		this.nombre = (nombre == null || nombre.trim().length() == 0) ? null : nombre.trim();
	}

	// GET Ejercicio
	public EjercicioContable getEjercicioContable() {
		return this.ejercicioContable;
	}

	// SET Ejercicio
	public void setEjercicioContable(EjercicioContable ejercicioContable ){
		this.ejercicioContable = ejercicioContable;
	}

	// GET Integra
	public String getIntegra() {
		return this.integra;
	}

	// SET Integra
	public void setIntegra(String integra ){
		this.integra = (integra == null || integra.trim().length() == 0) ? null : integra.trim();
	}

	// GET Cuenta de jerarquia
	public String getCuentaJerarquia() {
		return this.cuentaJerarquia;
	}

	// SET Cuenta de jerarquia
	public void setCuentaJerarquia(String cuentaJerarquia ){
		this.cuentaJerarquia = (cuentaJerarquia == null || cuentaJerarquia.trim().length() == 0) ? null : cuentaJerarquia.trim();
	}

	// GET Imputable
	public Boolean getImputable() {
		return this.imputable;
	}

	// SET Imputable
	public void setImputable(Boolean imputable ){
		this.imputable = (imputable == null) ? false : imputable;
	}

	// GET Ajusta por inflación
	public Boolean getAjustaPorInflacion() {
		return this.ajustaPorInflacion;
	}

	// SET Ajusta por inflación
	public void setAjustaPorInflacion(Boolean ajustaPorInflacion ){
		this.ajustaPorInflacion = (ajustaPorInflacion == null) ? false : ajustaPorInflacion;
	}

	// GET Estado
	public CuentaContableEstado getCuentaContableEstado() {
		return this.cuentaContableEstado;
	}

	// SET Estado
	public void setCuentaContableEstado(CuentaContableEstado cuentaContableEstado ){
		this.cuentaContableEstado = cuentaContableEstado;
	}

	// GET Cuenta con apropiación
	public Boolean getCuentaConApropiacion() {
		return this.cuentaConApropiacion;
	}

	// SET Cuenta con apropiación
	public void setCuentaConApropiacion(Boolean cuentaConApropiacion ){
		this.cuentaConApropiacion = (cuentaConApropiacion == null) ? false : cuentaConApropiacion;
	}

	// GET Estado
	public CentroCostoContable getCentroCostoContable() {
		return this.centroCostoContable;
	}

	// SET Estado
	public void setCentroCostoContable(CentroCostoContable centroCostoContable ){
		this.centroCostoContable = centroCostoContable;
	}

	// GET Cuenta agrupadora
	public String getCuentaAgrupadora() {
		return this.cuentaAgrupadora;
	}

	// SET Cuenta agrupadora
	public void setCuentaAgrupadora(String cuentaAgrupadora ){
		this.cuentaAgrupadora = (cuentaAgrupadora == null || cuentaAgrupadora.trim().length() == 0) ? null : cuentaAgrupadora.trim();
	}

	// GET Porcentaje
	public java.math.BigDecimal getPorcentaje() {
		return this.porcentaje;
	}

	// SET Porcentaje
	public void setPorcentaje(java.math.BigDecimal porcentaje ){
		this.porcentaje = porcentaje;
	}

	// GET Punto de equilibrio
	public PuntoEquilibrio getPuntoEquilibrio() {
		return this.puntoEquilibrio;
	}

	// SET Punto de equilibrio
	public void setPuntoEquilibrio(PuntoEquilibrio puntoEquilibrio ){
		this.puntoEquilibrio = puntoEquilibrio;
	}

	// GET Costo de venta
	public CostoVenta getCostoVenta() {
		return this.costoVenta;
	}

	// SET Costo de venta
	public void setCostoVenta(CostoVenta costoVenta ){
		this.costoVenta = costoVenta;
	}

	// GET Puerta
	public SeguridadPuerta getSeguridadPuerta() {
		return this.seguridadPuerta;
	}

	// SET Puerta
	public void setSeguridadPuerta(SeguridadPuerta seguridadPuerta ){
		this.seguridadPuerta = seguridadPuerta;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getCodigo() != null && this.getNombre() != null){
			return this.getCodigo() + " - " +  this.getNombre();
		} else if(this.getCodigo() != null && this.getNombre() == null){
			return this.getCodigo();
		} else if(this.getCodigo() == null && this.getNombre() != null){
			return this.getNombre();
		} else {
			return super.toString();
		}
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------